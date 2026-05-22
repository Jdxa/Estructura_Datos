package conjuntistas;
import lineales.*;
import lineales.dinamicas.Lista;
public class ArbolBB {
    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean pertenece(Comparable elem) {
        boolean exito = false;
        if (this.raiz != null) {
            exito = perteneceaux(this.raiz, elem);
        }
        return exito;
    }

    private boolean perteneceaux(NodoABB nodo, Comparable elem) {
        boolean esta = false;
        int comp = elem.compareTo(nodo.getElem());
        if (comp == 0) {
            esta = true;
        } else if (comp < 0) {
            // comparo si voy por izquierda o derecha
            if (nodo.getIZquierdo() != null) {
                esta = perteneceaux(nodo.getIZquierdo(), elem);
            }
        } else if (comp > 0) {
            // voy por rama derecha
            if (nodo.getDerecho() != null) {
                esta = perteneceaux(nodo.getDerecho(), elem);
            }
        }
        return esta;
    }

    public boolean insertar(Comparable elem) {
        boolean exito = true;
        if (this.raiz != null) {
            exito = insertaraux(this.raiz, elem);
        } else {
            // arbol vacio
            this.raiz = new NodoABB(elem, null, null);
        }

        return exito;
    }

    private boolean insertaraux(NodoABB nodo, Comparable elem) {
        boolean exito = true;
        int comp = elem.compareTo(nodo.getElem());

        if (comp == 0) {
            // elemento repetido
            exito = false;
        } else if (comp < 0) {
            if (nodo.getIZquierdo() != null) {
                exito = insertaraux(nodo.getIZquierdo(), elem);
            } else {
                nodo.setIzquierdo(new NodoABB(elem, null, null));
            }
        } else {
            if (nodo.getDerecho() != null) {
                exito = insertaraux(nodo.getDerecho(), elem);
            } else {
                nodo.setDerecho(new NodoABB(elem, null, null));
            }
        }
        return exito;
    }

    public boolean eliminar(Comparable elem) {
        boolean exito = false;
        if (this.raiz != null) {
            boolean[] aux = { false };
            this.raiz = eliminaraux(raiz, elem, aux);
            exito = aux[0];
        }
        return exito;
    }

    private NodoABB eliminaraux(NodoABB nodo, Comparable elem, boolean[] exito) {
        NodoABB retornar = nodo;
        if (nodo != null) {
            int comp = elem.compareTo(nodo.getElem());
            
            if (comp < 0) {
                // busco x izquierda
                NodoABB izq = nodo.getIZquierdo();
                nodo.setIzquierdo(eliminaraux(izq, elem, exito)); //llamado hasta que izq == elem

            } else if (comp > 0) {
                // busco x derecha
                NodoABB der = nodo.getDerecho();
                nodo.setDerecho(eliminaraux(der, elem, exito)); //llamado hasta que der == elem
            } else {
                // lo encontro  elem == nodo.getElemento
                exito[0] = true;

                // caso 1: hoja
                if (nodo.getIZquierdo() == null && nodo.getDerecho() == null) {
                    retornar = null;
                } else if (nodo.getIZquierdo() == null) {
                    // sin HI (vacio)
                    // HD ocupa el lugar
                    retornar = nodo.getDerecho();
                } else if (nodo.getDerecho() == null) {
                    // sin HD (vacio)
                    // HI ocupa el lugar
                    retornar = nodo.getIZquierdo();
                } else {
                    // ambos hijos ocupados
                    NodoABB reemplazo = obtenerMenor(nodo.getDerecho()); // menor nodo del subarbol derecho
                    nodo.setElem(reemplazo.getElem()); //le pone el mas chico de los mayores
                    nodo.setDerecho(eliminaraux(nodo.getDerecho(), reemplazo.getElem(), exito)); //borra el nodo de los mas chicos que puso como reemplazo
                }
            }
        }

        return retornar;
    }

    private NodoABB obtenerMenor(NodoABB nodo) {
        // busca el menor elemento del arbol
        while (nodo.getIZquierdo() != null) {
            nodo = nodo.getIZquierdo();
        }
        return nodo;
    }

    public Lista listar(){
        Lista l= new Lista();
        if (this.raiz != null) {
            recorrer(this.raiz, l);
        }
        return l;
    }

    private void recorrer(NodoABB nodo, Lista l){
        
        if (nodo != null) {
            recorrer(nodo.getIZquierdo(),l );
            l.insertar(nodo.getElem(), l.longitud()+1);
            recorrer(nodo.getDerecho(), l);
        }
    }
}
