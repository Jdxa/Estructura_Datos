public class Pila {
    private int tope;
    private Object[] arreglo;
    private static final int TAMANIO= 10;

    //Constructor
    public Pila(){
        this.tope= -1;
        this.arreglo = new Object[TAMANIO];
    }

    
    
    public boolean apilar(Object elem){
        boolean exito;
        if(this.tope < TAMANIO){
            this.tope++;
            this.arreglo[this.tope] = elem;
            exito =true;
        }else{
            exito = false;
        }

        return exito;
    }

    public boolean desapilar(){
        boolean exito;
        if (this.tope > -1 ) {
            this.arreglo[this.tope] = null;
            this.tope--;
            exito = true;
        }else{
            exito = false;
        }
        return exito;
    }

    public Object obtenerTope (){
        Object elem; 
        if (this.tope > -1 ) {
           elem = this.arreglo[this.tope];
        }else{
            elem = null;
        }
        return elem;
    }
    public void vaciar(){
        while (this.tope > -1) {
            this.arreglo[this.tope] = null;
            this.tope--;
        }
    }
    public boolean esVacia(){
        boolean exito = false;
        if (this.tope == -1) {
            exito = true;
        }
    
        return exito;
    }
    public Pila clone(){
        Pila n = new Pila();
        for(int i=0;i<=this.tope;i++){
            
            n.arreglo[i]=this.arreglo[i];
            n.tope++;
        }
        return n;
    }


}