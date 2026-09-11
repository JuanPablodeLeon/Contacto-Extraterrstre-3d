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
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
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

}
