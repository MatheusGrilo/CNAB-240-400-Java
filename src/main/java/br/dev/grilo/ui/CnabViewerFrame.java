package br.dev.grilo.ui;

import javax.swing.*;
import java.awt.*;

public class CnabViewerFrame extends JFrame {
    private final FileProcessingPanel fileProcessingPanel;
    private final LogPanel logPanel;

    public CnabViewerFrame() {
        setTitle("Leitor CNAB 240/400");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        fileProcessingPanel = new FileProcessingPanel(this);
        add(fileProcessingPanel, BorderLayout.NORTH);

        logPanel = new LogPanel();
        add(new JScrollPane(logPanel), BorderLayout.CENTER);

        JLabel statusBar = new JLabel(" Pronto");
        add(statusBar, BorderLayout.SOUTH);
    }

    public void log(String message) {
        logPanel.appendLog(message);
    }

    public void clearLogs() {
        logPanel.clearLogs();
    }
}