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
        
        Produccion p = new Produccion();
        p.crearCabeza("D");
        p.crearElemento("a", 1);
        p.crearElemento("A", 0);
        
        p.imprimirEnConsola();
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
        a.cargarEstado(p);
        p.crearCabeza("D");
        p.crearElemento("b", 1);
        p.crearElemento("B", 0);
        a.cargarEstado(p);
        
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
