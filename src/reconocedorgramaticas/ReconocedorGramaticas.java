/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the  template in the editor.
 */
package reconocedorgramaticas;
import java.util.*;
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
         */
        
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
        
    }
    
}
