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
                nodo.setIzquierdo(eliminaraux(izq, elem, exito)); // llamado hasta que izq == elem

            } else if (comp > 0) {
                // busco x derecha
                NodoABB der = nodo.getDerecho();
                nodo.setDerecho(eliminaraux(der, elem, exito)); // llamado hasta que der == elem
            } else {
                // lo encontro elem == nodo.getElemento
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
                    nodo.setElem(reemplazo.getElem()); // le pone el mas chico de los mayores
                    nodo.setDerecho(eliminaraux(nodo.getDerecho(), reemplazo.getElem(), exito)); // borra el nodo de los
                                                                                                 // mas chicos que puso
                                                                                                 // como reemplazo
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

    public Lista listar() {
        Lista l = new Lista();
        if (this.raiz != null) {
            recorrer(this.raiz, l);
        }
        return l;
    }

    private void recorrer(NodoABB nodo, Lista l) {
        if (nodo != null) {
            recorrer(nodo.getDerecho(), l);

            l.insertar(nodo.getElem(), 1);
            recorrer(nodo.getIZquierdo(), l);
        }
    }

    public Lista listarRango(Comparable min, Comparable max) {
        Lista l = new Lista();
        if (this.raiz != null) {
            listarRangoaux(this.raiz, min, max, l);
        }
        return l;
    }

    public void listarRangoaux(NodoABB nodo, Comparable min, Comparable max, Lista l) {
        if (nodo != null) {
            if (min.compareTo(nodo.getElem()) < 0) {
                listarRangoaux(nodo.getIZquierdo(), min, max, l);
            }
            if (min.compareTo(nodo.getElem()) <= 0 && max.compareTo(nodo.getElem()) >= 0) {
                l.insertar(nodo.getElem(), l.longitud() + 1);
            }
            if (max.compareTo(nodo.getElem()) > 0) {
                listarRangoaux(nodo.getDerecho(), min, max, l);
            }
        }
    }

    public Comparable minimoElem() {
        Comparable menor = null;
        if (this.raiz != null) {
            menor = obtenerMenor(this.raiz).getElem();
        }
        return menor;
    }

    private NodoABB obtenerMayor(NodoABB nodo) {

        while (nodo.getDerecho() != null) {

            nodo = nodo.getDerecho();
        }
        return nodo;
    }

    public Comparable maximoElem() {
        Comparable mayor = null;
        if (this.raiz != null) {
            mayor = obtenerMayor(this.raiz).getElem();
        }

        return mayor;
    }

    public void eliminarMenor() {
        if (this.raiz != null) {
            // al cambiar la raiz cambia el arbol
            this.raiz = eliminarMenorAux(this.raiz);
        }
    }

    private NodoABB eliminarMenorAux(NodoABB nodo) {
        // retorna la raiz del nuevo arbol eliminado el menor de este
        NodoABB res;
        if (nodo.getIZquierdo() == null) {
            // caso base: encontre al menor -> retorno su hermano derecho (puede ser null)
            res = nodo.getDerecho();
        } else {
            // va seteando izquierdo el nodo izquierdo hasta que su izquierdo sea nulo, ahi
            // caso base
            nodo.setIzquierdo(eliminarMenorAux(nodo.getIZquierdo()));
            res = nodo;
        }
        return res;
    }

    private NodoABB buscar(Comparable elem, NodoABB nodo) {
        NodoABB res = null;
        if (nodo != null) {
            int comp = elem.compareTo(nodo.getElem());
            if (comp < 0) {
                res = buscar(elem, nodo.getIZquierdo());
            } else if (comp > 0) {
                res = buscar(elem, nodo.getDerecho());
            } else {
                res = nodo;
            }
        }
        return res;
    }

    private NodoABB invertir(NodoABB nodo) {
        NodoABB res;
        if (nodo != null) {
            res = new NodoABB(nodo.getElem(), null, null);
            res.setIzquierdo(invertir(nodo.getDerecho()));
            res.setDerecho(invertir(nodo.getIZquierdo()));
        } else {
            res = null;
        }
        return res;
    }

    public ArbolBB clonarParteInvertida(Comparable elem) {
        ArbolBB clon = new ArbolBB();
        NodoABB subraiz = buscar(elem, this.raiz); // busco la subraiz original
        if (subraiz != null) {
            NodoABB nuevaRaiz = invertir(subraiz); // invierto la subraiz original
            clon.raiz = nuevaRaiz; // le asigno la raiz al clon
        }
        return clon;
    }

    public Lista listarMayorIgual(Comparable elem) {
        Lista l = new Lista();
        if (this.raiz != null) {

            listarMayorIgualAux(elem, l, this.raiz);
        }
        return l;
    }

    private void listarMayorIgualAux(Comparable elem, Lista l, NodoABB nodo) {
        if (nodo != null) {
            int comp = nodo.getElem().compareTo(elem); // a.compareTo(b) a > b -> 1 , a < b -> -1, a = b -> 0
            if (comp > 0) {
                listarMayorIgualAux(elem, l, nodo.getIZquierdo());
            }
            if (comp >= 0) {
                l.insertar(nodo.getElem(), 1);
            }
            listarMayorIgualAux(elem, l, nodo.getDerecho());
        }
    }

    public Lista listarMenor(Comparable elem) {
        Lista l = new Lista();
        if (this.raiz != null) {

            listarMenorAux(elem, l, this.raiz);
        }
        return l;
    }

    private void listarMenorAux(Comparable elem, Lista l, NodoABB nodo) {
        // que pasa si dejo la bajada izquierda afuera del if y saco la de dentro?
        if (nodo != null) {
            int comp = nodo.getElem().compareTo(elem); // a.compareTo(b) a > b -> 1 , a < b -> -1, a = b -> 0
            if (comp < 0) {
                listarMenorAux(elem, l, nodo.getDerecho());
                l.insertar(nodo.getElem(), 1); // recorro en in-orden inverso con nodos menores a elem
            }
            listarMenorAux(elem, l, nodo.getIZquierdo()); // si el nodo es mayor a elem bajo por la izquierda que se que
                                                          // es menor a la raiz

        }
    }
}
