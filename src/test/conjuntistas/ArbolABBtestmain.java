package test.conjuntistas;
import lineales.dinamicas.*;
import conjuntistas.*;
public class ArbolABBtestmain {
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();
        cargarArb(arbol);
        Lista l = arbol.listar();
        System.out.println(l.toString());
    }

    public static void cargarArb(ArbolBB a){
        a.insertar(1);
        a.insertar(2);
        a.insertar(3);
        a.insertar(6);
        a.insertar(7);
        a.insertar(8);
        a.insertar(12);
        a.insertar(3);
        a.insertar(2);
    }
}
