package test.jerarquicas;
import lineales.dinamicas.Lista;
import static org.junit.Assert.*;
import org.junit.Test;

import jerarquicas.ArbolGen;

/************* Autores ***********
    Joaquin Aguilera, Legajo FAI-4550
    Lucas Peroni, Legajo FAI-5499
    Miguel Mudarra Sucre, Legajo FAI-5172
    Santiago Lencina, Legajo FAI-5789
*/

public class ArbolGenTestEstudiante {

    @Test
    public void testCrearArbolVacio() {
        ArbolGen arbolVacio=new ArbolGen();
        boolean exito=false;
        exito=arbolVacio.esVacio();
        assertTrue(exito);
    }

    @Test
    public void testAgregarElemEnArbolVacio(){
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        boolean exito=false;
        exito=arbol.esVacio();
        assertFalse(exito);
        
    }
@Test
    public void testAgregarElemHijodeRaiz(){
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        boolean exito=false;
        exito=arbol.esVacio();
        assertFalse(exito);
        String d="A:B\nB:"; //esperado
        String s=arbol.toString();
        assertEquals(d, s);
        
    }

    @Test
    public void testAgregarElemSegundoHijo(){
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        arbol.insertar("C", "B");
        boolean exito=false;
        exito=arbol.esVacio();
        assertFalse(exito);
        String d="A:B\nB:C\nC:"; //esperado
        String s=arbol.toString();
        assertEquals(d, s);
        
    }
    @Test
    public void testAgregarElemSinPadrePresente(){
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "D");
        boolean exito=false;
        exito=arbol.esVacio();
        assertFalse(exito);
        String d="A:"; //esperado
        String s=arbol.toString();
        assertEquals(d, s);
        
    }
     @Test
    public void testAgregarElemPorPos1EnVacio(){
        ArbolGen arbol=new ArbolGen();
        arbol.insertarPorPosicion("A", 1);
        
        boolean exito=false;
        exito=arbol.esVacio();
        assertFalse(exito);
        String d="A:"; //esperado
        String s=arbol.toString();
        assertEquals(d, s);
        
    }
     @Test
    public void testAgregarElemPorPos0(){
        ArbolGen arbol=new ArbolGen();
        arbol.insertarPorPosicion("A", 0);
        boolean exito=false;
        exito=arbol.esVacio();
         assertFalse(exito);
        String d="A:"; //esperado
        String s=arbol.toString();
        assertEquals(d, s);
        
        
    }

     @Test
    public void testAgregarElemPorPosMayorA1(){
        ArbolGen arbol=new ArbolGen();
        arbol.insertarPorPosicion("A", 0);
        arbol.insertarPorPosicion("B", 1);
        boolean exito=false;
        exito=arbol.esVacio();
         assertFalse(exito);
        String d="A:B\nB:"; //esperado
        String s=arbol.toString();
        assertEquals(d, s);
        
        
    }

     @Test
    public void testAgregarElemAPadreInexistente(){
        ArbolGen arbol=new ArbolGen();
        arbol.insertarPorPosicion("A", 0);
        arbol.insertarPorPosicion("B", 3);
        boolean exito=false;
        exito=arbol.esVacio();
         assertFalse(exito);
        String d="A:"; //esperado
        String s=arbol.toString();
        assertEquals(d, s);
    }



    @Test
    public void testPerteneceRaiz() {
         ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        Boolean exito=arbol.pertenece("A");
        assertTrue(exito);
    }

    @Test
    public void testPerteneceHoja() {
         ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        Boolean exito=arbol.pertenece("B");
        assertTrue(exito);
    }

    @Test
    public void testNoPertenece() {
         ArbolGen arbol=new ArbolGen();
        Boolean exito=arbol.pertenece("B");
        assertFalse(exito);
    }

    @Test
    public void testNoPerteneceAArbolConUnElem() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        Boolean exito=arbol.pertenece("B");
        assertFalse(exito);
    }

    @Test
    public void testNoPerteneceAArbolConMasElem() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        Boolean exito=arbol.pertenece("C");
        assertFalse(exito);
    }

    @Test
    public void testEsVacia() {
        ArbolGen arbol=new ArbolGen();
        Boolean exito=arbol.esVacio();
        assertTrue(exito);
    }

    @Test
    public void testNoEsVacia() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        Boolean exito=arbol.esVacio();
        assertFalse(exito);
    }

@Test
    public void testPadreMultipleOcurrencia() {

        //busca la primera aparicion del elemento
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        arbol.insertar("C", "A");
        arbol.insertar("E", "B");
        arbol.insertar("E", "A");
        String A="A";
        assertEquals(A, arbol.padre("E"));

    }

    @Test
    public void testPadreUnaOcurrencia() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        String A="A";
        assertEquals(A, arbol.padre("B"));

    }

    @Test
    public void testPadreEnEmpty() {
        ArbolGen arbol=new ArbolGen();
        
        assertEquals(null, arbol.padre("A"));

    }

     @Test
    public void testPadreEnRaiz() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        assertEquals(null, arbol.padre("A"));
    }

    @Test
    public void testAlturaVacio() {
        ArbolGen arbol=new ArbolGen();
        int altura=arbol.altura();
        assertEquals(-1, altura);
    }


    @Test
    public void testAltura1Elemento() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        int altura=arbol.altura();
        assertEquals(0, altura);
    }

    @Test
    public void testAlturaMasElementos() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        arbol.insertar("C", "B");
        int altura=arbol.altura();
        assertEquals(2, altura);
    }

    @Test
    public void testNivelEmpty() {
        ArbolGen arbol=new ArbolGen();
        int nivel= arbol.nivel("A");
        assertEquals(-1, nivel);
    }

    @Test
    public void testNivelConUnELemento() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        int nivel= arbol.nivel("A");
        assertEquals(0, nivel);
    }

    @Test
    public void testNivelConMasELementos() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        arbol.insertar("C", "B");
        int nivel= arbol.nivel("C");
        assertEquals(2, nivel);
    }

    @Test
    public void testNivelConMasELementosSinEstar() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        arbol.insertar("D", "B");
        int nivel= arbol.nivel("C");
        assertEquals(-1, nivel);
    }
     @Test
    public void testNivelConUnELementoSinEstar() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        int nivel= arbol.nivel("C");
        assertEquals(-1, nivel);
    }

    @Test
    public void testAncestrosEmpty() {
        ArbolGen arbol=new ArbolGen();
        Lista l=arbol.ancestros("A");
        assertTrue(l.esVacia());
    }

    @Test
    public void testAncestrosUnElem() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        Lista l=arbol.ancestros("A");
        assertTrue(l.esVacia());
        String a="[]";
        assertEquals(a,l.toString());
    }

    @Test
    public void testAncestrosUnElemSinEstar() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        Lista l=arbol.ancestros("B");
        assertTrue(l.esVacia());
        String a="[]";
        assertEquals(a,l.toString());
    }

    @Test
    public void testAncestrosMasElemSinEstar() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        Lista l=arbol.ancestros("C");
        assertTrue(l.esVacia());
        String a="[]";
        assertEquals(a,l.toString());
    }
    @Test
    public void testAncestrosMasElem() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        Lista l=arbol.ancestros("B");
        assertFalse(l.esVacia());
        String a="[A]";
        assertEquals(a,l.toString());
    }

    @Test
    public void testClonVacio() {
        ArbolGen arbol=new ArbolGen();
        ArbolGen clon=arbol.clone();
        assertTrue(arbol.esVacio());
        assertTrue(clon.esVacio());
    }

    @Test
    public void testClonUnElemento() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        ArbolGen clon=arbol.clone();
        assertFalse(arbol.esVacio());
        assertFalse(clon.esVacio());
        assertEquals(arbol.toString(),clon.toString());
    }

    @Test
    public void testClonMuchosElemento() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        arbol.insertar("C", "A");
        arbol.insertar("D", "C");
        arbol.insertar("F", "D");
        ArbolGen clon=arbol.clone();
        assertFalse(arbol.esVacio());
        assertFalse(clon.esVacio());
        assertEquals(arbol.toString(),clon.toString());
    }

    @Test
    public void testPreorderVacio() {
        ArbolGen arbol=new ArbolGen();
        Lista l=arbol.listarPreorden();
        assertTrue(l.esVacia());
        String a="[]";
        assertEquals(a,l.toString());
    }

    @Test
    public void testInorderVacio() {
        ArbolGen arbol=new ArbolGen();
        Lista l=arbol.listarInorden();
        assertTrue(l.esVacia());
        String a="[]";
        assertEquals(a,l.toString());
    }

    @Test
    public void testPosorderVacio() {
        ArbolGen arbol=new ArbolGen();
        Lista l=arbol.listarPosorden();
        assertTrue(l.esVacia());
        String a="[]";
        assertEquals(a,l.toString());
    }

    @Test
    public void testPreorderMasElementos() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        arbol.insertar("C", "A");
        arbol.insertar("D", "C");
        arbol.insertar("F", "D");
        Lista l=arbol.listarPreorden();
        assertFalse(l.esVacia());
        String a="[A,C,D,F,B]";
        assertEquals(a,l.toString());
    }

    @Test
    public void testInorderMasElementos() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        arbol.insertar("C", "A");
        arbol.insertar("D", "C");
        arbol.insertar("F", "D");
        Lista l=arbol.listarInorden();
        assertFalse(l.esVacia());
        String a="[F,D,C,A,B]";
        assertEquals(a,l.toString());
    }

    @Test
    public void testPosorderMasElementos() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        arbol.insertar("C", "A");
        arbol.insertar("D", "C");
        arbol.insertar("F", "D");
        Lista l=arbol.listarPosorden();
        assertFalse(l.esVacia());
        String a="[F,D,C,B,A]";
        
        assertEquals(a,l.toString());
    }

    @Test
    public void testVaciarNoVacio() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.insertar("B", "A");
        arbol.insertar("C", "A");
        arbol.insertar("D", "C");
        arbol.insertar("F", "D");
        arbol.vaciar();
        assertTrue(arbol.esVacio());
    }
    @Test
    public void testVaciarUnELemento() {
        ArbolGen arbol=new ArbolGen();
        arbol.insertar("A", null);
        arbol.vaciar();
        assertTrue(arbol.esVacio());
    }

    @Test
    public void testVaciarEmpty() {
        ArbolGen arbol=new ArbolGen();
        arbol.vaciar();
        assertTrue(arbol.esVacio());
    }
}