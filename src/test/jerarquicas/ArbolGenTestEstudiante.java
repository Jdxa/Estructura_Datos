package test.jerarquicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import static org.junit.Assert.*;
import org.junit.Test;

import jerarquicas.ArbolGen;

public class ArbolGenTestEstudiante {
    private ArbolGen cargarArb(){
        ArbolGen arb = new ArbolGen();
        arb.insertar("A", null);
        arb.insertar("B", "A");
        arb.insertar("C", "A");
        arb.insertar("D", "A");
        arb.insertar("E", "B");
        arb.insertar("F", "B");
        arb.insertar("G", "B");
        arb.insertar("H", "D");

        return arb;
    }
    
    @Test
    public void testInsertarArbolVacio(){
        ArbolGen arb = new ArbolGen();
        arb.insertar("A", null);
        String s = arb.toString();
        assertEquals(s,"A -> ");
    }
    @Test
    public void testInsertarArbolnoVacio(){
        ArbolGen arb = cargarArb();
        Lista l = arb.listarPreorden();
        String s = arb.toString();
        assertEquals(s, "a");
        assertEquals(l.toString(),"a");
    }
}
