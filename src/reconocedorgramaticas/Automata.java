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
 * @author elkin.garces
 */
public class Automata implements Cloneable{
    private boolean esDeterministico;
    private ArrayList<NodoA> automata = new ArrayList<>();
    
 /**
 *Constructor
 * 
 */
    
    public Automata(){
        esDeterministico = true;
    }

    public Object clone()throws CloneNotSupportedException{  
        return super.clone();  
    } 
 /**
 *Metodo para determinar si el automata es deterministico
 * @return true si cumple para ser deterministico false de lo contrario
 * 
 */
    public boolean EsDeterministico() {
        return esDeterministico;
    }
/**
 *Metodo para retornar una lista que representa un automata
 * @return automata en forma de arraylist
 * 
 */
    
    public ArrayList<NodoA> getAutomata() {
        return automata;
    }
    
    
    
}
