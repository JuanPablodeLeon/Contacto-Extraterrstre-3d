package org.example.Semantico;

import antlr4.com.antlr4.com.ZetarianoParserBaseVisitor;
import antlr4.com.antlr4.com.ZetarianoParserParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.Ejecutor.ClaseZ;
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
        public String visibilidad = "default";
        public boolean override;
        public Metodo(boolean constructor, String nombre, Tipo retorno, ZetarianoParserParser.InstruccionesContext ctx) {
            this.constructor = constructor;
            this.nombre = nombre;
            this.retorno = retorno;
            this.ctx = ctx;
        }
    }

    private final TablaSimbolos tabla = new TablaSimbolos();
    private final ErrorReporter errores;
    private final Map<String, ClaseZ> clases;
    private final boolean proyecto;
    private String claseActual = "?";
    private ClaseZ modeloActual;
    private final Map<String, List<Metodo>> metodos = new LinkedHashMap<>();
    private final List<Metodo> constructores = new ArrayList<>();
    private Metodo metodoActual;
    private int profundidadCiclo = 0;
    private int profundidadSwitch = 0;

    public SemanticoZ(ErrorReporter errores) {
        this(errores, new LinkedHashMap<>(), false);
    }

    public SemanticoZ(ErrorReporter errores, Map<String, ClaseZ> clases) {
        this(errores, clases, clases != null && clases.size() > 1);
    }

    public SemanticoZ(ErrorReporter errores, Map<String, ClaseZ> clases, boolean proyecto) {
        this.errores = errores;
        this.clases = clases == null ? new LinkedHashMap<>() : clases;
        this.proyecto = proyecto;
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

    /** Normaliza un tipo textual a la forma canónica usada por ClaseZ. */
    private String canonTipo(String t) {
        return ClaseZ.canonZ(t);
    }

    /** Convierte un tipo canónico (numerus, textum, series<...>, Clase) a Tipo. */
    private Tipo tipoCanon(String canon) {
        if (canon == null) return Tipo.ERROR;
        String t = canon.trim();
        if (t.startsWith("series<") && t.endsWith(">")) {
            return Tipo.series(tipoCanon(t.substring(7, t.length() - 1)));
        }
        switch (t) {
            case "numerus": return Tipo.ENTERO;
            case "decimalis": return Tipo.FLOTANTE;
            case "textum": return Tipo.CADENA;
            case "littera": return Tipo.CARACTER;
            case "bool": return Tipo.BOOL;
            case "void": return Tipo.VOID;
            case "null": return Tipo.NULL;
            default: return Tipo.struct(t);
        }
    }

    private boolean asignable(Tipo destino, Tipo origen) {
        return Tipo.asignableZ(destino, origen, clases);
    }

    private boolean paramsCompatiblesZ(List<ClaseZ.ParamZ> params, List<Tipo> args) {
        if (params.size() != args.size()) return false;
        for (int i = 0; i < args.size(); i++) {
            Tipo esp = tipoCanon(params.get(i).tipo);
            Tipo real = args.get(i);
            if (!esp.esError() && !real.esError() && !asignable(esp, real)) return false;
        }
        return true;
    }

    /** Visibilidad de Java sin paquetes: private/default solo en la propia clase;
     *  protected también en subclases; public en todas. */
    private boolean puedeAcceder(String visibilidad, ClaseZ propietario) {
        if (propietario == null || modeloActual == null) return true;
        if (propietario.nombre.equals(claseActual)) return true;
        if ("public".equals(visibilidad)) return true;
        if ("protected".equals(visibilidad)) {
            return modeloActual.esSubclaseDe(propietario.nombre, clases);
        }
        return false;
    }

    /** ¿La cadena de ancestros de {@code clase} incluye una clase no disponible?
     *  Al compilar un .z aislado (sin imports) eso es normal y no debe reportarse. */
    private boolean padreDesconocido(ClaseZ clase) {
        if (clase == null) return false;
        Set<String> vistos = new HashSet<>();
        String p = clase.padre;
        while (p != null && vistos.add(p)) {
            ClaseZ c = clases.get(p);
            if (c == null) return true;
            p = c.padre;
        }
        return false;
    }

    private boolean tolerarMiembroAusente(ClaseZ base) {
        return !proyecto && padreDesconocido(base);
    }


    @Override
    public Tipo visitInicio(ZetarianoParserParser.InicioContext ctx) {
        if (ctx.bloc_main() == null) return Tipo.VOID;
        claseActual = ctx.bloc_main().ID(0).getText();
        modeloActual = clases.get(claseActual);
        if (modeloActual == null) {
            modeloActual = ClaseZ.desde(claseActual + ".z", ctx);
            if (modeloActual != null) clases.put(claseActual, modeloActual);
        }
        if (modeloActual != null && modeloActual.padre != null
                && !clases.containsKey(modeloActual.padre) && proyecto) {
            errores.semantico(linea(ctx.bloc_main()),
                    "La clase padre '" + modeloActual.padre + "' de '" + claseActual
                            + "' no está definida.");
        }
        validarCicloHerencia();

        for (ZetarianoParserParser.InstruccionesContext ins : ctx.bloc_main().instrucciones()) {
            if (!ins.declaracion().isEmpty()) {
                for (ZetarianoParserParser.DeclaracionContext d : ins.declaracion()) {
                    registrarCampo(d);
                }
            } else {
                registrarMiembro(ins);
            }
        }
        validarSobrescrituras();
        validarConstructoresClase();
        for (ZetarianoParserParser.InstruccionesContext ins : ctx.bloc_main().instrucciones()) {
            if (!ins.declaracion().isEmpty()) continue;
            visitarMiembro(ins);
        }
        return Tipo.VOID;
    }

    private void validarCicloHerencia() {
        if (modeloActual == null || modeloActual.padre == null) return;
        Set<String> vistos = new LinkedHashSet<>();
        ClaseZ c = modeloActual;
        int guarda = 0;
        while (c != null && guarda++ < 256) {
            if (!vistos.add(c.nombre)) {
                errores.semantico(linea(modeloActual.constructores.isEmpty()
                                ? null : modeloActual.constructores.get(0).ctx),
                        "Ciclo de herencia detectado en la clase '" + c.nombre + "'.");
                return;
            }
            c = c.clasePadre(clases);
        }
    }

    private void validarSobrescrituras() {
        if (modeloActual == null) return;
        ClaseZ padre = modeloActual.clasePadre(clases);
        if (padre == null && modeloActual.padre != null && !proyecto) return;
        for (Map.Entry<String, List<ClaseZ.MetodoZ>> e : modeloActual.metodos.entrySet()) {
            for (ClaseZ.MetodoZ m : e.getValue()) {
                ClaseZ.MetodoZ base = padre == null ? null
                        : buscarMetodoExacto(padre, m.nombre, m.params);
                if (base != null && !"public".equals(base.visibilidad)
                        && !"protected".equals(base.visibilidad)) {
                    // private/default no se hereda: no es una sobrescritura
                    base = null;
                }
                if (m.override && base == null && (padre != null || proyecto)) {
                    errores.semantico(linea(m.ctx),
                            "'@" + "Override' sobre '" + m.nombre
                                    + "' pero no existe un método con esa firma en la clase padre.");
                }
                if (!m.override && base != null) {
                    errores.semantico(linea(m.ctx),
                            "El método '" + m.nombre
                                    + "' sobrescribe al de la clase padre y debe marcarse con @Override.");
                }
                if (base != null) {
                    if (ClaseZ.rangoVisibilidad(m.visibilidad)
                            < ClaseZ.rangoVisibilidad(base.visibilidad)) {
                        errores.semantico(linea(m.ctx),
                                "La sobrescritura de '" + m.nombre
                                        + "' no puede reducir la visibilidad de "
                                        + base.visibilidad + " a " + m.visibilidad + ".");
                    }
                    Tipo esperado = tipoCanon(base.retorno);
                    Tipo real = tipoCanon(m.retorno);
                    if (!real.esError() && !esperado.esError()
                            && !asignable(esperado, real)) {
                        errores.semantico(linea(m.ctx),
                                "El retorno de la sobrescritura '" + m.nombre + "' (" + real
                                        + ") no es covariante con " + esperado + ".");
                    }
                }
            }
        }
        for (ClaseZ.MetodoZ c : modeloActual.constructores) {
            if (c.override) {
                errores.semantico(linea(c.ctx),
                        "Un constructor no puede marcarse con @Override.");
            }
        }
    }

    private ClaseZ.MetodoZ buscarMetodoExacto(ClaseZ clase, String nombre, List<ClaseZ.ParamZ> params) {
        ClaseZ c = clase;
        int guarda = 0;
        while (c != null && guarda++ < 256) {
            List<ClaseZ.MetodoZ> lista = c.metodos.get(nombre);
            if (lista != null) {
                for (ClaseZ.MetodoZ m : lista) {
                    if (m.params.size() != params.size()) continue;
                    boolean igual = true;
                    for (int i = 0; i < params.size(); i++) {
                        if (!canonTipo(m.params.get(i).tipo)
                                .equals(canonTipo(params.get(i).tipo))) {
                            igual = false;
                            break;
                        }
                    }
                    if (igual) return m;
                }
            }
            c = c.clasePadre(clases);
        }
        return null;
    }

    private void validarConstructoresClase() {
        if (modeloActual == null) return;
        ClaseZ padre = modeloActual.clasePadre(clases);
        if (padre == null && modeloActual.padre != null && !proyecto) return;
        if (constructores.isEmpty()) {
            if (padre != null && !padre.tieneConstructorSinArgs()) {
                errores.semantico(1, "La clase '" + claseActual
                        + "' necesita un constructor que invoque explícitamente a 'super(...)' de '"
                        + padre.nombre + "', que no tiene constructor sin argumentos.");
            }
            return;
        }
        for (Metodo m : constructores) {
            List<ZetarianoParserParser.InstruccionContext> cuerpo = m.ctx.instruccion();
            int posSuper = -1;
            for (int i = 0; i < cuerpo.size(); i++) {
                if (cuerpo.get(i).SUPER() != null) {
                    if (posSuper < 0) posSuper = i;
                    else {
                        errores.semantico(linea(cuerpo.get(i)),
                                "Solo puede existir una llamada a 'super(...)'.");
                    }
                }
            }
            if (posSuper > 0) {
                errores.semantico(linea(cuerpo.get(posSuper)),
                        "'super(...)' debe ser la primera instrucción del constructor.");
            }
            if (padre == null) {
                if (posSuper >= 0 && modeloActual.padre == null) {
                    errores.semantico(linea(cuerpo.get(posSuper)),
                            "La clase '" + claseActual + "' no tiene clase padre.");
                }
                continue;
            }
            if (posSuper >= 0) {
                ZetarianoParserParser.InstruccionContext s = cuerpo.get(posSuper);
                int n = s.params() == null ? 0 : s.params().expresion().size();
                if (padre.constructor(n) == null) {
                    errores.semantico(linea(s), "El padre '" + padre.nombre
                            + "' no declara un constructor con " + n + " argumento(s).");
                }
            } else if (!padre.tieneConstructorSinArgs()) {
                errores.semantico(linea(m.ctx),
                        "El constructor de '" + claseActual
                                + "' debe invocar explícitamente a un constructor de '"
                                + padre.nombre + "' mediante 'super(...)'.");
            }
        }
    }

    private void validarConstructorPadre(ClaseZ padre, List<Tipo> args, int ln) {
        if (padre.constructores.isEmpty()) {
            if (args.isEmpty()) return;
            errores.semantico(ln, "El padre '" + padre.nombre
                    + "' no declara constructores con " + args.size() + " argumento(s).");
            return;
        }
        for (ClaseZ.MetodoZ c : padre.constructores) {
            if (c.params.size() == args.size() && paramsCompatiblesZ(c.params, args)) return;
        }
        errores.semantico(ln, "Constructor de '" + padre.nombre
                + "' no coincide con " + args.size() + " argumento(s).");
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
        String vis = ins.modificador() == null ? "default" : ins.modificador().getText();
        if (!tieneVoid && !tieneTipos && ids.size() == 1
                && ids.get(0).getText().equals(claseActual)) {
            Metodo m = new Metodo(true, ids.get(0).getText(), Tipo.struct(claseActual), ins);
            m.visibilidad = vis;
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
            m.visibilidad = vis;
            m.override = ins.OVERRIDE() != null;
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
            if (e.tiposParams.size() != m.tiposParams.size()) continue;
            boolean igual = true;
            for (int i = 0; i < m.tiposParams.size(); i++) {
                if (!e.tiposParams.get(i).equals(m.tiposParams.get(i))) {
                    igual = false;
                    break;
                }
            }
            if (igual) return true;
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
        if (ctx.SUPER() != null) {
            if (metodoActual == null || !metodoActual.constructor) {
                errores.semantico(linea(ctx),
                        "'super(...)' solo puede usarse dentro de un constructor.");
                return Tipo.VOID;
            }
            ClaseZ padre = modeloActual == null ? null : modeloActual.clasePadre(clases);
            List<Tipo> args = tiposParams(ctx.params());
            if (padre == null) {
                if (modeloActual != null && modeloActual.padre == null) {
                    errores.semantico(linea(ctx),
                            "La clase '" + claseActual + "' no tiene clase padre.");
                }
            } else {
                validarConstructorPadre(padre, args, linea(ctx));
            }
            return Tipo.VOID;
        }
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
            Tipo sel = tipoExpresion(ctx.expresion(0));
            if (!sel.esPrimitivo() && !sel.esError()) {
                errores.semantico(linea(ctx), "El 'switch' solo admite int, char o String.");
            }
            profundidadSwitch++;
            ZetarianoParserParser.Switch_cuerpoContext cuerpo = ctx.switch_cuerpo();
            if (cuerpo != null) {
                for (ZetarianoParserParser.Bloque_switchContext b : cuerpo.bloque_switch()) {
                    Tipo tc = tipoExpresion(b.expresion());
                    if (!sel.esError() && !tc.esError()
                            && !asignable(sel, tc) && !asignable(tc, sel)) {
                        errores.semantico(linea(b), "El 'case' " + tc + " no es compatible con " + sel + ".");
                    }
                    profundidadCiclo++;
                    for (ZetarianoParserParser.InstruccionContext h : b.instruccion()) visitInstruccion(h);
                    profundidadCiclo--;
                }
                ZetarianoParserParser.Bloque_defaultContext def = cuerpo.bloque_default();
                if (def != null) {
                    profundidadCiclo++;
                    for (ZetarianoParserParser.InstruccionContext h : def.instruccion()) visitInstruccion(h);
                    profundidadCiclo--;
                }
            }
            profundidadSwitch--;
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
                    if (!tIter.esError() && !tInit.esError() && !asignable(tIter, tInit)) {
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
                        && !asignable(metodoActual.retorno, real)) {
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
                if (!elem.esError() && !real.esError() && !asignable(elem, real)) {
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
                if (!vs.type.esError() && !asignable(vs.type, tObj)) {
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
            if (!declarado.esError() && !real.esError() && !asignable(declarado, real)) {
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
        ClaseZ cz = clases.get(clase);
        if (cz == null && clase.equals(claseActual)) cz = modeloActual;
        if (cz == null) {
            if (proyecto) {
                errores.semantico(ln, "Clase no definida: '" + clase + "'.");
            }
            return;
        }
        if (cz.constructores.isEmpty()) {
            if (args.isEmpty()) return;
            errores.semantico(ln, "La clase '" + clase
                    + "' no declara constructores con " + args.size() + " argumento(s).");
            return;
        }
        for (ClaseZ.MetodoZ c : cz.constructores) {
            if (c.params.size() == args.size() && paramsCompatiblesZ(c.params, args)) return;
        }
        errores.semantico(ln, "Constructor no coincide: 'new " + clase
                + "' con " + args.size() + " argumento(s).");
    }

    private boolean paramsCompatibles(Metodo m, List<Tipo> args) {
        for (int i = 0; i < args.size(); i++) {
            Tipo esp = m.tiposParams.get(i);
            Tipo real = args.get(i);
            if (!esp.esError() && !real.esError() && !asignable(esp, real)) return false;
        }
        return true;
    }

    private Tipo visitarAsignacion(ZetarianoParserParser.AsignacionContext a) {
        int ln = linea(a);
        List<ZetarianoParserParser.ExpresionContext> exprs = a.expresion();
        if (a.SUMA_IGL() != null || a.RESTA_IGL() != null || a.MULT_IGL() != null) {
            String var = a.ID().getText();
            Tipo destino = tipoDestinoAsignacion(a, ln);
            Tipo real = tipoExpresion(exprs.get(0));
            if (destino.esError()) return Tipo.ERROR;
            if (!destino.esNumero() && !destino.esError()) {
                errores.semantico(ln, "La asignación compuesta solo aplica a int/double.");
                return destino;
            }
            if (!real.esNumero() && !real.esError()) {
                errores.semantico(ln, "La asignación compuesta solo acepta expresiones numéricas.");
                return destino;
            }
            if (!destino.esError() && !real.esError() && !asignable(destino, real)) {
                errores.semantico(ln, "No se puede aplicar '" + a.getChild(1).getText() + "' con "
                        + real + " a '" + var + "' de " + destino + ".");
            }
            return destino;
        }
        if (a.INTERRG() != null) {
            String var = a.ID().getText();
            Tipo destino = tipoDestinoAsignacion(a, ln);
            Tipo cond = tipoExpresion(exprs.get(0));
            Tipo r1 = tipoExpresion(exprs.get(1));
            Tipo r2 = tipoExpresion(exprs.get(2));
            exigirBool(cond, ln, "operador ternario");
            Tipo res = Tipo.ERROR;
            if (!r1.esError() && !r2.esError()) {
                if (asignable(r1, r2)) res = r1;
                else if (asignable(r2, r1)) res = r2;
                else {
                    errores.semantico(ln, "Las ramas del ternario (" + r1 + " : " + r2 + ") no son compatibles.");
                    res = Tipo.ERROR;
                }
            } else if (!r1.esError()) res = r1;
            else if (!r2.esError()) res = r2;
            if (destino.esError()) return Tipo.ERROR;
            if (!destino.esError() && !res.esError() && !asignable(destino, res)) {
                errores.semantico(ln, "El ternario " + res + " no es compatible con '" + var + "' de " + destino + ".");
            }
            return destino;
        }
        if (a.INCREMENTO() != null || a.DECREMENTO() != null) {
            Tipo destino = tipoDestinoAsignacion(a, ln);
            if (!destino.esNumero() && !destino.esError()) {
                errores.semantico(ln, "El operador '++/--' solo aplica a int/double.");
            }
            return destino;
        }
        if (exprs.isEmpty()) {
            errores.semantico(ln, "Asignación sin valor.");
            return Tipo.ERROR;
        }
        Tipo real = tipoExpresion(exprs.get(exprs.size() - 1));
        if (a.lvalue() != null) {
            Tipo tLv = tipoLvalue(a.lvalue());
            if (!tLv.esError() && !real.esError() && !asignable(tLv, real)) {
                errores.semantico(ln, mensajeAsignacion(a.lvalue().getText(), tLv, real));
            }
            return tLv;
        }
        Tipo destino = tipoDestinoAsignacion(a, ln);
        if (!destino.esError() && !real.esError() && !asignable(destino, real)) {
            errores.semantico(ln, mensajeAsignacion(a.ID().getText(), destino, real));
        }
        return destino;
    }

    /** Tipo del destino de una asignación simple o compuesta: this.<campo> o <id>. */
    private Tipo tipoDestinoAsignacion(ZetarianoParserParser.AsignacionContext a, int ln) {
        if (a.ID() == null) return Tipo.ERROR;
        String nombre = a.ID().getText();
        if (a.THIS() != null) {
            ClaseZ.CampoInfo ci = modeloActual == null ? null
                    : modeloActual.buscarCampo(nombre, clases);
            if (ci == null) {
                if (tolerarMiembroAusente(modeloActual)) return Tipo.ERROR;
                errores.semantico(ln, "Campo no definido: '" + claseActual + "." + nombre + "'.");
                return Tipo.ERROR;
            }
            if (!puedeAcceder(ci.visibilidad, ci.clase)) {
                errores.semantico(ln, "El campo '" + nombre + "' de '" + ci.clase.nombre
                        + "' no es accesible desde '" + claseActual + "'.");
                return Tipo.ERROR;
            }
            return tipoCanon(ci.tipo);
        }
        return tipoDeNombre(nombre, ln);
    }

    /** Resuelve un nombre que puede ser variable local, parámetro o campo (propio o heredado). */
    private Tipo tipoDeNombre(String nombre, int ln) {
        VarSymbol vs = tabla.obtenerVar(nombre);
        if (vs != null) return vs.type;
        ClaseZ.CampoInfo ci = modeloActual == null ? null
                : modeloActual.buscarCampo(nombre, clases);
        if (ci != null) {
            if (!puedeAcceder(ci.visibilidad, ci.clase)) {
                errores.semantico(ln, "El campo '" + nombre + "' de '" + ci.clase.nombre
                        + "' no es accesible desde '" + claseActual + "'.");
                return Tipo.ERROR;
            }
            return tipoCanon(ci.tipo);
        }
        if (tolerarMiembroAusente(modeloActual)) return Tipo.ERROR;
        errores.semantico(ln, "La variable no ha sido declarada: '" + nombre + "'.");
        return Tipo.ERROR;
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
        Tipo actual = tipoDeNombre(ids.get(0).getText(), linea(lv));
        if (actual.esError()) return Tipo.ERROR;
        int nExpr = lv.expresion().size();
        int e = 0;
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
            ClaseZ cz = clases.get(actual.nombreStruct);
            ClaseZ.CampoInfo ci = cz == null ? null : cz.buscarCampo(campo, clases);
            if (ci != null) {
                if (!puedeAcceder(ci.visibilidad, ci.clase)) {
                    errores.semantico(linea(lv), "El campo '" + campo + "' de '" + ci.clase.nombre
                            + "' no es accesible desde '" + claseActual + "'.");
                    return Tipo.ERROR;
                }
                actual = tipoCanon(ci.tipo);
            } else {
                StructSimbolo s = tabla.obtenerStruct(actual.nombreStruct);
                if (s != null && s.tieneCampo(campo)) {
                    actual = s.tipoCampo(campo);
                } else {
                    if (cz == null && !proyecto) return Tipo.ERROR;
                    if (tolerarMiembroAusente(cz)) return Tipo.ERROR;
                    errores.semantico(linea(lv), "Campo no definido: '" + actual + "." + campo + "'.");
                    return Tipo.ERROR;
                }
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

    private static boolean hijoTexto(ParseTree n, String txt) {
        for (int i = 0; i < n.getChildCount(); i++) {
            ParseTree ch = n.getChild(i);
            if (ch instanceof TerminalNode tn && tn.getText().equals(txt)) return true;
        }
        return false;
    }

    public Tipo tipoExpresion(ZetarianoParserParser.ExpresionContext e) {
        if (e.getChild(0) instanceof TerminalNode tn0) {
            int ty0 = tn0.getSymbol().getType();
            if (ty0 == ZetarianoParserParser.THIS) {
                if (e.getChildCount() == 1) return Tipo.struct(claseActual);
                if (e.getChild(2) instanceof ZetarianoParserParser.ExpresionContext inner) {
                    return tipoExpresionThis(inner, e);
                }
            }
            if (ty0 == ZetarianoParserParser.SUPER) {
                return tipoExpresionSuper(e);
            }
        }
        if (e.getChild(0) instanceof TerminalNode tnN && tnN.getSymbol().getType() == ZetarianoParserParser.NEW
                && e.getChild(1) instanceof ZetarianoParserParser.TiposContext tip) {
            Tipo t = Tipo.desdeZ(tip.getText());
            for (ZetarianoParserParser.ExpresionContext sz : e.expresion()) {
                Tipo ti = tipoExpresion(sz);
                if (!ti.esError() && ti.base != Tipo.Base.ENTERO) {
                    errores.semantico(linea(sz), "El tamaño del arreglo debe ser int.");
                }
            }
            for (int i = 0; i < e.LCORCH().size(); i++) t = Tipo.series(t);
            return t;
        }
        if (e.getChild(0) instanceof TerminalNode tnN && tnN.getSymbol().getType() == ZetarianoParserParser.NEW
                && e.getChild(1) instanceof TerminalNode tnId
                && tnId.getSymbol().getType() == ZetarianoParserParser.ID
                && !e.LCORCH().isEmpty()) {
            String clase = tnId.getText();
            if (proyecto && !clases.containsKey(clase)) {
                errores.semantico(linea(e), "Clase no definida: '" + clase + "'.");
            }
            for (ZetarianoParserParser.ExpresionContext sz : e.expresion()) {
                Tipo ti = tipoExpresion(sz);
                if (!ti.esError() && ti.base != Tipo.Base.ENTERO) {
                    errores.semantico(linea(sz), "El tamaño del arreglo debe ser int.");
                }
            }
            Tipo t = Tipo.struct(clase);
            for (int i = 0; i < e.LCORCH().size(); i++) t = Tipo.series(t);
            return t;
        }
        if (e.getChild(0) instanceof TerminalNode tnN && tnN.getSymbol().getType() == ZetarianoParserParser.NEW
                && e.getChild(1) instanceof TerminalNode tnId
                && tnId.getSymbol().getType() == ZetarianoParserParser.ID) {
            String clase = tnId.getText();
            List<Tipo> args = e.params() == null
                    ? List.of() : tiposParams(e.params());
            validarConstructor(clase, args, linea(e));
            return Tipo.struct(clase);
        }
        if (hijoTexto(e, "?")) {
            List<ZetarianoParserParser.ExpresionContext> es = e.expresion();
            Tipo cond = tipoExpresion(es.get(0));
            exigirBool(cond, linea(e), "operador ternario");
            Tipo a = tipoExpresion(es.get(1));
            Tipo b = tipoExpresion(es.get(2));
            if (a.esError()) return b;
            if (b.esError()) return a;
            if (asignable(a, b)) return a;
            if (asignable(b, a)) return b;
            errores.semantico(linea(e), "Las ramas del ternario (" + a + " : " + b + ") no son compatibles.");
            return Tipo.ERROR;
        }
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
                    return tipoDeNombre(t, tn.getSymbol().getLine());
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
        if (n >= 3 && e.getChild(1) instanceof TerminalNode opn
                && e.expresion().size() >= 2) {
            String op = opn.getText();
            if (op.equals("*") || op.equals("/") || op.equals("%")) {
                Tipo l = tipoExpresion(e.expresion(0));
                Tipo r = tipoExpresion(e.expresion(1));
                return aritmetica(l, op, r, linea(e), op.equals("%"));
            }
            if (op.equals("+") || op.equals("-")) {
                Tipo l = tipoExpresion(e.expresion(0));
                Tipo r = tipoExpresion(e.expresion(1));
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
            if (op.equals("==") || op.equals("!=")) {
                return igualdad(tipoExpresion(e.expresion(0)), op,
                        tipoExpresion(e.expresion(1)), linea(e));
            }
            if (op.equals("<=") || op.equals(">=") || op.equals("<") || op.equals(">")) {
                return relacional(tipoExpresion(e.expresion(0)), op,
                        tipoExpresion(e.expresion(1)), linea(e));
            }
            if (op.equals("&&") || op.equals("||")) {
                Tipo l = tipoExpresion(e.expresion(0));
                Tipo r = tipoExpresion(e.expresion(1));
                if (!l.equals(Tipo.BOOL) && !l.esError()
                        || !r.equals(Tipo.BOOL) && !r.esError()) {
                    errores.semantico(linea(e), "El operador '" + op + "' solo opera sobre boolean.");
                }
                return Tipo.BOOL;
            }
        }
        if (hijoTexto(e, ".")) {
            return tipoAcceso(e);
        }
        if (hijoTexto(e, "[")) {
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
        List<Tipo> args = new ArrayList<>();
        if (e.params() != null) {
            for (ZetarianoParserParser.ExpresionContext a : e.params().expresion()) args.add(tipoExpresion(a));
        }
        boolean esLlamada = e.params() != null || e.getText().contains("(");
        if (base.esError()) return Tipo.ERROR;
        if (base.base != Tipo.Base.STRUCT) {
            errores.semantico(linea(e), "'" + base + "' no es un objeto: no tiene miembros.");
            return Tipo.ERROR;
        }
        ClaseZ cz = clases.get(base.nombreStruct);
        if (cz == null) {
            StructSimbolo s = tabla.obtenerStruct(base.nombreStruct);
            if (!esLlamada && s != null && s.tieneCampo(nombre)) return s.tipoCampo(nombre);
            // Al compilar un .z aislado se toleran las clases hermanas ausentes.
            if (!proyecto) return Tipo.ERROR;
            errores.semantico(linea(e), "Tipo no definido: '" + base.nombreStruct + "'.");
            return Tipo.ERROR;
        }
        return tipoMiembro(cz, nombre, args, esLlamada, linea(e));
    }

    /** Resuelve un miembro (campo o método) buscando también en las clases padre. */
    private Tipo tipoMiembro(ClaseZ base, String nombre, List<Tipo> args,
                             boolean llamada, int ln) {
        if (llamada) {
            ClaseZ.MetodoInfo mi = buscarMetodoEn(base, nombre, args);
            if (mi == null) {
                if (tolerarMiembroAusente(base)) return Tipo.ERROR;
                List<ClaseZ.MetodoInfo> cands = base.metodosVisibles(nombre, clases);
                if (cands.isEmpty()) {
                    errores.semantico(ln, "Método no definido: '" + base.nombre + "." + nombre + "'.");
                } else {
                    errores.semantico(ln, "Ninguna sobrecarga de '" + nombre
                            + "' acepta esos argumentos.");
                }
                return Tipo.ERROR;
            }
            if (!puedeAcceder(mi.metodo.visibilidad, mi.clase)) {
                errores.semantico(ln, "El método '" + nombre + "' de '" + mi.clase.nombre
                        + "' no es accesible desde '" + claseActual + "'.");
                return Tipo.ERROR;
            }
            return tipoCanon(mi.metodo.retorno);
        }
        ClaseZ.CampoInfo ci = base.buscarCampo(nombre, clases);
        if (ci == null) {
            if (tolerarMiembroAusente(base)) return Tipo.ERROR;
            errores.semantico(ln, "Campo no definido: '" + base.nombre + "." + nombre + "'.");
            return Tipo.ERROR;
        }
        if (!puedeAcceder(ci.visibilidad, ci.clase)) {
            errores.semantico(ln, "El campo '" + nombre + "' de '" + ci.clase.nombre
                    + "' no es accesible desde '" + claseActual + "'.");
            return Tipo.ERROR;
        }
        return tipoCanon(ci.tipo);
    }

    /** Busca una sobrecarga de {@code nombre} en {@code desde} y sus ancestros. */
    private ClaseZ.MetodoInfo buscarMetodoEn(ClaseZ desde, String nombre, List<Tipo> args) {
        if (desde == null) return null;
        for (ClaseZ.MetodoInfo mi : desde.metodosVisibles(nombre, clases)) {
            if (mi.metodo.params.size() == args.size()
                    && paramsCompatiblesZ(mi.metodo.params, args)) return mi;
        }
        return null;
    }

    /** {@code this.<expresion>}: se resuelve como una expresión de la clase actual. */
    private Tipo tipoExpresionThis(ZetarianoParserParser.ExpresionContext inner,
                                   ZetarianoParserParser.ExpresionContext ctx) {
        if (modeloActual == null) {
            errores.semantico(linea(ctx),
                    "'this' solo puede usarse dentro de un método o constructor.");
            return Tipo.ERROR;
        }
        return tipoExpresion(inner);
    }

    /** {@code super.metodo(...)} y {@code super.campo}: se busca desde la clase padre. */
    private Tipo tipoExpresionSuper(ZetarianoParserParser.ExpresionContext e) {
        ClaseZ padre = modeloActual == null ? null : modeloActual.clasePadre(clases);
        if (padre == null) {
            if (modeloActual == null || modeloActual.padre == null || proyecto) {
                errores.semantico(linea(e), "La clase '" + claseActual
                        + "' no tiene clase padre; 'super' no es válido.");
            }
            return Tipo.ERROR;
        }
        String nombre = e.ID() != null ? e.ID().getText() : "?";
        List<Tipo> args = new ArrayList<>();
        if (e.params() != null) {
            for (ZetarianoParserParser.ExpresionContext a : e.params().expresion()) {
                args.add(tipoExpresion(a));
            }
        }
        boolean llamada = e.getText().contains("(");
        return tipoMiembro(padre, nombre, args, llamada, linea(e));
    }

    private Tipo tipoLlamadaMetodo(ZetarianoParserParser.ExpresionContext e) {
        String nombre = e.ID() != null ? e.ID().getText() : "?";
        List<Tipo> args = new ArrayList<>();
        if (e.params() != null) {
            for (ZetarianoParserParser.ExpresionContext a : e.params().expresion()) args.add(tipoExpresion(a));
        }
        if (modeloActual == null) {
            errores.semantico(linea(e),
                    "Método no definido: '" + nombre + "' (no hay una clase activa).");
            return Tipo.ERROR;
        }
        return tipoMiembro(modeloActual, nombre, args, true, linea(e));
    }

    private void exigirBool(Tipo t, int ln, String ctx) {
        if (!t.equals(Tipo.BOOL) && !t.esError()) {
            errores.semantico(ln, "La condición de " + ctx + " debe ser boolean.");
        }
    }
}
