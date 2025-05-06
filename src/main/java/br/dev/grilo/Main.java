package br.dev.grilo;

import br.dev.grilo.ui.CnabViewerFrame;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                CnabViewerFrame frame = new CnabViewerFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao iniciar aplicação: " + e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        });
    }
}