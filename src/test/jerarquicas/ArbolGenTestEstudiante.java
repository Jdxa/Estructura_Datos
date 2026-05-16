package test.jerarquicas;
import lineales.dinamicas.Lista;
import static org.junit.Assert.*;
import org.junit.Test;

import jerarquicas.ArbolGen;

public class ArbolGenTestEstudiante {

    
    public static ArbolGen cargarArb(){
        ArbolGen arbol = new ArbolGen();
        arbol.insertar("A", null);

        arbol.insertar("B", "A");
        arbol.insertar("C", "A");
        arbol.insertar("D", "A");

        arbol.insertar("E", "B");
        arbol.insertar("F", "B");

        arbol.insertar("G", "D");
        return arbol;
    }
    ArbolGen arbol = cargarArb();
    
    
    @Test
    public void testPertenece() {
        assertTrue(arbol.pertenece("A"));
        assertTrue(arbol.pertenece("F"));
        assertFalse(arbol.pertenece("X"));
    }

    @Test
    public void testPadre() {
        assertEquals("A", arbol.padre("B"));
        assertEquals("B", arbol.padre("E"));
        assertEquals("D", arbol.padre("G"));
    }

    @Test
    public void testAltura() {
        assertEquals(2, arbol.altura());
    }

    @Test
    public void testNivel() {
        assertEquals(0, arbol.nivel("A"));
        assertEquals(1, arbol.nivel("B"));
        assertEquals(2, arbol.nivel("F"));
        assertEquals(-1, arbol.nivel("X"));
    }

    @Test
    public void testEsVacio() {
        ArbolGen vacio = new ArbolGen();

        assertTrue(vacio.esVacio());
        assertFalse(arbol.esVacio());
    }

    @Test
    public void testVaciar() {
        arbol.vaciar();

        assertTrue(arbol.esVacio());
    }

    @Test
    public void testClone() {
        ArbolGen clon = arbol.clone();

        assertNotSame(arbol, clon);
        assertEquals(arbol.toString(), clon.toString());
    }

    @Test
    public void testListarPreorden() {
        Lista lista = arbol.listarPreorden();

        String esperado = "[A,D,G,C,B,F,E]";
        assertEquals(esperado, lista.toString());
    }

    @Test
    public void testListarPosorden() {
        Lista lista = arbol.listarPosorden();

        String esperado = "[G,D,C,F,E,B,A]";
        assertEquals(esperado, lista.toString());
    }

    @Test
    public void testListarPorNiveles() {
        Lista lista = arbol.listarNiveles();

        String esperado = "[A,D,C,B,G,F,E]";
        assertEquals(esperado, lista.toString());
    }

    @Test
    public void testInsertarPadreInexistente() {
        boolean exito = arbol.insertar("X", "Z");

        assertFalse(exito);
    }

    @Test
    public void testInsertarRaiz() {
        ArbolGen a = new ArbolGen();

        boolean exito = a.insertar("R", null);

        assertTrue(exito);
        assertEquals(0, a.altura());
    }
}

