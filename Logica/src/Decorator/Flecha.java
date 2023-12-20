package Decorator;

/**
 * Enumeración que define diferentes tipos de flechas con sus configuraciones predeterminadas.
 */
public enum Flecha {

    SIMPLE(false, true),  // Triangular: false, Relleno: true
    INHERITANCE(false, true),  // Triangular: false, Relleno: true
    ASSOCIATION(true, true),  // Triangular: true (es rombo), Relleno: true
    AGGREGATION(true, false),  // Triangular: true, Relleno: false
    COMPOSITION(false, true);  // Triangular: false, Relleno: true

    private final boolean tipoPuntaPredeterminado;
    private final boolean rellenoPredeterminado;

    Flecha(boolean tipoPuntaPredeterminado, boolean rellenoPredeterminado) {
        this.tipoPuntaPredeterminado = tipoPuntaPredeterminado;
        this.rellenoPredeterminado = rellenoPredeterminado;
    }

    /**
     * Obtiene el valor predeterminado del tipo de punta.
     *
     * @return true si el tipo de punta es triangular, false si es un rombo.
     */
    public boolean getTipoPuntaPredeterminado() {
        return tipoPuntaPredeterminado;
    }

    /**
     * Obtiene el valor predeterminado del relleno.
     *
     * @return true si se debe tener relleno, false de lo contrario.
     */
    public boolean getRellenoPredeterminado() {
        return rellenoPredeterminado;
    }
}