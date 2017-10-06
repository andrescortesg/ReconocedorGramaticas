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
        NodoP a = new NodoP();
        a.setModo(0);
        a.setDato("a");
        NodoP b = new NodoP();
        b.setModo(1);
        b.setDato("b");
        NodoP c = new NodoP();
        c.setModo(1);
        c.setDato("c");
        NodoP d = new NodoP();
        
        ListaP lista = new ListaP();
        lista.crearElemento("f", 0);
        
        lista.insertarElemento(a);
        
        lista.insertarElemento(b);
        
        lista.insertarElemento(c);
        lista.crearElemento("f", 0);
        
        lista.crearElemento("g", 0);
        
       
        
        //lista.imprimirEnConsola();
        
        ListaP l2 =new ListaP();
        ListaP l3 =new ListaP();
        
        ListaG gram = new ListaG();
        //gram.insertarProduccion(lista);
        String pr1 = "<A> = a<C>";
        String pr2 = "<B> = b<B><C>";
        String pr3 = "<C>= a";
        gram.crearProduccion(pr1);
        gram.crearProduccion(pr2);
        gram.crearProduccion(pr3);
        gram.imprimirGramatica();
        List liss = new ArrayList();
        liss = gram.detectarNTVivos();
        System.out.println(liss);
        
        
    }
    
}
