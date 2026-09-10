package org.example.Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainPanel extends JPanel {

    public MainPanel(JTextArea textArea, JTabbedPane DownOptions){
        setLayout(new BorderLayout());

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textArea, DownOptions);
        splitPane.setResizeWeight(0.67);
        splitPane.setContinuousLayout(true);
        splitPane.setBorder(new EmptyBorder(10,10,10,10));

        // Posicion inicial proporcional
        splitPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                splitPane.setDividerLocation(0.67);
                splitPane.removeComponentListener(this);
            }
        });
        add(splitPane, BorderLayout.CENTER);
    }
}
