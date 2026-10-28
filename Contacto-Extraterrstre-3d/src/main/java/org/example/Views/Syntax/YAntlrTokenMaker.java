package org.example.Views.Syntax;

import antlr4.com.antlr4.com.YLenguajeLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Vocabulary;

import java.util.Set;

/**
 * Resaltado de Y? usando el lexer generado por ANTLR a partir de
 * {@code YLenguajeLexer.g4}.
 */
public final class YAntlrTokenMaker extends AntlrTokenMaker {

    private static final Set<String> RESERVED_WORDS = Set.of(
            "ESTRUCTURAS", "FUNCIONES", "ESTRUCTURA", "DEFINIR",
            "SI", "ENTONCES", "SINO", "CONTRARIO",
            "ELEGITR", "CASO", "ROMPER",
            "PARA", "CONTINUAR", "MIENTRAS", "HACER",
            "IMPRIMIR", "LEER", "RETORNAR", "SIEMPRE"
    );

    private static final Set<String> DATA_TYPES = Set.of(
            "CADENA", "ENTERO", "FLOTANTE", "CARACTER", "BOOL"
    );

    private static final Set<String> BOOLEANS = Set.of(
            "VERDADERO", "FALSO", "NULL_VAL"
    );

    private static final Set<String> OPERATORS = Set.of(
            "RETORNO_FUNC", "IGUAL", "NO_IGUAL", "MENOR_IGUAL", "MAYOR_IGUAL",
            "MENOR", "MAYOR", "AND", "OR", "NOT",
            "INCREMENTO", "DECREMENTO", "ADD_ASSIGN", "SUB_ASSIGN",
            "MUL_ASSIGN", "DIV_ASSIGN", "ASIG",
            "SUMA", "RESTA", "MULT", "DIV", "MOD"
    );

    private static final Set<String> SEPARATORS = Set.of(
            "DOS_PUNTOS", "LCORCH", "RCORCH", "LPAREN", "RPAREN",
            "COMA", "LLLAVE", "RLLAVE", "PUNTO", "PUNTO_COMA"
    );

    public YAntlrTokenMaker() {
        super("/*", "*/");
    }

    @Override
    protected Lexer createLexer(CharStream input) {
        return new YLenguajeLexer(input);
    }

    @Override
    protected Vocabulary vocabulary() {
        return YLenguajeLexer.VOCABULARY;
    }

    @Override
    protected int[] buildRstaTypes() {
        return AntlrTokenTypes.build(
                vocabulary(), RESERVED_WORDS, DATA_TYPES, BOOLEANS, OPERATORS, SEPARATORS
        );
    }
}
