package Decorator;

import java.io.Serializable;


import java.io.Serializable;

/**
 * Clase que implementa la interfaz Conector y representa un conector simple en el contexto del Editor de Diagrama UML.
 */
public class SimpleConector implements Conector, Serializable {

    /**
     * Coordenada x del punto inicial del conector.
     */
    private int x;

    /**
     * Coordenada y del punto inicial del conector.
     */
    private int y;

    /**
     * Tipo de flecha del conector.
     */
    private Flecha arrowType;

    /**
     * Indica si el conector debe mostrar un número de serie.
     */
    private boolean serialNumber;

    /**
     * Coordenada x del punto final del conector.
     */
    private int x_j;

    /**
     * Coordenada y del punto final del conector.
     */
    private int y_j;

    /**
     * Indica si el conector debe tener relleno (configuración predeterminada según el tipo de flecha).
     */
    private boolean Relleno;

    /**
     * Indica el tipo de punta del conector (configuración predeterminada según el tipo de flecha).
     */
    private boolean tipoPunta;

    /**
     * Constructor que inicializa un conector simple con las coordenadas iniciales y finales, tipo de flecha, número de serie y tipo de punta.
     *
     * @param x_i Coordenada x del punto inicial del conector.
     * @param y_i Coordenada y del punto inicial del conector.
     * @param arrowType Tipo de flecha del conector.
     * @param serialNumber Indica si el conector debe mostrar un número de serie.
     * @param x_j Coordenada x del punto final del conector.
     * @param y_j Coordenada y del punto final del conector.
     */
    public SimpleConector(int x_i, int y_i, Flecha arrowType, boolean serialNumber, int x_j, int y_j) {
        this.x = x_i;
        this.y = y_i;
        this.arrowType = arrowType;
        this.serialNumber = serialNumber;
        this.x_j = x_j;
        this.y_j = y_j;
        this.Relleno = arrowType.getRellenoPredeterminado();
        this.tipoPunta = arrowType.getTipoPuntaPredeterminado();
    }

    /**
     * {@inheritDoc}
     * Imprime un mensaje indicando el tipo de flecha, las coordenadas iniciales y finales, el número de serie, el relleno y el tipo de punta del conector.
     */
    @Override
    public void draw() {
        System.out.println("Dibujando flecha de tipo " + arrowType + " inicia en coordenada(" + x + ", " + y + ") con número de serie " +
                serialNumber + " con relleno " + Relleno + " y tipo de punta " + (tipoPunta ? "triangular" : "rombo") + ", finaliza en la coordenada (" + x_j + "," + y_j + ")");
    }

    /**
     * {@inheritDoc}
     * Establece si el conector debe mostrar un número de serie.
     *
     * @param serialNumber true si se debe mostrar el número de serie, false de lo contrario.
     */
    @Override
    public void setSerialNumber(boolean serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * {@inheritDoc}
     * Establece si el conector debe tener relleno.
     *
     * @param Relleno true si se debe tener relleno, false de lo contrario.
     */
    @Override
    public void setRelleno(boolean Relleno) {
        this.Relleno = Relleno;
    }

    /**
     * {@inheritDoc}
     * Establece el tipo de punta del conector.
     *
     * @param tipoPunta true si la punta es triangular, false si es un rombo.
     */
    @Override
    public void setTipoPunta(boolean tipoPunta) {
        this.tipoPunta = tipoPunta;
    }

    /**
     * Obtiene el estado actual del número de serie del conector.
     *
     * @return true si el número de serie está activado(punta a la derecha), false de lo contrario.
     */
    public boolean isSerialNumber() {
        return serialNumber;
    }

    public boolean isRelleno() {
        return Relleno;
    }

    public boolean isTipoPunta() {
        return tipoPunta;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Flecha getArrowType() {
        return arrowType;
    }

    public int getX_j() {
        return x_j;
    }

    public int getY_j() {
        return y_j;
    }
}