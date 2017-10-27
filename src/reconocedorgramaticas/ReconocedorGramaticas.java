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
        
        /*
        String pr1 = "<S> = a<A><B><S>";
        String pr2 = "<S> =b<C><A><C> d";
        String pr3 = "<C>= &";
        */
        //gram.crearProduccion(pr1);
        //gram.crearProduccion(pr2);
        //gram.crearProduccion(pr3);
        
        gram.crearProduccion("<S> = a<A>");
        gram.crearProduccion("<S> = b");
        gram.crearProduccion("<S> = <A>");
        //gram.insertarProduccion(lista);
        gram.crearProduccion("<A>= c<A>");
        gram.crearProduccion("<A>= abb<S>");
        gram.crearProduccion("<A>= abbc");
        gram.crearProduccion("<A> =&");
        









        gram.imprimirGramatica();
//        List liss = new ArrayList();
//        liss = gram.detectarNTVivos();
//        System.out.println(liss+"hola");
        //gram.imprimirGramatica();
        //System.out.println(Arrays.toString(gram.detectarVivosPorDefinicion().toArray()));
        NTListas NTS = gram.detectarNTVivos();
        //System.out.println(Arrays.toString(NTS.getNT1().toArray()));
        //System.out.println(Arrays.toString(NTS.getNT0().toArray()));
        //System.out.println("----------+++++++++++++++++++++++++---------------");
       //gram.simplificarGramatica();
       //gram.eliminarProduccion("C");
       //Produccion t = new Produccion();
       //t.crearCabeza("C");
        
        //gram.imprimirGramatica();
        //gram.imprimirGramaticaFormal();
        //System.out.println(gram.detectarAlcanzablesPorDefinicion());
        //gram.esNTAlcanzable(gram.detectarAlcanzablesPorDefinicion(),t );
       //System.out.println(gram.detectarNTAlcanzables().getNT1());
       gram.caso1S();
       gram.imprimirGramaticaFormal();
    }
    
}
