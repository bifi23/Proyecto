package Pizarra;


import org.junit.Test;
import static org.junit.Assert.assertTrue;



import java.util.ArrayList;

public class testGuardar {
    @Test
    public void testGuardar() {
        ArchivoPizarra archivoPizarra = new ArchivoPizarra();
        Pizarra pizarra = new Pizarra(new ArrayList<>(),new ArrayList<>());
        pizarra.setNombre("mi_pizarra_test");

        archivoPizarra.guardar(pizarra);

        java.io.File file = new java.io.File("mi_pizarra_test");
        assertTrue(file.exists());
    }
}
