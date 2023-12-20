package Pizarra;
import Decorator.*;
import Command.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Pizarra implements Serializable {
    private Command boton1, boton2, boton3, boton4, boton5, boton6;
    private ArrayList<Conector> conectores;
    private ArrayList<Clase> clases;
    private String nombre;

    public Pizarra(ArrayList<Conector> conectores, ArrayList<Clase> clases){
        this.conectores = conectores;
        this.clases = clases;
    }

    /**
     * @return: retorna el nombre de la pizarra
     */
    public String getNombre() {
        return nombre;
    }


    /**
     * @param nombre: Almacena un string que correspondera al nombre de la pizarra
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Funcion para añadir objetos conectores a la pizarra
     * @param conector: Objeto para conectar clases en pizarra UML
     */
    public void addConector(Conector conector) {
        conectores.add(conector);
    }

    /** Funcion para añadir objetos clases a la pizarra
     * @param clase: Objeto que representa clases en pizarra UML
     */
    public void addClase(Clase clase) {
        clases.add(clase);
    }


    /** @return retorna todos los objetos "conectores" que estan en la pizarra UML
     */
    public ArrayList<Conector> getArrayconectores() {
        return conectores;
    }

    /**
     * @param clase: Son los objetos "clase" de la pizarra UML
     */
    public void addClases(Clase clase) {
        clases.add(clase);
    }

    /**
     * @return: retorna todos los objetos "clase" que estan en la pizarra UML
     */
    public ArrayList<Clase> getArrayclases() {
        return clases;
    }

    /** Ejecuta el boton1 (command pattern), que es el encargado de guardar el archivo pizarra
     */
    public void clickBoton1() {
        boton1.execute();
    }

    /** Ejecuta el boton2 (command pattern), que es el encargado de cargar el archivo pizarra
     */
    public void clickBoton2() {
        boton2.execute();
    }

    /**Ejecuta el boton5 (command pattern), borra tod0s los elementos de la pizarra
     */
    public void clickBoton5() {
        boton5.execute();
    }


    /**Botones que añaden objetos ¨clase¨ para la pizarra UML
     *boton3: clase atributo con titulo y atributo
     *boton4: clase metodo con titulo y metodo
     * boton6: clase completa con titulo, atributo y metodo
     */
    public void clickBoton4() {
        boton4.execute();
    }
    public void clickBoton3() {
        boton3.execute();
    }
    public void clickBoton6() {
        boton6.execute();
    }


    /**Getters y setters de botones (los setters se conectan con el command pattern), los set
     * se usan para implementar la funcionalidad de los botones (command pattern)
     *
     * @return: La accion de cada boton
     */
    public Command getBoton1() {
        return boton1;
    }
    public void setBoton1(Command boton1) {
        this.boton1 = boton1;
    }
    public Command getBoton2() {
        return boton2;
    }
    public void setBoton2(Command boton2) {
        this.boton2 = boton2;
    }
    public Command getBoton3() {
        return boton3;
    }
    public void setBoton3(Command boton3) {
        this.boton3 = boton3;
    }
    public Command getBoton4() {
        return boton4;
    }
    public void setBoton4(Command boton4) {
        this.boton4 = boton4;
    }
    public Command getBoton5() {
        return boton5;
    }
    public void setBoton5(Command boton5) {
        this.boton5 = boton5;
    }
    public Command getBoton6() {
        return boton6;
    }
    public void setBoton6(Command boton6) {
        this.boton6 = boton6;
    }


}