import java.io.Serializable;
import java.util.ArrayList;


import javax.swing.*;

public class main {
    private JLabel lb;
    private JPanel pizarra;
    private JTabbedPane tabbedPane;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            PizarraUML frame = new PizarraUML();
            frame.setVisible(true);
        });
    }
}

