package test.lineales;

import static org.junit.Assert.*;

import org.junit.Test;

import lineales.dinamicas.*;

public class ListaTestEstudiante {
    
    
    @Test
    public void testCreateEmptyList() {
            // Verifica que al crearla esté vacía y su toString sea []
        Lista lista = new Lista();
        assertTrue(lista.esVacia());
        assertEquals(0, lista.longitud());
        assertEquals("[]", lista.toString());
    }

    @Test
    public void testInsertInEmptyList() {
        // En una lista vacía, solo se puede insertar en la posición 1
        Lista lista = new Lista();
        assertTrue(lista.insertar(10, 1));
        assertEquals("[10]", lista.toString());
        assertFalse(lista.esVacia());
    }

    @Test
    public void testInsertInNonEmptyList() {
        Lista lista = new Lista();
        lista.insertar(10, 1); // [10]
        lista.insertar(30, 2); // [10,30]
        
        // Insertar en el medio (pos 2)
        assertTrue(lista.insertar(20, 2)); 
        assertEquals("[10,20,30]", lista.toString());
        
        // Insertar al principio
        lista.insertar(5, 1);
        assertEquals("[5,10,20,30]", lista.toString());
    }

    @Test
    public void testDeleteInEmptyList() {
        // No debería poder eliminar nada si está vacía
        Lista lista = new Lista();
        assertFalse(lista.eliminar(1));
        assertEquals("[]", lista.toString());
    }

    @Test
    public void testDeleteInListWithOnlyOneElement() {
        Lista lista = new Lista();
        assertEquals(lista.esVacia(), true);
        lista.insertar("A", 1);
        
        assertTrue(lista.eliminar(1));
        // assertEquals(lista.esVacia(),true);
        assertEquals("[]", lista.toString());
    }

    @Test
    public void testDeleteInListWithSomeElements() {
        Lista lista = new Lista();
        lista.insertar(1, 1);
        lista.insertar(2, 2);
        lista.insertar(3, 3); // [1,2,3]
        
        // Eliminar el del medio
        assertTrue(lista.eliminar(2));
        assertEquals("[1,3]", lista.toString());
        assertEquals(2, lista.longitud());
    }

    @Test
    public void testRecoverEmptyList() {
        // Siguiendo el patrón de 'unqueue' pero para recuperar
        // Como recuperar tiene precondición de posición válida, 
        // aquí testeamos que la lista se mantenga igual si intentamos algo raro
        Lista lista = new Lista();
        assertEquals(0, lista.longitud());
    }

    // @Test
    public void testCloneList() {
        Lista lista = new Lista();
        lista.insertar(10, 1);
        lista.insertar(20, 2);
        
        Lista copia = lista.clone();
        
        assertEquals(lista.toString(), copia.toString(), "El contenido debe ser idéntico");
        
        // Verificamos independencia: modificamos original, la copia no debe cambiar
        lista.insertar(30, 3);
        assertNotEquals(lista.toString(), copia.toString());
    }

    @Test
    public void testCloneEmptyList() {
        Lista lista = new Lista();
        Lista copia = lista.clone();
        assertTrue(copia.esVacia());
        assertEquals("[]", copia.toString());
    }
    @Test
    public void testobtenerMultiplos(){
        Lista lista= new Lista();
        lista.insertar("A", 1);
        lista.insertar("B", 2);
        lista.insertar("C", 3);
        lista.insertar("D", 4); //
        Lista copia = new Lista();
        copia = lista.obtenerMultiplos(2); //[B,D]
        assertEquals(lista.toString(),"[A,B,C,D]");
        assertEquals(copia.toString(),"[B,D]");
    }
    @Test
    public void testeliminarApariciones(){
        Lista lista = new Lista();
        lista.insertar("A", 1);
        lista.insertar("B", 2);
        lista.insertar("A", 3);
        lista.insertar("A", 4);
        lista.insertar("C", 5); //
        lista.eliminarApariciones("A");
        assertEquals(lista.toString(),"[B,C]");
    }
    @Test
    public void testAgregarElem(){
        Lista lista = new Lista();
        lista.insertar(1, 1);
        lista.insertar(2, 2);
        lista.insertar(3, 3);
        lista.insertar(4, 4);
        lista.insertar(5, 5);
        lista.insertar(6, 6);
        // lista.insertar(7, 7);
        
        

        lista.agregarElem(0, 2);

        assertEquals(lista.toString(),"[0,1,2,0,3,4,0,5,6,0]");
    }
}
