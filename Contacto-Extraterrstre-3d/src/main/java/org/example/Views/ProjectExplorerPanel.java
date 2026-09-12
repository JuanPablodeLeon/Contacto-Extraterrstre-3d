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
import java.util.List;
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
                File target = getSelectedFile();
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

    private record FileNode(String name, File file, boolean isDirectory){
        @Override
        public String toString(){
            return name;
        }
    }

    private void showPopUp(int x, int y, File target){
        JPopupMenu popup = new JPopupMenu();

        JMenu nuevoMenu = new JMenu("Nuevo archivo");

        JMenuItem pigItem = new JMenuItem("Archivo PigLatin (.pig)");
        JMenuItem yItem = new JMenuItem("Archivo YFile (.y)");
        JMenuItem zItem = new JMenuItem("Archivo Zetariano (.z)");
        pigItem.addActionListener(e -> {
            if(onNewFile != null) onNewFile.accept(ProjectManager.EXT_PGL);
        });
        yItem.addActionListener(e -> {
            if(onNewFile != null) onNewFile.accept(ProjectManager.EXT_Y);
        });
        zItem.addActionListener(e -> {
            if(onNewFile != null) onNewFile.accept(ProjectManager.EXT_Z);
        });

        nuevoMenu.add(pigItem);
        nuevoMenu.add(yItem);
        nuevoMenu.add(zItem);
        popup.add(nuevoMenu);

        if (target != null && target.isFile()){
            popup.addSeparator();

            JMenuItem abrirItem = new JMenuItem("Abrir");
            abrirItem.addActionListener(e ->{
                if (onOpenFile != null) onOpenFile.accept(target);
            });

            JMenuItem renameItem = new JMenuItem("Renombrar");
            renameItem.addActionListener(e ->{
                if (onOpenFile != null) onOpenFile.accept(target);
            });

            popup.add(abrirItem);
            popup.add(renameItem);
        }
        popup.show(tree, x, y);
    }

    public void setProjectManager(ProjectManager pm){
        this.projectManager = pm;
        refresh();
    }

    public void refresh(){
        rootNode.removeAllChildren();

        if (projectManager == null || !projectManager.hasProject()){
            rootNode.setUserObject("Sin proyecto Cartado");
            treeMododel.reload();
            expandRoot();
            return;
        }
        File dir = projectManager.getProjectDir();
        rootNode.setUserObject(new FileNode(projectManager.getProjectName(), dir, true));
        List<File> files = projectManager.listProjectFiles();
        for (File f : files){
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(new FileNode(f.getName(), f, false));
            rootNode.add(child);
        }
        treeMododel.reload();
        expandRoot();
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

    private File getFileAt(int x, int y){
        TreePath path = tree.getPathForLocation(x, y);
        if (path == null) return null;

        Object last = ((DefaultMutableTreeNode) path.getLastPathComponent()).getUserObject();
        if (last instanceof FileNode fn) return  fn.file();

        return null;
    }
}
