package org.example.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ProjectExplorerPanel extends JPanel {
    private final JTree tree;
    private final DefaultTreeModel treeMododel;
    private final DefaultMutableTreeNode rootNode;
    private final JLabel titleLabel;

    private ProjectManager projectManager;
    private Consumer<File> onOpenFile;
    private Consumer<String> onNewFile;
    private Consumer<File> onRenameFile;
    private BiConsumer<File, String> onNewFileIn;
    private Consumer<File> onNewFolderIn;
    private Consumer<File> onDeleteFile;

    public ProjectExplorerPanel(){
        setLayout(new BorderLayout());

        titleLabel = new JLabel(" Explorador de Proyecto");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 12f));
        add(titleLabel, BorderLayout.NORTH);

        rootNode = new DefaultMutableTreeNode("Sin Proyecto");
        treeMododel = new DefaultTreeModel(rootNode);
        tree = new JTree(treeMododel);
        tree.setRootVisible(true);
        tree.setShowsRootHandles(true);
        add(new JScrollPane(tree), BorderLayout.CENTER);

        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && onOpenFile != null){
                    File f = getFileAt(e.getX(), e.getY());
                    if (f != null && f.isFile()) onOpenFile.accept(f);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
            }

            private void maybeShowPopup(MouseEvent e){
                if (!e.isPopupTrigger() || projectManager == null || !projectManager.hasProject()) return;

                TreePath path = tree.getPathForLocation(e.getX(), e.getY());
                if (path != null){
                    tree.setSelectionPath(path);
                } else{
                    tree.setSelectionPath(new TreePath(rootNode.getPath()));
                }
                File target = getFileAt(e.getX(), e.getY());
                showPopUp(e.getX(), e.getY(), target);
            }
        });

    }

    public File getSelectedFile(){
        TreePath path = tree.getSelectionPath();
        if (path == null) return null;

        Object last = ((DefaultMutableTreeNode) path.getLastPathComponent()).getUserObject();
        if (last instanceof FileNode fn && !fn.isDirectory()) return fn.file();

        return null;
    }

    public File getSelectedDirectory() {
        TreePath path = tree.getSelectionPath();
        if (path != null) {
            Object last = ((DefaultMutableTreeNode) path.getLastPathComponent()).getUserObject();
            if (last instanceof FileNode fn) {
                if (fn.isDirectory()) return fn.file();
                File parent = fn.file().getParentFile();
                if (parent != null) return parent;
            }
        }
        if (projectManager != null && projectManager.hasProject()) {
            return projectManager.getProjectDir();
        }
        return null;
    }

    private record FileNode(String name, File file, boolean isDirectory){
        @Override
        public String toString(){
            return name;
        }
    }

    private void showPopUp(int x, int y, File target){
        JPopupMenu popup = new JPopupMenu();
        File destDir = (target != null && target.isDirectory()) ? target : getSelectedDirectory();

        JMenu nuevoMenu = new JMenu("Nuevo archivo aquí");

        JMenuItem pigItem = new JMenuItem("Archivo PigLatin (.pig)");
        JMenuItem yItem = new JMenuItem("Archivo Y? (.y)");
        JMenuItem zItem = new JMenuItem("Archivo Zetariano (.z)");
        pigItem.addActionListener(e -> fireNewFile(destDir, ProjectManager.EXT_PGL));
        yItem.addActionListener(e -> fireNewFile(destDir, ProjectManager.EXT_Y));
        zItem.addActionListener(e -> fireNewFile(destDir, ProjectManager.EXT_Z));

        nuevoMenu.add(pigItem);
        nuevoMenu.add(yItem);
        nuevoMenu.add(zItem);
        popup.add(nuevoMenu);

        JMenuItem folderItem = new JMenuItem("Nueva subcarpeta aquí");
        folderItem.addActionListener(e -> {
            if (onNewFolderIn != null) onNewFolderIn.accept(destDir);
            else if (destDir != null) {
                String n = JOptionPane.showInputDialog(tree, "Nombre de la subcarpeta:",
                        "Nueva subcarpeta", JOptionPane.QUESTION_MESSAGE);
                if (n != null && !n.trim().isEmpty()) {
                    try {
                        projectManager.createFolder(destDir, n.trim());
                        refresh();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(tree, "No se pudo crear:\n" + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        popup.add(folderItem);

        if (target != null){
            popup.addSeparator();

            if (target.isFile()) {
                JMenuItem abrirItem = new JMenuItem("Abrir");
                abrirItem.addActionListener(e ->{
                    if (onOpenFile != null) onOpenFile.accept(target);
                });
                popup.add(abrirItem);
            }

            JMenuItem renameItem = new JMenuItem("Renombrar");
            renameItem.addActionListener(e ->{
                if (onRenameFile != null) onRenameFile.accept(target);
            });

            JMenuItem deleteItem = new JMenuItem("Eliminar");
            deleteItem.addActionListener(e -> {
                if (onDeleteFile != null) onDeleteFile.accept(target);
            });

            popup.add(renameItem);
            popup.add(deleteItem);
        }
        popup.show(tree, x, y);
    }

    private void fireNewFile(File destDir, String ext) {
        if (onNewFileIn != null && destDir != null) {
            onNewFileIn.accept(destDir, ext);
        } else if (onNewFile != null) {
            onNewFile.accept(ext);
        }
    }

    public void setProjectManager(ProjectManager pm){
        this.projectManager = pm;
        refresh();
    }

    public void refresh(){
        rootNode.removeAllChildren();

        if (projectManager == null || !projectManager.hasProject()){
            rootNode.setUserObject("Sin proyecto");
            treeMododel.reload();
            expandRoot();
            return;
        }
        File dir = projectManager.getProjectDir();
        rootNode.setUserObject(new FileNode(projectManager.getProjectName(), dir, true));
        addDirectoryRecursive(rootNode, dir);
        treeMododel.reload();
        expandRoot();
    }

    private void addDirectoryRecursive(DefaultMutableTreeNode parent, File dir) {
        File[] kids = dir.listFiles();
        if (kids == null) return;
        Arrays.sort(kids, Comparator.comparing(File::isFile)
                .thenComparing(File::getName, String.CASE_INSENSITIVE_ORDER));
        for (File k : kids) {
            if (k.getName().equals(ProjectManager.XML_NAME)) continue;
            if (k.isDirectory()) {
                DefaultMutableTreeNode node =
                        new DefaultMutableTreeNode(new FileNode(k.getName(), k, true));
                parent.add(node);
                addDirectoryRecursive(node, k);
            } else {
                String n = k.getName();
                if (n.endsWith(ProjectManager.EXT_PGL) || n.endsWith(ProjectManager.EXT_Y)
                        || n.endsWith(ProjectManager.EXT_Z)) {
                    parent.add(new DefaultMutableTreeNode(new FileNode(n, k, false)));
                }
            }
        }
    }

    private void expandRoot(){
        tree.expandPath(new TreePath(rootNode.getPath()));
    }

    public void setOnOpenFile(Consumer<File> onOpenFile){
        this.onOpenFile = onOpenFile;
    }

    public void setOnNewFile(Consumer<String> onNewFile){
        this.onNewFile = onNewFile;
    }

    public void setOnRenameFile(Consumer<File> onRenameFile){
        this.onRenameFile = onRenameFile;
    }

    public void setOnNewFileIn(BiConsumer<File, String> onNewFileIn) {
        this.onNewFileIn = onNewFileIn;
    }

    public void setOnNewFolderIn(Consumer<File> onNewFolderIn) {
        this.onNewFolderIn = onNewFolderIn;
    }

    public void setOnDeleteFile(Consumer<File> onDeleteFile) {
        this.onDeleteFile = onDeleteFile;
    }

    private File getFileAt(int x, int y){
        TreePath path = tree.getPathForLocation(x, y);
        if (path == null) return null;

        Object last = ((DefaultMutableTreeNode) path.getLastPathComponent()).getUserObject();
        if (last instanceof FileNode fn) return  fn.file();

        return null;
    }
}
