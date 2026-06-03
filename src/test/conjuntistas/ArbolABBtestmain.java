package test.conjuntistas;
import lineales.dinamicas.*;
import conjuntistas.*;
public class ArbolABBtestmain {
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();
        cargarArb(arbol);
        Lista l = arbol.listarMayorIgual(5);
        System.out.println(l.toString());
    }

    public static void cargarArb(ArbolBB a){
        a.insertar(10);
        a.insertar(4);
        a.insertar(5);
        a.insertar(6);
        a.insertar(7);
        a.insertar(8);
        a.insertar(12);
    }
}
