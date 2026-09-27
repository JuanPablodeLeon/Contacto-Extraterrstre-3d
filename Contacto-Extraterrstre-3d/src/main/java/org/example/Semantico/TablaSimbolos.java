package org.example.Semantico;

import org.example.Views.MainFrame;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class TablaSimbolos {
    private final Map<String, FuncSimbolo> funcs = new LinkedHashMap<>();
    private final Map<String, StructSimbolo> structs = new LinkedHashMap<>();
    private Alcance actual = new Alcance(null, "global");

    // ---- Funciones ----
    public boolean existeFunc(String nombre) {
        return funcs.containsKey(nombre);
    }

    public void definirFunc(FuncSimbolo f) {
        funcs.put(f.name, f);
    }

    public FuncSimbolo obtenerFunc(String nombre) {
        return funcs.get(nombre);
    }

    public Map<String, FuncSimbolo> funciones() {
        return Collections.unmodifiableMap(funcs);
    }

    // ---- Structuras ----
    public boolean existeStruct(String nombre) {
        return structs.containsKey(nombre);
    }

    public void definirStruct(StructSimbolo s) {
        structs.put(s.name, s);
    }

    public StructSimbolo obtenerStruct(String nombre) {
        return structs.get(nombre);
    }

    public Map<String, StructSimbolo> structs() {
        return Collections.unmodifiableMap(structs);
    }

    // ---- Ambitos ----
    public void entrar(String etiqueta) {
        actual = new Alcance(actual, etiqueta);
    }

    public void salir() {
        if (actual.padre != null) actual = actual.padre;
    }

    public boolean existeLocal(String nombre) {
        return actual.existeLocal(nombre);
    }

    public void definirVar(VarSymbol v) {
        actual.declarar(v);
    }

    public VarSymbol obtenerVar(String nombre) {
        return actual.resolver(nombre);
    }
}
