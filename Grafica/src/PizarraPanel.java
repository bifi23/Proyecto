

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Decorator.Flecha;
import Pizarra.Pizarra;


import java.io.Serializable;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;




/**
 * Esta clase representa un panel de dibujo que permite al usuario crear y visualizar formas, como líneas, rectángulos, elipses y flechas.
 * Extiende JPanel e implementa la interfaz Serializable para permitir la serialización.
 */
public class PizarraPanel extends JPanel implements Serializable {
    /**
     *     Lista para almacenar las formas dibujadas en el panel
      */
    private List<Shape> shapes = new ArrayList<>();
    /**
     *     Variables para la forma actualmente en proceso de creación
     */
    private Shape currentShape;
    private Point startPoint;

    // Variables de configuración
    private Color colorLinea = Color.BLACK;
    private Mode currentMode = Mode.LINE;
    private ArrowType currentArrowType = ArrowType.NONE;
    private ArrowType arrowType = ArrowType.NONE;
    private Color colorFigura = Color.BLACK;

    // Referencias a otras clases
    private Pizarra pizarra;
    private Flecha tipoFlechaSeleccionada;

    /**
     * Constructor que recibe una instancia de Pizarra y establece las dimensiones preferidas del panel.
     * También configura los escuchadores de eventos del ratón.
     */
    public PizarraPanel() {
        this.pizarra = pizarra;
        setPreferredSize(new Dimension(800, 600));

        // Configuración de los escuchadores de eventos del ratón
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleMousePress(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                handleMouseRelease(e);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                handleMouseDrag(e);
            }
        });
    }

    // Enumeración para los modos de dibujo disponibles
    public enum Mode {
        LINE,
        RECTANGLE,
        ENTITY,
        ARROW
    }

    // Enumeración para los tipos de flecha disponibles
    public enum ArrowType {
        NONE,
        TRIANGLE,
        DIAMOND
    }

    // Método que maneja el evento de presionar el ratón
    private void handleMousePress(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        startPoint = new Point(x, y);

        // Crear la forma inicial según el modo de dibujo actual
        switch (currentMode) {
            case LINE:
                currentShape = new Line2D.Double(x, y, x, y);
                break;
            case RECTANGLE:
                currentShape = new Rectangle2D.Double(x, y, 0, 0);
                break;
            case ENTITY:
                currentShape = new Ellipse2D.Double(x, y, 0, 0);
                break;
            case ARROW:
                currentShape = new Line2D.Double(x, y, x, y);
                break;
        }
    }

    // Método que maneja el evento de arrastrar el ratón
    private void handleMouseDrag(MouseEvent e) {
        if (currentShape != null) {
            // Actualizar la forma actualmente en proceso según el modo de dibujo actual
            switch (currentMode) {
                case LINE:
                    ((Line2D) currentShape).setLine(startPoint.getX(), startPoint.getY(), e.getX(), e.getY());
                    break;
                case RECTANGLE:
                    ((Rectangle2D) currentShape).setFrameFromDiagonal(startPoint.getX(), startPoint.getY(), e.getX(), e.getY());
                    break;
                case ENTITY:
                    ((Ellipse2D) currentShape).setFrameFromDiagonal(startPoint.getX(), startPoint.getY(), e.getX(), e.getY());
                    break;
                case ARROW:
                    ((Line2D) currentShape).setLine(startPoint.getX(), startPoint.getY(), e.getX(), e.getY());
                    break;
            }

            // Establecer el tipo de flecha actual si el modo es ARROW y la forma es una línea
            if (currentMode == Mode.ARROW && currentShape instanceof Line2D) {
                ((PizarraPanel) currentShape).setArrowType2(arrowType);
            }
        }
    }

    // Método que maneja el evento de soltar el ratón
    private void handleMouseRelease(MouseEvent e) {
        if (currentShape != null) {
            // Agregar la forma actual a la lista de formas y repintar el panel
            shapes.add(currentShape);
            currentShape = null;
            repaint();
        }
    }

    // Método que establece el color de la línea para dibujar
    public void setColorLinea(Color color) {
        this.colorLinea = color;
    }

    // Método que establece el modo de dibujo actual
    public void setMode(Mode mode) {
        this.currentMode = mode;
    }

    // Método que establece el tipo de flecha para las líneas
    public void setArrowType(ArrowType arrowType) {
        this.currentArrowType = arrowType;
    }

    // Método que devuelve el modo de dibujo actual
    public Mode getMode() {
        return currentMode;
    }

    // Método que establece el tipo de flecha actual (usado en handleMouseDrag)
    public void setArrowType2(ArrowType arrowType) {
        this.arrowType = arrowType;
    }

    // Sobrescribe el método paintComponent para dibujar las formas en el panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(colorLinea);

        // Dibujar todas las formas almacenadas en la lista
        for (Shape shape : shapes) {
            if (shape instanceof Line2D) {
                drawArrow(g2d, (Line2D) shape);
            } else {
                g2d.draw(shape);
            }
        }

        // Dibujar la forma actualmente en proceso
        if (currentShape != null) {
            g2d.draw(currentShape);
        }
    }

    // Método privado que dibuja una flecha al final de la línea
    private void drawArrow(Graphics2D g2d, Line2D line) {
        switch (arrowType) {
            case NONE:
                drawArrowhead(g2d, line, ArrowType.TRIANGLE);
                break;
            case TRIANGLE:
                drawArrowheadTriangle(g2d, line);
                break;
            case DIAMOND:
                drawArrowheadDiamond(g2d, line);
                break;
        }
    }

    // Método privado que dibuja la cabeza de la flecha con forma de triángulo
    private void drawArrowhead(Graphics2D g2d, Line2D line, ArrowType arrowType) {
        double size = 8.0;
        double angle = Math.atan2(line.getY2() - line.getY1(), line.getX2() - line.getX1());

        Polygon arrowhead = new Polygon();
        arrowhead.addPoint((int) (line.getX2() - size * Math.cos(angle - Math.PI / 4)),
                (int) (line.getY2() - size * Math.sin(angle - Math.PI / 4)));
        arrowhead.addPoint((int) (line.getX2() - size * Math.cos(angle + Math.PI / 4)),
                (int) (line.getY2() - size * Math.sin(angle + Math.PI / 4)));
        arrowhead.addPoint((int) (line.getX2() - size * Math.cos(angle + 3 * Math.PI / 4)),
                (int) (line.getY2() - size * Math.sin(angle + 3 * Math.PI / 4)));

        g2d.draw(line);
        g2d.fill(arrowhead);
    }

    // Método privado que dibuja la cabeza de la flecha con forma de triángulo
    private void drawArrowheadTriangle(Graphics2D g2d, Line2D line) {
        Polygon arrowhead = new Polygon();
        arrowhead.addPoint((int) line.getX2(), (int) line.getY2());
        arrowhead.addPoint((int) (line.getX2() - 8), (int) (line.getY2() - 8));
        arrowhead.addPoint((int) (line.getX2() + 8), (int) (line.getY2() - 8));

        g2d.draw(line);
        g2d.fill(arrowhead);
    }

    // Método privado que dibuja la cabeza de la flecha con forma de diamante
    private void drawArrowheadDiamond(Graphics2D g2d, Line2D line) {
        int[] xPoints = {(int) line.getX2(), (int) (line.getX2() - 6), (int) line.getX2(), (int) (line.getX2() + 6)};
        int[] yPoints = {(int) line.getY2(), (int) (line.getY2() - 6), (int) (line.getY2() - 12), (int) (line.getY2() - 6)};

        Polygon arrowhead = new Polygon(xPoints, yPoints, 4);
        g2d.draw(line);
        g2d.fill(arrowhead);
    }

    /**
     * Establece el color de la figura recién creada.
     *
     * @param color Color de la figura.
     */
    public void setColorFigura(Color color) {
        this.colorFigura = color;
    }

    /**
     * Obtiene la figura actualmente en proceso de creación.
     *
     * @return La forma actual.
     */
    public Shape getCurrentShape() {
        return currentShape;
    }
}
