package org.example.Views.Syntax;

import antlr4.com.antlr4.com.PigLatinLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Vocabulary;

import java.util.Set;

/**
 * Resaltado de PigLatin usando el lexer generado por ANTLR a partir de
 * {@code PigLatinLexer.g4}.
 */
public final class PigLatinAntlrTokenMaker extends AntlrTokenMaker {

    private static final Set<String> RESERVED_WORDS = Set.of(
            "IMPORT", "VARIABILES", "ESTO", "MAIOR", "FINISUP",
            "NOVUS", "SI", "FINIS", "ALITER", "DUM", "FACERE",
            "PER", "NON", "PERGE", "INTERRUMPE", "IMPRIMIR", "LEER"
    );

    private static final Set<String> DATA_TYPES = Set.of(
            "BOOL", "NUMERUS", "TEXTUM", "DECIMALIS", "LITTERA", "SERIES"
    );

    private static final Set<String> BOOLEANS = Set.of(
            "FALSUS", "VERUM", "NULL_VAL"
    );

    private static final Set<String> OPERATORS = Set.of(
            "SUMA_INCR", "RESTA_DECR", "SUMA", "RESTA", "MULTI", "DIV",
            "IGUAL", "NO_IGUAL", "MENRO_IGUAL", "MAYOR_IGUAL", "MENOR", "MAYOR",
            "ASIGNACION", "AND", "OR"
    );

    private static final Set<String> SEPARATORS = Set.of(
            "DOS_PUNTOS", "LCORCH", "RCORCH", "LLLAVE", "RLLAVE",
            "LPAREN", "RPAREN", "COMA", "PUNTO", "PUNTO_COMA"
    );

    public PigLatinAntlrTokenMaker() {
        super("##", "##");
    }

    @Override
    protected Lexer createLexer(CharStream input) {
        return new PigLatinLexer(input);
    }

    @Override
    protected Vocabulary vocabulary() {
        return PigLatinLexer.VOCABULARY;
    }

    @Override
    protected int[] buildRstaTypes() {
        return AntlrTokenTypes.build(
                vocabulary(), RESERVED_WORDS, DATA_TYPES, BOOLEANS, OPERATORS, SEPARATORS
        );
    }
}
