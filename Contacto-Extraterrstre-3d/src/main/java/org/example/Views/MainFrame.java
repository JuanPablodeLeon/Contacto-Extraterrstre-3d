package org.example.Views;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final JTextArea editorPendiente;
    private final JTextArea consoleTextArea;
    private final JTextArea codigo3DirireccionesTextArea;
    private final JTextArea codigoCTextArea;

    public MainFrame(){

        setTitle("Contacto Extraterrestre 3D");
        setMinimumSize(new Dimension(600,400));
        setSize(new Dimension(1200,675));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Modificar para aceptar mas de un textarea
        editorPendiente = new JTextArea();

        JTabbedPane tabbedPaneDown = new JTabbedPane();

        consoleTextArea = new JTextArea();
        codigo3DirireccionesTextArea = new JTextArea();
        codigoCTextArea = new JTextArea();

        tabbedPaneDown.add("Consola", consoleTextArea);
        tabbedPaneDown.add("Codigo 3 Direcciones", codigo3DirireccionesTextArea);
        tabbedPaneDown.add("Codigo C", codigoCTextArea);

       // add(new MainPanel(editorPendiente, tabbedPaneDown));
        setVisible(true);
    }

}
