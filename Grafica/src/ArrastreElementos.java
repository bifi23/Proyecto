

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * esto es para arraastrar elementos
 */
public class ArrastreElementos extends JFrame {
    private JPanel pizarra;
    private JLabel elementoArrastrable;

    private int offsetX, offsetY, finalX, finalY, OriginalX, OriginalY;
    public ArrastreElementos() {
        setTitle("Arrastre de Elementos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pizarra = new JPanel();
        pizarra.setLayout(null);

        // Crear un elemento arrastrable (en este caso, un JLabel)
        elementoArrastrable = new JLabel("Arrastra este texto");
        elementoArrastrable.setBounds(50, 50, 150, 30);
        pizarra.add(elementoArrastrable);
        /**Registra la posicion de donde estaba el objeto original, luego cuando el objeto es soltado se
         * guarda su posicion final y se devuelve a su posicion inicial
         */
        elementoArrastrable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                offsetX = e.getX();
                offsetY = e.getY();
                OriginalX = e.getX();
                OriginalY = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                finalX = elementoArrastrable.getX();
                finalY = elementoArrastrable.getY();
                System.out.println("Coordenadas finales: (" + finalX + ", " + finalY + ")");//borrar linea luego

                elementoArrastrable.setLocation(OriginalX,OriginalY);
            }
        });
        /**Se ocupa para mostrar el arrastre del elemento a tiempo real
         */
        elementoArrastrable.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen() - offsetX;
                int y = e.getYOnScreen() - offsetY;
                elementoArrastrable.setLocation(x, y);
            }
        });

        pizarra.add(elementoArrastrable);
        add(pizarra);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArrastreElementos ventana = new ArrastreElementos();
            ventana.setVisible(true);

        });
    }
}