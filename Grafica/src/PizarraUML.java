

import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



import java.util.List;



/**
 * La clase PizarraUML extiende JFrame y representa una aplicación que permite gestionar múltiples pizarras para dibujar UML.
 */
public class PizarraUML extends JFrame {
    private JTabbedPane tabbedPane;
    private List<PizarraPanel> pizarras;
    private JButton agregarTabButton;
    private JButton cerrarTabButton;
    private JButton guardarButton;
    private JComboBox<String> colorComboBox;
    private JComboBox<String> modeComboBox;
    private JComboBox<String> arrowComboBox;

    /**
     * Constructor de la clase PizarraUML.
     * Configura la interfaz gráfica y los componentes necesarios.
     */
    public PizarraUML() {
        setTitle("Pizarra Múltiple");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Inicialización de componentes
        tabbedPane = new JTabbedPane();
        pizarras = new ArrayList<>();
        agregarTabButton = new JButton("Agregar Pizarra");
        cerrarTabButton = new JButton("Cerrar Pizarra");
        guardarButton = new JButton("Guardar");
        colorComboBox = new JComboBox<>(new String[]{"Negro", "Rojo", "Azul", "Verde"});
        modeComboBox = new JComboBox<>(new String[]{"Linea", "Rectangulo", "Entidad", "Flecha"});
        arrowComboBox = new JComboBox<>(new String[]{"Ninguna", "Triangulo", "Diamante"});

        // Configuración de eventos de los botones y ComboBox
        configurarEventos();

        // Creación del panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarTabButton);
        buttonPanel.add(cerrarTabButton);
        buttonPanel.add(guardarButton);
        buttonPanel.add(colorComboBox);
        buttonPanel.add(modeComboBox);
        buttonPanel.add(arrowComboBox);

        // Configuración del diseño del JFrame
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Configuración de eventos para los botones y ComboBox
    private void configurarEventos() {
        agregarTabButton.addActionListener(e -> agregarPizarra());
        cerrarTabButton.addActionListener(e -> cerrarPizarra());
        guardarButton.addActionListener(e -> guardarPizarra());
        colorComboBox.addActionListener(e -> cambiarColor((String) colorComboBox.getSelectedItem()));
        modeComboBox.addActionListener(e -> cambiarModo((String) modeComboBox.getSelectedItem()));
        arrowComboBox.addActionListener(e -> cambiarTipoFlecha((String) arrowComboBox.getSelectedItem()));
    }

    // Método para agregar una nueva pizarra al tabbedPane
    private void agregarPizarra() {
        PizarraPanel nuevaPizarra = new PizarraPanel();
        pizarras.add(nuevaPizarra);
        tabbedPane.addTab("Pizarra " + pizarras.size(), nuevaPizarra);
        tabbedPane.setSelectedComponent(nuevaPizarra);
    }

    // Método para cerrar la pizarra seleccionada
    private void cerrarPizarra() {
        int selectedIndex = tabbedPane.getSelectedIndex();
        if (selectedIndex != -1) {
            tabbedPane.remove(selectedIndex);
            pizarras.remove(selectedIndex);
        }
    }

    // Método para guardar la pizarra en un archivo
    private void guardarPizarra() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                List<PizarraPanel> pizarrasAGuardar = new ArrayList<>(pizarras);
                oos.writeObject(pizarrasAGuardar);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para cambiar el color de la figura en la pizarra actual
    private void cambiarColor(String color) {
        Color nuevoColor;
        switch (color) {
            case "Rojo":
                nuevoColor = Color.RED;
                break;
            case "Azul":
                nuevoColor = Color.BLUE;
                break;
            case "Verde":
                nuevoColor = Color.GREEN;
                break;
            default:
                nuevoColor = Color.BLACK;
                break;
        }

        PizarraPanel pizarraActual = obtenerPizarraActual();
        assert pizarraActual != null;
        pizarraActual.setColorFigura(nuevoColor);
        pizarraActual.repaint();
    }

    // Método para cambiar el modo de dibujo en la pizarra actual
    private void cambiarModo(String modo) {
        PizarraPanel pizarraActual = obtenerPizarraActual();
        if (pizarraActual != null) {
            switch (modo) {
                case "Linea":
                    pizarraActual.setMode(PizarraPanel.Mode.LINE);
                    break;
                case "Rectangulo":
                    pizarraActual.setMode(PizarraPanel.Mode.RECTANGLE);
                    break;
                case "Entidad":
                    pizarraActual.setMode(PizarraPanel.Mode.ENTITY);
                    break;
                case "Flecha":
                    pizarraActual.setMode(PizarraPanel.Mode.ARROW);
                    break;
            }
        }
    }

    // Método para cambiar el tipo de flecha en la pizarra actual
    private void cambiarTipoFlecha(String tipoFlecha) {
        PizarraPanel pizarraActual = obtenerPizarraActual();
        if (pizarraActual != null && pizarraActual.getMode() == PizarraPanel.Mode.ARROW) {
            switch (tipoFlecha) {
                case "Ninguna":
                    pizarraActual.setArrowType(PizarraPanel.ArrowType.NONE);
                    break;
                case "Triangulo":
                    pizarraActual.setArrowType(PizarraPanel.ArrowType.TRIANGLE);
                    break;
                case "Diamante":
                    pizarraActual.setArrowType(PizarraPanel.ArrowType.DIAMOND);
                    break;
            }
        }
    }

    // Método para obtener la pizarra actualmente seleccionada
    private PizarraPanel obtenerPizarraActual() {
        int selectedIndex = tabbedPane.getSelectedIndex();
        if (selectedIndex != -1) {
            return pizarras.get(selectedIndex);
        }
        return null;
    }
}
