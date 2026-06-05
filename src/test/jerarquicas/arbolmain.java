package test.jerarquicas;

import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

import static org.junit.Assert.*;

import org.junit.Test;


import conjuntistas.ArbolBB;
// import lineales.dinamicas.*;
public class arbolmain {
    public static void main(String[] args) {
         ArbolGen arb = cargarArb();
         System.out.println(arb.toString());
         
        // System.out.println(arb);
        Lista l = arb.listaQueJustificaAltura();

    }
    @Test


    public static ArbolGen cargarArb(){
        ArbolGen arb = new ArbolGen();
        arb.insertar(1, null);
        arb.insertar(2, 1);
        arb.insertar(3, 1);
        arb.insertar(4, 1);
        arb.insertar(5, 2);
        arb.insertar(6, 2);
        arb.insertar(7, 6);
        arb.insertar(8, 3);
        arb.insertar(9,8 );
        arb.insertar(10,8 );
        arb.insertar(11, 10);
        arb.insertar(12, 4);
        arb.insertar(15, 12);
        return arb;
    }

    public static Lista cargarLista(String cadenanumeros){
        Lista l = new Lista();
        if (cadenanumeros != null && !cadenanumeros.trim().isEmpty()) {
            String [] partes = cadenanumeros.split(",");

            int posInsertar = 1;
            for (int i = 0; i < partes.length; i++){
                String numerostr = partes[i].trim();
                Integer numero = Integer.valueOf(numerostr);

                l.insertar(numero, posInsertar);
                posInsertar++;
            }
        }
        return l;
    }
    
}
