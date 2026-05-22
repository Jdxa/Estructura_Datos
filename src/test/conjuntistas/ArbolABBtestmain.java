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
        a.insertar(50);
        a.insertar(70);
        a.insertar(30);
        a.insertar(20);
        a.insertar(40);
        a.insertar(60);
        a.insertar(80);
    }
}
