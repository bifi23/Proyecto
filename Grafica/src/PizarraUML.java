

import javax.swing.*;
import java.awt.*;
import Command.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Decorator.Flecha;
import Pizarra.Pizarra;
import clasesdecorator.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PizarraUML extends JFrame {
    private JTabbedPane tabbedPane;
    private List<PizarraPanel> pizarras;
    private JButton agregarTabButton;
    private JButton cerrarTabButton;
    private JButton guardarButton;
    private JComboBox<String> colorComboBox;
    private JComboBox<String> modeComboBox;
    private JComboBox<String> arrowComboBox;

    public PizarraUML() {
        setTitle("Pizarra Múltiple");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        tabbedPane = new JTabbedPane();
        pizarras = new ArrayList<>();

        agregarTabButton = new JButton("Agregar Pizarra");
        agregarTabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPizarra();
            }
        });

        cerrarTabButton = new JButton("Cerrar Pizarra");
        cerrarTabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPizarra();
            }
        });

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPizarra();
            }
        });

        colorComboBox = new JComboBox<>(new String[]{"Negro", "Rojo", "Azul", "Verde"});
        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarColor((String) colorComboBox.getSelectedItem());
            }
        });

        modeComboBox = new JComboBox<>(new String[]{"Linea", "Rectangulo", "Entidad", "Flecha"});
        modeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarModo((String) modeComboBox.getSelectedItem());
            }
        });

        arrowComboBox = new JComboBox<>(new String[]{"Ninguna", "Triangulo", "Diamante"});
        arrowComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarTipoFlecha((String) arrowComboBox.getSelectedItem());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarTabButton);
        buttonPanel.add(cerrarTabButton);
        buttonPanel.add(guardarButton);
        buttonPanel.add(colorComboBox);
        buttonPanel.add(modeComboBox);
        buttonPanel.add(arrowComboBox);

        add(tabbedPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void agregarPizarra() {
        PizarraPanel nuevaPizarra = new PizarraPanel();
        pizarras.add(nuevaPizarra);
        tabbedPane.addTab("Pizarra " + pizarras.size(), nuevaPizarra);
        tabbedPane.setSelectedComponent(nuevaPizarra);
    }

    private void cerrarPizarra() {
        int selectedIndex = tabbedPane.getSelectedIndex();
        if (selectedIndex != -1) {
            tabbedPane.remove(selectedIndex);
            pizarras.remove(selectedIndex);
        }
    }

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
//        if (pizarraActual != null) {
//            pizarraActual.setColorLinea(nuevoColor);
//        }
        assert pizarraActual != null;
        pizarraActual.setColorFigura(nuevoColor);
        pizarraActual.repaint();
    }

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

    private PizarraPanel obtenerPizarraActual() {
        int selectedIndex = tabbedPane.getSelectedIndex();
        if (selectedIndex != -1) {
            return pizarras.get(selectedIndex);
        }
        return null;
    }
    }

