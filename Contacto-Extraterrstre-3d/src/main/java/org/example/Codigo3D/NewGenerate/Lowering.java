package org.example.Codigo3D.NewGenerate;

import org.example.Codigo3D.Cuarteta;
import org.example.Ejecutor.ClaseZ;
import org.example.Semantico.StructSimbolo;
import org.example.Semantico.Tipo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lowering {

    private final List<Cuarteta> quads;
    private final Map<String, String> tipoTempBase;
    private final Map<String, String> tipoVar;
    private final List<String[]> globales;
    private final Map<String, ClaseZ> clases;
    private final Map<String, StructSimbolo> structsY;

    private final Map<String, String> tipoTemp = new LinkedHashMap<>();
    private final Map<String, Integer> globalSlots = new LinkedHashMap<>();
    private final Map<String, String> globalTypes = new LinkedHashMap<>();
    private final Map<String, Layout> classLayouts = new LinkedHashMap<>();
    private final Map<String, Layout> structLayouts = new LinkedHashMap<>();
    private final Map<String, String> literalTemps = new LinkedHashMap<>();
    private final List<Block> blocks = new ArrayList<>();
    private final List<Cuarteta> initGlobales = new ArrayList<>();

    private C3DProgram out;
    private Block main;
    private Block current;
    private int lineCounter;

    public Lowering(List<Cuarteta> quads,
                    Map<String, String> tipoTemp,
                    Map<String, String> tipoVar,
                    List<String[]> globales,
                    Map<String, ClaseZ> clases,
                    Map<String, StructSimbolo> structsY) {
        this.quads = quads == null ? List.of() : quads;
        this.tipoTempBase = tipoTemp == null ? Map.of() : tipoTemp;
        this.tipoTemp.putAll(this.tipoTempBase);
        this.tipoVar = tipoVar == null ? Map.of() : tipoVar;
        this.globales = globales == null ? List.of() : globales;
        this.clases = clases == null ? Map.of() : clases;
        this.structsY = structsY == null ? Map.of() : structsY;
    }

    public C3DProgram lower() {
        prepararLayouts();
        prepararGlobales();
        agrupar();
        prepararSlots();
        out = new C3DProgram(maxTemp() + 1, maxLabel() + 1);
        recogerLiterales();
        Block mainBlock = null;
        for (Block b : blocks) {
            if (b.main) {
                mainBlock = b;
                break;
            }
        }
        if (mainBlock != null) {
            emitBlock(mainBlock);
        }
        for (Block b : blocks) {
            if (!b.main) {
                emitBlock(b);
            }
        }
        return out;
    }

    private void prepararGlobales() {
        for (String[] g : globales) {
            if (g == null || g.length < 2 || g[1] == null) continue;
            if (!globalSlots.containsKey(g[1])) {
                globalSlots.put(g[1], globalSlots.size());
                globalTypes.put(g[1], g[0] == null ? "numerus" : g[0]);
            }
        }
    }

    private int maxTemp() {
        int max = -1;
        for (String t : tipoTempBase.keySet()) {
            max = Math.max(max, numero(t, "t"));
        }
        for (Cuarteta q : quads) {
            max = Math.max(max, numero(q.arg1, "t"));
            max = Math.max(max, numero(q.arg2, "t"));
            max = Math.max(max, numero(q.res, "t"));
        }
        return Math.max(max, 0);
    }

    private int maxLabel() {
        int max = -1;
        for (Cuarteta q : quads) {
            if ("LABEL".equals(q.op)) max = Math.max(max, numero(q.arg1, "L"));
            if ("GOTO".equals(q.op)) max = Math.max(max, numero(q.arg1, "L"));
            if ("IF_FALSE".equals(q.op) || "IF_TRUE".equals(q.op)) max = Math.max(max, numero(q.res, "L"));
        }
        return Math.max(max, 0);
    }

    private int numero(String s, String prefijo) {
        if (s == null || !s.startsWith(prefijo)) return -1;
        try {
            return Integer.parseInt(s.substring(prefijo.length()));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void agrupar() {
        for (Cuarteta q : quads) {
            switch (q.op) {
                case "FUNC_BEGIN": {
                    Block b = new Block(q.arg1, false);
                    b.ret = q.arg2 == null || q.arg2.equals("-") ? "void" : q.arg2;
                    blocks.add(b);
                    current = b;
                    break;
                }
                case "FUNC_END":
                    current = null;
                    break;
                case "MAIN_BEGIN": {
                    main = new Block("main", true);
                    blocks.add(main);
                    current = main;
                    break;
                }
                case "MAIN_END":
                    current = null;
                    break;
                case "PARAM_DECL":
                    if (current != null) {
                        current.params.add(new String[]{q.arg1, q.res});
                        current.tipos.put(q.res, q.arg1);
                        current.declarados.add(q.res);
                    }
                    break;
                case "DECLARE":
                    if (current != null) {
                        current.tipos.put(q.res, q.arg1);
                        if (!current.declarados.contains(q.res)) {
                            current.declarados.add(q.res);
                            current.vars.add(new String[]{q.arg1, q.res});
                        }
                    }
                    break;
                default:
                    if (current != null) {
                        current.body.add(q);
                    } else {
                        initGlobales.add(q);
                    }
                    break;
            }
        }
    }

    private void prepararSlots() {
        for (Block b : blocks) {
            asignarSlots(b);
        }
    }

    private void asignarSlots(Block b) {
        int off = 1;
        for (String[] p : b.params) {
            if (!b.slots.containsKey(p[1])) b.slots.put(p[1], off++);
        }
        b.paramCount = off - 1;
        for (String[] v : b.vars) {
            if (!b.slots.containsKey(v[1])) b.slots.put(v[1], off++);
        }
        b.frameSize = Math.max(1, off);
    }

    private void recogerLiterales() {
        for (Cuarteta q : quads) {
            recogerLiteral(q.arg1);
            recogerLiteral(q.arg2);
            recogerLiteral(q.res);
        }
        if (!literalTemps.containsKey("\"(null)\"")) {
            literalTemps.put("\"(null)\"", newTemp("textum"));
        }
    }

    private void recogerLiteral(String s) {
        if (s == null || !s.startsWith("\"")) return;
        if (literalTemps.containsKey(s)) return;
        literalTemps.put(s, newTemp("textum"));
    }

    private void emitBlock(Block b) {
        current = b;
        if (b.main) {
            emit(OpCode.LABEL, "", "", "main_entry", "inicio del maior");
            emitLiterals();
            emit(OpCode.ASSIGN, String.valueOf(globalSlots.size()), "", "P", "P = globales");
            for (Map.Entry<String, String> g : globalTypes.entrySet()) {
                initLugar(g.getKey(), g.getValue(), true);
            }
            body(initGlobales);
            prologueVars(b);
            body(b.body);
            emit(OpCode.NOP, "", "", "", "fin del maior");
        } else {
            emit(OpCode.LABEL, "", "", b.nombre, "funcion");
            prologueVars(b);
            body(b.body);
            emit(OpCode.NOP, "", "", "", "fin " + b.nombre);
        }
    }

    private void emitLiterals() {
        for (Map.Entry<String, String> e : literalTemps.entrySet()) {
            String lit = e.getKey();
            String ptr = e.getValue();
            List<Integer> chars = decodificar(lit);
            emit(OpCode.ASSIGN, "H", "", ptr, "literal");
            for (int i = 0; i < chars.size(); i++) {
                emit(OpCode.HEAP_WRITE, ptr + " + " + i, String.valueOf(chars.get(i)), "", "literal");
            }
            emit(OpCode.HEAP_WRITE, ptr + " + " + chars.size(), "-1", "", "fin literal");
            emit(OpCode.ADD, "H", String.valueOf(chars.size() + 1), "H", "");
        }
    }

    private List<Integer> decodificar(String lit) {
        List<Integer> outChars = new ArrayList<>();
        if (lit == null || lit.length() < 2) return outChars;
        String s = lit.substring(1, lit.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' && i + 1 < s.length()) {
                char n = s.charAt(++i);
                switch (n) {
                    case 'n': outChars.add((int) '\n'); break;
                    case 't': outChars.add((int) '\t'); break;
                    case 'r': outChars.add((int) '\r'); break;
                    case '\\': outChars.add((int) '\\'); break;
                    case '"': outChars.add((int) '"'); break;
                    case '\'': outChars.add((int) '\''); break;
                    case '0': outChars.add(0); break;
                    default: outChars.add((int) n); break;
                }
            } else {
                outChars.add((int) c);
            }
        }
        return outChars;
    }

    private void prologueVars(Block b) {
        for (String[] v : b.vars) {
            initLugar(v[1], v[0], false);
        }
    }

    private void initLugar(String nombre, String tipo, boolean global) {
        String tb = tipoBase(tipo);
        if (structLayouts.containsKey(tb)) {
            Layout l = structLayouts.get(tb);
            String ptr = newTemp("struct");
            emit(OpCode.ASSIGN, "H", "", ptr, "struct " + tb);
            emit(OpCode.ADD, "H", String.valueOf(l.size), "H", "");
            storeLugar(nombre, ptr, global);
            for (Campo c : l.campos) {
                if (c.inline) continue;
                if (esReferencia(c.tipo)) {
                    emit(OpCode.HEAP_WRITE, ptr + " + " + c.offset, "-1", "", "");
                }
            }
        } else if (esReferencia(tb)) {
            storeLugar(nombre, "-1", global);
        } else {
            storeLugar(nombre, "0", global);
        }
    }

    private void body(List<Cuarteta> lista) {
        List<String> params = new ArrayList<>();
        for (Cuarteta q : lista) {
            if ("PARAM".equals(q.op)) {
                params.add(q.arg1);
                continue;
            }
            if ("CALL".equals(q.op)) {
                emitCall(q, params);
                params.clear();
                continue;
            }
            traducir(q);
        }
    }

    private void traducir(Cuarteta q) {
        switch (q.op) {
            case "LABEL":
                emit(OpCode.LABEL, "", "", q.arg1, q.comentario);
                break;
            case "GOTO":
                emit(OpCode.GOTO, "", "", q.arg1, q.comentario);
                break;
            case "IF_FALSE":
                emit(OpCode.IF_FALSE, val(q.arg1), "", q.res, q.comentario);
                break;
            case "IF_TRUE":
                emit(OpCode.IF_TRUE, val(q.arg1), "", q.res, q.comentario);
                break;
            case "=":
                asignar(q);
                break;
            case "+":
                suma(q);
                break;
            case "-":
                binaria(q, OpCode.SUB);
                break;
            case "*":
                binaria(q, OpCode.MULT);
                break;
            case "/":
                binaria(q, OpCode.DIV, esNumerus(tipoDe(q.res)) ? "int" : "");
                break;
            case "%":
                binaria(q, OpCode.MOD, esNumerus(tipoDe(q.res)) ? "int" : "");
                break;
            case "==":
            case "!=":
                igualdad(q);
                break;
            case "<":
            case ">":
            case "<=":
            case ">=":
                comparacion(q);
                break;
            case "&&":
                binaria(q, OpCode.AND);
                break;
            case "||":
                binaria(q, OpCode.OR);
                break;
            case "UMINUS": {
                String v = val(q.arg1);
                String t = newTemp(tipoDe(q.res));
                emit(OpCode.SUB, "0", v, t, "");
                storeLugar(q.res, t, false);
                break;
            }
            case "NOT": {
                String v = val(q.arg1);
                String t = newTemp(tipoDe(q.res));
                emit(OpCode.NOT, v, "", t, "");
                storeLugar(q.res, t, false);
                break;
            }
            case "=[]": {
                String v = readIndex(q.arg1, q.arg2);
                storeLugar(q.res, v, false);
                break;
            }
            case "[]=": {
                String base = refLugar(q.arg1);
                String idx = val(q.arg2);
                String addr = add(base, idx);
                emit(OpCode.HEAP_WRITE, addr, val(q.res), "", "");
                break;
            }
            case "=.": {
                readField(q.arg1, q.arg2, q.res);
                break;
            }
            case ".=": {
                writeField(q.arg1, q.arg2, q.res);
                break;
            }
            case "S.=": {
                writeStructIndexField(q);
                break;
            }
            case "ALLOC_SERIES":
                allocSeries(q);
                break;
            case "ALLOC_OBJECT":
                allocObject(q);
                break;
            case "PRINT":
                print(q.arg1, false);
                break;
            case "PRINTLN":
                print(q.arg1, true);
                break;
            case "READ":
                read(q.arg1);
                break;
            case "RETURN": {
                if (q.arg1 != null && !q.arg1.equals("-")) {
                    String v = val(q.arg1);
                    emit(OpCode.STACK_WRITE, "P", v, "", "");
                }
                emit(OpCode.RETURN, "", "", "", q.comentario);
                break;
            }
            case "DECLARE":
            case "PARAM_DECL":
            case "FUNC_BEGIN":
            case "FUNC_END":
            case "MAIN_BEGIN":
            case "MAIN_END":
            case "STRUCT_DEF":
            case "STRUCT_FIELD":
            case "STRUCT_INIT_BEGIN":
            case "STRUCT_INIT_END":
                break;
            case "STRUCT_SET":
                writeField(q.arg1, q.arg2, q.res);
                break;
            default:
                emit(OpCode.NOP, "", "", "", "no soportada: " + q.a3Direcciones());
                break;
        }
    }

    private boolean esNumerus(String t) {
        return "numerus".equals(tipoBase(t));
    }

    private void suma(Cuarteta q) {
        if ("textum".equals(tipoBase(tipoDe(q.res)))) {
            String a = aTexto(q.arg1);
            String b = aTexto(q.arg2);
            String t = newTemp("textum");
            emit(OpCode.CONCAT_STR, a, b, t, "str_str");
            storeLugar(q.res, t, false);
            return;
        }
        binaria(q, OpCode.ADD);
    }

    private void binaria(Cuarteta q, OpCode op) {
        binaria(q, op, "");
    }

    private void binaria(Cuarteta q, OpCode op, String comment) {
        String a = val(q.arg1);
        String b = val(q.arg2);
        String t = newTemp(tipoDe(q.res));
        emit(op, a, b, t, comment);
        storeLugar(q.res, t, false);
    }

    private void igualdad(Cuarteta q) {
        String ta = tipoBase(tipoDe(q.arg1));
        String tb = tipoBase(tipoDe(q.arg2));
        if (ta.equals("textum") || tb.equals("textum")
                || ta.equals("null") || tb.equals("null")) {
            String a = esTextoONull(ta) ? val(q.arg1) : aTexto(q.arg1);
            String b = esTextoONull(tb) ? val(q.arg2) : aTexto(q.arg2);
            String cmp = newTemp("numerus");
            emit(OpCode.CMP_STR, a, b, cmp, "");
            String t = newTemp("bool");
            emit("==".equals(q.op) ? OpCode.EQ : OpCode.NEQ, cmp, "0", t, "");
            storeLugar(q.res, t, false);
            return;
        }
        binaria(q, "==".equals(q.op) ? OpCode.EQ : OpCode.NEQ);
    }

    private void comparacion(Cuarteta q) {
        String ta = tipoBase(tipoDe(q.arg1));
        String tb = tipoBase(tipoDe(q.arg2));
        if (ta.equals("textum") || tb.equals("textum")) {
            String a = ta.equals("textum") ? val(q.arg1) : aTexto(q.arg1);
            String b = tb.equals("textum") ? val(q.arg2) : aTexto(q.arg2);
            String cmp = newTemp("numerus");
            emit(OpCode.CMP_STR, a, b, cmp, "");
            String t = newTemp("bool");
            emit(opDe(q.op), cmp, "0", t, "");
            storeLugar(q.res, t, false);
            return;
        }
        binaria(q, opDe(q.op));
    }

    private OpCode opDe(String op) {
        switch (op) {
            case "<": return OpCode.LT;
            case ">": return OpCode.GT;
            case "<=": return OpCode.LE;
            case ">=": return OpCode.GE;
            case "==": return OpCode.EQ;
            case "!=": return OpCode.NEQ;
            default: return OpCode.NOP;
        }
    }

    private boolean esTextoONull(String t) {
        return t.equals("textum") || t.equals("null");
    }

    private void asignar(Cuarteta q) {
        String td = tipoBase(tipoDe(q.res));
        String ts = tipoBase(tipoDe(q.arg1));
        if (structLayouts.containsKey(td)) {
            Layout l = structLayouts.get(td);
            String d = val(q.res);
            if ("NULL".equals(q.arg1) || "0".equals(q.arg1)) {
                for (int i = 0; i < l.size; i++) {
                    emit(OpCode.HEAP_WRITE, d + " + " + i, "0", "", "");
                }
                for (Campo c : l.campos) {
                    if (!c.inline && esReferencia(c.tipo)) {
                        emit(OpCode.HEAP_WRITE, d + " + " + c.offset, "-1", "", "");
                    }
                }
            } else {
                String s = val(q.arg1);
                String cond = newTemp("bool");
                emit(OpCode.GE, s, "0", cond, "");
                String fin = newLabel();
                emit(OpCode.IF_FALSE, cond, "", fin, "");
                for (int i = 0; i < l.size; i++) {
                    String cell = heapRead(add(s, String.valueOf(i)));
                    emit(OpCode.HEAP_WRITE, d + " + " + i, cell, "", "");
                }
                emit(OpCode.LABEL, "", "", fin, "");
            }
            return;
        }
        if (td.equals("textum") && !ts.equals("textum")) {
            String s = aTexto(q.arg1);
            storeLugar(q.res, s, false);
            return;
        }
        String v = val(q.arg1);
        storeLugar(q.res, v, false);
    }

    private void readField(String base, String campo, String res) {
        Campo c = campo(tipoDeLugar(base), campo);
        if (c == null) {
            emit(OpCode.NOP, "", "", "", "campo no encontrado: " + base + "." + campo);
            return;
        }
        String b = refLugar(base);
        String addr = add(b, String.valueOf(c.offset));
        String v = heapRead(addr);
        storeLugar(res, v, false);
    }

    private void writeField(String base, String campo, String valor) {
        Campo c = campo(tipoDeLugar(base), campo);
        if (c == null) {
            emit(OpCode.NOP, "", "", "", "campo no encontrado: " + base + "." + campo);
            return;
        }
        String b = refLugar(base);
        String addr = add(b, String.valueOf(c.offset));
        emit(OpCode.HEAP_WRITE, addr, val(valor), "", "");
    }

    private void writeStructIndexField(Cuarteta q) {
        String expr = q.arg1;
        int lb = expr == null ? -1 : expr.lastIndexOf('[');
        if (lb <= 0 || !expr.endsWith("]")) {
            emit(OpCode.NOP, "", "", "", "S.= no soportado");
            return;
        }
        String base = expr.substring(0, lb);
        String idx = expr.substring(lb + 1, expr.length() - 1);
        String elemTipo = elementoDe(tipoDeLugar(base));
        Campo c = campo(elemTipo, q.arg2);
        if (c == null) {
            emit(OpCode.NOP, "", "", "", "campo no encontrado: " + q.arg2);
            return;
        }
        String baseRef = refLugar(base);
        String idxVal = val(idx);
        String elem = heapRead(add(baseRef, idxVal));
        if (c.inline) {
            String dir = add(elem, String.valueOf(c.offset));
            emit(OpCode.HEAP_WRITE, dir, val(q.res), "", "");
        } else {
            String dir = heapRead(add(elem, String.valueOf(c.offset)));
            emit(OpCode.HEAP_WRITE, dir, val(q.res), "", "");
        }
    }

    private String readIndex(String base, String idx) {
        String b = refLugar(base);
        String i = val(idx);
        String addr = add(b, i);
        return heapRead(addr);
    }

    private void allocSeries(Cuarteta q) {
        String elemTipo = tipoBase(q.arg1);
        String n = val(q.arg2);
        String ptr = newTemp("series");
        emit(OpCode.ASSIGN, "H", "", ptr, "alloc_series " + elemTipo);
        emit(OpCode.ADD, "H", n, "H", "");
        storeLugar(q.res, ptr, false);
        if (esReferencia(elemTipo)) {
            String i = newTemp("numerus");
            emit(OpCode.ASSIGN, "0", "", i, "");
            String ini = newLabel();
            String fin = newLabel();
            emit(OpCode.LABEL, "", "", ini, "");
            String cond = newTemp("bool");
            emit(OpCode.LT, i, n, cond, "");
            emit(OpCode.IF_FALSE, cond, "", fin, "");
            String addr = add(ptr, i);
            emit(OpCode.HEAP_WRITE, addr, "-1", "", "");
            emit(OpCode.ADD, i, "1", i, "");
            emit(OpCode.GOTO, "", "", ini, "");
            emit(OpCode.LABEL, "", "", fin, "");
        }
    }

    private void allocObject(Cuarteta q) {
        String tipo = tipoBase(q.arg1);
        Layout l = layout(tipo);
        if (l == null) {
            emit(OpCode.NOP, "", "", "", "tipo desconocido: " + tipo);
            return;
        }
        String ptr = newTemp("class");
        emit(OpCode.ASSIGN, "H", "", ptr, "new " + tipo);
        emit(OpCode.ADD, "H", String.valueOf(l.size), "H", "");
        storeLugar(q.res, ptr, false);
        if (l.clase) {
            emit(OpCode.HEAP_WRITE, ptr, String.valueOf(l.classId), "", "");
        }
        for (Campo c : l.campos) {
            if (!c.inline && esReferencia(c.tipo)) {
                emit(OpCode.HEAP_WRITE, ptr + " + " + c.offset, "-1", "", "");
            }
        }
    }

    private void print(String lugar, boolean salto) {
        String t = tipoBase(tipoDe(lugar));
        String v = val(lugar);
        String mode;
        if (t.equals("textum")) {
            emit(OpCode.PRINT_STR, v, "", "", salto ? "nl" : "");
            return;
        }
        if (t.equals("null")) {
            if ("NULL".equals(lugar)) {
                emit(OpCode.PRINT_STR, literalTemp("\"(null)\""), "", "", salto ? "nl" : "");
            } else {
                emit(OpCode.PRINT_STR, v, "", "", salto ? "nl" : "");
            }
            return;
        }
        switch (t) {
            case "bool": mode = salto ? "bool" : "bool_nonl"; break;
            case "decimalis": mode = salto ? "decimal" : "decimal_nonl"; break;
            case "littera": mode = salto ? "char" : "char_nonl"; break;
            case "numerus": mode = salto ? "" : "nonl"; break;
            default:
                if (t.startsWith("series<") || classLayouts.containsKey(t)) {
                    emit(OpCode.NOP, "", "", "", "print no soportado: " + t);
                    return;
                }
                emit(OpCode.PRINT_STR, v, "", "", salto ? "nl" : "");
                return;
        }
        emit(OpCode.PRINT, v, "", "", mode);
    }

    private void read(String nombre) {
        String t = tipoBase(tipoDe(nombre));
        if (t.equals("textum")) {
            String tmp = newTemp("textum");
            emit(OpCode.READ_STR, "", "", tmp, "");
            storeLugar(nombre, tmp, false);
            return;
        }
        if (t.equals("littera")) {
            String tmp = newTemp("littera");
            emit(OpCode.READ_CHAR, "", "", tmp, "");
            storeLugar(nombre, tmp, false);
            return;
        }
        String tmp = newTemp(t);
        emit(OpCode.READ, "", "", tmp, "");
        storeLugar(nombre, tmp, false);
    }

    private void emitCall(Cuarteta q, List<String> params) {
        String target = q.arg1;
        int frame = current == null ? 1 + params.size() : current.frameSize;
        String oldP = newTemp("numerus");
        String base = newTemp("numerus");
        emit(OpCode.ASSIGN, "P", "", oldP, "");
        emit(OpCode.ADD, oldP, String.valueOf(frame), base, "");
        for (int i = 0; i < params.size(); i++) {
            String v = val(params.get(i));
            emit(OpCode.STACK_WRITE, base + " + " + (i + 1), v, "", "");
        }
        emit(OpCode.ASSIGN, base, "", "P", "");
        emit(OpCode.CALL, target, String.valueOf(params.size()), "", "");
        emit(OpCode.ASSIGN, oldP, "", "P", "");
        if (q.res != null && !q.res.equals("-")) {
            String r = newTemp(tipoDe(q.res));
            emit(OpCode.STACK_READ, base, "", r, "");
            storeLugar(q.res, r, false);
        }
    }

    private String aTexto(String lugar) {
        String t = tipoBase(tipoDe(lugar));
        String v = val(lugar);
        switch (t) {
            case "textum":
                return v;
            case "null":
                return v;
            case "numerus": {
                String tmp = newTemp("textum");
                emit(OpCode.CONCAT_STR, v, "-1", tmp, "int_str");
                return tmp;
            }
            case "decimalis": {
                String tmp = newTemp("textum");
                emit(OpCode.CONCAT_STR, v, "-1", tmp, "dec_str");
                return tmp;
            }
            case "littera": {
                String tmp = newTemp("textum");
                emit(OpCode.CONCAT_STR, v, "-1", tmp, "char_str");
                return tmp;
            }
            case "bool": {
                String tmp = newTemp("textum");
                emit(OpCode.CONCAT_STR, v, "-1", tmp, "bool_str");
                return tmp;
            }
            default:
                return v;
        }
    }

    private String literalTemp(String lit) {
        String t = literalTemps.get(lit);
        if (t == null) {
            t = newTemp("textum");
            literalTemps.put(lit, t);
        }
        return t;
    }

    private String val(String lugar) {
        if (lugar == null || lugar.equals("-") || lugar.equals("_")) return "0";
        if (lugar.equals("P") || lugar.equals("H")) return lugar;
        if (lugar.equals("verum")) return "1";
        if (lugar.equals("falsus")) return "0";
        if (lugar.equals("NULL")) return "-1";
        if (lugar.startsWith("&")) return val(lugar.substring(1));
        if (lugar.startsWith("\"")) return literalTemp(lugar);
        if (lugar.startsWith("'")) return String.valueOf(codigoChar(lugar));
        if (tipoTemp.containsKey(lugar) || esTemp(lugar)) return lugar;
        String offset = stackOffset(lugar, current);
        if (offset != null) {
            String t = newTemp(tipoDe(lugar));
            emit(OpCode.STACK_READ, offset, "", t, "");
            return t;
        }
        if (lugar.contains("->") || lugar.contains(".") || lugar.endsWith("]")) {
            return refLugar(lugar);
        }
        if (esNumero(lugar)) return lugar;
        return lugar;
    }

    private String refLugar(String lugar) {
        if (lugar == null || lugar.equals("-")) return "0";
        if (lugar.startsWith("&")) return refLugar(lugar.substring(1));
        if (lugar.startsWith("\"") || lugar.startsWith("'")) return val(lugar);

        int pArrow = lugar.lastIndexOf("->");
        int pDot = lugar.lastIndexOf('.');
        int p = Math.max(pArrow >= 0 ? pArrow + 2 : -1, pDot >= 0 ? pDot + 1 : -1);
        if (p > 0 && p < lugar.length()) {
            String base;
            if (pArrow >= 0 && p == pArrow + 2) base = lugar.substring(0, pArrow);
            else base = lugar.substring(0, pDot);
            String campo = lugar.substring(p);
            Campo c = campo(tipoDeLugar(base), campo);
            String b = refLugar(base);
            if (c == null) return b;
            String addr = add(b, String.valueOf(c.offset));
            if (c.inline) return addr;
            return heapRead(addr);
        }

        if (lugar.endsWith("]")) {
            int lb = lugar.lastIndexOf('[');
            if (lb > 0) {
                String base = lugar.substring(0, lb);
                String idx = lugar.substring(lb + 1, lugar.length() - 1);
                String b = refLugar(base);
                String i = val(idx);
                return heapRead(add(b, i));
            }
        }
        return val(lugar);
    }

    private void storeLugar(String lugar, String valor, boolean global) {
        if (lugar == null || lugar.equals("-")) return;
        if (lugar.startsWith("&")) {
            storeLugar(lugar.substring(1), valor, global);
            return;
        }
        if (esTemp(lugar)) {
            emit(OpCode.ASSIGN, valor, "", lugar, "");
            return;
        }
        int pArrow = lugar.lastIndexOf("->");
        int pDot = lugar.lastIndexOf('.');
        int p = Math.max(pArrow >= 0 ? pArrow + 2 : -1, pDot >= 0 ? pDot + 1 : -1);
        if (p > 0 && p < lugar.length()) {
            String base;
            if (pArrow >= 0 && p == pArrow + 2) base = lugar.substring(0, pArrow);
            else base = lugar.substring(0, pDot);
            String campo = lugar.substring(p);
            Campo c = campo(tipoDeLugar(base), campo);
            if (c == null) return;
            String b = refLugar(base);
            String addr = add(b, String.valueOf(c.offset));
            emit(OpCode.HEAP_WRITE, addr, valor, "", "");
            return;
        }
        if (lugar.endsWith("]")) {
            int lb = lugar.lastIndexOf('[');
            if (lb > 0) {
                String base = lugar.substring(0, lb);
                String idx = lugar.substring(lb + 1, lugar.length() - 1);
                String b = refLugar(base);
                String i = val(idx);
                String addr = add(b, i);
                emit(OpCode.HEAP_WRITE, addr, valor, "", "");
                return;
            }
        }
        String offset = stackOffset(lugar, current);
        if (offset != null) {
            emit(OpCode.STACK_WRITE, offset, valor, "", "");
            return;
        }
        emit(OpCode.ASSIGN, valor, "", lugar, "");
    }

    private String stackOffset(String nombre, Block b) {
        if (b != null) {
            Integer off = b.slots.get(nombre);
            if (off != null) return "P + " + off;
        }
        Integer g = globalSlots.get(nombre);
        if (g != null) return String.valueOf(g);
        return null;
    }

    private String add(String a, String b) {
        String t = newTemp("numerus");
        emit(OpCode.ADD, a, b, t, "");
        return t;
    }

    private String heapRead(String addr) {
        String t = newTemp("numerus");
        emit(OpCode.HEAP_READ, addr, "", t, "");
        return t;
    }

    private String tipoDe(String lugar) {
        return tipoDeLugar(lugar);
    }

    private String tipoDeLugar(String lugar) {
        if (lugar == null || lugar.equals("-") || lugar.equals("_")) return "numerus";
        if (lugar.startsWith("&")) return tipoDeLugar(lugar.substring(1));
        if (lugar.equals("NULL")) return "null";
        if (lugar.equals("verum") || lugar.equals("falsus")) return "bool";
        if (lugar.startsWith("\"")) return "textum";
        if (lugar.startsWith("'")) return "littera";
        if (tipoTemp.containsKey(lugar)) return tipoTemp.get(lugar);
        if (current != null && current.tipos.containsKey(lugar)) return current.tipos.get(lugar);
        if (globalTypes.containsKey(lugar)) return globalTypes.get(lugar);
        if (tipoVar.containsKey(lugar)) return tipoVar.get(lugar);
        if (lugar.equals("P") || lugar.equals("H")) return "decimalis";

        if (lugar.contains("->") || lugar.contains(".")) {
            int pArrow = lugar.lastIndexOf("->");
            int pDot = lugar.lastIndexOf('.');
            int p = Math.max(pArrow >= 0 ? pArrow + 2 : -1, pDot >= 0 ? pDot + 1 : -1);
            if (p > 0 && p < lugar.length()) {
                String base;
                if (pArrow >= 0 && p == pArrow + 2) base = lugar.substring(0, pArrow);
                else base = lugar.substring(0, pDot);
                String nombreCampo = lugar.substring(p);
                Campo c = campo(tipoDeLugar(base), nombreCampo);
                if (c != null) return c.tipo;
            }
        }

        if (lugar.endsWith("]")) {
            int lb = lugar.lastIndexOf('[');
            if (lb > 0) {
                String base = lugar.substring(0, lb);
                return elementoDe(tipoDeLugar(base));
            }
        }

        if (esNumero(lugar)) {
            return lugar.contains(".") ? "decimalis" : "numerus";
        }
        return "numerus";
    }

    private boolean esTemp(String s) {
        return s != null && s.matches("t\\d+");
    }

    private boolean esNumero(String s) {
        if (s == null || s.isEmpty()) return false;
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int codigoChar(String lit) {
        if (lit == null || lit.length() < 3) return 0;
        String s = lit.substring(1, lit.length() - 1);
        if (s.isEmpty()) return 0;
        char c = s.charAt(0);
        if (c == '\\' && s.length() > 1) {
            char n = s.charAt(1);
            switch (n) {
                case 'n': return '\n';
                case 't': return '\t';
                case 'r': return '\r';
                case '\\': return '\\';
                case '\'': return '\'';
                case '"': return '"';
                case '0': return 0;
                default: return n;
            }
        }
        return c;
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

    private boolean esReferencia(String tipo) {
        String t = tipoBase(tipo);
        return t.equals("textum") || t.startsWith("series<")
                || t.equals("null") || classLayouts.containsKey(t);
    }

    private Layout layout(String tipo) {
        String t = tipoBase(tipo);
        Layout l = classLayouts.get(t);
        if (l != null) return l;
        return structLayouts.get(t);
    }

    private Campo campo(String tipo, String nombre) {
        Layout l = layout(tipo);
        return l == null ? null : l.porNombre.get(nombre);
    }

    private void prepararLayouts() {
        int cid = 1;
        for (Map.Entry<String, ClaseZ> e : clases.entrySet()) {
            ClaseZ cz = e.getValue();
            Layout l = new Layout();
            l.nombre = cz.nombre;
            l.clase = true;
            l.classId = cid;
            cid++;
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

    private String newTemp(String tipo) {
        String t = out.newTemp();
        tipoTemp.put(t, tipo == null ? "numerus" : tipo);
        return t;
    }

    private String newLabel() {
        return out.newLabel();
    }

    private void emit(OpCode op, String a1, String a2, String res, String comment) {
        out.emit(op, a1, a2, res, lineCounter++, comment);
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

    private static class Block {
        final String nombre;
        final boolean main;
        String ret = "void";
        final List<String[]> params = new ArrayList<>();
        final List<String[]> vars = new ArrayList<>();
        final Set<String> declarados = new LinkedHashSet<>();
        final List<Cuarteta> body = new ArrayList<>();
        final Map<String, Integer> slots = new LinkedHashMap<>();
        final Map<String, String> tipos = new LinkedHashMap<>();
        int paramCount;
        int frameSize = 1;

        Block(String nombre, boolean main) {
            this.nombre = nombre;
            this.main = main;
        }
    }
}
