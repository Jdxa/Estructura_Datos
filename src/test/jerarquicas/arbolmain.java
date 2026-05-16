package test.jerarquicas;

import jerarquicas.ArbolGen;
// import lineales.dinamicas.*;
public class arbolmain {
    public static void main(String[] args) {

        // ArbolGen arb = cargarArb();

        // String s = arb.toString();

        // Lista l = arb.listarPreorden();
        // System.out.println("lista: ");
        // System.out.println(l.toString());
        // l = arb.listarInorden();
        // System.out.println(l.toString());

        // System.out.println(s);
        // Lista ancestros = arb.ancestros("I");
        // System.out.println(ancestros.toString());
        // l = arb.listarPosorden();
        // System.out.println(l.toString());
        // l = arb.listarNiveles();
        // System.out.println(l.toString());
        // ArbolGen arb2 = arb.clone();
        // System.out.println("clone");
        // System.out.println(arb2.toString());
    }
    public static ArbolGen cargarArb(){
        ArbolGen arb = new ArbolGen();
        arb.insertar("A", null);
        arb.insertar("B", "A");
        arb.insertar("C", "A");
        arb.insertar("D", "A");
        arb.insertar("E", "B");
        arb.insertar("F", "B");
        arb.insertar("G", "B");
        arb.insertar("H", "D");
        return arb;
    }
}
