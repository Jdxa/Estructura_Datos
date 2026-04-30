package test.jerarquicas;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import static org.junit.Assert.*;
import org.junit.Test;

import jerarquicas.ArbolBin;

public class ArbolBinarioTestEstudiante {
    // *mejorar usando metodos auxiliares
    @Test
    public void testInsertarArbolVacio(){
        ArbolBin arb = new ArbolBin();
        boolean ev = arb.insertar(1,null,'a');
        assertEquals(true,ev);
    }
    
    @Test
    public void testInsertarArbolHijoIzq(){
        ArbolBin arb = new ArbolBin();
        arb.insertar(1,null,'a');
        boolean ev = arb.insertar(2, 1, 'I');
        boolean ev2 = arb.insertar(2, 1, 'I'); //Va a estar ocupado
        assertEquals(ev,true);
        assertEquals(ev2,false);
        Lista l = arb.listarPreorden();
        Lista l2 = new Lista();
        l2.insertar(1, 1);
        l2.insertar(2, 2);
        assertEquals(l.toString(),l2.toString() );
    }
    @Test
    public void testInsertarHijoDerecho(){
        ArbolBin arb = new ArbolBin();
        arb.insertar(1,null,'a');
        boolean ev = arb.insertar(3, 1, 'D');
        assertEquals(ev,true);
        
    }
    @Test    
    public void testInsertarArbolOcupado(){
        ArbolBin arb = new ArbolBin();
        arb.insertar(1,null,'a'); //Raiz
        boolean ev = arb.insertar(2, 1, 'I');   
        boolean ev2 = arb.insertar(2, 1, 'I'); //ocupado
        assertEquals(ev,true);
        assertEquals(ev2,false);
    }
    
    private ArbolBin insertarAux(){
         ArbolBin arb = new ArbolBin();
        arb.insertar(1, 1, 'I');
        arb.insertar(2, 1, 'I');
        arb.insertar(3, 1, 'D');
        return arb;
    }
    @Test
    public void testRecorridoPreOrden(){
        //Verifica que este bien el recorrido PreOrden
        ArbolBin arb = insertarAux();
        Lista l = arb.listarPreorden(); //[1,2,3]
    
        assertEquals(l.toString(), "[1,2,3]");  

    }
   
    @Test
    public void testRecorridoInOrden(){
        //Verifica que este bien el recorrido InOrden
        ArbolBin arb = insertarAux();
        Lista l = arb.listarInorden(); //[2,1,3]
        assertEquals(l.toString(), "[2,1,3]");  

    }
    
    @Test
    public void testRecorridoPosOrden(){
        //Verifica que este bien el recorrido PosOrden
        ArbolBin arb = insertarAux();
        Lista l = arb.listarPosorden(); //[2,3,1]
        assertEquals(l.toString(), "[2,3,1]");  

    }

    @Test
    public void testRecorridoPorNiveles(){
        //Verifica que este bien el recorrido PorNiveles
        ArbolBin arb = insertarAux();
        Cola c = arb.listarPorNiveles(); //[1,2,3]
        assertEquals(c.toString(), "[1,2,3]");
    }   
    @Test
    public void testInsertarPorPosicion(){
        ArbolBin arb = insertarAux(); //[1,2,3]
        boolean ev = arb.insertarPorPosicion(4, 2, 'I');
        assertTrue(ev);
        assertEquals(arb.listarPreorden().toString(),"[1,2,4,3]");
    }
    @Test
    public void testVerificarPatron(){
        ArbolBin arb = insertarAux();
        arb.insertar(4, 2, 'I');
        arb.insertar(5, 2, 'D'); 
        arb.insertar(6, 3, 'I');
        arb.insertar(7, 3, 'D'); //[1,2,3,4,5,6,7]
        Lista l = new Lista();
        l.insertar(1, 1);
        l.insertar(3, 2);
        l.insertar(7, 3);

        assertEquals(arb.verificarPatron(l), true);

    }
    @Test
    public void testverificarFrontera(){
        ArbolBin arb = insertarAux();
        arb.insertar(4, 2, 'I');
        arb.insertar(5, 2, 'D'); 
        arb.insertar(6, 3, 'I');
        arb.insertar(7, 3, 'D'); //[1,2,3,4,5,6,7]
        Lista l = arb.frontera();
        assertEquals(l.toString(), "[4,5,6,7]");
    }
    @Test
    public void testAlturaIzq(){
        ArbolBin arb = insertarAux();
        arb.insertar(4, 2, 'I');
        arb.insertar(5, 2, 'D'); 
        assertEquals(arb.altura(), 2);
    }

    @Test
    public void testAlturaDer(){
        ArbolBin arb = insertarAux();
        arb.insertar(4, 3, 'I');
        arb.insertar(5, 3, 'D'); 
        assertEquals(arb.altura(), 2);

    }

    @Test
    public void testAlturaRaiz(){
        ArbolBin arb = new ArbolBin();
        arb.insertar(1,null , 'I');
        assertEquals(arb.altura(), 0);

    }
    @Test
    public void testAlturaEmpty(){
        ArbolBin arb = new ArbolBin();
        assertEquals(arb.altura(), -1);

    }
    @Test
    public void testClone(){
        ArbolBin arb = insertarAux();
        ArbolBin clon = arb.clone();
        Lista l1 = arb.listarPreorden();
        
        Lista l2 = clon.listarPreorden();
        assertEquals(l1.toString(), l2.toString());
    }
    @Test
    public void tesCloneInvertido(){
        ArbolBin arb = insertarAux();
        arb.insertar(4, 2, 'I');
        arb.insertar(5, 2, 'D'); 
        arb.insertar(6, 3, 'I');
        arb.insertar(7, 3, 'D'); //[1,2,3,4,5,6,7]
        ArbolBin clon = arb.clonarInvertido(); // [1,3,7,6,2,5,4]
        Lista l1 = arb.listarInorden();
        Lista l2 = clon.listarInorden();
        assertNotEquals(l1.toString(),l2.toString());

        assertEquals(l2.toString(),"[7,3,6,1,5,2,4]" );


    
    }
}
