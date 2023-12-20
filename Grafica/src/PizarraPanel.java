

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Decorator.Flecha;
import Pizarra.Pizarra;




public class PizarraPanel extends JPanel implements Serializable {

    private Pizarra pizarra;
    private Flecha tipoFlechaSeleccionada;

    public void setTipoFlechaSeleccionada(Flecha tipoFlechaSeleccionada) {
        this.tipoFlechaSeleccionada = tipoFlechaSeleccionada;
    }

    public PizarraPanel(Pizarra pizarra) {
        this.pizarra = pizarra;
        setPreferredSize(new Dimension(800, 600));
    }


    private List<Shape> shapes = new ArrayList<>();
    private Shape currentShape;
    private Color colorLinea = Color.BLACK;
    private Mode currentMode = Mode.LINE;
    private ArrowType currentArrowType = ArrowType.NONE;
    private Point startPoint;
    private ArrowType arrowType = ArrowType.NONE;
    private Color colorFigura = Color.BLACK;
    public enum Mode {
        LINE,
        RECTANGLE,
        ENTITY,
        ARROW
    }

    public enum ArrowType {
        NONE,
        TRIANGLE,
        DIAMOND
    }

    public PizarraPanel() {
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

    private void handleMousePress(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        startPoint = new Point(x, y);

        switch (currentMode) {
            case LINE:
                currentShape = new Line2D.Double(x, y, x, y);
                break;
            case RECTANGLE:
                currentShape = new Rectangle2D.Double(x, y, 0, 0);
                break;
            case ENTITY:
                // Agrega lógica para la forma de entidad
                currentShape = new Ellipse2D.Double(x, y, 0, 0);
                break;
            case ARROW:
                // Agrega lógica para la flecha
                currentShape = new Line2D.Double(x, y, x, y);
                break;
        }
    }

    private void handleMouseDrag(MouseEvent e) {
        if (currentShape != null) {
            switch (currentMode) {
                case LINE:
                    ((Line2D) currentShape).setLine(startPoint.getX(), startPoint.getY(), e.getX(), e.getY());
                    break;
                case RECTANGLE:
                    ((Rectangle2D) currentShape).setFrameFromDiagonal(startPoint.getX(), startPoint.getY(), e.getX(), e.getY());
                    break;
                case ENTITY:
                    // Agrega lógica para la forma de entidad
                    ((Ellipse2D) currentShape).setFrameFromDiagonal(startPoint.getX(), startPoint.getY(), e.getX(), e.getY());
                    break;
                case ARROW:
                    // Agrega lógica para la flecha
                    ((Line2D) currentShape).setLine(startPoint.getX(), startPoint.getY(), e.getX(), e.getY());
                    break;
            }
//            repaint();
            if (currentMode == Mode.ARROW && currentShape instanceof Line2D) {
                ((PizarraPanel) currentShape).setArrowType2(arrowType);
            }
        }
    }

    private void handleMouseRelease(MouseEvent e) {
        if (currentShape != null) {
            shapes.add(currentShape);
            currentShape = null;
            repaint();
        }
    }

    public void setColorLinea(Color color) {
        this.colorLinea = color;
    }

    public void setMode(Mode mode) {
        this.currentMode = mode;
    }

    public void setArrowType(ArrowType arrowType) {
        this.currentArrowType = arrowType;
    }
    public Mode getMode() {
        return currentMode;
    }
    public void setArrowType2(ArrowType arrowType) {
        this.arrowType = arrowType;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(colorLinea);

        for (Shape shape : shapes) {
            if (shape instanceof Line2D) {
                drawArrow(g2d, (Line2D) shape);
            } else {
                g2d.draw(shape);
            }
        }

        if (currentShape != null) {
            g2d.draw(currentShape);
        }
    }

    private void drawArrow(Graphics2D g2d, Line2D line) {
        switch (arrowType) {
            case NONE:
                drawArrowhead(g2d, line, ArrowType.TRIANGLE);
                break;
            case TRIANGLE:
                drawArrowheadTriangle(g2d, line);
//                drawArrowhead(g2d, line, ArrowType.TRIANGLE);
                break;
            case DIAMOND:
                drawArrowheadDiamond(g2d, line);
//                drawArrowhead(g2d, line, ArrowType.DIAMOND);
                break;
        }
    }

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
    private void drawArrowheadTriangle(Graphics2D g2d, Line2D line) {
        Polygon arrowhead = new Polygon();
        arrowhead.addPoint((int) line.getX2(), (int) line.getY2());
        arrowhead.addPoint((int) (line.getX2() - 8), (int) (line.getY2() - 8));
        arrowhead.addPoint((int) (line.getX2() + 8), (int) (line.getY2() - 8));

        g2d.draw(line);
        g2d.fill(arrowhead);
    }
    private void drawArrowheadDiamond(Graphics2D g2d, Line2D line) {
        int[] xPoints = {(int) line.getX2(), (int) (line.getX2() - 6), (int) line.getX2(), (int) (line.getX2() + 6)};
        int[] yPoints = {(int) line.getY2(), (int) (line.getY2() - 6), (int) (line.getY2() - 12), (int) (line.getY2() - 6)};

        Polygon arrowhead = new Polygon(xPoints, yPoints, 4);
        g2d.draw(line);
        g2d.fill(arrowhead);
    }
    //Nuevo método para establecer el color de la figura recién creada
    public void setColorFigura(Color color) {
        this.colorFigura = color;
    }

    // Nuevo método para obtener la figura actualmente en proceso de creación
    public Shape getCurrentShape() {
        return currentShape;
    }
}