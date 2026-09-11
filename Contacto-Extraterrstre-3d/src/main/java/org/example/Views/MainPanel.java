package org.example.Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainPanel extends JPanel {

    public MainPanel(JTabbedPane editorTabs, ProjectExplorerPanel explorer, JTabbedPane DownOptions){
        setLayout(new BorderLayout());

        for (int i = 0; i < DownOptions.getTabCount(); i++) {
            Component tab = DownOptions.getComponentAt(i);
            JTextArea area = findTextArea(tab);
            if (area != null) styleOutputArea(area);
        }

        JSplitPane verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, editorTabs, DownOptions);
        verticalSplit.setResizeWeight(0.67);
        verticalSplit.setContinuousLayout(true);
        verticalSplit.setBorder(new EmptyBorder(10,10,10,10));

        // Posicion inicial proporcional
        verticalSplit.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                verticalSplit.setDividerLocation(0.67);
                verticalSplit.removeComponentListener(this);
            }
        });

        explorer.setPreferredSize(new Dimension(220,0));

        JSplitPane horizontalSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, explorer, verticalSplit);
        horizontalSplit.setResizeWeight(0.0);
        horizontalSplit.setContinuousLayout(true);
        horizontalSplit.setDividerLocation(220);

        add(verticalSplit, BorderLayout.CENTER);
    }

    private void styleOutputArea(JTextArea area) {
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        area.setBackground(Color.darkGray);
        area.setForeground(Color.lightGray);
        area.setCaretColor(Color.darkGray);
        area.setEditable(false);
        area.setBorder(new EmptyBorder(10, 10, 10, 10));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
    }

    private static JTextArea findTextArea(Component tab) {
        if (tab instanceof JScrollPane scroll){
            JViewport vp = scroll.getViewport();
            if (vp != null && vp.getView() instanceof JTextArea area){
                return area;
            }
        } else if (tab instanceof JTextArea area) {
            return area;
        }
        return null;
    }
}
