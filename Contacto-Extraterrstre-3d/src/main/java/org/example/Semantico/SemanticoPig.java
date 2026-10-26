package org.example.Semantico;

import antlr4.com.antlr4.com.PigLatinParserBaseVisitor;
import antlr4.com.antlr4.com.PigLatinParserParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.Ejecutor.ClaseZ;
import org.example.Ejecutor.FuncInfo;
import org.example.Reports.ErrorReporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SemanticoPig extends PigLatinParserBaseVisitor<Tipo> {

    private final TablaSimbolos tabla = new TablaSimbolos();
    private final ErrorReporter errores;
    private final Map<String, FuncInfo> funcionesY;
    private final Map<String, ClaseZ> clasesZ;

    private final Map<String, StructSimbolo> structsY;
    private int profundidadCiclo = 0;

    public SemanticoPig(ErrorReporter errores,
                        Map<String, FuncInfo> funcionesY,
                        Map<String, ClaseZ> clasesZ,
                        Map<String, StructSimbolo> structsY) {
        this.errores = errores;
        this.funcionesY = funcionesY == null ? Map.of() : funcionesY;
        this.clasesZ = clasesZ == null ? Map.of() : clasesZ;
        this.structsY = structsY == null ? Map.of() : structsY;
        for (String n : this.structsY.keySet()) {
            if (!tabla.existeStruct(n)) tabla.definirStruct(this.structsY.get(n));
        }
    }

    public TablaSimbolos getTabla() {
        return tabla;
    }

    public void analizar(PigLatinParserParser.InicioContext tree) {
        visitInicio(tree);
    }

    private int linea(ParseTree n) {
        if (n instanceof org.antlr.v4.runtime.ParserRuleContext c) return c.getStart().getLine();
        return 1;
    }

    @Override
    public Tipo visitInicio(PigLatinParserParser.InicioContext ctx) {
        if (ctx.instrucciones() == null) return Tipo.VOID;
        if (ctx.instrucciones().vars_par() != null) {
            for (PigLatinParserParser.Bloque_varsContext b
                    : ctx.instrucciones().vars_par().bloque_vars()) {
                visitarGlobal(b);
            }
        }
        if (ctx.instrucciones().bloque_main() != null) {
            tabla.entrar("maior");
            for (PigLatinParserParser.InstruccionContext s
                    : ctx.instrucciones().bloque_main().instruccion()) {
                visitInstruccion(s);
            }
            tabla.salir();
        }
        return Tipo.VOID;
    }

    private void visitarGlobal(PigLatinParserParser.Bloque_varsContext b) {
        List<TerminalNode> ids = b.ID();
        if (ids.isEmpty()) return;
        int ln = linea(b);
        if (b.ESTO() != null && b.SERIES() == null) {
            String nombre = ids.get(0).getText();
            if (b.NOVUS() != null) {
                String clase = ids.size() > 1 ? ids.get(1).getText() : "?";
                List<Tipo> args = tiposBloqueObjt(b.bloque_objt());
                validarConstructor(clase, args, ln);
                declarar(nombre, Tipo.struct(clase), ln);
                return;
            }
            if (b.tipos() != null) {
                Tipo declarado = Tipo.desdePig(b.tipos().getText(), tabla, ln, errores);
                if (b.expresion() != null) {
                    Tipo real = visit(b.expresion());
                    if (!declarado.esError() && !real.esError()
                            && !Tipo.asignablePig(declarado, real)) {
                        errores.semantico(ln, "El tipo " + real + " no es compatible con '"
                                + nombre + "' de " + declarado + ".");
                    }
                }
                declarar(nombre, declarado, ln);
                return;
            }
            if (b.expresion() != null && ids.size() == 1) {
                Tipo real = visit(b.expresion());
                if (!real.equals(Tipo.BOOL) && !real.esError()) {
                    errores.semantico(ln, "La declaración inferida de '" + nombre
                            + "' debe ser bool (se dio " + real + ").");
                }
                declarar(nombre, Tipo.BOOL, ln);
                return;
            }
            if (ids.size() >= 2) {
                String tipoStruct = ids.get(1).getText();
                Tipo declarado = Tipo.struct(tipoStruct);
                if (b.bloque_varios() != null) {
                    validarLiteralStruct(tipoStruct, b.bloque_varios(), ln);
                }
                declarar(nombre, declarado, ln);
                return;
            }
            declarar(nombre, Tipo.ERROR, ln);
            return;
        }
        if (b.SERIES() != null) {
            String nombre = ids.get(0).getText();
            String elemRaw = b.tipos_varios() == null ? "numerus" : b.tipos_varios().getText();
            Tipo elem = Tipo.desdePig(elemRaw, tabla, ln, null);
            if (elem.esError() && elem.base != Tipo.Base.STRUCT) {
                elem = Tipo.struct(elemRaw);
            }
            if (b.expresion() != null) {
                Tipo tTam = visit(b.expresion());
                if (!tTam.esError() && tTam.base != Tipo.Base.ENTERO) {
                    errores.semantico(linea(b.expresion()),
                            "El tamaño de la serie debe ser numerus.");
                }
            }
            if (b.bloque_varios() != null) {
                validarLiteralSerie(elem, b.bloque_varios(), b.expresion(), ln, nombre);
            }
            VarSymbol vs = new VarSymbol(nombre, ln, Tipo.series(elem));
            Integer tam = b.expresion() == null ? null : constanteEntera(b.expresion());
            vs.sizeSeries = tam;
            declararVar(vs);
        }
    }

    private void declarar(String nombre, Tipo tipo, int ln) {
        declararVar(new VarSymbol(nombre, ln, tipo));
    }

    private void declararVar(VarSymbol vs) {
        if (tabla.existeLocal(vs.name)) {
            errores.semantico(vs.line, "Símbolo duplicado: '" + vs.name + "' ya fue declarado.");
            return;
        }
        tabla.definirVar(vs);
    }

    private Integer constanteEntera(PigLatinParserParser.ExpresionContext e) {
        if (e == null) return null;
        try {
            return Integer.parseInt(e.getText().trim());
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private void validarLiteralStruct(String tipoStruct,
                                      PigLatinParserParser.Bloque_variosContext init, int ln) {
        StructSimbolo s = tabla.obtenerStruct(tipoStruct);
        if (s == null) {
            ClaseZ cz = clasesZ.get(tipoStruct);
            if (cz == null) {
                errores.semantico(ln, "Tipo no declarado: '" + tipoStruct + "'.");
            }
            if (init != null) for (PigLatinParserParser.ExpresionContext e : init.expresion()) visit(e);
            return;
        }
        List<Tipo> reales = tiposBloqueVarios(init);
        List<String> campos = new ArrayList<>(s.campos.keySet());
        if (reales.size() != campos.size()) {
            errores.semantico(ln, "La estructura '" + tipoStruct + "' espera " + campos.size()
                    + " valor(es) pero se dieron " + reales.size() + ".");
            return;
        }
        for (int i = 0; i < campos.size(); i++) {
            Tipo esp = s.campos.get(campos.get(i));
            Tipo real = reales.get(i);
            if (!esp.esError() && !real.esError() && !Tipo.asignablePig(esp, real)) {
                errores.semantico(ln, "El atributo '" + campos.get(i) + "' espera " + esp
                        + " pero se dio " + real + ".");
            }
        }
    }

    private List<Tipo> tiposBloqueVarios(PigLatinParserParser.Bloque_variosContext b) {
        List<Tipo> out = new ArrayList<>();
        if (b == null) return out;

        for (PigLatinParserParser.ExpresionContext e : b.expresion()) out.add(visit(e));
        for (PigLatinParserParser.Bloque_variosContext sub : b.bloque_varios()) {
            tiposBloqueVarios(sub);
            out.add(Tipo.series(Tipo.ENTERO));
        }
        return out;
    }

    private void validarLiteralSerie(Tipo elem, PigLatinParserParser.Bloque_variosContext init,
                                     PigLatinParserParser.ExpresionContext tamCtx,
                                     int ln, String nombre) {
        Integer tam = constanteEntera(tamCtx);
        int n = init.expresion().size() + init.bloque_varios().size();
        if (tam != null && n != tam) {
            errores.semantico(ln, "La serie '" + nombre + "' declara tamaño " + tam
                    + " pero trae " + n + " valor(es).");
        }
        for (PigLatinParserParser.ExpresionContext v : init.expresion()) {
            Tipo real = visit(v);
            if (!elem.esError() && !real.esError() && !Tipo.asignablePig(elem, real)) {
                errores.semantico(linea(v), "Valor " + real + " incompatible con la serie '"
                        + nombre + "' de " + elem + ".");
            }
        }
    }

    private List<Tipo> tiposBloqueObjt(PigLatinParserParser.Bloque_objtContext b) {
        List<Tipo> out = new ArrayList<>();
        if (b == null) return out;
        for (PigLatinParserParser.ExpresionContext e : b.expresion()) out.add(visit(e));

        for (int i = 0; i < b.getChildCount(); i++) {
            ParseTree ch = b.getChild(i);
            if (ch instanceof TerminalNode tn && tn.getText().equals("novus")) {
                String clase = null;
                PigLatinParserParser.Bloque_objtContext sub = null;
                for (int k = i + 1; k < b.getChildCount(); k++) {
                    ParseTree c2 = b.getChild(k);
                    if (c2 instanceof TerminalNode t2) {
                        if (t2.getText().equals("novus") || t2.getText().equals(",")
                                || t2.getText().equals(")")) break;
                        if (clase == null) clase = t2.getText();
                    } else if (c2 instanceof PigLatinParserParser.Bloque_objtContext sb) {
                        sub = sb;
                        break;
                    } else {
                        break;
                    }
                }
                if (clase != null) {
                    List<Tipo> args = tiposBloqueObjt(sub);
                    validarConstructor(clase, args, linea(b));
                    out.add(Tipo.struct(clase));
                }
            }
        }
        return out;
    }

    private void validarConstructor(String clase, List<Tipo> args, int ln) {
        ClaseZ cz = clasesZ.get(clase);
        if (cz == null) {
            errores.semantico(ln, "Clase no definida: '" + clase + "' no existe en ningún import .z.");
            return;
        }
        if (cz.constructores.isEmpty() && args.isEmpty()) return;
        for (ClaseZ.MetodoZ c : cz.constructores) {
            if (c.params.size() == args.size() && paramsCompatiblesZ(c, args)) return;
        }
        errores.semantico(ln, "Constructor no coincide: 'novus " + clase
                + "' con " + args.size() + " argumento(s).");
    }

    private boolean paramsCompatiblesZ(ClaseZ.MetodoZ m, List<Tipo> args) {
        for (int i = 0; i < args.size(); i++) {
            Tipo esp = desdeCanon(m.params.get(i).tipo);
            Tipo real = args.get(i);
            if (!esp.esError() && !real.esError() && !Tipo.asignablePig(esp, real)) return false;
        }
        return true;
    }

    private Tipo desdeCanon(String canon) {
        if (canon != null && canon.startsWith("series<") && canon.endsWith(">")) {
            return Tipo.series(desdeCanon(canon.substring(7, canon.length() - 1)));
        }
        return switch (canon) {
            case "numerus" -> Tipo.ENTERO;
            case "decimalis" -> Tipo.FLOTANTE;
            case "textum" -> Tipo.CADENA;
            case "littera" -> Tipo.CARACTER;
            case "bool" -> Tipo.BOOL;
            case "void" -> Tipo.VOID;
            default -> Tipo.struct(canon);
        };
    }

    @Override
    public Tipo visitInstruccion(PigLatinParserParser.InstruccionContext ctx) {
        if (ctx.bloque_impr() != null) {
            PigLatinParserParser.Impresion_ConsolaContext imp =
                    (PigLatinParserParser.Impresion_ConsolaContext) ctx.bloque_impr();
            for (PigLatinParserParser.ExpresionContext e : imp.expresion()) {
                Tipo t = visit(e);
                if (t.base == Tipo.Base.SERIES || t.base == Tipo.Base.STRUCT) {
                    if (t.base == Tipo.Base.STRUCT && clasesZ.containsKey(t.nombreStruct)) continue;
                    errores.semantico(linea(e), "No se puede imprimir una serie o estructura directamente.");
                }
            }
            return Tipo.VOID;
        }
        if (ctx.bloque_leer() != null) {
            PigLatinParserParser.Lectura_TextoContext lec =
                    (PigLatinParserParser.Lectura_TextoContext) ctx.bloque_leer();
            if (lec.ID() != null) {
                VarSymbol vs = tabla.obtenerVar(lec.ID().getText());
                if (vs == null) {
                    errores.semantico(linea(ctx), "La variable no ha sido declarada: '" + lec.ID().getText() + "'.");
                } else if (!vs.type.esPrimitivo()) {
                    errores.semantico(linea(ctx), "Solo se puede leer en variables primitivas.");
                }
            }
            return Tipo.VOID;
        }
        if (ctx.bloque_asignacion() != null) return visitarAsignacion(ctx.bloque_asignacion());
        if (ctx.SI() != null) {
            exigirBool(visit(ctx.expresion(0)), linea(ctx), "'si'");
            tabla.entrar("si");
            for (PigLatinParserParser.InstruccionContext h : ctx.instruccion()) visitInstruccion(h);
            tabla.salir();
            PigLatinParserParser.Bloque_siContext bs = ctx.bloque_si();
            if (bs != null) {
                for (PigLatinParserParser.ExpresionContext c : bs.expresion()) {
                    exigirBool(visit(c), linea(ctx), "'aliter'");
                }
                List<List<PigLatinParserParser.InstruccionContext>> grupos = new ArrayList<>();
                List<PigLatinParserParser.InstruccionContext> actual = null;
                int depth = 0;
                if (bs.children != null) {
                    for (ParseTree ch : bs.children) {
                        if (ch instanceof TerminalNode tn) {
                            if (tn.getText().equals("aliter")) {
                                actual = new ArrayList<>();
                                grupos.add(actual);
                            } else if (tn.getText().equals("{")) depth++;
                            else if (tn.getText().equals("}")) depth--;
                        } else if (ch instanceof PigLatinParserParser.InstruccionContext ic) {
                            if (actual != null && depth > 0) actual.add(ic);
                        }
                    }
                }
                for (List<PigLatinParserParser.InstruccionContext> g : grupos) {
                    tabla.entrar("aliter");
                    for (PigLatinParserParser.InstruccionContext h : g) visitInstruccion(h);
                    tabla.salir();
                }
            }
            return Tipo.VOID;
        }
        if (ctx.DUM() != null && ctx.FACERE() == null) {
            exigirBool(visit(ctx.expresion(0)), linea(ctx), "'dum'");
            profundidadCiclo++;
            tabla.entrar("dum");
            for (PigLatinParserParser.InstruccionContext h : ctx.instruccion()) visitInstruccion(h);
            tabla.salir();
            profundidadCiclo--;
            return Tipo.VOID;
        }
        if (ctx.FACERE() != null) {
            profundidadCiclo++;
            tabla.entrar("facere");
            for (PigLatinParserParser.InstruccionContext h : ctx.instruccion()) visitInstruccion(h);
            tabla.salir();
            profundidadCiclo--;
            exigirBool(visit(ctx.expresion(0)), linea(ctx), "'facere ... dum'");
            return Tipo.VOID;
        }
        if (ctx.PER() != null) {
            tabla.entrar("per");
            Tipo tIter = Tipo.desdePig(ctx.tipos().getText(), tabla, linea(ctx), errores);
            Tipo tInit = visit(ctx.expresion(0));
            String var = ctx.ID().getText();
            if (!tIter.esError() && !tInit.esError() && !Tipo.asignablePig(tIter, tInit)) {
                errores.semantico(linea(ctx), "El iterador '" + var + "' (" + tIter
                        + ") no acepta " + tInit + ".");
            }
            if (tabla.existeLocal(var)) {
                errores.semantico(linea(ctx), "Símbolo duplicado: '" + var + "' ya fue declarado.");
            } else {
                tabla.definirVar(new VarSymbol(var, linea(ctx), tIter));
            }
            exigirBool(visit(ctx.expresion(1)), linea(ctx), "'per'");
            visitarAutoCambio(ctx.auto_cambio());
            profundidadCiclo++;
            tabla.entrar("per_cuerpo");
            for (PigLatinParserParser.InstruccionContext h : ctx.instruccion()) visitInstruccion(h);
            tabla.salir();
            profundidadCiclo--;
            tabla.salir();
            return Tipo.VOID;
        }
        if (ctx.PERGE() != null) {
            if (profundidadCiclo == 0) errores.semantico(linea(ctx), "'perge' usado fuera de un ciclo.");
            return Tipo.VOID;
        }
        if (ctx.INTERRUMPE() != null) {
            if (profundidadCiclo == 0) errores.semantico(linea(ctx), "'interrumpe' usado fuera de un ciclo.");
            return Tipo.VOID;
        }
        if (!ctx.expresion().isEmpty()) {
            visit(ctx.expresion(0));
            return Tipo.VOID;
        }
        return Tipo.VOID;
    }

    private Tipo visitarAsignacion(PigLatinParserParser.Bloque_asignacionContext a) {
        int ln = linea(a);
        if (a.auto_cambio() != null && a.ID().isEmpty()) return visitarAutoCambio(a.auto_cambio());
        List<TerminalNode> ids = a.ID();
        List<PigLatinParserParser.ExpresionContext> exprs = a.expresion();
        if (a.auto_cambio() != null) return visitarAutoCambio(a.auto_cambio());
        if (a.ASIGNACION() == null) return Tipo.ERROR;
        if (a.LCORCH() != null && a.PUNTO() != null) {
            VarSymbol vs = tabla.obtenerVar(ids.get(0).getText());
            if (vs == null) {
                errores.semantico(ln, "La variable no ha sido declarada: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            if (vs.type.base != Tipo.Base.SERIES || vs.type.elementos.base != Tipo.Base.STRUCT) {
                errores.semantico(ln, "No es una serie de estructuras: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            exigirIndice(exprs.get(0));
            Tipo real = visit(exprs.get(exprs.size() - 1));
            Tipo esperado = tipoCampoEstructura(vs.type.elementos.nombreStruct,
                    ids.get(ids.size() - 1).getText(), ln);
            if (esperado != null && !esperado.esError() && !real.esError()
                    && !Tipo.asignablePig(esperado, real)) {
                errores.semantico(ln, "No se puede asignar " + real + " al atributo '"
                        + ids.get(ids.size() - 1).getText() + "' de " + esperado + ".");
            }
            return esperado == null ? Tipo.ERROR : esperado;
        }
        if (a.LCORCH() != null) {
            VarSymbol vs = tabla.obtenerVar(ids.get(0).getText());
            if (vs == null) {
                errores.semantico(ln, "La variable no ha sido declarada: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            if (vs.type.base != Tipo.Base.SERIES) {
                errores.semantico(ln, "No es de tipo serie: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            exigirIndice(exprs.get(0));
            Integer idx = constanteEntera(exprs.get(0));
            if (idx != null && vs.sizeSeries != null && (idx < 0 || idx >= vs.sizeSeries)) {
                errores.semantico(ln, "Índice fuera de rango: " + idx + ".");
            }
            Tipo real = visit(exprs.get(exprs.size() - 1));
            if (!vs.type.elementos.esError() && !real.esError()
                    && !Tipo.asignablePig(vs.type.elementos, real)) {
                errores.semantico(ln, "No se puede asignar " + real + " a la serie '"
                        + ids.get(0).getText() + "' de " + vs.type.elementos + ".");
            }
            return vs.type.elementos;
        }
        if (a.PUNTO() != null) {
            VarSymbol vs = tabla.obtenerVar(ids.get(0).getText());
            Tipo real = visit(exprs.get(0));
            if (vs == null) {
                errores.semantico(ln, "La variable no ha sido declarada: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            if (vs.type.base != Tipo.Base.STRUCT) {
                errores.semantico(ln, "No es una estructura/objeto: '" + ids.get(0).getText() + "'.");
                return Tipo.ERROR;
            }
            Tipo esperado = tipoCampoEstructura(vs.type.nombreStruct, ids.get(1).getText(), ln);
            if (esperado != null && !esperado.esError() && !real.esError()
                    && !Tipo.asignablePig(esperado, real)) {
                errores.semantico(ln, "No se puede asignar " + real + " al atributo '"
                        + ids.get(1).getText() + "' de " + esperado + ".");
            }
            return esperado == null ? Tipo.ERROR : esperado;
        }
        VarSymbol vs = tabla.obtenerVar(ids.get(0).getText());
        Tipo real = visit(exprs.get(0));
        if (vs == null) {
            errores.semantico(ln, "La variable no ha sido declarada: '" + ids.get(0).getText() + "'.");
            return Tipo.ERROR;
        }
        if (!vs.type.esError() && !real.esError() && !Tipo.asignablePig(vs.type, real)) {
            errores.semantico(ln, "Valores no compatibles: " + real + " <-> " + vs.type + ".");
        }
        return vs.type;
    }

    private Tipo tipoCampoEstructura(String tipoStruct, String campo, int ln) {
        StructSimbolo s = tabla.obtenerStruct(tipoStruct);
        if (s != null && s.tieneCampo(campo)) return s.tipoCampo(campo);
        ClaseZ cz = clasesZ.get(tipoStruct);
        if (cz != null && cz.campos.containsKey(campo)) return desdeCanon(cz.campos.get(campo));
        if (s == null && cz == null) {
            errores.semantico(ln, "Tipo no declarado: '" + tipoStruct + "'.");
            return null;
        }
        errores.semantico(ln, "El tipo '" + tipoStruct + "' no tiene el atributo '" + campo + "'.");
        return null;
    }

    private void exigirIndice(PigLatinParserParser.ExpresionContext idx) {
        Tipo t = visit(idx);
        if (!t.esError() && t.base != Tipo.Base.ENTERO) {
            errores.semantico(linea(idx), "El índice de la serie debe ser numerus.");
        }
    }

    private Tipo visitarAutoCambio(PigLatinParserParser.Auto_cambioContext a) {
        VarSymbol vs = tabla.obtenerVar(a.ID().getText());
        if (vs == null) {
            errores.semantico(linea(a), "La variable no ha sido declarada: '" + a.ID().getText() + "'.");
            return Tipo.ERROR;
        }
        if (!vs.type.esNumero() && !vs.type.esError()) {
            errores.semantico(linea(a), "El operador '++/--' solo aplica a numerus/decimalis.");
        }
        return vs.type;
    }

    private void exigirBool(Tipo t, int ln, String ctx) {
        if (!t.equals(Tipo.BOOL) && !t.esError()) {
            errores.semantico(ln, "La condición de " + ctx + " debe ser bool.");
        }
    }

    // ---------------- expresiones ----------------

    @Override
    public Tipo visitUmenos(PigLatinParserParser.UmenosContext ctx) {
        Tipo t = visit(ctx.expresion());
        if (!t.esNumero() && !t.esError()) {
            errores.semantico(linea(ctx), "El operador '-' solo aplica a numerus/decimalis.");
            return Tipo.ERROR;
        }
        return t;
    }

    @Override
    public Tipo visitNegacion(PigLatinParserParser.NegacionContext ctx) {
        Tipo t = visit(ctx.expresion());
        if (!t.equals(Tipo.BOOL) && !t.esError()) {
            errores.semantico(linea(ctx), "El operador 'non' solo aplica a bool.");
        }
        return Tipo.BOOL;
    }

    @Override
    public Tipo visitParentesis(PigLatinParserParser.ParentesisContext ctx) {
        return visit(ctx.expresion());
    }

    @Override
    public Tipo visitMultDiv(PigLatinParserParser.MultDivContext ctx) {
        Tipo l = visit(ctx.expresion(0));
        Tipo r = visit(ctx.expresion(1));
        String op = ctx.ops1.getText();
        if (l.esError() || r.esError()) return Tipo.ERROR;
        if (l.base == Tipo.Base.CADENA || r.base == Tipo.Base.CADENA) {
            errores.semantico(linea(ctx), "El operador '" + op + "' no es compatible con textum.");
            return Tipo.ERROR;
        }
        if (!l.esPrimitivo() || !r.esPrimitivo()) {
            errores.semantico(linea(ctx), "El operador '" + op + "' solo aplica a tipos primitivos.");
            return Tipo.ERROR;
        }
        if (!l.esNumero() || !r.esNumero()) {
            errores.semantico(linea(ctx), "El operador '" + op + "' solo opera entre numerus y decimalis.");
            return Tipo.ERROR;
        }
        return Tipo.resultado(l, r);
    }

    @Override
    public Tipo visitSumaResta(PigLatinParserParser.SumaRestaContext ctx) {
        Tipo l = visit(ctx.expresion(0));
        Tipo r = visit(ctx.expresion(1));
        String op = ctx.ops1.getText();
        if (l.esError() || r.esError()) return Tipo.ERROR;
        if (op.equals("+") && (l.base == Tipo.Base.CADENA || r.base == Tipo.Base.CADENA)) {
            if (!l.esPrimitivo() || !r.esPrimitivo()) {
                errores.semantico(linea(ctx), "No se puede concatenar una serie o estructura con textum.");
                return Tipo.ERROR;
            }
            return Tipo.CADENA;
        }
        if (!l.esPrimitivo() || !r.esPrimitivo()) {
            errores.semantico(linea(ctx), "El operador '" + op + "' solo aplica a tipos primitivos.");
            return Tipo.ERROR;
        }
        if (!l.esNumero() || !r.esNumero()) {
            errores.semantico(linea(ctx), "El operador '" + op + "' solo opera entre numerus y decimalis"
                    + " (use '+' con textum para concatenar).");
            return Tipo.ERROR;
        }
        return Tipo.resultado(l, r);
    }

    @Override
    public Tipo visitIgualNoIgual(PigLatinParserParser.IgualNoIgualContext ctx) {
        Tipo l = visit(ctx.expresion(0));
        Tipo r = visit(ctx.expresion(1));
        String op = ctx.ops1.getText();
        if (l.esError() || r.esError()) return Tipo.BOOL;
        if (!l.esPrimitivo() || !r.esPrimitivo()) {
            errores.semantico(linea(ctx), "El operador '" + op + "' solo aplica a tipos primitivos.");
        } else if ((l.base == Tipo.Base.CADENA) != (r.base == Tipo.Base.CADENA)) {
            errores.semantico(linea(ctx), "Solo se puede comparar textum con textum.");
        } else if (l.base == Tipo.Base.BOOL || r.base == Tipo.Base.BOOL) {
            if (!l.equals(Tipo.BOOL) || !r.equals(Tipo.BOOL)) {
                errores.semantico(linea(ctx), "Solo se puede comparar bool con bool.");
            }
        }
        return Tipo.BOOL;
    }

    @Override
    public Tipo visitMenorMayorIgual(PigLatinParserParser.MenorMayorIgualContext ctx) {
        return relacional(visit(ctx.expresion(0)), ctx.ops1.getText(), visit(ctx.expresion(1)), linea(ctx));
    }

    @Override
    public Tipo visitMenorMayor(PigLatinParserParser.MenorMayorContext ctx) {
        return relacional(visit(ctx.expresion(0)), ctx.ops1.getText(), visit(ctx.expresion(1)), linea(ctx));
    }

    private Tipo relacional(Tipo l, String op, Tipo r, int ln) {
        if (l.esError() || r.esError()) return Tipo.BOOL;
        if (l.base == Tipo.Base.CADENA || r.base == Tipo.Base.CADENA
                || !l.esPrimitivo() || !r.esPrimitivo()) {
            errores.semantico(ln, "El operador '" + op + "' no aplica a textum, serie o estructura.");
        } else if ((!l.esNumero() && l.base != Tipo.Base.CARACTER)
                || (!r.esNumero() && r.base != Tipo.Base.CARACTER)) {
            errores.semantico(ln, "El operador '" + op + "' compara numerus/decimalis o littera.");
        }
        return Tipo.BOOL;
    }

    @Override
    public Tipo visitAndOr(PigLatinParserParser.AndOrContext ctx) {
        Tipo l = visit(ctx.expresion(0));
        Tipo r = visit(ctx.expresion(1));
        String op = ctx.ops1.getText();
        if (!l.equals(Tipo.BOOL) && !l.esError() || !r.equals(Tipo.BOOL) && !r.esError()) {
            errores.semantico(linea(ctx), "El operador '" + op + "' solo opera sobre bool.");
        }
        return Tipo.BOOL;
    }

    @Override
    public Tipo visitAcceso_Cadena(PigLatinParserParser.Acceso_CadenaContext ctx) {
        Tipo base = visit(ctx.expresion());
        if (base.esError()) return Tipo.ERROR;
        if (base.base != Tipo.Base.STRUCT) {
            errores.semantico(linea(ctx), "'" + ctx.expresion().getText()
                    + "' no es una estructura/objeto (es " + base + ").");
            return Tipo.ERROR;
        }
        Tipo t = tipoCampoEstructura(base.nombreStruct, ctx.ID().getText(), linea(ctx));
        return t == null ? Tipo.ERROR : t;
    }

    @Override
    public Tipo visitMetodo_Cadena(PigLatinParserParser.Metodo_CadenaContext ctx) {
        Tipo base = visit(ctx.expresion(0));
        if (base.esError()) return Tipo.ERROR;
        if (base.base != Tipo.Base.STRUCT) {
            errores.semantico(linea(ctx), "'" + ctx.expresion(0).getText()
                    + "' no es un objeto (es " + base + ").");
            return Tipo.ERROR;
        }
        ClaseZ cz = clasesZ.get(base.nombreStruct);
        if (cz == null) {
            errores.semantico(linea(ctx), "'" + base.nombreStruct
                    + "' es estructura: no tiene métodos.");
            return Tipo.ERROR;
        }
        String met = ctx.ID().getText();
        List<Tipo> args = new ArrayList<>();
        for (int i = 1; i < ctx.expresion().size(); i++) args.add(visit(ctx.expresion(i)));
        ClaseZ.MetodoZ mm = cz.metodo(met, args.size());
        if (mm == null) {
            errores.semantico(linea(ctx), "Método no definido: '" + base.nombreStruct + "." + met + "'.");
            return Tipo.ERROR;
        }
        if (mm.params.size() != args.size()) {
            errores.semantico(linea(ctx), "Aridad incorrecta: '" + base.nombreStruct + "." + met
                    + "' espera " + mm.params.size() + " pero se dieron " + args.size() + ".");
            return desdeCanon(mm.retorno);
        }
        if (!paramsCompatiblesZ(mm, args)) {
            errores.semantico(linea(ctx), "Los argumentos de '" + base.nombreStruct + "." + met
                    + "' no son compatibles con sus parámetros.");
        }
        return desdeCanon(mm.retorno);
    }

    @Override
    public Tipo visitAcceso_Indice(PigLatinParserParser.Acceso_IndiceContext ctx) {
        Tipo base = visit(ctx.expresion(0));
        Tipo idx = visit(ctx.expresion(1));
        if (!idx.esError() && idx.base != Tipo.Base.ENTERO) {
            errores.semantico(linea(ctx), "El índice de la serie debe ser numerus.");
        }
        if (base.esError()) return Tipo.ERROR;
        if (base.base != Tipo.Base.SERIES) {
            errores.semantico(linea(ctx), "No es una serie (es " + base + ").");
            return Tipo.ERROR;
        }
        return base.elementos;
    }

    @Override
    public Tipo visitNovus_Exp(PigLatinParserParser.Novus_ExpContext ctx) {
        String clase = ctx.ID().getText();
        List<Tipo> args = new ArrayList<>();
        for (PigLatinParserParser.ExpresionContext e : ctx.expresion()) args.add(visit(e));
        validarConstructor(clase, args, linea(ctx));
        return Tipo.struct(clase);
    }

    @Override
    public Tipo visitVerumValor(PigLatinParserParser.VerumValorContext ctx) {
        return Tipo.BOOL;
    }

    @Override
    public Tipo visitFalsusValor(PigLatinParserParser.FalsusValorContext ctx) {
        return Tipo.BOOL;
    }

    @Override
    public Tipo visitIdentificador(PigLatinParserParser.IdentificadorContext ctx) {
        VarSymbol vs = tabla.obtenerVar(ctx.ID().getText());
        if (vs != null) return vs.type;
        if (funcionesY.containsKey(ctx.ID().getText())) {
            errores.semantico(linea(ctx), "La función '" + ctx.ID().getText()
                    + "' debe invocarse con paréntesis.");
            return desdeCanon(funcionesY.get(ctx.ID().getText()).retorno);
        }
        errores.semantico(linea(ctx), "La variable no ha sido declarada: '" + ctx.ID().getText() + "'.");
        return Tipo.ERROR;
    }

    @Override
    public Tipo visitDoubleVal(PigLatinParserParser.DoubleValContext ctx) {
        return Tipo.FLOTANTE;
    }

    @Override
    public Tipo visitIntVal(PigLatinParserParser.IntValContext ctx) {
        return Tipo.ENTERO;
    }

    @Override
    public Tipo visitCharVal(PigLatinParserParser.CharValContext ctx) {
        return Tipo.CARACTER;
    }

    @Override
    public Tipo visitStringVal(PigLatinParserParser.StringValContext ctx) {
        return Tipo.CADENA;
    }

    @Override
    protected Tipo defaultResult() {
        return Tipo.ERROR;
    }

    @Override
    protected Tipo aggregateResult(Tipo aggregate, Tipo nextResult) {
        return nextResult == null ? aggregate : nextResult;
    }
}
