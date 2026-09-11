package org.example.Views;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import java.awt.*;

public class PigLatinEditor extends JPanel {

    private final RSyntaxTextArea textArea;
    private final JLabel statusLabel;

    public PigLatinEditor(){
        setLayout(new BorderLayout());

        textArea = new RSyntaxTextArea();
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_GO);
        textArea.setCodeFoldingEnabled(true);
        textArea.setAntiAliasingEnabled(true);
        textArea.setAutoIndentEnabled(true);
        textArea.setTabSize(4);

        RTextScrollPane scrollPane = new RTextScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        statusLabel = new JLabel("Lin: 1, Col: 1");
        JPanel statusbar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        statusbar.setBorder(BorderFactory.createEmptyBorder());
        statusbar.add(statusLabel);
        add(statusbar, BorderLayout.SOUTH);

        textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent caretEvent) {
                try {
                    int line = textArea.getCaretLineNumber()+1;
                    int offset = textArea.getCaretPosition();
                    int lineStart = textArea.getLineStartOffset(line-1);
                    int col = offset - lineStart +1;
                    statusLabel.setText("Lin: "+line+", Col: "+col);
                } catch (Exception ex) {
                    statusLabel.setText("Lin: --, Col: --");
                }
            }
        });

    }

    public RSyntaxTextArea getTextArea() {
        return textArea;
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

}
