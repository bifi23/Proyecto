

import javax.swing.*;
import java.awt.*;
import Command.*;
import java.util.ArrayList;

import Decorator.Flecha;
import Pizarra.Pizarra;
import clasesdecorator.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PizarraUML extends JPanel {
    private Pizarra pizarraL;
    private PizarraPanel pizarraPanel;
    private JComboBox<Flecha> tipoFlechaComboBox;
    private JLabel nombrePizarraLabel;
    private boolean primeraVez = true;
    private int numeroClases;

    public PizarraUML() {
        pizarraL = new Pizarra(new ArrayList<>(), new ArrayList<>());
        CommandConfiguracion.CommandConfiguracion(pizarraL);
        ComponentesInicial();
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

        JButton guardarButton = new JButton("Guardar Pizarra");
        JButton cargarButton = new JButton("Cargar Pizarra");
        JButton botonBorrarTodo = new JButton("Borrar todo");



        /**
         * Guarda la pizarra con cierto nombre
         */
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primeraVez) {
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la pizarra:");

                    if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                        pizarraL.setNombre(nuevoNombre);
                        primeraVez = false;
                    }
                }
                nombrePizarraLabel.setText(pizarraL.getNombre());
                pizarraL.clickBoton1();
                pizarraPanel.repaint();
            }
        });
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



        botonBorrarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pizarraL.clickBoton5();
                pizarraPanel.repaint();
            }
        });


        botonesPanel.add(guardarButton);
        botonesPanel.add(cargarButton);
        botonesPanel.add(botonBorrarTodo);
        add(botonesPanel, BorderLayout.SOUTH);


        add(clasesPanel, BorderLayout.WEST);




    }
}