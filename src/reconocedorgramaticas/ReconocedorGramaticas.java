/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the  template in the editor.
 */
package reconocedorgramaticas;

/**
 *
 * @author andres.cortesg
 */
public class ReconocedorGramaticas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // --------------- AREA DE PRUEBAS E INICALIZACIÓN ------------------
        
        /**
         * Notas de pruebas
         * -Terminado funcionalidad de gramaticas
         * -falta terminar metodos base de Automata y Estado
         */
        
        
        /*
        Estado a = new Estado();
        a.setEstado("A");
        a.crearTransicion("A", "1");
        a.crearTransicion("B", "2");
        a.crearTransicion("C", "3");
        
        System.out.println(a.imprimir());
        System.out.println(a.esDeterministico());
        a.crearTransicion("D", "1");
        System.out.println(a.imprimir());
        System.out.println(a.esDeterministico());
        */
        
        Automata a = new Automata();
        
        
        Gramatica g = new Gramatica();
        
        g.crearProduccion("<S> = a<A>");
        
    g.crearProduccion("<S> = b<B>");
    g.crearProduccion("<S> = c<A>");
    g.crearProduccion("<A> = b<S>");
    g.crearProduccion("<A>= c<A>");
    g.crearProduccion("<A> =&");

        a.generarAutomata(g);
        Estado x = new Estado();
        x.setEstado("jajajaja");
        Estado y = new Estado();
        y.setEstado("asdasdasd");
        Estado z = new Estado();
        z.setEstado("sddfsdf");
        a.insertarEstado(x);
        a.insertarEstado(y);
        a.imprimirNodos();
        System.out.println("esto se ejecuta");
    }
    
}
