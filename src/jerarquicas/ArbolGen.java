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
        NodoGen nuevo = new NodoGen(dato, null, null);
        if (this.raiz != null) {
            NodoGen nodoPadre = buscarNodo(this.raiz, padre);
            // si encontro al padre puede insertarlo -> siempre es true
            if (nodoPadre != null) {
                NodoGen aux = nodoPadre.getHijoIzquierdo();
                nuevo.setHermanoDerecho(aux);
                nodoPadre.setHijoIzquierdo(nuevo);
                exito = true;
            }

        } else {
            this.raiz = nuevo;
            exito = true;
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
                while (hijo != null && res == null) {
                    res = buscarNodo(hijo, padre);
                    if (res == null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }

        }
        return res;
    }

    public boolean insertarPorPosicion(Object elemento, int posPadre) {
        boolean exito = false;
        if (this.raiz != null) {
            if (posPadre > 0) {
                int[] cont = { 1 };
                // defino nodo a insertar, nodo padre obtenido por pos, y su hijo
                NodoGen nuevo = new NodoGen(elemento, null, null);
                NodoGen padre = buscarPos(this.raiz, posPadre, cont);
                if (padre != null) {
                    // si el padre exite
                    NodoGen hijoPadre = padre.getHijoIzquierdo(); // le pregunto su hijo
                    nuevo.setHermanoDerecho(hijoPadre);
                    padre.setHijoIzquierdo(nuevo);
                    exito = true;
                }
            }
        } else {
            this.raiz = new NodoGen(elemento, null, null);
            exito = true;
        }
        return exito;
    }

    private NodoGen buscarPos(NodoGen nodo, int pos, int[] cont) {
        NodoGen res = null;

        if (nodo != null) {
            if (pos == cont[0]) {
                // comparo si encontre la pos
                res = nodo;

            } else {
                cont[0]++; // incrementa el contador ded posicion

                NodoGen hijo = nodo.getHijoIzquierdo();
                // mientras no haya llegado a pos
                while (hijo != null && res == null) {
                    res = buscarPos(hijo, pos, cont);

                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return res;

    }

    // busca si el elemento esta dentro del arbol
    public boolean pertenece(Object elemento) {
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
                while (hijo != null && !res) {
                    res = perteneceAux(hijo, elemento);
                    hijo = hijo.getHermanoDerecho();
                }
            }

        }
        return res;
    }

    public Lista ancestros(Object elemento) {
        Lista l = new Lista();
        if (this.raiz != null) {
            ancestrosaux(this.raiz, elemento, l);
        }
        return l;
    }

    private boolean ancestrosaux(NodoGen nodo, Object elemento, Lista l) {
        boolean encontrado = false;
        if (nodo != null) {
            if (nodo.getElem().equals(elemento)) {
                encontrado = true;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && !encontrado) {
                    encontrado = ancestrosaux(hijo, elemento, l);

                    hijo = hijo.getHermanoDerecho();
                }
                // cuando lo encontró
                if (encontrado) {
                    // va insertando toda la cadena de ancestros
                    l.insertar(nodo.getElem(), 1);
                }
            }
        }
        return encontrado;
    }

    public boolean esVacio() {
        boolean res = false;
        if (this.raiz == null) {
            res = true;
        }
        return res;
    }

    // altura
    public int altura() {
        return alturaAux(this.raiz);
    }

    private int alturaAux(NodoGen nodo) {
        int res = -1;
        if (nodo != null) {
            res = 0;
            NodoGen hijo = nodo.getHijoIzquierdo();

            while (hijo != null) {
                int althijo = 1 + alturaAux(hijo);
                if (althijo > res) {
                    res = althijo;
                }
                hijo = hijo.getHermanoDerecho();
            }
        }
        return res;
    }

    // metodo que devuelve el nivel en el arbol de un elemento
    public int nivel(Object elemento) {
        return nivelaux(elemento, this.raiz, 0);
    }

    private int nivelaux(Object elemento, NodoGen nodo, int nivel) {
        int res = -1;
        if (nodo != null) {
            if (nodo.getElem().equals(elemento)) {
                // encontre el elemento
                res = nivel;
            } else {
                // recorro hijo izquierdo y sus hermanos hasta encontrar el elemento
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && res == -1) {
                    // res solo cambia al encontrar el elemento, sino se mantiene en -1
                    res = nivelaux(elemento, hijo, nivel + 1);
                    hijo = hijo.getHermanoDerecho();
                }
            }

        }
        return res;
    }

    // padre()
    public Object padre(Object elemento) {
        Object res = null;
        if (this.raiz != null) {
            // raiz no tiene padre
            if (!this.raiz.getElem().equals(elemento)) {
                res = padreAux(this.raiz, elemento);
            }
        }
        return res;
    }

    private Object padreAux(NodoGen nodo, Object elemento) {
        Object res = null;
        NodoGen hijo = nodo.getHijoIzquierdo();

        while (hijo != null && res == null) {
            if (hijo.getElem().equals(elemento)) {
                res = nodo.getElem();
            } else {
                res = padreAux(hijo, elemento);
            }
            hijo = hijo.getHermanoDerecho();
        }
        return res;
    }

    public void vaciar() {
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

    // lista pos posorden
    public Lista listarPosorden() {
        Lista l = new Lista();
        if (this.raiz != null) {
            listarPosordenaux(this.raiz, l);
        }
        return l;
    }

    private void listarPosordenaux(NodoGen nodo, Lista l) {

        NodoGen hijo = nodo.getHijoIzquierdo();

        while (hijo != null) {
            listarPosordenaux(hijo, l);
            hijo = hijo.getHermanoDerecho();
        }

        l.insertar(nodo.getElem(), l.longitud() + 1);
        // h,c

    }

    public Lista listarNiveles() {

        Lista l = new Lista();
        // creo un tope de iteracion
        int altura = alturaAux(this.raiz);

        for (int i = 0; i <= altura; i++) {
            listarNivelAux(this.raiz, i, l);
        }

        return l;
    }

    private void listarNivelAux(NodoGen nodo, int nivel, Lista l) {
        // carga en la lista todos los nodos del nivel n
        if (nodo != null) {
            if (nivel == 0) {
                l.insertar(nodo.getElem(), l.longitud() + 1);
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    listarNivelAux(hijo, nivel - 1, l);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public ArbolGen clone() {

        ArbolGen nuevo = new ArbolGen();

        if (this.raiz != null) {
            nuevo.raiz = cloneAux(this.raiz);
        }

        return nuevo;
    }

    private NodoGen cloneAux(NodoGen nodo) {
        NodoGen nuevoNodo = null;
        if (nodo != null) {
            nuevoNodo = new NodoGen(nodo.getElem(), null, null);
            // copiar hijo izquierdo
            nuevoNodo.setHijoIzquierdo(cloneAux(nodo.getHijoIzquierdo()));
            // copiar hermano derecho
            nuevoNodo.setHermanoDerecho(cloneAux(nodo.getHermanoDerecho()));
        }

        return nuevoNodo;
    }

    // ToString
    // public String toString() {
    // return toStringAux(this.raiz);
    // }

    // private String toStringAux(NodoGen nodo) {
    // String s = "";
    // if (nodo != null) {
    // // visita el nodo n
    // s += nodo.getElem() + " -> ";
    // NodoGen hijo = nodo.getHijoIzquierdo();
    // // esto anota todos los hijos de nodo
    // while (hijo != null) {
    // s += hijo.getElem() + ", ";
    // hijo = hijo.getHermanoDerecho();
    // }

    // hijo = nodo.getHijoIzquierdo(); // ahora va al izquierdo de n
    // while (hijo != null) {
    // s += "\n" + toStringAux(hijo);
    // hijo = hijo.getHermanoDerecho();
    // }
    // }

    // return s;
    // }
    public String toString() {
        String cadena = "";
        if (this.raiz != null) {
            cadena = toStringAux(this.raiz);
        }
        return cadena;
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null) {
            s += n.getElem().toString() + ":";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString();
                hijo = hijo.getHermanoDerecho();
                if (hijo != null)
                    s += ",";
            }
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += '\n' + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }

    public boolean verificarCamino(Lista l) {
        boolean res = false;
        // casos: l es vacia, arbol es vacio, el primer elemento no coincide, caso malo:
        // hay que verificar el arbol -> metodo privado
        if (l.esVacia()) {
            // lista vacia -> es un camino del arbol
            res = false;
        } else if (this.raiz != null) {
            // el arbol esta vacio?
            // no -> verifico si son iguales el primer elemento de la lista y del arbol,
            // sino no corresponde a un camino
            Object a = l.recuperar(1);
            if (this.raiz.getElem().equals(a)) {
                // si coincide puedo recorrer
                int longLista = l.longitud();
                if (longLista == 1) {
                    res = true;
                } else {
                    res = verificarCaminoaux(l, this.raiz.getHijoIzquierdo(), 2, longLista);
                }

            }
        } // el arbol esta vacio
        return res;
    }

    private boolean verificarCaminoaux(Lista l, NodoGen nodo, int pos, int longLista) {
        // 20 ,54, 27
        boolean res = false;
        // analizo la lista
        if (pos > longLista) {
            // caso corte: comprobe toda la lista y en efecto
            res = true;
        } else if (nodo != null) { // recorro siempre y cuando no sea nulo -> otro caso de corte
            Object a = l.recuperar(pos);
            if (nodo.getElem().equals(a)) {
                if (pos == longLista) {
                    // caso corte
                    res = true;
                } else {
                    res = verificarCaminoaux(l, nodo.getHijoIzquierdo(), pos + 1, longLista);
                }
            } else {
                res = verificarCaminoaux(l, nodo.getHermanoDerecho(), pos, longLista);
            }
        }
        return res;
    }

    public Lista listarEntreNiveles(int niv1, int niv2) {
        Lista l = new Lista();
        if (this.raiz != null) {
            int alt = this.altura();
            if (0 <= niv1 && niv1 <= alt && 0 <= niv2 && niv2 <= alt) {
                listarEntreNivelesAux(niv1, niv2, this.raiz, 0, l);
            }
        }
        return l;
    }

    private void listarEntreNivelesAux(int niv1, int niv2, NodoGen nodo, int nivel, Lista l) {

        if (nodo != null) {
            // caso corte: nodo nulo
            if (nivel >= niv1 && nivel <= niv2) {
                // caso se insercion: que el nivel del nodo este entre niv1 y niv2
                int longLista = l.longitud();
                l.insertar(nodo.getElem(), longLista + 1);
            }
            if (nivel < niv2) {
                // caso corte: llego hasta que nivel sea menos niv2 sino accederia al nodo de
                // niv2+1
                NodoGen hijo = nodo.getHijoIzquierdo();

                while (hijo != null) {
                    // visito por izquierda hasta null y luego veo su hermano y repite
                    listarEntreNivelesAux(niv1, niv2, hijo, nivel + 1, l);
                    hijo = hijo.getHermanoDerecho();
                }
            }

        }
    }

    public void eliminar(Object elem) {
        if (this.raiz != null) {
            this.raiz = eliminarAux(this.raiz, elem);
        }
    }

    private NodoGen eliminarAux(NodoGen nodo, Object elem) {
        NodoGen resultado;

        if (nodo == null) {
            // Caso base 1: El nodo es nulo
            resultado = null;
        } else if (nodo.getElem().equals(elem)) {
            // Caso base 2: Encontramos el elemento, devolvemos su hermano (puenteo)
            resultado = nodo.getHermanoDerecho();
        } else {
            // Caso recursivo: No es el elemento, seguimos buscando y reconstruyendo
            nodo.setHijoIzquierdo(eliminarAux(nodo.getHijoIzquierdo(), elem));
            nodo.setHermanoDerecho(eliminarAux(nodo.getHermanoDerecho(), elem));
            resultado = nodo;
        }

        return resultado;
    }
    // public void eliminar(Object elem) {
    // if (this.raiz != null) {
    // if (this.raiz.getElem().equals(elem)) {
    // this.raiz = null;
    // } else {
    // eliminaraux(this.raiz, elem);
    // }
    // }
    // }

    // private void eliminaraux(NodoGen nodo, Object elem) {
    // boolean flag = false;
    // if (nodo != null) {
    // if (nodo.getHijoIzquierdo() != null) {
    // if (nodo.getHijoIzquierdo().getElem().equals(elem)) {
    // flag = true;
    // nodo.setHijoIzquierdo(nodo.getHijoIzquierdo().getHermanoDerecho());
    // }
    // }
    // if (nodo.getHermanoDerecho() != null && !flag) {
    // if (nodo.getHermanoDerecho().getElem().equals(elem)) {
    // flag = true;
    // nodo.setHermanoDerecho(nodo.getHermanoDerecho().getHermanoDerecho());
    // }
    // }
    // if (!flag) {
    // NodoGen hijo = nodo.getHijoIzquierdo();
    // while (hijo != null) {
    // eliminaraux(hijo, elem);
    // hijo = hijo.getHermanoDerecho();
    // }
    // }
    // }
    // }

    public Lista listarHastaNivel(int nivel) {
        Lista l = new Lista();
        if (this.raiz != null) {
            int[] pos = { 1 }; // asi no uso longitud()
            listarHastaNivelAux(nivel, this.raiz, l, 0, pos);
        }
        return l;
    }

    private void listarHastaNivelAux(int nivel, NodoGen nodo, Lista l, int actual, int[] pos) {
        if (nodo != null) {
            if (actual <= nivel) {
                l.insertar(nodo.getElem(), pos[0]);
                pos[0]++;
            }
            if (actual < nivel) {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    listarHastaNivelAux(nivel, hijo, l, actual + 1, pos);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public boolean verificarCaminoHoja(Lista l) {
        boolean res = false;
        if (this.raiz != null) {
            if (!l.esVacia()) {
                if (this.raiz.getElem().equals(l.recuperar(1))) {
                    int longL = l.longitud();
                    res = verificarCaminoHojaAux(l, this.raiz.getHijoIzquierdo(), 2, longL);
                }
            }
        }
        return res;
    }

    private boolean verificarCaminoHojaAux(Lista l, NodoGen nodo, int pos, int longL) {
        boolean res = false;
        // analizo la lista
        if (nodo != null && pos < longL) { // recorro siempre y cuando no sea nulo -> otro caso de corte
            Object a = l.recuperar(pos);
            if (nodo.getElem().equals(a)) {
                if (pos == longL && nodo.getHijoIzquierdo() == null) {
                    // caso corte
                    res = true;
                } else {
                    res = verificarCaminoaux(l, nodo.getHijoIzquierdo(), pos + 1, longL);
                }
            } else {
                res = verificarCaminoaux(l, nodo.getHermanoDerecho(), pos, longL);
            }
        }
        return res;
    }
}
