package test.lineales;
import org.junit.Test;
// import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.*;

// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

import lineales.estaticas.*;
public class ColaTestGrupo{

    @Test
    public void testCreateEmptyQueue() {
        Cola c = new Cola();
        boolean ev = c.esVacia();
        assertTrue(ev);
    }
    @Test
    public void testEnqueueInEmptyQueue() {
        Cola c = new Cola();
        c.poner(1);
        Object f = c.obtenerFrente();
        assertEquals(f, 1);
        assertEquals(c.esVacia(), false);
    }
    @Test
    public void testEnqueueInNonEmptyQueue() {
        Cola c = new Cola();
        c.poner(1);
        c.poner(2);
        Object f = c.obtenerFrente();
        assertEquals(f, 1);
        assertEquals(c.esVacia(), false);
    }
    @Test
    public void testDequeueInEmptyQueue() {
        Cola c = new Cola();
        boolean s = c.sacar();
        assertFalse(s);
    }
    @Test
    public void testDequeueInQueueWithOnlyOneElement() {
        Cola c = new Cola();
        c.poner(1);
        boolean s = c.sacar();
        assertEquals(s, true);
        assertEquals(c.esVacia(), true);
    }
    @Test
    public void testDequeueInQueueWithSomeElements() {
       Cola c = new Cola();
        c.poner(1);
        c.poner(2);
        boolean s = c.sacar();
        Object f = c.obtenerFrente();
        assertEquals(s, true);
        assertEquals(f, 2);
        assertEquals(c.esVacia(), false);
    }
    @Test
    public void testUnqueueEmptyQueue() {
        Cola c = new Cola();
        boolean s = c.sacar();
        assertEquals(s,false);
    }
    @Test
    public void testCloneQueue() {
        Cola c = new Cola();
        c.poner(1);
        c.poner(2);
        Cola clone = c.clone();
        assertEquals(c.obtenerFrente(), clone.obtenerFrente());
        assertEquals(c.esVacia(), clone.esVacia());
        c.clone().sacar();
        assertNotEquals(c, clone);
    }
    @Test
    public void testCloneEmptyQueue() {
        Cola c = new Cola();
        Cola clone = c.clone();
        Object t = c.obtenerFrente();
        Object cloneT = clone.obtenerFrente();
        Boolean ev = c.esVacia();
        Boolean evClone = clone.esVacia();
        assertEquals(c.obtenerFrente(), clone.obtenerFrente());
        assertEquals(ev, true);
        assertEquals(evClone, true);
        assertNotEquals(c, clone);
        assertEquals(t,null);
        assertEquals(cloneT, null);
    }


}
