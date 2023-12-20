
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorPestanas extends JFrame {
    private JTabbedPane tabbedPane;

    public GestorPestanas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Editor de Diagrama UML");

        tabbedPane = new JTabbedPane();
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        setPreferredSize(new Dimension(850, 630));
        JButton addButton = new JButton("+ Nueva Pizarra");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PizarraUML nuevaPizarra = new PizarraUML();
                tabbedPane.addTab("Pestaña " + (tabbedPane.getTabCount() + 1), nuevaPizarra);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }
}