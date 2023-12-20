package Decorator;

import java.io.*;
import java.util.List;

/**
 * clase para declarar metodos estaticos para serializar y desserializar la lista de los objetos
 */
public class ConectorManager {
    /**
     * Este método toma una lista de conectores y un nombre de archivo como parámetros.
     * @param conectores
     * @param nombreArchivo
     */
    public static void serializarConectores(List<Conector> conectores, String nombreArchivo) {
        /**
         * se utiliza un bloque try-with-resources.
         * ObjectOutputStream se encarga de escribir objetos en un flujo de salida (FileOutputStream),
         *  que se conecta a un archivo con el nombre proporcionado.
         */
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            /**
             * Se escribe la lista de conectores en el flujo de salida.
             */
            oos.writeObject(conectores);
            System.out.println("Objetos serializados con exito.");
            /**
             * En caso de que ocurra una excepción de tipo IOException
             * (por ejemplo, si hay un problema al escribir en el archivo),
             * se imprime la traza de la excepción.
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**Método deserializarConectores:
     * Este método toma un nombre de archivo como parámetro
     * @param nombreArchivo
     * @return devuelve una lista de conectores.
     */
    public static List<Conector> deserializarConectores(String nombreArchivo) {
        /**
         * Se inicia una variable para almacenar la lista de conectores que se deserializará.
         */
        List<Conector> conectores = null;
        /**
         * Se utiliza un bloque try-with-resources similar al método de serialización.
         *  El ObjectInputStream lee objetos desde un flujo de entrada (FileInputStream),
         *  que está conectado al archivo con el nombre proporcionado
         */
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            conectores = (List<Conector>) ois.readObject();
            System.out.println("Objetos deserializados correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conectores;
    }
}