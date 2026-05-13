package jerarquicas;

import lineales.dinamicas.*; //para metodos auxiliares como Lista o Cola

public class ArbolGen {
    // atributo
    private NodoGen raiz;

    // constructor
    public ArbolGen() {
        this.raiz = null;
    }

    // metodos propios

    // Listar en preorden
    public Lista listarPreorden() {
        Lista salida = new Lista();
        listarPreordenAux(this.raiz, salida);
        return salida;
    }

    private void listarPreordenAux(NodoGen nodo, Lista l) {
        if (nodo != null) {
            // carga la lista
            l.insertar(nodo.getElem(), l.longitud() + 1); // +1 xq empieza en 0 y 0 no es valida

            // recorro recursivamente: va por izq anota, si hay izq sigue
            // sino va por su
            // hermano derecho y anota y va x izquierda
            // puntero al hijo izq
            NodoGen hijo = nodo.getHijoIzquierdo(); //
            // cuando ya no tiene hijos corta desapila
            while (hijo != null) {
                listarPreordenAux(hijo, l);
                // aqui accedo a su hermano y cuando repite revisa ese nodo
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    // ToString
    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen nodo) {
        String s = "";
        if (nodo != null) {
            // visita el nodo n
            s += nodo.getElem() + " -> ";
            NodoGen hijo = nodo.getHijoIzquierdo();
            // esto anota todos los hijos de nodo
            while (hijo != null) {
                s += hijo.getElem() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            hijo = nodo.getHijoIzquierdo(); // ahora va al izquierdo de n
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = nodo.getHermanoDerecho();
            }
        }

        return s;
    }

}
