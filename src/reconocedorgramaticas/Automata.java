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
    private ArrayList<NodoA> estadosAceptacion = new ArrayList<>();
    private int estados, simbolos;
    private Estado cabeza;
 /**
 *Constructor
 * 
 */
    
    public Automata(){
        esDeterministico = true;
        estadosAceptacion = new ArrayList<>();
        cabeza = new Estado();
        cabeza.setLigaDer(cabeza);
        cabeza.setLigaIzq(cabeza);
    }

    
 /**
 *Metodo para determinar si el automata es deterministico
 * @return true si cumple para ser deterministico false de lo contrario
 * 
 */
    public boolean esDeterministico() {
        return esDeterministico;
    }
    
    public ArrayList<NodoA> getEstadosAceptacion(){
        return estadosAceptacion;
    }
    
    public boolean esVacia(){
        return cabeza == cabeza.getLigaIzq();
    }
    
    public Estado getCabeza(){
        return cabeza;
    }
    public Estado primerElemento(){
        return cabeza.getLigaDer();
    }
    public Estado ultimoElemento(){
        return cabeza.getLigaIzq();
    }
    
    public void insertarEstado(Estado e){ // inserción al final
        if(!e.esDeterministico()){
                esDeterministico = false;
        }
        if(!esVacia()){ // si No es vacia
            e.setLigaDer(cabeza.getLigaIzq());
            e.setLigaDer(cabeza.getLigaIzq().getLigaDer());
            cabeza.getLigaIzq().setLigaDer(e);
            cabeza.setLigaIzq(e);
        }else{ // caso contrario
            cabeza.setLigaDer(e);
            cabeza.setLigaIzq(e);
            e.setLigaDer(cabeza);
            e.setLigaIzq(cabeza);
        }
        
    }
    
    public void desconectar(Estado e){
        if(e != cabeza){
            e.getLigaDer().setLigaIzq(e.getLigaIzq());
            e.getLigaIzq().setLigaDer(e.getLigaDer());
        }
    }
    
    
}
