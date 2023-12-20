

import javax.swing.*;

public class ClaseAtributosOMetodosVista extends JPanel {
    /**Vista de clase con Titulo y solo atributos o metodos, tiene 2 areas de texto divididas
     */
    public ClaseAtributosOMetodosVista() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JTextArea textArea1 = new JTextArea();
        JTextArea textArea2 = new JTextArea();
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textArea1, textArea2);
        splitPane1.setDividerLocation(150);
        add(splitPane1);
    }
    public void paint(){

    }


}