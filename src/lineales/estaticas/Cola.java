package lineales.estaticas;
public class Cola {
    private int frente;
    private int finale;
    private static final int TAMANIO = 10; 
    private Object[] arr;

    public Cola(){
        this.frente = 0;
        this.finale = 0;
        this.arr = new Object[TAMANIO];
    }
    
    public boolean poner(Object dato){
        boolean exito;
        // Si la posicion final+1 es igual a frente esta llena
        if  ((this.finale + 1)  % TAMANIO != this.frente) {
            this.arr[this.finale]= dato;    
            //Incremento el tamaño, si esta en la ultima pos la pone en 0, sino
            this.finale = ((this.finale +1) % TAMANIO);
            exito= true;
        }else {
            exito = false;
        }    
        return exito;

    }
    public boolean sacar(){
        boolean exito = false;
        // Si el frente es igual al final, esta vacia
        if (this.frente != this.finale) {
            this.arr[this.frente] = null;
            //le suma 1 a frente, si esta en la ultima pos lo pone en 0
            this.frente = ((this.frente+1) % TAMANIO);
            exito = true;
        }
        return exito;
    }

    public Object obtenerFrente(){
        Object dato = null;
        if (this.arr[frente] != null) {
            dato = this.arr[frente];
        }
        return dato;
    }
    public boolean esVacia(){
        boolean exito = false;
        if (this.arr[frente] == null) {
            exito = true;
        }
        return exito;
    }
    public void vaciar(){
        while (this.arr[frente]!= null) {
            this.arr[frente] = null;
            this.frente = (this.frente +1) % TAMANIO;
        }
    }
    public Cola clone(){
        Cola clon = new Cola();                     //creo una nueva cola
        clon.arr = new Object[TAMANIO];             //creo un nuevo arreglo para la nueva cola
        for (int i = 0; i < TAMANIO; i++) {         //copio los elementos del arreglo de la cola original al nuevo arreglo
            clon.arr[i] = this.arr[i];
        }
        clon.frente = this.frente;                 //copio el valor del frente de la cola original al nuevo frente
        clon.finale = this.finale;           //copio el valor del final de la cola original al nuevo final          
        return clon;
    }
    public String toString(){
        String cadena = "[";
        if (this.arr[frente] != null) {
            int i = this.frente;
            while (i != this.finale) {
                cadena += this.arr[i] + ", ";
                i = (i + 1) % TAMANIO;
            }
        }
        cadena += "]";
        return cadena;
    }

}
