package jerarquicas;

public class NodoGen {
    private Object elem; // dato que guarda el nodo
    private NodoGen hijoIzquierdo; // hijo izquierdo del nodo
    private NodoGen hermanoDerecho; // hermanos del mismo nivel que this.nodo

    public NodoGen(Object dato, NodoGen hijoIzq, NodoGen hermDer) {
        this.elem = dato;
        this.hijoIzquierdo = hijoIzq;
        this.hermanoDerecho = hermDer;
    }
    //getter y setters
    public Object getElem() {
        return this.elem;
    }

    public NodoGen getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho() {
        return this.hermanoDerecho;
    }

    public void setElem(Object dato){
        this.elem = dato;
    }

    public void setHijoIzquierdo(NodoGen izq){
        this.hijoIzquierdo = izq;
    }
    public void setElem(NodoGen hermDer){
        this.hermanoDerecho = hermDer;
    }

}
