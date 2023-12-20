


import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Decorator.Flecha;
import Pizarra.Pizarra;
import Command.*;
import clasesdecorator.*;

public class PizarraUML extends JPanel {
    private List<PizarraPanel> pizarras;

    private Pizarra pizarraL;
    private PizarraPanel pizarraPanel;
    private JComboBox<Flecha> tipoFlechaComboBox;
    private JLabel nombrePizarraLabel;
    private boolean primeraVez = true;
    private int numeroClases;
    private JButton guardarButton;



    public PizarraUML() {
        pizarraL = new Pizarra(new ArrayList<>(), new ArrayList<>());
        CommandConfiguracion.CommandConfiguracion(pizarraL);
        ComponentesInicial();
        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPizarra();
            }
        });

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
    private void ComponentesInicial() {
        setLayout(new BorderLayout());

        pizarraPanel = new PizarraPanel(pizarraL);
        add(pizarraPanel, BorderLayout.CENTER);

        nombrePizarraLabel = new JLabel("Nombre de la Pizarra: " + pizarraL.getNombre());
        add(nombrePizarraLabel, BorderLayout.NORTH);

        JPanel botonesPanel = new JPanel();
        JPanel clasesPanel = new JPanel();
        clasesPanel.setLayout(new BoxLayout(clasesPanel, BoxLayout.Y_AXIS));

        JButton cargarButton = new JButton("Cargar Pizarra");
        JButton botonBorrarTodo = new JButton("Borrar todo");
        JButton anadirClaseC = new JButton("Crear clase Completa");
        JButton anadirClaseA = new JButton("Crear clase con titulo y atributos");
        JButton anadirClaseM = new JButton("Crear clase con titulo y metodos");



        /**
         * Guarda la pizarra con cierto nombre
         */


        /**
         * Utiliza el boton 2 para cargar la pizarra con cierto nombre
         */
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nombre EXACTO de pizarra a cargar:");
                pizarraL.setNombre(nuevoNombre);
                nombrePizarraLabel.setText(pizarraL.getNombre());
                pizarraL.clickBoton2();
                pizarraPanel.repaint();
            }
        });

        /**
         * Escucha si se presiona el boton, si lo hace, entonces crea una nueva clase, se le asigna su vista
         * y deja arrastrarlo visualmente
         */
        anadirClaseC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pizarraL.clickBoton6(); //crea una clase completa y lo guarda en la pizarra
                numeroClases = pizarraL.getArrayclases().size();
                Clase actual = pizarraL.getArrayclases().get(numeroClases -1);
                ClaseCompletaVista cv = new ClaseCompletaVista();
                //cv.paint(g, actual);

                pizarraPanel.repaint();
            }
        }); //Se debe implementar esto para las otras vistas de clases

        /**
         * Escucha si se presiona el boton, si lo hace, entonces crea una nueva clase, se le asigna su vista
         * y deja arrastrarlo visualmente
         */
        anadirClaseC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pizarraL.clickBoton6(); //crea una clase completa y lo guarda en la pizarra
                numeroClases = pizarraL.getArrayclases().size();
                Clase actual = pizarraL.getArrayclases().get(numeroClases -1);
                ClaseCompletaVista cv = new ClaseCompletaVista();
                //cv.paint(g, actual);

                pizarraPanel.repaint();
            }
        });


        botonBorrarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pizarraL.clickBoton5();
                pizarraPanel.repaint();
            }
        });


        botonesPanel.add(cargarButton);
        botonesPanel.add(botonBorrarTodo);
        add(botonesPanel, BorderLayout.SOUTH);

        clasesPanel.add(anadirClaseC);
        clasesPanel.add(anadirClaseM);
        clasesPanel.add(anadirClaseA);
        add(clasesPanel, BorderLayout.WEST);


        add(clasesPanel, BorderLayout.WEST);

    }
}