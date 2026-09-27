package org.example.Semantico;

import org.example.Reports.CompilerError;

public class VarSymbol {
    public final String name;
    public final int line;
    public final Tipo type;
    public Integer sizeSeries;

    public VarSymbol(String name, int line, Tipo type) {
        this.name = name;
        this.line = line;
        this.type = type;
    }
}
