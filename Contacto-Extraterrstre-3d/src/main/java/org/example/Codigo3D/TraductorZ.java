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
            for (ClaseZ.MetodoZ m : cz.metodos.values()) traducirMetodo(cz, m);
        }
        this.actual = null;
        this.metodo = null;
    }

    private void constructorDefecto(ClaseZ cz) {
        tac.emit("FUNC_BEGIN", cz.nombre + "_new", cz.nombre, "-", "STACK", "constructor por defecto");
        este = tac.declara("this", cz.nombre);
        tac.emit("DECLARE", cz.nombre, "-", este, "HEAP", "receptor");
        tac.emit("ALLOC_OBJECT", cz.nombre, "-", este, "HEAP", "reserva en heap");
        tac.emit("RETURN", este, "-", "-");
        tac.emit("FUNC_END", cz.nombre + "_new", "-", "-", "STACK", "");
        tac.retFunc().put(cz.nombre + "_new", cz.nombre);
    }

    private void traducirConstructor(ClaseZ cz, ClaseZ.MetodoZ c) {
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
        for (ZetarianoParserParser.InstruccionContext s : c.ctx.instruccion()) stmZ(s);

        for (ZetarianoParserParser.DeclaracionContext d : c.ctx.declaracion()) declZ(d);
        tac.pop();
        if (!retornado) tac.emit("RETURN", este, "-", "-");
        tac.emit("FUNC_END", cn, "-", "-", "STACK", "");
        tac.retFunc().put(cn, cz.nombre);
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
            throw new RuntimeException("switch no soportado aún en C3D (línea " + s.getStart().getLine() + ")");
        }
        if (s.FOR() != null) {
            if (s.tipos() != null) {
                tac.push();
                String varName = primerIdDirecto(s);
                String eit = tac.declara(varName, ClaseZ.canonZ(s.tipos().getText()));
                tac.emit("DECLARE", ClaseZ.canonZ(s.tipos().getText()), "-", eit, "STACK", "iterador for");
                tac.emit("=", genZ(s.expresion(0)), "-", eit);
                String ini = tac.lbl();
                String fin = tac.lbl();
                tac.emit("LABEL", ini, "-", "-");
                tac.emit("IF_FALSE", genZ(s.expresion(1)), "-", fin);
                tac.pushBreak(fin);
                tac.pushCont(ini);
                for (ZetarianoParserParser.InstruccionContext h : s.instruccion()) stmZ(h);
                String tgt = tac.resolve(varName);
                if (tgt == null) tgt = varName;
                tac.emit(s.DECREMENTO() != null ? "-" : "+", tgt, "1", tgt);
                tac.popBreak(); tac.popCont();
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
            tac.popBreak(); tac.popCont();
            tac.emit("GOTO", ini, "-", "-");
            tac.emit("LABEL", fin, "-", "-");
            return;
        }
        if (s.DO() != null) {
            String ini = tac.lbl();
            String fin = tac.lbl();
            tac.emit("LABEL", ini, "-", "-");
            tac.pushBreak(fin);
            tac.pushCont(ini);
            cuerpoZ(s.instruccion());
            tac.popBreak(); tac.popCont();
            tac.popBreak(); tac.popCont();
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

    private String tipoDecl(ZetarianoParserParser.DeclaracionContext d) {
        if (d.tipos() != null && !d.tipos().isEmpty()) {
            String t = d.tipos().get(0).getText();
            if (!d.LCORCH().isEmpty()) return "series<" + ClaseZ.canonZ(t) + ">";
            return ClaseZ.canonZ(t);
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
        for (ZetarianoParserParser.ExpresionContext a : args) {
            tac.emit("PARAM", genZ(a), "-", "-");
        }
        String e = tac.declara(var, clase);
        tac.emit("DECLARE", clase, "-", e, "HEAP", "objeto en HEAP");
        tac.emit("CALL", clase + "_new", String.valueOf(args.size()), e, "HEAP", "");
        if (!tipo.equals(clase) && !tipo.equals("numerus")) {
            avisos.add("'" + var + "' declarado como " + tipo + " pero recibe new " + clase + ".");
        }
    }

    private void declArreglo(ZetarianoParserParser.DeclaracionContext d) {
        String tipo = tipoDecl(d);
        String var = varDecl(d);
        if (var == null) throw new RuntimeException("Arreglo sin variable: " + d.getText());
        String elem = tipo.startsWith("series<") ? tipo.substring(7, tipo.length() - 1) : "numerus";
        String e = tac.declara(var, tipo);
        tac.emit("DECLARE", tipo, "-", e, "HEAP", "series en HEAP");
        List<ZetarianoParserParser.ExpresionContext> exprs = d.expresion();
        if (d.NEW() != null && !exprs.isEmpty()) {
            tac.emit("ALLOC_SERIES", elem, genZ(exprs.get(0)), e, "HEAP", "reserva en heap");
        } else if (d.params() != null) {
            List<ZetarianoParserParser.ExpresionContext> vals = d.params().expresion();
            tac.emit("ALLOC_SERIES", elem, String.valueOf(vals.size()), e, "HEAP", "reserva en heap");
            for (int i = 0; i < vals.size(); i++) {
                tac.emit("[]=", e, String.valueOf(i), genZ(vals.get(i)), "HEAP", "");
            }
        } else {
            tac.emit("=", "NULL", "-", e, "HEAP", "sin inicializar");
        }
    }

    private void asigZ(ZetarianoParserParser.AsignacionContext a) {
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
        if (a.LCORCH() != null) {
            List<ZetarianoParserParser.ExpresionContext> es = a.expresion();
            String base = leerLugarBase(a.lvalue() != null ? null : null);
            String idtxt = a.getText();
            String var = a.ID() != null ? a.ID().getText()
                    : (a.lvalue() != null && !a.lvalue().ID().isEmpty()
                       ? a.lvalue().ID().get(0).getText() : null);
            if (var == null) throw new RuntimeException("Asignación indexada sin base: " + a.getText());
            String b = tac.resolve(var);
            if (b == null) b = var;
            tac.emit("[]=", b, genZ(es.get(0)), genZ(es.get(es.size() - 1)), "HEAP", "");
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

    private String leerLugar(String nombre) {
        String e = tac.resolve(nombre);
        if (e != null) return e;
        if (actual != null && actual.campos.containsKey(nombre)) {
            String t = tac.tmp(actual.campos.get(nombre));
            tac.emit("=.", este, nombre, t,
                    GeneradorC.segmentoDe(actual.campos.get(nombre)), "");
            return t;
        }
        throw new RuntimeException("Variable no declarada: '" + nombre + "'.");
    }

    private String leerLugarBase(String ign) {
        return ign;
    }

    private boolean esCampo(String nombre) {
        return tac.resolve(nombre) == null
                && actual != null && actual.campos.containsKey(nombre);
    }

    private void escribirLugar(String nombre, String valor) {
        String e = tac.resolve(nombre);
        if (e != null) {
            tac.emit("=", valor, "-", e, GeneradorC.segmentoDe(tac.tipoDe(e)), "");
            return;
        }
        if (actual != null && actual.campos.containsKey(nombre)) {
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
        if (bplace == null && actual != null && actual.campos.containsKey(base)) {
            baseCampo = true;
            bplace = este;
        }
        if (bplace == null) throw new RuntimeException("Variable no declarada: '" + base + "'.");
        if (ids.size() == 1 && lv.expresion().isEmpty()) {
            if (baseCampo) tac.emit(".=", este, base, valor,
                    GeneradorC.segmentoDe(tac.tipoDe(valor)), "");
            else tac.emit("=", valor, "-", bplace,
                    GeneradorC.segmentoDe(tac.tipoDe(bplace)), "");
            return;
        }
        String cur = baseCampo ? leerLugar(base) : bplace;
        String curTipo = tac.tipoDe(cur);
        int ei = 0;
        for (int i = 1; i < ids.size(); i++) {
            String campo = ids.get(i).getText();
            ClaseZ cz = TraductorPigY.clases().get(curTipo);
            String tCampo = (cz != null && cz.campos.containsKey(campo))
                    ? cz.campos.get(campo) : "numerus";
            String t = tac.tmp(tCampo);
            tac.emit("=.", cur, campo, t, GeneradorC.segmentoDe(tCampo), "");
            cur = t;
            curTipo = tCampo;
        }
        for (ZetarianoParserParser.ExpresionContext idx : lv.expresion()) {
            String t = tac.tmp(curTipo);
            tac.emit("=[]", cur, genZ(idx), t, GeneradorC.segmentoDe(curTipo), "");
            cur = t;
            ei++;
        }
        if (ei > 0) {
            tac.emit("[]=", bplace, "0", valor, "HEAP", "");
        } else {
            tac.emit("=", valor, "-", cur, GeneradorC.segmentoDe(tac.tipoDe(cur)), "");
        }
    }

    private String genZ(ZetarianoParserParser.ExpresionContext e) {
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
                ClaseZ.MetodoZ mm = cz.metodos.get(met);
                if (mm == null) {
                    throw new RuntimeException("Método no definido: '" + tipoR + "." + met + "'.");
                }
                if (mm.params.size() != args.size()) {
                    throw new RuntimeException("Aridad incorrecta: '" + tipoR + "." + met
                            + "' espera " + mm.params.size() + " pero se dieron " + args.size() + ".");
                }
                tac.emit("PARAM", rplace, "-", "-");
                for (String ap : args) tac.emit("PARAM", ap, "-", "-");
                if (mm.retorno.equals("void")) {
                    tac.emit("CALL", tipoR + "_" + met,
                            String.valueOf(args.size() + 1), "-");
                    return "0";
                }
                String t = tac.tmp(mm.retorno);
                tac.emit("CALL", tipoR + "_" + met, String.valueOf(args.size() + 1), t,
                        GeneradorC.segmentoDe(mm.retorno), "");
                return t;
            }
        }
        if (n == 3 && e.getChild(1).getText().equals(".")
                && e.getChild(0) instanceof ZetarianoParserParser.ExpresionContext recv
                && e.getChild(2) instanceof TerminalNode tnf) {
            String rplace = genZ(recv);
            String tipoR = tac.tipoDe(rplace);
            ClaseZ cz = TraductorPigY.clases().get(tipoR);
            String tCampo = (cz != null && cz.campos.containsKey(tnf.getText()))
                    ? cz.campos.get(tnf.getText()) : "numerus";
            String t = tac.tmp(tCampo);
            tac.emit("=.", rplace, tnf.getText(), t, GeneradorC.segmentoDe(tCampo), "");
            return t;
        }
        if (n == 4 && e.getChild(1).getText().equals("[")
                && e.getChild(0) instanceof ZetarianoParserParser.ExpresionContext recv
                && e.getChild(2) instanceof ZetarianoParserParser.ExpresionContext idx) {
            String rplace = genZ(recv);
            String t = tac.tmp("numerus");
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
            if (actual != null && actual.metodos.containsKey(fn)) {
                ClaseZ.MetodoZ mm = actual.metodos.get(fn);
                if (mm.params.size() != args.size()) {
                    throw new RuntimeException("Aridad incorrecta: '" + fn + "'.");
                }
                tac.emit("PARAM", este, "-", "-");
                for (String ap : args) tac.emit("PARAM", ap, "-", "-");
                if (mm.retorno.equals("void")) {
                    tac.emit("CALL", actual.nombre + "_" + fn,
                            String.valueOf(args.size() + 1), "-");
                    return "0";
                }
                String t = tac.tmp(mm.retorno);
                tac.emit("CALL", actual.nombre + "_" + fn,
                        String.valueOf(args.size() + 1), t,
                        GeneradorC.segmentoDe(mm.retorno), "");
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

