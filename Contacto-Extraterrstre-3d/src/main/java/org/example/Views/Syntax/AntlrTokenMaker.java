package org.example.Views.Syntax;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Vocabulary;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMaker;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMap;
import org.fife.ui.rsyntaxtextarea.TokenTypes;

import javax.swing.text.Segment;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * TokenMaker de RSyntaxTextArea que usa un lexer generado por ANTLR para
 * clasificar los tokens de cada linea.
 *
 * <p>RSyntaxTextArea pide el resaltado linea por linea, mientras que un lexer
 * de ANTLR trabaja sobre un flujo completo. Por eso esta clase:</p>
 * <ol>
 *   <li>conserva el estado de los comentarios de bloque entre lineas,</li>
 *   <li>enmascara los comentarios antes de pasar la linea al lexer (algunos
 *       gramaticas los descartan con {@code -> skip}),</li>
 *   <li>traduce los tipos de token de ANTLR a {@link TokenTypes}, y</li>
 *   <li>rellena con {@link TokenTypes#WHITESPACE} los huecos que el lexer
 *       omite.</li>
 * </ol>
 */
public abstract class AntlrTokenMaker extends AbstractTokenMaker {

    private static final String LINE_COMMENT_START = "//";

    private final String blockCommentStart;
    private final String blockCommentEnd;

    private int[] rstaTypes;
    private Lexer lexer;
    private boolean blockCommentOpen;

    protected AntlrTokenMaker(String blockCommentStart, String blockCommentEnd) {
        this.blockCommentStart = blockCommentStart;
        this.blockCommentEnd = blockCommentEnd;
    }

    /** Crea una instancia nueva del lexer de ANTLR para el lenguaje. */
    protected abstract Lexer createLexer(CharStream input);

    /** Vocabulario del lexer generado por ANTLR. */
    protected abstract Vocabulary vocabulary();

    /** Construye el mapeo tipo ANTLR -&gt; tipo RSyntaxTextArea. */
    protected abstract int[] buildRstaTypes();

    @Override
    public TokenMap getWordsToHighlight() {
        TokenMap words = new TokenMap();
        Vocabulary vocabulary = vocabulary();
        int[] types = rstaTypes();
        for (int tokenType = 1; tokenType < types.length; tokenType++) {
            String literal = vocabulary.getLiteralName(tokenType);
            if (literal == null || literal.length() < 2) {
                continue;
            }
            int type = types[tokenType];
            if (type == TokenTypes.RESERVED_WORD
                    || type == TokenTypes.DATA_TYPE
                    || type == TokenTypes.LITERAL_BOOLEAN
                    || type == TokenTypes.ANNOTATION) {
                words.put(literal.substring(1, literal.length() - 1), type);
            }
        }
        return words;
    }

    @Override
    public Token getTokenList(Segment text, int initialTokenType, int startOffset) {
        resetTokenList();
        blockCommentOpen = false;

        char[] array = text.array;
        int lineStart = text.offset;
        int lineEnd = lineStart + text.count;
        int shift = -lineStart + startOffset;

        if (lineStart == lineEnd) {
            if (initialTokenType == TokenTypes.COMMENT_MULTILINE) {
                // Sin tokens: getLastTokenTypeOnLine conserva el estado.
                return firstToken;
            }
            addNullToken();
            return firstToken;
        }

        List<Span> comments = new ArrayList<>();
        int position = lineStart;

        // Continuacion de un comentario de bloque abierto en la linea anterior.
        if (initialTokenType == TokenTypes.COMMENT_MULTILINE) {
            int close = indexOf(array, position, lineEnd, blockCommentEnd);
            if (close < 0) {
                comments.add(new Span(0, text.count, TokenTypes.COMMENT_MULTILINE));
                blockCommentOpen = true;
                position = lineEnd;
            } else {
                int stop = close + blockCommentEnd.length();
                comments.add(new Span(0, stop - lineStart, TokenTypes.COMMENT_MULTILINE));
                position = stop;
            }
        }

        if (position < lineEnd) {
            scanComments(array, position, lineEnd, lineStart, text.count, comments);
        }

        char[] masked = new char[text.count];
        System.arraycopy(array, lineStart, masked, 0, text.count);
        for (Span comment : comments) {
            for (int i = comment.start; i < comment.end; i++) {
                masked[i] = ' ';
            }
        }

        List<Span> code = lex(masked);
        emit(array, lineStart, text.count, shift, code, comments);

        if (!blockCommentOpen) {
            addNullToken();
        }
        return firstToken;
    }

    /**
     * Conserva el estado cuando una linea vacia esta dentro de un comentario
     * de bloque, ya que en ese caso no se genera ningun token.
     */
    @Override
    public int getLastTokenTypeOnLine(Segment text, int initialTokenType) {
        if (text.count == 0 && initialTokenType == TokenTypes.COMMENT_MULTILINE) {
            return TokenTypes.COMMENT_MULTILINE;
        }
        Token token = getTokenList(text, initialTokenType, 0);
        if (token == null) {
            return TokenTypes.NULL;
        }
        while (token.getNextToken() != null) {
            token = token.getNextToken();
        }
        return token.getType();
    }

    @Override
    public String[] getLineCommentStartAndEnd(int languageIndex) {
        return new String[]{LINE_COMMENT_START, null};
    }

    /**
     * Busca comentarios fuera de cadenas y caracteres. Los comentarios se
     * enmascaran luego con espacios para que el lexer de ANTLR no los vea.
     */
    private void scanComments(char[] array, int from, int end, int lineStart,
                              int lineLength, List<Span> comments) {
        int i = from;
        while (i < end) {
            char c = array[i];
            if (c == '"' || c == '\'') {
                i = skipQuoted(array, i, end);
            } else if (startsWith(array, i, end, LINE_COMMENT_START)) {
                comments.add(new Span(i - lineStart, lineLength, TokenTypes.COMMENT_EOL));
                return;
            } else if (startsWith(array, i, end, blockCommentStart)) {
                int close = indexOf(array, i + blockCommentStart.length(), end, blockCommentEnd);
                if (close < 0) {
                    comments.add(new Span(i - lineStart, lineLength, TokenTypes.COMMENT_MULTILINE));
                    blockCommentOpen = true;
                    return;
                }
                int stop = close + blockCommentEnd.length();
                comments.add(new Span(i - lineStart, stop - lineStart, TokenTypes.COMMENT_MULTILINE));
                i = stop;
            } else {
                i++;
            }
        }
    }

    private List<Span> lex(char[] masked) {
        List<Span> spans = new ArrayList<>();
        Lexer lexer = lexer();
        lexer.setInputStream(CharStreams.fromString(new String(masked)));

        while (true) {
            org.antlr.v4.runtime.Token token = lexer.nextToken();
            if (token.getType() == org.antlr.v4.runtime.Token.EOF) {
                break;
            }
            if (token.getChannel() != org.antlr.v4.runtime.Token.DEFAULT_CHANNEL) {
                continue;
            }
            if (token.getStartIndex() < 0 || token.getStopIndex() < token.getStartIndex()) {
                continue;
            }
            int type = rstaTypes()[token.getType()];
            if (type == TokenTypes.WHITESPACE) {
                continue;
            }
            spans.add(new Span(token.getStartIndex(), token.getStopIndex() + 1, type));
        }
        return spans;
    }

    private void emit(char[] array, int lineStart, int lineLength, int shift,
                      List<Span> code, List<Span> comments) {
        List<Span> spans = new ArrayList<>(code.size() + comments.size());
        spans.addAll(code);
        spans.addAll(comments);
        spans.sort(Comparator.comparingInt(Span::start));

        int cursor = 0;
        for (Span span : spans) {
            if (span.start < cursor) {
                continue;
            }
            if (span.start > cursor) {
                add(array, lineStart + cursor, lineStart + span.start,
                        TokenTypes.WHITESPACE, shift);
            }
            add(array, lineStart + span.start, lineStart + span.end, span.type, shift);
            cursor = span.end;
        }
        if (cursor < lineLength) {
            add(array, lineStart + cursor, lineStart + lineLength,
                    TokenTypes.WHITESPACE, shift);
        }
    }

    private Lexer lexer() {
        if (lexer == null) {
            lexer = createLexer(CharStreams.fromString(""));
            lexer.removeErrorListeners();
        }
        return lexer;
    }

    private int[] rstaTypes() {
        if (rstaTypes == null) {
            rstaTypes = buildRstaTypes();
        }
        return rstaTypes;
    }

    private void add(char[] array, int start, int endExclusive, int type, int shift) {
        if (endExclusive <= start) {
            return;
        }
        addToken(array, start, endExclusive - 1, type, start + shift);
    }

    private static int skipQuoted(char[] array, int start, int end) {
        char quote = array[start];
        int i = start + 1;
        while (i < end) {
            char c = array[i];
            if (c == '\\' && i + 1 < end) {
                i += 2;
            } else if (c == quote) {
                return i + 1;
            } else {
                i++;
            }
        }
        return end;
    }

    private static boolean startsWith(char[] array, int start, int end, String text) {
        if (start + text.length() > end) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            if (array[start + i] != text.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static int indexOf(char[] array, int from, int end, String text) {
        int last = end - text.length();
        for (int i = from; i <= last; i++) {
            if (startsWith(array, i, end, text)) {
                return i;
            }
        }
        return -1;
    }

    private record Span(int start, int end, int type) {
    }
}
