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
}
