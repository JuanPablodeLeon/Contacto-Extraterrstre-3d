package org.example.Codigo3D;

import antlr4.com.antlr4.com.ZetarianoParserParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.Ejecutor.ClaseZ;

import java.util.ArrayList;
import java.util.List;

public class TraductorZ {

    private final TraductorPigY tac;
    private final java.util.Map<String, ClaseZ> clases;
    private final java.util.Map<String, antlr4.com.antlr4.com.ZetarianoParserParser.InicioContext> arboles;
    private final List<String> avisos = new ArrayList<>();
    private ClaseZ actual;
    private ClaseZ.MetodoZ metodo;
    private boolean retornado;
    private String este = "this";

    public TraductorZ(TraductorPigY tac,
                      java.util.Map<String, ClaseZ> clases,
                      java.util.Map<String, antlr4.com.antlr4.com.ZetarianoParserParser.InicioContext> arboles) {
        this.tac = tac;
        this.clases = clases == null ? new java.util.LinkedHashMap<>() : clases;
        this.arboles = arboles == null ? new java.util.LinkedHashMap<>() : arboles;
    }

    public List<String> getAvisos() { return avisos; }

    public void traducirClases() {
        for (ClaseZ cz : clases.values()) {
            this.actual = cz;
            for (ClaseZ.MetodoZ c : cz.constructores) traducirConstructor(cz, c);
            if (cz.constructores.isEmpty()) {
                constructorDefecto(cz);
            }
            for (List<ClaseZ.MetodoZ> ms : cz.metodos.values()) for (ClaseZ.MetodoZ m : ms) traducirMetodo(cz, m);
        }
        this.actual = null;
        this.metodo = null;
    }

    private void constructorDefecto(ClaseZ cz) {
        String cn = cz.nombre + "_new_0";
        tac.emit("FUNC_BEGIN", cn, cz.nombre, "-", "STACK", "constructor por defecto");
        tac.push();
        este = tac.declara("this", cz.nombre);
        tac.emit("DECLARE", cz.nombre, "-", este, "HEAP", "receptor");
        tac.emit("ALLOC_OBJECT", cz.nombre, "-", este, "HEAP", "reserva en heap");
        tac.emit("PARAM", este, "-", "-");
        tac.emit("CALL", cz.nombre + "_init_0", "1", "-");
        tac.emit("RETURN", este, "-", "-");
        tac.pop();
        tac.emit("FUNC_END", cn, "-", "-", "STACK", "");
        tac.retFunc().put(cn, cz.nombre);

        String in = cz.nombre + "_init_0";
        tac.emit("FUNC_BEGIN", in, "void", "-", "STACK", "inicializador por defecto");
        tac.push();
        este = tac.declara("this", cz.nombre);
        tac.emit("PARAM_DECL", cz.nombre, "-", este, "HEAP", "receptor");
        emitirInitPadre(cz, null);
        tac.pop();
        tac.emit("FUNC_END", in, "-", "-", "STACK", "");
    }

    /** Emite la llamada al inicializador del padre (explícita o implícita). */
    private void emitirInitPadre(ClaseZ cz, ZetarianoParserParser.ParamsContext args) {
        if (cz.padre == null) return;
        ClaseZ padre = clases.get(cz.padre);
        if (padre == null) {
            avisos.add("No se encontró la clase padre '" + cz.padre + "' de '" + cz.nombre + "'.");
            return;
        }
        int n = args == null ? 0 : args.expresion().size();
        List<String> places = new ArrayList<>();
        List<String> tipos = new ArrayList<>();
        if (args != null) {
            for (ZetarianoParserParser.ExpresionContext a : args.expresion()) {
                String p = genZ(a);
                places.add(p);
                tipos.add(tac.tipoDe(p));
            }
        }
        ClaseZ.MetodoZ ctor = padre.constructorPorTipos(tipos, clases);
        String nombreInit = ctor != null
                ? ctor.nombreInit(padre.nombre)
                : padre.nombre + "_init_" + n;
        tac.emit("PARAM", este, "-", "-");
        for (String p : places) tac.emit("PARAM", p, "-", "-");
        tac.emit("CALL", nombreInit, String.valueOf(n + 1), "-");
    }

    private void traducirConstructor(ClaseZ cz, ClaseZ.MetodoZ c) {
        // --- constructor de creación: reserva y delega en el inicializador ---
        this.metodo = c;
        this.retornado = false;
        String cn = c.nombreC(cz.nombre);
        tac.emit("FUNC_BEGIN", cn, cz.nombre, "-", "STACK", "");
        tac.push();
        este = tac.declara("this", cz.nombre);
        tac.emit("DECLARE", cz.nombre, "-", este, "HEAP", "receptor");
        for (ClaseZ.ParamZ p : c.params) {
            String e = tac.declara(p.nombre, p.tipo);
            tac.emit("PARAM_DECL", p.tipo, "-", e, TraductorPigY.segDe(p.tipo),
                    e.equals(p.nombre) ? "parametro en STACK" : "parametro, sombra de " + p.nombre);
        }
        tac.emit("ALLOC_OBJECT", cz.nombre, "-", este, "HEAP", "reserva en heap");
        tac.emit("PARAM", este, "-", "-");
        for (ClaseZ.ParamZ p : c.params) {
            String ph = tac.resolve(p.nombre);
            tac.emit("PARAM", ph == null ? p.nombre : ph, "-", "-");
        }
        tac.emit("CALL", c.nombreInit(cz.nombre),
                String.valueOf(c.params.size() + 1), "-");
        tac.emit("RETURN", este, "-", "-");
        tac.pop();
        tac.emit("FUNC_END", cn, "-", "-", "STACK", "");
        tac.retFunc().put(cn, cz.nombre);

        // --- inicializador: llama al padre y ejecuta el cuerpo ---
        this.metodo = c;
        this.retornado = false;
        String in = c.nombreInit(cz.nombre);
        tac.emit("FUNC_BEGIN", in, "void", "-", "STACK", "");
        tac.push();
        este = tac.declara("this", cz.nombre);
        tac.emit("PARAM_DECL", cz.nombre, "-", este, "HEAP", "receptor");
        for (ClaseZ.ParamZ p : c.params) {
            String e = tac.declara(p.nombre, p.tipo);
            tac.emit("PARAM_DECL", p.tipo, "-", e, TraductorPigY.segDe(p.tipo),
                    e.equals(p.nombre) ? "parametro en STACK" : "parametro, sombra de " + p.nombre);
        }
        List<ZetarianoParserParser.InstruccionContext> cuerpo = c.ctx.instruccion();
        int posSuper = -1;
        for (int i = 0; i < cuerpo.size(); i++) {
            if (cuerpo.get(i).SUPER() != null) { posSuper = i; break; }
        }
        emitirInitPadre(cz, posSuper >= 0 ? cuerpo.get(posSuper).params() : null);
        for (int i = 0; i < cuerpo.size(); i++) {
            if (i == posSuper) continue;
            stmZ(cuerpo.get(i));
        }
        for (ZetarianoParserParser.DeclaracionContext d : c.ctx.declaracion()) declZ(d);
        tac.pop();
        tac.emit("FUNC_END", in, "-", "-", "STACK", "");
        this.metodo = null;
    }

    private void traducirMetodo(ClaseZ cz, ClaseZ.MetodoZ m) {
        this.metodo = m;
        this.retornado = false;
        String cn = m.nombreC(cz.nombre);
        tac.emit("FUNC_BEGIN", cn, m.retorno, "-", "STACK", "");
        tac.push();
        este = tac.declara("this", cz.nombre);
        tac.emit("PARAM_DECL", cz.nombre, "-", este, "HEAP", "receptor");
        for (ClaseZ.ParamZ p : m.params) {
            String e = tac.declara(p.nombre, p.tipo);
            tac.emit("PARAM_DECL", p.tipo, "-", e, TraductorPigY.segDe(p.tipo),
                    e.equals(p.nombre) ? "parametro en STACK" : "parametro, sombra de " + p.nombre);
        }
        for (ZetarianoParserParser.InstruccionContext s : m.ctx.instruccion()) stmZ(s);
        for (ZetarianoParserParser.DeclaracionContext d : m.ctx.declaracion()) declZ(d);
        tac.pop();
        tac.emit("FUNC_END", cn, "-", "-", "STACK", "");
        tac.retFunc().put(cn, m.retorno);
        this.metodo = null;
    }

    private void stmZ(ZetarianoParserParser.InstruccionContext s) {
        if (s.declaracion() != null) {
            declZ(s.declaracion());
            return;
        }
        if (s.asignacion() != null) {
            asigZ(s.asignacion());
            return;
        }
        if (s.IF() != null && s.LLLAVE() != null) {
            String fin = tac.lbl();
            String cond = genZ(s.expresion(0));
            List<List<ZetarianoParserParser.InstruccionContext>> ramas = new ArrayList<>();
            List<ZetarianoParserParser.ExpresionContext> conds = new ArrayList<>();
            ramas.add(s.instruccion());
            segmentarElse(s.bloque_si(), ramas, conds);
            List<String> etiq = new ArrayList<>();
            for (int i = 0; i < ramas.size(); i++) etiq.add(tac.lbl());
            tac.emit("IF_FALSE", cond, "-", ramas.size() > 1 ? etiq.get(0) : fin);
            cuerpoZ(ramas.get(0));
            tac.emit("GOTO", fin, "-", "-");
            for (int i = 1; i < ramas.size(); i++) {
                tac.emit("LABEL", etiq.get(i - 1), "-", "-");
                if (i - 1 < conds.size()) {
                    String c = genZ(conds.get(i - 1));
                    String sig = (i + 1 < ramas.size()) ? etiq.get(i) : fin;
                    tac.emit("IF_FALSE", c, "-", sig);
                }
                cuerpoZ(ramas.get(i));
                if (i + 1 < ramas.size() || conds.size() == ramas.size()) {
                    tac.emit("GOTO", fin, "-", "-");
                }
            }
            tac.emit("LABEL", fin, "-", "-");
            return;
        }
        if (s.IF() != null) {
            List<ZetarianoParserParser.InstruccionContext> hs = s.instruccion();
            String fin = tac.lbl();
            tac.emit("IF_FALSE", genZ(s.expresion(0)), "-", fin);
            cuerpoZ(List.of(hs.get(0)));
            if (s.ELSE() != null && hs.size() > 1) {
                String sino = tac.lbl();
                tac.emit("GOTO", sino, "-", "-");
                tac.emit("LABEL", fin, "-", "-");
                cuerpoZ(List.of(hs.get(1)));
                tac.emit("LABEL", sino, "-", "-");
            } else {
                tac.emit("LABEL", fin, "-", "-");
            }
            return;
        }
        if (s.SWITCH() != null) {
            ZetarianoParserParser.Switch_cuerpoContext cuerpo = s.switch_cuerpo();
            if (cuerpo == null) return;
            List<ZetarianoParserParser.Bloque_switchContext> casos = cuerpo.bloque_switch();
            List<String> etiquetas = new ArrayList<>();
            for (int i = 0; i < casos.size(); i++) etiquetas.add(tac.lbl());
            String fin = tac.lbl();
            String def = cuerpo.bloque_default() == null ? fin : tac.lbl();
            String selector = genZ(s.expresion(0));
            tac.pushBreak(fin);
            for (int i = 0; i < casos.size(); i++) {
                String cmp = tac.binaria(selector, "==", genZ(casos.get(i).expresion()));
                tac.emit("IF_TRUE", cmp, "-", etiquetas.get(i));
            }
            tac.emit("GOTO", def, "-", "-");
            for (int i = 0; i < casos.size(); i++) {
                tac.emit("LABEL", etiquetas.get(i), "-", "-");
                for (ZetarianoParserParser.InstruccionContext h : casos.get(i).instruccion()) stmZ(h);
            }
            if (cuerpo.bloque_default() != null) {
                tac.emit("LABEL", def, "-", "-");
                for (ZetarianoParserParser.InstruccionContext h : cuerpo.bloque_default().instruccion()) stmZ(h);
            }
            tac.emit("LABEL", fin, "-", "-");
            tac.popBreak();
            return;
        }
        if (s.FOR() != null) {
            if (s.tipos() != null) {
                tac.push();
                String varName = primerIdDirecto(s);
                String eit = tac.declara(varName, ClaseZ.canonZ(s.tipos().getText()));
                tac.emit("DECLARE", ClaseZ.canonZ(s.tipos().getText()), "-", eit, "STACK", "iterador for");
                tac.emit("=", genZ(s.expresion(0)), "-", eit);
                String ini = tac.lbl();
                String inc = tac.lbl();
                String fin = tac.lbl();
                tac.emit("LABEL", ini, "-", "-");
                tac.emit("IF_FALSE", genZ(s.expresion(1)), "-", fin);
                tac.pushBreak(fin);
                tac.pushCont(inc);
                for (ZetarianoParserParser.InstruccionContext h : s.instruccion()) stmZ(h);
                tac.popBreak(); tac.popCont();
                tac.emit("LABEL", inc, "-", "-");
                String tgt = tac.resolve(varName);
                if (tgt == null) tgt = varName;
                tac.emit(s.DECREMENTO() != null ? "-" : "+", tgt, "1", tgt);
                tac.emit("GOTO", ini, "-", "-");
                tac.emit("LABEL", fin, "-", "-");
                tac.pop();
            } else {
                String ini = tac.lbl();
                String fin = tac.lbl();
                tac.emit("LABEL", ini, "-", "-");
                tac.pushBreak(fin);
                tac.pushCont(ini);
                for (ZetarianoParserParser.InstruccionContext h : s.instruccion()) stmZ(h);
                tac.popBreak(); tac.popCont();
                tac.emit("GOTO", ini, "-", "-");
                tac.emit("LABEL", fin, "-", "-");
            }
            return;
        }
        if (s.WHILE() != null && s.DO() == null) {
            String ini = tac.lbl();
            String fin = tac.lbl();
            tac.emit("LABEL", ini, "-", "-");
            tac.emit("IF_FALSE", genZ(s.expresion(0)), "-", fin);
            tac.pushBreak(fin);
            tac.pushCont(ini);
            for (ZetarianoParserParser.InstruccionContext h : s.instruccion()) stmZ(h);
            tac.popBreak(); tac.popCont();
            tac.emit("GOTO", ini, "-", "-");
            tac.emit("LABEL", fin, "-", "-");
            return;
        }
        if (s.DO() != null) {
            String ini = tac.lbl();
            String cond = tac.lbl();
            String fin = tac.lbl();
            tac.emit("LABEL", ini, "-", "-");
            tac.pushBreak(fin);
            tac.pushCont(cond);
            cuerpoZ(s.instruccion());
            tac.popBreak(); tac.popCont();
            tac.emit("LABEL", cond, "-", "-");
            tac.emit("IF_TRUE", genZ(s.expresion(0)), "-", ini);
            tac.emit("LABEL", fin, "-", "-");
            return;
        }
        if (s.PRINTLN() != null || s.PRINT() != null) {
            boolean salto = s.PRINTLN() != null;
            List<ZetarianoParserParser.ExpresionContext> args = s.expresion();
            if (args.isEmpty()) {
                tac.emit(salto ? "PRINTLN" : "PRINT", "\"\"", "-", "-",
                        GeneradorC.segmentoDe("textum"), "");
            } else {
                String v = genZ(args.get(0));
                tac.emit(salto ? "PRINTLN" : "PRINT", v, "-", "-",
                        GeneradorC.segmentoDe(tac.tipoDe(v)), "");
            }
            return;
        }
        if (s.READLN() != null) {
            tac.emit("READ", "_", "-", "-");
            return;
        }
        if (s.BREAK() != null) {
            tac.emit("GOTO", tac.peekBreak(), "-", "-", "STACK", "break");
            return;
        }
        if (s.CONTINUE() != null) {
            tac.emit("GOTO", tac.peekCont(), "-", "-", "STACK", "continue");
            return;
        }
        if (s.RETURN() != null) {
            List<ZetarianoParserParser.ExpresionContext> args = s.expresion();
            if (args.isEmpty()) {
                tac.emit("RETURN", "-", "-", "-");
            } else {
                String v = genZ(args.get(0));
                String ret = metodo == null ? "void" : metodo.retorno;
                if ((v.equals("NULL")) && esRetPrimitivo(ret)) {
                    avisos.add("return null en '" + (metodo == null ? "?" : metodo.nombre)
                            + "' con retorno " + ret + ": se genera return "
                            + defectoRet(ret) + ".");
                    tac.emit("RETURN", defectoRet(ret), "-", "-");
                } else {
                    tac.emit("RETURN", v, "-", "-");
                }
            }
            retornado = true;
            return;
        }
        if (s.SUPER() != null) {
            return; // ya se emitió al inicio del inicializador
        }
        if (!s.expresion().isEmpty()) {
            genZ(s.expresion(0));
            return;
        }
        throw new RuntimeException("Instrucción Zetariana no soportada: " + s.getText());
    }

    private static boolean esRetPrimitivo(String ret) {
        return ret.equals("numerus") || ret.equals("decimalis")
                || ret.equals("littera") || ret.equals("bool");
    }

    private static String defectoRet(String ret) {
        switch (ret) {
            case "decimalis": return "0.0";
            case "littera": return "'\\0'";
            default: return "0";
        }
    }

    private void segmentarElse(ZetarianoParserParser.Bloque_siContext bs,
                               List<List<ZetarianoParserParser.InstruccionContext>> ramas,
                               List<ZetarianoParserParser.ExpresionContext> conds) {
        if (bs == null) return;
        conds.addAll(bs.expresion());
        int nElse = bs.ELSE().size();
        if (nElse == 0) return;
        List<List<ZetarianoParserParser.InstruccionContext>> grupos = new ArrayList<>();
        List<ZetarianoParserParser.InstruccionContext> act = null;
        int depth = 0;
        for (int _ci = 0; _ci < bs.getChildCount(); _ci++) {
            ParseTree ch = bs.getChild(_ci);
            if (ch instanceof TerminalNode tn) {
                String t = tn.getText();
                if (t.equals("else")) {
                    act = new ArrayList<>();
                    grupos.add(act);
                } else if (t.equals("{")) depth++;
                else if (t.equals("}")) depth--;
            } else if (ch instanceof ZetarianoParserParser.InstruccionContext ic) {
                if (act != null && depth > 0) act.add(ic);
            }
        }
        if (grupos.size() != nElse) {
            grupos.clear();
            for (int i = 0; i < nElse; i++) grupos.add(new ArrayList<>());
            List<ZetarianoParserParser.InstruccionContext> todas = bs.instruccion();
            if (!todas.isEmpty()) grupos.get(0).addAll(todas);
        }
        ramas.addAll(grupos);
    }

    private void cuerpoZ(List<ZetarianoParserParser.InstruccionContext> stms) {
        tac.push();
        for (ZetarianoParserParser.InstruccionContext s : stms) stmZ(s);
        tac.pop();
    }

    private String primerIdDirecto(ZetarianoParserParser.InstruccionContext s) {
        for (ParseTree ch : s.children) {
            if (ch instanceof TerminalNode tn
                    && tn.getSymbol().getType() == ZetarianoParserParser.ID) {
                return tn.getText();
            }
        }
        return "i";
    }

    private void declZ(ZetarianoParserParser.DeclaracionContext d) {
        if (d.NEW() != null && d.LPAREN() == null && !d.LCORCH().isEmpty()) {
            declArreglo(d);
            return;
        }
        if (d.NEW() != null) {
            declNew(d);
            return;
        }
        if (!d.LCORCH().isEmpty() || d.LLLAVE() != null) {
            declArreglo(d);
            return;
        }
        String tipo = tipoDecl(d);
        String var = varDecl(d);
        if (var == null) throw new RuntimeException("Declaración sin variable: " + d.getText());
        String e = tac.declara(var, tipo);
        tac.emit("DECLARE", tipo, "-", e, TraductorPigY.segDe(tipo),
                e.equals(var) ? "variable en " + TraductorPigY.segDe(tipo) : "sombra de " + var);
        List<ZetarianoParserParser.ExpresionContext> exprs = d.expresion();
        if (d.ASIGNACION() != null && !exprs.isEmpty()) {
            tac.emit("=", genZ(exprs.get(0)), "-", e, TraductorPigY.segDe(tipo), "");
        } else {
            tac.emit("=", TraductorPigY.valorDefectoPlace(tipo), "-", e,
                    TraductorPigY.segDe(tipo), "valor por defecto");
        }
    }

    private int dimsDecl(ZetarianoParserParser.DeclaracionContext d) {
        int dims = 0;
        for (int i = 0; i < d.getChildCount(); i++) {
            ParseTree ch = d.getChild(i);
            if (ch instanceof TerminalNode tn
                    && tn.getSymbol().getType() == ZetarianoParserParser.ID) break;
            if (ch instanceof TerminalNode tn && tn.getText().equals("[")) dims++;
        }
        return dims;
    }

    private String tipoDecl(ZetarianoParserParser.DeclaracionContext d) {
        if (d.tipos() != null && !d.tipos().isEmpty()) {
            String t = ClaseZ.canonZ(d.tipos().get(0).getText());
            for (int i = 0; i < dimsDecl(d); i++) t = "series<" + t + ">";
            return t;
        }
        List<String> ids = idsDirectosAntes(d, "=");
        if (ids.size() >= 2) return ids.get(0);
        return "numerus";
    }

    private String varDecl(ZetarianoParserParser.DeclaracionContext d) {
        List<String> ids = idsDirectosAntes(d, "=");
        if (ids.isEmpty()) {
            List<TerminalNode> todos = d.ID();
            if (!todos.isEmpty()) return todos.get(todos.size() - 1).getText();
            return null;
        }
        return ids.get(ids.size() - 1);
    }

    private List<String> idsDirectosAntes(ParseTree n, String marca) {
        List<String> out = new ArrayList<>();
        for (int i = 0; i < n.getChildCount(); i++) {
            ParseTree ch = n.getChild(i);
            if (ch instanceof TerminalNode tn) {
                if (tn.getText().equals(marca)) break;
                if (tn.getSymbol().getType() == ZetarianoParserParser.ID) {
                    out.add(tn.getText());
                }
            }
        }
        return out;
    }

    private void declNew(ZetarianoParserParser.DeclaracionContext d) {
        List<String> ids = idsDirectosAntes(d, "=");
        String var = ids.isEmpty() ? null : ids.get(ids.size() - 1);
        String tipo = tipoDecl(d);
        String clase = null;
        boolean trasNew = false;
        for (ParseTree ch : d.children) {
            if (ch instanceof TerminalNode tn) {
                if (tn.getText().equals("new")) { trasNew = true; continue; }
                if (trasNew && tn.getSymbol().getType() == ZetarianoParserParser.ID) {
                    clase = tn.getText();
                    break;
                }
            }
        }
        if (var == null || clase == null) {
            throw new RuntimeException("new mal formado: " + d.getText());
        }
        ClaseZ cz = TraductorPigY.clases().get(clase);
        if (cz == null) throw new RuntimeException("Clase no definida: '" + clase + "'.");
        List<ZetarianoParserParser.ExpresionContext> args = d.params() == null
                ? List.of() : d.params().expresion();
        List<String> places = new ArrayList<>();
        List<String> tipos = new ArrayList<>();
        for (ZetarianoParserParser.ExpresionContext a : args) {
            String p = genZ(a);
            places.add(p);
            tipos.add(tac.tipoDe(p));
        }
        ClaseZ.MetodoZ ctor = cz.constructorPorTipos(tipos, clases);
        String nombreCtor = ctor != null ? ctor.nombreC(clase) : clase + "_new_" + args.size();
        String tipoVar = clases.containsKey(tipo) ? tipo : clase;
        String e = tac.declara(var, tipoVar);
        tac.emit("DECLARE", tipoVar, "-", e, "HEAP", "objeto en HEAP");
        for (String p : places) tac.emit("PARAM", p, "-", "-");
        tac.emit("CALL", nombreCtor, String.valueOf(args.size()), e, "HEAP", "");
        if (!tipoVar.equals(clase)) {
            avisos.add("'" + var + "' declarado como " + tipoVar + " y recibe new " + clase + ".");
        }
    }

    private void declArreglo(ZetarianoParserParser.DeclaracionContext d) {
        String tipo = tipoDecl(d);
        String var = varDecl(d);
        if (var == null) throw new RuntimeException("Arreglo sin variable: " + d.getText());
        String e = tac.declara(var, tipo);
        tac.emit("DECLARE", tipo, "-", e, "HEAP", "series en HEAP");
        List<ZetarianoParserParser.ExpresionContext> exprs = d.expresion();
        if (d.NEW() != null && !exprs.isEmpty()) {
            List<String> dims = new ArrayList<>();
            for (ZetarianoParserParser.ExpresionContext sz : exprs) dims.add(genZ(sz));
            String v = allocArreglo(tipo, dims);
            tac.emit("=", v, "-", e, "HEAP", "");
        } else if (d.params() != null) {
            String elem = tipoElemento(tipo);
            List<ZetarianoParserParser.ExpresionContext> vals = d.params().expresion();
            tac.emit("ALLOC_SERIES", elem, String.valueOf(vals.size()), e, "HEAP", "reserva en heap");
            for (int i = 0; i < vals.size(); i++) {
                tac.emit("[]=", e, String.valueOf(i), genZ(vals.get(i)), "HEAP", "");
            }
        } else {
            tac.emit("=", "NULL", "-", e, "HEAP", "sin inicializar");
        }
    }

    private String tipoElemento(String tipo) {
        if (tipo != null && tipo.startsWith("series<") && tipo.endsWith(">")) {
            return tipo.substring(7, tipo.length() - 1);
        }
        return "numerus";
    }

    private String allocArreglo(String tipo, List<String> dims) {
        if (dims.isEmpty()) return "NULL";
        String elem = tipoElemento(tipo);
        String t = tac.tmp(tipo);
        tac.emit("ALLOC_SERIES", elem, dims.get(0), t, "HEAP", "reserva en heap");
        if (dims.size() == 1) return t;
        String i = tac.tmp("numerus");
        tac.emit("=", "0", "-", i, "STACK", "");
        String ini = tac.lbl();
        String fin = tac.lbl();
        tac.emit("LABEL", ini, "-", "-");
        String cond = tac.binaria(i, "<", dims.get(0));
        tac.emit("IF_FALSE", cond, "-", fin);
        String fila = allocArreglo(elem, dims.subList(1, dims.size()));
        tac.emit("[]=", t, i, fila, "HEAP", "");
        tac.emit("+", i, "1", i, "STACK", "");
        tac.emit("GOTO", ini, "-", "-");
        tac.emit("LABEL", fin, "-", "-");
        return t;
    }

    private void asigZ(ZetarianoParserParser.AsignacionContext a) {
        if (a.THIS() != null) {
            String campo = a.ID().getText();
            String tc = tipoCampoActual(campo);
            if (tc == null) {
                throw new RuntimeException("Campo no definido: '" + claseDeActual() + "." + campo + "'.");
            }
            if (a.INCREMENTO() != null || a.DECREMENTO() != null) {
                String op = a.DECREMENTO() != null ? "-" : "+";
                String r = leerCampoActual(campo, tc);
                tac.emit(op, r, "1", r, "STACK", a.DECREMENTO() != null ? "--" : "++");
                tac.emit(".=", este, campo, r, GeneradorC.segmentoDe(tc), "");
                return;
            }
            String v = genZ(a.expresion(0));
            if (a.SUMA_IGL() != null || a.RESTA_IGL() != null || a.MULT_IGL() != null) {
                String op = a.SUMA_IGL() != null ? "+" : (a.RESTA_IGL() != null ? "-" : "*");
                String r = leerCampoActual(campo, tc);
                String t = tac.tmp(tc);
                tac.emit(op, r, v, t, GeneradorC.segmentoDe(tc), op + "=");
                v = t;
            }
            tac.emit(".=", este, campo, v, GeneradorC.segmentoDe(tc), "");
            return;
        }
        if (a.SUMA_IGL() != null || a.RESTA_IGL() != null || a.MULT_IGL() != null) {
            String op = a.SUMA_IGL() != null ? "+" : (a.RESTA_IGL() != null ? "-" : "*");
            String var = a.ID().getText();
            String r = leerLugar(var);
            String t = tac.tmp(tac.tipoDe(r));
            tac.emit(op, r, genZ(a.expresion(0)), t, GeneradorC.segmentoDe(tac.tipoDe(t)), op + "=");
            escribirLugar(var, t);
            return;
        }
        if (a.INTERRG() != null) {
            String var = a.ID().getText();
            List<ZetarianoParserParser.ExpresionContext> es = a.expresion();
            String fin = tac.lbl();
            String lelse = tac.lbl();
            tac.emit("IF_FALSE", genZ(es.get(0)), "-", lelse);
            escribirLugar(var, genZ(es.get(1)));
            tac.emit("GOTO", fin, "-", "-");
            tac.emit("LABEL", lelse, "-", "-");
            escribirLugar(var, genZ(es.get(2)));
            tac.emit("LABEL", fin, "-", "-");
            return;
        }
        if (a.INCREMENTO() != null || a.DECREMENTO() != null) {
            String var = a.ID().getText();
            String op = a.DECREMENTO() != null ? "-" : "+";
            String r = leerLugar(var);
            tac.emit(op, r, "1", r, "STACK", a.DECREMENTO() != null ? "--" : "++");

            if (esCampo(var)) escribirLugar(var, r);
            return;
        }
        List<ZetarianoParserParser.ExpresionContext> es = a.expresion();
        if (es.isEmpty()) throw new RuntimeException("Asignación sin valor: " + a.getText());
        String v = genZ(es.get(es.size() - 1));
        if (a.lvalue() != null) {
            escribirLvalue(a.lvalue(), v);
        } else if (a.ID() != null) {
            escribirLugar(a.ID().getText(), v);
        } else {
            throw new RuntimeException("Asignación sin destino: " + a.getText());
        }
    }

    private String leerCampoActual(String nombre, String tipo) {
        String t = tac.tmp(tipo);
        tac.emit("=.", este, nombre, t, GeneradorC.segmentoDe(tipo), "");
        return t;
    }

    private String claseDeActual() {
        return actual == null ? "?" : actual.nombre;
    }

    private String tipoCampoActual(String nombre) {
        if (actual == null) return null;
        ClaseZ.CampoInfo ci = actual.buscarCampo(nombre, clases);
        return ci == null ? null : ci.tipo;
    }

    private String leerLugar(String nombre) {
        String e = tac.resolve(nombre);
        if (e != null) return e;
        String tc = tipoCampoActual(nombre);
        if (tc != null) {
            String t = tac.tmp(tc);
            tac.emit("=.", este, nombre, t, GeneradorC.segmentoDe(tc), "");
            return t;
        }
        throw new RuntimeException("Variable no declarada: '" + nombre + "'.");
    }

    private String leerLugarBase(String ign) {
        return ign;
    }

    private boolean esCampo(String nombre) {
        return tac.resolve(nombre) == null && tipoCampoActual(nombre) != null;
    }

    private void escribirLugar(String nombre, String valor) {
        String e = tac.resolve(nombre);
        if (e != null) {
            tac.emit("=", valor, "-", e, GeneradorC.segmentoDe(tac.tipoDe(e)), "");
            return;
        }
        if (tipoCampoActual(nombre) != null) {
            tac.emit(".=", este, nombre, valor,
                    GeneradorC.segmentoDe(tac.tipoDe(valor)), "");
            return;
        }
        throw new RuntimeException("Variable no declarada: '" + nombre + "'.");
    }

    private void escribirLvalue(ZetarianoParserParser.LvalueContext lv, String valor) {
        List<TerminalNode> ids = lv.ID();
        if (ids.isEmpty()) throw new RuntimeException("lvalue vacío.");
        String base = ids.get(0).getText();
        String bplace = tac.resolve(base);
        boolean baseCampo = false;
        if (bplace == null && tipoCampoActual(base) != null) {
            baseCampo = true;
            bplace = este;
        }
        if (bplace == null) throw new RuntimeException("Variable no declarada: '" + base + "'.");

        List<Object> partes = new ArrayList<>();
        int idIdx = 0;
        int exprIdx = 0;
        for (int i = 1; i < lv.getChildCount(); i++) {
            ParseTree ch = lv.getChild(i);
            if (ch instanceof TerminalNode tn && tn.getText().equals(".")) {
                if (i + 1 < lv.getChildCount()
                        && lv.getChild(i + 1) instanceof TerminalNode idn) {
                    partes.add("." + idn.getText());
                    idIdx++;
                }
            } else if (ch instanceof TerminalNode tn && tn.getText().equals("[")) {
                partes.add(lv.expresion(exprIdx++));
            }
        }
        if (partes.isEmpty()) {
            if (baseCampo) tac.emit(".=", este, base, valor,
                    GeneradorC.segmentoDe(tac.tipoDe(valor)), "");
            else tac.emit("=", valor, "-", bplace,
                    GeneradorC.segmentoDe(tac.tipoDe(bplace)), "");
            return;
        }

        String cur = baseCampo ? leerLugar(base) : bplace;
        String curTipo = baseCampo ? tipoCampoActual(base) : tac.tipoDe(cur);
        for (int i = 0; i < partes.size(); i++) {
            Object p = partes.get(i);
            boolean ultimo = i == partes.size() - 1;
            if (p instanceof String campo) {
                String nombre = campo.substring(1);
                ClaseZ cz = TraductorPigY.clases().get(curTipo);
                ClaseZ.CampoInfo ci = cz == null ? null : cz.buscarCampo(nombre, clases);
                String tCampo = ci != null ? ci.tipo : "numerus";
                if (ultimo) {
                    tac.emit(".=", cur, nombre, valor, GeneradorC.segmentoDe(tCampo), "");
                } else {
                    String t = tac.tmp(tCampo);
                    tac.emit("=.", cur, nombre, t, GeneradorC.segmentoDe(tCampo), "");
                    cur = t;
                    curTipo = tCampo;
                }
            } else {
                ZetarianoParserParser.ExpresionContext idx = (ZetarianoParserParser.ExpresionContext) p;
                String elem = tipoElemento(curTipo);
                if (ultimo) {
                    tac.emit("[]=", cur, genZ(idx), valor, "HEAP", "");
                } else {
                    String t = tac.tmp(elem);
                    tac.emit("=[]", cur, genZ(idx), t, "HEAP", "");
                    cur = t;
                    curTipo = elem;
                }
            }
        }
    }

    /** {@code super.metodo(...)} / {@code super.campo} con llamada estática al padre. */
    private String genZSuper(ZetarianoParserParser.ExpresionContext e) {
        ClaseZ padre = actual == null ? null : actual.clasePadre(clases);
        if (padre == null) {
            throw new RuntimeException("'super' sin clase padre en '" 
                    + (actual == null ? "?" : actual.nombre) + "'.");
        }
        String nombre = e.ID() != null ? e.ID().getText() : "?";
        if (e.LPAREN() != null || e.getText().contains("(")) {
            List<String> args = new ArrayList<>();
            if (e.params() != null) {
                for (ZetarianoParserParser.ExpresionContext a : e.params().expresion()) {
                    args.add(genZ(a));
                }
            }
            ClaseZ.MetodoInfo mi = buscarMetodoPorArgs(padre, nombre, args);
            if (mi == null) mi = buscarMetodoClase(padre, nombre, args.size());
            if (mi == null) {
                throw new RuntimeException("Método no definido en el padre: '"
                        + padre.nombre + "." + nombre + "'.");
            }
            tac.emit("PARAM", este, "-", "-");
            for (String ap : args) tac.emit("PARAM", ap, "-", "-");
            String ret = mi.metodo.retorno;
            if (ret.equals("void")) {
                tac.emit("CALL", mi.metodo.nombreC(mi.clase.nombre),
                        String.valueOf(args.size() + 1), "-");
                return "0";
            }
            String t = tac.tmp(ret);
            tac.emit("CALL", mi.metodo.nombreC(mi.clase.nombre),
                    String.valueOf(args.size() + 1), t,
                    GeneradorC.segmentoDe(ret), "");
            return t;
        }
        ClaseZ.CampoInfo ci = padre.buscarCampo(nombre, clases);
        if (ci == null) {
            throw new RuntimeException("Campo no definido en el padre: '"
                    + padre.nombre + "." + nombre + "'.");
        }
        String t = tac.tmp(ci.tipo);
        tac.emit("=.", este, nombre, t, GeneradorC.segmentoDe(ci.tipo), "");
        return t;
    }

    private ClaseZ.MetodoInfo buscarMetodoClase(ClaseZ desde, String nombre, int aridad) {
        if (desde == null) return null;
        for (ClaseZ.MetodoInfo mi : desde.metodosVisibles(nombre, clases)) {
            if (mi.metodo.params.size() == aridad) return mi;
        }
        return null;
    }

    /** Elige la sobrecarga cuyos tipos de parámetro aceptan los argumentos dados. */
    private ClaseZ.MetodoInfo buscarMetodoPorArgs(ClaseZ desde, String nombre, List<String> args) {
        if (desde == null) return null;
        for (ClaseZ.MetodoInfo mi : desde.metodosVisibles(nombre, clases)) {
            if (mi.metodo.params.size() != args.size()) continue;
            boolean ok = true;
            for (int i = 0; i < args.size(); i++) {
                if (!compatibleZ(mi.metodo.params.get(i).tipo, tac.tipoDe(args.get(i)))) {
                    ok = false;
                    break;
                }
            }
            if (ok) return mi;
        }
        return null;
    }

    private boolean compatibleZ(String param, String arg) {
        if (param == null || arg == null) return true;
        String p = param.startsWith("&") ? param.substring(1) : param;
        String a = arg.startsWith("&") ? arg.substring(1) : arg;
        if (p.equals(a)) return true;
        if (a.equals("null")) {
            return clases.containsKey(p) || p.startsWith("series<") || p.equals("textum");
        }
        if (p.equals("decimalis") && a.equals("numerus")) return true;
        ClaseZ pc = clases.get(p);
        ClaseZ ac = clases.get(a);
        return pc != null && ac != null && ac.esSubclaseDe(p, clases);
    }

    private String tipoCampoDe(String tipoBase, String campo) {
        ClaseZ cz = TraductorPigY.clases().get(tipoBase);
        if (cz != null) {
            ClaseZ.CampoInfo ci = cz.buscarCampo(campo, clases);
            if (ci != null) return ci.tipo;
        }
        return "numerus";
    }

    private String genZ(ZetarianoParserParser.ExpresionContext e) {
        if (e.getChild(0) instanceof TerminalNode t0) {
            int ty0 = t0.getSymbol().getType();
            if (ty0 == ZetarianoParserParser.THIS) {
                if (e.getChildCount() == 1) return este;
                if (e.getChild(2) instanceof ZetarianoParserParser.ExpresionContext inner) {
                    return genZ(inner);
                }
            }
            if (ty0 == ZetarianoParserParser.SUPER) {
                return genZSuper(e);
            }
        }
        if (e.INTERRG() != null) {
            List<ZetarianoParserParser.ExpresionContext> es = e.expresion();
            String fin = tac.lbl();
            String sino = tac.lbl();
            tac.emit("IF_FALSE", genZ(es.get(0)), "-", sino);
            String v1 = genZ(es.get(1));
            String t = tac.tmp(tac.tipoDe(v1));
            tac.emit("=", v1, "-", t);
            tac.emit("GOTO", fin, "-", "-");
            tac.emit("LABEL", sino, "-", "-");
            tac.emit("=", genZ(es.get(2)), "-", t);
            tac.emit("LABEL", fin, "-", "-");
            return t;
        }
        if (e.NEW() != null && e.tipos() != null) {
            String tipo = ClaseZ.canonZ(e.tipos().getText());
            for (int i = 0; i < e.LCORCH().size(); i++) tipo = "series<" + tipo + ">";
            List<String> dims = new ArrayList<>();
            for (ZetarianoParserParser.ExpresionContext sz : e.expresion()) dims.add(genZ(sz));
            return allocArreglo(tipo, dims);
        }
        if (e.NEW() != null && e.ID() != null) {
            String clase = e.ID().getText();
            ClaseZ cz = TraductorPigY.clases().get(clase);
            if (cz == null) throw new RuntimeException("Clase no definida: '" + clase + "'.");
            List<String> args = new ArrayList<>();
            List<String> tipos = new ArrayList<>();
            if (e.params() != null) {
                for (ZetarianoParserParser.ExpresionContext a : e.params().expresion()) {
                    String p = genZ(a);
                    args.add(p);
                    tipos.add(tac.tipoDe(p));
                }
            }
            ClaseZ.MetodoZ ctor = cz.constructorPorTipos(tipos, clases);
            String nombreCtor = ctor != null ? ctor.nombreC(clase) : clase + "_new_" + args.size();
            for (String ap : args) tac.emit("PARAM", ap, "-", "-");
            String t = tac.tmp(clase);
            tac.emit("CALL", nombreCtor, String.valueOf(args.size()), t, "HEAP", "");
            return t;
        }
        int n = e.getChildCount();
        if (n == 1) {
            ParseTree ch = e.getChild(0);
            if (ch instanceof TerminalNode tn) {
                int t = tn.getSymbol().getType();
                String txt = tn.getText();
                if (t == ZetarianoParserParser.TRUE) return "verum";
                if (t == ZetarianoParserParser.FALSE) return "falsus";
                if (t == ZetarianoParserParser.NULL_VAL) return "NULL";
                if (t == ZetarianoParserParser.ID) return leerLugar(txt);
                return txt;
            }
            if (ch instanceof ZetarianoParserParser.ExpresionContext sub) return genZ(sub);
            if (ch instanceof ZetarianoParserParser.ParamsContext p) {
                if (p.expresion().isEmpty()) return "";
                return genZ(p.expresion(0));
            }
            return ch.getText();
        }
        if (esNodo(e, "leer") && n == 3) {
            String t = tac.tmp("textum");
            tac.emit("CALL", "leer", "0", t, "HEAP", "");
            return t;
        }
        if (n == 2 && e.getChild(0) instanceof TerminalNode tn0
                && e.getChild(1) instanceof ZetarianoParserParser.ExpresionContext sub) {
            String op = tn0.getText();
            String v = genZ(sub);
            if (op.equals("-")) {
                String t = tac.tmp(tac.tipoDe(v));
                tac.emit("UMINUS", v, "-", t, GeneradorC.segmentoDe(t), "");
                return t;
            }
            if (op.equals("!")) {
                String t = tac.tmp("bool");
                tac.emit("NOT", v, "-", t);
                return t;
            }
        }
        if (n == 3 && e.getChild(0).getText().equals("(")
                && e.getChild(2).getText().equals(")")
                && e.getChild(1) instanceof ZetarianoParserParser.ExpresionContext sub) {
            return genZ(sub);
        }
        if (contiene(e, ".") && contiene(e, "(")) {
            int pto = indiceHijo(e, ".");
            int par = indiceHijo(e, "(");
            if (pto >= 0 && par > pto
                    && e.getChild(0) instanceof ZetarianoParserParser.ExpresionContext recv) {
                String rplace = genZ(recv);
                String tipoR = tac.tipoDe(rplace);
                String met = null;
                for (int i = pto + 1; i < par; i++) {
                    if (e.getChild(i) instanceof TerminalNode tn
                            && tn.getSymbol().getType() == ZetarianoParserParser.ID) {
                        met = tn.getText();
                    }
                }
                List<String> args = new ArrayList<>();
                ZetarianoParserParser.ParamsContext pc = paramsDe(e);
                if (pc != null) {
                    for (ZetarianoParserParser.ExpresionContext a : pc.expresion()) {
                        args.add(genZ(a));
                    }
                }
                if (met == null) throw new RuntimeException("Llamada sin método: " + e.getText());
                ClaseZ cz = TraductorPigY.clases().get(tipoR);
                if (cz == null) {
                    throw new RuntimeException("El receptor no es objeto (tipo " + tipoR + "): " + e.getText());
                }
                ClaseZ.MetodoInfo mi = buscarMetodoPorArgs(cz, met, args);
                if (mi == null) mi = buscarMetodoClase(cz, met, args.size());
                if (mi == null) {
                    throw new RuntimeException("Método no definido: '" + tipoR + "." + met + "'.");
                }
                tac.emit("PARAM", rplace, "-", "-");
                for (String ap : args) tac.emit("PARAM", ap, "-", "-");
                String ret = mi.metodo.retorno;
                if (ret.equals("void")) {
                    tac.emit("CALL", "V:" + mi.metodo.firma(),
                            String.valueOf(args.size() + 1), "-");
                    return "0";
                }
                String t = tac.tmp(ret);
                tac.emit("CALL", "V:" + mi.metodo.firma(),
                        String.valueOf(args.size() + 1), t,
                        GeneradorC.segmentoDe(ret), "");
                return t;
            }
        }
        if (n == 3 && e.getChild(1).getText().equals(".")
                && e.getChild(0) instanceof ZetarianoParserParser.ExpresionContext recv
                && e.getChild(2) instanceof TerminalNode tnf) {
            String rplace = genZ(recv);
            String tipoR = tac.tipoDe(rplace);
            String tCampo = tipoCampoDe(tipoR, tnf.getText());
            String t = tac.tmp(tCampo);
            tac.emit("=.", rplace, tnf.getText(), t, GeneradorC.segmentoDe(tCampo), "");
            return t;
        }
        if (n == 4 && e.getChild(1).getText().equals("[")
                && e.getChild(0) instanceof ZetarianoParserParser.ExpresionContext recv
                && e.getChild(2) instanceof ZetarianoParserParser.ExpresionContext idx) {
            String rplace = genZ(recv);
            String t = tac.tmp(tipoElemento(tac.tipoDe(rplace)));
            tac.emit("=[]", rplace, genZ(idx), t, "STACK", "");
            return t;
        }
        if (n == 3 && e.getChild(0) instanceof ZetarianoParserParser.ExpresionContext l
                && e.getChild(2) instanceof ZetarianoParserParser.ExpresionContext r
                && e.getChild(1) instanceof TerminalNode op) {
            String o = op.getText();
            if (esBinario(o)) {
                return tac.binaria(genZ(l), o, genZ(r));
            }
        }
        if (e.getChild(0) instanceof TerminalNode tn0
                && tn0.getSymbol().getType() == ZetarianoParserParser.ID
                && contiene(e, "(")) {
            String fn = tn0.getText();
            List<String> args = new ArrayList<>();
            ZetarianoParserParser.ParamsContext pc = paramsDe(e);
            if (pc != null) {
                for (ZetarianoParserParser.ExpresionContext a : pc.expresion()) {
                    args.add(genZ(a));
                }
            }
            ClaseZ.MetodoInfo mi = buscarMetodoPorArgs(actual, fn, args);
            if (mi == null) mi = buscarMetodoClase(actual, fn, args.size());
            if (mi != null) {
                tac.emit("PARAM", este, "-", "-");
                for (String ap : args) tac.emit("PARAM", ap, "-", "-");
                String ret = mi.metodo.retorno;
                if (ret.equals("void")) {
                    tac.emit("CALL", "V:" + mi.metodo.firma(),
                            String.valueOf(args.size() + 1), "-");
                    return "0";
                }
                String t = tac.tmp(ret);
                tac.emit("CALL", "V:" + mi.metodo.firma(),
                        String.valueOf(args.size() + 1), t,
                        GeneradorC.segmentoDe(ret), "");
                return t;
            }
            throw new RuntimeException("Función no definida: '" + fn + "'.");
        }
        throw new RuntimeException("Expresión no soportada: " + e.getText());
    }

    private static boolean esNodo(ZetarianoParserParser.ExpresionContext e, String id) {
        return e.getChild(0) instanceof TerminalNode tn
                && tn.getSymbol().getType() == ZetarianoParserParser.ID
                && tn.getText().equals(id);
    }

    private static boolean contiene(ZetarianoParserParser.ExpresionContext e, String txt) {
        for (int _ci = 0; _ci < e.getChildCount(); _ci++) {
            ParseTree ch = e.getChild(_ci);
            if (ch instanceof TerminalNode tn && tn.getText().equals(txt)) return true;
        }
        return false;
    }

    private static int indiceHijo(ZetarianoParserParser.ExpresionContext e, String txt) {
        for (int i = 0; i < e.getChildCount(); i++) {
            ParseTree ch = e.getChild(i);
            if (ch instanceof TerminalNode tn && tn.getText().equals(txt)) return i;
        }
        return -1;
    }

    private static ZetarianoParserParser.ParamsContext paramsDe(
            ZetarianoParserParser.ExpresionContext e) {
        for (int _ci = 0; _ci < e.getChildCount(); _ci++) {
            ParseTree ch = e.getChild(_ci);
            if (ch instanceof ZetarianoParserParser.ParamsContext p) return p;
        }
        return null;
    }

    private static boolean esBinario(String o) {
        return o.equals("*") || o.equals("/") || o.equals("%") || o.equals("+") || o.equals("-")
                || o.equals("==") || o.equals("!=") || o.equals("<=") || o.equals(">=")
                || o.equals("<") || o.equals(">") || o.equals("&&") || o.equals("||");
    }
}

