package org.example.Codigo3D;

import org.example.Ejecutor.ClaseZ;
import org.example.Semantico.StructSimbolo;
import org.example.Semantico.Tipo;

import java.util.*;

public class GeneradorC {

    private static final int STACK_SIZE = 30101999;
    private static final int HEAP_SIZE = 30101999;

    private final List<Cuarteta> quads;
    private final Map<String, String> tipoTemp;
    private final Map<String, String> tipoVar;
    private final List<String[]> globales;
    private final Map<String, String> retFunc;
    private final Map<String, ClaseZ> clases;
    private final Map<String, StructSimbolo> structsY;

    private final Map<String, Integer> globalSlots = new LinkedHashMap<>();
    private final Map<String, String> globalTypes = new LinkedHashMap<>();
    private final Map<String, Layout> classLayouts = new LinkedHashMap<>();
    private final Map<String, Layout> structLayouts = new LinkedHashMap<>();
    private final Map<String, Integer> classIds = new LinkedHashMap<>();
    private final Map<String, String> literales = new LinkedHashMap<>();

    private final List<Bloque> funciones = new ArrayList<>();
    private final Map<String, Bloque> funcionesPorNombre = new LinkedHashMap<>();
    private final Bloque main = new Bloque("main", true);
    private final List<Cuarteta> initGlobales = new ArrayList<>();
    private int globalCount;
    private int contC;
    private Bloque bloqueActual;

    public GeneradorC(List<Cuarteta> quads,
                      Map<String, String> tipoTemp,
                      Map<String, String> tipoVar,
                      List<String[]> globales,
                      Map<String, String> retFunc,
                      Map<String, ClaseZ> clases) {
        this(quads, tipoTemp, tipoVar, globales, retFunc, clases, Map.of());
    }

    public GeneradorC(List<Cuarteta> quads,
                      Map<String, String> tipoTemp,
                      Map<String, String> tipoVar,
                      List<String[]> globales,
                      Map<String, String> retFunc,
                      Map<String, ClaseZ> clases,
                      Map<String, StructSimbolo> structsY) {
        this.quads = quads == null ? List.of() : quads;
        this.tipoTemp = tipoTemp == null ? Map.of() : tipoTemp;
        this.tipoVar = tipoVar == null ? Map.of() : tipoVar;
        this.globales = globales == null ? List.of() : globales;
        this.retFunc = retFunc == null ? Map.of() : retFunc;
        this.clases = clases == null ? Map.of() : clases;
        this.structsY = structsY == null ? Map.of() : structsY;
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

    private static class Campo {
        String nombre;
        String tipo;
        int offset;
        int size = 1;
        boolean inline;
    }

    private static class Layout {
        String nombre;
        int size;
        boolean clase;
        int classId;
        final List<Campo> campos = new ArrayList<>();
        final Map<String, Campo> porNombre = new LinkedHashMap<>();
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
        final Map<String, Integer> slots = new LinkedHashMap<>();
        final Map<String, String> tipos = new LinkedHashMap<>();
        int paramCount;
        int frameSize = 1;

        Bloque(String nombre, boolean esMain) {
            this.nombre = nombre;
            this.esMain = esMain;
        }
    }

    private void prepararLayouts() {
        int cid = 1;
        for (Map.Entry<String, ClaseZ> e : clases.entrySet()) {
            ClaseZ cz = e.getValue();
            Layout l = new Layout();
            l.nombre = cz.nombre;
            l.clase = true;
            l.classId = cid;
            classIds.put(cz.nombre, cid++);
            int offset = 1;
            for (Map.Entry<String, String> f : cz.campos.entrySet()) {
                Campo c = new Campo();
                c.nombre = f.getKey();
                c.tipo = f.getValue();
                c.offset = offset++;
                c.size = 1;
                l.campos.add(c);
                l.porNombre.put(c.nombre, c);
            }
            l.size = offset;
            classLayouts.put(cz.nombre, l);
        }

        for (Map.Entry<String, StructSimbolo> e : structsY.entrySet()) {
            StructSimbolo sy = e.getValue();
            Layout l = new Layout();
            l.nombre = sy.name;
            l.clase = false;
            int offset = 1;
            for (Map.Entry<String, Tipo> f : sy.campos.entrySet()) {
                Campo c = new Campo();
                c.nombre = f.getKey();
                c.tipo = canonTipoY(f.getValue());
                int tam = sy.tamanos.getOrDefault(f.getKey(), 0);
                if (f.getValue() != null && f.getValue().base == Tipo.Base.SERIES) {
                    if (tam > 0) {
                        c.inline = true;
                        c.size = tam * (f.getValue().elementos != null
                                && f.getValue().elementos.base == Tipo.Base.STRUCT
                                ? tamanioStruct(f.getValue().elementos.nombreStruct) : 1);
                    } else {
                        c.size = 1;
                    }
                } else if (f.getValue() != null && f.getValue().base == Tipo.Base.STRUCT) {
                    c.inline = true;
                    c.size = tamanioStruct(f.getValue().nombreStruct);
                } else {
                    c.size = 1;
                }
                c.offset = offset;
                offset += c.size;
                l.campos.add(c);
                l.porNombre.put(c.nombre, c);
            }
            l.size = offset;
            structLayouts.put(sy.name, l);
        }
    }

    private int tamanioStruct(String nombre) {
        Layout l = structLayouts.get(nombre);
        return l == null ? 1 : l.size;
    }

    private static String canonTipoY(Tipo t) {
        if (t == null) return "numerus";
        switch (t.base) {
            case ENTERO: return "numerus";
            case FLOTANTE: return "decimalis";
            case CADENA: return "textum";
            case CARACTER: return "littera";
            case BOOL: return "bool";
            case SERIES: return "series<" + canonTipoY(t.elementos) + ">";
            case STRUCT: return t.nombreStruct;
            case NULL: return "null";
            case VOID: return "void";
            default: return "numerus";
        }
    }

    private Layout layout(String tipo) {
        String t = tipo == null ? "" : tipo.trim();
        if (t.startsWith("&")) t = t.substring(1).trim();
        Layout l = classLayouts.get(t);
        if (l != null) return l;
        return structLayouts.get(t);
    }

    private Campo campo(String tipo, String nombre) {
        Layout l = layout(tipo);
        return l == null ? null : l.porNombre.get(nombre);
    }

    private boolean esEstructura(String tipo) {
        String t = tipo == null ? "" : tipo.trim();
        if (t.startsWith("&")) t = t.substring(1).trim();
        return structLayouts.containsKey(t);
    }

    private boolean esClase(String tipo) {
        String t = tipo == null ? "" : tipo.trim();
        if (t.startsWith("&")) t = t.substring(1).trim();
        return classLayouts.containsKey(t);
    }

    private boolean esReferencia(String tipo) {
        String t = tipo == null ? "" : tipo.trim();
        if (t.startsWith("&")) t = t.substring(1).trim();
        return t.equals("textum") || t.startsWith("series<")
                || t.equals("null") || classLayouts.containsKey(t);
    }

    private String tipoDe(String lugar) {
        if (lugar == null || lugar.equals("-") || lugar.equals("_")) return "numerus";
        if (lugar.equals("NULL")) return "null";
        if (tipoTemp.containsKey(lugar)) return tipoTemp.get(lugar);
        if (bloqueActual != null && bloqueActual.tipos.containsKey(lugar)) {
            return bloqueActual.tipos.get(lugar);
        }
        if (globalTypes.containsKey(lugar)) return globalTypes.get(lugar);
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

    private String tipoBase(String tipo) {
        if (tipo == null) return "";
        String t = tipo.trim();
        return t.startsWith("&") ? t.substring(1).trim() : t;
    }

    private String elementoDe(String tipo) {
        String t = tipoBase(tipo);
        if (t.startsWith("series<") && t.endsWith(">")) {
            return t.substring(7, t.length() - 1).trim();
        }
        return "numerus";
    }

    private String slot(String nombre, Bloque b) {
        if (nombre == null) return null;
        Integer off = b.slots.get(nombre);
        if (off != null) return "stack[(int)(P + " + off + ")]";
        Integer g = globalSlots.get(nombre);
        if (g != null) return "stack[" + g + "]";
        return null;
    }

    private String destino(String nombre, Bloque b) {
        String s = slot(nombre, b);
        return s == null ? id(nombre) : s;
    }

    private String val(String lugar, Bloque b) {
        if (lugar == null || lugar.equals("-")) return "0";
        if (lugar.equals("verum")) return "1";
        if (lugar.equals("falsus")) return "0";
        if (lugar.equals("NULL")) return "-1";
        if (lugar.startsWith("&")) return val(lugar.substring(1), b);
        if (lugar.startsWith("\"")) {
            String lit = literales.get(lugar);
            return lit == null ? "(-1)" : lit;
        }
        if (lugar.startsWith("'")) return lugar;
        String s = slot(lugar, b);
        if (s != null) return s;
        if (lugar.contains("->") || lugar.contains(".") || lugar.endsWith("]")) {
            return ref(lugar, b);
        }
        try {
            Double.parseDouble(lugar);
            return lugar;
        } catch (NumberFormatException ignored) { }
        return id(lugar);
    }

    private String ref(String lugar, Bloque b) {
        if (lugar == null || lugar.equals("-")) return "0";
        if (lugar.startsWith("&")) return ref(lugar.substring(1), b);
        if (lugar.startsWith("\"") || lugar.startsWith("'")) return val(lugar, b);

        int pArrow = lugar.lastIndexOf("->");
        int pDot = lugar.lastIndexOf('.');
        int p = Math.max(pArrow >= 0 ? pArrow + 2 : -1, pDot >= 0 ? pDot + 1 : -1);
        if (p > 0 && p < lugar.length()) {
            String base = lugar.substring(0, pArrow >= 0 && p == pArrow + 2 ? pArrow : pDot);
            String nombreCampo = lugar.substring(p);
            String baseTipo = tipoDe(base);
            Campo c = campo(baseTipo, nombreCampo);
            String baseRef = ref(base, b);
            if (c == null) return baseRef;
            if (c.inline) return "(" + baseRef + " + " + c.offset + ")";
            return "heap[(int)((" + baseRef + ") + " + c.offset + ")]";
        }

        if (lugar.endsWith("]")) {
            int lb = lugar.lastIndexOf('[');
            if (lb > 0) {
                String base = lugar.substring(0, lb);
                String idx = lugar.substring(lb + 1, lugar.length() - 1);
                return "heap[(int)((" + ref(base, b) + ") + (" + val(idx, b) + "))]";
            }
        }
        return val(lugar, b);
    }

    private String aTexto(String lugar, Bloque b) {
        String t = tipoBase(tipoDe(lugar));
        String v = val(lugar, b);
        switch (t) {
            case "textum": return v;
            case "numerus": return "S_of_int(" + v + ")";
            case "decimalis": return "S_of_double(" + v + ")";
            case "littera": return "S_of_char(" + v + ")";
            case "bool": return "S_of_bool(" + v + ")";
            default: return v;
        }
    }

    private String nuevoC(String prefijo) {
        return prefijo + (contC++);
    }

    private void recogerTemp(Bloque b, String lugar) {
        if (lugar == null || lugar.equals("-") || lugar.equals("_")) return;
        if (lugar.matches("t\\d+") && tipoTemp.containsKey(lugar)) b.temps.add(lugar);
    }

    private void agrupar() {
        Bloque actual = null;
        boolean enMain = false;
        for (Cuarteta q : quads) {
            switch (q.op) {
                case "FUNC_BEGIN":
                    actual = new Bloque(q.arg1, false);
                    actual.ret = q.arg2.equals("-") ? "void" : q.arg2;
                    enMain = false;
                    break;
                case "FUNC_END":
                    if (actual != null) {
                        funciones.add(actual);
                        funcionesPorNombre.put(actual.nombre, actual);
                    }
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
                        actual.tipos.put(q.res, q.arg1);
                    }
                    break;
                case "DECLARE":
                    if (actual != null) {
                        actual.tipos.put(q.res, q.arg1);
                        if (!actual.declarados.contains(q.res)) {
                            actual.declarados.add(q.res);
                            actual.vars.add(new String[]{q.arg1, q.res});
                        }
                    } else if (enMain) {
                        main.tipos.put(q.res, q.arg1);
                        if (!main.declarados.contains(q.res)) {
                            main.declarados.add(q.res);
                            main.vars.add(new String[]{q.arg1, q.res});
                        }
                    } else {
                        initGlobales.add(q);
                        recogerTemp(main, q.arg1);
                        recogerTemp(main, q.arg2);
                        recogerTemp(main, q.res);
                    }
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
    }

    private void asignarSlots(Bloque b) {
        int off = 1;
        for (String[] p : b.params) {
            if (!b.slots.containsKey(p[1])) b.slots.put(p[1], off++);
        }
        b.paramCount = off - 1;
        for (String[] v : b.vars) {
            if (!b.slots.containsKey(v[1])) b.slots.put(v[1], off++);
        }
        for (String t : b.temps) {
            if (!b.slots.containsKey(t)) b.slots.put(t, off++);
        }
        b.frameSize = Math.max(1, off);
    }

    private void prepararSlots() {
        for (String[] g : globales) {
            if (!globalSlots.containsKey(g[1])) {
                globalSlots.put(g[1], globalSlots.size());
                globalTypes.put(g[1], g[0]);
            }
        }
        globalCount = globalSlots.size();
        for (Bloque f : funciones) asignarSlots(f);
        asignarSlots(main);
    }

    private void recogerLiterales() {
        for (Cuarteta q : quads) {
            for (String s : new String[]{q.arg1, q.arg2, q.res}) {
                if (s != null && s.startsWith("\"") && !literales.containsKey(s)) {
                    literales.put(s, "_lit" + literales.size());
                }
            }
        }
    }

    public String generar(String nombreFuente) {
        prepararLayouts();
        recogerLiterales();
        agrupar();
        prepararSlots();

        Bloque actual = null;
        StringBuilder c = new StringBuilder();
        c.append("/* =====================================================\n");
        c.append(" * Traduccion PigLatin+Zetariano+Y? -> C estilo Nexus-Solairy\n");
        if (nombreFuente != null && !nombreFuente.isBlank()) {
            c.append(" * Fuente: ").append(nombreFuente).append("\n");
        }
        c.append(" * STACK: variables, parametros, temporales, retorno y control\n");
        c.append(" * HEAP : textum, series, objetos y estructuras\n");
        c.append(" * ===================================================== */\n");
        c.append("#define _GNU_SOURCE\n");
        c.append("#include <stdio.h>\n");
        c.append("#include <stdlib.h>\n");
        c.append("#include <string.h>\n");
        c.append("#include <math.h>\n\n");
        c.append("#define STACK_SIZE ").append(STACK_SIZE).append("\n");
        c.append("#define HEAP_SIZE  ").append(HEAP_SIZE).append("\n\n");
        c.append("static double stack[STACK_SIZE];\n");
        c.append("static double heap[HEAP_SIZE];\n");
        c.append("static double P = 0;\n");
        c.append("static double H = 0;\n");
        for (String lit : literales.values()) {
            c.append("static double ").append(lit).append(";\n");
        }
        c.append("\n");
        emitirRuntime(c);
        c.append("\n");

        for (Bloque f : funciones) {
            c.append("void ").append(id(f.nombre)).append("(void);\n");
        }
        if (!funciones.isEmpty()) c.append("\n");

        c.append("int main(void) {\n");
        c.append("    P = ").append(globalCount).append(";\n");
        c.append("    H = 0;\n");
        bloqueActual = main;
        for (Map.Entry<String, String> e : literales.entrySet()) {
            c.append("    ").append(e.getValue()).append(" = str_lit(")
                    .append(e.getKey()).append(");\n");
        }
        emitirInicializacionBloque(c, main);
        for (String[] g : globales) {
            c.append("    ").append(destino(g[1], main)).append(" = ")
                    .append(valorInicialGlobal(g[0])).append(";\n");
        }
        emitirLista(c, initGlobales, main);
        emitirLista(c, main.cuerpo, main);
        c.append("    return 0;\n");
        c.append("}\n\n");

        for (Bloque f : funciones) {
            actual = f;
            bloqueActual = f;
            c.append("void ").append(id(f.nombre)).append("(void) {\n");
            emitirInicializacionBloque(c, f);
            emitirLista(c, f.cuerpo, f);
            c.append("    return;\n");
            c.append("}\n\n");
        }
        return c.toString();
    }

    private String valorInicialGlobal(String tipo) {
        String t = tipoBase(tipo);
        if (structLayouts.containsKey(t)) {
            return "h_alloc(" + structLayouts.get(t).size + ")";
        }
        if (esReferencia(t)) return "-1";
        return "0";
    }

    private void emitirInicializacionBloque(StringBuilder c, Bloque b) {
        for (int i = 0; i < b.vars.size(); i++) {
            String[] v = b.vars.get(i);
            int off = b.slots.getOrDefault(v[1], 0);
            String t = tipoBase(v[0]);
            if (structLayouts.containsKey(t)) {
                Layout l = structLayouts.get(t);
                c.append("    stack[(int)(P + ").append(off).append(")] = h_alloc(")
                        .append(l.size).append(");\n");
                for (Campo campo : l.campos) {
                    if (campo.inline) continue;
                    if (esReferencia(campo.tipo)) {
                        c.append("    heap[(int)(stack[(int)(P + ").append(off)
                                .append(")] + ").append(campo.offset).append(")] = -1;\n");
                    }
                }
            } else {
                c.append("    stack[(int)(P + ").append(off).append(")] = ")
                        .append(esReferencia(t) ? "-1" : "0").append(";\n");
            }
        }
        for (String t : b.temps) {
            int off = b.slots.getOrDefault(t, 0);
            String tipo = tipoTemp.getOrDefault(t, "numerus");
            String tb = tipoBase(tipo);
            if (structLayouts.containsKey(tb)) {
                Layout l = structLayouts.get(tb);
                c.append("    stack[(int)(P + ").append(off).append(")] = h_alloc(")
                        .append(l.size).append(");\n");
            } else {
                c.append("    stack[(int)(P + ").append(off).append(")] = ")
                        .append(esReferencia(tb) ? "-1" : "0").append(";\n");
            }
        }
    }

    private void emitirLista(StringBuilder c, List<Cuarteta> lista, Bloque b) {
        List<String> params = new ArrayList<>();
        for (Cuarteta q : lista) {
            if (q.op.equals("PARAM")) {
                params.add(q.arg1);
                continue;
            }
            if (q.op.equals("CALL")) {
                for (String s : traducirCall(q, params, b)) {
                    c.append("    ").append(s).append("\n");
                }
                params.clear();
                continue;
            }
            for (String s : traducir(q, b)) {
                c.append("    ").append(s).append("\n");
            }
        }
    }

    private List<String> traducir(Cuarteta q, Bloque b) {
        List<String> out = new ArrayList<>();
        switch (q.op) {
            case "LABEL" -> out.add(id(q.arg1) + ":;");
            case "GOTO" -> out.add("goto " + id(q.arg1) + ";");
            case "IF_FALSE" -> out.add("if (!(" + val(q.arg1, b) + ")) goto " + id(q.res) + ";");
            case "IF_TRUE" -> out.add("if (" + val(q.arg1, b) + ") goto " + id(q.res) + ";");
            case "FUNC_BEGIN", "FUNC_END", "MAIN_BEGIN", "MAIN_END", "PARAM_DECL", "DECLARE" -> { }
            case "=" -> out.add(asignar(q, b));
            case "+", "-", "*" -> out.add(binaria(q, b));
            case "/" -> out.add(division(q, b));
            case "%" -> out.add(modulo(q, b));
            case "==", "!=" -> out.add(igualdad(q, b));
            case "<", ">", "<=", ">=" -> out.add(comparacion(q, b));
            case "&&", "||" -> out.add(destino(q.res, b) + " = ((" + val(q.arg1, b)
                    + " != 0) " + q.op + " (" + val(q.arg2, b) + " != 0));");
            case "UMINUS" -> out.add(destino(q.res, b) + " = -(" + val(q.arg1, b) + ");");
            case "NOT" -> out.add(destino(q.res, b) + " = !(" + val(q.arg1, b) + ");");
            case "=[]" -> out.add(destino(q.res, b) + " = heap[(int)(("
                    + ref(q.arg1, b) + ") + (" + val(q.arg2, b) + "))];");
            case "[]=" -> out.add("heap[(int)((" + ref(q.arg1, b) + ") + ("
                    + val(q.arg2, b) + "))] = " + val(q.res, b) + ";");
            case "=." -> out.add(campoLeer(q, b));
            case ".=" -> out.add(campoEscribir(q, b));
            case "S.=" -> out.add(serieStructEscribir(q, b));
            case "ALLOC_OBJECT" -> out.add(allocObjeto(q, b));
            case "ALLOC_SERIES" -> out.add(allocSerie(q, b));
            case "PRINT" -> out.add(print(q.arg1, false, b));
            case "PRINTLN" -> out.add(print(q.arg1, true, b));
            case "READ" -> out.addAll(read(q.arg1, b));
            case "RETURN" -> {
                if (q.arg1 != null && !q.arg1.equals("-")) {
                    out.add("stack[(int)P] = " + val(q.arg1, b) + ";");
                }
                out.add("return;");
            }
            default -> out.add("/* cuarteta no soportada: " + q.a3Direcciones() + " */");
        }
        return out;
    }

    private String asignar(Cuarteta q, Bloque b) {
        String dst = q.res;
        String src = q.arg1;
        String td = tipoBase(tipoDe(dst));
        String ts = tipoBase(tipoDe(src));

        if (structLayouts.containsKey(td)) {
            Layout l = structLayouts.get(td);
            String d = val(dst, b);
            if (src.equals("0") || src.equals("NULL")) {
                return "{ double _o = " + d + "; for (int _i = 0; _i < " + l.size
                        + "; _i++) heap[(int)(_o + _i)] = 0; "
                        + refsCampo(l, "_o") + " }";
            }
            String s = val(src, b);
            return "{ double _d = " + d + "; double _s = " + s
                    + "; if (_s >= 0) for (int _i = 0; _i < " + l.size
                    + "; _i++) heap[(int)(_d + _i)] = heap[(int)(_s + _i)]; }";
        }
        if (td.equals("textum") && !ts.equals("textum")) {
            return destino(dst, b) + " = " + aTexto(src, b) + ";";
        }
        if ((td.equals("textum") || td.startsWith("series<") || esClase(td))
                && src.equals("NULL")) {
            return destino(dst, b) + " = -1;";
        }
        return destino(dst, b) + " = " + val(src, b) + ";";
    }

    private String refsCampo(Layout l, String base) {
        StringBuilder sb = new StringBuilder();
        for (Campo c : l.campos) {
            if (c.inline) continue;
            if (esReferencia(c.tipo)) {
                sb.append("heap[(int)(").append(base).append(" + ")
                        .append(c.offset).append(")] = -1; ");
            }
        }
        return sb.toString();
    }

    private String binaria(Cuarteta q, Bloque b) {
        String td = tipoBase(tipoDe(q.res));
        if (td.equals("textum") && q.op.equals("+")) {
            return destino(q.res, b) + " = S_concat(" + aTexto(q.arg1, b)
                    + ", " + aTexto(q.arg2, b) + ");";
        }
        return destino(q.res, b) + " = " + val(q.arg1, b) + " " + q.op + " "
                + val(q.arg2, b) + ";";
    }

    private String division(Cuarteta q, Bloque b) {
        String td = tipoBase(tipoDe(q.res));
        if (td.equals("numerus")) {
            return destino(q.res, b) + " = (double)((int)(" + val(q.arg1, b)
                    + ") / (int)(" + val(q.arg2, b) + "));";
        }
        return destino(q.res, b) + " = " + val(q.arg1, b) + " / "
                + val(q.arg2, b) + ";";
    }

    private String modulo(Cuarteta q, Bloque b) {
        String td = tipoBase(tipoDe(q.res));
        if (td.equals("numerus")) {
            return destino(q.res, b) + " = (double)((int)(" + val(q.arg1, b)
                    + ") % (int)(" + val(q.arg2, b) + "));";
        }
        return destino(q.res, b) + " = fmod(" + val(q.arg1, b) + ", "
                + val(q.arg2, b) + ");";
    }

    private String igualdad(Cuarteta q, Bloque b) {
        String ta = tipoBase(tipoDe(q.arg1));
        String tb = tipoBase(tipoDe(q.arg2));
        String cmp;
        if (ta.equals("textum") || tb.equals("textum")
                || ta.equals("null") || tb.equals("null")) {
            String a = ta.equals("textum") || ta.equals("null")
                    ? val(q.arg1, b) : aTexto(q.arg1, b);
            String c = tb.equals("textum") || tb.equals("null")
                    ? val(q.arg2, b) : aTexto(q.arg2, b);
            cmp = "S_cmp(" + a + ", " + c + ")";
        } else {
            cmp = "(" + val(q.arg1, b) + " " + q.op + " " + val(q.arg2, b) + ")";
            return destino(q.res, b) + " = " + cmp + ";";
        }
        return destino(q.res, b) + " = (" + cmp
                + (q.op.equals("==") ? " == 0" : " != 0") + ");";
    }

    private String comparacion(Cuarteta q, Bloque b) {
        String ta = tipoBase(tipoDe(q.arg1));
        String tb = tipoBase(tipoDe(q.arg2));
        if (ta.equals("textum") || tb.equals("textum")) {
            String a = ta.equals("textum") ? val(q.arg1, b) : aTexto(q.arg1, b);
            String c = tb.equals("textum") ? val(q.arg2, b) : aTexto(q.arg2, b);
            return destino(q.res, b) + " = (S_cmp(" + a + ", " + c + ") "
                    + q.op + " 0);";
        }
        return destino(q.res, b) + " = (" + val(q.arg1, b) + " " + q.op + " "
                + val(q.arg2, b) + ");";
    }

    private String campoLeer(Cuarteta q, Bloque b) {
        String base = q.arg1;
        String nombreCampo = q.arg2;
        Campo c = campo(tipoDe(base), nombreCampo);
        if (c == null) return "/* campo no encontrado: " + base + "." + nombreCampo + " */";
        return destino(q.res, b) + " = heap[(int)((" + val(base, b)
                + ") + " + c.offset + ")];";
    }

    private String campoEscribir(Cuarteta q, Bloque b) {
        String base = q.arg1;
        String nombreCampo = q.arg2;
        Campo c = campo(tipoDe(base), nombreCampo);
        if (c == null) return "/* campo no encontrado: " + base + "." + nombreCampo + " */";
        return "heap[(int)((" + val(base, b) + ") + " + c.offset + ")] = "
                + val(q.res, b) + ";";
    }

    private String serieStructEscribir(Cuarteta q, Bloque b) {
        String expr = q.arg1;
        int lb = expr.lastIndexOf('[');
        if (lb <= 0 || !expr.endsWith("]")) {
            return "/* S.= no soportado: " + q.a3Direcciones() + " */";
        }
        String base = expr.substring(0, lb);
        String idx = expr.substring(lb + 1, expr.length() - 1);
        String elemTipo = elementoDe(tipoDe(base));
        Campo c = campo(elemTipo, q.arg2);
        if (c == null) return "/* campo no encontrado: " + q.arg2 + " */";
        String elem = "heap[(int)((" + ref(base, b) + ") + (" + val(idx, b) + "))]";
        String dir = c.inline ? "(" + elem + " + " + c.offset + ")"
                : "heap[(int)((" + elem + ") + " + c.offset + ")]";
        return "heap[(int)(" + dir + ")] = " + val(q.res, b) + ";";
    }

    private String allocObjeto(Cuarteta q, Bloque b) {
        String tipo = tipoBase(q.arg1);
        Layout l = layout(tipo);
        if (l == null) return "/* tipo desconocido: " + tipo + " */";
        String tmp = nuevoC("_o");
        StringBuilder sb = new StringBuilder();
        sb.append("{ double ").append(tmp).append(" = h_alloc(").append(l.size)
                .append("); ").append(destino(q.res, b)).append(" = ").append(tmp)
                .append("; ");
        if (l.clase) {
            sb.append("heap[(int)").append(tmp).append("] = ").append(l.classId).append("; ");
        }
        for (Campo c : l.campos) {
            if (!c.inline && esReferencia(c.tipo)) {
                sb.append("heap[(int)(").append(tmp).append(" + ").append(c.offset)
                        .append(")] = -1; ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private String allocSerie(Cuarteta q, Bloque b) {
        String n = val(q.arg2, b);
        String tmp = nuevoC("_a");
        StringBuilder sb = new StringBuilder();
        sb.append("{ double ").append(tmp).append(" = h_alloc(").append(n).append("); ")
                .append(destino(q.res, b)).append(" = ").append(tmp).append("; ");
        if (esReferencia(elementoDe(q.arg1))) {
            sb.append("for (int _i = 0; _i < (int)(").append(n)
                    .append("); _i++) heap[(int)(").append(tmp).append(" + _i)] = -1; ");
        }
        sb.append("}");
        return sb.toString();
    }

    private List<String> traducirCall(Cuarteta q, List<String> params, Bloque b) {
        List<String> out = new ArrayList<>();
        String target = q.arg1;
        if (target != null && target.equals("leer")) {
            if (q.res != null && !q.res.equals("-")) {
                out.add(destino(q.res, b) + " = leer_linea();");
            }
            return out;
        }
        if (!funcionesPorNombre.containsKey(target)) {
            out.add("/* llamada no definida: " + target + " */");
            return out;
        }
        String viejo = nuevoC("_p");
        String base = nuevoC("_b");
        StringBuilder sb = new StringBuilder();
        sb.append("{ double ").append(viejo).append(" = P; double ").append(base)
                .append(" = ").append(viejo).append(" + ").append(b.frameSize).append("; ");
        for (int i = 0; i < params.size(); i++) {
            sb.append("stack[(int)(").append(base).append(" + ").append(i + 1)
                    .append(")] = ").append(val(params.get(i), b)).append("; ");
        }
        sb.append("P = ").append(base).append("; ").append(id(target))
                .append("(); P = ").append(viejo).append("; ");
        if (q.res != null && !q.res.equals("-")) {
            sb.append(destino(q.res, b)).append(" = stack[(int)").append(base).append("]; ");
        }
        sb.append("}");
        out.add(sb.toString());
        return out;
    }

    private String print(String lugar, boolean salto, Bloque b) {
        String t = tipoBase(tipoDe(lugar));
        String v = val(lugar, b);
        String nl = salto ? "\\n" : "";
        switch (t) {
            case "bool":
                return "printf(\"%s" + nl + "\", ((int)(" + v + ")) ? \"verum\" : \"falsus\");";
            case "numerus":
                return "printf(\"%d" + nl + "\", (int)(" + v + "));";
            case "decimalis":
                return salto
                        ? "{ print_double(" + v + "); printf(\"\\n\"); }"
                        : "print_double(" + v + ");";
            case "littera":
                return "printf(\"%c" + nl + "\", (char)((int)(" + v + ")));";
            case "textum":
                return salto
                        ? "{ print_str(" + v + "); printf(\"\\n\"); }"
                        : "print_str(" + v + ");";
            case "null":
                if (lugar != null && lugar.equals("NULL")) {
                    return "printf(\"(null)" + nl + "\");";
                }
                return salto
                        ? "{ print_str(" + v + "); printf(\"\\n\"); }"
                        : "print_str(" + v + ");";
            default:
                if (t.startsWith("series<")) return "/* print de " + t + " no soportado */";
                if (esClase(t)) return "/* print de objeto " + t + " no soportado */";
                return salto
                        ? "{ print_str(" + v + "); printf(\"\\n\"); }"
                        : "print_str(" + v + ");";
        }
    }

    private List<String> read(String nombre, Bloque b) {
        List<String> out = new ArrayList<>();
        if (nombre == null || nombre.equals("_") || nombre.equals("-")) {
            out.add("read_linea_descartar();");
            return out;
        }
        String dst = destino(nombre, b);
        String t = tipoBase(tipoDe(nombre));
        switch (t) {
            case "numerus" -> out.add(dst + " = read_int();");
            case "decimalis" -> out.add(dst + " = read_double();");
            case "littera" -> out.add(dst + " = read_char();");
            case "bool" -> out.add(dst + " = read_bool();");
            case "textum" -> out.add(dst + " = leer_linea();");
            default -> out.add("/* read no soportado para " + t + " */");
        }
        return out;
    }

    private void emitirRuntime(StringBuilder c) {
        c.append("static void *heap_alloc(size_t n) {\n");
        c.append("    void *p = calloc(1, n);\n");
        c.append("    if (!p) { fprintf(stderr, \"sin memoria (heap)\\n\"); exit(1); }\n");
        c.append("    return p;\n");
        c.append("}\n");
        c.append("static double h_alloc(double n) {\n");
        c.append("    if (n < 0) n = 0;\n");
        c.append("    double p = H;\n");
        c.append("    H += n;\n");
        c.append("    if (H >= HEAP_SIZE) { fprintf(stderr, \"sin memoria (heap)\\n\"); exit(1); }\n");
        c.append("    for (int i = 0; i < (int)n; i++) heap[(int)p + i] = 0;\n");
        c.append("    return p;\n");
        c.append("}\n");
        c.append("static double str_lit(const char *s) {\n");
        c.append("    if (!s) s = \"\";\n");
        c.append("    int n = (int)strlen(s);\n");
        c.append("    double p = h_alloc(n + 1);\n");
        c.append("    for (int i = 0; i < n; i++) heap[(int)p + i] = (unsigned char)s[i];\n");
        c.append("    heap[(int)p + n] = -1;\n");
        c.append("    return p;\n");
        c.append("}\n");
        c.append("static void print_str(double p) {\n");
        c.append("    if (p < 0) return;\n");
        c.append("    for (int i = 0; (int)p + i < HEAP_SIZE; i++) {\n");
        c.append("        double ch = heap[(int)p + i];\n");
        c.append("        if (ch == -1) break;\n");
        c.append("        putchar((int)ch);\n");
        c.append("    }\n");
        c.append("}\n");
        c.append("static int S_cmp(double a, double b) {\n");
        c.append("    if (a < 0 && b < 0) return 0;\n");
        c.append("    if (a < 0) return -1;\n");
        c.append("    if (b < 0) return 1;\n");
        c.append("    int i = 0;\n");
        c.append("    while (heap[(int)a + i] != -1 && heap[(int)b + i] != -1) {\n");
        c.append("        int ca = (int)heap[(int)a + i];\n");
        c.append("        int cb = (int)heap[(int)b + i];\n");
        c.append("        if (ca != cb) return ca - cb;\n");
        c.append("        i++;\n");
        c.append("    }\n");
        c.append("    return (int)heap[(int)a + i] - (int)heap[(int)b + i];\n");
        c.append("}\n");
        c.append("static double S_concat(double a, double b) {\n");
        c.append("    int na = 0, nb = 0;\n");
        c.append("    if (a >= 0) while (heap[(int)a + na] != -1) na++;\n");
        c.append("    if (b >= 0) while (heap[(int)b + nb] != -1) nb++;\n");
        c.append("    double r = h_alloc((double)(na + nb + 1));\n");
        c.append("    for (int i = 0; i < na; i++) heap[(int)r + i] = heap[(int)a + i];\n");
        c.append("    for (int i = 0; i < nb; i++) heap[(int)r + na + i] = heap[(int)b + i];\n");
        c.append("    heap[(int)r + na + nb] = -1;\n");
        c.append("    return r;\n");
        c.append("}\n");
        c.append("static void fmt_double(char *b, size_t n, double v) {\n");
        c.append("    if (v == (long long)v && v > -1e15 && v < 1e15) snprintf(b, n, \"%lld.0\", (long long)v);\n");
        c.append("    else snprintf(b, n, \"%g\", v);\n");
        c.append("}\n");
        c.append("static void print_double(double v) {\n");
        c.append("    char b[64]; fmt_double(b, sizeof b, v); printf(\"%s\", b);\n");
        c.append("}\n");
        c.append("static double S_of_int(double v) {\n");
        c.append("    char b[32]; snprintf(b, sizeof b, \"%d\", (int)v); return str_lit(b);\n");
        c.append("}\n");
        c.append("static double S_of_double(double v) {\n");
        c.append("    char b[64]; fmt_double(b, sizeof b, v); return str_lit(b);\n");
        c.append("}\n");
        c.append("static double S_of_char(double v) {\n");
        c.append("    char b[2]; b[0] = (char)((int)v); b[1] = '\\0'; return str_lit(b);\n");
        c.append("}\n");
        c.append("static double S_of_bool(double v) {\n");
        c.append("    return str_lit(((int)v) ? \"verum\" : \"falsus\");\n");
        c.append("}\n");
        c.append("static double leer_linea(void) {\n");
        c.append("    char *l = NULL; size_t n = 0;\n");
        c.append("    if (getline(&l, &n, stdin) < 0) { free(l); return str_lit(\"\"); }\n");
        c.append("    l[strcspn(l, \"\\r\\n\")] = '\\0';\n");
        c.append("    double p = str_lit(l); free(l); return p;\n");
        c.append("}\n");
        c.append("static void read_linea_descartar(void) {\n");
        c.append("    char *l = NULL; size_t n = 0;\n");
        c.append("    if (getline(&l, &n, stdin) < 0) { free(l); return; }\n");
        c.append("    free(l);\n");
        c.append("}\n");
        c.append("static void limpiar_linea(void) {\n");
        c.append("    int c; while ((c = getchar()) != '\\n' && c != EOF) { }\n");
        c.append("}\n");
        c.append("static double read_int(void) {\n");
        c.append("    int v = 0; if (scanf(\"%d\", &v) != 1) { limpiar_linea(); return 0; }\n");
        c.append("    limpiar_linea(); return v;\n");
        c.append("}\n");
        c.append("static double read_double(void) {\n");
        c.append("    double v = 0; if (scanf(\"%lf\", &v) != 1) { limpiar_linea(); return 0; }\n");
        c.append("    limpiar_linea(); return v;\n");
        c.append("}\n");
        c.append("static double read_char(void) {\n");
        c.append("    char v = 0; scanf(\" %c\", &v); return (unsigned char)v;\n");
        c.append("}\n");
        c.append("static double read_bool(void) {\n");
        c.append("    int v = 0; scanf(\"%d\", &v); return v ? 1 : 0;\n");
        c.append("}\n");
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
