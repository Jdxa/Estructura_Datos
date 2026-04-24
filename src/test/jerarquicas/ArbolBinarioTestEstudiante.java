package test.jerarquicas;
import lineales.dinamicas.Lista;
import static org.junit.Assert.*;
import org.junit.Test;

import jerarquicas.ArbolBin;

public class ArbolBinarioTestEstudiante {
    // *mejorar usando metodos auxiliares
    @Test
    public void insertarArbolVacio(){
        ArbolBin arb = new ArbolBin();
        boolean ev = arb.insertar(1,null,'a');
        assertEquals(true,ev);
    }
    
    @Test
    public void insertarArbolHijoIzq(){
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
    public void insertarHijoDerecho(){
        ArbolBin arb = new ArbolBin();
        arb.insertar(1,null,'a');
        boolean ev = arb.insertar(3, 1, 'D');
        assertEquals(ev,true);
        
    }
    @Test    
    public void insertarArbolOcupado(){
        ArbolBin arb = new ArbolBin();
        arb.insertar(1,null,'a'); //Raiz
        boolean ev = arb.insertar(2, 1, 'I');   
        boolean ev2 = arb.insertar(2, 1, 'I'); //ocupado
        assertEquals(ev,true);
        assertEquals(ev2,false);
    }
    private Lista cargarListaPre(){
        Lista l = new Lista();
        l.insertar(1, 1);
        l.insertar(2, 2);
        l.insertar(3, 3);
        return l;
    }
    private ArbolBin insertarAux(){
         ArbolBin arb = new ArbolBin();
        arb.insertar(1, 1, 'I');
        arb.insertar(2, 1, 'I');
        arb.insertar(3, 1, 'D');
        return arb;
    }
    @Test
    public void recorridoPreOrden(){
        //Verifica que este bien el recorrido PreOrden
        ArbolBin arb = insertarAux();
        Lista l = arb.listarPreorden(); //[1,2,3]
        Lista l2 = cargarListaPre();
        assertEquals(l.toString(), l2.toString());  

    }
    private Lista cargarListaIn(){
        Lista l = new Lista();
        l.insertar(2, 1);
        l.insertar(1, 2);
        l.insertar(3, 3);
        return l;
    }
    @Test
    public void recorridoInOrden(){
        //Verifica que este bien el recorrido InOrden
        ArbolBin arb = insertarAux();
        Lista l = arb.listarInorden(); //[2,1,3]
        Lista l2 = cargarListaIn();
        assertEquals(l.toString(), l2.toString());  

    }
    private Lista cargarListaPos(){
        Lista l = new Lista();
        l.insertar(2, 1);
        l.insertar(3, 2);
        l.insertar(1, 3);
        return l;
    }
    @Test
    public void recorridoPosOrden(){
        //Verifica que este bien el recorrido PosOrden
        ArbolBin arb = insertarAux();
        Lista l = arb.listarPosorden(); //[2,3,1]
        Lista l2 = cargarListaPos();
        assertEquals(l.toString(), l2.toString());  

    }

}
