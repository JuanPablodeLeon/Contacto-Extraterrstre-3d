package org.example.Ejecutor;

import antlr4.com.antlr4.com.ZetarianoParserParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClaseZ {

    public final String nombre;
    public final String archivoOrigen;
    public final Map<String, String> campos = new LinkedHashMap<>();
    public final List<MetodoZ> constructores = new ArrayList<>();
    public final Map<String, MetodoZ> metodos = new LinkedHashMap<>();

    public ClaseZ(String nombre, String archivoOrigen) {
        this.nombre = nombre;
        this.archivoOrigen = archivoOrigen;
    }

    public static class ParamZ {
        public final String tipo;
        public final String nombre;
        public ParamZ(String tipo, String nombre) {
            this.tipo = tipo;
            this.nombre = nombre;
        }
    }

    public static class MetodoZ {
        public final boolean constructor;
        public final String nombre;
        public final String retorno;
        public final List<ParamZ> params = new ArrayList<>();
        public final ZetarianoParserParser.InstruccionesContext ctx;
        public MetodoZ(boolean constructor, String nombre, String retorno,
                       ZetarianoParserParser.InstruccionesContext ctx) {
            this.constructor = constructor;
            this.nombre = nombre;
            this.retorno = retorno;
            this.ctx = ctx;
        }
        public String nombreC(String clase) {
            return clase + "_" + (constructor ? "new" : nombre);
        }
    }

    public static String canonZ(String t) {
        if (t == null) return "numerus";
        String s = t.trim();
        switch (s) {
            case "int": return "numerus";
            case "double": return "decimalis";
            case "String": return "textum";
            case "char": return "littera";
            case "boolean": return "bool";
            case "void": return "void";
            default: return s;
        }
    }

    public static boolean esPrimitiva(String canon) {
        return canon.equals("numerus") || canon.equals("decimalis")
                || canon.equals("littera") || canon.equals("bool")
                || canon.equals("void");
    }

    public static ClaseZ desde(String archivoOrigen,
                               ZetarianoParserParser.InicioContext tree) {
        if (tree == null || tree.bloc_main() == null) return null;
        TerminalNode idClase = tree.bloc_main().ID();
        if (idClase == null) return null;
        String nombreClase = idClase.getText();
        ClaseZ cz = new ClaseZ(nombreClase, archivoOrigen);

        for (ZetarianoParserParser.InstruccionesContext ins
                : tree.bloc_main().instrucciones()) {
            if (ins.PUBLIC() == null) {
                for (ZetarianoParserParser.DeclaracionContext d : ins.declaracion()) {
                    campoDesde(d, cz);
                }
                continue;
            }
            List<TerminalNode> ids = ins.ID();
            boolean tieneVoid = ins.VOID() != null;
            boolean tieneTipos = ins.tipos() != null;
            if (!tieneVoid && !tieneTipos && ids.size() == 1) {
                MetodoZ m = new MetodoZ(true, ids.get(0).getText(),
                        nombreClase, ins);
                paramsDesde(ins.param_var(), m);
                cz.constructores.add(m);
            } else {
                if (ids.isEmpty()) continue;
                String nombreMet = ids.get(ids.size() - 1).getText();
                String ret;
                if (tieneVoid) ret = "void";
                else if (tieneTipos) ret = canonZ(ins.tipos().getText());
                else if (ids.size() >= 2) ret = ids.get(ids.size() - 2).getText();
                else ret = "void";
                MetodoZ m = new MetodoZ(false, nombreMet, ret, ins);
                paramsDesde(ins.param_var(), m);
                cz.metodos.put(nombreMet, m);
            }
        }
        return cz;
    }

    private static void campoDesde(ZetarianoParserParser.DeclaracionContext d, ClaseZ cz) {
        List<TerminalNode> ids = d.ID();
        if (ids.isEmpty()) return;
        String tipo;
        String campo;
        if (d.tipos() != null && !d.tipos().isEmpty()) {
            tipo = canonZ(d.tipos().get(0).getText());
            campo = ids.get(0).getText();
        } else if (ids.size() >= 2) {
            tipo = ids.get(0).getText();
            campo = ids.get(1).getText();
        } else {
            return;
        }
        cz.campos.putIfAbsent(campo, tipo);
    }

    static void paramsDesde(ZetarianoParserParser.Param_varContext pv, MetodoZ m) {
        if (pv == null) return;
        String pendiente = null;
        for (int i = 0; i < pv.getChildCount(); i++) {
            ParseTree ch = pv.getChild(i);
            if (ch instanceof ZetarianoParserParser.TiposContext t) {
                pendiente = canonZ(t.getText());
            } else if (ch instanceof TerminalNode tn) {
                String txt = tn.getText();
                if (txt.equals(",")) continue;
                ParseTree sig = null;
                for (int k = i + 1; k < pv.getChildCount(); k++) {
                    ParseTree c2 = pv.getChild(k);
                    if (c2 instanceof TerminalNode t2 && t2.getText().equals(",")) continue;
                    sig = c2;
                    break;
                }
                if (sig instanceof ZetarianoParserParser.ExpresionContext) {
                    pendiente = txt;
                }
            } else if (ch instanceof ZetarianoParserParser.ExpresionContext e) {
                String nombre = e.getText();
                if (!nombre.matches("[a-zA-Z_][a-zA-Z_0-9]*")) {
                    nombre = "p" + m.params.size();
                }
                m.params.add(new ParamZ(pendiente == null ? "numerus" : pendiente, nombre));
                pendiente = null;
            }
        }
    }

    public static String describeTipo(String canon) {
        return canon;
    }

    public static boolean esLlamadaMetodo(ParseTree n) {
        String txt = n.getText();
        return txt.contains(".") && txt.contains("(");
    }
}
