package org.example.Reports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ErrorReporter {
    private final List<CompilerError> errores = new ArrayList<>();

    public void lexico(int line, int column, String message) {
        errores.add(new CompilerError(CompilerError.Tipo.LEXICO, line, column, message));
    }

    public void sintactico(int line, int column, String message) {
        errores.add(new CompilerError(CompilerError.Tipo.SINTACTICO, line, column, message));
    }

    public void semantico(int line, String message) {
        errores.add(new CompilerError(CompilerError.Tipo.SEMANTICO, line, message));
    }

    public boolean tieneErrores() {
        return !errores.isEmpty();
    }

    public List<CompilerError> getErrores() {
        return Collections.unmodifiableList(errores);
    }
}
