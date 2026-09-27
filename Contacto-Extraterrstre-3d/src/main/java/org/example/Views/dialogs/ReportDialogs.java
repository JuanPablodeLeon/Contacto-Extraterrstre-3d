package org.example.Views.dialogs;

import org.antlr.v4.runtime.Token;
import org.example.Reports.CompilerError;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public final class ReportDialogs {

    private ReportDialogs() {
    }

    public static String tipoLegible(CompilerError.Tipo tipo) {
        return switch (tipo) {
            case LEXICO -> "Lexico";
            case SINTACTICO -> "Sintactico";
            case SEMANTICO -> "Semantico";
        };
    }

    public static void showTokens(Component parent, List<Token> tokens, String vocabName) {
        JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(parent), "Reporte de Tokens", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setSize(800, 500);
        dialog.setLocationRelativeTo(parent);
        dialog.setLayout(new BorderLayout());

        String[] columnas = {"#", "Tipo", "Texto", "Línea", "Columna"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        int indice = 0;
        for (Token tok : tokens) {
            if (tok.getType() == Token.EOF) continue;
            modelo.addRow(new Object[]{
                    indice++,
                    String.valueOf(tok.getType()),
                    tok.getText(),
                    tok.getLine(),
                    tok.getCharPositionInLine()
            });
        }

        JTable tabla = new JTable(modelo);
        tabla.setFillsViewportHeight(true);
        tabla.setRowHeight(22);
        dialog.add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelSur.add(new JLabel(vocabName + " | Total de tokens: " + modelo.getRowCount()));
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dialog.dispose());
        panelSur.add(btnCerrar);
        dialog.add(panelSur, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }

    public static void showErrors(Component parent, List<CompilerError> errores) {
        JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(parent), "Reporte de Errores", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setSize(900, 500);
        dialog.setLocationRelativeTo(parent);
        dialog.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Reporte de Errores", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        dialog.add(lblTitulo, BorderLayout.NORTH);

        String[] columnas = {"Tipo", "Descripción", "Línea", "Columna"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (CompilerError error : errores) {
            modelo.addRow(new Object[]{
                    tipoLegible(error.getTipo()),
                    error.getMessage(),
                    error.getLine(),
                    error.getColumn() >= 0 ? error.getColumn() : "-"
            });
        }

        JTable tabla = new JTable(modelo);
        tabla.setFillsViewportHeight(true);
        tabla.setRowHeight(25);
        tabla.setGridColor(Color.GRAY);
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tabla.getTableHeader().setBackground(new Color(180, 220, 180));

        tabla.setDefaultRenderer(Object.class, (t, value, isSelected, hasFocus, row, column) -> {
            JLabel cell = new JLabel(value != null ? value.toString() : "");
            cell.setOpaque(true);
            String tipo = modelo.getValueAt(row, 0).toString();
            if (isSelected) {
                cell.setBackground(t.getSelectionBackground());
            } else {
                cell.setBackground(switch (tipo) {
                    case "Lexico" -> new Color(255, 220, 220);
                    case "Sintactico" -> new Color(255, 245, 200);
                    case "Semantico" -> new Color(220, 220, 255);
                    default -> Color.WHITE;
                });
            }
            return cell;
        });

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        dialog.add(scroll, BorderLayout.CENTER);

        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelSur.setBackground(new Color(245, 245, 245));
        JLabel lblConteo = new JLabel("Total de errores: " + modelo.getRowCount());
        lblConteo.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBackground(new Color(180, 220, 180));
        btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCerrar.addActionListener(e -> dialog.dispose());
        panelSur.add(lblConteo);
        panelSur.add(btnCerrar);
        dialog.add(panelSur, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
}
