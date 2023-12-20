package clasesdecorator;


/**
 * Clase concreta que extiende a Decorador y representa un método de una clase en el contexto UML.
 */
public class ClaseMetodo extends Decorador {

    private String metodo;

    /**
     * Constructor que inicializa la clase método.
     *
     * @param clase Clase base a decorar.
     * @param metodo Método a agregar a la clase.
     */
    public ClaseMetodo(Clase clase, String metodo){
        super(clase);
        this.metodo = metodo;
    }

    /**
     * {@inheritDoc}
     *
     * @return Un array de cadenas que representa  la clase con el método.
     */
    @Override
    public String[] modulo(){
        String[] moduloBase = super.modulo();
        String[] moduloConMetodo = new String[moduloBase.length + 1];
        System.arraycopy(moduloBase, 0, moduloConMetodo, 0, moduloBase.length);
        moduloConMetodo[moduloBase.length] = metodo;
        return moduloConMetodo;
    }
}