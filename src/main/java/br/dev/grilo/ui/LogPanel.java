package br.dev.grilo.ui;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;

public class LogPanel extends JTextArea {
    public LogPanel() {
        setEditable(false);
        setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        setBackground(Color.BLACK);
        setForeground(Color.GREEN);

        // Auto-scroll
        DefaultCaret caret = (DefaultCaret) getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    public void appendLog(String message) {
        append(message + "\n");
    }

    public void clearLogs() {
        setText("");
    }
}