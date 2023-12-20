package clasesdecorator;


import java.io.Serializable;

/**
 * Clase concreta que implementa la interfaz Clase y representa un componente base en el contexto UML.
 */
public class ComponenteBase implements Clase, Serializable {

    private String titulo;
    private int coordX, coordY;


    /**
     * Constructor que inicializa el componente base con un título.
     *
     * @param titulo Título del componente base.
     */
    public ComponenteBase(String titulo) {
        this.titulo = titulo;
    }

    /**recibe la coordenada de la pizarra
     * @param x: Coordenada x de la pizarra
     */
    public void setCoordX(int x){
        this.coordX = x;
    }
    /**recibe la coordenada de la pizarra
     * @param y: Coordenada x de la pizarra
     */
    public void setCoordY(int y){
        this.coordY = y;
    }

    /**@return coordenada x
     */
    public int getCoordX(){
        return coordX;
    }
    /**@return coordenada y
     */
    public int getCoordY(){
        return coordY;
    }

    /**
     * {@inheritDoc}
     *
     * @return Un array de cadenas que representa los componentes base.
     */
    @Override
    public String[] modulo() {
        return new String[]{titulo};
    }
}