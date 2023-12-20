package Decorator;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase que representa una lista de conectores y proporciona métodos para agregar y dibujar conectores.
 */
public class ListConectores {

    /**
     * Lista que almacena los conectores.
     */
    private List<Conector> conectorList = new ArrayList<>();

    /**
     * Agrega un conector a la lista.
     *
     * @param conector Conector a agregar a la lista.
     */
    public void addArrow(Conector conector) {
        conectorList.add(conector);
    }

    /**
     * Dibuja todos los conectores en la lista.
     */
    public void drawAllArrows() {
        for (Conector arrow : conectorList) {
            arrow.draw();
        }
    }
}