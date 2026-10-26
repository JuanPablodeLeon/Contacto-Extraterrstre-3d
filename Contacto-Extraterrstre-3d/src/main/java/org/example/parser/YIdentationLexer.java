package org.example.parser;

import antlr4.com.antlr4.com.YLenguajeLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class YIdentationLexer extends YLenguajeLexer {

    public static final int TAB_WIDTH = 4;

    private final Deque<Integer> indentStack = new ArrayDeque<>();
    private final Queue<Token> pending = new ArrayDeque<>();
    private final List<String> indentationErrors = new ArrayList<>();

    private Token lookahead;
    private int openedBrackets = 0;
    private int lastSignificantType = Token.INVALID_TYPE;

    public YIdentationLexer(CharStream input) {
        super(input);
        indentStack.push(0);
    }

    public List<String> getIndentationErrors() {
        return indentationErrors;
    }

    @Override
    public Token nextToken() {
        Token token = pending.isEmpty() ? processNext() : pending.poll();
        if (token != null) {
            lastSignificantType = token.getType();
        }
        return token;
    }

    private Token processNext() {
        Token token = readRaw();

        while (true) {
            int type = token.getType();

            if (type == Token.EOF) {
                return processEof(token);
            }

            if (type == LPAREN || type == LCORCH || type == LLLAVE) {
                openedBrackets++;
                return token;
            }

            if (type == RPAREN || type == RCORCH || type == RLLAVE) {
                if (openedBrackets > 0) {
                    openedBrackets--;
                }
                return token;
            }

            if (type == NEWLINE) {
                if (openedBrackets > 0) {
                    token = readRaw();
                    continue;
                }
                return processNewline(token);
            }

            if (type == TAB) {
                token = readRaw();
                continue;
            }

            return token;
        }
    }

    private Token processNewline(Token newline) {
        int indent = 0;
        Token ahead = readRaw();

        while (true) {
            if (ahead.getType() == NEWLINE) {
                ahead = readRaw();
                continue;
            }

            if (ahead.getType() == TAB) {
                indent = calculateIndentation(ahead.getText());
                Token next = readRaw();
                if (next.getType() == NEWLINE) {
                    indent = 0;
                    ahead = readRaw();
                    continue;
                }
                ahead = next;
                break;
            }

            indent = 0;
            break;
        }

        pending.offer(cleanNewline(newline));

        if (ahead.getType() == Token.EOF) {
            while (indentStack.peek() > 0) {
                indentStack.pop();
                pending.offer(synthetic(DEDENT, ahead));
            }
            pending.offer(ahead);
            return pending.poll();
        }

        Token current = lookahead = ahead;
        int currentIndent = indentStack.peek();

        if (indent > currentIndent) {
            indentStack.push(indent);
            pending.offer(synthetic(INDENT, current));
            if (indent % TAB_WIDTH != 0) {
                warn(current, "indentacion de " + indent
                        + " espacios no es multiplo de " + TAB_WIDTH + ".");
            }
        } else if (indent < currentIndent) {
            while (indentStack.peek() > indent) {
                indentStack.pop();
                pending.offer(synthetic(DEDENT, current));
            }
            if (indentStack.peek() != indent) {
                indentationErrors.add("linea " + Math.max(1, current.getLine())
                        + ": indentacion inconsistente (" + indent
                        + " espacios, se esperaba " + indentStack.peek() + ").");
                warn(current, "indentacion inconsistente (" + indent
                        + " espacios, se esperaba " + indentStack.peek() + ").");
            }
        }

        return pending.poll();
    }

    private Token processEof(Token eof) {
        if (lastSignificantType != Token.INVALID_TYPE
                && lastSignificantType != NEWLINE
                && lastSignificantType != INDENT
                && lastSignificantType != DEDENT) {
            pending.offer(syntheticNewline(eof));
        }

        while (indentStack.peek() > 0) {
            indentStack.pop();
            pending.offer(synthetic(DEDENT, eof));
        }

        pending.offer(eof);
        return pending.poll();
    }

    private Token readRaw() {
        if (lookahead != null) {
            Token token = lookahead;
            lookahead = null;
            return token;
        }

        Token token;
        do {
            token = super.nextToken();
        } while (token.getChannel() == Token.HIDDEN_CHANNEL);
        return token;
    }

    private int calculateIndentation(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '\t') {
                count += TAB_WIDTH;
            } else if (c == ' ') {
                count += 1;
            }
        }
        return count;
    }

    private CommonToken cleanNewline(Token reference) {
        CommonToken newline = new CommonToken(NEWLINE, "\n");
        newline.setLine(reference.getLine());
        newline.setCharPositionInLine(0);
        newline.setChannel(Token.DEFAULT_CHANNEL);
        return newline;
    }

    private CommonToken syntheticNewline(Token reference) {
        CommonToken newline = new CommonToken(NEWLINE, "\n");
        newline.setLine(reference.getLine());
        newline.setCharPositionInLine(0);
        newline.setChannel(Token.DEFAULT_CHANNEL);
        return newline;
    }

    private CommonToken synthetic(int type, Token reference) {
        String text = switch (type) {
            case INDENT -> "<INDENT>";
            case DEDENT -> "<DEDENT>";
            default -> "";
        };
        CommonToken token = new CommonToken(type, text);
        token.setLine(reference.getLine());
        token.setCharPositionInLine(reference.getCharPositionInLine());
        token.setChannel(Token.DEFAULT_CHANNEL);
        return token;
    }

    private void warn(Token reference, String message) {
        String text = "[YIdentationLexer] linea " + Math.max(1, reference.getLine())
                + ": " + message;
        indentationErrors.add(text);
        System.err.println(text);
    }
}
