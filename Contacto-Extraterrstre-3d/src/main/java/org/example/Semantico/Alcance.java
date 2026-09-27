package org.example.Semantico;

import java.util.LinkedHashMap;
import java.util.Map;

public class Alcance {

    public final Alcance padre;
    public final String etiqueta;
    private final Map<String, VarSymbol> vars = new LinkedHashMap<>();

    public Alcance(Alcance padre, String etiqueta) {
        this.padre = padre;
        this.etiqueta = etiqueta;
    }

    public boolean existeLocal(String nombre) {
        return vars.containsKey(nombre);
    }

    public void declarar(VarSymbol s) {
        vars.put(s.name, s);
    }

    public VarSymbol resolver(String nombre) {
        Alcance actual = this;
        while (actual != null) {
            VarSymbol s = actual.vars.get(nombre);
            if (s != null) return s;
            actual = actual.padre;
        }
        return null;
    }
}
