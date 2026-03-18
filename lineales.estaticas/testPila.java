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

        System.out.println(Capicua(p));
       

    }
    public static boolean Capicua(Pila p){
        Pila waza=p.clone();
        int[] arr=Pilarreglo(waza);
        boolean exito=true;
        int n=0;
        while (arr[0+n]<arr.length-n-1){
            if(!(arr[0+n]==arr[arr.length-n])){
            exito=false;
            }
        n++;
        }
        return exito;
    }
    public static int[] Pilarreglo(Pila p){
        int [] hola=new int[10];
        for(int i=9;i!=-1;i--){
            hola[i]=(int)p.obtenerTope();
            p.desapilar();
        }

        return hola;
    }
}



