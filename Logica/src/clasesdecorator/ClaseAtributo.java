package clasesdecorator;


import java.io.Serializable;

/**
 * Clase concreta que extiende a Decorador y representa un atributo de una clase en la pizarra UML.
 */
public class ClaseAtributo extends Decorador implements Serializable {

    private String atributo;

    /**
     * Constructor que inicializa la clase atributo.
     *
     * @param clase Clase base a decorar.
     * @param atributo Atributo a agregar a la clase.
     */
    public ClaseAtributo(Clase clase, String atributo){
        super(clase);
        this.atributo = atributo;
    }

    /**
     * {@inheritDoc}
     *
     * @return Un array de cadenas que con el módulo de la clase con el atributo.
     */
    @Override
    public String[] modulo(){
        String[] moduloBase = super.modulo();
        String[] moduloConAtributo = new String[moduloBase.length + 1];
        System.arraycopy(moduloBase, 0, moduloConAtributo, 0, moduloBase.length);
        moduloConAtributo[moduloBase.length] = atributo;
        return moduloConAtributo;
    }
}