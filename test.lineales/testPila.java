public class testPila {
    
    public static void main(String[] args) {
        Pila p = new Pila();
        p.apilar(1);
        p.apilar(3);
        p.apilar(6);
        p.apilar(7);
        p.apilar(6);
        p.apilar(6);
        p.apilar(7);
        p.apilar(6);
        p.apilar(3);
        p.apilar(1);
        //clono p y creo p2
        Pila p2 = p.clone();
        imprimirPila(p);
        imprimirPila(p2);
        //pruebo que p y p2 no apunten a la misma direccion de memoria
        apuntan(p, p2);

        //*main extraido de pila dinamica */
        // Pila p = new Pila();
        // p.apilar(1);
        // p.apilar(2);
        // p.apilar(3);
        // System.out.println(p.obtenerTope());
        // Pila p2 = p.clone();
        // System.out.println(p2.obtenerTope());
        // p2.desapilar();
        // System.out.println(p2.obtenerTope());
        // p2.desapilar();
        // System.out.println(p2.obtenerTope());
        // System.out.println(p==p2);

        




        //System.out.println(Capicua(p));

    }
    
    
    // public static boolean Capicua(Pila p){
    //     Pila waza=p.clone();
    //     int[] arr=Pilarreglo(waza);
    //     boolean exito=true;
    //     int n=0;
    //     while (arr[0+n]<arr.length-n-1){
    //         if(!(arr[0+n]==arr[arr.length-n])){
    //         exito=false;
    //         }
    //     n++;
    //     }
    //     return exito;
    // }
    // public static int[] Pilarreglo(Pila p){
    //     int [] hola=new int[10];
    //     for(int i=9;i!=-1;i--){
    //         hola[i]=(int)p.obtenerTope();
    //         p.desapilar();
    //     }

    //     return hola;
    // }
    public static void apuntan (Pila p1, Pila p2){
        //evalua si estan en la misma direccion de memoria, para probar el clone
        if (p1== p2) {
            System.out.println("Las pilas apuntan a la misma direccion de memoria");
        }else{
            System.out.println("Las pilas no apuntan a la misma direccion de memoria");
        }
        

        
    }
    public static void imprimirPila(Pila p){
        Pila p2 = p.clone();
        String pilaS= "";
        while (!p2.esVacia()) {
            pilaS = pilaS +p2.obtenerTope() + ", ";
            p2.desapilar();
        }
        System.out.println(pilaS);
        
    }

}



