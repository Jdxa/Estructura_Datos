package test.lineales;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// import lineales.entregas.WeimbergerBacciNehuelLammel.estaticas.*;
import lineales.dinamicas.*;
/**
 *
 * @author Catedra EDAT - FAI - UNCOMA
 *         Ultima modificación: 17/03/2025
 *
 */

/*
  * Se asume que la salida de toString() para Pila devuelve 
  * un texto que incluye la subcadena del tipo [3,2,1] donde 3 es el tope y 1 la base de la pila,
  * para una pila donde los elemenos apilados fueron 1, 2 y 3 en ese orden.
  * El texto de salida del toString() puede contener cualquier otro texto antes o despues de la subcadena anterior.
  */
  
public class PilaTest {

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

    private static Pila load_stack(String elements, char separator) {
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
        //System.out.println(p.toString());
        return p;
    }

    @Test
    public void testCreateEmptyStack() {
        Pila p = new Pila();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(ev,true);
        assertEquals(t, null);
        assertEquals(findSubstring,true);
    };

    @Test
    public void testStackFirstElement() {
        Pila p=new Pila();
        boolean ap = p.apilar(1);
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        String rx="\\[1\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(ap,true);
        assertEquals(ev,false);
        assertEquals(t, 1);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testStackElementInNonEmptyStack() {
        Pila p=load_stack("1,2",',');
        boolean ap = p.apilar(3);
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        String rx="\\[3,2,1\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(ap,true);
        assertEquals(ev,false);
        assertEquals(t, 3);
        assertEquals(findSubstring,true);
    };

    @Test
    public void testUnstackStackWithOnlyOneElement() {
        Pila p=load_stack("1",',');
        p.desapilar();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(ev,true);
        assertEquals(t, null);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testUnstackStackWithMoreThanOneElement() {
        Pila p=load_stack("1,2,3",',');
        boolean des=p.desapilar();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        String rx="\\[2,1\\]";
        assertEquals(des,true);
        assertEquals(ev,false);
        assertEquals(t, 2);
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testUnstackEmptyStack() {
        Pila p=new Pila();
        boolean des = p.desapilar();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s, rx);
        assertEquals(des,false);
        assertEquals(ev,true);
        assertEquals(t, null);
        assertEquals(findSubstring,true);
    };

    @Test
    public void testCloneNonEmptyStack(){
        Pila p=load_stack("1,2,3",',');
        Pila pClone=p.clone();
        boolean ev = p.esVacia();
        boolean evClone = pClone.esVacia();
        Object t = p.obtenerTope();
        Object tClone = pClone.obtenerTope();
        String s = p.toString();
        String sClone = pClone.toString();
        String rx="\\[3,2,1\\]";
        boolean findSubstring = isSubstring(s,rx);
        boolean findSubstringClone = isSubstring(sClone, rx);
        assertEquals(ev,false);
        assertEquals(evClone,false);
        assertEquals(t, 3);
        assertEquals(tClone,3);
        assertEquals(findSubstring,true);
        assertEquals(findSubstringClone,true);
        assertNotEquals(pClone,p);
        assertEquals(s,sClone);
    }

    @Test
    public void testCloneEmptyStack(){
        Pila p=new Pila();
        Pila pClone=p.clone();
        boolean ev = p.esVacia();
        boolean evClone = pClone.esVacia();
        Object t = p.obtenerTope();
        Object tClone = pClone.obtenerTope();
        String s = p.toString();
        String sClone = pClone.toString();
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        boolean findSubstringClone = isSubstring(sClone, rx);
        assertEquals(ev,true);
        assertEquals(evClone,true);
        assertEquals(t, null);
        assertEquals(tClone,null);
        assertEquals(findSubstring,true);
        assertEquals(findSubstringClone,true);
        assertNotEquals(pClone,p);
        assertEquals(s,sClone);
        
    }

}
