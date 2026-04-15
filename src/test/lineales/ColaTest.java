package test.lineales;
import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import lineales.dinamicas.*;
/**
 *
 * @author Catedra EDAT - FAI - UNCOMA
 *         Ultima modificación: 10/04/2025
 *
 */

/*
  * Se asume que la salida de toString() para Cola devuelve 
  * un texto que incluye la subcadena del tipo [1,2,3] donde 3 es el fin y 1 el frente de la cola,
  * para una cola donde los elemenos agregados fueron 1, 2 y 3 en ese orden.
  * El texto de salida del toString() puede contener cualquier otro texto antes o despues de la subcadena anterior.
*/

public class ColaTest {

    private static boolean isSubstring(String s, String rx){
        Pattern pattern = Pattern.compile(rx);
        Matcher matcher = pattern.matcher(s);
        boolean findSubstring = false;
        while (matcher.find()) {
            //System.out.println(s.substring(matcher.start(), matcher.end()));
            findSubstring = true;
        }
        return findSubstring;
    }

    private static Cola loadQueue(String elements, char separator) {
        Cola c = new Cola();
        int lengthElements = elements.length();
        char d = ' ';
        String number = "";
        for (int i = 0; i < lengthElements; i++) {
            d = elements.charAt(i);
            if ((d == separator) || (i + 1) == lengthElements) {
                if ((i + 1) == lengthElements)
                    number += d;
                c.poner(Integer.parseInt(number));
                number = "";
            } else {
                number += d;
            }
        }
        return c;
    }

    @Test
    public void testCreateEmptyQueue() {
        Cola c = new Cola();
        boolean ev = c.esVacia();
        Object f = c.obtenerFrente();
        String s = c.toString();
        assertEquals(ev,true);
        assertEquals(f, null);
        String rx="\\[\\]";
        assertEquals(s.matches(rx),true);
    };

    @Test
    public void testAddFirstElement() {
        Cola c=new Cola();
        boolean po = c.poner(1);
        boolean ev = c.esVacia();
        Object f = c.obtenerFrente();
        String s = c.toString();
        assertEquals(po,true);
        assertEquals(ev,false);
        assertEquals(f, 1);
        String rx="\\[1\\]";
        System.err.println(s);
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testAddElementInNonEmptyQueue() {
        Cola c=loadQueue("1,2",',');
        boolean po = c.poner(3);
        boolean ev = c.esVacia();
        int f =(int) c.obtenerFrente();
        String s = c.toString();
        assertEquals(po,true);
        assertEquals(ev,false);
        assertEquals(f, 1);
        String rx="\\[1,2,3\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);
    };

    @Test
    public void testRemoveFromQueueWithOnlyOneElement() {
        Cola c=loadQueue("1",',');
        boolean sac = c.sacar();
        boolean ev = c.esVacia();
        Object f = c.obtenerFrente();
        String s = c.toString();
        assertEquals(sac,true);
        assertEquals(ev,true);
        assertEquals(f, null);
        String rx="\\[\\]";
        assertEquals(s.matches(rx),true);

    };

    @Test
    public void testRemoveFromQueueWithMoreThanOneElement() {
        Cola c=loadQueue("1,2,3",',');
        boolean sac = c.sacar();
        boolean ev = c.esVacia();
        Object f = c.obtenerFrente();
        String s = c.toString();
        assertEquals(sac,true);
        assertEquals(ev,false);
        assertEquals(f, 2);
        String rx="\\[2,3\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testRemoveFromEmptyQueue() {
        Cola c=new Cola();
        boolean sac = c.sacar();
        boolean ev = c.esVacia();
        Object f = c.obtenerFrente();
        String s = c.toString();
        assertEquals(sac,false);
        assertEquals(ev,true);
        assertEquals(f, null);
        String rx="\\[\\]";
        assertEquals(s.matches(rx),true);

    };

    @Test
    public void testEmtpyQueue() {
        Cola c=loadQueue("1,2,3",',');
        c.vaciar();
        boolean ev = c.esVacia();
        Object f = c.obtenerFrente();
        String s = c.toString();
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(ev,true);
        assertEquals(f, null);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testCloneNonEmptyQueue(){
        Cola c=loadQueue("1,2,3",',');
        Cola cClone=c.clone();
        boolean ev = c.esVacia();
        boolean evClone = cClone.esVacia();
        Object f = c.obtenerFrente();
        Object fClone = cClone.obtenerFrente();
        String s = c.toString();
        String sClone = cClone.toString();
        String rx="\\[1,2,3\\]";
        boolean findSubstring = isSubstring(s,rx);
        boolean findSubstringClone = isSubstring(sClone, rx);
        assertEquals(ev,false);
        assertEquals(evClone,false);
        assertEquals(f, 1);
        assertEquals(fClone,1);
        assertEquals(findSubstring,true);
        assertEquals(findSubstringClone,true);
        assertNotEquals(cClone,c);
        assertEquals(s,sClone);
    }

    @Test
    public void testCloneEmptyQueue(){
        Cola c=new Cola();
        Cola cClone=c.clone();
        boolean ev = c.esVacia();
        boolean evClone = cClone.esVacia();
        Object f = c.obtenerFrente();
        Object fClone = cClone.obtenerFrente();
        String s = c.toString();
        String sClone = cClone.toString();
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        boolean findSubstringClone = isSubstring(sClone, rx);
        assertEquals(ev,true);
        assertEquals(evClone,true);
        assertEquals(f, null);
        assertEquals(fClone,null);
        assertEquals(findSubstring,true);
        assertEquals(findSubstringClone,true);
        assertNotEquals(cClone,c);
        assertEquals(s,sClone);
        
    }

}
