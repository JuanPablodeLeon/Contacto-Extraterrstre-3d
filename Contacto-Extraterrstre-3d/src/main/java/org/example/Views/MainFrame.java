package org.example.Views;

import org.example.Ejecutor.CompiladorService;
import org.example.Ejecutor.ResultadoCompilacion;
import org.example.Views.dialogs.ReportDialogs;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    private final JTabbedPane editorTabs;
    private final ProjectExplorerPanel explorer;
    private final JTextArea consoleTextArea;
    private final JTextArea codigo3DireccionesTextArea;
    private final JTextArea codigoCTextArea;
    private final JTabbedPane tabbetPaneDown;
    private final MenuBar menuBar;
    private final ProjectManager projectManager;
    private final CompiladorService compilador = new CompiladorService();
    private ResultadoCompilacion lastResultado;

    private final Map<Component, File> tabFiles = new HashMap<>();

    public MainFrame(){

        setTitle("Contacto Extraterrestre 3D");
        setMinimumSize(new Dimension(600,400));
        setSize(new Dimension(1200,675));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        projectManager = new ProjectManager();
        editorTabs = new JTabbedPane();
        explorer = new ProjectExplorerPanel();
        explorer.setProjectManager(projectManager);
        consoleTextArea = new JTextArea();
        codigo3DireccionesTextArea = new JTextArea();
        codigoCTextArea = new JTextArea();

        tabbetPaneDown = new JTabbedPane();
        tabbetPaneDown.add("Consola", new JScrollPane(consoleTextArea));
        tabbetPaneDown.add("Codigo 3 Direciones", new JScrollPane(codigo3DireccionesTextArea));
        tabbetPaneDown.add("Codigo C", new JScrollPane(codigoCTextArea));
        cleanConsole();

        menuBar = new MenuBar();
        setJMenuBar(menuBar);
        add(new MainPanel(editorTabs, explorer, tabbetPaneDown));

        wireActions(menuBar);
        wireExplorer();
        wireTabs();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveAllOpenFiles();
            }
        });

        // Ctrl+S guarda todo
        KeyStroke ctrlS = KeyStroke.getKeyStroke("control S");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ctrlS, "saveAll");
        getRootPane().getActionMap().put("saveAll", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                saveAllOpenFiles();
            }
        });

        // Ctrl+W cierra la pestaña activa
        KeyStroke ctrlW = KeyStroke.getKeyStroke("control W");
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ctrlW, "closeTab");
        getRootPane().getActionMap().put("closeTab", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Component sel = editorTabs.getSelectedComponent();
                if (sel != null) {
                    closeTab(sel);
                }
            }
        });

        updateRunButtonState();
        setVisible(true);
        showWelcome();
    }

    private void wireActions(MenuBar menuBar) {
        menuBar.onRun(e -> run());
        menuBar.onClean(e -> cleanConsole());
        menuBar.onNew(e -> crearProyecto());
        menuBar.onOpenProject(e -> abrirProyecto());
        menuBar.onSave(e -> {
            saveAllOpenFiles();
            consoleTextArea.append("Archivos guardados.\n");
        });
        menuBar.onExit(e -> {
            saveAllOpenFiles();
            System.exit(0);
        });
        menuBar.onTokens(e -> showTokens());
        menuBar.onErrors(e -> errors());
        menuBar.onASTTree(e -> {
            Component current = editorTabs.getSelectedComponent();
            String codigo = current != null ? getEditorText(current) : "";
            if (codigo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese codigo primero");
                return;
            }
            mostrarArbolAST();
        });
        menuBar.onAbout(e -> JOptionPane.showMessageDialog(
                this,
                "Contacto Extraterrestre 3D\nVersión 1.0.0\nOLC2",
                "Acerca de",
                JOptionPane.INFORMATION_MESSAGE));
        menuBar.onSimbolos(e -> mostrarSimbolos());
        menuBar.onTresDir(e -> mostrarTresDirecciones());
        menuBar.onCodigoC(e -> mostrarCodigoC());
        menuBar.onGuardarC(e -> guardarCodigoC());
        menuBar.onCopyCodeC(e -> copiarCOdigoC());
    }

    private void wireExplorer() {
        explorer.setOnOpenFile(this::openFileInTab);
        explorer.setOnNewFile(this::promptNewFile);
        explorer.setOnRenameFile(this::promptRename);
        explorer.setOnNewFileIn(this::promptNewFileIn);
        explorer.setOnNewFolderIn(this::promptNewFolder);
        explorer.setOnDeleteFile(this::promptDelete);
    }

    private void wireTabs() {
        editorTabs.addChangeListener(e -> {
            if (projectManager.hasProject() && !tabFiles.isEmpty()) {
                saveAllOpenFilesQuiet();
            }
            updateRunButtonState();
        });

        editorTabs.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                handleTabMouse(e);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                handleTabMouse(e);
            }

            private void handleTabMouse(java.awt.event.MouseEvent e) {
                int idx = editorTabs.indexAtLocation(e.getX(), e.getY());
                if (idx < 0) {
                    return;
                }
                // Clic medio: cerrar directamente
                if (e.getButton() == java.awt.event.MouseEvent.BUTTON2) {
                    closeTab(editorTabs.getComponentAt(idx));
                    return;
                }
                if (e.isPopupTrigger()) {
                    editorTabs.setSelectedIndex(idx);
                    showTabPopup(e.getX(), e.getY(), editorTabs.getComponentAt(idx));
                }
            }
        });
    }

    private void showWelcome() {
        JOptionPane.showMessageDialog(
                this,
                "¡Bienvenido a Contacto Extraterrestre 3D!\n\n"
                        + "• Usa Archivo > Nuevo proyecto para crear tu carpeta de proyecto\n"
                        + "  o Archivo > Abrir proyecto para cargar uno existente.\n"
                        + "• Se generarán PigLatin.pig, YFile.y y Zetariano.z.\n"
                        + "• Explora tus archivos en el árbol de la izquierda.\n"
                        + "• Clic derecho: nuevo archivo / nueva subcarpeta / renombrar / eliminar.\n"
                        + "• Puedes cerrar pestañas con la X, clic medio, Ctrl+W o clic derecho.\n"
                        + "• El botón Ejecutar solo está disponible en archivos .pig\n"
                        + "  (los .y/.z se resuelven como imports vía proyecto.xml).",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void copiarCOdigoC(){
        if (tabbetPaneDown.getSelectedIndex() != 2){
           JOptionPane.showMessageDialog(this, "Cambia a la pestaña Codigo C", "Copiar C", JOptionPane.WARNING_MESSAGE);
         //  tabbetPaneDown.setSelectedIndex(2);
           return;
        }

        if (lastResultado == null || !lastResultado.tieneTraduccion()) {
            JOptionPane.showMessageDialog(this,
                    "Primero ejecuta un programa sin errores.",
                    "Copiar C", JOptionPane.WARNING_MESSAGE);
            return;
        }

        codigoCTextArea.selectAll();
        codigoCTextArea.copy();
        JOptionPane.showMessageDialog(this, "Codigo C copiado", "Codigo C", JOptionPane.INFORMATION_MESSAGE);
    }
    private void crearProyecto() {
        String nombre = JOptionPane.showInputDialog(
                this,
                "Nombre del proyecto:",
                "Nuevo proyecto",
                JOptionPane.QUESTION_MESSAGE);
        if (nombre == null || nombre.trim().isEmpty()) {
            return;
        }
        nombre = nombre.trim();
        if (nombre.matches(".*[/\\\\:<>\":|?*].*")) {
            JOptionPane.showMessageDialog(this,
                    "El nombre contiene caracteres no válidos ( / \\ : < > \" | ? * ).",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Elige dónde crear la carpeta del proyecto");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        try {
            projectManager.createProject(chooser.getSelectedFile(), nombre);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo crear el proyecto:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Limpiar pestañas anteriores
        editorTabs.removeAll();
        tabFiles.clear();
        explorer.refresh();

        // Abrir los 3 archivos iniciales en pestañas
        for (File f : projectManager.listProjectFilesRecursive()) {
            openFileInTab(f);
        }
        selectPglTab();

        cleanConsole();
        consoleTextArea.append("Proyecto '" + projectManager.getProjectName()
                + "' creado en: " + projectManager.getProjectDir().getAbsolutePath() + "\n");
        consoleTextArea.append("Archivos: PigLatin.pig, YFile.y, Zetariano.z\n");
        consoleTextArea.append("Control XML: " + projectManager.getXmlFile().getAbsolutePath() + "\n");
        setTitle("Contacto Extraterrestre 3D - " + projectManager.getProjectName());
        updateRunButtonState();
    }

    private void abrirProyecto() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Selecciona la carpeta del proyecto");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File dir = chooser.getSelectedFile();
        if (dir == null || !dir.isDirectory()) {
            return;
        }
        // Validación suave: avisar si no parece un proyecto del IDE
        File[] controlados = dir.listFiles((d, name)
                -> name.endsWith(ProjectManager.EXT_PGL)
                || name.endsWith(ProjectManager.EXT_Y)
                || name.endsWith(ProjectManager.EXT_Z));
        File xml = new File(dir, ProjectManager.XML_NAME);
        if ((controlados == null || controlados.length == 0) && !xml.exists()) {
            int opt = JOptionPane.showConfirmDialog(this,
                    "La carpeta no contiene archivos .pig / .y / .z ni proyecto.xml.\n¿Abrirla de todos modos?",
                    "Abrir proyecto",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (opt != JOptionPane.YES_OPTION) {
                return;
            }
        }

        try {
            saveAllOpenFilesQuiet();
            projectManager.openProject(dir);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo abrir el proyecto:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        editorTabs.removeAll();
        tabFiles.clear();
        explorer.refresh();

        for (File f : projectManager.listProjectFilesRecursive()) {
            openFileInTab(f);
        }
        selectPglTab();

        cleanConsole();
        consoleTextArea.append("Proyecto '" + projectManager.getProjectName()
                + "' cargado desde: " + projectManager.getProjectDir().getAbsolutePath() + "\n");
        consoleTextArea.append("Archivos: " + projectManager.listProjectFilesRecursive().size() + "\n");
        consoleTextArea.append("Control XML: " + projectManager.getXmlFile().getAbsolutePath() + "\n");
        setTitle("Contacto Extraterrestre 3D - " + projectManager.getProjectName());
        updateRunButtonState();
    }

    public void openFileInTab(File file) {
        if (file == null || !file.isFile()) {
            return;
        }
        for (Map.Entry<Component, File> entry : tabFiles.entrySet()) {
            try {
                if (entry.getValue().getCanonicalPath().equals(file.getCanonicalPath())) {
                    editorTabs.setSelectedComponent(entry.getKey());
                    return;
                }
            } catch (Exception ignored) {
            }
        }

        String ext = ProjectManager.getExtension(file.getName()).toLowerCase();
        Component editor;
        switch (ext) {
            case ".pig" -> editor = new PigLatinEditor();
            case ".y" -> editor = new YEditor();
            case ".z" -> editor = new ZetarianoEditor();
            default -> {
                JOptionPane.showMessageDialog(this,
                        "Extensión no soportada: " + ext + "\nSolo .pig, .y, .z",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        try {
            String content = Files.readString(file.toPath(), StandardCharsets.UTF_8);
            setEditorText(editor, content);
            editorTabs.addTab(file.getName(), editor);
            int idx = editorTabs.getTabCount() - 1;
            editorTabs.setToolTipTextAt(idx, file.getAbsolutePath());
            editorTabs.setTabComponentAt(idx, createTabHeader(editor, file.getName()));
            tabFiles.put(editor, file);
            editorTabs.setSelectedComponent(editor);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo abrir el archivo:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        updateRunButtonState();
    }

    private void promptNewFile(String extension) {
        promptNewFileIn(projectManager.hasProject() ? projectManager.getProjectDir() : null, extension);
    }

    private void promptNewFileIn(File directory, String extension) {
        if (!projectManager.hasProject()) {
            JOptionPane.showMessageDialog(this, "Primero crea un proyecto.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (directory == null) directory = projectManager.getProjectDir();
        String base = JOptionPane.showInputDialog(
                this,
                "Nombre para el nuevo archivo (" + extension + ") en:\n" + directory.getAbsolutePath(),
                "Nuevo archivo " + extension,
                JOptionPane.QUESTION_MESSAGE);
        if (base == null || base.trim().isEmpty()) {
            return;
        }
        try {
            File created = projectManager.createFile(directory, base.trim(), extension);
            explorer.refresh();
            openFileInTab(created);
            consoleTextArea.append("Archivo creado: " + projectManager.relativePath(created) + "\n");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo crear el archivo:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void promptNewFolder(File parentDir) {
        if (!projectManager.hasProject()) {
            JOptionPane.showMessageDialog(this, "Primero crea un proyecto.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (parentDir == null) parentDir = projectManager.getProjectDir();
        String base = JOptionPane.showInputDialog(
                this,
                "Nombre de la subcarpeta en:\n" + parentDir.getAbsolutePath(),
                "Nueva subcarpeta",
                JOptionPane.QUESTION_MESSAGE);
        if (base == null || base.trim().isEmpty()) {
            return;
        }
        try {
            File created = projectManager.createFolder(parentDir, base.trim());
            explorer.refresh();
            consoleTextArea.append("Subcarpeta creada: " + projectManager.relativePath(created) + "\n");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo crear la subcarpeta:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void promptDelete(File target) {
        if (target == null) return;
        int opt = JOptionPane.showConfirmDialog(this,
                "¿Eliminar '" + target.getName() + "'?" + (target.isDirectory() ? "\nSe eliminará todo su contenido." : ""),
                "Eliminar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (opt != JOptionPane.YES_OPTION) return;
        try {
            Component tab = findTabForFile(target);
            if (tab != null) {
                editorTabs.remove(tab);
                tabFiles.remove(tab);
            } else if (target.isDirectory()) {
                // cerrar pestañas dentro de la carpeta eliminada
                for (Component c : tabFiles.keySet().toArray(new Component[0])) {
                    File f = tabFiles.get(c);
                    if (f != null && f.getAbsolutePath().startsWith(target.getAbsolutePath() + File.separator)) {
                        editorTabs.remove(c);
                        tabFiles.remove(c);
                    }
                }
            }
            projectManager.delete(target);
            explorer.refresh();
            consoleTextArea.append("Eliminado: " + target.getName() + "\n");
            updateRunButtonState();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo eliminar:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Clic derecho > Renombrar sobre un archivo o carpeta existente. */
    private void promptRename(File file) {
        if (file == null) {
            return;
        }
        String nuevo = (String) JOptionPane.showInputDialog(
                this,
                "Nuevo nombre:",
                "Renombrar archivo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                file.getName());
        if (nuevo == null || nuevo.trim().isEmpty() || nuevo.trim().equals(file.getName())) {
            return;
        }
        try {
            if (file.isFile()) {
                // Guardar contenido en memoria antes de mover en disco
                Component tab = findTabForFile(file);
                if (tab != null) {
                    Files.writeString(file.toPath(), getEditorText(tab), StandardCharsets.UTF_8);
                }
                File renamed = projectManager.renameFile(file, nuevo.trim());
                if (tab != null) {
                    tabFiles.put(tab, renamed);
                    int idx = editorTabs.indexOfComponent(tab);
                    if (idx >= 0) {
                        editorTabs.setTitleAt(idx, renamed.getName());
                        editorTabs.setToolTipTextAt(idx, renamed.getAbsolutePath());
                        updateTabHeaderTitle(idx, renamed.getName());
                    }
                }
                consoleTextArea.append("Renombrado: " + file.getName() + " -> " + renamed.getName() + "\n");
            } else {
                File renamed = projectManager.renameFile(file, nuevo.trim());
                // re-mapear pestañas dentro de la carpeta
                String oldBase = file.getAbsolutePath();
                String newBase = renamed.getAbsolutePath();
                for (Map.Entry<Component, File> e : tabFiles.entrySet()) {
                    String p = e.getValue().getAbsolutePath();
                    if (p.equals(oldBase) || p.startsWith(oldBase + File.separator)) {
                        File nf = new File(newBase + p.substring(oldBase.length()));
                        e.setValue(nf);
                        int idx = editorTabs.indexOfComponent(e.getKey());
                        if (idx >= 0) {
                            editorTabs.setToolTipTextAt(idx, nf.getAbsolutePath());
                        }
                    }
                }
                consoleTextArea.append("Carpeta renombrada: " + file.getName() + " -> " + renamed.getName() + "\n");
            }
            explorer.refresh();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo renombrar:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Component findTabForFile(File file) {
        try {
            String wanted = file.getCanonicalPath();
            for (Map.Entry<Component, File> e : tabFiles.entrySet()) {
                if (e.getValue().getCanonicalPath().equals(wanted)) {
                    return e.getKey();
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    private void selectPglTab() {
        for (int i = 0; i < editorTabs.getTabCount(); i++) {
            if (editorTabs.getComponentAt(i) instanceof PigLatinEditor) {
                editorTabs.setSelectedIndex(i);
                return;
            }
        }
    }

    private Component createTabHeader(Component editor, String title) {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        header.setOpaque(false);
        JLabel label = new JLabel(title);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        JButton closeBtn = new JButton("x");
        closeBtn.setMargin(new Insets(0, 4, 0, 4));
        closeBtn.setFocusable(false);
        closeBtn.setBorderPainted(false);
        closeBtn.setContentAreaFilled(false);
        closeBtn.setToolTipText("Cerrar (Ctrl+W)");
        closeBtn.addActionListener(e -> closeTab(editor));
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                closeBtn.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                closeBtn.setContentAreaFilled(false);
            }
        });
        header.add(label);
        header.add(closeBtn);
        return header;
    }

    private void updateTabHeaderTitle(int idx, String title) {
        Component header = editorTabs.getTabComponentAt(idx);
        if (header instanceof JPanel panel) {
            for (Component c : panel.getComponents()) {
                if (c instanceof JLabel label) {
                    label.setText(title);
                    break;
                }
            }
        }
    }

    private void showTabPopup(int x, int y, Component target) {
        JPopupMenu popup = new JPopupMenu();
        JMenuItem cerrar = new JMenuItem("Cerrar");
        JMenuItem cerrarOtras = new JMenuItem("Cerrar otras");
        JMenuItem cerrarTodas = new JMenuItem("Cerrar todas");
        cerrar.addActionListener(e -> closeTab(target));
        cerrarOtras.addActionListener(e -> closeOtherTabs(target));
        cerrarTodas.addActionListener(e -> closeAllTabs());
        popup.add(cerrar);
        popup.add(cerrarOtras);
        popup.add(cerrarTodas);
        popup.show(editorTabs, x, y);
    }

    public void closeTab(Component editor) {
        if (editor == null || !tabFiles.containsKey(editor)) {
            return;
        }
        saveSingleTab(editor);
        editorTabs.remove(editor);
        tabFiles.remove(editor);
        updateRunButtonState();
    }

    public void closeOtherTabs(Component keep) {
        for (Component c : tabFiles.keySet().toArray(new Component[0])) {
            if (c != keep) {
                closeTab(c);
            }
        }
    }

    public void closeAllTabs() {
        for (Component c : tabFiles.keySet().toArray(new Component[0])) {
            closeTab(c);
        }
    }

    private void saveSingleTab(Component editor) {
        File f = tabFiles.get(editor);
        if (f == null) {
            return;
        }
        try {
            Files.writeString(f.toPath(), getEditorText(editor), StandardCharsets.UTF_8);
        } catch (Exception ignored) {
        }
    }

    public void saveAllOpenFiles() {
        try {
            saveAllOpenFilesQuiet();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveAllOpenFilesQuiet() {
        for (Map.Entry<Component, File> e : tabFiles.entrySet()) {
            try {
                Files.writeString(e.getValue().toPath(), getEditorText(e.getKey()), StandardCharsets.UTF_8);
            } catch (Exception ignored) {
            }
        }
        if (projectManager.hasProject()) {
            try {
                projectManager.writeXml();
            } catch (Exception ignored) {
            }
        }
    }

    private static String getEditorText(Component editor) {
        if (editor instanceof PigLatinEditor ep) {
            return ep.getText();
        }
        if (editor instanceof YEditor ye) {
            return ye.getText();
        }
        if (editor instanceof ZetarianoEditor ze) {
            return ze.getText();
        }
        return "";
    }

    private static void setEditorText(Component editor, String text) {
        if (editor instanceof PigLatinEditor ep) {
            ep.setText(text);
        } else if (editor instanceof YEditor ye) {
            ye.setText(text);
        } else if (editor instanceof ZetarianoEditor ze) {
            ze.setText(text);
        }
    }



    private void cleanConsole() {
        consoleTextArea.setText("CONSOLA  -  Codex Latinus \n\n");
        codigo3DireccionesTextArea.setText("CODIGO 3 DIRECCIONES\n\n");
        codigoCTextArea.setText("CODIGO C\n\n");
    }

    private void updateRunButtonState() {
        Component sel = editorTabs.getSelectedComponent();
        boolean soloPig = sel instanceof PigLatinEditor;
        menuBar.setRunEnabled(soloPig);
        if (soloPig) {
            menuBar.getRunButton().setToolTipText("Ejecutar .pig (valida imports .y/.z vía proyecto.xml y genera C3D + C)");
        } else {
            menuBar.getRunButton().setToolTipText("Solo disponible en archivos .pig");
        }
    }

    public Component getCurrentEditor() {
        return editorTabs.getSelectedComponent();
    }

    public PigLatinEditor getCurrentPglEditor() {
        Component sel = editorTabs.getSelectedComponent();
        return sel instanceof PigLatinEditor ep ? ep : null;
    }

    public JTextArea getConsoleTextArea() {
        return consoleTextArea;
    }

    public JTextArea getCodigo3DireccionesTextArea() {
        return codigo3DireccionesTextArea;
    }

    public JTextArea getCodigoCTextArea() {
        return codigoCTextArea;
    }

    public JTabbedPane getTabbetPaneDown() {
        return tabbetPaneDown;
    }

    public JTabbedPane getEditorTabs() {
        return editorTabs;
    }

    public ProjectExplorerPanel getExplorer() {
        return explorer;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    private void run() {
        Component current = editorTabs.getSelectedComponent();
        if (current == null) {
            JOptionPane.showMessageDialog(this,
                    "No hay ningún archivo abierto.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        File file = tabFiles.get(current);
        if (file == null) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo identificar el archivo de la pestaña activa.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!file.getName().toLowerCase().endsWith(".pig")) {
            JOptionPane.showMessageDialog(this,
                    "La ejecución solo está disponible para archivos .pig.\n"
                            + "Los .y/.z se validan como imports desde el .pig principal.",
                    "Solo .pig", JOptionPane.WARNING_MESSAGE);
            return;
        }
        saveAllOpenFilesQuiet();
        String contenido = getEditorText(current);
        if (contenido.trim().isEmpty()) {
            cleanConsole();
            consoleTextArea.append("Campo vacío: no hay código para ejecutar.\n");
            tabbetPaneDown.setSelectedIndex(0);
            return;
        }
        cleanConsole();
        try {
            lastResultado = compilador.compilar(file, contenido);
            consoleTextArea.append(lastResultado.getConsola());
            if (lastResultado.isExitoso()) {
                codigo3DireccionesTextArea.setText("CODIGO 3 DIRECCIONES (" + lastResultado.getLenguaje() + ")\n\n"
                        + lastResultado.getCodigo3D());
                codigoCTextArea.setText(lastResultado.getCodigoC());
            } else {
                consoleTextArea.append("Revisa Reportes > Reporte de errores.\n");
                codigo3DireccionesTextArea.setText("CODIGO 3 DIRECCIONES\n\n(sin traducción: hay errores)");
                codigoCTextArea.setText("CODIGO C\n\n(sin traducción: hay errores)");
            }
        } catch (Exception ex) {
            consoleTextArea.append("✖ Error inesperado al ejecutar: " + ex.getMessage() + "\n");
        }
        tabbetPaneDown.setSelectedIndex(0);
        consoleTextArea.setCaretPosition(consoleTextArea.getDocument().getLength());
        current.requestFocus();
    }

    private void errors() {
        if (lastResultado == null) {
            JOptionPane.showMessageDialog(this,
                    "Primero ejecuta el código.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        ReportDialogs.showErrors(this, lastResultado.getErrores());
    }

    private void showTokens() {
        if (lastResultado == null || lastResultado.getTokens().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Primero ejecuta un programa para generar los tokens.",
                    "Reporte de tokens",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        ReportDialogs.showTokens(this, lastResultado.getTokens(),
                lastResultado.getLenguaje());
    }

    private void mostrarArbolAST() {
        JOptionPane.showMessageDialog(this,
                "El árbol AST gráfico estará disponible en el Proyecto 2.\n"
                        + "De momento usa Reportes > Reporte de tokens para inspeccionar el análisis léxico.",
                "Árbol AST",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean exigirTraduccion(String titulo) {
        if (lastResultado == null || !lastResultado.tieneTraduccion()) {
            JOptionPane.showMessageDialog(this,
                    "Primero ejecuta un programa SIN errores.\nSolo entonces se generan las cuartetas y el código C.",
                    titulo,
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void mostrarSimbolos() {
        if (!exigirTraduccion("Tabla de símbolos")) return;
        tabbetPaneDown.setSelectedIndex(1);
        JOptionPane.showMessageDialog(this,
                "Cuartetas: " + lastResultado.getCuartetas().size()
                        + " | Variables detectadas en la traducción.\n"
                        + "Ver pestaña 'Codigo 3 Direciones' para el detalle.",
                "Tabla de símbolos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarTresDirecciones() {
        if (!exigirTraduccion("Código 3 direcciones")) return;
        tabbetPaneDown.setSelectedIndex(1);
    }

    private void mostrarCodigoC() {
        if (!exigirTraduccion("Código C")) return;
        tabbetPaneDown.setSelectedIndex(2);
    }

    private void guardarCodigoC() {
        if (!exigirTraduccion("Guardar C")) return;
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Código C (.c)", "c"));
        fc.setSelectedFile(new File("salida.c"));
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            if (!f.getName().toLowerCase().endsWith(".c")) {
                f = new File(f.getParentFile(), f.getName() + ".c");
            }
            try (FileWriter w = new FileWriter(f)) {
                w.write(lastResultado.getCodigoC());
                JOptionPane.showMessageDialog(this,
                        "Código C guardado en:\n" + f.getAbsolutePath() + "\n\nCompilar con:  gcc " + f.getName() + " -o salida",
                        "Guardar C",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

