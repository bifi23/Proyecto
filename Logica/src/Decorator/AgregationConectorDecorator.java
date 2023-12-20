package Decorator;


/**
 * Clase que representa un decorador para agregar la punta triangular o rombo de agregación a un conector.
 */
public class AgregationConectorDecorator extends ConectorDecorator {

    /**
     * Constructor que inicializa el decorador con un conector decorado.
     *
     * @param decoratedArrow Conector decorado al que se le añadirá la punta triangular o rombo de agregación.
     */
    public AgregationConectorDecorator(Conector decoratedArrow) {
        super(decoratedArrow);
    }

    /**
     * {@inheritDoc}
     * Añade la funcionalidad de imprimir un mensaje sobre la adición de la punta triangular o rombo de agregación.
     */
    @Override
    public void draw() {
        super.draw();
        System.out.println("Añadiendo punta triangular o rombo de agregación");
    }
}