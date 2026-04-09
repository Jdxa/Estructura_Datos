package lineales.estaticas;
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
        
        if (this.tope > -1 ) {                          //Comprueba que no este vacio y 
           elem = this.arreglo[this.tope];              //copia el elemento del tope a elem y lo retorna
        }else{                                          // sino retorna null
            elem = null;
        }
        return elem;
    }
    public void vaciar(){                              //Vacia la pila iterativamente
        while (this.tope > -1) {                       //coloca null en cada tope y va decreciendo el tope
            this.arreglo[this.tope] = null;
            this.tope--;
        }
    }
    public boolean esVacia(){                       // comprueba si el tope es -1, si lo es retorna true, sino false
        boolean exito = false;
        if (this.tope == -1) {
            exito = true;
        }
    
        return exito;
    }
    public Pila clone(){
        Pila n = new Pila();
        // si tope es -1 no clona nada xq esta vacia
        // sino, itera desde el tope hasta 0, copiando cada elemento a la nueva pila y aumentando el tope de esta
        for(int i=0; i<=this.tope ; i++){ 
            n.arreglo[i]=this.arreglo[i];
            n.tope++;
        }
        return n;
    }
    public String toString(){
        String s = "[";
        for (int i = this.tope; i > -1; i--) {
            s += this.arreglo[i];
            if (i != 0) {
                s += ",";
            }
        }
        s += "]";
        return s;
    }

}