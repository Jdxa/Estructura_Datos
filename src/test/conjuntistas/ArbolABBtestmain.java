package test.conjuntistas;
import lineales.dinamicas.*;
import conjuntistas.*;
public class ArbolABBtestmain {
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();
        cargarArb(arbol);
        ArbolBB clon = arbol.clonarParteInvertida(13);
        Lista l = clon.listar();
        System.out.println(l.toString()); // esperado -> [24,15,13,7]
    }

    public static void cargarArb(ArbolBB a){
        a.insertar(56);
        a.insertar(13);
        a.insertar(78);
        a.insertar(7);
        a.insertar(24);
        a.insertar(15);
        a.insertar(100);
    }
}
