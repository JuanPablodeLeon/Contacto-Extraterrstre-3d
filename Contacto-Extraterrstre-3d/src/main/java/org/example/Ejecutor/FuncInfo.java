package org.example.Ejecutor;

import java.util.ArrayList;
import java.util.List;

public class FuncInfo {
    public final String nombre;
    public final List<ParamInfo> params = new ArrayList<>();
    public final String retorno;
    public final String archivoOrigen;

    public FuncInfo(String nombre, String retorno, String archivoOrigen) {
        this.nombre = nombre;
        this.retorno = retorno == null ? "void" : retorno;
        this.archivoOrigen = archivoOrigen;
    }

    public static class ParamInfo {
        public final String tipo;
        public final String nombre;
        public ParamInfo(String tipo, String nombre) {
            this.tipo = tipo;
            this.nombre = nombre;
        }
    }

    public static String canonY(String t) {
        if (t == null) return "numerus";
        String s = t.trim().toLowerCase();
        switch (s) {
            case "entero": return "numerus";
            case "flotante": return "decimalis";
            case "cadena": return "textum";
            case "caracter": return "littera";
            case "bool": case "booleano": return "bool";
            case "numerus": case "decimalis": case "textum": case "littera": return s;
            case "void": case "vacio": return "void";
            default: return s;
        }
    }
}
