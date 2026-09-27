package org.example.Codigo3D;

import org.example.Ejecutor.ClaseZ;

import java.util.*;

public class GeneradorC {

    private final List<Cuarteta> quads;
    private final Map<String, String> tipoTemp;
    private final Map<String, String> tipoVar;
    private final List<String[]> globales;
    private final Map<String, String> retFunc;
    private final Map<String, ClaseZ> clases;

    public GeneradorC(List<Cuarteta> quads,
                      Map<String, String> tipoTemp,
                      Map<String, String> tipoVar,
                      List<String[]> globales,
                      Map<String, String> retFunc,
                      Map<String, ClaseZ> clases) {
        this.quads = quads;
        this.tipoTemp = tipoTemp == null ? Map.of() : tipoTemp;
        this.tipoVar = tipoVar == null ? Map.of() : tipoVar;
        this.globales = globales == null ? List.of() : globales;
        this.retFunc = retFunc == null ? Map.of() : retFunc;
        this.clases = clases == null ? Map.of() : clases;
    }

    public GeneradorC(List<Cuarteta> quads,
                      Map<String, String> tipoTemp,
                      Map<String, String> tipoVar,
                      List<String[]> globales,
                      Map<String, String> retFunc) {
        this(quads, tipoTemp, tipoVar, globales, retFunc, Map.of());
    }

    private static final Set<String> PALABRAS_C = Set.of(
            "auto", "break", "case", "char", "const", "continue", "default", "do",
            "double", "else", "enum", "extern", "float", "for", "goto", "if",
            "int", "long", "register", "return", "short", "signed", "sizeof",
            "static", "struct", "switch", "typedef", "union", "unsigned",
            "void", "volatile", "while", "_Bool", "_Complex", "_Imaginary");

    private static String id(String nombre) {
        if (nombre == null) return "_";
        if (PALABRAS_C.contains(nombre)) return "ux_" + nombre;
        return nombre;
    }

    public static String cTipo(String t) {
        if (t == null) return "int";
        String s = t.trim();
        switch (s) {
            case "numerus": return "int";
            case "decimalis": return "double";
            case "textum": return "char*";
            case "littera": return "char";
            case "bool": return "int";
            case "void": return "void";
            default:
                if (s.startsWith("series<") && s.endsWith(">")) {
                    return cTipo(s.substring(7, s.length() - 1)) + "*";
                }
                return "int";
        }
    }

    public static String segmentoDe(String tipo) {
        if (tipo == null) return "STACK";
        String t = tipo.trim();
        if (t.equals("textum") || t.startsWith("series<")) return "HEAP";
        return "STACK";
    }

    private String ct(String t) {
        if (t == null) return "int";
        String s = t.trim();
        if (clases.containsKey(s)) return s + "*";
        if (s.startsWith("series<") && s.endsWith(">")) {
            String e = s.substring(7, s.length() - 1);
            if (clases.containsKey(e)) return e + "**";
            return cTipo(s);
        }
        if (s.equals("null")) return "void*";
        return cTipo(s);
    }

    private boolean esObjeto(String tipo) {
        return tipo != null && clases.containsKey(tipo.trim());
    }

    private String ctCampo(String t) {
        if (t == null) return "int";
        String s = t.trim();
        if (clases.containsKey(s)) return "struct " + s + "*";
        if (s.startsWith("series<") && s.endsWith(">")) {
            String e = s.substring(7, s.length() - 1);
            if (clases.containsKey(e)) return "struct " + e + "**";
            return cTipo(s);
        }
        return cTipo(s);
    }

    private List<ClaseZ> structsOrdenados() {
        List<ClaseZ> orden = new ArrayList<>();
        Set<String> visitado = new LinkedHashSet<>();
        Set<String> enPila = new LinkedHashSet<>();
        for (String nombre : clases.keySet()) {
            visitarStruct(nombre, visitado, enPila, orden);
        }
        return orden;
    }

    private void visitarStruct(String nombre, Set<String> visitado,
                               Set<String> enPila, List<ClaseZ> orden) {
        if (visitado.contains(nombre)) return;
        if (enPila.contains(nombre)) return;
        ClaseZ cz = clases.get(nombre);
        if (cz == null) return;
        enPila.add(nombre);
        for (String tipoCampo : cz.campos.values()) {
            String dep = tipoCampo.trim();
            if (dep.startsWith("series<") && dep.endsWith(">")) {
                dep = dep.substring(7, dep.length() - 1).trim();
            }
            if (clases.containsKey(dep)) visitarStruct(dep, visitado, enPila, orden);
        }
        enPila.remove(nombre);
        visitado.add(nombre);
        orden.add(cz);
    }

    private String tipoDe(String lugar) {
        if (lugar == null || lugar.equals("-") || lugar.equals("_")) return "numerus";
        if (lugar.equals("NULL")) return "null";
        if (tipoTemp.containsKey(lugar)) return tipoTemp.get(lugar);
        if (tipoVar.containsKey(lugar)) return tipoVar.get(lugar);
        if (lugar.startsWith("\"")) return "textum";
        if (lugar.startsWith("'")) return "littera";
        if (lugar.equals("verum") || lugar.equals("falsus")) return "bool";
        try {
            Integer.parseInt(lugar);
            return "numerus";
        } catch (NumberFormatException ignored) { }
        try {
            Double.parseDouble(lugar);
            return "decimalis";
        } catch (NumberFormatException ignored) { }
        return "numerus";
    }

    private static String val(String lugar) {
        if (lugar == null) return "0";
        if (lugar.equals("verum")) return "1";
        if (lugar.equals("falsus")) return "0";
        return id(lugar);
    }

    private String aTexto(String lugar) {
        String t = tipoDe(lugar);
        switch (t) {
            case "textum": return val(lugar);
            case "numerus": return "S_of_int(" + val(lugar) + ")";
            case "decimalis": return "S_of_double(" + val(lugar) + ")";
            case "littera": return "S_of_char(" + val(lugar) + ")";
            case "bool": return "S_of_bool(" + val(lugar) + ")";
            default: return val(lugar);
        }
    }

    private static class Bloque {
        String nombre;
        boolean esMain;
        String ret = "void";
        final List<String[]> params = new ArrayList<>();
        final List<String[]> vars = new ArrayList<>();
        final Set<String> declarados = new LinkedHashSet<>();
        final Set<String> temps = new LinkedHashSet<>();
        final List<Cuarteta> cuerpo = new ArrayList<>();
    }

    private void declararEn(Bloque b, String tipo, String nombre) {
        if (b.declarados.contains(nombre)) return;
        b.declarados.add(nombre);
        b.vars.add(new String[]{tipo, nombre});
    }

    private void recogerTemp(Bloque b, String lugar) {
        if (lugar == null || lugar.equals("-") || lugar.equals("_")) return;
        if (lugar.matches("t\\d+") && tipoTemp.containsKey(lugar)) b.temps.add(lugar);
    }

    public String generar(String nombreFuente) {
        List<Bloque> funciones = new ArrayList<>();
        Bloque main = new Bloque();
        main.esMain = true;
        main.nombre = "main";

        Bloque actual = null;
        boolean enMain = false;
        List<Cuarteta> initGlobales = new ArrayList<>();
        for (Cuarteta q : quads) {
            switch (q.op) {
                case "FUNC_BEGIN":
                    actual = new Bloque();
                    actual.nombre = q.arg1;
                    actual.ret = q.arg2.equals("-") ? "void" : q.arg2;
                    enMain = false;
                    break;
                case "FUNC_END":
                    if (actual != null) funciones.add(actual);
                    actual = null;
                    break;
                case "MAIN_BEGIN":
                    enMain = true;
                    actual = null;
                    break;
                case "MAIN_END":
                    enMain = false;
                    break;
                case "PARAM_DECL":
                    if (actual != null) {
                        actual.params.add(new String[]{q.arg1, q.res});
                        actual.declarados.add(q.res);
                    }
                    break;
                case "DECLARE":
                    if (actual != null) declararEn(actual, q.arg1, q.res);
                    else if (enMain) declararEn(main, q.arg1, q.res);
                    break;
                default:
                    if (actual != null) {
                        actual.cuerpo.add(q);
                        recogerTemp(actual, q.arg1);
                        recogerTemp(actual, q.arg2);
                        recogerTemp(actual, q.res);
                    } else if (enMain) {
                        main.cuerpo.add(q);
                        recogerTemp(main, q.arg1);
                        recogerTemp(main, q.arg2);
                        recogerTemp(main, q.res);
                    } else {
                        initGlobales.add(q);
                        recogerTemp(main, q.arg1);
                        recogerTemp(main, q.arg2);
                        recogerTemp(main, q.res);
                    }
            }
        }

        StringBuilder c = new StringBuilder();
        c.append("/* =====================================================\n");
        c.append(" * Traduccion PigLatin+Zetariano+Y? -> C (via codigo de 3 direcciones)\n");
        if (nombreFuente != null && !nombreFuente.isBlank()) {
            c.append(" * Fuente: ").append(nombreFuente).append("\n");
        }
        c.append(" * STACK: primitivas, temporales, parametros y control (pila C)\n");
        c.append(" * HEAP : textum (char*), series (heap_alloc/malloc)\n");
        c.append(" * ===================================================== */\n");
        c.append("#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n\n");
        c.append("/* ---------- runtime STACK/HEAP ---------- */\n");
        c.append("static size_t heap_usados = 0;   /* bytes pedidos al HEAP */\n");
        c.append("static int pila_prof = 0;        /* profundidad logica del STACK */\n");
        c.append("static void *heap_alloc(size_t n) { /* HEAP */\n");
        c.append("    heap_usados += n;\n");
        c.append("    void *p = calloc(1, n);\n");
        c.append("    if (!p) { fprintf(stderr, \"sin memoria (heap)\\n\"); exit(1); }\n");
        c.append("    return p;\n}\n");
        c.append("static char *S_dup(const char *s) { /* textum vive en HEAP */\n");
        c.append("    if (!s) s = \"\";\n");
        c.append("    size_t n = strlen(s) + 1;\n");
        c.append("    char *p = (char*) heap_alloc(n);\n");
        c.append("    memcpy(p, s, n);\n    return p;\n}\n");
        c.append("static char *S_concat(const char *a, const char *b) {\n");
        c.append("    if (!a) a = \"\";\n    if (!b) b = \"\";\n");
        c.append("    size_t n = strlen(a) + strlen(b) + 1;\n");
        c.append("    char *p = (char*) heap_alloc(n);\n");
        c.append("    strcpy(p, a); strcat(p, b);\n    return p;\n}\n");
        c.append("static char *S_of_int(int v) { char b[32]; snprintf(b, sizeof b, \"%d\", v); return S_dup(b); }\n");
        c.append("static void fmt_double(char *b, size_t n, double v) { /* paridad con Double.toString de Java */\n");
        c.append("    if (v == (long long) v && v > -1e15 && v < 1e15) snprintf(b, n, \"%lld.0\", (long long) v);\n");
        c.append("    else snprintf(b, n, \"%g\", v);\n}\n");
        c.append("static char *S_of_double(double v) { char b[64]; fmt_double(b, sizeof b, v); return S_dup(b); }\n");
        c.append("static char *S_of_char(char v) { char b[2]; b[0]=v; b[1]='\\0'; return S_dup(b); }\n");
        c.append("static char *S_of_bool(int v) { return S_dup(v ? \"verum\" : \"falsus\"); }\n");
        c.append("static char *leer_linea(void) { /* << hacia el HEAP */\n");
        c.append("    char *l = NULL; size_t n = 0;\n");
        c.append("    if (getline(&l, &n, stdin) < 0) { free(l); return S_dup(\"\"); }\n");
        c.append("    l[strcspn(l, \"\\r\\n\")] = '\\0';\n");
        c.append("    char *p = S_dup(l); free(l);\n    return p;\n}\n\n");

        if (!clases.isEmpty()) {
            for (String n : clases.keySet()) {
                c.append("struct ").append(id(n)).append(";\n");
            }
            c.append("\n");
            for (ClaseZ cz : structsOrdenados()) {
                c.append("typedef struct ").append(id(cz.nombre)).append(" {\n");
                for (Map.Entry<String, String> f : cz.campos.entrySet()) {
                    c.append("    ").append(ctCampo(f.getValue())).append(" ")
                            .append(id(f.getKey())).append("; /* ")
                            .append(esObjeto(f.getValue()) ? "HEAP" : segmentoDe(f.getValue()))
                            .append(" */\n");
                }
                c.append("} ").append(id(cz.nombre)).append(";\n");
            }
            c.append("\n");
        }

        for (Bloque f : funciones) {
            c.append(ct(f.ret)).append(" ").append(id(f.nombre)).append("(");
            c.append(firma(f)).append(");\n");
        }
        if (!funciones.isEmpty()) c.append("\n");

        for (String[] g : globales) {
            String seg = esObjeto(g[0]) ? "HEAP" : segmentoDe(g[0]);
            c.append("/* global (").append(seg).append(") */ ");
            c.append(ct(g[0])).append(" ").append(id(g[1])).append(";\n");
        }
        if (!globales.isEmpty()) c.append("\n");

        for (Bloque f : funciones) {
            c.append(ct(f.ret)).append(" ").append(id(f.nombre)).append("(");
            c.append(firma(f)).append(") {\n");
            c.append("    pila_prof++; /* entra llamada: crece el STACK */\n");
            List<String> sent = traducirLista(f.cuerpo, f);
            emitirDeclaraciones(c, f);
            for (String s : sent) c.append("    ").append(s).append("\n");
            if (f.ret.equals("void") || f.ret.equals("-")) {
                c.append("    pila_prof--;\n");
                if (sent.stream().noneMatch(s -> s.startsWith("return"))) {
                    c.append("    return;\n");
                }
            }
            c.append("}\n\n");
        }

        c.append("int main(void) {\n");
        c.append("    pila_prof++; /* base del STACK */\n");
        List<String> sentMain = new ArrayList<>();
        if (!initGlobales.isEmpty()) {
            sentMain.add("/* inicializadores de variables globales */");
            sentMain.addAll(traducirLista(initGlobales, main));
        }
        sentMain.addAll(traducirLista(main.cuerpo, main));
        emitirDeclaraciones(c, main);
        for (String s : sentMain) c.append("    ").append(s).append("\n");
        for (String[] g : globales) {
            if (g[0].equals("textum") || g[0].startsWith("series<") || esObjeto(g[0])) {
                c.append("    free(").append(id(g[1])).append("); /* libera HEAP */\n");
            }
        }
        c.append("    /* pila_prof-- al salir: se libera el STACK */\n");
        c.append("    pila_prof--;\n    return 0;\n}\n");
        return c.toString();
    }

    private String firma(Bloque f) {
        if (f.params.isEmpty()) return "void";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < f.params.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(ct(f.params.get(i)[0])).append(" ").append(id(f.params.get(i)[1]));
        }
        return sb.toString();
    }

    private void emitirDeclaraciones(StringBuilder c, Bloque b) {
        for (String[] v : b.vars) {
            String tipoL = v[0], nombre = v[1];
            if (tipoL.equals("textum")) {
                c.append("    char* ").append(id(nombre)).append(" = NULL; /* HEAP */\n");
            } else if (tipoL.startsWith("series<") && tipoL.endsWith(">")) {
                c.append("    ").append(ct(tipoL)).append(" ").append(id(nombre))
                        .append(" = NULL; /* HEAP */\n");
            } else if (esObjeto(tipoL)) {
                c.append("    ").append(ct(tipoL)).append(" ").append(id(nombre))
                        .append(" = NULL; /* objeto HEAP */\n");
            } else {
                c.append("    ").append(ct(tipoL)).append(" ").append(id(nombre))
                        .append(" = ").append(valorDefecto(tipoL)).append("; /* STACK */\n");
            }
        }
        for (String t : b.temps) {
            String tipoL = tipoTemp.getOrDefault(t, "numerus");
            if (tipoL.equals("textum")) {
                c.append("    char* ").append(t).append(" = NULL; /* temporal HEAP */\n");
            } else if (tipoL.startsWith("series<")) {
                c.append("    ").append(ct(tipoL)).append(" ").append(t)
                        .append(" = NULL; /* temporal HEAP */\n");
            } else if (esObjeto(tipoL)) {
                c.append("    ").append(ct(tipoL)).append(" ").append(t)
                        .append(" = NULL; /* temporal objeto HEAP */\n");
            } else {
                c.append("    ").append(ct(tipoL)).append(" ").append(t)
                        .append(" = ").append(valorDefecto(tipoL))
                        .append("; /* temporal STACK */\n");
            }
        }
    }

    private String valorDefecto(String tipo) {
        if (esObjeto(tipo) || tipo.startsWith("series<")) return "NULL";
        return valorDefectoStatic(tipo);
    }

    private static String valorDefectoStatic(String tipo) {
        switch (tipo) {
            case "decimalis": return "0.0";
            case "textum": return "NULL";
            case "littera": return "'\\0'";
            case "bool":
            case "numerus": return "0";
            default:
                if (tipo.startsWith("series<")) return "NULL";
                return "0";
        }
    }

    private List<String> traducirLista(List<Cuarteta> lista, Bloque b) {
        List<String> out = new ArrayList<>();
        List<String> paramsPend = new ArrayList<>();
        for (Cuarteta q : lista) {
            switch (q.op) {
                case "LABEL" -> out.add(id(q.arg1) + ":;");
                case "GOTO" -> out.add("goto " + id(q.arg1) + ";");
                case "IF_FALSE" -> out.add("if (!(" + val(q.arg1) + ")) goto " + id(q.res) + ";");
                case "IF_TRUE" -> out.add("if (" + val(q.arg1) + ") goto " + id(q.res) + ";");
                case "=" -> {
                    String dst = q.res, src = q.arg1;
                    String td = tipoDe(dst), ts = tipoDe(src);
                    if (td.equals("textum") && ts.equals("textum")
                            && !src.startsWith("\"") && !src.equals(dst)) {
                        out.add(id(dst) + " = S_dup(" + val(src) + "); /* HEAP */");
                    } else if (td.equals("textum") && src.startsWith("\"")) {
                        out.add(id(dst) + " = S_dup(" + src + "); /* HEAP */");
                    } else if (td.equals("textum") && !ts.equals("textum")) {
                        out.add(id(dst) + " = S_dup(" + aTexto(src) + "); /* HEAP */");
                    } else {
                        out.add(id(dst) + " = " + val(src) + ";");
                    }
                }
                case "+", "-", "*", "/", "%" -> {
                    String td = tipoDe(q.res);
                    if (td.equals("textum") && q.op.equals("+")) {
                        out.add(id(q.res) + " = S_concat(" + aTexto(q.arg1)
                                + ", " + aTexto(q.arg2) + "); /* HEAP */");
                    } else {
                        out.add(id(q.res) + " = " + val(q.arg1) + " " + q.op + " " + val(q.arg2) + ";");
                    }
                }
                case "==", "!=" -> {
                    if (tipoDe(q.arg1).equals("textum") || tipoDe(q.arg2).equals("textum")) {
                        String cmp = q.op.equals("!=")
                                ? "strcmp(" + val(q.arg1) + ", " + val(q.arg2) + ") != 0"
                                : "strcmp(" + val(q.arg1) + ", " + val(q.arg2) + ") == 0";
                        out.add(id(q.res) + " = (" + cmp + "); /* textum en HEAP */");
                    } else {
                        out.add(id(q.res) + " = (" + val(q.arg1) + " " + q.op + " " + val(q.arg2) + ");");
                    }
                }
                case "<", ">", "<=", ">=", "&&", "||" ->
                        out.add(id(q.res) + " = (" + val(q.arg1) + " " + q.op + " " + val(q.arg2) + ");");
                case "UMINUS" -> out.add(id(q.res) + " = -(" + val(q.arg1) + ");");
                case "NOT" -> out.add(id(q.res) + " = !(" + val(q.arg1) + ");");
                case "=[] " -> out.add(id(q.res) + " = " + id(q.arg1) + "[" + val(q.arg2) + "];");
                case "=[]" -> out.add(id(q.res) + " = " + id(q.arg1) + "[" + val(q.arg2) + "];");
                case "[]=" -> out.add(id(q.arg1) + "[" + val(q.arg2) + "] = " + val(q.res) + ";");
                case "=.", ".=" -> {
                    String sep = esObjeto(tipoDe(q.arg1)) ? "->" : ".";
                    if (q.op.equals("=.")) {
                        out.add(id(q.res) + " = " + id(q.arg1) + sep + id(q.arg2) + ";");
                    } else {
                        out.add(id(q.arg1) + sep + id(q.arg2) + " = " + val(q.res) + ";");
                    }
                }
                case "ALLOC_OBJECT" -> {
                    out.add(id(q.res) + " = (" + ct(q.arg1) + ") heap_alloc(sizeof("
                            + id(q.arg1) + ")); /* objeto HEAP */");
                }
                case "ALLOC_SERIES" -> {
                    String elem = q.arg1, tam = q.arg2, dst = q.res;
                    String tipoElemC = cTipo(elem);
                    out.add(id(dst) + " = (" + tipoElemC + "*) heap_alloc(sizeof("
                            + tipoElemC + ") * (" + val(tam) + ")); /* HEAP */");
                }
                case "PRINT", "PRINTLN" -> out.add(sentPrint(q.arg1, q.op.equals("PRINTLN")));
                case "READ" -> out.addAll(sentRead(q.arg1));
                case "PARAM" -> paramsPend.add(q.arg1);
                case "CALL" -> {
                    String llamada = id(q.arg1) + "("
                            + String.join(", ", paramsPend.stream().map(GeneradorC::val).toList()) + ")";
                    paramsPend.clear();
                    if (q.res.equals("-")) out.add(llamada + ";");
                    else {
                        String td = tipoDe(q.res);
                        if (td.equals("textum")) {
                            out.add(id(q.res) + " = S_dup(" + llamada + "); /* HEAP */");
                        } else {
                            out.add(id(q.res) + " = " + llamada + ";");
                        }
                    }
                }
                case "RETURN" -> {
                    if (q.arg1.equals("-")) out.add("pila_prof--; return;");
                    else out.add("{ pila_prof--; return " + val(q.arg1) + "; }");
                }
                default -> out.add("/* cuarteta no soportada: " + q.a3Direcciones() + " */");
            }
        }
        return out;
    }

    private String sentPrint(String lugar, boolean salto) {
        String nl = salto ? "\\n" : "";
        String t = tipoDe(lugar);
        String v = val(lugar);
        switch (t) {
            case "bool":
                return "printf(\"%s" + nl + "\", " + v + " ? \"verum\" : \"falsus\");";
            case "numerus":
                return "printf(\"%d" + nl + "\", " + v + ");";
            case "decimalis":
                return salto
                        ? "{ char _db[64]; fmt_double(_db, sizeof _db, " + v + "); printf(\"%s\\n\", _db); }"
                        : "{ char _db[64]; fmt_double(_db, sizeof _db, " + v + "); printf(\"%s\", _db); }";
            case "littera":
                return "printf(\"%c" + nl + "\", " + v + ");";
            case "textum":
            case "null":
            default:
                if (t.startsWith("series<")) return "/* print de " + t + " no soportado */";
                if (clases.containsKey(t)) return "/* print de objeto " + t + " no soportado */";
                if (lugar.startsWith("\"")) return "printf(\"%s" + nl + "\", " + lugar + ");";
                if (lugar.equals("NULL")) return "printf(\"%s" + nl + "\", \"(null)\");";
                return "printf(\"%s" + nl + "\", " + v + " ? " + v + " : \"\");";
        }
    }

    private List<String> sentRead(String nombre) {
        List<String> out = new ArrayList<>();
        if (nombre.equals("_") || nombre.equals("-")) {
            out.add("{ char _d[256]; if (fgets(_d, sizeof _d, stdin)) {} } /* << sin variable */");
            return out;
        }
        String t = tipoDe(nombre);
        switch (t) {
            case "numerus" -> {
                out.add("scanf(\"%d\", &" + id(nombre) + ");");
                out.add("{ int _c; while ((_c = getchar()) != '\\n' && _c != EOF) {} } /* limpia buffer */");
            }
            case "decimalis" -> {
                out.add("scanf(\"%lf\", &" + id(nombre) + ");");
                out.add("{ int _c; while ((_c = getchar()) != '\\n' && _c != EOF) {} } /* limpia buffer */");
            }
            case "littera" -> out.add("scanf(\" %c\", &" + id(nombre) + ");");
            case "bool" -> out.add("{ int _b; scanf(\"%d\", &_b); " + id(nombre) + " = _b; } /* 0=falsus */");
            case "textum" -> out.add(id(nombre) + " = leer_linea(); /* HEAP */");
            default -> out.add("/* read no soportado para " + t + " */");
        }
        return out;
    }

    public static String fmt3D(List<Cuarteta> cuartetas) {
        StringBuilder sb = new StringBuilder();
        for (Cuarteta c : cuartetas) {
            sb.append(String.format("%3d: %-28s", c.id, c.a3Direcciones()));
            if (!c.comentario.isEmpty()) sb.append("   # ").append(c.comentario);
            if (!c.segmento.isEmpty()) sb.append("   [").append(c.segmento).append("]");
            sb.append("\n");
        }
        return sb.toString();
    }
}

