package Pizarra;



import clasesdecorator.*;
import java.io.Serializable;
import java.util.ArrayList;

public class ElementosPizarra implements Serializable {
    /** Añade una clase con 2 strings, se activa con el boton 3
     * @param p: Pizarra a la que se le añadira las clase con titulo y campo para atributos
     */
    public void AddClaseAtrbuto(Pizarra p){
        Clase componenteBase = new ComponenteBase("<Titulo>");
        p.addClase(new ClaseAtributo(componenteBase, "<Atributos>"));
    }
    /** Añade una clase con 4 strings, se activa con el boton 4
     * @param p: Pizarra a la que se le añadira las clase con titulo y campo para metodos
     */
    public void AddClaseMetodo(Pizarra p){
        Clase componenteBase = new ComponenteBase("<Titulo>");
        p.addClase(new ClaseMetodo(componenteBase, "<Metodos>"));
    }

    /** Añade una clase con 3 strings, se activa con el boton 6
     * @param p: Pizarra a la que se le añadira las clase Completa
     */
    public void AddClaseCompleta(Pizarra p){
        Clase componenteBase = new ComponenteBase("<Titulo>");
        Clase claseAtributo = new ClaseAtributo(componenteBase, "<Atributos>");
        Clase completa = new ClaseMetodo(claseAtributo, "<Metodos>");
        p.addClase(completa);
    }
    public void DeleteElement(){

    }

    /** Metodo que sirve para borrar todas las clases y conectores del UML almacenadas en sus arraylists
     * en la pizarra p
     * @param p: instancia de la pizarra donde se borrara sus contenidos
     */
    public void DeleteAll(Pizarra p){
        ArrayList conectores = p.getArrayconectores();
        ArrayList clases = p.getArrayclases();
        for (int i = 0; i < conectores.size(); i++) {
            conectores.remove(i);
        }
        for (int i = 0; i < clases.size(); i++) {
            clases.remove(i);
        }
    }
}