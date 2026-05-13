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
    public boolean insertar(Object dato, Object padre) {
        boolean exito = false;
        if (this.raiz != null) {
            NodoGen nodoPadre = buscarNodo(this.raiz, padre);
            // si encontro al padre puede insertarlo -> siempre es true
            if (nodoPadre != null) {
                NodoGen nuevo = new NodoGen(dato, null, null);

                // si no tiene hijos el padre
                if (nodoPadre.getHijoIzquierdo() == null) {
                    nodoPadre.setHijoIzquierdo(nuevo);
                } else {
                    // Si tiene hijos busco el ultimo hermano
                    NodoGen aux = nodoPadre.getHijoIzquierdo();
                    while (aux.getHermanoDerecho() != null) {
                        aux = aux.getHermanoDerecho();
                    }
                    aux.setHermanoDerecho(nuevo);

                }
                exito = true;
            }

        }
        return exito;
    }

    private NodoGen buscarNodo(NodoGen nodo, Object padre) {
        // retorno el puntero del padre
        NodoGen res = null;
        if (nodo != null) {

            if (nodo.getElem().equals(padre)) {
                res = nodo;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    res = buscarNodo(hijo, padre);
                    hijo = hijo.getHermanoDerecho();
                }
            }

        }
        return res;
    }
    //busca si el elemento esta dentro del arbol
    public boolean pertence(Object elemento){
        return perteneceAux(this.raiz, elemento);
    }
    private boolean perteneceAux(NodoGen nodo, Object elemento) {
        // inteligencia de busqueda
        boolean res = false;
        if (nodo != null) {

            if (nodo.getElem().equals(elemento)) {
                res = true;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && !res ) {
                    res = perteneceAux(hijo, elemento);
                    hijo = hijo.getHermanoDerecho();
                }
            }

        }
        return res;
    }
    public boolean esVacio(){
        boolean res= false;
        if (this.raiz == null) {
            res = true;
        }
        return res;
    }
    //altura
    public int altura(){
        return alturaAux(this.raiz);
    }
    private int alturaAux(NodoGen nodo){
        int res= -1;
        if (nodo != null) {
            res= 0;
            NodoGen hijo = nodo.getHijoIzquierdo();

            while (hijo != null) {
                int althijo = 1 +alturaAux(hijo);
                if (althijo > res) {
                    res = althijo;
                }
                hijo = hijo.getHermanoDerecho();
            }
        }
        return res;
    }
    //padre()
    public Object padre(Object elemento){
        Object res = null;
        if (this.raiz!= null) {
            //raiz no tiene padre
            if (!this.raiz.getElem().equals(elemento)) {
                res= padreAux(this.raiz, elemento);
            }
        }
        return res;
    }
    
    private Object padreAux(NodoGen nodo, Object elemento){
        Object res = null;
        NodoGen hijo = nodo.getHijoIzquierdo();

        while (hijo != null && res == null) {
            if (hijo.getElem().equals(elemento)) {
                res = nodo.getElem();
            }else{
                res = padreAux(hijo, elemento);
            }
            hijo = hijo.getHermanoDerecho();
        }
        return res;
    }
    public void vaciar(){
        this.raiz = null;
    }

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

    // ListarInOrden
    public Lista listarInorden() {
        Lista salida = new Lista();
        listarInordenAux(this.raiz, salida);
        return salida;
    }

    private void listarInordenAux(NodoGen nodo, Lista l) {
        if (nodo != null) {

            // voy al fondo izquierda
            if (nodo.getHijoIzquierdo() != null) {
                listarInordenAux(nodo.getHijoIzquierdo(), l);
            }

            // al llegar a ese ultimo izquierdo anoto
            l.insertar(nodo.getElem(), l.longitud() + 1);
            // no entra al ultimo entonces despila y ve su padre
            // de aca va por sus otros hijos
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, l);
                    hijo = hijo.getHermanoDerecho();
                }
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
