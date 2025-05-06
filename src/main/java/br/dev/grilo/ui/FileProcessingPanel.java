package br.dev.grilo.ui;

import br.dev.grilo.service.CnabValidator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.nio.file.Path;
import java.util.List;

public class FileProcessingPanel extends JPanel {
    private final CnabViewerFrame parent;
    private final LayoutSelectionPanel layoutPanel;
    private final JTextField fileField;
    private Path selectedFile;

    public FileProcessingPanel(CnabViewerFrame parent) {
        this.parent = parent;
        setLayout(new BorderLayout());


        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        layoutPanel = new LayoutSelectionPanel();
        topPanel.add(layoutPanel);

        fileField = new JTextField(30);
        fileField.setEditable(false);
        topPanel.add(fileField);

        JButton browseBtn = new JButton("Selecionar");
        browseBtn.addActionListener(this::selectFile);
        topPanel.add(browseBtn);

        add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton validateBtn = new JButton("Validar");
        validateBtn.addActionListener(this::validateFile);
        bottomPanel.add(validateBtn);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void selectFile(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile().toPath();
            fileField.setText(selectedFile.toString());
        }
    }

    private void validateFile(ActionEvent e) {
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(parent, "Selecione um arquivo primeiro");
            return;
        }

        try {
            parent.clearLogs();
            parent.log("Validando arquivo Itaú CNAB 400: " + selectedFile.getFileName());

            CnabValidator validator = new CnabValidator();
            List<String> erros = validator.validateItauCnab400(selectedFile);

            if (erros.size() == 0) { // Substituindo isEmpty() por size() == 0
                parent.log("Arquivo válido para Itaú CNAB 400");
                JOptionPane.showMessageDialog(parent,
                        "Arquivo válido!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                parent.log("Erros encontrados:");
                for (String erro : erros) {
                    parent.log(erro);
                }
                JOptionPane.showMessageDialog(parent,
                        "Arquivo inválido!\n" + String.join("\n", erros),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (java.io.IOException ex) { // IOException totalmente qualificado
            parent.log("ERRO: " + ex.getMessage());
            JOptionPane.showMessageDialog(parent,
                    "Erro ao ler arquivo: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}