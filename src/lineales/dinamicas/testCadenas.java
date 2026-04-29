package lineales.dinamicas;
import static org.junit.Assert.*;
import org.junit.Test;
public class testCadenas {
    


    public Cola generar(Cola c1){
        Cola res = new Cola();   //Cola resultante
        Lista l= new Lista(); //Lista auxiliar que guardara los caracteres ordenadso
        Pila p = new Pila(); //Pila auxiliar que guardara los caracteres invertidos
        int pos = 1; // pos de la lista
        while (!c1.esVacia()) {
            char dato = (char)c1.obtenerFrente(); //obtengo el frente actual
            c1.sacar();
            if (dato != '#') {
                //vierto la primera parte de la cola en lista y pila    
                p.apilar(dato);         //guardo los caracteres invertidos
                l.insertar(dato, pos);  //guardo los caracteres ordenados
                pos++;  
            }else{
                //ordenada
                int lenght= l.longitud();
                for (int i= 1; i <= lenght; i++){
                    res.poner(l.recuperar(i)); //vierto toda la lista en la nueva cola
                }
                //invertida
                while (!p.esVacia()) {
                    res.poner(p.obtenerTope()); //vierto el tope sobre la cola
                    p.desapilar();      //desapilo para vertir toda la pila sobre la cola y vaciarla
                }
                // ordenada
                for (int i= 1; i <= lenght; i++){
                    res.poner(l.recuperar(i)); //vierto de vuelta toda la lista en la nueva cola
                }
                res.poner('#'); //separador correspondiente

                l.vaciar(); //vacio la lista
                pos = 1; //reinicio pos lista
            }
            
        }
        //ahora con el ultimo segmento que no termina com
        if (!l.esVacia()) {
            //vierto la lista
            int lenght = l.longitud();
            for (int i= 1; i <= lenght; i++){
                res.poner(l.recuperar(i)); //vierto de vuelta toda la lista en la nueva cola
            }
            //vierto invertida
            while (!p.esVacia()) {
                res.poner(p.obtenerTope());
                p.desapilar();
            }
            //vierto lista
            for (int i= 1; i <= lenght; i++){
                res.poner(l.recuperar(i)); //vierto de vuelta toda la lista en la nueva cola
            }
        }
        return res;

        //l va a ser [A,B] luego [C] luego [D,E,F]
        // P va a ser [B,A] luego [C] luego [F,E,D]
    }

    @Test
    public void testgenerar(){
        Cola c1 = new Cola();
        c1.poner('A');
        c1.poner('B');
        c1.poner('#');
        c1.poner('C');
        c1.poner('#');
        c1.poner('D');
        c1.poner('E');
        c1.poner('F');

        Cola clone = generar(c1); // [A,B,B,A,A,B#,C,C,C,#,D,E,F,F,E,D,D,E,F]
        assertEquals(clone.toString(),"[A,B,B,A,A,B,#,C,C,C,#,D,E,F,F,E,D,D,E,F]");
    }

    public boolean verificarBalanceo(Cola q){ //q va a ser una expresion matematica
        boolean balanceo = true; //true si esta balanceada; false si no lo está
        Pila p = new Pila();
        Cola aux = new Cola(); //para volver a acomodar la cola q

        while (balanceo && !q.esVacia()) {
            char c = (char) q.obtenerFrente();
            q.sacar();
            aux.poner(c); //para no perder la cola

            if (c == '{' || c== '[' || c== '('){
                p.apilar(c); //la apilo en una pila auxiliar para verificar despues
            }else if(c == '}' || c== ']' || c== ')' ){
               if (p.esVacia()) {
                   //si es una cerradura y no apile nada en p, no está balanceada
                    balanceo= false;
               }else{
                    char tope = (char) p.obtenerTope(); //obtengo el tope cargado en la pila
                    //comparo aberturas y cerraduras
                    if ((c == ')' && tope == '(') ||(c == ']' && tope == '[') ||
                    (c == '}' && tope == '{')) {
                        p.desapilar(); //si concuerdan desapilo
                        
                    }else{
                        balanceo =false; //si no comprueba ninguna comparacion esta desbalanceado
                    }   

               }
                
            }
        }
        //restauro la cola q a su estado original
        while (!aux.esVacia()) {
            q.poner(aux.obtenerFrente());
            aux.sacar();
        }
        return balanceo;
    }

    @Test
    public void testVerificarBalanceo(){
        Cola q= new Cola();
        q.poner('[');
        q.poner('(');
        q.poner('2');
        q.poner('+');
        q.poner('2');
        q.poner(')');
        q.poner('*');
        q.poner('2');
        q.poner(']');   //[(2+2)*2]
        boolean v = verificarBalanceo(q);
        assertTrue(v);
        assertEquals(q.toString(), "[[,(,2,+,2,),*,2,]]");
    }
    @Test
    public void testVerificarDesbalanceo(){
        Cola q= new Cola();
        q.poner('[');
        q.poner('(');
        q.poner('2');
        q.poner('+');
        q.poner('2');
        q.poner('*');
        q.poner('2');
        q.poner(']');   //[(2+2*2]  me faltaria un )
        boolean v = verificarBalanceo(q);
        assertFalse(v);
        assertEquals(q.toString(), "[[,(,2,+,2,*,2,]]");
    }
}
