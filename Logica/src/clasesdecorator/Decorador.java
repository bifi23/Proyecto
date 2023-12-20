package clasesdecorator;


import java.io.Serializable;

/**
 * Clase abstracta que implementa la interfaz Clase y actúa como base para los decoradores.
 */
public abstract class Decorador implements Clase, Serializable {

    /**
     * Componente que se va a decorar.
     */
    public Clase component;

    /**
     * Constructor que inicializa el decorador con un componente base.
     *
     * @param component Componente base a decorar.
     */
    public Decorador(Clase component){
        this.component = component;
    }

    /**
     * {@inheritDoc}
     *
     * @return Un array de cadenas que representa el módulo del componente decorado.
     */
    @Override
    public String[] modulo(){
        return component.modulo();
    }
}