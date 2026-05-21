package conjuntistas;

public class NodoABB {
    private Comparable elem;
    private NodoABB izquierdo;
    private NodoABB derecho;

    public NodoABB (Comparable dato, NodoABB izq, NodoABB der ){
        this.elem = dato;
        this.izquierdo = izq;
        this.derecho = der;
    }



    public Comparable getElem(){
        return this.elem;
    }
    public NodoABB getIZquierdo(){
        return this.izquierdo;
    }
    public NodoABB getDerecho(){
        return this.derecho;
    }

    public void setElem(Comparable unELem){
        this.elem=unELem;
    }

    public void setIzquierdo(NodoABB unNodo){
        this.izquierdo=unNodo;
    }
    public void setDerecho(NodoABB unNodo){
        this.derecho=unNodo;
    }
}
// git pull
// git add .
// git commit -m "asdas"
// git push