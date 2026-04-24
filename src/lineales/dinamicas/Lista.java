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
        Nodo nuevoNodo = new Nodo(dato, null);      //Nodo a insertar
        Nodo nodoActual = this.cabecera;                   //Nodo de recorrido
        if (pos >=1 && pos <= longitud+1) {                //Veririca dentro de limites
            if (pos == 1) {                                
                    //se inserta pos 1
                    nuevoNodo.setEnlace(cabecera);        //le pongo al nuevo nodo de enlace cabeecera
                    this.cabecera = nuevoNodo;            //ahora cabecera es nuevo nodo
                    exito = true;   

            }else if(pos == longitud+1){
                //caso añadir al final 
                for (int i = 1; i < pos-1; i++){    //itero hasta nodo pos-1
                    nodoActual = nodoActual.getEnlace();
                }
                nodoActual.setEnlace(nuevoNodo);       //a pos-1 le pongo de enlace nuevonodo
                exito = true;
            }else{
                //caso insertar en medio
                 Nodo temp = new Nodo(null, null);      //nodo auxiliar
                for(int i = 1; i < pos; i++){                       //itero hasta que llegue a pos-1
                    temp.setEnlace(nodoActual);                     // enlazo el actual a temp
                    nodoActual = nodoActual.getEnlace();            
                   
                }

                nuevoNodo.setEnlace(nodoActual);            //al nuevo nodo le pongo de enlace actual
                temp.getEnlace().setEnlace(nuevoNodo);      //al enlace de temp le coloco de enlace el nuevo nodo
                exito = true;                               //mueve los nodos a la derecha para inserta en pos el nodo nuevo
            }
        }
        return exito;
    }
/////////////////////////////////////////////////////////////
    public boolean eliminar(int pos){
        boolean exito = false;              
        int longitud = this.longitud();
    
        Nodo nodoActual = this.cabecera;
        if (pos >=1 && pos <= longitud) {       //si pos esta dentro de los limites
            if (pos == 1) {               
                    //si eliminamos primer elemento
                    nodoActual = nodoActual.getEnlace();    //me voy a pos+1
                    cabecera = nodoActual;                  //a pos+1 le seteo la cabecera, se desenlaza la antigua cabecera
                    exito = true;

            }else if(pos == longitud){
                //si eliminamos ultimo elemento
                for (int i = 1; i < pos-1; i++){
                    nodoActual = nodoActual.getEnlace();   //itero hasta pos-1 y su enlace es pos
                }
                nodoActual.setEnlace(null);        //al enlace que posee que es pos lo hago nulo borrando el nodo en pos
                exito = true;
            }else{
                //caso comun, posiciones entre medias 
                for(int i = 1; i < pos-1; i++){
                         
                    nodoActual = nodoActual.getEnlace();    //itero hasta pos-1
                    
                }
                      
                Nodo temp=nodoActual.getEnlace().getEnlace();    //guardo el nodo pos+1  
                nodoActual.setEnlace(temp);                     //lo enlazo con actual que es pos-1, 
                                                                // eliminando el del medio que es pos
                
                exito = true;
            }
        }
        return exito;
    }    
///////////////////////////////////////////////////////////////////
    public void vaciar(){
        this.cabecera= null;        //poner null la cabecera pone null toda la lista
    }
//////////////////////////////////////////////////////////////
    public Object recuperar(int pos){
        Object res = new Object();      //copia a retornar 
        Nodo actual = this.cabecera;    //nodo de recorrido
       for(int i= 1; i < pos;i++){
            actual = actual.getEnlace();    //itero hasta pos asi actual es su enlace que es pos
       }
        res = actual.getDato();             //guardo el dato en res y retorno el objeto
        return res;
    }
//////////////////////////////////////////////////////////////////////////
    public int localizar(Object unObjeto){
        int pos = -1 ;          //si no existe el objeto retona -1
        int i = 1;              //la listas empiezan en 1
        Nodo actual = this.cabecera;
        Boolean flag = false;
        while (!flag && actual != null) {       //mientras no lo encontro y la cabecera es vacia
            if (actual.getDato() == unObjeto) {     //si el dato es igual al objeto
                flag = true;                        //corta el while
                pos = i;                            //me guarda la posicion que posee
            }else{                                  //sino                        
                i++;                                // incrementa el iterador
                actual = actual.getEnlace();        // y se mueve por la lista y repite...
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
        Nodo nuevoNodo=new Nodo(null,null);         //este nodo sera el que uso para cargar
        Nodo actual=new Nodo(null,null);            //este nodo referencia el de la lista original a evaluar
        Nodo anteriorNodo=new Nodo(null,null);      //este nodo referencia el nodo ya cargado para su posterior enlace
        if(this.cabecera!=null){
            
            actual=this.cabecera;                  //solo si la lista no esta referencio la cabecera en actual
            nuevoNodo.setDato(actual.getDato());  //al nuevo nodo le seteo el dato del actual
            anteriorNodo=nuevoNodo;               //anterior nodo es el nodo que ya esta cargado
            clon.cabecera=nuevoNodo;              //seteo el primer nodo de la lista
            
            if(this.longitud()>1){  // cuando la lista tiene mas de un elemento
                for(int i=1;i<this.longitud();i++){
                    actual=actual.getEnlace();              //me muevo al siguiente nodo
                    nuevoNodo.setDato(actual.getDato());    //al nodo por cargar le pongo el dato
                    anteriorNodo.setEnlace(nuevoNodo);         //lo linkeo con el anterior cargado
                    anteriorNodo=anteriorNodo.getEnlace();  //ahora anterior es el que ya cargue
                }
            }
        }
        return clon;
    }
}
