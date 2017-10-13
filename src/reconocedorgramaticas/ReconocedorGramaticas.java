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
        
        
        Produccion lista = new Produccion();
        
        lista.crearCabeza("D");
        
        lista.crearElemento("C", 0);
        
        lista.crearElemento("g", 1);
        
        
       
        
        //lista.imprimirEnConsola();
        
        
        
        ListaG gram = new ListaG();
        gram.insertarProduccion(lista);
        
        String pr1 = "<A> = aasdasd<C>";
        String pr2 = "<B> = b<B>";
        String pr3 = "<C>= &";
        gram.crearProduccion(pr1);
        gram.crearProduccion(pr2);
        gram.crearProduccion(pr3);
        gram.crearProduccion("<A> = &");
        gram.crearProduccion("<D> = a");
        //gram.imprimirGramatica();
//        List liss = new ArrayList();
//        liss = gram.detectarNTVivos();
//        System.out.println(liss+"hola");
        gram.imprimirGramatica();
        System.out.println(Arrays.toString(gram.detectarVivosPorDefinicion().toArray()));
        System.out.println(gram.esNTVivo(gram.detectarVivosPorDefinicion(), lista));
        
    }
    
}
