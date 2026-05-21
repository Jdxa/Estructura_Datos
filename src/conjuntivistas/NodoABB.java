package conjuntivistas;

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
    public void setElem(){
        
    }
// git pull
// git add .
// git commit -m "asdas"
// git push
}
