package br.dev.grilo.ui;

import javax.swing.*;
import java.awt.*;

public class LayoutSelectionPanel extends JPanel {
    private final JComboBox<String> layoutCombo;

    public LayoutSelectionPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JLabel("Layout:"));

        layoutCombo = new JComboBox<>();
        layoutCombo.addItem("CNAB 400 - Itaú");
        add(layoutCombo);
    }

    public String getSelectedLayout() {
        return (String) layoutCombo.getSelectedItem();
    }
}