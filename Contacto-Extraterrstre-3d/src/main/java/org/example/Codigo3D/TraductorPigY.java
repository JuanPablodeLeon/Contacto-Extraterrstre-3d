package org.example.Codigo3D;

import antlr4.com.antlr4.com.PigLatinParserParser;
import antlr4.com.antlr4.com.YLenguajeParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.Ejecutor.ClaseZ;
import org.example.Ejecutor.FuncInfo;
import org.example.Semantico.StructSimbolo;
import org.example.Semantico.Tipo;

import java.util.*;

public class TraductorPigY {

    public static class GlobalDecl {
        public final String nombre;
        public final String tipo;
        public final PigLatinParserParser.ExpresionContext init;
        public final PigLatinParserParser.ExpresionContext serieTam;
        public final String serieElem;
        public final PigLatinParserParser.Bloque_variosContext serieInit;
        public final String novusClase;
        public final PigLatinParserParser.Bloque_objtContext novusArgs;
        public GlobalDecl(String nombre, String tipo,
                          PigLatinParserParser.ExpresionContext init) {
            this(nombre, tipo, init, null, null, null, null, null);
        }
        public GlobalDecl(String nombre, String tipo,
                          PigLatinParserParser.ExpresionContext init,
                          PigLatinParserParser.ExpresionContext serieTam,
                          String serieElem,
                          PigLatinParserParser.Bloque_variosContext serieInit) {
            this(nombre, tipo, init, serieTam, serieElem, serieInit, null, null);
        }
        public GlobalDecl(String nombre, String tipo,
                          PigLatinParserParser.ExpresionContext init,
                          PigLatinParserParser.ExpresionContext serieTam,
                          String serieElem,
                          PigLatinParserParser.Bloque_variosContext serieInit,
                          String novusClase,
                          PigLatinParserParser.Bloque_objtContext novusArgs) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.init = init;
            this.serieTam = serieTam;
            this.serieElem = serieElem;
            this.serieInit = serieInit;
            this.novusClase = novusClase;
            this.novusArgs = novusArgs;
        }
    }

    public static class FuncionY {
        public final FuncInfo firma;
        public final YLenguajeParser.Bloc_funcContext ctx;
        public FuncionY(FuncInfo firma, YLenguajeParser.Bloc_funcContext ctx) {
            this.firma = firma;
            this.ctx = ctx;
        }
    }

    private final List<GlobalDecl> globalesDecl;
    private final List<FuncionY> funcionesY;
    private final PigLatinParserParser.InicioContext pigTree;
    private final Map<String, StructSimbolo> structsY;

    private final List<Cuarteta> cuartetas = new ArrayList<>();
    private final Map<String, String> tipoTemp = new LinkedHashMap<>();
    private final Map<String, String> tipoVar = new LinkedHashMap<>();
    private final List<String[]> globales = new ArrayList<>();
    private final Map<String, String> retFunc = new LinkedHashMap<>();
    private final Map<String, FuncInfo> firmasY = new LinkedHashMap<>();

    private final Deque<Map<String, String>> pilaAmbitos = new ArrayDeque<>();
    private Set<String> usadosEnFuncion = new HashSet<>();
    private int contSombra = 0;
    private int contTemp = 0;
    private int contLabel = 0;
    private int contId = 0;
    private final Deque<String> pilaBreak = new ArrayDeque<>();
    private final Deque<String> pilaContinue = new ArrayDeque<>();
    private static Map<String, ClaseZ> clasesZ = new LinkedHashMap<>();
    private TraductorZ traductorZ;

    public static Map<String, ClaseZ> clases() { return clasesZ; }
    public static void clases(Map<String, ClaseZ> c) {
        clasesZ = c == null ? new LinkedHashMap<>() : c;
    }

    public void traductorZ(TraductorZ tz) { this.traductorZ = tz; }

    public TraductorPigY(PigLatinParserParser.InicioContext pigTree,
                         List<GlobalDecl> globalesDecl,
                         List<FuncionY> funcionesY,
                         Map<String, StructSimbolo> structsY) {
        this.pigTree = pigTree;
        this.globalesDecl = globalesDecl;
        this.funcionesY = funcionesY;
        this.structsY = structsY == null ? new LinkedHashMap<>() : structsY;
    }

    public String tmp(String tipo) { return nuevoTemp(tipo); }
    public String lbl() { return nuevaEtiqueta(); }
    public void emit(String op, String a1, String a2, String res,
                     String segmento, String comentario) {
        emitir(op, a1, a2, res, segmento, comentario);
    }
    public void emit(String op, String a1, String a2, String res) {
        emitir(op, a1, a2, res);
    }
    public void push() { pushAmbito(); }
    public void pop() { popAmbito(); }
    public String resolve(String nombre) { return resolver(nombre); }
    public String declara(String nombre, String tipo) { return declarar(nombre, tipo); }
    public String tipoDe(String lugar) { return tipoLugar(lugar); }
    public Map<String, String> retFunc() { return retFunc; }
    public Map<String, String> tipoTemps() { return tipoTemp; }
    public void pushBreak(String l) { pilaBreak.push(l); }
    public void pushCont(String l) { pilaContinue.push(l); }
    public void popBreak() { if (!pilaBreak.isEmpty()) pilaBreak.pop(); }
    public void popCont() { if (!pilaContinue.isEmpty()) pilaContinue.pop(); }
    public String peekBreak() { return pilaBreak.isEmpty() ? "L_FIN" : pilaBreak.peek(); }
    public String peekCont() { return pilaContinue.isEmpty() ? "L_INI" : pilaContinue.peek(); }

    public void traducir() {
        pushAmbito();
        usadosEnFuncion = new HashSet<>();
        for (FuncionY f : funcionesY) {
            usadosEnFuncion.add(f.firma.nombre);
            retFunc.put(f.firma.nombre, f.firma.retorno);
            firmasY.put(f.firma.nombre, f.firma);
        }
        for (GlobalDecl g : globalesDecl) {
            String e = declarar(g.nombre, g.tipo);
            globales.add(new String[]{g.tipo, e});
            emitir("DECLARE", g.tipo, "-", e, segDe(g.tipo),
                    e.equals(g.nombre) ? "variable global en " + GeneradorC.segmentoDe(g.tipo)
                            : "sombra de " + g.nombre);
            if (g.serieTam != null) {
                String tam = genPig(g.serieTam);
                emitir("ALLOC_SERIES", g.serieElem == null ? "numerus" : g.serieElem,
                        tam, e, "HEAP", "reserva en heap");
                if (g.serieInit != null) {
                    List<PigLatinParserParser.ExpresionContext> vals =
                            g.serieInit.expresion();
                    for (int i = 0; i < vals.size(); i++) {
                        emitir("[]=", e, String.valueOf(i), genPig(vals.get(i)),
                                "HEAP", "");
                    }
                }
            } else if (g.novusClase != null) {
                if (!clasesZ.containsKey(g.novusClase)) {
                    throw new RuntimeException("Clase no definida: '" + g.novusClase + "'.");
                }
                List<String> parNovus = argsNovus(g.novusArgs);
                for (String ap : parNovus) {
                    emitir("PARAM", ap, "-", "-");
                }
                emitir("CALL", g.novusClase + "_new_" + parNovus.size(), String.valueOf(parNovus.size()), e, "HEAP", "");
            } else if (g.init != null) {
                String v = genPig(g.init);
                emitir("=", v, "-", e, GeneradorC.segmentoDe(g.tipo), "");
            } else {
                emitir("=", valorDefectoPlace(g.tipo), "-", e,
                        GeneradorC.segmentoDe(g.tipo), "valor por defecto");
            }
        }
        for (FuncionY f : funcionesY) {
            traducirFuncionY(f);
        }
        if (traductorZ != null) {
            traductorZ.traducirClases();
        }
        emitir("MAIN_BEGIN", "-", "-", "-", "STACK", "inicio del maior");
        pushAmbito();
        Set<String> previa = usadosEnFuncion;
        usadosEnFuncion = new HashSet<>(previa);
        usadosEnFuncion.addAll(tipoVar.keySet());
        PigLatinParserParser.InstruccionesContext ins = pigTree.instrucciones();
        if (ins != null && ins.bloque_main() != null) {
            for (PigLatinParserParser.InstruccionContext s : ins.bloque_main().instruccion()) {
                stmPig(s);
            }
        }
        popAmbito();
        usadosEnFuncion = previa;
        emitir("MAIN_END", "-", "-", "-", "STACK", "fin del maior");
        popAmbito();
    }

    public List<Cuarteta> getCuartetas() { return cuartetas; }
    public Map<String, String> getTempTypes() { return tipoTemp; }
    public Map<String, String> getVarTypes() { return tipoVar; }
    public List<String[]> getGlobales() { return globales; }
    public Map<String, String> getRetFunc() { return retFunc; }

    public String nuevoTemp(String tipo) {
        String t = "t" + (contTemp++);
        tipoTemp.put(t, tipo == null ? "numerus" : tipo);
        return t;
    }

    public String nuevaEtiqueta() { return "L" + (contLabel++); }

    public void emitir(String op, String a1, String a2, String res,
                       String segmento, String comentario) {
        cuartetas.add(new Cuarteta(contId++, op, a1, a2, res, segmento, comentario));
    }

    public void emitir(String op, String a1, String a2, String res) {
        emitir(op, a1, a2, res, "STACK", "");
    }

    public void pushAmbito() { pilaAmbitos.push(new LinkedHashMap<>()); }
    public void popAmbito() { pilaAmbitos.pop(); }

    public String resolver(String nombre) {
        for (Map<String, String> a : pilaAmbitos) {
            if (a.containsKey(nombre)) return a.get(nombre);
        }
        return null;
    }

    public String declarar(String nombre, String tipo) {
        String visible = resolver(nombre);
        String emitido = nombre;
        if (visible != null) {
            do {
                emitido = nombre + "_" + (++contSombra);
            } while (usadosEnFuncion.contains(emitido) || resolver(emitido) != null);
        }
        usadosEnFuncion.add(emitido);
        pilaAmbitos.peek().put(nombre, emitido);
        tipoVar.put(emitido, tipo);
        return emitido;
    }

    public String tipoLugar(String lugar) {
        if (lugar == null) return "numerus";
        if (lugar.equals("NULL")) return "null";
        if (tipoTemp.containsKey(lugar)) return tipoTemp.get(lugar);
        if (tipoVar.containsKey(lugar)) return tipoVar.get(lugar);
        if (lugar.startsWith("\"")) return "textum";
        if (lugar.startsWith("'")) return "littera";
        if (lugar.equals("verum") || lugar.equals("falsus")) return "bool";
        try { Integer.parseInt(lugar); return "numerus"; }
        catch (NumberFormatException ignored) { }
        try { Double.parseDouble(lugar); return "decimalis"; }
        catch (NumberFormatException ignored) { }
        return "numerus";
    }

    public List<String> argsNovus(PigLatinParserParser.Bloque_objtContext b) {
        List<String> out = new ArrayList<>();
        if (b == null) return out;
        for (int i = 0; i < b.getChildCount(); i++) {
            ParseTree ch = b.getChild(i);
            if (ch instanceof PigLatinParserParser.ExpresionContext e) {
                out.add(genPig(e));
            } else if (ch instanceof TerminalNode tn && tn.getText().equals("novus")) {
                // NOVUS ID LPAREN [bloque_objt] RPAREN
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
                    } else if (c2 instanceof PigLatinParserParser.ExpresionContext) {
                        break;
                    }
                }
                if (clase == null || !clasesZ.containsKey(clase)) {
                    throw new RuntimeException("Clase no definida en novus anidado.");
                }
                List<String> par = argsNovus(sub);
                for (String ap : par) emitir("PARAM", ap, "-", "-");
                String t = nuevoTemp(clase);
                emitir("CALL", clase + "_new_" + par.size(), String.valueOf(par.size()), t, "HEAP", "");
                out.add(t);
            }
        }
        return out;
    }

    public static String segDe(String tipo) {
        if (tipo != null && clasesZ.containsKey(tipo.trim())) return "HEAP";
        return GeneradorC.segmentoDe(tipo);
    }

    public static String valorDefectoPlace(String tipo) {
        switch (tipo) {
            case "decimalis": return "0.0";
            case "textum": return "\"\"";
            case "littera": return "'\\0'";
            case "bool": return "falsus";
            default:
                if (tipo.startsWith("series<")) return "NULL";
                if (clasesZ.containsKey(tipo)) return "NULL";
                return "0";
        }
    }

    private void traducirFuncionY(FuncionY f) {
        emitir("FUNC_BEGIN", f.firma.nombre,
                f.firma.retorno == null ? "void" : f.firma.retorno, "-", "STACK", "");
        Set<String> previa = usadosEnFuncion;
        usadosEnFuncion = new HashSet<>(retFunc.keySet());
        usadosEnFuncion.addAll(tipoVar.keySet());
        pushAmbito();
        for (FuncInfo.ParamInfo p : f.firma.params) {
            String pTipo = p.ref ? "&" + p.tipo : p.tipo;
            String e = declarar(p.nombre, pTipo);
            emitir("PARAM_DECL", pTipo, "-", e,
                    GeneradorC.segmentoDe(pTipo),
                    e.equals(p.nombre) ? "parametro en STACK" : "parametro, sombra de " + p.nombre);
        }
        YLenguajeParser.BloqueContext b = f.ctx.bloque();
        if (b != null) {
            for (YLenguajeParser.InstruccionesContext s : b.instrucciones()) {
                stmY(s);
            }
        }
        popAmbito();
        usadosEnFuncion = previa;
        emitir("FUNC_END", f.firma.nombre, "-", "-", "STACK", "");
    }

    private void stmY(YLenguajeParser.InstruccionesContext s) {
        if (s.definiciones() != null) {
            defY(s.definiciones());
            return;
        }
        if (s.asignaciones() != null) {
            asigY(s.asignaciones());
            return;
        }
        if (s.llamada() != null) {
            llamadaY(s.llamada());
            return;
        }
        if (s.LEER() != null) {
            String t = nuevoTemp("decimalis");
            emitir("READ", t, "-", "-");
            return;
        }
        String txt = s.getText();
        if (s.IMPRIMIR() != null) {
            List<YLenguajeParser.ExpresionContext> args = s.expresion();
            if (args.isEmpty()) {
                emitir("PRINTLN", "\"\"", "-", "-",
                        GeneradorC.segmentoDe("textum"), "");
            } else {
                String v = genY(args.get(0));
                emitir("PRINTLN", v, "-", "-", GeneradorC.segmentoDe(tipoLugar(v)), "");
            }
            return;
        }
        if (s.RETORNAR() != null) {
            List<YLenguajeParser.ExpresionContext> args = s.expresion();
            if (args.isEmpty()) emitir("RETURN", "-", "-", "-");
            else emitir("RETURN", genY(args.get(0)), "-", "-");
            return;
        }
        if (s.ROMPER() != null) {
            emitir("GOTO", pilaBreak.isEmpty() ? "L_FIN" : pilaBreak.peek(),
                    "-", "-", "STACK", "romper -> break");
            return;
        }
        if (s.CONTINUAR() != null) {
            emitir("GOTO", pilaContinue.isEmpty() ? "L_INI" : pilaContinue.peek(),
                    "-", "-", "STACK", "continuar -> continue");
            return;
        }
        if (s.SI() != null) {
            String fin = nuevaEtiqueta();
            String sino = nuevaEtiqueta();
            String c = genY(s.expresion(0));
            emitir("IF_FALSE", c, "-", sino);
            cuerpoY(s.bloque());
            emitir("GOTO", fin, "-", "-");
            emitir("LABEL", sino, "-", "-");
            YLenguajeParser.Bloc_siContext bs = s.bloc_si();
            if (bs != null) stmBlocSiY(bs, fin);
            emitir("LABEL", fin, "-", "-");
            return;
        }
        if (s.ELEGITR() != null) {
            elegirY(s);
            return;
        }
        if (s.MIENTRAS() != null && s.HACER() != null && s.DOS_PUNTOS() == null) {
            String ini = nuevaEtiqueta();
            String fin = nuevaEtiqueta();
            emitir("LABEL", ini, "-", "-");
            String c = genY(s.expresion(0));
            emitir("IF_FALSE", c, "-", fin);
            pilaBreak.push(fin);
            pilaContinue.push(ini);
            cuerpoY(s.bloque());
            pilaBreak.pop();
            pilaContinue.pop();
            emitir("GOTO", ini, "-", "-");
            emitir("LABEL", fin, "-", "-");
            return;
        }
        if (s.HACER() != null && s.DOS_PUNTOS() != null) {
            String ini = nuevaEtiqueta();
            String fin = nuevaEtiqueta();
            emitir("LABEL", ini, "-", "-");
            pilaBreak.push(fin);
            pilaContinue.push(ini);
            cuerpoY(s.bloque());
            pilaBreak.pop();
            pilaContinue.pop();
            String c = genY(s.expresion(0));
            emitir("IF_TRUE", c, "-", ini);
            emitir("LABEL", fin, "-", "-");
            return;
        }
        if (s.PARA() != null) {
            pushAmbito();
            String varName = s.ID(0).getText();
            String tipoC = FuncInfo.canonY(s.tipos().getText());
            String eit = declarar(varName, tipoC);
            emitir("DECLARE", tipoC, "-", eit, "STACK", "iterador para en STACK");
            emitir("=", genY(s.expresion(0)), "-", eit);
            String ini = nuevaEtiqueta();
            String fin = nuevaEtiqueta();
            emitir("LABEL", ini, "-", "-");
            String c = genY(s.expresion(1));
            emitir("IF_FALSE", c, "-", fin);
            pilaBreak.push(fin);
            pilaContinue.push(ini);
            cuerpoY(s.bloque());
            String incTarget = resolver(varName);
            if (incTarget == null) incTarget = varName;
            String op = s.getText().contains("--") ? "-" : "+";
            emitir(op, incTarget, "1", incTarget);
            pilaBreak.pop();
            pilaContinue.pop();
            emitir("GOTO", ini, "-", "-");
            emitir("LABEL", fin, "-", "-");
            popAmbito();
            return;
        }
        throw new RuntimeException("Construcción Y? no soportada en C3D: " + s.getText());
    }

    private void elegirY(YLenguajeParser.InstruccionesContext s) {
        YLenguajeParser.Bloque_elegirContext be = s.bloque_elegir();
        if (be == null) return;

        String fin = nuevaEtiqueta();
        String defecto = nuevaEtiqueta();
        String selector = genY(s.expresion(0));
        List<YLenguajeParser.ExpresionContext> casos = be.expresion();
        List<String> etiquetas = new ArrayList<>();

        for (YLenguajeParser.ExpresionContext caso : casos) {
            String etiqueta = nuevaEtiqueta();
            etiquetas.add(etiqueta);
            String condicion = binaria(selector, "==", genY(caso));
            emitir("IF_TRUE", condicion, "-", etiqueta);
        }
        emitir("GOTO", defecto, "-", "-");

        List<YLenguajeParser.BloqueContext> bloques = be.bloque();
        for (int i = 0; i < etiquetas.size() && i < bloques.size(); i++) {
            emitir("LABEL", etiquetas.get(i), "-", "-");
            pilaBreak.push(fin);
            cuerpoY(bloques.get(i));
            pilaBreak.pop();
            emitir("GOTO", fin, "-", "-");
        }

        emitir("LABEL", defecto, "-", "-");
        if (be.SIEMPRE() != null && bloques.size() > casos.size()) {
            pilaBreak.push(fin);
            cuerpoY(bloques.get(casos.size()));
            pilaBreak.pop();
        }
        emitir("LABEL", fin, "-", "-");
    }

    private void paramsY(String fn, List<String> args) {
        FuncInfo fi = firmasY.get(fn);
        for (int i = 0; i < args.size(); i++) {
            String a = args.get(i);
            if (fi != null && i < fi.params.size() && fi.params.get(i).ref
                    && !tipoLugar(a).startsWith("&")) a = "&" + a;
            emitir("PARAM", a, "-", "-");
        }
    }

    private String sepCampo(String base) {
        return tipoLugar(base).startsWith("&") ? "->" : ".";
    }

    private String tipoBase(String lugar) {
        String t = tipoLugar(lugar);
        return t.startsWith("&") ? t.substring(1) : t;
    }

    private String tipoCampoY(String base, String campo) {
        StructSimbolo s = structsY.get(tipoBase(base));
        if (s == null) return "numerus";
        return canonTipoY(s.tipoCampo(campo));
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
            default: return "numerus";
        }
    }

    private void llamadaY(YLenguajeParser.LlamadaContext llamada) {
        List<TerminalNode> ids = llamada.ID();
        if (ids.isEmpty()) return;
        String fn = ids.get(ids.size() - 1).getText();
        List<String> args = new ArrayList<>();
        for (YLenguajeParser.ExpresionContext arg : llamada.expresion()) {
            args.add(genY(arg));
        }
        paramsY(fn, args);
        String retorno = retFunc.getOrDefault(fn, "void");
        if (retorno.equals("void")) {
            emitir("CALL", fn, String.valueOf(args.size()), "-");
        } else {
            String t = nuevoTemp(retorno);
            emitir("CALL", fn, String.valueOf(args.size()), t,
                    GeneradorC.segmentoDe(retorno), "");
        }
    }

    private void stmBlocSiY(YLenguajeParser.Bloc_siContext bs, String fin) {
        List<YLenguajeParser.ExpresionContext> conds = bs.expresion();
        List<YLenguajeParser.BloqueContext> bloques = new ArrayList<>();
        if (bs.children != null) for (ParseTree ch : bs.children) {
            if (ch instanceof YLenguajeParser.BloqueContext b) bloques.add(b);
        }
        for (int i = 0; i < bloques.size(); i++) {
            if (i < conds.size()) {
                String c = genY(conds.get(i));
                String sig = nuevaEtiqueta();
                emitir("IF_FALSE", c, "-", sig);
                cuerpoY(bloques.get(i));
                emitir("GOTO", fin, "-", "-");
                emitir("LABEL", sig, "-", "-");
            } else {
                cuerpoY(bloques.get(i));
            }
        }
    }

    private void cuerpoY(YLenguajeParser.BloqueContext b) {
        pushAmbito();
        if (b != null) {
            for (YLenguajeParser.InstruccionesContext s : b.instrucciones()) stmY(s);
        }
        popAmbito();
    }

    private void defY(YLenguajeParser.DefinicionesContext d) {
        List<TerminalNode> ids = d.ID();
        if (ids.size() < 1) return;
        String tipoRaw = d.tipos() != null ? d.tipos().getText()
                : (ids.size() > 1 ? ids.get(0).getText() : "numerus");
        String nombre = ids.get(ids.size() - 1).getText();
        if (d.tipos() == null && ids.size() > 1) {
            tipoRaw = ids.get(0).getText();
        }
        String tipo = FuncInfo.canonY(tipoRaw);
        List<YLenguajeParser.ExpresionContext> exprs = d.expresion();
        String e = declarar(nombre, tipo);
        emitir("DECLARE", tipo, "-", e, GeneradorC.segmentoDe(tipo),
                e.equals(nombre) ? "variable en " + GeneradorC.segmentoDe(tipo)
                        : "sombra de " + nombre);
        if (!exprs.isEmpty() && d.ASIG() != null) {
            emitir("=", genY(exprs.get(0)), "-", e, GeneradorC.segmentoDe(tipo), "");
        } else if (d.ASIG() != null) {
            emitir("=", valorDefectoPlace(tipo), "-", e, GeneradorC.segmentoDe(tipo), "");
        } else {
            emitir("=", valorDefectoPlace(tipo), "-", e, GeneradorC.segmentoDe(tipo),
                    "sin inicializador");
        }
    }

    private void asigY(YLenguajeParser.AsignacionesContext a) {
        List<TerminalNode> ids = a.ID();
        List<YLenguajeParser.ExpresionContext> exprs = a.expresion();
        int indices = a.LCORCH().size();
        boolean inc = a.INCREMENTO() != null || a.DECREMENTO() != null;
        boolean comp = a.ADD_ASSIGN() != null || a.SUB_ASSIGN() != null
                || a.MUL_ASSIGN() != null || a.DIV_ASSIGN() != null;
        String op = a.DECREMENTO() != null || a.SUB_ASSIGN() != null ? "-"
                : a.MUL_ASSIGN() != null ? "*"
                : a.DIV_ASSIGN() != null ? "/" : "+";
        String rhs = (a.ASIG() != null || comp) && !exprs.isEmpty()
                ? genY(exprs.get(exprs.size() - 1)) : null;

        String base = resolver(ids.get(0).getText());
        if (base == null) base = ids.get(0).getText();

        if (a.PUNTO() != null) {
            String campo = ids.get(1).getText();
            if (indices > 0) {
                String arreglo = indexarY(base + sepCampo(base) + campo, exprs, indices - 1);
                String idx = genY(exprs.get(indices - 1));
                if (a.ASIG() != null) {
                    emitir("[]=", arreglo, idx, rhs, "HEAP", "");
                    return;
                }
                String t = nuevoTemp("numerus");
                emitir("=[]", arreglo, idx, t, "HEAP", "");
                if (inc) {
                    emitir(op, t, "1", t);
                } else {
                    t = binaria(t, op, rhs);
                }
                emitir("[]=", arreglo, idx, t, "HEAP", "");
                return;
            }

            if (a.ASIG() != null) {
                emitir(".=", base, campo, rhs,
                        GeneradorC.segmentoDe(tipoLugar(rhs)), "");
                return;
            }
            String t = nuevoTemp(tipoCampoY(base, campo));
            emitir("=.", base, campo, t, GeneradorC.segmentoDe(tipoCampoY(base, campo)), "");
            if (inc) {
                emitir(op, t, "1", t);
            } else {
                t = binaria(t, op, rhs);
            }
            emitir(".=", base, campo, t, "STACK", "");
            return;
        }

        if (indices > 0) {
            String arreglo = indexarY(base, exprs, indices - 1);
            String idx = genY(exprs.get(indices - 1));
            if (a.ASIG() != null) {
                emitir("[]=", arreglo, idx, rhs, "HEAP", "");
                return;
            }
            String t = nuevoTemp("numerus");
            emitir("=[]", arreglo, idx, t, "HEAP", "");
            if (inc) {
                emitir(op, t, "1", t);
            } else {
                t = binaria(t, op, rhs);
            }
            emitir("[]=", arreglo, idx, t, "HEAP", "");
            return;
        }

        if (a.ASIG() != null) {
            emitir("=", rhs, "-", base, GeneradorC.segmentoDe(tipoLugar(base)), "");
        } else if (inc) {
            emitir(op, base, "1", base);
        } else {
            String t = binaria(base, op, rhs);
            emitir("=", t, "-", base, GeneradorC.segmentoDe(tipoLugar(base)), "");
        }
    }

    private String indexarY(String arreglo, List<YLenguajeParser.ExpresionContext> exprs,
                            int indices) {
        String actual = arreglo;
        for (int i = 0; i < indices; i++) {
            String t = nuevoTemp("series<numerus>");
            emitir("=[]", actual, genY(exprs.get(i)), t, "HEAP", "");
            actual = t;
        }
        return actual;
    }

    private String genYCache(YLenguajeParser.ExpresionContext e) {
        String t = e.getText();
        if (t.startsWith("\"")) return "\"x\"";
        if (t.equals("verdadero") || t.equals("falso")) return "verum";
        try { Integer.parseInt(t); return "0"; } catch (NumberFormatException ignored) { }
        try { Double.parseDouble(t); return "0.0"; } catch (NumberFormatException ignored) { }
        String r = resolver(t);
        return r == null ? t : r;
    }

    private String genY(YLenguajeParser.ExpresionContext e) {
        int n = e.getChildCount();
        if (n == 1) {
            ParseTree ch = e.getChild(0);
            if (ch instanceof TerminalNode tn) {
                String t = tn.getText();
                switch (t) {
                    case "verdadero": return "verum";
                    case "falso": return "falsus";
                    default:
                        if (tn.getSymbol().getType() == YLenguajeParser.ID) {
                            String r = resolver(t);
                            return r == null ? t : r;
                        }
                        return t;
                }
            }
            if (ch instanceof YLenguajeParser.ExpresionContext sub) return genY(sub);
            return ch.getText();
        }
        if (n == 2) {
            String op = e.getChild(0).getText();
            String v = genY((YLenguajeParser.ExpresionContext) e.getChild(1));
            if (op.equals("-")) {
                String t = nuevoTemp(tipoLugar(v));
                emitir("UMINUS", v, "-", t, GeneradorC.segmentoDe(t), "");
                return t;
            }
            if (op.equals("!")) {
                String t = nuevoTemp("bool");
                emitir("NOT", v, "-", t);
                return t;
            }
            return v;
        }
        if (n == 3) {
            String a = e.getChild(0).getText();
            String b = e.getChild(1).getText();
            ParseTree c3 = e.getChild(2);
            if (a.equals("(") && c3.getText().equals(")")) {
                return genY((YLenguajeParser.ExpresionContext) e.getChild(1));
            }
            if (a.equals("leer") && b.equals("(")) {
                String t = nuevoTemp("decimalis");
                emitir("READ", t, "-", "-");
                return t;
            }
            if (e.getChild(0) instanceof YLenguajeParser.ExpresionContext
                    && e.getChild(2) instanceof YLenguajeParser.ExpresionContext) {
                // binaria: expr op expr
                String l = genY((YLenguajeParser.ExpresionContext) e.getChild(0));
                String op = e.getChild(1).getText();
                String r = genY((YLenguajeParser.ExpresionContext) e.getChild(2));
                return binaria(l, op, r);
            }
        }
        String txt = e.getText();
        if (e.PUNTO() != null && !e.LCORCH().isEmpty()) {
            List<TerminalNode> ids = e.ID();
            List<YLenguajeParser.ExpresionContext> idxs = e.expresion();
            if (ids.size() >= 2 && !idxs.isEmpty()) {
                String base = resolver(ids.get(0).getText());
                if (base == null) base = ids.get(0).getText();
                int cantidad = e.LCORCH().size();
                String arreglo = indexarY(base + sepCampo(base) + ids.get(1).getText(), idxs, cantidad - 1);
                String idx = genY(idxs.get(cantidad - 1));
                String t = nuevoTemp("numerus");
                emitir("=[]", arreglo, idx, t, "HEAP", "");
                return t;
            }
        }
        if (txt.contains("(")) {
            int p = txt.indexOf('(');
            String fn = txt.substring(0, p);
            if (fn.contains(".")) fn = fn.substring(fn.lastIndexOf('.') + 1);
            List<String> argPlaces = new ArrayList<>();
            for (ParseTree ch : e.children) {
                if (ch instanceof YLenguajeParser.ExpresionContext sub
                        && !sub.getText().equals(fn)) {
                    argPlaces.add(genY(sub));
                }
            }
            paramsY(fn, argPlaces);
            String ret = retFunc.getOrDefault(fn, "numerus");
            if (ret.equals("void")) {
                emitir("CALL", fn, String.valueOf(argPlaces.size()), "-");
                return "0";
            }
            String t = nuevoTemp(ret);
            emitir("CALL", fn, String.valueOf(argPlaces.size()), t,
                    GeneradorC.segmentoDe(ret), "");
            return t;
        }
        if (txt.contains("[")) {
            List<YLenguajeParser.ExpresionContext> subs = new ArrayList<>();
            for (ParseTree ch : e.children) {
                if (ch instanceof YLenguajeParser.ExpresionContext sub) subs.add(sub);
            }
            if (subs.size() >= 2) {
                String baseTxt = subs.get(0).getText();
                String base = resolver(baseTxt);
                if (base == null) base = baseTxt;
                String idx = genY(subs.get(1));
                String t = nuevoTemp("numerus");
                emitir("=[]", base, idx, t, GeneradorC.segmentoDe("numerus"), "");
                return t;
            }
        }
        if (txt.contains(".")) {
            int p = txt.lastIndexOf('.');
            String baseTxt = txt.substring(0, p);
            String campo = txt.substring(p + 1);
            String base = resolver(baseTxt);
            if (base == null) base = baseTxt;
            String t = nuevoTemp(tipoCampoY(base, campo));
            emitir("=.", base, campo, t, GeneradorC.segmentoDe(tipoCampoY(base, campo)), "");
            return t;
        }
        return txt;
    }

    public String binaria(String l, String op, String r) {
        String tipo;
        if (op.equals("==") || op.equals("!=") || op.equals("<") || op.equals(">")
                || op.equals("<=") || op.equals(">=") || op.equals("&&") || op.equals("||")) {
            tipo = "bool";
        } else if (op.equals("+")
                && (tipoLugar(l).equals("textum") || tipoLugar(r).equals("textum"))) {
            tipo = "textum";
        } else if (tipoLugar(l).equals("decimalis") || tipoLugar(r).equals("decimalis")) {
            tipo = "decimalis";
        } else {
            tipo = "numerus";
        }
        String t = nuevoTemp(tipo);
        emitir(op, l, r, t, GeneradorC.segmentoDe(tipo),
                tipo.equals("textum") ? "concat en HEAP" : "");
        return t;
    }

    private void stmPig(PigLatinParserParser.InstruccionContext s) {
        if (s.bloque_impr() != null) {
            PigLatinParserParser.Impresion_ConsolaContext imp =
                    (PigLatinParserParser.Impresion_ConsolaContext) s.bloque_impr();
            List<PigLatinParserParser.ExpresionContext> args = imp.expresion();
            for (int i = 0; i < args.size(); i++) {
                String v = genPig(args.get(i));
                boolean ultimo = (i == args.size() - 1);
                emitir(ultimo ? "PRINTLN" : "PRINT", v, "-", "-",
                        GeneradorC.segmentoDe(tipoLugar(v)), "");
            }
            return;
        }
        if (s.bloque_leer() != null) {
            PigLatinParserParser.Lectura_TextoContext lec =
                    (PigLatinParserParser.Lectura_TextoContext) s.bloque_leer();
            String nombre = lec.ID() == null ? "_" : lec.ID().getText();
            String e = "_";
            if (!nombre.equals("_")) {
                e = resolver(nombre);
                if (e == null) e = nombre;
            }
            emitir("READ", e, "-", "-");
            return;
        }
        if (s.bloque_asignacion() != null) {
            asigPig(s.bloque_asignacion());
            return;
        }
        if (s.SI() != null) {
            String fin = nuevaEtiqueta();
            List<List<PigLatinParserParser.InstruccionContext>> ramas = new ArrayList<>();
            List<PigLatinParserParser.ExpresionContext> conds = new ArrayList<>();
            conds.add(s.expresion(0));
            ramas.add(s.instruccion());
            segmentarAliter(s.bloque_si(), ramas, conds);
            List<String> etiq = new ArrayList<>();
            for (int i = 0; i < ramas.size(); i++) etiq.add(nuevaEtiqueta());
            String cond = genPig(conds.get(0));
            emitir("IF_FALSE", cond, "-", ramas.size() > 1 ? etiq.get(0) : fin);
            cuerpoPig(ramas.get(0));
            emitir("GOTO", fin, "-", "-");
            for (int i = 1; i < ramas.size(); i++) {
                emitir("LABEL", etiq.get(i - 1), "-", "-");
                if (i - 1 < conds.size() - 1 || (conds.size() == ramas.size())) {
                    String c = genPig(conds.get(i));
                    String siguiente = (i + 1 < ramas.size()) ? etiq.get(i) : fin;
                    emitir("IF_FALSE", c, "-", siguiente);
                }
                cuerpoPig(ramas.get(i));
                if (i + 1 < ramas.size() || conds.size() == ramas.size()) {
                    emitir("GOTO", fin, "-", "-");
                }
            }
            emitir("LABEL", fin, "-", "-");
            return;
        }
        if (s.DUM() != null && s.FACERE() == null) {
            String ini = nuevaEtiqueta();
            String fin = nuevaEtiqueta();
            emitir("LABEL", ini, "-", "-");
            emitir("IF_FALSE", genPig(s.expresion(0)), "-", fin);
            pilaBreak.push(fin);
            pilaContinue.push(ini);
            cuerpoPig(s.instruccion());
            pilaBreak.pop();
            pilaContinue.pop();
            emitir("GOTO", ini, "-", "-");
            emitir("LABEL", fin, "-", "-");
            return;
        }
        if (s.FACERE() != null) {
            String ini = nuevaEtiqueta();
            String fin = nuevaEtiqueta();
            emitir("LABEL", ini, "-", "-");
            pilaBreak.push(fin);
            pilaContinue.push(ini);
            cuerpoPig(s.instruccion());
            pilaBreak.pop();
            pilaContinue.pop();
            emitir("IF_TRUE", genPig(s.expresion(0)), "-", ini);
            emitir("LABEL", fin, "-", "-");
            return;
        }
        if (s.PER() != null) {
            pushAmbito();
            String varName = s.ID().getText();
            String tipoC = s.tipos().getText();
            String eit = declarar(varName, tipoC);
            emitir("DECLARE", tipoC, "-", eit, "STACK", "iterador per en STACK");
            emitir("=", genPig(s.expresion(0)), "-", eit);
            String ini = nuevaEtiqueta();
            String fin = nuevaEtiqueta();
            emitir("LABEL", ini, "-", "-");
            emitir("IF_FALSE", genPig(s.expresion(1)), "-", fin);
            pilaBreak.push(fin);
            pilaContinue.push(ini);
            cuerpoPig(s.instruccion());
            autoCambio(s.auto_cambio());
            pilaBreak.pop();
            pilaContinue.pop();
            emitir("GOTO", ini, "-", "-");
            emitir("LABEL", fin, "-", "-");
            popAmbito();
            return;
        }
        if (s.PERGE() != null) {
            emitir("GOTO", pilaContinue.isEmpty() ? "L_INI" : pilaContinue.peek(),
                    "-", "-", "STACK", "perge -> continue");
            return;
        }
        if (s.INTERRUMPE() != null) {
            emitir("GOTO", pilaBreak.isEmpty() ? "L_FIN" : pilaBreak.peek(),
                    "-", "-", "STACK", "interrumpe -> break");
            return;
        }
        if (!s.expresion().isEmpty()) {
            genPig(s.expresion(0));
        }
    }

    private void segmentarAliter(PigLatinParserParser.Bloque_siContext bs,
                                 List<List<PigLatinParserParser.InstruccionContext>> ramas,
                                 List<PigLatinParserParser.ExpresionContext> conds) {
        if (bs == null) return;
        conds.addAll(bs.expresion());
        List<PigLatinParserParser.InstruccionContext> todas = bs.instruccion();
        int nRamas = bs.ALITER().size();
        if (nRamas == 0) return;

        List<List<PigLatinParserParser.InstruccionContext>> grupos = new ArrayList<>();
        List<PigLatinParserParser.InstruccionContext> actual = null;
        int depth = 0;
        if (bs.children != null) for (ParseTree ch : bs.children) {
            if (ch instanceof TerminalNode tn) {
                String t = tn.getText();
                if (t.equals("aliter")) {
                    actual = new ArrayList<>();
                    grupos.add(actual);
                } else if (t.equals("{")) {
                    depth++;
                } else if (t.equals("}")) {
                    depth--;
                }
            } else if (ch instanceof PigLatinParserParser.InstruccionContext ic) {
                if (actual != null && depth > 0) actual.add(ic);
            }
        }
        if (grupos.size() != nRamas) {
            grupos.clear();
            for (int i = 0; i < nRamas; i++) grupos.add(new ArrayList<>());
            if (!todas.isEmpty()) {
                grupos.get(0).addAll(todas);
            }
        }
        ramas.addAll(grupos);
    }

    private void cuerpoPig(List<PigLatinParserParser.InstruccionContext> stms) {
        pushAmbito();
        for (PigLatinParserParser.InstruccionContext s : stms) stmPig(s);
        popAmbito();
    }

    private void asigPig(PigLatinParserParser.Bloque_asignacionContext a) {
        if (a.auto_cambio() != null && a.ID().isEmpty()) {
            autoCambio(a.auto_cambio());
            return;
        }
        List<TerminalNode> ids = a.ID();
        List<PigLatinParserParser.ExpresionContext> exprs = a.expresion();
        if (a.auto_cambio() != null) {
            autoCambio(a.auto_cambio());
            return;
        }
        String txt = a.getText();
        if (a.ASIGNACION() == null) return;
        if (a.LCORCH() != null && a.PUNTO() != null) {
            String base = resolver(ids.get(0).getText());
            if (base == null) base = ids.get(0).getText();
            emitir("S.=", base + "[" + genPig(exprs.get(0)) + "]",
                    ids.get(ids.size() - 1).getText(),
                    genPig(exprs.get(exprs.size() - 1)), "HEAP", "serie de structura");
            return;
        }
        if (a.LCORCH() != null) {
            String base = resolver(ids.get(0).getText());
            if (base == null) base = ids.get(0).getText();
            emitir("[]=", base, genPig(exprs.get(0)),
                    genPig(exprs.get(exprs.size() - 1)), "HEAP", "");
            return;
        }
        if (a.PUNTO() != null) {
            String base = resolver(ids.get(0).getText());
            if (base == null) base = ids.get(0).getText();
            String v = genPig(exprs.get(0));
            emitir(".=", base, ids.get(1).getText(), v,
                    GeneradorC.segmentoDe(tipoLugar(v)), "");
            return;
        }
        String e = resolver(ids.get(0).getText());
        if (e == null) e = ids.get(0).getText();
        String v = genPig(exprs.get(0));
        emitir("=", v, "-", e, GeneradorC.segmentoDe(tipoLugar(e)), "");
        if (txt.contains("++") || txt.contains("--")) { }
    }

    private void autoCambio(PigLatinParserParser.Auto_cambioContext a) {
        String nombre = a.ID().getText();
        String e = resolver(nombre);
        if (e == null) e = nombre;
        emitir(a.getText().contains("--") ? "-" : "+", e, "1", e,
                "STACK", a.getText().contains("--") ? "--" : "++");
    }

    private String tipoElemento(String tipo) {
        if (tipo != null && tipo.startsWith("series<") && tipo.endsWith(">")) {
            return tipo.substring(7, tipo.length() - 1);
        }
        return "numerus";
    }

    private String genPig(PigLatinParserParser.ExpresionContext e) {
        if (e instanceof PigLatinParserParser.UmenosContext u) {
            String v = genPig(u.expresion());
            String t = nuevoTemp(tipoLugar(v));
            emitir("UMINUS", v, "-", t, GeneradorC.segmentoDe(t), "");
            return t;
        }
        if (e instanceof PigLatinParserParser.NegacionContext n) {
            String v = genPig(n.expresion());
            String t = nuevoTemp("bool");
            emitir("NOT", v, "-", t);
            return t;
        }
        if (e instanceof PigLatinParserParser.ParentesisContext p) {
            return genPig(p.expresion());
        }
        if (e instanceof PigLatinParserParser.MultDivContext m) {
            return binaria(genPig(m.expresion(0)), m.ops1.getText(), genPig(m.expresion(1)));
        }
        if (e instanceof PigLatinParserParser.SumaRestaContext s) {
            return binaria(genPig(s.expresion(0)), s.ops1.getText(), genPig(s.expresion(1)));
        }
        if (e instanceof PigLatinParserParser.IgualNoIgualContext eq) {
            return binaria(genPig(eq.expresion(0)), eq.ops1.getText(), genPig(eq.expresion(1)));
        }
        if (e instanceof PigLatinParserParser.MenorMayorIgualContext mm) {
            return binaria(genPig(mm.expresion(0)), mm.ops1.getText(), genPig(mm.expresion(1)));
        }
        if (e instanceof PigLatinParserParser.MenorMayorContext mm) {
            return binaria(genPig(mm.expresion(0)), mm.ops1.getText(), genPig(mm.expresion(1)));
        }
        if (e instanceof PigLatinParserParser.AndOrContext ao) {
            return binaria(genPig(ao.expresion(0)), ao.ops1.getText(), genPig(ao.expresion(1)));
        }
        if (e instanceof PigLatinParserParser.Llamada_Actio_ExpContext c) {
            List<String> args = new ArrayList<>();
            for (PigLatinParserParser.ExpresionContext a : c.expresion()) {
                args.add(genPig(a));
            }
            String fn = c.ID().getText();
            paramsY(fn, args);
            String ret = retFunc.getOrDefault(fn, "numerus");
            if (ret.equals("void")) {
                emitir("CALL", fn, String.valueOf(args.size()), "-");
                return "0";
            }
            String t = nuevoTemp(ret);
            emitir("CALL", fn, String.valueOf(args.size()), t,
                    GeneradorC.segmentoDe(ret), "");
            return t;
        }
        if (e instanceof PigLatinParserParser.Llamada_Ratio_TipoContext c) {
            List<String> args = new ArrayList<>();
            for (PigLatinParserParser.ExpresionContext a : c.expresion()) {
                args.add(genPig(a));
            }
            String fn = c.ID().getText();
            paramsY(fn, args);
            String ret = retFunc.getOrDefault(fn, c.tipos().getText());
            String t = nuevoTemp(ret);
            emitir("CALL", fn, String.valueOf(args.size()), t,
                    GeneradorC.segmentoDe(ret), "");
            return t;
        }
        if (e instanceof PigLatinParserParser.Novus_ExpContext c) {
            String clase = c.ID().getText();
            List<String> args = new ArrayList<>();
            for (PigLatinParserParser.ExpresionContext a : c.expresion()) args.add(genPig(a));
            for (String ap : args) emitir("PARAM", ap, "-", "-");
            String t = nuevoTemp(clase);
            emitir("CALL", clase + "_new_" + args.size(), String.valueOf(args.size()), t, "HEAP", "");
            return t;
        }
        if (e instanceof PigLatinParserParser.Acceso_CadenaContext c) {
            String base = genPig(c.expresion());
            String tipoB = tipoLugar(base);
            String campo = c.ID().getText();
            ClaseZ cz = clasesZ.get(tipoB);
            String tCampo = (cz != null && cz.campos.containsKey(campo))
                    ? cz.campos.get(campo) : "numerus";
            String t = nuevoTemp(tCampo);
            emitir("=.", base, campo, t, GeneradorC.segmentoDe(tCampo), "");
            return t;
        }
        if (e instanceof PigLatinParserParser.Metodo_CadenaContext c) {
            String base = genPig(c.expresion(0));
            String tipoB = tipoLugar(base);
            ClaseZ cz = clasesZ.get(tipoB);
            String metName = c.ID().getText();
            List<String> args = new ArrayList<>();
            for (int i = 1; i < c.expresion().size(); i++) args.add(genPig(c.expresion(i)));
            if (cz != null) {
                ClaseZ.MetodoZ mm = cz.metodo(metName, args.size());
                if (mm == null) {
                    throw new RuntimeException("Método no definido: '" + tipoB + "." + metName + "'.");
                }
                if (mm.params.size() != args.size()) {
                    throw new RuntimeException("Aridad incorrecta: '" + tipoB + "." + metName
                            + "' espera " + mm.params.size() + " pero se dieron " + args.size() + ".");
                }
                emitir("PARAM", base, "-", "-");
                for (String ap : args) emitir("PARAM", ap, "-", "-");
                if (mm.retorno.equals("void")) {
                    emitir("CALL", mm.nombreC(tipoB),
                            String.valueOf(args.size() + 1), "-");
                    return "0";
                }
                String t = nuevoTemp(mm.retorno);
                emitir("CALL", mm.nombreC(tipoB), String.valueOf(args.size() + 1), t,
                        GeneradorC.segmentoDe(mm.retorno), "");
                return t;
            }
            for (String ap : args) emitir("PARAM", ap, "-", "-");
            String t = nuevoTemp("numerus");
            emitir("CALL", tipoB + "." + metName,
                    String.valueOf(args.size()), t, "STACK", "");
            return t;
        }
        if (e instanceof PigLatinParserParser.Acceso_IndiceContext c) {
            String base = genPig(c.expresion(0));
            String tipoB = tipoLugar(base);
            String elem = tipoElemento(tipoB);
            String t = nuevoTemp(elem);
            emitir("=[]", base, genPig(c.expresion(1)), t, GeneradorC.segmentoDe(elem), "");
            return t;
        }
        if (e instanceof PigLatinParserParser.VerumValorContext) return "verum";
        if (e instanceof PigLatinParserParser.FalsusValorContext) return "falsus";
        if (e instanceof PigLatinParserParser.IdentificadorContext c) {
            String r = resolver(c.ID().getText());
            return r == null ? c.ID().getText() : r;
        }
        if (e instanceof PigLatinParserParser.IntValContext
                || e instanceof PigLatinParserParser.DoubleValContext
                || e instanceof PigLatinParserParser.CharValContext
                || e instanceof PigLatinParserParser.StringValContext) {
            return e.getText();
        }
        return e.getText();
    }
}

