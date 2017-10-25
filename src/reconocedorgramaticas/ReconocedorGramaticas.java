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
        
        
        
        Gramatica gram = new Gramatica();
        
        
        String pr1 = "<A> = aasdasd<C>";
        String pr2 = "<B> = b<B>";
        String pr3 = "<C>= &";
        
        gram.crearProduccion(pr1);
        gram.crearProduccion(pr2);
        gram.crearProduccion(pr3);
        
        gram.crearProduccion("<A> = &");
        gram.crearProduccion("<C> = abc<D>");
        gram.crearProduccion("<E> = a<C><A>");
        gram.insertarProduccion(lista);
        gram.crearProduccion("<C> = xc<W>");
        gram.imprimirGramatica();
//        List liss = new ArrayList();
//        liss = gram.detectarNTVivos();
//        System.out.println(liss+"hola");
        //gram.imprimirGramatica();
        //System.out.println(Arrays.toString(gram.detectarVivosPorDefinicion().toArray()));
        NTVivosMuertos NTS = gram.detectarNTVivos();
        System.out.println(Arrays.toString(NTS.getNTVivos().toArray()));
        System.out.println(Arrays.toString(NTS.getNTMuertos().toArray()));
        System.out.println("----------+++++++++++++++++++++++++---------------");
       //gram.simplificarGramatica();
       //gram.eliminarProduccion("C");
       Produccion t = new Produccion();
       t.crearCabeza("C");
        
        gram.imprimirGramatica();
        gram.imprimirGramaticaFormal();
        System.out.println(gram.detectarAlcanzablesPorDefinicion());
        gram.esAlcanzable(gram.detectarAlcanzablesPorDefinicion(),t );
    }
    
}
