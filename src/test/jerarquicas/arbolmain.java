package test.jerarquicas;

import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;
// import lineales.dinamicas.*;
public class arbolmain {
    public static void main(String[] args) {
        ArbolGen arb = cargarArb();
        Lista l = arb.listarPreorden();
        System.out.println(l.toString());
        arb.eliminar(20);
        l = arb.listarPreorden();
        System.out.println(l.toString());

        
        
    }
    public static ArbolGen cargarArb(){
        ArbolGen arb = new ArbolGen();
        arb.insertar(20, null);
        arb.insertar(54, 20);
        arb.insertar(13, 20);
        arb.insertar(12, 13);
        arb.insertar(15, 13);
        arb.insertar(4, 54);
        arb.insertar(27, 54);
        arb.insertar(11, 54);
        arb.insertar(17, 27);
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
