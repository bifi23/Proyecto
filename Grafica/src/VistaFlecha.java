
import javax.swing.*;
import java.awt.*;
import Decorator.Flecha;
import Pizarra.Pizarra;
import Command.*;
import clasesdecorator.*;

public class VistaFlecha extends JComponent {
    private Flecha flecha;

    public VistaFlecha(Flecha flecha) {
        this.flecha = flecha;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Implementa la lógica para dibujar la flecha según las propiedades del modelo
        // Utiliza los métodos de Graphics para dibujar líneas, polígonos, etc.
        // Puedes acceder a las propiedades del modelo a través de la instancia 'flecha'
    }
}