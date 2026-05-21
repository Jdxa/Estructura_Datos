package conjuntistas;

public class ArbolBB {
    private NodoABB raiz;

    public ArbolBB(){
        this.raiz = null;
    }

    public boolean pertenece(Comparable elem){
        boolean exito = false;
        if (this.raiz != null){
            exito = perteneceaux(this.raiz, elem);
        }
        return exito;
    }
    private boolean perteneceaux(NodoABB nodo,Comparable elem ){
        boolean esta = false;
        if (elem.compareTo(nodo.getElem())== 0){
            esta = true;
        }else if (elem.compareTo(nodo.getElem()) < 0) {
                        //comparo si voy por izquierda o derecha
            if (nodo.getIZquierdo() != null) {
                esta = perteneceaux(nodo.getIZquierdo(), elem);
            }  
        }else if (elem.compareTo(nodo.getElem())>0){
            //voy por rama derecha
             if (nodo.getDerecho()!= null) {
                esta = perteneceaux(nodo.getDerecho(), elem);
             }
        }    
        return esta;
    }
}


