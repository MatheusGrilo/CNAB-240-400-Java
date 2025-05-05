package br.dev.grilo.ui;

import br.dev.grilo.service.cnab400.itau.LeituraService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSelectorPanel extends JPanel {
    private final CnabViewerFrame parent;
    private final JTextField filePathField;

    public FileSelectorPanel(CnabViewerFrame parent) {
        this.parent = parent;
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Label
        add(new JLabel("Arquivo CNAB:"));

        // Campo de texto
        filePathField = new JTextField(40);
        filePathField.setEditable(false);
        add(filePathField);

        // Botão de seleção
        JButton browseButton = new JButton("Selecionar...");
        browseButton.addActionListener(this::selectFile);
        add(browseButton);

        // Botão de processamento
        JButton processButton = new JButton("Processar");
        processButton.addActionListener(this::processFile);
        add(processButton);
    }

    private void selectFile(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(Paths.get("src/main/resources/mock/ITAU").toFile());

        int result = fileChooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            filePathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void processFile(ActionEvent e) {
        if (filePathField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Selecione um arquivo primeiro!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        parent.clearLogs();
        Path caminhoArquivo = Paths.get(filePathField.getText());

        try {
            LeituraService leituraService = new LeituraService() {
                @Override
                protected void log(String message) {
                    parent.log(message);
                }
            };

            parent.log("Processando arquivo: " + caminhoArquivo.getFileName());
            leituraService.processarArquivoCnab400(caminhoArquivo);
            parent.log("Arquivo processado com sucesso!");
        } catch (IOException ex) {
            parent.log("ERRO: " + ex.getMessage());
            JOptionPane.showMessageDialog(parent, "Erro ao ler arquivo: " + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            parent.log("ERRO: " + ex.getMessage());
            JOptionPane.showMessageDialog(parent, "Arquivo inválido: " + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}