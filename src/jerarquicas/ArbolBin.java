package jerarquicas;
import lineales.dinamicas.*;
public class ArbolBin {
    private NodoArbol raiz;

    public ArbolBin(){
        this.raiz = null;
    }
    
    public boolean insertar(Object elemNuevo,Object elemPadre,char lugar ){
        boolean exito = true;
        if (this.raiz   == null) {
            //si es es nulo el arbol
            this.raiz = new NodoArbol(elemNuevo,null,null);

        }else{
            //como el arbol no esta vacio busco el padre
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);
            if (nPadre != null) {       //si existe ese nodo padre
                if (lugar == 'I' && nPadre.getIzquierdo() == null) {
                    //si inserto por izquierda y veo que este vacio ese lugar
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                }else if (lugar == 'D' && nPadre.getDerecho() == null) {
                    //si inserto por derecha y veo que este vacio ese lugar
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                }else{
                    //el padre ya tiene hijos
                    exito = false;
                }
            }else{
                //no existe el padre
                exito= false;
            }
        }

        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        NodoArbol res = null;
        if (n != null) {
            //si n tiene a buscando lo retornado
            if (n.getElem().equals(buscado)) {
                res = n;
            }else{
                // busca por izquierda
               res= obtenerNodo(n.getIzquierdo(), buscado);
                // si no lo encontro por izq va por derecha
               if (res == null) {
                    res = obtenerNodo(n.getDerecho(), buscado);
               }
            }
        }

        return res;
    }



    public Lista listarPreorden(){
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis){

        if (nodo != null) {
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarInorden(){
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;

    }
    
    private void listarInordenAux(NodoArbol nodo, Lista lis){
        if (nodo != null) {
            listarInordenAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            listarInordenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarPosorden(){
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;

    }
    private void listarPosordenAux(NodoArbol nodo, Lista lis){
        if (nodo != null) {
            listarPosordenAux(nodo.getIzquierdo(), lis);
            listarPosordenAux(nodo.getDerecho(), lis);
            lis.insertar(nodo.getElem(), lis.longitud()+1);
        }
    }

    public Cola listarPorNiveles(){
        Cola c = new Cola();                                            //Cola a retornar
        if (this.raiz != null) {                //mientras no este vacio el arbol            
            Cola aux = new Cola();              //creo una auxiliar para el recorrido                                           
            aux.poner(this.raiz);               //le coloco la raiz del arbol
            while (!aux.esVacia()) {            //hasta que no recorra todo el arbol no corta
                NodoArbol nodoActual = (NodoArbol) aux.obtenerFrente();       //creo un nodo arbol que sera
                c.poner(nodoActual.getElem());                      //coloco el elemento del nodo actual en la cola a retornar           
                if (nodoActual.getIzquierdo() != null) {      //si el nodo actual tiene hijo por izquierda lo coloco en la cola auxiliar
                    aux.poner(nodoActual.getIzquierdo());     //
                }
                if (nodoActual.getDerecho() != null) {      //si el nodo actual tiene hijo por derecha lo coloco en la cola auxiliar    
                    aux.poner(nodoActual.getDerecho());
                }
                aux.sacar();        //saco el nodo actual para seguir con el siguiente
            }
        }
        return c;
    }
}
