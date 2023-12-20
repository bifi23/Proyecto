package Decorator;


import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Interfaz que define el comportamiento de un conector en el contexto del Editor de Diagrama UML.
 */
public interface Conector extends Serializable {

    /**
     * Método que se encarga de dibujar el conector.
     */
    void draw();

    /**
     * Establece si el conector debe mostrar un número de serie.
     *
     * @param serialNumber true si se debe mostrar el número de serie, false de lo contrario.
     */
    void setSerialNumber(boolean serialNumber);

    /**
     * Establece si el conector debe tener relleno.
     *
     * @param relleno true si se debe tener relleno, false de lo contrario.
     */
    void setRelleno(boolean relleno);

    /**
     * Establece el tipo de punta del conector.
     *
     * @param tipoPunta true si la punta es triangular, false si es un rombo.
     */
    void setTipoPunta(boolean tipoPunta);
}
