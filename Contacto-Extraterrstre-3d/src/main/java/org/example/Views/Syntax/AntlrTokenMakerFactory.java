package org.example.Views.Syntax;

import org.fife.ui.rsyntaxtextarea.TokenMaker;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Fabrica de {@link TokenMaker} para los lenguajes del proyecto. Mantiene los
 * estilos nativos de RSyntaxTextArea y agrega los estilos propios.
 */
public final class AntlrTokenMakerFactory extends TokenMakerFactory {

    public static final String SYNTAX_STYLE_Y = "text/y";
    public static final String SYNTAX_STYLE_PIG_LATIN = "text/piglatin";
    public static final String SYNTAX_STYLE_ZETARIANO = "text/zetariano";

    public static final AntlrTokenMakerFactory INSTANCE = new AntlrTokenMakerFactory();

    private final TokenMakerFactory delegate;

    private AntlrTokenMakerFactory() {
        this.delegate = TokenMakerFactory.getDefaultInstance();
    }

    @Override
    protected TokenMaker getTokenMakerImpl(String key) {
        return switch (key) {
            case SYNTAX_STYLE_Y -> new YAntlrTokenMaker();
            case SYNTAX_STYLE_PIG_LATIN -> new PigLatinAntlrTokenMaker();
            case SYNTAX_STYLE_ZETARIANO -> new ZetarianoAntlrTokenMaker();
            default -> delegate.getTokenMaker(key);
        };
    }

    @Override
    public Set<String> keySet() {
        Set<String> keys = new LinkedHashSet<>(delegate.keySet());
        keys.add(SYNTAX_STYLE_Y);
        keys.add(SYNTAX_STYLE_PIG_LATIN);
        keys.add(SYNTAX_STYLE_ZETARIANO);
        return keys;
    }
}
