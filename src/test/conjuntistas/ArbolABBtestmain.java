package test.conjuntistas;
import lineales.dinamicas.*;
import conjuntistas.*;
public class ArbolABBtestmain {
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();
        cargarArb(arbol);
        Lista l1 = arbol.listar();
        Lista l = arbol.listarRango(3, 6);
        System.out.println(l1.toString());
        System.out.println(l.toString());
        System.out.println(""+arbol.minimoElem());
        System.out.println(""+arbol.maximoElem());

    }

    public static void cargarArb(ArbolBB a){
        // a.insertar(50);
        // a.insertar(70);
        // a.insertar(30);
        // a.insertar(20);
        // a.insertar(40);
        // a.insertar(60);
        // a.insertar(80);
        a.insertar(1);
        a.insertar(2);
        a.insertar(3);
        a.insertar(4);
        a.insertar(5);
        a.insertar(6);
        a.insertar(7);
    }
}
