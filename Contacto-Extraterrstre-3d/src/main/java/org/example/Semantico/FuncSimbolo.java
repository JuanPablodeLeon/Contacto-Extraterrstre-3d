package org.example.Semantico;

import java.util.List;

public class FuncSimbolo {
    public final String name;
    public final int line;
    public final Tipo retorno;
    public final List<Tipo> tiposParams;
    public final List<String> nombresParams;

    public FuncSimbolo(String nombre, int linea, Tipo retorno, List<Tipo> tiposParams, List<String> nombresParams) {
        this.name = nombre;
        this.line = linea;
        this.retorno = retorno;
        this.tiposParams = tiposParams;
        this.nombresParams = nombresParams;
    }
}
