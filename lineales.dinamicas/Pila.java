public class Pila {
    private Nodo tope;

    public Pila(){
        this.tope = null;
    }
    public boolean apilar(Object elem){
        Nodo nuevo = new Nodo(elem, this.tope);
        this.tope = nuevo;
        return true;
    }
     public boolean desapilar(){
        boolean exito= false;
        if (this.tope != null) {
            this.tope = this.tope.getEnlace();
            exito = true;
        }
        return exito;   
    }

    public boolean vaciar(){
        this.tope = null;
        return true;
    }
    public boolean esVacia(){
        boolean exito = false;
        if (this.tope == null) {
            exito = true;
        }
        return exito;
    }
    public Object obtenerTope(){
        Object elem;
        if (this.tope != null) {
            elem = this.tope.getDato();
        }else{
            elem = null;
        }
        return elem;
    }
    public Pila clone(){
        //TESTEAR
        Pila n = new Pila();
        Nodo nodoActual = this.tope;
        Nodo nodoAnterior = null;
        while (nodoActual != null) {
            Nodo nuevoNodo = new Nodo(nodoActual.getDato(), null);
            if (nodoAnterior == null) {
                n.tope = nuevoNodo;
                nodoAnterior = nodoActual;
            }else{
                nodoAnterior.setEnlace(nuevoNodo);
                n.tope = nuevoNodo;
            }
            
            nodoActual = nodoActual.getEnlace();
        }        
        return n;
    }

}
