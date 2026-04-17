package lineales.dinamicas;

// import static org.junit.Assert.*;

public class Lista {
    private Nodo cabecera;


    public Lista (){
        this.cabecera = null;
    }
    public int longitud(){
        int longitud = 0;
        Nodo nodoActual = this.cabecera;
        while(nodoActual != null) {
            longitud = longitud +1;
            nodoActual = nodoActual.getEnlace();
        }
        return longitud;
    }
/////////////////////////////////////////////////////////
    public boolean insertar(Object dato, int pos){
        boolean exito = false;
        int longitud = this.longitud();
        Nodo nuevoNodo = new Nodo(dato, null);
        Nodo nodoActual = this.cabecera;
        if (pos >=1 && pos <= longitud+1) {
            if (pos == 1) {               
                    //se inserta pos 1
                    nuevoNodo.setEnlace(cabecera);
                    this.cabecera = nuevoNodo;
                    exito = true;

            }else if(pos == longitud+1){
                for (int i = 1; i < pos-1; i++){
                    nodoActual = nodoActual.getEnlace();
                }
                nodoActual.setEnlace(nuevoNodo);
                exito = true;
            }else{
                 Nodo temp = new Nodo(null, null);
                for(int i = 1; i < pos; i++){
                    temp.setEnlace(nodoActual);         
                    nodoActual = nodoActual.getEnlace();
                   
                }
                
                nuevoNodo.setEnlace(nodoActual);
                temp.getEnlace().setEnlace(nuevoNodo);
                exito = true;
            }
        }
        return exito;
    }
/////////////////////////////////////////////////////////////
    public boolean eliminar(int pos){
        boolean exito = false;
        int longitud = this.longitud();
    
        Nodo nodoActual = this.cabecera;
        if (pos >=1 && pos <= longitud) {
            if (pos == 1) {               
                    //si eliminamos primer elemento
                    nodoActual = nodoActual.getEnlace();
                    cabecera = nodoActual;
                    exito = true;

            }else if(pos == longitud){
                //si eliminamos ultimo elemento
                for (int i = 1; i < pos-1; i++){
                    nodoActual = nodoActual.getEnlace();
                }
                nodoActual.setEnlace(null);
                exito = true;
            }else{
                
                for(int i = 1; i < pos-1; i++){
                         
                    nodoActual = nodoActual.getEnlace();
                    
                }
                Nodo temp=new Nodo(null,null);
                temp=nodoActual.getEnlace().getEnlace();
                nodoActual.setEnlace(temp);
                
                exito = true;
            }
        }
        return exito;
    }    
///////////////////////////////////////////////////////////////////
    public void vaciar(){
        this.cabecera= null;
    }
//////////////////////////////////////////////////////////////
    public Object recuperar(int pos){
        Object res = new Object();
        Nodo actual = this.cabecera;
       for(int i= 1; i < pos;i++){
            actual = actual.getEnlace();
       }
        res = actual.getDato();
        return res;
    }
//////////////////////////////////////////////////////////////////////////
    public int localizar(Object unObjeto){
        int pos = -1 ;
        int i = 1;
        Nodo actual = this.cabecera;
        Boolean flag = false;
        while (!flag && actual != null) {
            if (actual.getDato() == unObjeto) {
                flag = true;
                pos = i;
            }else{
                i++;
                actual = actual.getEnlace();
            }
        }
        return pos;
    }
/////////////////////////////////////////////////////////////////
    public boolean esVacia(){
        boolean exito= false;
        if (this.longitud() == 0) {
            exito = true;
        }
        return exito;
    }
///////////////////////////////////////////////////////////////////
    public String toString(){
        String res= "[";
        Nodo actual = this.cabecera;
        while (actual != null) {
            res = res + actual.getDato();
            if (actual.getEnlace() != null){
                res = res + ",";
            }
            actual = actual.getEnlace();
        }
        res = res + "]";
        return res;
    }
//////////////////////////////////////////////////////////////
    public Lista clone(){
        Lista clon=new Lista();
        Nodo nuevoNodo=new Nodo(null,null);
        Nodo actual=new Nodo(null,null);
        Nodo anteriorNodo=new Nodo(null,null);
        if(this.cabecera!=null){
            actual=this.cabecera;
            nuevoNodo.setDato(actual.getDato());
            anteriorNodo=nuevoNodo;
            clon.cabecera=nuevoNodo;
            
            if(this.longitud()>1){
                for(int i=1;i<this.longitud();i++){
                    actual=actual.getEnlace();
                    nuevoNodo.setDato(actual.getDato());
                    anteriorNodo.setEnlace(nuevoNodo);
                    anteriorNodo=anteriorNodo.getEnlace();
                }
            }
        }
        return clon;
    }
}
