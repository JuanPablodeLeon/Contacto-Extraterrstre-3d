package org.example.Views.Syntax;

import org.antlr.v4.runtime.Vocabulary;
import org.fife.ui.rsyntaxtextarea.TokenTypes;

import java.util.Set;

/**
 * Traduce los tipos de token de un lexer de ANTLR a los tipos que entiende
 * RSyntaxTextArea.
 */
final class AntlrTokenTypes {

    private AntlrTokenTypes() {
    }

    /**
     * Construye un arreglo indexado por el tipo de token de ANTLR.
     *
     * @param vocabulary   vocabulario del lexer generado.
     * @param reservedWords nombres simbolicos de las palabras reservadas.
     * @param dataTypes     nombres simbolicos de los tipos de dato.
     * @param booleans      nombres simbolicos de los literales booleanos/null.
     * @param operators     nombres simbolicos de los operadores.
     * @param separators    nombres simbolicos de los separadores.
     * @return arreglo donde {@code resultado[tipoAntlr]} es el tipo de
     *         RSyntaxTextArea.
     */
    static int[] build(Vocabulary vocabulary,
                       Set<String> reservedWords,
                       Set<String> dataTypes,
                       Set<String> booleans,
                       Set<String> operators,
                       Set<String> separators) {
        int[] types = new int[vocabulary.getMaxTokenType() + 1];
        for (int tokenType = 1; tokenType < types.length; tokenType++) {
            types[tokenType] = classify(
                    vocabulary.getSymbolicName(tokenType),
                    reservedWords,
                    dataTypes,
                    booleans,
                    operators,
                    separators
            );
        }
        return types;
    }

    private static int classify(String name,
                                Set<String> reservedWords,
                                Set<String> dataTypes,
                                Set<String> booleans,
                                Set<String> operators,
                                Set<String> separators) {
        if (name == null) {
            return TokenTypes.IDENTIFIER;
        }
        if (reservedWords.contains(name)) {
            return TokenTypes.RESERVED_WORD;
        }
        if (dataTypes.contains(name)) {
            return TokenTypes.DATA_TYPE;
        }
        if (booleans.contains(name)) {
            return TokenTypes.LITERAL_BOOLEAN;
        }
        if (operators.contains(name)) {
            return TokenTypes.OPERATOR;
        }
        if (separators.contains(name)) {
            return TokenTypes.SEPARATOR;
        }

        return switch (name) {
            case "OVERRIDE" -> TokenTypes.ANNOTATION;
            case "NULL_VAL" -> TokenTypes.LITERAL_BOOLEAN;
            case "ID" -> TokenTypes.IDENTIFIER;
            case "INT", "INTEGER" -> TokenTypes.LITERAL_NUMBER_DECIMAL_INT;
            case "DOUBLE", "DOUBLES", "DECIMAL" -> TokenTypes.LITERAL_NUMBER_FLOAT;
            case "STRING", "STRINGS" -> TokenTypes.LITERAL_STRING_DOUBLE_QUOTE;
            case "CHAR", "CHARS" -> TokenTypes.LITERAL_CHAR;
            case "LINE_COMMENT" -> TokenTypes.COMMENT_EOL;
            case "BLOCK_COMMENT" -> TokenTypes.COMMENT_MULTILINE;
            case "WS", "NEWLINE", "TAB" -> TokenTypes.WHITESPACE;
            default -> TokenTypes.IDENTIFIER;
        };
    }
}
