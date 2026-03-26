import org.junit.*;
// import org.junit.Test;
public class testPila {
    //palabra clave para el test
    @Test
    public static void main(String[] args) {
        Pila p = new Pila();
        p.apilar(1);
        p.apilar(2);
        p.apilar(3);
        p.apilar(4);
        p.apilar(5);
    }
}


