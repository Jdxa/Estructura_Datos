package conjuntistas;

public class NodoABB {
    private Object elem;
    private NodoABB izquierdo;
    private NodoABB derecho;

    public NodoABB (Object dato, NodoABB izq, NodoABB der ){
        this.elem = dato;
        this.izquierdo = izq;
        this.derecho = der;
    }



    public Object getElem(){
        return this.elem;
    }
    public NodoABB getIZquierdo(){
        return this.izquierdo;
    }
    public NodoABB getDerecho(){
        return this.derecho;
    }

    public void setElem(Object unELem){
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