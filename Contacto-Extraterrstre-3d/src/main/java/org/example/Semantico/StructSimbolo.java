package org.example.Semantico;

import java.util.LinkedHashMap;
import java.util.Map;

public class StructSimbolo {

    public final String name;
    public final int line;
    public final Map<String, Tipo> campos = new LinkedHashMap<>();

    public StructSimbolo(String nombre, int linea) {
        this.name = nombre;
        this.line = linea;
    }

    public boolean tieneCampo(String campo) {
        return campos.containsKey(campo);
    }

    public Tipo tipoCampo(String campo) {
        return campos.getOrDefault(campo, Tipo.ERROR);
    }
}