package br.dev.grilo.ui;

import javax.swing.*;
import java.awt.*;

public class CnabViewerFrame extends JFrame {
    private final FileSelectorPanel fileSelectorPanel;
    private final LogPanel logPanel;

    public CnabViewerFrame() {
        setTitle("Leitor CNAB 400 - Itaú");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Layout principal
        setLayout(new BorderLayout());

        // Painel de seleção de arquivo (topo)
        fileSelectorPanel = new FileSelectorPanel(this);
        add(fileSelectorPanel, BorderLayout.NORTH);

        // Painel de logs (centro)
        logPanel = new LogPanel();
        add(new JScrollPane(logPanel), BorderLayout.CENTER);

        // Status bar (rodapé)
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