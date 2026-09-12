package org.example.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuBar extends JMenuBar {
    private final JMenuItem newItem;
    private final JMenuItem openItem;
    private final JMenuItem saveItem;
    private final JMenuItem exitItem;
    private final JButton runButton;
    private final JButton cleanButton;
    private final JMenuItem tokensItem;
    private final JMenuItem errorsItem;
    private final JMenuItem aboutItem;
    private final JMenuItem astTreeItem;

    public MenuBar(){
        JMenu fileMenu = new JMenu("Archivo");
        runButton = createButton("Ejecutar");
        JMenu reportMenu = new JMenu("Reportes");
        cleanButton = createButton("Limpiar consola");
        JMenu helpMenu = new JMenu("Ayuda");

        newItem = new JMenuItem("Nuevo proyecto...");
        openItem = new JMenuItem("Abrir proyecto...");
        saveItem = new JMenuItem("Guardar");
        exitItem = new JMenuItem("Salir");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        tokensItem = new JMenuItem("Reporte de tokens");
        errorsItem = new JMenuItem("Reporte de errores");
        astTreeItem = new JMenuItem("Visualizar Árbol AST");
        reportMenu.add(tokensItem);
        reportMenu.add(errorsItem);
        reportMenu.add(astTreeItem);

        aboutItem = new JMenuItem("Acerca de");
        helpMenu.add(aboutItem);

        add(fileMenu);
        add(runButton);
        add(reportMenu);
        add(cleanButton);
        add(helpMenu);
    }

    public void onRun(ActionListener l)    { runButton.addActionListener(l); }
    public void onClean(ActionListener l)  { cleanButton.addActionListener(l); }
    public void onNew(ActionListener l)    { newItem.addActionListener(l); }
    public void onOpenProject(ActionListener l) { openItem.addActionListener(l); }
    public void onSave(ActionListener l)   { saveItem.addActionListener(l); }
    public void onExit(ActionListener l)   { exitItem.addActionListener(l); }
    public void onTokens(ActionListener l) { tokensItem.addActionListener(l); }
    public void onErrors(ActionListener l) { errorsItem.addActionListener(l); }
    public void onAbout(ActionListener l)  { aboutItem.addActionListener(l); }
    public void onASTTree(ActionListener l) { astTreeItem.addActionListener(l); }

    public JButton getRunButton() { return runButton; }

    public void setRunEnabled(boolean enabled) { runButton.setEnabled(enabled); }

    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(Color.LIGHT_GRAY);
                button.setOpaque(true);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button.setOpaque(false);
            }
        });
        return button;
    }
}
