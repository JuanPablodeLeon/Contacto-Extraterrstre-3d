package org.example.Views.Syntax;

import antlr4.com.antlr4.com.ZetarianoLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Vocabulary;

import java.util.Set;

/**
 * Resaltado de Zetariano usando el lexer generado por ANTLR a partir de
 * {@code ZetarianoLexer.g4}.
 */
public final class ZetarianoAntlrTokenMaker extends AntlrTokenMaker {

    private static final Set<String> RESERVED_WORDS = Set.of(
            "PUBLIC", "CLASS", "VOID", "RETURN", "NEW", "IF", "ELSE",
            "SWITCH", "CASE", "DEFAULT", "BREAK", "FOR", "CONTINUE",
            "WHILE", "DO", "PRINTLN", "PRINT", "READLN",
            "PRIVATE", "PROTECTED", "THIS", "SUPER", "EXTENDS"
    );

    private static final Set<String> DATA_TYPES = Set.of(
            "STRING", "INT", "BOOLEAN", "DOUBLE", "CHAR"
    );

    private static final Set<String> BOOLEANS = Set.of(
            "TRUE", "FALSE", "NULL_VAL"
    );

    private static final Set<String> OPERATORS = Set.of(
            "IGUAL", "NO_IGUAL", "MAYOR_IGUAL", "MENOR_IGUAL", "MAYOR", "MENOR",
            "AND", "OR", "NOT", "INCREMENTO", "DECREMENTO",
            "SUMA_IGL", "RESTA_IGL", "MULT_IGL",
            "SUMA", "RESTA", "MULT", "DIV", "MOD", "ASIGNACION"
    );

    private static final Set<String> SEPARATORS = Set.of(
            "LPAREN", "RPAREN", "LLLAVE", "RLLAVE", "PUNTO_COMA",
            "COMA", "INTERRG", "DOS_PUNTOS", "PUNTO", "LCORCH", "RCORCH"
    );

    public ZetarianoAntlrTokenMaker() {
        super("/*", "*/");
    }

    @Override
    protected Lexer createLexer(CharStream input) {
        return new ZetarianoLexer(input);
    }

    @Override
    protected Vocabulary vocabulary() {
        return ZetarianoLexer.VOCABULARY;
    }

    @Override
    protected int[] buildRstaTypes() {
        return AntlrTokenTypes.build(
                vocabulary(), RESERVED_WORDS, DATA_TYPES, BOOLEANS, OPERATORS, SEPARATORS
        );
    }
}
