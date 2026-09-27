package org.example.Ejecutor;

import antlr4.com.antlr4.com.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.Codigo3D.Cuarteta;
import org.example.Codigo3D.GeneradorC;
import org.example.Codigo3D.TraductorPigY;
import org.example.Codigo3D.TraductorZ;
import org.example.Reports.CompilerError;
import org.example.Reports.ErrorCollector;
import org.example.Reports.ErrorReporter;
import org.example.Semantico.SemanticoPig;
import org.example.Semantico.SemanticoY;
import org.example.Semantico.SemanticoZ;
import org.example.Semantico.StructSimbolo;
import org.example.parser.YIdentationLexer;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompiladorService {

    public ResultadoCompilacion compilar(File archivo, String codigo) {
        String nombre = archivo == null ? "desconocido" : archivo.getName();
        String ext = extension(nombre);
        switch (ext) {
            case ".pig": return compilarPig(archivo, codigo);
            case ".y": return compilarY(archivo, codigo);
            case ".z": return compilarZ(archivo, codigo);
            default:
                ErrorReporter r = new ErrorReporter();
                r.semantico(1, "Extensión no soportada: " + ext + " (solo .pig, .y, .z)");
                return new ResultadoCompilacion(false, "desconocido",
                        List.of(), r.getErrores(), List.of(), "", "",
                        "✖ No se pudo ejecutar: extensión no soportada.\n");
        }
    }

    private ResultadoCompilacion compilarPig(File archivo, String codigo) {
        ErrorReporter reporter = new ErrorReporter();
        CharStream entrada = CharStreams.fromString(codigo);
        PigLatinLexer lexer = new PigLatinLexer(entrada);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ErrorCollector(reporter, true));

        CommonTokenStream stream = new CommonTokenStream(lexer);
        stream.fill();
        List<Token> tokens = new ArrayList<>(stream.getTokens());
        stream.seek(0);

        PigLatinParserParser parser = new PigLatinParserParser(stream);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorCollector(reporter, false));
        PigLatinParserParser.InicioContext tree = parser.inicio();

        if (reporter.tieneErrores()) {
            return fallo("PigLatin", tokens, reporter,
                    "----- Hay errores léxicos/sintácticos (PigLatin) -----\n" + fmtErrores(reporter));
        }
        if (tree == null || tree.instrucciones() == null) {
            reporter.semantico(1, "No se pudo construir el árbol de análisis del .pig.");
            return fallo("PigLatin", tokens, reporter,
                    "----- Hay errores semánticos (PigLatin) -----\n" + fmtErrores(reporter));
        }

        List<String> imports = extraerImports(tree, codigo);
        ResolutorImports.Proyecto proyecto = ResolutorImports.localizar(archivo);
        Map<String, File> resueltos = new LinkedHashMap<>();
        for (String imp : imports) {
            File f = ResolutorImports.resolver(imp, archivo, proyecto);
            if (f == null) {
                String donde = proyecto.raiz == null ? "(sin proyecto.xml localizado)"
                        : proyecto.raiz.getAbsolutePath() + " / proyecto.xml";
                reporter.semantico(1, "Import no encontrado: '" + imp
                        + "' (buscado en " + donde + ").");
            } else {
                resueltos.put(imp, f);
            }
        }

        Map<String, FuncInfo> funciones = new LinkedHashMap<>();
        List<TraductorPigY.FuncionY> funcionesY = new ArrayList<>();
        Map<String, YLenguajeParser.InicioContext> arbolesY = new HashMap<>();
        for (Map.Entry<String, File> e : resueltos.entrySet()) {
            File f = e.getValue();
            String ext = extension(f.getName());
            if (!ext.equals(".y")) continue; // .z se valida abajo
            String cy;
            try {
                cy = Files.readString(f.toPath(), StandardCharsets.UTF_8);
            } catch (Exception ex) {
                reporter.semantico(1, "No se pudo leer el import '" + e.getKey()
                        + "': " + ex.getMessage());
                continue;
            }
            ErrorReporter ry = new ErrorReporter();
            YLenguajeParser.InicioContext ty = parseY(cy, ry);
            if (ry.tieneErrores() || ty == null) {
                reporter.semantico(1, "El import '" + e.getKey() + "' ("
                        + f.getName() + ") tiene errores y no puede usarse.");
                for (CompilerError ce : ry.getErrores()) {
                    reporter.semantico(1, "En '" + f.getName() + "': " + ce.getMessage());
                }
                continue;
            }
            arbolesY.put(f.getName(), ty);
            for (YLenguajeParser.Bloc_funcContext bf : ty.bloq_func().bloc_func()) {
                FuncInfo fi = firmaY(bf, f.getName());
                if (funciones.containsKey(fi.nombre)) {
                    reporter.semantico(1, "Función duplicada: '" + fi.nombre
                            + "' (en '" + f.getName() + "' y en '"
                            + funciones.get(fi.nombre).archivoOrigen + "').");
                } else {
                    funciones.put(fi.nombre, fi);
                    funcionesY.add(new TraductorPigY.FuncionY(fi, bf));
                }
            }
        }
        Map<String, ClaseZ> clases = new LinkedHashMap<>();
        Map<String, ZetarianoParserParser.InicioContext> arbolesZ = new LinkedHashMap<>();
        for (Map.Entry<String, File> e : resueltos.entrySet()) {
            File f = e.getValue();
            if (!extension(f.getName()).equals(".z")) continue;
            try {
                String cz = Files.readString(f.toPath(), StandardCharsets.UTF_8);
                ErrorReporter rz = new ErrorReporter();
                ZetarianoParserParser.InicioContext tz = parseZ(cz, rz);
                if (rz.tieneErrores() || tz == null) {
                    reporter.semantico(1, "El import '" + e.getKey() + "' ("
                            + f.getName() + ") tiene errores y no puede usarse.");
                    for (CompilerError ce : rz.getErrores()) {
                        reporter.semantico(1, "En '" + f.getName() + "': " + ce.getMessage());
                    }
                    continue;
                }
                ClaseZ modelo = ClaseZ.desde(f.getName(), tz);
                if (modelo == null) {
                    reporter.semantico(1, "El import '" + e.getKey() + "' ("
                            + f.getName() + ") no define una clase válida.");
                    continue;
                }
                String base = f.getName().replaceFirst("\\.[zZ]$", "");
                if (!modelo.nombre.equals(base)) {
                    reporter.semantico(1, "El archivo debe llamarse como la clase: '"
                            + f.getName() + "' define 'class " + modelo.nombre + "'.");
                    continue;
                }
                if (clases.containsKey(modelo.nombre)) {
                    reporter.semantico(1, "Clase duplicada: '" + modelo.nombre + "'.");
                    continue;
                }
                clases.put(modelo.nombre, modelo);
                arbolesZ.put(modelo.nombre, tz);
            } catch (Exception ex) {
                reporter.semantico(1, "No se pudo leer el import '" + e.getKey() + "'.");
            }
        }

        Map<String, StructSimbolo> structsY = new LinkedHashMap<>();
        for (Map.Entry<String, YLenguajeParser.InicioContext> e : arbolesY.entrySet()) {
            String origen = e.getKey();
            ErrorReporter ry = new ErrorReporter();
            new SemanticoY(ry).analizar(e.getValue());
            structsY.putAll(SemanticoY.extraerStructs(e.getValue()));
            if (ry.tieneErrores()) {
                reporter.semantico(1, "El import '" + origen + "' tiene errores semánticos:");
                for (CompilerError ce : ry.getErrores()) {
                    reporter.semantico(1, "En '" + origen + "': " + ce.getMessage());
                }
            }
        }

        for (Map.Entry<String, ZetarianoParserParser.InicioContext> e : arbolesZ.entrySet()) {
            String origen = e.getKey() + ".z";
            ErrorReporter rz = new ErrorReporter();
            new SemanticoZ(rz).analizar(e.getValue());
            if (rz.tieneErrores()) {
                reporter.semantico(1, "El import '" + origen + "' tiene errores semánticos:");
                for (CompilerError ce : rz.getErrores()) {
                    reporter.semantico(1, "En '" + origen + "': " + ce.getMessage());
                }
            }
        }

        List<TraductorPigY.GlobalDecl> globales = extraerGlobales(tree, reporter);
        new SemanticoPig(reporter, funciones, clases, structsY).analizar(tree);

        if (reporter.tieneErrores()) {
            return fallo("PigLatin", tokens, reporter,
                    "----- Hay errores semánticos (PigLatin) -----\n" + fmtErrores(reporter)
                            + "Sin traducción: no se genera C3D ni código C con errores.\n");
        }

        TraductorPigY.clases(clases);
        TraductorPigY trad = new TraductorPigY(tree, globales, funcionesY);
        TraductorZ tz = new TraductorZ(trad, clases, arbolesZ);
        trad.traductorZ(tz);
        try {
            trad.traducir();
        } catch (RuntimeException ex) {
            reporter.semantico(1, "No se pudo generar C3D: " + ex.getMessage());
            return fallo("PigLatin", tokens, reporter,
                    "----- Hay errores semánticos (PigLatin) -----\n" + fmtErrores(reporter));
        }
        List<Cuarteta> cuartetas = trad.getCuartetas();
        String codigo3D = GeneradorC.fmt3D(cuartetas);
        GeneradorC genC = new GeneradorC(cuartetas, trad.getTempTypes(),
                trad.getVarTypes(), trad.getGlobales(), trad.getRetFunc(), clases);
        String codigoC = genC.generar(archivo == null ? "principal.pig" : archivo.getName());

        StringBuilder sb = new StringBuilder();
        sb.append("✔ Ejecución exitosa: no se encontraron errores léxicos, sintácticos ni semánticos.\n");
        sb.append("Lenguaje: PigLatin | Archivo: ")
                .append(archivo == null ? "?" : archivo.getName()).append("\n");
        sb.append("Imports resueltos: ").append(resueltos.size())
                .append(" | Funciones importadas: ").append(funciones.size())
                .append(" | Clases importadas: ").append(clases.size())
                .append(" | Cuartetas generadas: ").append(cuartetas.size()).append("\n");
        if (!tz.getAvisos().isEmpty()) {
            sb.append("Avisos (no bloquean la traducción):\n");
            for (String av : tz.getAvisos()) sb.append("  ! ").append(av).append("\n");
        }
        sb.append("Ver: pestañas 'Codigo 3 Direciones' y 'Codigo C' | Reportes > Tokens / Errores.\n");
        return new ResultadoCompilacion(true, "PigLatin", tokens, reporter.getErrores(),
                cuartetas, codigo3D, codigoC, sb.toString());
    }

    private ResultadoCompilacion compilarY(File archivo, String codigo) {
        ErrorReporter reporter = new ErrorReporter();
        YLenguajeParser.InicioContext tree = parseY(codigo, reporter);
        List<Token> tokens = tokensY(codigo);

        if (reporter.tieneErrores() || tree == null) {
            return fallo("Y?", tokens, reporter,
                    "----- Hay errores léxicos/sintácticos (Y?) -----\n" + fmtErrores(reporter));
        }
        if (!codigo.contains("%funciones")) {
            reporter.semantico(1, "Sección obligatoria '%funciones' no encontrada.");
        }

        new SemanticoY(reporter).analizar(tree);
        if (reporter.tieneErrores()) {
            return fallo("Y?", tokens, reporter,
                    "----- Hay errores semánticos (Y?) -----\n" + fmtErrores(reporter));
        }
        String consola = "✔ Archivo .y válido (funciones: " + funcionesY(codigo).size() + ").\n"
                + "Semántica OK: tipos, estructuras, arreglos y funciones verificados con Visitor.\n"
                + "La ejecución y el C3D se generan desde el .pig que lo importa.\n";
        return new ResultadoCompilacion(true, "Y?", tokens, reporter.getErrores(),
                List.of(), "", "", consola);
    }

    private ResultadoCompilacion compilarZ(File archivo, String codigo) {
        ErrorReporter reporter = new ErrorReporter();
        ZetarianoParserParser.InicioContext tree = parseZ(codigo, reporter);
        List<Token> tokens = tokensZ(codigo);

        if (reporter.tieneErrores() || tree == null) {
            return fallo("Zetariano", tokens, reporter,
                    "----- Hay errores léxicos/sintácticos (Zetariano) -----\n" + fmtErrores(reporter));
        }
        String clase = claseZetariana(tokens);
        String base = archivo == null ? "" : archivo.getName().replaceFirst("\\.z$", "");
        if (clase != null && !clase.equals(base)) {
            reporter.semantico(1, "El archivo debe llamarse como la clase: se encontró 'class "
                    + clase + "' pero el archivo es '" + archivo.getName() + "'.");
        }
        new SemanticoZ(reporter).analizar(tree);
        if (reporter.tieneErrores()) {
            return fallo("Zetariano", tokens, reporter,
                    "----- Hay errores semánticos (Zetariano) -----\n" + fmtErrores(reporter));
        }
        String consola = "✔ Archivo .z válido (clase " + clase + ").\n"
                + "Semántica OK: aritmética int/double, String+primitivos, +=, ternario y null verificados.\n"
                + "La ejecución y el C3D se generan desde el .pig principal.\n";
        return new ResultadoCompilacion(true, "Zetariano", tokens, reporter.getErrores(),
                List.of(), "", "", consola);
    }

    private YLenguajeParser.InicioContext parseY(String codigo, ErrorReporter reporter) {
        return parseY(codigo, reporter, true);
    }

    private YLenguajeParser.InicioContext parseY(String codigo, ErrorReporter reporter,
                                                 boolean normalizar) {
        try {
            CharStream entrada = CharStreams.fromString(
                    normalizar ? normalizarY(codigo) : codigo);
            Lexer lexer = new YIdentationLexer(entrada);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new ErrorCollector(reporter, true));
            CommonTokenStream stream = new CommonTokenStream(lexer);
            stream.fill();
            stream.seek(0);
            YLenguajeParser parser = new YLenguajeParser(stream);
            parser.removeErrorListeners();
            parser.addErrorListener(new ErrorCollector(reporter, false));
            YLenguajeParser.InicioContext t = parser.inicio();
            if (reporter.tieneErrores()) return null;
            return t;
        } catch (Exception ex) {
            reporter.semantico(1, "Fallo interno al analizar Y?: " + ex.getMessage());
            return null;
        }
    }

    static String normalizarY(String codigo) {
        String[] lineas = codigo.split("\r?\n", -1);
        StringBuilder sb = new StringBuilder();
        boolean enDef = false;
        for (int i = 0; i < lineas.length; i++) {
            String l = lineas[i];
            String stripped = l.stripLeading();
            int indent = l.length() - stripped.length();
            String out = l;
            if (!stripped.isBlank() && indent == 0
                    && stripped.matches("(definir|estructura)\\b.*")) {
                out = "    " + l;
                enDef = true;
            } else if (!stripped.isBlank() && indent == 0
                    && stripped.matches("%(funciones|estructuras)\\b.*")) {
                enDef = false;
            } else if (enDef && !stripped.isBlank() && indent > 0 && indent <= 4) {
                out = "    " + l;
            }
            sb.append(out);
            if (i + 1 < lineas.length) sb.append("\n");
        }
        return sb.toString();
    }

    private List<Token> tokensY(String codigo) {
        try {
            CharStream entrada = CharStreams.fromString(codigo);
            Lexer lexer = new YIdentationLexer(entrada);
            CommonTokenStream stream = new CommonTokenStream(lexer);
            stream.fill();
            return new ArrayList<>(stream.getTokens());
        } catch (Exception ignored) {
            return List.of();
        }
    }

    private ZetarianoParserParser.InicioContext parseZ(String codigo, ErrorReporter reporter) {
        try {
            CharStream entrada = CharStreams.fromString(codigo);
            ZetarianoLexer lexer = new ZetarianoLexer(entrada);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new ErrorCollector(reporter, true));
            CommonTokenStream stream = new CommonTokenStream(lexer);
            stream.fill();
            stream.seek(0);
            ZetarianoParserParser parser = new ZetarianoParserParser(stream);
            parser.removeErrorListeners();
            parser.addErrorListener(new ErrorCollector(reporter, false));
            ZetarianoParserParser.InicioContext t = parser.inicio();
            if (reporter.tieneErrores()) return null;
            return t;
        } catch (Exception ex) {
            reporter.semantico(1, "Fallo interno al analizar Zetariano: " + ex.getMessage());
            return null;
        }
    }

    private List<Token> tokensZ(String codigo) {
        try {
            CharStream entrada = CharStreams.fromString(codigo);
            ZetarianoLexer lexer = new ZetarianoLexer(entrada);
            CommonTokenStream stream = new CommonTokenStream(lexer);
            stream.fill();
            return new ArrayList<>(stream.getTokens());
        } catch (Exception ignored) {
            return List.of();
        }
    }

    private List<String> extraerImports(PigLatinParserParser.InicioContext tree, String codigo) {
        List<String> out = new ArrayList<>();
        try {
            if (tree.instrucciones() != null) {
                for (PigLatinParserParser.Bloque_importsContext b
                        : tree.instrucciones().bloque_imports()) {
                    String t = b.getText();
                    String imp = t.startsWith("import") ? t.substring("import".length()) : t;
                    if (!imp.isBlank()) out.add(imp.trim());
                }
            }
        } catch (Exception ignored) { }
        if (out.isEmpty()) {
            Matcher m = Pattern.compile("(?m)^\\s*import\\s+([A-Za-z_][\\w]*(?:\\.[A-Za-z_][\\w]*)*)")
                    .matcher(codigo);
            while (m.find()) out.add(m.group(1));
        }
        return out.stream().distinct().toList();
    }

    private FuncInfo firmaY(YLenguajeParser.Bloc_funcContext bf, String origen) {
        String nombre = bf.ID(0).getText();
        String retorno = "void";
        if (bf.RETORNO_FUNC() != null) {
            if (bf.tipos() != null) retorno = FuncInfo.canonY(bf.tipos().getText());
            else if (bf.ID().size() > 1) retorno = FuncInfo.canonY(bf.ID(1).getText());
        }
        FuncInfo fi = new FuncInfo(nombre, retorno, origen);
        if (bf.params() != null) {
            for (YLenguajeParser.Tipos_paramsContext tp : bf.params().tipos_params()) {
                List<TerminalNode> ids = tp.ID();
                String tipo;
                String pname;
                if (tp.tipos() != null) {
                    tipo = FuncInfo.canonY(tp.tipos().getText());
                    pname = ids.get(ids.size() - 1).getText();
                } else if (ids.size() >= 2) {
                    tipo = FuncInfo.canonY(ids.get(0).getText());
                    pname = ids.get(1).getText();
                } else {
                    tipo = "numerus";
                    pname = ids.get(0).getText();
                }
                fi.params.add(new FuncInfo.ParamInfo(tipo, pname));
            }
        }
        return fi;
    }

    private List<TraductorPigY.GlobalDecl> extraerGlobales(
            PigLatinParserParser.InicioContext tree, ErrorReporter reporter) {
        List<TraductorPigY.GlobalDecl> out = new ArrayList<>();
        Set<String> vistos = new HashSet<>();
        if (tree.instrucciones() == null || tree.instrucciones().vars_par() == null) {
            return out;
        }
        for (PigLatinParserParser.Bloque_varsContext b
                : tree.instrucciones().vars_par().bloque_vars()) {
            if (b.ESTO() != null && b.SERIES() == null) {
                List<TerminalNode> ids = b.ID();
                if (ids.isEmpty()) continue;
                if (b.NOVUS() != null) {
                    String nombre = ids.get(0).getText();
                    String tipo = ids.size() > 1 ? ids.get(1).getText() : "struct";
                    vistos.add(nombre);
                    out.add(new TraductorPigY.GlobalDecl(nombre, tipo, null,
                            null, null, null, tipo, b.bloque_objt()));
                } else if (b.tipos() != null) {
                    String nombre = ids.get(0).getText();
                    String tipo = b.tipos().getText();
                    vistos.add(nombre);
                    PigLatinParserParser.ExpresionContext init =
                            b.expresion() == null ? null : b.expresion();
                    out.add(new TraductorPigY.GlobalDecl(nombre, tipo, init));
                } else if (b.expresion() != null && ids.size() == 1) {
                    String nombre = ids.get(0).getText();
                    vistos.add(nombre);
                    out.add(new TraductorPigY.GlobalDecl(nombre, "bool", b.expresion()));
                } else if (ids.size() >= 2) {
                    String nombre = ids.get(0).getText();
                    String tipo = ids.get(1).getText();
                    vistos.add(nombre);
                    out.add(new TraductorPigY.GlobalDecl(nombre, tipo, null));
                }
            } else if (b.SERIES() != null) {
                List<TerminalNode> ids = b.ID();
                if (ids.isEmpty()) continue;
                String nombre = ids.get(0).getText();
                String tipoElem = b.tipos_varios() == null ? "numerus"
                        : b.tipos_varios().getText();
                vistos.add(nombre);
                out.add(new TraductorPigY.GlobalDecl(nombre, "series<" + tipoElem + ">", null,
                        b.expresion(), tipoElem, b.bloque_varios()));
            }
        }
        return out;
    }

    private void dupCheck(ErrorReporter reporter, Set<String> vistos, String nombre) {
        if (!vistos.add(nombre)) {
            reporter.semantico(1, "Símbolo duplicado: '" + nombre + "' ya fue declarado.");
        }
    }

    private List<String> iteradoresPer(PigLatinParserParser.InicioContext tree) {
        List<String> out = new ArrayList<>();
        if (tree.instrucciones() == null || tree.instrucciones().bloque_main() == null) {
            return out;
        }
        for (PigLatinParserParser.InstruccionContext s
                : tree.instrucciones().bloque_main().instruccion()) {
            recolectarPer(s, out);
        }
        return out;
    }

    private void recolectarPer(PigLatinParserParser.InstruccionContext s, List<String> out) {
        if (s.PER() != null && s.ID() != null) out.add(s.ID().getText());
        for (PigLatinParserParser.InstruccionContext h : s.instruccion()) recolectarPer(h, out);
        if (s.bloque_si() != null) {
            for (PigLatinParserParser.InstruccionContext h : s.bloque_si().instruccion()) {
                recolectarPer(h, out);
            }
        }
    }

    private static final Set<String> NO_VARIABLES = Set.of(
            "esto", "series", "novus", "import", "si", "aliter", "finis", "dum",
            "facere", "per", "perge", "interrumpe", "verum", "falsus");

    private void validarVariables(List<Token> tokens, Set<String> declaradas,
                                  Set<String> funciones, ErrorReporter reporter) {
        Set<String> yaReportados = new HashSet<>();
        for (int i = 0; i < tokens.size(); i++) {
            Token t = tokens.get(i);
            if (t.getType() == Token.EOF) continue;
            if (t.getChannel() != Token.DEFAULT_CHANNEL) continue;
            if (t.getType() != PigLatinLexer.ID) continue;
            String txt = t.getText();
            if (NO_VARIABLES.contains(txt)) continue;
            String prev = prevText(tokens, i);
            String next = nextText(tokens, i);
            if (prev.equals("esto") || prev.equals("series") || prev.equals("novus")
                    || prev.equals(".") || prev.equals("import")) continue;
            if (prev.equals(":")) continue;
            if (next.equals("(")) continue;
            if (prev.equals("(") && next.equals(")")) continue;
            if (declaradas.contains(txt) || funciones.contains(txt)) continue;
            if (yaReportados.add(txt)) {
                reporter.semantico(t.getLine(),
                        "Variable no declarada: '" + txt + "'.");
            }
        }
    }

    private String prevText(List<Token> tokens, int i) {
        for (int k = i - 1; k >= 0; k--) {
            Token t = tokens.get(k);
            if (t.getChannel() != Token.DEFAULT_CHANNEL) continue;
            if (t.getType() == Token.EOF) continue;
            return t.getText();
        }
        return "";
    }

    private String nextText(List<Token> tokens, int i) {
        for (int k = i + 1; k < tokens.size(); k++) {
            Token t = tokens.get(k);
            if (t.getChannel() != Token.DEFAULT_CHANNEL) continue;
            if (t.getType() == Token.EOF) continue;
            return t.getText();
        }
        return "";
    }

    private void validarLlamadas(PigLatinParserParser.InicioContext tree,
                                 Map<String, FuncInfo> funciones, ErrorReporter reporter) {
        List<PigLatinParserParser.Llamada_Actio_ExpContext> llamadas = new ArrayList<>();
        List<PigLatinParserParser.Llamada_Ratio_TipoContext> llamadasRatio = new ArrayList<>();
        recolectarLlamadas(tree, llamadas, llamadasRatio);
        for (var c : llamadas) {
            String fn = c.ID().getText();
            if (fn.equals("leer")) continue;
            FuncInfo fi = funciones.get(fn);
            if (fi == null) {
                reporter.semantico(1, "Función no definida: '" + fn
                        + "' no existe en ningún import .y.");
            } else if (fi.params.size() != c.expresion().size()) {
                reporter.semantico(1, "Aridad incorrecta: '" + fn + "' espera "
                        + fi.params.size() + " argumento(s) pero se dieron "
                        + c.expresion().size() + ".");
            }
        }
        for (var c : llamadasRatio) {
            String fn = c.ID().getText();
            FuncInfo fi = funciones.get(fn);
            if (fi == null) {
                reporter.semantico(1, "Función no definida: '" + fn
                        + "' no existe en ningún import .y.");
            }
        }
    }

    private void recolectarLlamadas(ParseTree n,
                                    List<PigLatinParserParser.Llamada_Actio_ExpContext> out,
                                    List<PigLatinParserParser.Llamada_Ratio_TipoContext> outR) {
        if (n instanceof PigLatinParserParser.Llamada_Actio_ExpContext c) out.add(c);
        else if (n instanceof PigLatinParserParser.Llamada_Ratio_TipoContext c) outR.add(c);
        for (int i = 0; i < n.getChildCount(); i++) {
            recolectarLlamadas(n.getChild(i), out, outR);
        }
    }

    private void validarObjetos(PigLatinParserParser.InicioContext tree,
                                Map<String, String> tipoGlobal,
                                Map<String, ClaseZ> clases, ErrorReporter reporter) {
        if (tree.instrucciones() == null) return;
        if (tree.instrucciones().vars_par() != null) {
            for (PigLatinParserParser.Bloque_varsContext b
                    : tree.instrucciones().vars_par().bloque_vars()) {
                if (b.NOVUS() == null) continue;
                List<TerminalNode> ids = b.ID();
                if (ids.size() < 2) continue;
                String clase = ids.get(1).getText();
                ClaseZ cz = clases.get(clase);
                if (cz == null) {
                    reporter.semantico(1, "Clase no definida: '" + clase
                            + "' no existe en ningún import .z.");
                    continue;
                }
                int nArgs = contarArgsObjt(b.bloque_objt());
                boolean ok = cz.constructores.isEmpty() && nArgs == 0;
                for (ClaseZ.MetodoZ c : cz.constructores) {
                    if (c.params.size() == nArgs) { ok = true; break; }
                }
                if (!ok) {
                    reporter.semantico(1, "Constructor no coincide: 'new " + clase
                            + "' con " + nArgs + " argumento(s).");
                }
            }
        }

        List<PigLatinParserParser.Bloque_objtContext> objs = new ArrayList<>();
        recolectarObjt(tree, objs);
        for (var b : objs) {
            for (int i = 0; i < b.getChildCount(); i++) {
                if (!(b.getChild(i) instanceof TerminalNode tn)
                        || !tn.getText().equals("novus")) continue;
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
                if (clase == null) continue;
                ClaseZ cz = clases.get(clase);
                if (cz == null) {
                    reporter.semantico(1, "Clase no definida: '" + clase
                            + "' no existe en ningún import .z.");
                    continue;
                }
                int nArgs = contarArgsObjt(sub);
                boolean ok = cz.constructores.isEmpty() && nArgs == 0;
                for (ClaseZ.MetodoZ c : cz.constructores) {
                    if (c.params.size() == nArgs) { ok = true; break; }
                }
                if (!ok) {
                    reporter.semantico(1, "Constructor no coincide: 'new " + clase
                            + "' con " + nArgs + " argumento(s).");
                }
            }
        }

        List<PigLatinParserParser.LLamada_Propiedad_FuncionContext> mets = new ArrayList<>();
        List<PigLatinParserParser.Llamada_Propiedad_StructuraContext> campos = new ArrayList<>();
        recolectarObjetos(tree, mets, campos);
        for (var c : mets) {
            List<TerminalNode> ids = c.ID();
            String obj = ids.get(0).getText();
            String met = ids.get(1).getText();
            String tipo = tipoGlobal.get(obj);
            if (tipo == null) continue;
            ClaseZ cz = clases.get(tipo);
            if (cz == null) {
                reporter.semantico(1, "'" + obj + "' no es un objeto (es " + tipo
                        + "): no tiene métodos.");
                continue;
            }
            ClaseZ.MetodoZ mm = cz.metodos.get(met);
            if (mm == null) {
                reporter.semantico(1, "Método no definido: '" + tipo + "." + met + "'.");
            } else if (mm.params.size() != c.expresion().size()) {
                reporter.semantico(1, "Aridad incorrecta: '" + tipo + "." + met + "' espera "
                        + mm.params.size() + " pero se dieron " + c.expresion().size() + ".");
            }
        }
        for (var c : campos) {
            List<TerminalNode> ids = c.ID();
            String obj = ids.get(0).getText();
            String campo = ids.get(1).getText();
            String tipo = tipoGlobal.get(obj);
            if (tipo == null) continue;
            ClaseZ cz = clases.get(tipo);
            if (cz == null) continue;
            if (!cz.campos.containsKey(campo)) {
                reporter.semantico(1, "Campo no definido: '" + tipo + "." + campo + "'.");
            }
        }
    }

    private void recolectarObjetos(ParseTree n,
                                   List<PigLatinParserParser.LLamada_Propiedad_FuncionContext> mets,
                                   List<PigLatinParserParser.Llamada_Propiedad_StructuraContext> campos) {
        if (n instanceof PigLatinParserParser.LLamada_Propiedad_FuncionContext c) mets.add(c);
        else if (n instanceof PigLatinParserParser.Llamada_Propiedad_StructuraContext c) campos.add(c);
        for (int i = 0; i < n.getChildCount(); i++) {
            recolectarObjetos(n.getChild(i), mets, campos);
        }
    }

    private int contarArgsObjt(PigLatinParserParser.Bloque_objtContext b) {
        if (b == null) return 0;
        int n = b.expresion().size();
        for (int i = 0; i < b.getChildCount(); i++) {
            if (b.getChild(i) instanceof TerminalNode tn && tn.getText().equals("novus")) n++;
        }
        return n;
    }

    private void recolectarObjt(ParseTree n,
                                List<PigLatinParserParser.Bloque_objtContext> out) {
        if (n instanceof PigLatinParserParser.Bloque_objtContext c) out.add(c);
        for (int i = 0; i < n.getChildCount(); i++) {
            recolectarObjt(n.getChild(i), out);
        }
    }

    private ResultadoCompilacion fallo(String lenguaje, List<Token> tokens,
                                       ErrorReporter reporter, String consola) {
        StringBuilder sb = new StringBuilder(consola);
        sb.append(reporter.getErrores().size()).append(" error(es) encontrado(s)\n");
        return new ResultadoCompilacion(false, lenguaje, tokens, reporter.getErrores(),
                List.of(), "", "", sb.toString());
    }

    private void semDuplicados(ErrorReporter reporter, List<String> nombres) {
        Map<String, Integer> vistos = new HashMap<>();
        for (String n : nombres) {
            vistos.merge(n, 1, Integer::sum);
            if (vistos.get(n) == 2) {
                reporter.semantico(1, "Símbolo duplicado: '" + n + "' ya fue declarado.");
            }
        }
    }

    private String fmtErrores(ErrorReporter reporter) {
        StringBuilder sb = new StringBuilder();
        for (CompilerError e : reporter.getErrores()) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }

    private List<String> funcionesY(String codigo) {
        List<String> out = new ArrayList<>();
        Matcher m = Pattern.compile("definir\\s+([a-zA-Z_][a-zA-Z_0-9]*)").matcher(codigo);
        while (m.find()) out.add(m.group(1));
        return out;
    }

    private String claseZetariana(List<Token> tokens) {
        for (int i = 0; i + 2 < tokens.size(); i++) {
            if (tokens.get(i).getText().equals("class")
                    && tokens.get(i + 1).getText().matches("[a-zA-Z_][a-zA-Z_0-9]*")) {
                return tokens.get(i + 1).getText();
            }
        }
        return null;
    }

    private static String extension(String nombre) {
        int dot = nombre.lastIndexOf('.');
        if (dot < 0) return "";
        return nombre.substring(dot).toLowerCase();
    }
}

