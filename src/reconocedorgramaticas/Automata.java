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
    
    public boolean esVacio(){
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
            
            
            x = x.getLigaDer();
        }
    }
    
    public void imprimir(){
        Estado x = primerElemento();
        while(x != cabeza){
            if(x.getAceptacion()){
                System.out.println(x.imprimir()+ "\t 1");
            }else{
                System.out.println(x.imprimir()+ "\t 0");
            }
            
            x = x.getLigaDer();
        }
    }
    
    //probado
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
    
    
    //probado
    public void insertarEstado(Estado e){ // inserción al final
        if(!e.esDeterministico()){
                esDeterministico = false;
        }
        if(!esVacio()){ // si No es vacia
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
    
    public int crearEstado(String estado){
        if(!listaEstados.contains(estado)){
            listaEstados.add(estado);
            Estado e = new Estado();
            e.setEstado(estado);
            insertarEstado(e);
            imprimir();
            return 0;
        }
        return 1;
    }
    
    public int crearTransiciones(Produccion p){
        Estado x = buscarEstado(p.getCabeza());
        if(x != null){
            x.crearTransicion(p.ultimoElemento().getDato(), p.primerElemento().getDato());
            x.imprimirEstado();
            return 0;
        }
        return 1;
        
    }
    
    public void generarAutomata(Gramatica g){
        Produccion p = g.primerProduccion();
        
        while(p != g.getCabeza()){
            if(p.esNulo()){
                buscarEstado(p.getCabeza()).setAceptacion(true);
            }else{
                crearEstado(p.getCabeza());
                crearTransiciones(p);
            }
            p = p.getLigaDer();
        }
        
    }
    
    public int conectar(Estado x, Estado estado){
        Estado t = primerElemento();
        while(t != cabeza){
            if( t == x){
                estado.setLigaIzq(t);
                estado.setLigaDer(t.getLigaDer());
                t.getLigaDer().setLigaIzq(estado);
                t.setLigaDer(estado);
                return 0;
            }
            t = t.getLigaDer();
        }
        return 1;
    }
    
    public void desconectar(Estado e){
        if(e != cabeza){
            e.getLigaDer().setLigaIzq(e.getLigaIzq());
            e.getLigaIzq().setLigaDer(e.getLigaDer());
        }
    }
    
    
    

    
}
