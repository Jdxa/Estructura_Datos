package test.conjuntistas;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import conjuntistas.*;

public class ArbolBBTest {

    private ArbolBB arbol;

    @Before
    public void setUp() {

        arbol = new ArbolBB();

        /*
                    50
                  /    \
                30      70
               /  \    /  \
             20   40  60   80
        */

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
    }

    // =====================================
    // ELIMINAR HOJA
    // =====================================
    @Test
    public void testEliminarHoja() {

        boolean exito = arbol.eliminar(20);

        assertTrue(exito);

        // ya no debe existir
        assertFalse(arbol.pertenece(20));

        // los demás siguen
        assertTrue(arbol.pertenece(30));
        assertTrue(arbol.pertenece(50));
    }

    // =====================================
    // ELIMINAR NODO CON UN HIJO
    // =====================================
    @Test
    public void testEliminarUnHijo() {

        // agrego un hijo a 20
        arbol.insertar(10);

        /*
                    50
                  /    \
                30      70
               /  \    /  \
             20   40  60   80
            /
           10
        */

        boolean exito = arbol.eliminar(20);

        assertTrue(exito);

        // 20 desaparece
        assertFalse(arbol.pertenece(20));

        // 10 debe seguir
        assertTrue(arbol.pertenece(10));
    }

    // =====================================
    // ELIMINAR NODO CON DOS HIJOS
    // =====================================
    @Test
    public void testEliminarDosHijos() {

        boolean exito = arbol.eliminar(30);

        assertTrue(exito);

        // 30 desaparece
        assertFalse(arbol.pertenece(30));

        // el resto sigue
        assertTrue(arbol.pertenece(20));
        assertTrue(arbol.pertenece(40));
    }

    // =====================================
    // ELIMINAR LA RAIZ
    // =====================================
    @Test
    public void testEliminarRaiz() {

        boolean exito = arbol.eliminar(50);

        assertTrue(exito);

        assertFalse(arbol.pertenece(50));

        // el árbol debe seguir funcionando
        assertTrue(arbol.pertenece(30));
        assertTrue(arbol.pertenece(70));
    }

    // =====================================
    // ELIMINAR ELEMENTO INEXISTENTE
    // =====================================
    @Test
    public void testEliminarInexistente() {

        boolean exito = arbol.eliminar(999);

        assertFalse(exito);
    }

    // =====================================
    // ELIMINAR ÚNICO ELEMENTO
    // =====================================
    @Test
    public void testEliminarUnicoElemento() {

        ArbolBB a = new ArbolBB();

        a.insertar(10);

        boolean exito = a.eliminar(10);

        assertTrue(exito);

        assertFalse(a.pertenece(10));
    }
}
