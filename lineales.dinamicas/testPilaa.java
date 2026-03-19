public class testPilaa {
    public static void main(String[] args) {
        Pila p = new Pila();
        p.apilar(1);
        p.apilar(2);
        p.apilar(3);
        System.out.println(p.obtenerTope());
        Pila p2 = p.clone();
        System.out.println(p2.obtenerTope());
        p2.desapilar();
        System.out.println(p2.obtenerTope());
        p2.desapilar();
        System.out.println(p2.obtenerTope());
        System.out.println(p==p2);
    }
}
