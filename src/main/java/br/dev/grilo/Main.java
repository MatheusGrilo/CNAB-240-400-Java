package br.dev.grilo;

import br.dev.grilo.ui.CnabViewerFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CnabViewerFrame frame = new CnabViewerFrame();
            frame.setVisible(true);
        });
    }
}