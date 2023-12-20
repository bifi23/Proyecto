
import javax.swing.*;

public class ClaseCompletaVista extends JPanel {
    /**Vista de clase con Titulo, atributos y metodos, tiene 3 areas de texto divididas
     */
    public ClaseCompletaVista() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JTextArea textArea1 = new JTextArea();
        JTextArea textArea2 = new JTextArea();
        JTextArea textArea3 = new JTextArea();

        JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textArea1, textArea2);
        splitPane1.setDividerLocation(150);

        JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane1, textArea3);
        splitPane2.setDividerLocation(300);

        add(splitPane2);
    }
    public void paint(){

    }


}