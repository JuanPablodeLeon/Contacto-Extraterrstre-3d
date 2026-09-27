package org.example.Ejecutor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class ResolutorImports {

    private ResolutorImports() {}

    public static class Proyecto {
        public final File raiz;
        public final List<String> rutasXml;
        public Proyecto(File raiz, List<String> rutasXml) {
            this.raiz = raiz;
            this.rutasXml = rutasXml;
        }
    }

    public static Proyecto localizar(File archivoPig) {
        if (archivoPig == null) return new Proyecto(null, List.of());
        File dir = archivoPig.getAbsoluteFile().getParentFile();
        while (dir != null) {
            File xml = new File(dir, "proyecto.xml");
            if (xml.isFile()) {
                return new Proyecto(dir, leerRutas(xml));
            }
            dir = dir.getParentFile();
        }
        return new Proyecto(
                archivoPig.getAbsoluteFile().getParentFile(), List.of());
    }

    public static List<String> leerRutas(File xml) {
        List<String> out = new ArrayList<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xml);
            NodeList nodes = doc.getElementsByTagName("archivo");
            for (int i = 0; i < nodes.getLength(); i++) {
                if (nodes.item(i) instanceof Element e) {
                    String ruta = e.getAttribute("ruta");
                    if (ruta != null && !ruta.isBlank()) out.add(ruta.trim());
                    String txt = e.getTextContent();
                    if (txt != null && !txt.isBlank()
                            && !out.contains(txt.trim())) {
                        out.add(txt.trim());
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return out;
    }

    public static File resolver(String importCrudo, File archivoPig, Proyecto proyecto) {
        if (importCrudo == null || importCrudo.isBlank()) return null;
        String imp = importCrudo.trim();
        List<String> candidatos = new ArrayList<>();

        boolean tieneExtension = imp.toLowerCase().matches(".*\\.(y|z|pig)$");
        if (tieneExtension) {
            int dot = imp.lastIndexOf('.');
            String base = imp.substring(0, dot).replace('.', File.separatorChar);
            String ext = imp.substring(dot); // .y / .z
            candidatos.add(base + ext);
            String simple = new File(base).getName() + ext;
            if (!candidatos.contains(simple)) candidatos.add(simple);
        } else {
            String base = imp.replace('.', File.separatorChar);
            candidatos.add(base + ".y");
            candidatos.add(base + ".z");
            String simpleY = new File(base).getName() + ".y";
            String simpleZ = new File(base).getName() + ".z";
            if (!candidatos.contains(simpleY)) candidatos.add(simpleY);
            if (!candidatos.contains(simpleZ)) candidatos.add(simpleZ);
        }

        for (String cand : candidatos) {
            String normCand = cand.replace(File.separatorChar, '/').toLowerCase();
            String fileCand = new File(cand).getName().toLowerCase();
            for (String ruta : proyecto.rutasXml) {
                String normRuta = ruta.replace(File.separatorChar, '/').toLowerCase();
                if (normRuta.equals(normCand) || normRuta.endsWith("/" + normCand)
                        || normRuta.equals(fileCand) || normRuta.endsWith("/" + fileCand)) {
                    File f = new File(proyecto.raiz, ruta);
                    if (f.isFile()) return f;
                    File g = new File(proyecto.raiz, new File(ruta).getName());
                    if (g.isFile()) return g;
                }
            }
        }

        List<File> bases = new ArrayList<>();
        if (archivoPig != null && archivoPig.getParentFile() != null) {
            bases.add(archivoPig.getParentFile());
        }
        if (proyecto.raiz != null && !bases.contains(proyecto.raiz)) {
            bases.add(proyecto.raiz);
        }
        for (File base : bases) {
            for (String cand : candidatos) {
                File f = new File(base, cand);
                if (f.isFile()) return f;
                File hallado = buscarRecursivo(base, new File(cand).getName());
                if (hallado != null) return hallado;
            }
        }
        return null;
    }

    private static File buscarRecursivo(File dir, String nombre) {
        if (dir == null || !dir.isDirectory()) return null;
        File[] kids = dir.listFiles();
        if (kids == null) return null;
        for (File k : kids) {
            if (k.isFile() && k.getName().equalsIgnoreCase(nombre)) return k;
        }
        for (File k : kids) {
            if (k.isDirectory()) {
                File h = buscarRecursivo(k, nombre);
                if (h != null) return h;
            }
        }
        return null;
    }
}

