package org.example;

import org.example.logica.PizarraFrame;
import org.example.logica.PizarraPanel;

import javax.swing.*;

public class Pizarra {
    private JLabel lb;
    private JPanel pizarra;
    private JTabbedPane tabbedPane;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            PizarraFrame frame = new PizarraFrame();
            frame.setVisible(true);
        });
    }
}
