package Decorator;

import java.io.Serializable;

/**
 * Clase abstracta que implementa la interfaz Conector y actúa como base para los decoradores de conectores.
 */
public abstract class ConectorDecorator implements Conector, Serializable  {

    /**
     * Conector decorado al que se le añadirán funcionalidades adicionales.
     */
    protected Conector decoratedArrow;

    /**
     * Indica el tipo de punta del conector.
     */
    protected boolean tipoPunta;

    /**
     * Indica si el conector debe tener relleno.
     */
    protected boolean Relleno;

    /**
     * Constructor que inicializa el decorador con un conector decorado.
     *
     * @param decoratedArrow Conector decorado al que se le añadirán funcionalidades adicionales.
     */
    public ConectorDecorator(Conector decoratedArrow) {
        this.decoratedArrow = decoratedArrow;
    }

    /**
     * {@inheritDoc}
     * Añade funcionalidades adicionales al dibujar el conector, como establecer el relleno y el tipo de punta.
     */
    @Override
    public void draw() {
        decoratedArrow.draw();
        setRelleno(Relleno);
        setTipoPunta(tipoPunta);
    }

    /**
     * {@inheritDoc}
     * Propaga la configuración del número de serie al conector decorado.
     */
    @Override
    public void setSerialNumber(boolean serialNumber) {
        decoratedArrow.setSerialNumber(serialNumber);
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
}