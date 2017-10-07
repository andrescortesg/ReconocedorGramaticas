/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocedorgramaticas;
import java.util.*;
/**
 *
 * @author andres.cortesg
 */
public class Automata {
    private boolean esDeterministico;
    private ArrayList<NodoA> automata = new ArrayList<>();
    
    public Automata(){
        esDeterministico = true;
    }

    public boolean isEsDeterministico() {
        return esDeterministico;
    }

    public ArrayList<NodoA> getAutomata() {
        return automata;
    }
    
   
    
}
