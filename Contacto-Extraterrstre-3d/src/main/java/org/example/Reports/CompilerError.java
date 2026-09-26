package org.example.Reports;

public class CompilerError {
    public enum Tipo {LEXICO, SINTACTICO, SEMANTICO}

    private final Tipo tipo;
    private final int line;
    private final int column;
    private final String message;

    public CompilerError(Tipo tipo, int line, int column, String message) {
        this.tipo = tipo;
        this.line = line;
        this.column = column;
        this.message = message;
    }

    public CompilerError(Tipo tipo, int line, String message) {
        this(tipo, line, -1, message);
    }

    public Tipo getTipo() { return tipo; }
    public int getLine() { return line; }
    public int getColumn() { return column; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        String pos = column >= 0 ? "linea: " + line + ", columna: " + column : "linea: " + line;
        return "[Error: " + tipo + "] (" + pos + "): " + message;
    }
}
