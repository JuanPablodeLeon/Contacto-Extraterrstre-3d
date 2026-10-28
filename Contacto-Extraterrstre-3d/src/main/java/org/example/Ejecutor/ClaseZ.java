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
    public String padre;
    public final Map<String, String> campos = new LinkedHashMap<>();
    public final Map<String, String> visibilidadCampos = new LinkedHashMap<>();
    public final List<MetodoZ> constructores = new ArrayList<>();
    public final Map<String, List<MetodoZ>> metodos = new LinkedHashMap<>();

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
        public String visibilidad = "default";
        public boolean override;

        public MetodoZ(boolean constructor, String nombre, String retorno,
                       ZetarianoParserParser.InstruccionesContext ctx) {
            this.constructor = constructor;
            this.nombre = nombre;
            this.retorno = retorno;
            this.ctx = ctx;
        }
        public String nombreC(String clase) {
            return clase + "_" + (constructor ? "new" : nombre) + "_" + params.size()
                    + sufijoFirma();
        }
        public String nombreInit(String clase) {
            return clase + "_init_" + params.size() + sufijoFirma();
        }
        /** Sufijo estable que distingue sobrecargas con la misma aridad. */
        public String sufijoFirma() {
            if (params.isEmpty()) return "";
            StringBuilder sb = new StringBuilder("_");
            for (int i = 0; i < params.size(); i++) {
                if (i > 0) sb.append('_');
                String t = canonZ(params.get(i).tipo);
                for (int k = 0; k < t.length(); k++) {
                    char ch = t.charAt(k);
                    sb.append(Character.isLetterOrDigit(ch) ? ch : '_');
                }
            }
            return sb.toString();
        }
        public String firma() {
            StringBuilder sb = new StringBuilder(nombre).append('(');
            for (int i = 0; i < params.size(); i++) {
                if (i > 0) sb.append(',');
                sb.append(canonZ(params.get(i).tipo));
            }
            return sb.append(')').toString();
        }
    }

    public static class CampoInfo {
        public final ClaseZ clase;
        public final String tipo;
        public final String visibilidad;
        public CampoInfo(ClaseZ clase, String tipo, String visibilidad) {
            this.clase = clase;
            this.tipo = tipo;
            this.visibilidad = visibilidad;
        }
    }

    public static class MetodoInfo {
        public final ClaseZ clase;
        public final MetodoZ metodo;
        public MetodoInfo(ClaseZ clase, MetodoZ metodo) {
            this.clase = clase;
            this.metodo = metodo;
        }
    }

    public MetodoZ metodo(String nombre, int aridad) {
        List<MetodoZ> lista = metodos.get(nombre);
        if (lista == null) return null;
        for (MetodoZ m : lista) {
            if (m.params.size() == aridad) return m;
        }
        return null;
    }

    public MetodoZ constructor(int aridad) {
        for (MetodoZ m : constructores) {
            if (m.params.size() == aridad) return m;
        }
        return null;
    }

    public boolean tieneConstructorSinArgs() {
        return constructores.isEmpty() || constructor(0) != null;
    }

    /** Selecciona el constructor cuyos parámetros aceptan los tipos dados (canónicos). */
    public MetodoZ constructorPorTipos(List<String> tiposArgs, Map<String, ClaseZ> clases) {
        for (MetodoZ m : constructores) {
            if (m.params.size() != tiposArgs.size()) continue;
            boolean ok = true;
            for (int i = 0; i < tiposArgs.size(); i++) {
                if (!tipoCompatible(m.params.get(i).tipo, tiposArgs.get(i), clases)) {
                    ok = false;
                    break;
                }
            }
            if (ok) return m;
        }
        return null;
    }

    /** ¿Un argumento del tipo canónico {@code arg} encaja en un parámetro {@code param}? */
    public static boolean tipoCompatible(String param, String arg,
                                         Map<String, ClaseZ> clases) {
        if (param == null || arg == null) return true;
        String p = canonZ(param);
        String a = arg.startsWith("&") ? arg.substring(1) : arg;
        if (p.equals(a)) return true;
        if (a.equals("null")) {
            return clases != null && clases.containsKey(p)
                    || p.startsWith("series<") || p.equals("textum");
        }
        if (p.equals("decimalis") && a.equals("numerus")) return true;
        if (clases == null) return false;
        ClaseZ pc = clases.get(p);
        ClaseZ ac = clases.get(a);
        return pc != null && ac != null && ac.esSubclaseDe(p, clases);
    }

    public ClaseZ clasePadre(Map<String, ClaseZ> clases) {
        return padre == null ? null : clases.get(padre);
    }

    public boolean esSubclaseDe(String ancestro, Map<String, ClaseZ> clases) {
        if (ancestro == null) return false;
        ClaseZ c = this;
        int guarda = 0;
        while (c != null && guarda++ < 256) {
            if (c.nombre.equals(ancestro)) return true;
            c = c.clasePadre(clases);
        }
        return false;
    }

    public CampoInfo buscarCampo(String campo, Map<String, ClaseZ> clases) {
        ClaseZ c = this;
        int guarda = 0;
        while (c != null && guarda++ < 256) {
            if (c.campos.containsKey(campo)) {
                return new CampoInfo(c, c.campos.get(campo),
                        c.visibilidadCampos.getOrDefault(campo, "default"));
            }
            c = c.clasePadre(clases);
        }
        return null;
    }

    public MetodoInfo buscarMetodo(String nombre, int aridad, Map<String, ClaseZ> clases) {
        ClaseZ c = this;
        int guarda = 0;
        while (c != null && guarda++ < 256) {
            MetodoZ m = c.metodo(nombre, aridad);
            if (m != null) return new MetodoInfo(c, m);
            c = c.clasePadre(clases);
        }
        return null;
    }

    /** Busca por firma completa (nombre y tipos de parámetros), respetando la herencia. */
    public MetodoInfo buscarMetodoFirma(String firma, Map<String, ClaseZ> clases) {
        if (firma == null) return null;
        int p = firma.indexOf('(');
        String nombre = p > 0 ? firma.substring(0, p) : firma;
        ClaseZ c = this;
        int guarda = 0;
        while (c != null && guarda++ < 256) {
            List<MetodoZ> lista = c.metodos.get(nombre);
            if (lista != null) {
                for (MetodoZ m : lista) {
                    if (m.firma().equals(firma)) return new MetodoInfo(c, m);
                }
            }
            c = c.clasePadre(clases);
        }
        return null;
    }

    public List<MetodoInfo> metodosVisibles(String nombre, Map<String, ClaseZ> clases) {
        List<MetodoInfo> out = new ArrayList<>();
        ClaseZ c = this;
        int guarda = 0;
        while (c != null && guarda++ < 256) {
            List<MetodoZ> lista = c.metodos.get(nombre);
            if (lista != null) {
                for (MetodoZ m : lista) out.add(new MetodoInfo(c, m));
            }
            c = c.clasePadre(clases);
        }
        return out;
    }

    public static int rangoVisibilidad(String v) {
        if (v == null) return 0;
        switch (v) {
            case "public": return 3;
            case "protected": return 2;
            case "private": return 1;
            default: return 0;
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
        TerminalNode idClase = tree.bloc_main().ID(0);
        if (idClase == null) return null;
        String nombreClase = idClase.getText();
        ClaseZ cz = new ClaseZ(nombreClase, archivoOrigen);
        if (tree.bloc_main().EXTENDS() != null && tree.bloc_main().ID().size() > 1) {
            cz.padre = tree.bloc_main().ID(1).getText();
        }

        for (ZetarianoParserParser.InstruccionesContext ins
                : tree.bloc_main().instrucciones()) {
            String visibilidad = ins.modificador() == null
                    ? "default" : ins.modificador().getText();
            if (!ins.declaracion().isEmpty()) {
                for (ZetarianoParserParser.DeclaracionContext d : ins.declaracion()) {
                    campoDesde(d, cz, visibilidad);
                }
                continue;
            }
            if (ins.LLLAVE() == null) continue;
            List<TerminalNode> ids = ins.ID();
            if (ids.isEmpty()) continue;
            boolean tieneVoid = ins.VOID() != null;
            boolean tieneTipos = ins.tipos() != null;
            if (!tieneVoid && !tieneTipos && ids.size() == 1) {
                MetodoZ m = new MetodoZ(true, ids.get(0).getText(),
                        nombreClase, ins);
                m.visibilidad = visibilidad;
                m.override = ins.OVERRIDE() != null;
                paramsDesde(ins.param_var(), m);
                cz.constructores.add(m);
            } else {
                String nombreMet = ids.get(ids.size() - 1).getText();
                String ret;
                if (tieneVoid) ret = "void";
                else if (tieneTipos) ret = canonZ(ins.tipos().getText());
                else if (ids.size() >= 2) ret = canonZ(ids.get(ids.size() - 2).getText());
                else ret = "void";
                MetodoZ m = new MetodoZ(false, nombreMet, ret, ins);
                m.visibilidad = visibilidad;
                m.override = ins.OVERRIDE() != null;
                paramsDesde(ins.param_var(), m);
                cz.metodos.computeIfAbsent(nombreMet, k -> new ArrayList<>()).add(m);
            }
        }
        return cz;
    }

    private static void campoDesde(ZetarianoParserParser.DeclaracionContext d,
                                   ClaseZ cz, String visibilidad) {
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
        int dims = 0;
        for (int i = 0; i < d.getChildCount(); i++) {
            ParseTree ch = d.getChild(i);
            if (ch instanceof TerminalNode tn
                    && tn.getSymbol().getType() == ZetarianoParserParser.ID) break;
            if (ch instanceof TerminalNode tn && tn.getText().equals("[")) dims++;
        }
        int postDims = 0;
        boolean despuesNombre = false;
        for (int i = 0; i < d.getChildCount(); i++) {
            ParseTree ch = d.getChild(i);
            if (ch instanceof TerminalNode tn
                    && tn.getSymbol().getType() == ZetarianoParserParser.ID) {
                despuesNombre = true;
                continue;
            }
            if (despuesNombre && ch instanceof TerminalNode tn
                    && tn.getText().equals("[")) postDims++;
        }
        for (int i = 0; i < dims + postDims; i++) tipo = "series<" + tipo + ">";
        cz.campos.putIfAbsent(campo, tipo);
        cz.visibilidadCampos.putIfAbsent(campo, visibilidad);
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
