package org.example.Ejecutor;

import org.antlr.v4.runtime.Token;
import org.example.Codigo3D.Cuarteta;
import org.example.Reports.CompilerError;

import java.util.Collections;
import java.util.List;

public class ResultadoCompilacion {

    private final boolean exitoso;
    private final String lenguaje;
    private final List<Token> tokens;
    private final List<CompilerError> errores;
    private final List<Cuarteta> cuartetas;
    private final String codigo3D;
    private final String codigoC;
    private final String consola;

    public ResultadoCompilacion(boolean exitoso, String lenguaje, List<Token> tokens, List<CompilerError> errores,
                                List<Cuarteta> cuartetas, String codigo3D, String codigoC, String consola) {
        this.exitoso = exitoso;
        this.lenguaje = lenguaje;
        this.tokens = tokens == null ? Collections.emptyList() : Collections.unmodifiableList(tokens);
        this.errores = errores == null ? Collections.emptyList() : Collections.unmodifiableList(errores);
        this.cuartetas = cuartetas == null ? Collections.emptyList() : Collections.unmodifiableList(cuartetas);
        this.codigo3D = codigo3D == null ? "" : codigo3D;
        this.codigoC = codigoC == null ? "" : codigoC;
        this.consola = consola == null ? "" : consola;
    }

    public boolean isExitoso() { return exitoso; }
    public String getLenguaje() { return lenguaje; }
    public List<Token> getTokens() { return tokens; }
    public List<CompilerError> getErrores() { return errores; }
    public List<Cuarteta> getCuartetas() { return cuartetas; }
    public String getCodigo3D() { return codigo3D; }
    public String getCodigoC() { return codigoC; }
    public String getConsola() { return consola; }

    public boolean tieneTraduccion() {
        return exitoso && !cuartetas.isEmpty();
    }
}
