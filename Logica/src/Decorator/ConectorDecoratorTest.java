package Decorator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class ConectorDecoratorTest {
        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        public ConectorDecoratorTest() {
        }

        @Before
        public void setUpStreams() {
            System.setOut(new PrintStream(this.outContent));
        }

        @After
        public void restoreStreams() {
            System.setOut(System.out);
        }

        @Test
        public void testConectorDecorator() {
            Conector simpleConector = new SimpleConector(0, 0, Flecha.SIMPLE, true, 1, 1);
            ConectorDecorator herenciaDecorator = new HerenciaConectorDecorator(simpleConector);
            ConectorDecorator composicionDecorator = new ComposicionConectorDecorator(simpleConector);
            ConectorDecorator asociacionDecorator = new AsociationConectorDecorator(simpleConector);
            ConectorDecorator agregacionDecorator = new AgregationConectorDecorator(simpleConector);
            herenciaDecorator.draw();
            Assert.assertTrue(this.systemOut().contains("Añadiendo punta triangular o rombo de herencia"));
            composicionDecorator.draw();
            Assert.assertTrue(this.systemOut().contains("Añadiendo rombo o punta triangular de composición"));
            asociacionDecorator.draw();
            Assert.assertTrue(this.systemOut().contains("Añadiendo rombo o punta triangular de Agregación"));
            agregacionDecorator.draw();
            Assert.assertTrue(this.systemOut().contains("Añadiendo punta triangular o rombo de agregación"));
        }

        private String systemOut() {
            return this.outContent.toString();
        }
    }


