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
        boolean exito = false;
        // Si la posicion final+1 es igual a frente esta llena
        if  ((this.finale +1 ) % TAMANIO == this.frente) {
            this.arr[this.finale]= dato;
            exito= true;
            //Incremento el tamaño, si esta en la ultima pos la pone en 0, sino
            this.finale = (this.finale +1) % TAMANIO;
        }else{
            exito = false;
        }
        return exito;

    }

}
