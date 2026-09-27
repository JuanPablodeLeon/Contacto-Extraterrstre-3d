package org.example.Views;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class ProjectManager {

    public static final String EXT_PGL = ".pig";
    public static final String EXT_Y = ".y";
    public static final String EXT_Z = ".z";
    public static final String XML_NAME = "proyecto.xml";

    public static final String DEFAULT_PIG = "PigLatin.pig";
    public static final String DEFAULT_Y = "YFile.y";
    public static final String DEFAULT_Z = "Zetariano.z";

    private File projectDir;
    private String projectName;
    private String rootTag;

    public ProjectManager(){
    }

    public void createProject(File parentDir, String projectName) throws IOException{
        if (parentDir == null || projectName == null || projectName.trim().isEmpty()) throw new IOException("Nombre del proyecto no es valido");

        this.projectName = projectName.trim();
        this.rootTag = sanitizeTag(this.projectName);
        this.projectDir = new File(parentDir, this.projectName);
        if (projectDir.exists())  throw new IOException("Existe una carpeta con el mismo nombre: "+projectDir.getAbsolutePath());

        if (!projectDir.mkdirs()) throw new IOException("No se pudo crear el proyecto");

        createEmptyFile(new File(projectDir, DEFAULT_PIG));
        createEmptyFile(new File(projectDir, DEFAULT_Y));
        createEmptyFile(new File(projectDir, DEFAULT_Z));
        writeXml();
    }

    public void loadProyect(File projectDir, String projectName){
        this.projectDir = projectDir;
        this.projectName = projectName;
        this.rootTag = sanitizeTag(projectName);
    }

    public void openProject(File projectDir) throws IOException{
        if ( projectDir == null || !projectDir.isDirectory()) throw new IOException("La carpera no es valida");

        this.projectDir = projectDir;
        this.projectName = projectDir.getName();
        this.rootTag = sanitizeTag(this.projectName);
        writeXml();
    }

    public void writeXml() throws IOException{
        assertProjectOpen();
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element root = doc.createElement(rootTag);
            root.setAttribute("nombre", projectName);
            doc.appendChild(root);
            for (File f : listProjectFilesRecursive()) {
                Element e = doc.createElement("archivo");
                e.setAttribute("ruta", relativePath(f));
                e.setTextContent(f.getName());
                root.appendChild(e);
            }
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            t.transform(new DOMSource(doc), new StreamResult(getXmlFile()));

        } catch (Exception ex) {
            throw new IOException("No se pudo escribir el XML del proyecto: "+ex.getMessage(), ex);
        }
    }

    public File createFile(String baseName, String extension) throws IOException{
        assertProjectOpen();
        return createFile(projectDir, baseName, extension);
    }

    /** Crea un archivo dentro de una subcarpeta del proyecto (nuevo: subcarpetas). */
    public File createFile(File directory, String baseName, String extension) throws IOException{
        assertProjectOpen();
        if (directory == null) directory = projectDir;
        if (!isInsideProject(directory) && !directory.equals(projectDir)) {
            throw new IOException("La carpeta no pertenece al proyecto");
        }
        if (!directory.isDirectory()) throw new IOException("La carpeta no es válida");
        if (!extension.startsWith(".")) extension = "."+extension;

        String name = baseName.trim();
        if (!name.endsWith(extension)){
            name = name+extension;
        }
        if (name.contains("/") || name.contains("\\")) throw new IOException("El nombre no debe contener rutas");
        File f = new File(directory, name);
        if (f.exists()) throw new IOException("Existe archivo con ese nombre: "+name);

        Files.writeString(f.toPath(), initialContentZFile(f), StandardCharsets.UTF_8);
        writeXml();
        return f;
    }

    /** Crea una subcarpeta dentro del proyecto (o dentro de otra subcarpeta). */
    public File createFolder(File parent, String name) throws IOException {
        assertProjectOpen();
        if (parent == null) parent = projectDir;
        if (!parent.isDirectory()) throw new IOException("La carpeta padre no es válida");
        name = name == null ? "" : name.trim();
        if (name.isEmpty() || name.contains("/") || name.contains("\\") || name.equals(".") || name.equals("..")) {
            throw new IOException("Nombre de carpeta inválido");
        }
        File dir = new File(parent, name);
        if (dir.exists()) throw new IOException("Ya existe: " + name);
        if (!dir.mkdirs()) throw new IOException("No se pudo crear la carpeta");
        writeXml();
        return dir;
    }

    /** Elimina un archivo o carpeta (recursivo) del proyecto. */
    public void delete(File target) throws IOException {
        assertProjectOpen();
        if (target == null || !isInsideProject(target)) throw new IOException("Fuera del proyecto");
        if (target.equals(projectDir)) throw new IOException("No se puede eliminar la raíz");
        deleteRecursive(target);
        writeXml();
    }

    private void deleteRecursive(File f) throws IOException {
        if (f.isDirectory()) {
            File[] kids = f.listFiles();
            if (kids != null) for (File k : kids) deleteRecursive(k);
        }
        if (!f.delete()) throw new IOException("No se pudo eliminar: " + f.getName());
    }

    public boolean isInsideProject(File f) {
        try {
            String root = projectDir.getCanonicalPath();
            String path = f.getCanonicalPath();
            return path.equals(root) || path.startsWith(root + File.separator);
        } catch (Exception e) {
            return false;
        }
    }

    /** Ruta relativa al proyecto (para el XML y el árbol). */
    public String relativePath(File f) {
        try {
            String root = projectDir.getCanonicalPath();
            String path = f.getCanonicalPath();
            if (path.equals(root)) return ".";
            if (path.startsWith(root + File.separator)) return path.substring(root.length() + 1);
        } catch (Exception ignored) {
        }
        return f.getName();
    }

    public File renameFile(File oldFile, String newName) throws IOException{
        assertProjectOpen();
        newName = newName.trim();

        if (newName.isEmpty() || newName.contains("/") || newName.contains("\\")) throw new IOException("Nombre invalido");

        String oldExt = getExtension(oldFile.getName());
        if (!oldExt.isEmpty() && oldFile.isFile() && !newName.contains(".")) newName = newName + oldExt;

        File dest = new File(oldFile.getParentFile(), newName);
        if(dest.exists()) throw new IOException("Existe  archivo con ese nombre: "+newName);

        Files.move(oldFile.toPath(), dest.toPath());
        writeXml();
        return dest;
    }

    public static String getExtension(String name) {
        int dot = name.lastIndexOf('.');
        if (dot < 0) return "";
        return name.substring(dot);
    }

    //Enlista los archivos de los lenguajes por orden de nombre
    public List<File> listProjectFiles() {
        List<File> out = new ArrayList<>();
        if (projectDir == null || !projectDir.isDirectory()) return out;

        File[] files = projectDir.listFiles((dir, name) -> name.endsWith(EXT_PGL) || name.endsWith(EXT_Y) || name.endsWith(EXT_Z));
        if (files != null){
            Arrays.sort(files, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));
            out.addAll(Arrays.asList(files));
        }
        return out;
    }

    /** Listado recursivo (incluye subcarpetas) de .pig/.y/.z ordenados por ruta. */
    public List<File> listProjectFilesRecursive() {
        List<File> out = new ArrayList<>();
        if (projectDir == null || !projectDir.isDirectory()) return out;
        collectRecursive(projectDir, out);
        out.sort(Comparator.comparing(this::relativePath, String.CASE_INSENSITIVE_ORDER));
        return out;
    }

    private void collectRecursive(File dir, List<File> out) {
        File[] kids = dir.listFiles();
        if (kids == null) return;
        Arrays.sort(kids, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));
        for (File k : kids) {
            if (k.isDirectory()) {
                collectRecursive(k, out);
            } else {
                String n = k.getName();
                if (n.endsWith(EXT_PGL) || n.endsWith(EXT_Y) || n.endsWith(EXT_Z)) out.add(k);
            }
        }
    }

    public List<String> readXmlEntries(){
        List<String> out = new ArrayList<>();
        try {
            File xml = getXmlFile();
            if (xml == null || !xml.exists()) return out;

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xml);
            NodeList nodes = doc.getElementsByTagName("archivo");
            for (int i = 0; i < nodes.getLength(); i++) {
                out.add(nodes.item(i).getTextContent().trim());
            }
        } catch (Exception e) {
        }
        return out;
    }

    private void assertProjectOpen() throws IOException{
        if (projectDir == null || projectName == null) throw new IOException("No hay ningun proyecto abierto");
    }

    private void createEmptyFile(File file) throws  IOException{
        if (!file.exists()) Files.writeString(file.toPath(), initialContentZFile(file), StandardCharsets.UTF_8);
    }

    private String sanitizeTag(String name) {
        if (name == null || name.trim().isEmpty()) return "proyecto";

        String s = name.trim().replaceAll("\\s", "_").replaceAll("[^A-Za-z0-9_\\-\\.]", "_");
        if (s.isEmpty()) return "proyecto";

        char first = s.charAt(0);
        if (!(Character.isLetter(first) || first == '_')) s = "_" +s;

        return s;
    }

    public File getProjectDir() {
        return projectDir;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getRootTag() {
        return rootTag;
    }

    public File getXmlFile(){
        if (projectDir == null) return null;

        return new File(projectDir, XML_NAME);
    }

    public boolean hasProject(){
        return projectDir != null && projectDir.isDirectory();
    }

    private static String initialContentZFile(File f){
        String name = f.getName();
        if (name.toLowerCase().endsWith(EXT_Z)){
            name = name.substring(0,name.length() - 2 );
            return "public class "+ name + "{\n\n\n}";
        }
        return "";
    }
}
