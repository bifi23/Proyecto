package Pizarra;



import java.io.*;

public class ArchivoPizarra implements Serializable {
    /**
     * Funcion que carga los atributos de un archivo de pizarra con un nombre definido porel usuario
     * para usarla se llama al boton 1 desde la clase pizarra
     * @param pizarra: se crea una pizarra en blanco con el nombre de la pizarra a cargar, luego se carga
     * @return: retorna la pizarra cargada
     */
    public void cargar(Pizarra pizarra) {
        String nombreArchivo = pizarra.getNombre();
        pizarra = null;
        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            pizarra = (Pizarra) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** guardar: Funcion que guarda los atributos de la pizarra como un archivo con el nombre de esta,
     * para usarla se llama al boton 1 desde la clase pizarra
     * @param pizarra: Pizarra que se va a guardar como archivo
     */
    public void guardar(Pizarra pizarra) {
        String nombreArchivo = pizarra.getNombre();
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(pizarra);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}