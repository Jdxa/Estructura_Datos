package test.lineales;
import org.junit.Test;
import static org.junit.Assert.*;
import lineales.estaticas.*;

public class PilaTestGrupo{
    private Pila load_stack(String elements, char separator) {
        Pila p = new Pila();
        int lengthElements = elements.length();
        char d = ' ';
        String number = "";
        for (int i = 0; i < lengthElements; i++) {
            d = elements.charAt(i);
            if ((d == separator) || (i + 1) == lengthElements) {
                if ((i + 1) == lengthElements)
                    number += d;
                p.apilar(Integer.parseInt(number));
                number = "";
            } else {
                number += d;
            }
        }
        return p;
    }


    @Test
    public void testCreateEmptyStack() {
        Pila p = new Pila();
        boolean ev = p.esVacia();
        assertTrue(ev);
    }
    @Test
    public void testStackFirstElement() {
        Pila p=new Pila();
        boolean ap = p.apilar(1);
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        assertEquals(ap,true);
        assertEquals(ev,false);
        assertEquals(t, 1);

    }
    @Test
    public void testStackElementInNonEmptyStack() {
        Pila p= load_stack("1,2",',');
        boolean ap = p.apilar(3);
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        assertEquals(ap,true);
        assertEquals(ev,false);
        assertEquals(t, 3);
    }
    
    @Test
    public void testUnstackInEmptyStack() {
        Pila p = new Pila();
        boolean s = p.desapilar();
        assertFalse(s);
    }
    @Test    
    public void testUnstackInStackWithOnlyOneElement() {
        Pila p = new Pila();
        p.apilar(1);
        boolean s = p.desapilar();
        assertEquals(s, true);
        assertEquals(p.esVacia(), true);
    }
    @Test
    public void testUnstackInStackWithSomeElements() {
       Pila p = new Pila();
        p.apilar(1);
        p.apilar(2);
        boolean s = p.desapilar();
        Object t = p.obtenerTope();
        assertEquals(s, true);
        assertEquals(t, 1);
        assertEquals(p.esVacia(), false);
    }
    @Test   
    public void testCloneStack() {
        Pila p = new Pila();
        p.apilar(1);
        p.apilar(2);
        Pila clone = p.clone();
        assertEquals(p.obtenerTope(), clone.obtenerTope());
        assertEquals(p.esVacia(), clone.esVacia());
    }
    @Test
    public void testCloneEmptyStack() {
        Pila p = new Pila();
        Pila clone = p.clone();
        assertEquals(p.obtenerTope(), clone.obtenerTope());
        assertEquals(p.esVacia(), clone.esVacia());


    }
}