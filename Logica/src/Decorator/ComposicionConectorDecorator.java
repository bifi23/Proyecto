package Decorator;

/**
 * Clase que representa un decorador para agregar el rombo o punta triangular de composición a un conector.
 */
public class ComposicionConectorDecorator extends ConectorDecorator {

    /**
     * Constructor que inicializa el decorador con un conector decorado.
     *
     * @param decoratedArrow Conector decorado al que se le añadirá el rombo o punta triangular de composición.
     */
    public ComposicionConectorDecorator(Conector decoratedArrow) {
        super(decoratedArrow);
    }

    /**
     * {@inheritDoc}
     * Añade la funcionalidad de imprimir un mensaje sobre la adición del rombo o punta triangular de composición.
     * Además, establece el relleno y el tipo de punta del conector.
     */
    @Override
    public void draw() {
        super.draw();
        setRelleno(true);
        setTipoPunta(false);
        System.out.println("Añadiendo rombo o punta triangular de composición");
    }
}