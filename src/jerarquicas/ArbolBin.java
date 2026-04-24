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

    private NodoArbol obtenerNodoPosicion(NodoArbol n, int posBusc, int[] posActual){
        NodoArbol res = null;

        if (n != null) {
            //Incrementa la pos actual si hay nodo en n(nodo actual)
            posActual[0] = posActual[0] +1;
            if (posBusc == posActual[0]) {
                //si llego a la posBusc retorna el nodo en esa pos
                res = n;
            }else{
                //visita por izquierda
                res = obtenerNodoPosicion(n.getIzquierdo(), posBusc, posActual);
                if (res == null) {
                    //si ya visito toda la izquierda va por la derecha del padre
                    res = obtenerNodoPosicion(n.getDerecho(), posBusc, posActual);
                }
            }
        }
        return res;
    }
    public boolean insertarPorPosicion(Object nuevo, int posPadre, char posHijo){
        boolean exito = false;
        NodoArbol nNodo = new NodoArbol(nuevo, null, null);
        //solo inserta si existe un nodo en PosPadre
        if (this.raiz != null) {
            //arbol no vacio
            int[] posActual = {0};
            NodoArbol nPadre = obtenerNodoPosicion(this.raiz, posPadre, posActual);
            if (nPadre != null) {
                //lo encontro
                if (posHijo == 'I' && nPadre.getIzquierdo() == null) {
                    // si quiero insertar en I y no esta ocupado
                    nPadre.setIzquierdo(nNodo);
                    exito = true;
                }else if (posHijo == 'D' && nPadre.getDerecho() == null) {
                    // si quiero insertar por D y no esta ocupado
                    nPadre.setDerecho(nNodo);
                    exito = true;
                }
            }
        }
        return exito;
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
