package org.example.Semantico;

import antlr4.com.antlr4.com.YLenguajeParser;
import antlr4.com.antlr4.com.YLenguajeParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.Reports.ErrorReporter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SemanticoY extends YLenguajeParserBaseVisitor<Tipo> {

    private final TablaSimbolos tabla = new TablaSimbolos();
    private final ErrorReporter errores;
    private FuncSimbolo funcionActual;
    private int profundidadCiclo = 0;
    private int profundidadSwitch = 0;

    public SemanticoY(ErrorReporter errores){
        this.errores = errores;
    }

    public TablaSimbolos getTabla(){
        return tabla;
    }

    public static java.util.Map<String, StructSimbolo> extraerStructs(
            YLenguajeParser.InicioContext tree) {
        java.util.Map<String, StructSimbolo> out = new java.util.LinkedHashMap<>();
        if (tree == null || tree.bloq_estruc() == null) return out;
        for (YLenguajeParser.EsctrucContext e : tree.bloq_estruc().esctruc()) {
            String nombre = e.ID().getText();
            StructSimbolo s = new StructSimbolo(nombre, e.ID().getSymbol().getLine());
            for (YLenguajeParser.DefinicionesContext d : e.definiciones()) {
                if (d.ID().isEmpty()) continue;
                String tipoRaw = d.tipos() != null ? d.tipos().getText()
                        : (d.ID().size() > 1 ? d.ID(0).getText() : "entero");
                Tipo t;
                switch (tipoRaw) {
                    case "entero": t = Tipo.ENTERO; break;
                    case "flotante": t = Tipo.FLOTANTE; break;
                    case "cadena": t = Tipo.CADENA; break;
                    case "caracter": t = Tipo.CARACTER; break;
                    case "bool": t = Tipo.BOOL; break;
                    default: t = Tipo.struct(tipoRaw); break;
                }
                if (!d.LCORCH().isEmpty()) t = Tipo.series(t);
                s.campos.putIfAbsent(d.ID(d.ID().size() - 1).getText(), t);
            }
            out.putIfAbsent(nombre, s);
        }
        return out;
    }
    public void analizar(YLenguajeParser.InicioContext tree) {
        visitInicio(tree);
    }

    private int linea(ParseTree n) {
        if (n instanceof YLenguajeParser.InicioContext c) return c.getStart().getLine();
        if (n instanceof ParseTree) {
            try {
                java.lang.reflect.Method m = n.getClass().getMethod("getStart");
                Object t = m.invoke(n);
                if (t instanceof org.antlr.v4.runtime.Token tok) return tok.getLine();
            } catch (Exception ignored) { }
        }
        return 1;
    }

    @Override
    public Tipo visitInicio(YLenguajeParser.InicioContext ctx) {
        if (ctx.bloq_estruc() != null) {
            for (YLenguajeParser.EsctrucContext e : ctx.bloq_estruc().esctruc()) {
                String nombre = e.ID().getText();
                if (tabla.existeStruct(nombre)) {
                    errores.semantico(e.ID().getSymbol().getLine(),
                            "La estructura ya fue declarada: '" + nombre + "'.");
                } else {
                    tabla.definirStruct(new StructSimbolo(nombre, e.ID().getSymbol().getLine()));
                }
            }
            for (YLenguajeParser.EsctrucContext e : ctx.bloq_estruc().esctruc()) {
                registrarCampos(e);
            }
        }
        if (ctx.bloq_func() != null) {
            for (YLenguajeParser.Bloc_funcContext f : ctx.bloq_func().bloc_func()) {
                registrarFirma(f);
            }
            for (YLenguajeParser.Bloc_funcContext f : ctx.bloq_func().bloc_func()) {
                visitBloc_func(f);
            }
        }
        return Tipo.VOID;
    }

    private void registrarCampos(YLenguajeParser.EsctrucContext e) {
        StructSimbolo s = tabla.obtenerStruct(e.ID().getText());
        if (s == null) return;
        Set<String> vistos = new HashSet<>();
        for (YLenguajeParser.DefinicionesContext d : e.definiciones()) {
            List<TerminalNode> ids = d.ID();
            if (ids.isEmpty()) continue;
            String tipoRaw = d.tipos() != null ? d.tipos().getText()
                    : (ids.size() > 1 ? ids.get(0).getText() : null);
            String campo = ids.get(ids.size() - 1).getText();
            int ln = ids.get(ids.size() - 1).getSymbol().getLine();
            if (!vistos.add(campo)) {
                errores.semantico(ln, "Atributo duplicado: '" + campo
                        + "' en estructura '" + s.name + "'.");
                continue;
            }
            Tipo tCampo = tipoDeCampo(tipoRaw, ln);
            if (!d.LCORCH().isEmpty()) {
                for (YLenguajeParser.ExpresionContext sz : d.expresion()) {
                    Tipo t = tipoExpresionAislada(sz);
                    if (!t.esError() && !t.esNumero()) {
                        errores.semantico(linea(sz),
                                "El tamaño del arreglo debe ser de tipo entero.");
                        break;
                    }
                }
                tCampo = Tipo.series(tCampo);
            }
            s.campos.put(campo, tCampo);
        }
    }

    private Tipo tipoDeCampo(String tipoRaw, int ln) {
        if (tipoRaw == null) return Tipo.ERROR;
        switch (tipoRaw) {
            case "entero": return Tipo.ENTERO;
            case "flotante": return Tipo.FLOTANTE;
            case "cadena": return Tipo.CADENA;
            case "caracter": return Tipo.CARACTER;
            case "bool": return Tipo.BOOL;
            default:
                if (tabla.existeStruct(tipoRaw)) return Tipo.struct(tipoRaw);
                errores.semantico(ln, "Tipo no declarado: '" + tipoRaw + "'.");
                return Tipo.ERROR;
        }
    }

    private void registrarFirma(YLenguajeParser.Bloc_funcContext f) {
        String nombre = f.ID(0).getText();
        int ln = f.ID(0).getSymbol().getLine();
        if (tabla.existeFunc(nombre)) {
            errores.semantico(ln, "La función '" + nombre + "' ya está declarada.");
            return;
        }
        Tipo retorno = Tipo.VOID;
        if (f.RETORNO_FUNC() != null) {
            String retRaw = f.tipos() != null ? f.tipos().getText()
                    : (f.ID().size() > 1 ? f.ID(1).getText() : null);
            retorno = tipoDeCampo(retRaw == null ? "entero" : retRaw, ln);
        }
        List<Tipo> tps = new ArrayList<>();
        List<String> nps = new ArrayList<>();
        Set<String> vistos = new HashSet<>();
        if (f.params() != null) {
            for (YLenguajeParser.Tipos_paramsContext tp : f.params().tipos_params()) {
                List<TerminalNode> ids = tp.ID();
                String tRaw = tp.tipos() != null ? tp.tipos().getText()
                        : (ids.size() >= 2 ? ids.get(0).getText() : "entero");
                String pNombre = ids.get(ids.size() - 1).getText();
                int pln = ids.get(ids.size() - 1).getSymbol().getLine();
                if (!vistos.add(pNombre)) {
                    errores.semantico(pln, "Parámetro duplicado: '" + pNombre
                            + "' en función '" + nombre + "'.");
                }
                Tipo t = tipoDeCampo(tRaw, pln);
                if (tp.LCORCH() != null) t = Tipo.series(t);
                tps.add(t);
                nps.add(pNombre);
            }
        }
        tabla.definirFunc(new FuncSimbolo(nombre, ln, retorno, tps, nps));
    }

    @Override
    public Tipo visitBloc_func(YLenguajeParser.Bloc_funcContext ctx) {
        String nombre = ctx.ID(0).getText();
        FuncSimbolo fs = tabla.obtenerFunc(nombre);
        if (fs == null) {
            fs = new FuncSimbolo(nombre, linea(ctx), Tipo.VOID, List.of(), List.of());
        }
        FuncSimbolo previa = funcionActual;
        funcionActual = fs;
        int cicloPrevio = profundidadCiclo;
        profundidadCiclo = 0;
        tabla.entrar("funcion: " + nombre);
        for (int i = 0; i < fs.nombresParams.size(); i++) {
            String pn = fs.nombresParams.get(i);
            Tipo pt = i < fs.tiposParams.size() ? fs.tiposParams.get(i) : Tipo.ERROR;
            if (tabla.existeLocal(pn)) {
                errores.semantico(linea(ctx), "Parámetro ya declarado: '" + pn + "'.");
            } else {
                tabla.definirVar(new VarSymbol(pn, linea(ctx), pt));
            }
        }
        procesarBloque(ctx.bloque());
        if (fs.retorno.base != Tipo.Base.VOID && !siempreRetorna(ctx.bloque())) {
            errores.semantico(linea(ctx),
                    "La función '" + nombre + "' debe retornar un valor de tipo " + fs.retorno + " (falta 'retornar').");
        }
        tabla.salir();
        profundidadCiclo = cicloPrevio;
        funcionActual = previa;
        return Tipo.VOID;
    }

    private void procesarBloque(YLenguajeParser.BloqueContext b) {
        if (b == null) return;
        tabla.entrar("bloque");
        boolean yaRetorno = false;
        for (YLenguajeParser.InstruccionesContext s : b.instrucciones()) {
            if (yaRetorno) {
                errores.semantico(linea(s), "Código inalcanzable: ya existe 'retornar' antes.");
            }
            visitInstrucciones(s);
            if (s.RETORNAR() != null) yaRetorno = true;
        }
        tabla.salir();
    }

    private boolean siempreRetorna(YLenguajeParser.BloqueContext b) {
        if (b == null) return false;
        for (YLenguajeParser.InstruccionesContext s : b.instrucciones()) {
            if (s.RETORNAR() != null) return true;
            if (s.SI() != null) {
                boolean todas = siempreRetorna(s.bloque());
                YLenguajeParser.Bloc_siContext bs = s.bloc_si();
                boolean tieneContrario = bs != null && bs.CONTRARIO() != null;
                if (bs != null && bs.children != null) {
                    for (ParseTree ch : bs.children) {
                        if (ch instanceof YLenguajeParser.BloqueContext sb) {
                            todas = todas && siempreRetorna(sb);
                        }
                    }
                }
                if (tieneContrario && todas) return true;
            }
        }
        return false;
    }

    @Override
    public Tipo visitInstrucciones(YLenguajeParser.InstruccionesContext ctx) {
        if (ctx.definiciones() != null) return visitarDefinicion(ctx.definiciones());
        if (ctx.asignaciones() != null) return visitarAsignacion(ctx.asignaciones());
        if (ctx.IMPRIMIR() != null) {
            for (YLenguajeParser.ExpresionContext e : ctx.expresion()) {
                Tipo t = tipoExpresion(e);
                if (t.base == Tipo.Base.SERIES || t.base == Tipo.Base.STRUCT) {
                    errores.semantico(linea(ctx),
                            "No se puede imprimir una serie o estructura directamente.");
                }
            }
            return Tipo.VOID;
        }
        if (ctx.SI() != null) {
            exigirBool(tipoExpresion(ctx.expresion(0)), linea(ctx), "'si'");
            procesarBloque(ctx.bloque());
            YLenguajeParser.Bloc_siContext bs = ctx.bloc_si();
            if (bs != null) {
                List<YLenguajeParser.ExpresionContext> conds = bs.expresion();
                for (YLenguajeParser.ExpresionContext c : conds) {
                    exigirBool(tipoExpresion(c), linea(ctx), "'sino'");
                }
                if (bs.children != null) {
                    for (ParseTree ch : bs.children) {
                        if (ch instanceof YLenguajeParser.BloqueContext sb) procesarBloque(sb);
                    }
                }
            }
            return Tipo.VOID;
        }
        if (ctx.MIENTRAS() != null && ctx.HACER() != null && ctx.DOS_PUNTOS() == null) {
            exigirBool(tipoExpresion(ctx.expresion(0)), linea(ctx), "'mientras'");
            profundidadCiclo++;
            procesarBloque(ctx.bloque());
            profundidadCiclo--;
            return Tipo.VOID;
        }
        if (ctx.HACER() != null && ctx.DOS_PUNTOS() != null) {
            profundidadCiclo++;
            procesarBloque(ctx.bloque());
            profundidadCiclo--;
            exigirBool(tipoExpresion(ctx.expresion(0)), linea(ctx), "'hacer ... mientras'");
            return Tipo.VOID;
        }
        if (ctx.PARA() != null) {
            tabla.entrar("para");
            String var = ctx.ID(0).getText();
            Tipo tIter = tipoDeCampo(ctx.tipos().getText(), linea(ctx));
            Tipo tInit = tipoExpresion(ctx.expresion(0));
            if (!tIter.esError() && !tInit.esError()
                    && !Tipo.asignableY(tIter, tInit)) {
                errores.semantico(linea(ctx), "El valor inicial del iterador '" + var
                        + "' no es compatible con " + tIter + ".");
            }
            tabla.definirVar(new VarSymbol(var, linea(ctx), tIter));
            exigirBool(tipoExpresion(ctx.expresion(1)), linea(ctx), "'para'");
            VarSymbol vs = tabla.obtenerVar(ctx.ID(1).getText());
            if (vs == null) {
                errores.semantico(linea(ctx),
                        "La variable no ha sido declarada: '" + ctx.ID(1).getText() + "'.");
            } else if (!vs.type.esNumero() && !vs.type.esError()) {
                errores.semantico(linea(ctx),
                        "El operador '++/--' solo aplica a tipos numéricos (entero, flotante).");
            }
            profundidadCiclo++;
            if (ctx.bloque() != null) {
                boolean yaRet = false;
                for (YLenguajeParser.InstruccionesContext s : ctx.bloque().instrucciones()) {
                    if (yaRet) errores.semantico(linea(s), "Código inalcanzable: ya existe 'retornar' antes.");
                    visitInstrucciones(s);
                    if (s.RETORNAR() != null) yaRet = true;
                }
            }
            profundidadCiclo--;
            tabla.salir();
            return Tipo.VOID;
        }
        if (ctx.ELEGITR() != null) {
            Tipo tSel = tipoExpresion(ctx.expresion(0));
            if (!tSel.esPrimitivo() && !tSel.esError()) {
                errores.semantico(linea(ctx), "El selector de 'elegir' debe ser un tipo primitivo.");
            }
            profundidadSwitch++;
            profundidadCiclo++;
            YLenguajeParser.Bloque_elegirContext be = ctx.bloque_elegir();
            if (be != null && be.children != null) {
                for (ParseTree ch : be.children) {
                    if (ch instanceof YLenguajeParser.ExpresionContext ce) {
                        Tipo tc = tipoExpresion(ce);
                        if (!tc.esError() && !tSel.esError()
                                && !Tipo.asignableY(tSel, tc) && !Tipo.asignableY(tc, tSel)) {
                            errores.semantico(linea(ce),
                                    "El 'caso' de tipo " + tc + " no es compatible con el selector " + tSel + ".");
                        }
                    } else if (ch instanceof YLenguajeParser.BloqueContext sb) {
                        procesarBloque(sb);
                    }
                }
            }
            profundidadCiclo--;
            profundidadSwitch--;
            return Tipo.VOID;
        }
        if (ctx.RETORNAR() != null) {
            if (funcionActual == null) {
                errores.semantico(linea(ctx), "'retornar' usado fuera de una función.");
                return Tipo.VOID;
            }
            if (ctx.expresion().isEmpty()) {
                if (funcionActual.retorno.base != Tipo.Base.VOID) {
                    errores.semantico(linea(ctx), "La función '" + funcionActual.name
                            + "' debe devolver un valor de tipo " + funcionActual.retorno + ".");
                }
            } else {
                Tipo real = tipoExpresion(ctx.expresion(0));
                if (funcionActual.retorno.base == Tipo.Base.VOID) {
                    errores.semantico(linea(ctx), "La función '" + funcionActual.name
                            + "' es sin retorno y no puede devolver valores.");
                } else if (!funcionActual.retorno.esError() && !real.esError()
                        && !Tipo.asignableY(funcionActual.retorno, real)) {
                    errores.semantico(linea(ctx), "El valor a retornar (" + real
                            + ") no es compatible con el retorno " + funcionActual.retorno + ".");
                }
            }
            return Tipo.VOID;
        }
        if (ctx.ROMPER() != null) {
            if (profundidadCiclo == 0 && profundidadSwitch == 0) {
                errores.semantico(linea(ctx), "'romper' usado fuera de un ciclo o 'elegir'.");
            }
            return Tipo.VOID;
        }
        if (ctx.CONTINUAR() != null) {
            if (profundidadCiclo == 0) {
                errores.semantico(linea(ctx), "'continuar' usado fuera de un ciclo.");
            }
            return Tipo.VOID;
        }
        return Tipo.VOID;
    }

    private Tipo visitarDefinicion(YLenguajeParser.DefinicionesContext d) {
        List<TerminalNode> ids = d.ID();
        if (ids.isEmpty()) return Tipo.ERROR;
        String tipoRaw = d.tipos() != null ? d.tipos().getText()
                : (ids.size() > 1 ? ids.get(0).getText() : null);
        String nombre = ids.get(ids.size() - 1).getText();
        int ln = ids.get(ids.size() - 1).getSymbol().getLine();
        Tipo declarado = tipoDeCampo(tipoRaw == null ? "entero" : tipoRaw, ln);

        List<YLenguajeParser.ExpresionContext> exprs = d.expresion();
        boolean esArreglo = !d.LCORCH().isEmpty();
        boolean conLlaves = d.LLLAVE() != null || d.bloc_llaves() != null;

        if (tabla.existeLocal(nombre)) {
            errores.semantico(ln, "Variable ya declarada: '" + nombre + "'.");
        }

        if (esArreglo) {
            for (YLenguajeParser.ExpresionContext sz : exprs) {
               Tipo t = tipoExpresion(sz);
                if (!t.esError() && !t.esNumero()) {
                    errores.semantico(linea(sz), "El índice/tamaño del arreglo debe ser numérico.");
                }
            }
            Tipo tSerie = Tipo.series(declarado);
            Integer tam = null;
            if (!exprs.isEmpty()) tam = constanteEntera(exprs.get(0));
            if (d.bloc_llaves() != null) {
                validarBlocLlaves(d.bloc_llaves(), declarado, tam, nombre, ln);
            }
            VarSymbol vs = new VarSymbol(nombre, ln, tSerie);
            vs.sizeSeries = tam;
            tabla.definirVar(vs);
            return tSerie;
        }
        if (conLlaves) {
            YLenguajeParser.Val_arregloContext vals = d.val_arreglo();
            if (vals != null) {
                for (YLenguajeParser.ExpresionContext v : vals.expresion()) {
                    Tipo real = tipoExpresion(v);
                    if (!declarado.esError() && !real.esError()
                            && !Tipo.asignableY(declarado, real)) {
                        errores.semantico(linea(v), "Valor " + real
                                + " incompatible con el arreglo '" + nombre + "' de " + declarado + ".");
                    }
                }
            }
            VarSymbol vs = new VarSymbol(nombre, ln, Tipo.series(declarado));
            vs.sizeSeries = vals == null ? null : vals.expresion().size();
            tabla.definirVar(vs);
            return vs.type;
        }
        if (d.ASIG() != null && !exprs.isEmpty()) {
            Tipo real = tipoExpresion(exprs.get(0));
            if (declarado.base == Tipo.Base.STRUCT && esLiteralLlaves(exprs.get(0))) {
                validarLiteralStruct(declarado, exprs.get(0), ln);
            } else if (!declarado.esError() && !real.esError()
                    && !Tipo.asignableY(declarado, real)) {
                errores.semantico(ln, "El tipo " + real + " no es compatible con '"
                        + nombre + "' de tipo " + declarado + ".");
            }
            tabla.definirVar(new VarSymbol(nombre, ln, declarado));
            return declarado;
        }
        tabla.definirVar(new VarSymbol(nombre, ln, declarado));
        return declarado;
    }

    private void validarBlocLlaves(YLenguajeParser.Bloc_llavesContext b, Tipo elem,
                                   Integer tam, String nombre, int ln) {
        int total = b.val_arreglo().size();
        if (tam != null && total != tam) {
            errores.semantico(ln, "El inicializador de '" + nombre + "' trae " + total
                    + " fila(s) pero el tamaño es " + tam + ".");
        }
        for (YLenguajeParser.Val_arregloContext fila : b.val_arreglo()) {
            for (YLenguajeParser.ExpresionContext v : fila.expresion()) {
                Tipo real = tipoExpresion(v);
                if (!elem.esError() && !real.esError() && !Tipo.asignableY(elem, real)) {
                    errores.semantico(linea(v), "Valor " + real
                            + " incompatible con el arreglo '" + nombre + "' de " + elem + ".");
                }
            }
        }
    }

    private boolean esLiteralLlaves(YLenguajeParser.ExpresionContext e) {
        String t = e.getText();
        return t.startsWith("{") && t.endsWith("}");
    }

    private void validarLiteralStruct(Tipo declarado, YLenguajeParser.ExpresionContext lit, int ln) {
        StructSimbolo s = tabla.obtenerStruct(declarado.nombreStruct);
        if (s == null) return;
        List<Tipo> reales = new ArrayList<>();
        recolectarExpresiones(lit, reales);
        List<String> campos = new ArrayList<>(s.campos.keySet());
        if (reales.size() != campos.size()) {
            errores.semantico(ln, "La estructura '" + s.name + "' espera " + campos.size()
                    + " valor(es) pero se dieron " + reales.size() + ".");
            return;
        }
        for (int i = 0; i < campos.size(); i++) {
            Tipo esp = s.campos.get(campos.get(i));
            Tipo real = reales.get(i);
            if (!esp.esError() && !real.esError() && !Tipo.asignableY(esp, real)) {
                errores.semantico(ln, "El atributo '" + campos.get(i) + "' espera " + esp
                        + " pero se dio " + real + ".");
            }
        }
    }

    private void recolectarExpresiones(YLenguajeParser.ExpresionContext e, List<Tipo> out) {
        for (YLenguajeParser.ExpresionContext sub : e.expresion()) {
            if (sub.getChildCount() == 1 && sub.getChild(0) instanceof YLenguajeParser.ExpresionContext) {
                recolectarExpresiones(sub, out);
            } else if (esLiteralLlaves(sub)) {
                recolectarExpresiones(sub, out);
            } else {
                out.add(tipoExpresion(sub));
            }
        }
    }

    private Tipo visitarAsignacion(YLenguajeParser.AsignacionesContext a) {
        List<TerminalNode> ids = a.ID();
        List<YLenguajeParser.ExpresionContext> exprs = a.expresion();
        int ln = linea(a);
        if (a.ASIG() == null) {
            VarSymbol vs = tabla.obtenerVar(ids.get(0).getText());
            if (vs == null) {
                errores.semantico(ln, "La variable no ha sido declarada: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            if (!vs.type.esNumero() && !vs.type.esError()) {
                errores.semantico(ln, "El operador '++/--' solo aplica a tipos numéricos (entero, flotante).");
            }
            return vs.type;
        }
        if (a.PUNTO() != null) {
            VarSymbol vs = tabla.obtenerVar(ids.get(0).getText());
            Tipo real = tipoExpresion(exprs.get(exprs.size() - 1));
            if (vs == null) {
                errores.semantico(ln, "La variable no ha sido declarada: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            if (vs.type.base != Tipo.Base.STRUCT) {
                errores.semantico(ln, "No es una variable de tipo estructura: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            StructSimbolo s = tabla.obtenerStruct(vs.type.nombreStruct);
            String campo = ids.get(1).getText();
            if (s == null || !s.tieneCampo(campo)) {
                errores.semantico(ln, "La estructura '" + vs.type + "' no tiene el atributo '" + campo + "'.");
                return Tipo.ERROR;
            }
            Tipo esperado = s.tipoCampo(campo);
            if (!a.LCORCH().isEmpty()) {
                if (esperado.base != Tipo.Base.SERIES) {
                    errores.semantico(ln, "El atributo '" + campo + "' no es un arreglo.");
                    return Tipo.ERROR;
                }
                for (int i = 0; i < exprs.size() - 1; i++) {
                    exigirIndice(exprs.get(i));
                }
                esperado = esperado.elementos;
            }
            if (!esperado.esError() && !real.esError() && !Tipo.asignableY(esperado, real)) {
                errores.semantico(ln, "No se puede asignar " + real + " al atributo '" + campo + "' de " + esperado + ".");
            }
            return esperado;
        }
        if (!a.LCORCH().isEmpty()) {
            VarSymbol vs = tabla.obtenerVar(ids.get(0).getText());
            if (vs == null) {
                errores.semantico(ln, "La variable no ha sido declarada: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            if (vs.type.base != Tipo.Base.SERIES) {
                errores.semantico(ln, "No es de tipo arreglo: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            for (int i = 0; i < exprs.size() - 1; i++) exigirIndice(exprs.get(i));
            Tipo real = tipoExpresion(exprs.get(exprs.size() - 1));
            Tipo elem = vs.type.elementos;
            if (!elem.esError() && !real.esError() && !Tipo.asignableY(elem, real)) {
                errores.semantico(ln, "No se puede asignar " + real + " al arreglo '" + ids.get(0).getText()
                        + "' de " + elem + ".");
            }
            return elem;
        }
        VarSymbol vs = tabla.obtenerVar(ids.get(0).getText());
        Tipo real = tipoExpresion(exprs.get(0));
        if (vs == null) {
            errores.semantico(ln, "La variable no ha sido declarada: '" + ids.get(0).getText() + "'.");
            return Tipo.ERROR;
        }
        if (!vs.type.esError() && !real.esError() && !Tipo.asignableY(vs.type, real)) {
            errores.semantico(ln, "Valores no compatibles: " + real + " <-> " + vs.type + ".");
        }
        return vs.type;
    }

    private void exigirIndice(YLenguajeParser.ExpresionContext idx) {
        Tipo t = tipoExpresion(idx);
        if (!t.esError() && t.base != Tipo.Base.ENTERO) {
            errores.semantico(linea(idx), "El índice del arreglo debe ser de tipo entero.");
        }
    }

    public Tipo tipoExpresion(YLenguajeParser.ExpresionContext e) {
        int n = e.getChildCount();
        if (n == 1) {
            ParseTree ch = e.getChild(0);
            if (ch instanceof TerminalNode tn) {
                switch (tn.getText()) {
                    case "verdadero":
                    case "falso":
                        return Tipo.BOOL;
                    default:
                        break;
                }
                int tipo = tn.getSymbol().getType();
                if (tipo == YLenguajeParser.ID) {
                    VarSymbol vs = tabla.obtenerVar(tn.getText());
                    FuncSimbolo fs = tabla.obtenerFunc(tn.getText());
                    if (vs != null) return vs.type;
                    if (fs != null) {
                        errores.semantico(tn.getSymbol().getLine(),
                                "La función '" + tn.getText() + "' debe invocarse con argumentos.");
                        return fs.retorno;
                    }
                    errores.semantico(tn.getSymbol().getLine(),
                            "La variable no ha sido declarada: '" + tn.getText() + "'.");
                    return Tipo.ERROR;
                }
                if (tipo == YLenguajeParser.INT) return Tipo.ENTERO;
                if (tipo == YLenguajeParser.DECIMAL) return Tipo.FLOTANTE;
                if (tipo == YLenguajeParser.STRING) return Tipo.CADENA;
                if (tipo == YLenguajeParser.CHAR) return Tipo.CARACTER;
                if (tipo == YLenguajeParser.VERDADERO || tipo == YLenguajeParser.FALSO) return Tipo.BOOL;
                return Tipo.ERROR;
            }
            if (ch instanceof YLenguajeParser.ExpresionContext sub) return tipoExpresion(sub);
            return Tipo.ERROR;
        }
        if (n == 2 && e.getChild(1) instanceof YLenguajeParser.ExpresionContext sub2) {
            String op = e.getChild(0).getText();
            Tipo v = tipoExpresion(sub2);
            if (op.equals("-")) {
                if (!v.esNumero() && !v.esError()) {
                    errores.semantico(linea(e), "El operador '-' solo aplica a entero/flotante.");
                    return Tipo.ERROR;
                }
                return v;
            }
            if (op.equals("!")) {
                if (!v.equals(Tipo.BOOL) && !v.esError()) {
                    errores.semantico(linea(e), "El operador '!' solo aplica a tipo bool.");
                }
                return Tipo.BOOL;
            }
            return Tipo.ERROR;
        }
        if (n == 3 && e.getChild(1) instanceof TerminalNode opNode
                && e.getChild(0) instanceof YLenguajeParser.ExpresionContext hi
                && e.getChild(2) instanceof YLenguajeParser.ExpresionContext hd) {
            String a = e.getChild(0).getText();
            ParseTree c3 = e.getChild(2);
            if (a.equals("(") && c3.getText().equals(")")) {
                return tipoExpresion((YLenguajeParser.ExpresionContext) e.getChild(1));
            }
            if (a.equals("leer")) {
                return Tipo.CADENA;
            }
            Tipo izq = tipoExpresion(hi);
            String op = opNode.getText();
            Tipo der = tipoExpresion(hd);
            return tipoBinaria(izq, op, der, linea(e));
        }
        if (n == 3 && e.getChild(0).getText().equals("(")
                && e.getChild(2).getText().equals(")")
                && e.getChild(1) instanceof YLenguajeParser.ExpresionContext par) {
            return tipoExpresion(par);
        }
        if (n == 3 && e.getChild(0).getText().equals("leer")) {
            return Tipo.CADENA;
        }
        String txt = e.getText();
        if (txt.contains("(")) {
            return tipoLlamada(e, linea(e));
        }
        if (txt.contains("[") && e.PUNTO() == null) {
            List<YLenguajeParser.ExpresionContext> subs = e.expresion();
            if (subs.size() >= 2) {
                String baseTxt = subs.get(0).getText();
                VarSymbol vs = tabla.obtenerVar(baseTxt);
                if (vs == null) {
                    errores.semantico(linea(e), "La variable no ha sido declarada: '" + baseTxt + "'.");
                    return Tipo.ERROR;
                }
                if (vs.type.base != Tipo.Base.SERIES) {
                    errores.semantico(linea(e), "La variable no es un arreglo: '" + baseTxt + "'.");
                    return Tipo.ERROR;
                }
                for (int i = 1; i < subs.size(); i++) exigirIndice(subs.get(i));
                return vs.type.elementos;
            }
        }
        if (e.PUNTO() != null) {
            List<TerminalNode> ids = e.ID();
            if (ids.size() >= 2) {
                VarSymbol vs = tabla.obtenerVar(ids.get(0).getText());
                if (vs == null) {
                    errores.semantico(linea(e),
                            "La variable no ha sido declarada: '" + ids.get(0).getText() + "'.");
                    return Tipo.ERROR;
                }
                if (vs.type.base != Tipo.Base.STRUCT) {
                    errores.semantico(linea(e),
                            "No es una variable de tipo estructura: '" + ids.get(0).getText() + "'.");
                    return Tipo.ERROR;
                }
                StructSimbolo s = tabla.obtenerStruct(vs.type.nombreStruct);
                String campo = ids.get(1).getText();
                if (s == null || !s.tieneCampo(campo)) {
                    errores.semantico(linea(e), "La estructura '" + vs.type
                            + "' no tiene el atributo '" + campo + "'.");
                    return Tipo.ERROR;
                }
                Tipo tCampo = s.tipoCampo(campo);
                List<YLenguajeParser.ExpresionContext> subs = e.expresion();
                if (!subs.isEmpty() && tCampo.base == Tipo.Base.SERIES) {
                    for (YLenguajeParser.ExpresionContext idx : subs) exigirIndice(idx);
                    return tCampo.elementos;
                }
                return tCampo;
            }
        }
        return Tipo.ERROR;
    }

    private Tipo tipoBinaria(Tipo izq, String op, Tipo der, int ln) {
        if (izq.esError() || der.esError()) return Tipo.ERROR;
        switch (op) {
            case "+":
                if (izq.base == Tipo.Base.CADENA || der.base == Tipo.Base.CADENA) {
                    if (!izq.esPrimitivo() || !der.esPrimitivo()) {
                        errores.semantico(ln, "No se puede concatenar una serie o estructura con cadena.");
                        return Tipo.ERROR;
                    }
                    return Tipo.CADENA;
                }
                if (!izq.esPrimitivo() || !der.esPrimitivo()) {
                    errores.semantico(ln, "El operador '+' solo aplica a tipos primitivos.");
                    return Tipo.ERROR;
                }
                if (!izq.esNumero() || !der.esNumero()) {
                    errores.semantico(ln, "El operador '+' solo combina numéricos o cadena con numéricos.");
                    return Tipo.ERROR;
                }
                return Tipo.resultado(izq, der);
            case "-":
            case "*":
            case "/":
                if (izq.base == Tipo.Base.CADENA || der.base == Tipo.Base.CADENA) {
                    errores.semantico(ln, "El operador '" + op + "' no es compatible con cadena.");
                    return Tipo.ERROR;
                }
                if (!izq.esPrimitivo() || !der.esPrimitivo()) {
                    errores.semantico(ln, "El operador '" + op + "' solo aplica a tipos primitivos.");
                    return Tipo.ERROR;
                }
                if (!izq.esNumero() || !der.esNumero()) {
                    errores.semantico(ln, "El operador '" + op + "' solo opera entre entero y flotante.");
                    return Tipo.ERROR;
                }
                return Tipo.resultado(izq, der);
            case "==":
            case "!=":
                if (!izq.esPrimitivo() || !der.esPrimitivo()) {
                    errores.semantico(ln, "El operador '" + op + "' solo aplica a tipos primitivos.");
                } else if ((izq.base == Tipo.Base.CADENA) != (der.base == Tipo.Base.CADENA)) {
                    errores.semantico(ln, "Solo se puede comparar cadena con cadena.");
                } else if (izq.base == Tipo.Base.BOOL || der.base == Tipo.Base.BOOL) {
                    if (!izq.equals(Tipo.BOOL) || !der.equals(Tipo.BOOL)) {
                        errores.semantico(ln, "Solo se puede comparar bool con bool.");
                    }
                }
                return Tipo.BOOL;
            case "<":
            case ">":
            case "<=":
            case ">=":
                if (izq.base == Tipo.Base.CADENA || der.base == Tipo.Base.CADENA
                        || !izq.esPrimitivo() || !der.esPrimitivo()) {
                    errores.semantico(ln, "El operador '" + op + "' no aplica a cadena, serie o estructura.");
                } else if (!izq.esNumero() && izq.base != Tipo.Base.CARACTER
                        || !der.esNumero() && der.base != Tipo.Base.CARACTER) {
                    errores.semantico(ln, "El operador '" + op + "' compara numéricos o caracteres.");
                }
                return Tipo.BOOL;
            case "&&":
            case "||":
                if (!izq.equals(Tipo.BOOL) || !der.equals(Tipo.BOOL)) {
                    errores.semantico(ln, "El operador '" + op + "' solo opera sobre bool (verdadero/falso).");
                }
                return Tipo.BOOL;
            default:
                return Tipo.ERROR;
        }
    }

    private Tipo tipoLlamada(YLenguajeParser.ExpresionContext e, int ln) {
        List<TerminalNode> ids = e.ID();
        if (ids.isEmpty()) return Tipo.ERROR;
        String nombre = ids.get(0).getText();
        List<Tipo> args = new ArrayList<>();
        for (YLenguajeParser.ExpresionContext sub : e.expresion()) {
            args.add(tipoExpresion(sub));
        }
        if (!e.LCORCH().isEmpty() && !args.isEmpty()) {
            args = args.subList(1, args.size());
        }
        if (e.PUNTO() != null && !args.isEmpty()) {
            args = args.subList(1, args.size());
        }
        return validarLlamada(nombre, args, ln);
    }

    private Tipo validarLlamada(String nombre, List<Tipo> args, int ln) {
        FuncSimbolo fs = tabla.obtenerFunc(nombre);
        if (fs == null) {
            errores.semantico(ln, "La función no ha sido declarada: '" + nombre + "'.");
            return Tipo.ERROR;
        }
        if (fs.tiposParams.size() != args.size()) {
            errores.semantico(ln, "La función '" + nombre + "' necesita " + fs.tiposParams.size()
                    + " argumento(s) pero se recibieron " + args.size() + ".");
            return fs.retorno;
        }
        for (int i = 0; i < args.size(); i++) {
            Tipo esp = fs.tiposParams.get(i);
            Tipo real = args.get(i);
            if (real.esError() || esp.esError()) continue;
            if (!Tipo.asignableY(esp, real)) {
                errores.semantico(ln, "El argumento " + (i + 1) + " de '" + nombre
                        + "' espera " + esp + " pero se dio " + real + ".");
            }
        }
        return fs.retorno;
    }

    private void exigirBool(Tipo t, int ln, String ctx) {
        if (!t.equals(Tipo.BOOL) && !t.esError()) {
            errores.semantico(ln, "La condición de " + ctx + " debe ser de tipo bool.");
        }
    }

    private Tipo tipoExpresionAislada(YLenguajeParser.ExpresionContext e) {
        try {
            return tipoExpresion(e);
        } catch (Exception ex) {
            return Tipo.ERROR;
        }
    }

    private Integer constanteEntera(YLenguajeParser.ExpresionContext e) {
        String t = e.getText().trim();
        try {
            return Integer.parseInt(t);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
