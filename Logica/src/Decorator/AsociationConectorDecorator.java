package Decorator;

/**
 * Clase que representa un decorador para agregar el rombo o punta triangular de asociación a un conector.
 */
public class AsociationConectorDecorator extends ConectorDecorator {

    /**
     * Constructor que inicializa el decorador con un conector decorado.
     *
     * @param decoratedArrow Conector decorado al que se le añadirá el rombo o punta triangular de asociación.
     */
    public AsociationConectorDecorator(Conector decoratedArrow) {
        super(decoratedArrow);
    }

    /**
     * {@inheritDoc}
     * Añade la funcionalidad de imprimir un mensaje sobre la adición del rombo o punta triangular de asociación.
     * Además, establece el relleno y el tipo de punta del conector.
     */
    @Override
    public void draw() {
        super.draw();
        setRelleno(true);
        setTipoPunta(true);
        System.out.println("Añadiendo rombo o punta triangular de Agregación");
    }
}