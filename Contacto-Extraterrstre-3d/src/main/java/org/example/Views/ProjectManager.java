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
            for (File f : listProjectFiles()) {
                Element e = doc.createElement("archivo");
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
        if (!extension.startsWith(".")) extension = "."+extension;

        String name = baseName.trim();
        if (name.endsWith(extension)){

        }else {
            name = name+extension;
        }
        File f = new File(projectDir, name);
        if (f.exists()) throw new IOException("Existe archivo con ese nombre: "+name);

        Files.writeString(f.toPath(), initialContentZFile(f), StandardCharsets.UTF_8);
        writeXml();
        return f;
    }

    public File renameFile(File oldFile, String newName) throws IOException{
        assertProjectOpen();
        newName = newName.trim();

        if (newName.isEmpty()) throw new IOException("Nombre invalido");

        String oldExt = getExtension(oldFile.getName());
        if (!oldExt.isEmpty() && !newName.contains(".")) newName = newName + oldExt;

        File dest = new File(projectDir, newName);
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
