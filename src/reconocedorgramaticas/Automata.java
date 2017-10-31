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
    private Estado cabeza;
    private ArrayList<String> listaEstados;
    private ArrayList<String> listaSimbolos;
 /**
 *Constructor
 * 
 */
    
    public Automata(){
        listaEstados = new ArrayList<>();
        listaSimbolos = new ArrayList<>();
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
     
    public int nroEstados(){
        return listaEstados.size();
    }
            
    public int nroSimbolos(){
        return listaSimbolos.size();
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
    
    public void imprimirNodos(){
        
        Estado x = primerElemento();
        
        while(x != cabeza){
            System.out.println("nodo:"+x+" dato asociado:"+x.getEstado());
            NodoA y = x.primerElemento();
            while(y != x.getCabeza()){
                System.out.println("Estado:"+y.getEstado()+" Simbolo:"+y.getSimbolo());
                y = y.getLigaDer();
            }
            System.out.println(x.esVacio());
            
            x = x.getLigaDer();
        }
    }
    
    public Estado buscarEstado(String e){
        Estado x = primerElemento();
        while(x != cabeza){
            if(x.getEstado().equals(e)){
                return x;
            }
            
            x = x.getLigaDer();
        }
        
        return null;
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
    
    public void generarAutomata(Gramatica g){
        
        Produccion p = g.primerProduccion();
        while(p != g.getCabeza()){
            Estado e = new Estado();
            if(p.esNulo()){
                e.setAceptacion(true);
            }
            
            if(!listaEstados.contains(p.getCabeza())){
                listaEstados.add(p.getCabeza());
                
                Produccion x = p.getLigaDer();
                int nroP =g.getNroProducciones();
                Produccion y = x.getLigaIzq();
                System.out.println("p:"+p);
                int i = 0;
                while(i < nroP-1){
                    
                    //System.out.println("atascado lol");
                    if(x == g.getCabeza()){
                        x = x.getLigaDer();
                    }
                    System.out.println("x:"+x);
                    System.out.println("pregunta del loop:"+x.getCabeza().equals(p.getCabeza()));
                    if(x.getCabeza().equals(p.getCabeza())){
                        System.out.println("asasdasdaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                        boolean xxx =e.crearTransicion(x.ultimoElemento().getDato(), x.primerElemento().getDato());
                        System.out.println("error en la escritura?:"+xxx);
                    }
                    
                    x = x.getLigaDer();
                    i++;
                }
            }
            p = p.getLigaDer();
        }
        
        
    }
    
    
    public void desconectar(Estado e){
        if(e != cabeza){
            e.getLigaDer().setLigaIzq(e.getLigaIzq());
            e.getLigaIzq().setLigaDer(e.getLigaDer());
        }
    }
    
    
    // METODOS NO FUNCIONALES
}
