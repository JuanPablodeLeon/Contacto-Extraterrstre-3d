package org.example.Semantico;

import antlr4.com.antlr4.com.ZetarianoParserBaseVisitor;
import antlr4.com.antlr4.com.ZetarianoParserParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.Reports.ErrorReporter;

import java.util.*;

public class SemanticoZ  extends ZetarianoParserBaseVisitor<Tipo> {
    public static class Metodo {
        public final boolean constructor;
        public final String nombre;
        public final Tipo retorno;
        public final List<Tipo> tiposParams = new ArrayList<>();
        public final List<String> nombresParams = new ArrayList<>();
        public final ZetarianoParserParser.InstruccionesContext ctx;
        public Metodo(boolean constructor, String nombre, Tipo retorno, ZetarianoParserParser.InstruccionesContext ctx) {
            this.constructor = constructor;
            this.nombre = nombre;
            this.retorno = retorno;
            this.ctx = ctx;
        }
    }

    private final TablaSimbolos tabla = new TablaSimbolos();
    private final ErrorReporter errores;
    private String claseActual = "?";
    private final Map<String, List<Metodo>> metodos = new LinkedHashMap<>();
    private final List<Metodo> constructores = new ArrayList<>();
    private Metodo metodoActual;
    private int profundidadCiclo = 0;
    private int profundidadSwitch = 0;

    public SemanticoZ(ErrorReporter errores) {
        this.errores = errores;
    }

    public TablaSimbolos getTabla() {
        return tabla;
    }

    public String getClase() {
        return claseActual;
    }

    public void analizar(ZetarianoParserParser.InicioContext tree) {
        visitInicio(tree);
    }

    private int linea(ParseTree n) {
        if (n instanceof org.antlr.v4.runtime.ParserRuleContext c) return c.getStart().getLine();
        return 1;
    }

    @Override
    public Tipo visitInicio(ZetarianoParserParser.InicioContext ctx) {
        if (ctx.bloc_main() == null) return Tipo.VOID;
        claseActual = ctx.bloc_main().ID().getText();
        for (ZetarianoParserParser.InstruccionesContext ins : ctx.bloc_main().instrucciones()) {
            if (ins.PUBLIC() == null) {
                for (ZetarianoParserParser.DeclaracionContext d : ins.declaracion()) {
                    registrarCampo(d);
                }
            } else {
                registrarMiembro(ins);
            }
        }
        for (ZetarianoParserParser.InstruccionesContext ins : ctx.bloc_main().instrucciones()) {
            if (ins.PUBLIC() != null) visitarMiembro(ins);
        }
        return Tipo.VOID;
    }

    private Tipo tipoDeclarado(ZetarianoParserParser.DeclaracionContext d) {
        if (!d.tipos().isEmpty()) return Tipo.desdeZ(d.tipos().get(0).getText());
        List<TerminalNode> ids = d.ID();
        if (ids.size() >= 2) return Tipo.desdeZ(ids.get(0).getText());
        return Tipo.ERROR;
    }

    private String campoDeclarado(ZetarianoParserParser.DeclaracionContext d) {
        List<TerminalNode> ids = d.ID();
        if (ids.isEmpty()) return "?";
        if (!d.tipos().isEmpty()) return ids.get(0).getText();
        if (ids.size() >= 2) return ids.get(1).getText();
        return ids.get(0).getText();
    }

    private void registrarCampo(ZetarianoParserParser.DeclaracionContext d) {
        String campo = campoDeclarado(d);
        Tipo tipo = tipoDeclarado(d);
        int dims = d.LCORCH().size() / 2;
        if (d.LCORCH().size() > 0 && d.NEW() == null && dims == 0) dims = d.LCORCH().size();

        int ndims = d.RCORCH().size();
        for (int i = 0; i < ndims; i++) tipo = Tipo.series(tipo);
        if (tabla.existeLocal(campo)) {
            errores.semantico(linea(d), "Campo duplicado: '" + campo + "' en clase '" + claseActual + "'.");
            return;
        }
        VarSymbol vs = new VarSymbol(campo, linea(d), tipo);
        tabla.definirVar(vs);
        StructSimbolo s = tabla.obtenerStruct(claseActual);
        if (s == null) {
            s = new StructSimbolo(claseActual, linea(d));
            tabla.definirStruct(s);
        }
        s.campos.putIfAbsent(campo, tipo);
    }

    private void registrarMiembro(ZetarianoParserParser.InstruccionesContext ins) {
        List<TerminalNode> ids = ins.ID();
        if (ids.isEmpty()) return;
        boolean tieneVoid = ins.VOID() != null;
        boolean tieneTipos = ins.tipos() != null;
        if (!tieneVoid && !tieneTipos && ids.size() == 1
                && ids.get(0).getText().equals(claseActual)) {
            Metodo m = new Metodo(true, ids.get(0).getText(), Tipo.struct(claseActual), ins);
            extraerParams(ins.param_var(), m);
            if (firmaDuplicada(constructores, m)) {
                errores.semantico(linea(ins), "Constructor duplicado con la misma aridad en '" + claseActual + "'.");
            }
            constructores.add(m);
        } else {
            String nombreMet = ids.get(ids.size() - 1).getText();
            Tipo ret;
            if (tieneVoid) ret = Tipo.VOID;
            else if (tieneTipos) ret = Tipo.desdeZ(ins.tipos().getText());
            else if (ids.size() >= 2) ret = Tipo.desdeZ(ids.get(ids.size() - 2).getText());
            else ret = Tipo.VOID;
            Metodo m = new Metodo(false, nombreMet, ret, ins);
            extraerParams(ins.param_var(), m);
            metodos.computeIfAbsent(nombreMet, k -> new ArrayList<>());
            if (firmaDuplicada(metodos.get(nombreMet), m)) {
                errores.semantico(linea(ins), "Método duplicado: '" + nombreMet
                        + "' con la misma aridad en '" + claseActual + "'.");
            }
            metodos.get(nombreMet).add(m);
        }
    }

    private boolean firmaDuplicada(List<Metodo> lista, Metodo m) {
        for (Metodo e : lista) {
            if (e.tiposParams.size() == m.tiposParams.size()) return true;
        }
        return false;
    }

    private void extraerParams(ZetarianoParserParser.Param_varContext pv, Metodo m) {
        if (pv == null) return;

        String pendiente = null;
        Set<String> vistos = new HashSet<>();
        for (int i = 0; i < pv.getChildCount(); i++) {
            ParseTree ch = pv.getChild(i);
            if (ch instanceof ZetarianoParserParser.TiposContext t) {
                pendiente = t.getText();
            } else if (ch instanceof TerminalNode tn) {
                if (tn.getText().equals(",")) continue;
                ParseTree sig = null;
                for (int k = i + 1; k < pv.getChildCount(); k++) {
                    ParseTree c2 = pv.getChild(k);
                    if (c2 instanceof TerminalNode t2 && t2.getText().equals(",")) continue;
                    sig = c2;
                    break;
                }
                if (sig instanceof ZetarianoParserParser.ExpresionContext) pendiente = tn.getText();
            } else if (ch instanceof ZetarianoParserParser.ExpresionContext e) {
                String nombre = e.getText();
                if (!nombre.matches("[a-zA-Z_][a-zA-Z_0-9]*")) nombre = "p" + m.tiposParams.size();
                if (!vistos.add(nombre)) {
                    errores.semantico(linea(pv), "Parámetro duplicado: '" + nombre + "'.");
                }
                m.tiposParams.add(Tipo.desdeZ(pendiente == null ? "int" : pendiente));
                m.nombresParams.add(nombre);
                pendiente = null;
            }
        }
    }

    private void visitarMiembro(ZetarianoParserParser.InstruccionesContext ins) {
        List<TerminalNode> ids = ins.ID();
        if (ids.isEmpty()) return;
        boolean tieneVoid = ins.VOID() != null;
        boolean tieneTipos = ins.tipos() != null;
        Metodo m;
        if (!tieneVoid && !tieneTipos && ids.size() == 1) {
            m = buscarPorAridad(constructores, tamParams(ins.param_var()));
            if (m == null) return;
        } else {
            String nombreMet = ids.get(ids.size() - 1).getText();
            List<Metodo> cands = metodos.getOrDefault(nombreMet, List.of());
            m = buscarPorAridad(cands, tamParams(ins.param_var()));
            if (m == null) return;
        }
        Metodo previo = metodoActual;
        metodoActual = m;
        int cicloPrevio = profundidadCiclo;
        profundidadCiclo = 0;
        tabla.entrar((m.constructor ? "constructor: " : "metodo: ") + m.nombre);
        for (int i = 0; i < m.nombresParams.size(); i++) {
            tabla.definirVar(new VarSymbol(m.nombresParams.get(i), linea(ins), m.tiposParams.get(i)));
        }
        boolean yaRetorno = false;
        for (ZetarianoParserParser.InstruccionContext s : ins.instruccion()) {
            if (yaRetorno) errores.semantico(linea(s), "Código inalcanzable: ya existe 'return' antes.");
            visitInstruccion(s);
            if (s.RETURN() != null) yaRetorno = true;
        }
        if (!m.constructor && m.retorno.base != Tipo.Base.VOID && !siempreRetorna(ins.instruccion())) {
            errores.semantico(linea(ins), "El método '" + m.nombre + "' debe retornar " + m.retorno + " (falta 'return').");
        }
        tabla.salir();
        profundidadCiclo = cicloPrevio;
        metodoActual = previo;
    }

    private int tamParams(ZetarianoParserParser.Param_varContext pv) {
        if (pv == null) return 0;
        return pv.expresion().size();
    }

    private Metodo buscarPorAridad(List<Metodo> lista, int n) {
        for (Metodo m : lista) {
            if (m.tiposParams.size() == n) return m;
        }
        return lista.isEmpty() ? null : lista.get(0);
    }

    private boolean siempreRetorna(List<ZetarianoParserParser.InstruccionContext> stms) {
        for (ZetarianoParserParser.InstruccionContext s : stms) {
            if (s.RETURN() != null) return true;
            if (s.IF() != null && s.bloque_si() != null) {
                ZetarianoParserParser.Bloque_siContext bs = s.bloque_si();
                boolean tieneElse = bs.children != null && bs.children.stream()
                        .anyMatch(c -> c instanceof ZetarianoParserParser.InstruccionContext);
                boolean ramas = siempreRetorna(s.instruccion());
                if (ramas && tieneElse) {
                    boolean todo = true;
                    for (ZetarianoParserParser.InstruccionContext h : bs.instruccion()) {
                        todo = todo && true;
                    }
                    if (todo) return true;
                }
            }
        }
        return false;
    }

    @Override
    public Tipo visitInstruccion(ZetarianoParserParser.InstruccionContext ctx) {
        if (ctx.declaracion() != null) return visitarDeclaracion(ctx.declaracion());
        if (ctx.asignacion() != null) return visitarAsignacion(ctx.asignacion());
        if (ctx.IF() != null && ctx.LLLAVE() != null) {
            exigirBool(tipoExpresion(ctx.expresion(0)), linea(ctx), "'if'");
            tabla.entrar("if");
            for (ZetarianoParserParser.InstruccionContext s : ctx.instruccion()) visitInstruccion(s);
            tabla.salir();
            ZetarianoParserParser.Bloque_siContext bs = ctx.bloque_si();
            if (bs != null) {
                for (ZetarianoParserParser.ExpresionContext c : bs.expresion()) {
                    exigirBool(tipoExpresion(c), linea(ctx), "'else if'");
                }
                if (bs.children != null) {
                    for (ParseTree ch : bs.children) {
                        if (ch instanceof ZetarianoParserParser.InstruccionContext h) {
                            tabla.entrar("else");
                            visitInstruccion(h);
                            tabla.salir();
                        }
                    }
                }
            }
            return Tipo.VOID;
        }
        if (ctx.IF() != null && ctx.ELSE() != null && ctx.LLLAVE() == null) {
            exigirBool(tipoExpresion(ctx.expresion(0)), linea(ctx), "'if'");
            List<ZetarianoParserParser.InstruccionContext> hijos = ctx.instruccion();
            for (ZetarianoParserParser.InstruccionContext h : hijos) visitInstruccion(h);
            return Tipo.VOID;
        }
        if (ctx.IF() != null) {
            exigirBool(tipoExpresion(ctx.expresion(0)), linea(ctx), "'if'");
            for (ZetarianoParserParser.InstruccionContext h : ctx.instruccion()) visitInstruccion(h);
            return Tipo.VOID;
        }
        if (ctx.SWITCH() != null) {
            String var = ctx.ID(0).getText();
            VarSymbol vs = tabla.obtenerVar(var);
            if (vs == null) {
                errores.semantico(linea(ctx), "La variable no ha sido declarada: '" + var + "'.");
            } else if (!vs.type.esPrimitivo() && !vs.type.esError()) {
                errores.semantico(linea(ctx), "El 'switch' solo admite int, char o String.");
            }
            profundidadSwitch++;
            for (ZetarianoParserParser.Bloque_switchContext b : ctx.bloque_switch()) {
                Tipo tc = tipoExpresion(b.expresion());
                if (vs != null && !vs.type.esError() && !tc.esError()
                        && !Tipo.asignableZ(vs.type, tc) && !Tipo.asignableZ(tc, vs.type)) {
                    errores.semantico(linea(b), "El 'case' " + tc + " no es compatible con " + vs.type + ".");
                }
                profundidadCiclo++;
                for (ZetarianoParserParser.InstruccionContext h : b.instruccion()) visitInstruccion(h);
                profundidadCiclo--;
            }
            profundidadSwitch--;
            for (ZetarianoParserParser.InstruccionContext h : ctx.instruccion()) visitInstruccion(h);
            return Tipo.VOID;
        }
        if (ctx.FOR() != null) {
            tabla.entrar("for");
            List<ZetarianoParserParser.ExpresionContext> exprs = ctx.expresion();
            if (ctx.tipos() != null && !ctx.ID().isEmpty()) {
                Tipo tIter = Tipo.desdeZ(ctx.tipos().getText());
                String var = ctx.ID(0).getText();
                if (!exprs.isEmpty()) {
                    Tipo tInit = tipoExpresion(exprs.get(0));
                    if (!tIter.esError() && !tInit.esError() && !Tipo.asignableZ(tIter, tInit)) {
                        errores.semantico(linea(ctx), "El iterador '" + var + "' (" + tIter
                                + ") no acepta " + tInit + ".");
                    }
                }
                tabla.definirVar(new VarSymbol(var, linea(ctx), tIter));
                if (exprs.size() > 1) exigirBool(tipoExpresion(exprs.get(1)), linea(ctx), "'for'");
                if (!ctx.ID().isEmpty()) {
                    String inc = ctx.ID(ctx.ID().size() - 1).getText();
                    VarSymbol vi = tabla.obtenerVar(inc);
                    if (vi == null) {
                        errores.semantico(linea(ctx), "La variable no ha sido declarada: '" + inc + "'.");
                    } else if (!vi.type.esNumero() && !vi.type.esError()) {
                        errores.semantico(linea(ctx), "El incremento de 'for' solo aplica a int/double.");
                    }
                }
            } else if (!exprs.isEmpty()) {
                exigirBool(tipoExpresion(exprs.get(0)), linea(ctx), "'for'");
            }
            profundidadCiclo++;
            for (ZetarianoParserParser.InstruccionContext h : ctx.instruccion()) visitInstruccion(h);
            profundidadCiclo--;
            tabla.salir();
            return Tipo.VOID;
        }
        if (ctx.WHILE() != null && ctx.DO() == null) {
            exigirBool(tipoExpresion(ctx.expresion(0)), linea(ctx), "'while'");
            profundidadCiclo++;
            tabla.entrar("while");
            for (ZetarianoParserParser.InstruccionContext h : ctx.instruccion()) visitInstruccion(h);
            tabla.salir();
            profundidadCiclo--;
            return Tipo.VOID;
        }
        if (ctx.DO() != null) {
            profundidadCiclo++;
            tabla.entrar("do");
            for (ZetarianoParserParser.InstruccionContext h : ctx.instruccion()) visitInstruccion(h);
            tabla.salir();
            profundidadCiclo--;
            exigirBool(tipoExpresion(ctx.expresion(0)), linea(ctx), "'do ... while'");
            return Tipo.VOID;
        }
        if (ctx.PRINTLN() != null || ctx.PRINT() != null) {
            if (!ctx.expresion().isEmpty()) tipoExpresion(ctx.expresion(0));
            return Tipo.VOID;
        }
        if (ctx.READLN() != null) return Tipo.VOID;
        if (ctx.BREAK() != null) {
            if (profundidadCiclo == 0 && profundidadSwitch == 0) {
                errores.semantico(linea(ctx), "'break' usado fuera de un ciclo o 'switch'.");
            }
            return Tipo.VOID;
        }
        if (ctx.CONTINUE() != null) {
            if (profundidadCiclo == 0) {
                errores.semantico(linea(ctx), "'continue' usado fuera de un ciclo.");
            }
            return Tipo.VOID;
        }
        if (ctx.RETURN() != null) {
            if (metodoActual == null) {
                errores.semantico(linea(ctx), "'return' usado fuera de un método.");
                return Tipo.VOID;
            }
            if (ctx.expresion().isEmpty()) {
                if (metodoActual.retorno.base != Tipo.Base.VOID && !metodoActual.constructor) {
                    errores.semantico(linea(ctx), "El método '" + metodoActual.nombre
                            + "' debe devolver " + metodoActual.retorno + ".");
                }
            } else {
                Tipo real = tipoExpresion(ctx.expresion(0));
                if (metodoActual.constructor) {
                    errores.semantico(linea(ctx), "El constructor no puede devolver valores.");
                } else if (metodoActual.retorno.base == Tipo.Base.VOID) {
                    errores.semantico(linea(ctx), "El método '" + metodoActual.nombre
                            + "' es void y no puede devolver valores.");
                } else if (!metodoActual.retorno.esError() && !real.esError()
                        && !Tipo.asignableZ(metodoActual.retorno, real)) {
                    errores.semantico(linea(ctx), mensajeRetorno(metodoActual.retorno, real));
                }
            }
            return Tipo.VOID;
        }
        if (!ctx.expresion().isEmpty()) {
            tipoExpresion(ctx.expresion(0));
            return Tipo.VOID;
        }
        return Tipo.VOID;
    }

    private Tipo visitarDeclaracion(ZetarianoParserParser.DeclaracionContext d) {
        int ln = linea(d);
        List<TerminalNode> ids = d.ID();
        if (d.NEW() != null && !d.LCORCH().isEmpty() && d.LPAREN() == null) {
            String tipoBase = d.tipos().isEmpty() ? ids.get(0).getText() : d.tipos().get(0).getText();
            Tipo elem = Tipo.desdeZ(tipoBase);
            for (ZetarianoParserParser.ExpresionContext sz : d.expresion()) {
                Tipo t = tipoExpresion(sz);
                if (!t.esError() && t.base != Tipo.Base.ENTERO) {
                    errores.semantico(linea(sz), "El tamaño del arreglo debe ser int.");
                }
            }
            int ndims = d.RCORCH().size();
            Tipo t = elem;
            for (int i = 0; i < ndims; i++) t = Tipo.series(t);
            String campo = campoDeclarado(d);
            declararLocal(campo, t, ln);
            return t;
        }
        if (d.LLLAVE() != null && d.params() != null) {
            Tipo elem = tipoDeclarado(d);
            String campo = campoDeclarado(d);
            for (ZetarianoParserParser.ExpresionContext v : d.params().expresion()) {
                Tipo real = tipoExpresion(v);
                if (!elem.esError() && !real.esError() && !Tipo.asignableZ(elem, real)) {
                    errores.semantico(linea(v), "Valor " + real + " incompatible con el arreglo de " + elem + ".");
                }
            }
            Tipo t = Tipo.series(elem);
            declararLocal(campo, t, ln);
            return t;
        }
        if (d.NEW() != null && d.LPAREN() != null) {
            String clase = ids.get(ids.size() - 1).getText();
            List<Tipo> args = tiposParams(d.params());
            validarConstructor(clase, args, ln);
            Tipo tObj = Tipo.struct(clase);
            String campo;
            if (!d.tipos().isEmpty() || ids.size() >= 2) campo = campoDeclarado(d);
            else campo = ids.get(0).getText();
            if (d.tipos().isEmpty() && ids.size() == 1) {
                VarSymbol vs = tabla.obtenerVar(campo);
                if (vs == null) {
                    errores.semantico(ln, "La variable no ha sido declarada: '" + campo + "'.");
                    return Tipo.ERROR;
                }
                if (!vs.type.esError() && !Tipo.asignableZ(vs.type, tObj)) {
                    errores.semantico(ln, "No se puede asignar " + tObj + " a '" + campo + "' de " + vs.type + ".");
                }
                return vs.type;
            }
            declararLocal(campo, tObj, ln);
            return tObj;
        }
        Tipo declarado = tipoDeclarado(d);
        String campo = campoDeclarado(d);
        if (!d.expresion().isEmpty()) {
            Tipo real = tipoExpresion(d.expresion().get(0));
            if (!declarado.esError() && !real.esError() && !Tipo.asignableZ(declarado, real)) {
                errores.semantico(ln, mensajeAsignacion(campo, declarado, real));
            }
        }
        declararLocal(campo, declarado, ln);
        return declarado;
    }

    private void declararLocal(String nombre, Tipo tipo, int ln) {
        if (tabla.existeLocal(nombre)) {
            errores.semantico(ln, "Variable ya declarada: '" + nombre + "'.");
            return;
        }
        tabla.definirVar(new VarSymbol(nombre, ln, tipo));
    }

    private List<Tipo> tiposParams(ZetarianoParserParser.ParamsContext p) {
        List<Tipo> out = new ArrayList<>();
        if (p == null) return out;
        for (ZetarianoParserParser.ExpresionContext e : p.expresion()) out.add(tipoExpresion(e));
        return out;
    }

    private void validarConstructor(String clase, List<Tipo> args, int ln) {
        if (clase.equals(claseActual)) {
            if (constructores.isEmpty() && args.isEmpty()) return;
            for (Metodo c : constructores) {
                if (c.tiposParams.size() == args.size() && paramsCompatibles(c, args)) return;
            }
            errores.semantico(ln, "Constructor no coincide: 'new " + clase
                    + "' con " + args.size() + " argumento(s).");
            return;
        }
    }

    private boolean paramsCompatibles(Metodo m, List<Tipo> args) {
        for (int i = 0; i < args.size(); i++) {
            Tipo esp = m.tiposParams.get(i);
            Tipo real = args.get(i);
            if (!esp.esError() && !real.esError() && !Tipo.asignableZ(esp, real)) return false;
        }
        return true;
    }

    private Tipo visitarAsignacion(ZetarianoParserParser.AsignacionContext a) {
        int ln = linea(a);
        List<ZetarianoParserParser.ExpresionContext> exprs = a.expresion();
        if (a.SUMA_IGL() != null || a.RESTA_IGL() != null || a.MULT_IGL() != null) {
            String var = a.ID().getText();
            VarSymbol vs = tabla.obtenerVar(var);
            Tipo real = tipoExpresion(exprs.get(0));
            if (vs == null) {
                errores.semantico(ln, "La variable no ha sido declarada: '" + var + "'.");
                return Tipo.ERROR;
            }
            if (!vs.type.esNumero() && !vs.type.esError()) {
                errores.semantico(ln, "La asignación compuesta solo aplica a int/double.");
                return vs.type;
            }
            if (!real.esNumero() && !real.esError()) {
                errores.semantico(ln, "La asignación compuesta solo acepta expresiones numéricas.");
                return vs.type;
            }
            if (!vs.type.esError() && !real.esError() && !Tipo.asignableZ(vs.type, real)) {
                errores.semantico(ln, "No se puede aplicar '" + a.getChild(1).getText() + "' con "
                        + real + " a '" + var + "' de " + vs.type + ".");
            }
            return vs.type;
        }
        if (a.INTERRG() != null) {
            String var = a.ID().getText();
            VarSymbol vs = tabla.obtenerVar(var);
            Tipo cond = tipoExpresion(exprs.get(0));
            Tipo r1 = tipoExpresion(exprs.get(1));
            Tipo r2 = tipoExpresion(exprs.get(2));
            exigirBool(cond, ln, "operador ternario");
            Tipo res = Tipo.ERROR;
            if (!r1.esError() && !r2.esError()) {
                if (Tipo.asignableZ(r1, r2)) res = r1;
                else if (Tipo.asignableZ(r2, r1)) res = r2;
                else {
                    errores.semantico(ln, "Las ramas del ternario (" + r1 + " : " + r2 + ") no son compatibles.");
                    res = Tipo.ERROR;
                }
            } else if (!r1.esError()) res = r1;
            else if (!r2.esError()) res = r2;
            if (vs == null) {
                errores.semantico(ln, "La variable no ha sido declarada: '" + var + "'.");
                return Tipo.ERROR;
            }
            if (!vs.type.esError() && !res.esError() && !Tipo.asignableZ(vs.type, res)) {
                errores.semantico(ln, "El ternario " + res + " no es compatible con '" + var + "' de " + vs.type + ".");
            }
            return vs.type;
        }
        if (a.LCORCH() != null) {
            String var = a.ID().getText();
            VarSymbol vs = tabla.obtenerVar(var);
            if (vs == null) {
                errores.semantico(ln, "La variable no ha sido declarada: '" + var + "'.");
                return Tipo.ERROR;
            }
            if (vs.type.base != Tipo.Base.SERIES) {
                errores.semantico(ln, "No es un arreglo: '" + var + "'.");
                return Tipo.ERROR;
            }
            Tipo tIdx = tipoExpresion(exprs.get(0));
            if (!tIdx.esError() && tIdx.base != Tipo.Base.ENTERO) {
                errores.semantico(linea(exprs.get(0)), "El índice del arreglo debe ser int.");
            }
            Tipo real = tipoExpresion(exprs.get(1));
            if (!vs.type.elementos.esError() && !real.esError()
                    && !Tipo.asignableZ(vs.type.elementos, real)) {
                errores.semantico(ln, "No se puede asignar " + real + " al arreglo '" + var
                        + "' de " + vs.type.elementos + ".");
            }
            return vs.type.elementos;
        }
        if (a.INCREMENTO() != null || a.DECREMENTO() != null) {
            VarSymbol vs = tabla.obtenerVar(a.ID().getText());
            if (vs == null) {
                errores.semantico(ln, "La variable no ha sido declarada: '" + a.ID().getText() + "'.");
                return Tipo.ERROR;
            }
            if (!vs.type.esNumero() && !vs.type.esError()) {
                errores.semantico(ln, "El operador '++/--' solo aplica a int/double.");
            }
            return vs.type;
        }
        Tipo tLv = tipoLvalue(a.lvalue());
        Tipo real = tipoExpresion(exprs.get(exprs.size() - 1));
        if (!tLv.esError() && !real.esError() && !Tipo.asignableZ(tLv, real)) {
            errores.semantico(ln, mensajeAsignacion(a.lvalue().getText(), tLv, real));
        }
        return tLv;
    }

    private String mensajeAsignacion(String destinoNombre, Tipo destino, Tipo origen) {
        if (origen.base == Tipo.Base.NULL) {
            return "null solo es asignable a referencias (objetos, String, arreglos): "
                    + "no es compatible con '" + destinoNombre + "' de " + destino + ".";
        }
        return "No se puede asignar " + origen + " a '" + destinoNombre + "' de " + destino + ".";
    }

    private String mensajeRetorno(Tipo esperado, Tipo real) {
        if (real.base == Tipo.Base.NULL) {
            return "null solo es asignable a referencias (objetos, String, arreglos): "
                    + "el 'return' null no es compatible con " + esperado + ".";
        }
        return "El 'return' " + real + " no es compatible con " + esperado + ".";
    }

    private Tipo tipoLvalue(ZetarianoParserParser.LvalueContext lv) {
        if (lv == null) return Tipo.ERROR;
        List<TerminalNode> ids = lv.ID();
        if (ids.isEmpty()) return Tipo.ERROR;
        VarSymbol vs = tabla.obtenerVar(ids.get(0).getText());
        if (vs == null) {
            errores.semantico(linea(lv), "La variable no ha sido declarada: '" + ids.get(0).getText() + "'.");
            return Tipo.ERROR;
        }
        Tipo actual = vs.type;
        int nExpr = lv.expresion().size();
        int e = 0;
        String txt = lv.getText();
        for (int i = 1; i < ids.size(); i++) {
            if (actual.base == Tipo.Base.SERIES) {
                if (e < nExpr) {
                    Tipo tIdx = tipoExpresion(lv.expresion(e++));
                    if (!tIdx.esError() && tIdx.base != Tipo.Base.ENTERO) {
                        errores.semantico(linea(lv), "El índice del arreglo debe ser int.");
                    }
                }
                actual = actual.elementos;
            }
            if (actual.base != Tipo.Base.STRUCT) {
                errores.semantico(linea(lv), "'" + ids.get(i - 1).getText() + "' no es un objeto (es " + actual + ").");
                return Tipo.ERROR;
            }
            String campo = ids.get(i).getText();
            StructSimbolo s = tabla.obtenerStruct(actual.nombreStruct);
            if (s != null && s.tieneCampo(campo)) {
                actual = s.tipoCampo(campo);
            } else if (actual.nombreStruct.equals(claseActual)) {
                errores.semantico(linea(lv), "Campo no definido: '" + actual + "." + campo + "'.");
                return Tipo.ERROR;
            } else {
                return Tipo.ERROR;
            }
        }
        while (e < nExpr) {
            if (actual.base != Tipo.Base.SERIES) {
                errores.semantico(linea(lv), "No es un arreglo: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            Tipo tIdx = tipoExpresion(lv.expresion(e++));
            if (!tIdx.esError() && tIdx.base != Tipo.Base.ENTERO) {
                errores.semantico(linea(lv), "El índice del arreglo debe ser int.");
            }
            actual = actual.elementos;
        }
        return actual;
    }

    public Tipo tipoExpresion(ZetarianoParserParser.ExpresionContext e) {
        int n = e.getChildCount();
        if (n == 1) {
            ParseTree ch = e.getChild(0);
            if (ch instanceof TerminalNode tn) {
                String t = tn.getText();
                if (e.TRUE() != null || t.equals("true")) return Tipo.BOOL;
                if (e.FALSE() != null || t.equals("false")) return Tipo.BOOL;
                if (e.NULL_VAL() != null || t.equals("null")) return Tipo.NULL;
                if (e.INTEGER() != null) return Tipo.ENTERO;
                if (e.DOUBLES() != null) return Tipo.FLOTANTE;
                if (e.STRINGS() != null) return Tipo.CADENA;
                if (e.CHARS() != null) return Tipo.CARACTER;
                if (e.ID() != null) {
                    VarSymbol vs = tabla.obtenerVar(t);
                    if (vs != null) return vs.type;
                    errores.semantico(tn.getSymbol().getLine(),
                            "La variable no ha sido declarada: '" + t + "'.");
                    return Tipo.ERROR;
                }
                return Tipo.ERROR;
            }
            if (ch instanceof ZetarianoParserParser.ExpresionContext sub) return tipoExpresion(sub);
            if (ch instanceof ZetarianoParserParser.ParamsContext p) {
                return Tipo.ERROR;
            }
            return Tipo.ERROR;
        }
        if (n == 2) {
            String op = e.getChild(0).getText();
            Tipo v = tipoExpresion((ZetarianoParserParser.ExpresionContext) e.getChild(1));
            if (op.equals("-")) {
                if (!v.esNumero() && !v.esError()) {
                    errores.semantico(linea(e), "El operador '-' solo aplica a int/double.");
                    return Tipo.ERROR;
                }
                return v;
            }
            if (op.equals("!")) {
                if (!v.equals(Tipo.BOOL) && !v.esError()) {
                    errores.semantico(linea(e), "El operador '!' solo aplica a boolean.");
                }
                return Tipo.BOOL;
            }
            return Tipo.ERROR;
        }
        if (n == 3) {
            String a = e.getChild(0).getText();
            ParseTree c3 = e.getChild(2);
            if (a.equals("(") && c3.getText().equals(")")) {
                return tipoExpresion((ZetarianoParserParser.ExpresionContext) e.getChild(1));
            }
        }
        if (e.MULT() != null || e.DIV() != null) {
            Tipo l = tipoExpresion(e.expresion(0));
            Tipo r = tipoExpresion(e.expresion(1));
            String op = e.MULT() != null ? "*" : "/";
            return aritmetica(l, op, r, linea(e), false);
        }
        if (e.MOD() != null) {
            Tipo l = tipoExpresion(e.expresion(0));
            Tipo r = tipoExpresion(e.expresion(1));
            return aritmetica(l, "%", r, linea(e), true);
        }
        if (e.SUMA() != null || e.getChildCount() > 1
                && (e.getChild(1).getText().equals("+") || e.getChild(1).getText().equals("-"))) {
            if (e.expresion().size() >= 2) {
                Tipo l = tipoExpresion(e.expresion(0));
                Tipo r = tipoExpresion(e.expresion(1));
                String op = e.getChild(1).getText();
                if (op.equals("+") && (l.base == Tipo.Base.CADENA || r.base == Tipo.Base.CADENA)) {
                    if (!l.esPrimitivo() && l.base != Tipo.Base.CADENA
                            || !r.esPrimitivo() && r.base != Tipo.Base.CADENA) {
                        if (!l.esError() && !r.esError()
                                && l.base != Tipo.Base.STRUCT && r.base != Tipo.Base.STRUCT) {
                            errores.semantico(linea(e), "El operador '+' solo concatena String con primitivos.");
                            return Tipo.ERROR;
                        }
                    }
                    return Tipo.CADENA;
                }
                return aritmetica(l, op, r, linea(e), false);
            }
        }
        if (e.IGUAL() != null || e.NO_IGUAL() != null) {
            Tipo l = tipoExpresion(e.expresion(0));
            Tipo r = tipoExpresion(e.expresion(1));
            String op = e.IGUAL() != null ? "==" : "!=";
            return igualdad(l, op, r, linea(e));
        }
        if (e.MENOR_IGUAL() != null || e.MAYOR_IGUAL() != null) {
            Tipo l = tipoExpresion(e.expresion(0));
            Tipo r = tipoExpresion(e.expresion(1));
            String op = e.MENOR_IGUAL() != null ? "<=" : ">=";
            return relacional(l, op, r, linea(e));
        }
        if (e.MENOR() != null || e.MAYOR() != null) {
            Tipo l = tipoExpresion(e.expresion(0));
            Tipo r = tipoExpresion(e.expresion(1));
            String op = e.MENOR() != null ? "<" : ">";
            return relacional(l, op, r, linea(e));
        }
        if (e.AND() != null || e.OR() != null) {
            Tipo l = tipoExpresion(e.expresion(0));
            Tipo r = tipoExpresion(e.expresion(1));
            String op = e.AND() != null ? "&&" : "||";
            if (!l.equals(Tipo.BOOL) && !l.esError()
                    || !r.equals(Tipo.BOOL) && !r.esError()) {
                errores.semantico(linea(e), "El operador '" + op + "' solo opera sobre boolean.");
            }
            return Tipo.BOOL;
        }
        if (e.PUNTO() != null) {
            return tipoAcceso(e);
        }
        if (e.LCORCH() != null) {
            Tipo base = tipoExpresion(e.expresion(0));
            Tipo idx = tipoExpresion(e.expresion(1));
            if (!idx.esError() && idx.base != Tipo.Base.ENTERO) {
                errores.semantico(linea(e), "El índice del arreglo debe ser int.");
            }
            if (base.esError()) return Tipo.ERROR;
            if (base.base != Tipo.Base.SERIES) {
                errores.semantico(linea(e), "No es un arreglo (es " + base + ").");
                return Tipo.ERROR;
            }
            return base.elementos;
        }
        if (e.ID() != null && e.params() != null || txtContieneLlamada(e)) {
            return tipoLlamadaMetodo(e);
        }
        return Tipo.ERROR;
    }

    private boolean txtContieneLlamada(ZetarianoParserParser.ExpresionContext e) {
        String t = e.getText();
        return t.contains("(") && t.contains(")");
    }

    private Tipo aritmetica(Tipo l, String op, Tipo r, int ln, boolean modulo) {
        if (l.esError() || r.esError()) return Tipo.ERROR;
        if (modulo) {
            if (!l.esNumero() || !r.esNumero()) {
                errores.semantico(ln, "El operador '%' solo opera entre int y double.");
                return Tipo.ERROR;
            }
            if (l.base == Tipo.Base.FLOTANTE || r.base == Tipo.Base.FLOTANTE) return Tipo.FLOTANTE;
            return Tipo.ENTERO;
        }
        if (!l.esNumero() || !r.esNumero()) {
            errores.semantico(ln, "El operador '" + op + "' solo opera entre int y double.");
            return Tipo.ERROR;
        }
        if (l.base == Tipo.Base.FLOTANTE || r.base == Tipo.Base.FLOTANTE) return Tipo.FLOTANTE;
        return Tipo.ENTERO;
    }

    private Tipo igualdad(Tipo l, String op, Tipo r, int ln) {
        if (l.esError() || r.esError()) return Tipo.BOOL;
        if (l.base == Tipo.Base.NULL || r.base == Tipo.Base.NULL) {
            Tipo otro = l.base == Tipo.Base.NULL ? r : l;
            if (otro.base == Tipo.Base.STRUCT || otro.base == Tipo.Base.NULL
                    || otro.base == Tipo.Base.SERIES || otro.esPrimitivo()) {
                if (otro.esPrimitivo() && otro.base != Tipo.Base.CADENA) {
                    errores.semantico(ln, "No se puede comparar " + otro + " con null.");
                }
                return Tipo.BOOL;
            }
            errores.semantico(ln, "Comparación con null no válida.");
            return Tipo.BOOL;
        }
        if (l.esNumero() && r.esNumero()) return Tipo.BOOL;
        if (l.base == Tipo.Base.STRUCT && r.base == Tipo.Base.STRUCT) {
            if (!l.equals(r)) {
                errores.semantico(ln, "No se puede comparar " + l + " con " + r + ".");
            }
            return Tipo.BOOL;
        }
        if (l.base == r.base && (l.base == Tipo.Base.CADENA
                || l.base == Tipo.Base.BOOL || l.base == Tipo.Base.CARACTER)) {
            return Tipo.BOOL;
        }
        errores.semantico(ln, "El operador '" + op + "' no es compatible entre " + l + " y " + r + ".");
        return Tipo.BOOL;
    }

    private Tipo relacional(Tipo l, String op, Tipo r, int ln) {
        if (l.esError() || r.esError()) return Tipo.BOOL;
        if (l.esNumero() && r.esNumero()) return Tipo.BOOL;
        if (l.base == Tipo.Base.CARACTER && r.base == Tipo.Base.CARACTER) return Tipo.BOOL;
        errores.semantico(ln, "El operador '" + op + "' solo compara int/double (o char).");
        return Tipo.BOOL;
    }

    private Tipo tipoAcceso(ZetarianoParserParser.ExpresionContext e) {
        Tipo base = tipoExpresion(e.expresion(0));
        String nombre = e.ID() != null ? e.ID().getText() : "?";
        if (base.esError()) {
            if (e.params() != null) for (ZetarianoParserParser.ExpresionContext a : e.params().expresion()) tipoExpresion(a);
            return Tipo.ERROR;
        }
        if (base.base != Tipo.Base.STRUCT) {
            errores.semantico(linea(e), "'" + base + "' no es un objeto: no tiene miembros.");
            return Tipo.ERROR;
        }
        List<Tipo> args = new ArrayList<>();
        if (e.params() != null) {
            for (ZetarianoParserParser.ExpresionContext a : e.params().expresion()) args.add(tipoExpresion(a));
        }
        boolean esLlamada = e.params() != null || e.getText().contains("(");
        if (!base.nombreStruct.equals(claseActual)) {
            return Tipo.ERROR;
        }
        if (esLlamada) {
            List<Metodo> cands = metodos.getOrDefault(nombre, List.of());
            for (Metodo m : cands) {
                if (m.tiposParams.size() == args.size() && paramsCompatibles(m, args)) return m.retorno;
            }
            if (cands.isEmpty()) {
                errores.semantico(linea(e), "Método no definido: '" + base + "." + nombre + "'.");
            } else {
                errores.semantico(linea(e), "Ninguna sobrecarga de '" + nombre + "' acepta esos argumentos.");
            }
            return Tipo.ERROR;
        }
        StructSimbolo s = tabla.obtenerStruct(claseActual);
        if (s != null && s.tieneCampo(nombre)) return s.tipoCampo(nombre);
        errores.semantico(linea(e), "Campo no definido: '" + base + "." + nombre + "'.");
        return Tipo.ERROR;
    }

    private Tipo tipoLlamadaMetodo(ZetarianoParserParser.ExpresionContext e) {
        String nombre = e.ID() != null ? e.ID().getText() : "?";
        List<Tipo> args = new ArrayList<>();
        if (e.params() != null) {
            for (ZetarianoParserParser.ExpresionContext a : e.params().expresion()) args.add(tipoExpresion(a));
        }
        List<Metodo> cands = metodos.getOrDefault(nombre, List.of());
        for (Metodo m : cands) {
            if (m.tiposParams.size() == args.size() && paramsCompatibles(m, args)) return m.retorno;
        }
        if (cands.isEmpty()) {
            errores.semantico(linea(e), "Método no definido: '" + nombre + "'.");
        } else {
            errores.semantico(linea(e), "Ninguna sobrecarga de '" + nombre + "' acepta esos argumentos.");
        }
        return Tipo.ERROR;
    }

    private void exigirBool(Tipo t, int ln, String ctx) {
        if (!t.equals(Tipo.BOOL) && !t.esError()) {
            errores.semantico(ln, "La condición de " + ctx + " debe ser boolean.");
        }
    }
}
