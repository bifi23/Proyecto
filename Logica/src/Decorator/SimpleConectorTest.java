package Decorator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;

public class SimpleConectorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testDraw() {
        SimpleConector conector = new SimpleConector(0, 0, Flecha.SIMPLE, true, 10, 10);
        conector.draw();

        String expectedOutput = "Dibujando flecha de tipo SIMPLE inicia en coordenada(0, 0) con número de serie true con relleno true y tipo de punta rombo, finaliza en la coordenada (10,10)";

        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }



    @Test
    public void testDraw2() {
        SimpleConector conector = new SimpleConector(0, 0, Flecha.SIMPLE, true, 10, 10);
        conector.draw();

    }

    @Test
    public void testSetSerialNumber() {
        SimpleConector conector = new SimpleConector(0, 0, Flecha.SIMPLE, true, 10, 10);
        conector.setSerialNumber(false);
        assertFalse(conector.isSerialNumber());
    }

    @Test
    public void testSetRelleno() {
        SimpleConector conector = new SimpleConector(0, 0, Flecha.SIMPLE, true, 10, 10);
        conector.setRelleno(true);
        assertTrue(conector.isRelleno());
    }

    @Test
    public void testSetTipoPunta() {
        SimpleConector conector = new SimpleConector(0, 0, Flecha.SIMPLE, true, 10, 10);
        conector.setTipoPunta(false);
        assertFalse(conector.isTipoPunta());
    }

}