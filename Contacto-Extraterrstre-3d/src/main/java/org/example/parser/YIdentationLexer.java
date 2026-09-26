package org.example.parser;

import antlr4.com.antlr4.com.YLenguajeLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class YIdentationLexer extends YLenguajeLexer {


    public static final int TAB_WIDTH = 4;

    private final Deque<Integer> indentStack = new ArrayDeque<>();
    private final Queue<Token> pending = new ArrayDeque<>();

    //crea despues de un NEWLINE
    private Token lookahead;
    private int openedBrackets = 0;
    private int lastSignificantType = Token.INVALID_TYPE;
    private boolean firstRealTokenSeen = false;

    public YIdentationLexer(CharStream input) {
        super(input);
        indentStack.push(0);
    }

    // lee el siguiente token evitando el canal de los comoentarios
    private Token readRaw() {
        if (lookahead != null) {
            Token t = lookahead;
            lookahead = null;
            return t;
        }
        Token t;
        do {
            t = super.nextToken();
        } while (t.getChannel() == Token.HIDDEN_CHANNEL);
        return t;
    }

    @Override
    public Token nextToken() {
        if (!pending.isEmpty()) {
            return pending.poll();
        }

        Token t = readRaw();

        while (true) {
            int type = t.getType();

            if (type == Token.EOF) {
                // Si la ultima linea no termino en NEWLINE, sintetizarlo
                // para que `bloque: INDENT instrucciones+ DEDENT` cierre bien
                // (instrucciones siempre terminan en NEWLINE).
                if (firstRealTokenSeen
                        && lastSignificantType != NEWLINE
                        && lastSignificantType != INDENT
                        && lastSignificantType != DEDENT
                        && lastSignificantType != Token.INVALID_TYPE) {
                    pending.offer(syntheticNewline(t));
                }
                while (indentStack.peek() > 0) {
                    indentStack.pop();
                    pending.offer(synthetic(DEDENT, t));
                }
                pending.offer(t);
                lastSignificantType = Token.EOF;
                return pending.poll();
            }

            if (type == LPAREN || type == LCORCH || type == LLLAVE) {
                openedBrackets++;
                lastSignificantType = type;
                firstRealTokenSeen = true;
                return t;
            }
            if (type == RPAREN || type == RCORCH || type == RLLAVE) {
                if (openedBrackets > 0) {
                    openedBrackets--;
                }
                lastSignificantType = type;
                firstRealTokenSeen = true;
                return t;
            }

            if (type == NEWLINE) {
                if (openedBrackets > 0) {
                    t = readRaw();
                    continue;
                }
                int indent = countIndent(t.getText());
                int nlLine = t.getLine();

                Token ahead = readRaw();
                while (ahead.getType() == NEWLINE) {
                    indent = countIndent(ahead.getText());
                    nlLine = ahead.getLine();
                    ahead = readRaw();
                }

                if (ahead.getType() == Token.EOF) {
                    pending.offer(cleanNewline(nlLine, t));
                    lastSignificantType = NEWLINE;
                    while (indentStack.peek() > 0) {
                        indentStack.pop();
                        pending.offer(synthetic(DEDENT, ahead));
                    }
                    pending.offer(ahead);
                    lastSignificantType = Token.EOF;
                    return pending.poll();
                }

                pending.offer(cleanNewline(nlLine, t));
                lastSignificantType = NEWLINE;

                lookahead = ahead;

                int current = indentStack.peek();
                if (indent > current) {
                    indentStack.push(indent);
                    pending.offer(synthetic(INDENT, ahead));
                    if (indent % TAB_WIDTH != 0) {
                        System.err.println("[YIdentationLexer] aviso linea "
                                + ahead.getLine() + ": indentacion de " + indent
                                + " espacios no es multiplo de " + TAB_WIDTH);
                    }
                } else if (indent < current) {
                    while (indentStack.peek() > indent) {
                        indentStack.pop();
                        pending.offer(synthetic(DEDENT, ahead));
                    }
                    if (indentStack.peek() != indent) {
                        System.err.println("[YIdentationLexer] error linea "
                                + ahead.getLine() + ": indentacion inconsistente ("
                                + indent + " espacios, se esperaba "
                                + indentStack.peek() + ").");
                    }
                }
                return pending.poll();
            }

            // ---- token normal ----
            if (!firstRealTokenSeen) {
                firstRealTokenSeen = true;
                int col = t.getCharPositionInLine();
                if (col > 0) {
                    System.err.println("[YIdentationLexer] error linea "
                            + t.getLine() + ": la primera linea no debe indentarse.");
                    indentStack.push(col);
                    pending.offer(synthetic(INDENT, t));
                    pending.offer(t);
                    lastSignificantType = type;
                    return pending.poll();
                }
            }
            lastSignificantType = type;
            return t;
        }
    }

    private int countIndent(String text) {
        int count = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            char c = text.charAt(i);
            if (c == ' ') {
                count += 1;
            } else if (c == '\t') {
                count += TAB_WIDTH;
            } else {
                break;
            }
        }
        return count;
    }

    private CommonToken cleanNewline(int line, Token ref) {
        CommonToken nl = new CommonToken(new Pair<>(this, _input), NEWLINE,
                Token.DEFAULT_CHANNEL, -1, -1);
        nl.setText("\n");
        nl.setLine(line);
        nl.setCharPositionInLine(0);
        return nl;
    }

    private CommonToken syntheticNewline(Token ref) {
        CommonToken nl = new CommonToken(new Pair<>(this, _input), NEWLINE,
                Token.DEFAULT_CHANNEL, -1, -1);
        nl.setText("\n");
        nl.setLine(ref.getLine());
        nl.setCharPositionInLine(0);
        return nl;
    }

    private CommonToken synthetic(int type, Token ref) {
        CommonToken tok = new CommonToken(new Pair<>(this, _input), type,
                Token.DEFAULT_CHANNEL, -1, -1);
        tok.setText(type == INDENT ? "<INDENT>" : "<DEDENT>");
        tok.setLine(ref.getLine());
        tok.setCharPositionInLine(ref.getCharPositionInLine());
        return tok;
    }
}
