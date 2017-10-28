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
public class Estado {
    
    private Estado ligaDer, ligaIzq;
    private NodoA cabeza;
    private boolean noDeterministico;
    private ArrayList<NodoA> estados;
    
    public Estado(){
        ligaDer = ligaIzq = null;
        cabeza = new NodoA();
        cabeza.setLigaDer(cabeza);
        cabeza.setLigaIzq(cabeza);
    }

    public Estado getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(Estado ligaDer) {
        this.ligaDer = ligaDer;
    }

    public Estado getLigaIzq() {
        return ligaIzq;
    }

    public void setLigaIzq(Estado ligaIzq) {
        this.ligaIzq = ligaIzq;
    }
    
    public NodoA getCabeza(){
        return cabeza;
    }
    
    public NodoA primerElemento(){
        return cabeza.getLigaDer();
    }
    
    public NodoA ultimoElemento(){
        return cabeza.getLigaIzq();
    }
    
    public boolean esVacia(){
        return cabeza.getLigaDer() == cabeza;
    }
    
    
    public StringBuilder imprimir(){
        StringBuilder transicion = new StringBuilder();
        NodoA a = cabeza;
        transicion.append(a.getEstado()).append("\t");
        a = a.getLigaDer();
        while(a != cabeza){
            transicion.append("|").append("\t").append(a.getSimbolo()).append("-").append(a.getEstado());
            a = a.getLigaDer();
        }
        transicion.append("|");
        return transicion;
    }
    
    public void insertarTransicion(NodoA x){ // inserción al final
        if(!esVacia()){ // si No es vacia
            x.setLigaDer(cabeza.getLigaIzq());
            x.setLigaDer(cabeza.getLigaIzq().getLigaDer());
            cabeza.getLigaIzq().setLigaDer(x);
            cabeza.setLigaIzq(x);
        }else{ // caso contrario
            cabeza.setLigaDer(x);
            cabeza.setLigaIzq(x);
            x.setLigaDer(cabeza);
            x.setLigaIzq(cabeza);
        }
        
    }
    
    public void crearTransicion(String estado, String simbolo){ // crea una transicion
        NodoA x = new NodoA();
        x.setEstado(estado);
        x.setSimbolo(simbolo);
        insertarTransicion(x);  
    }
    
    public void setEstado(String estado){ // define el estado actual de la trasicion
        cabeza.setEstado(estado);
        cabeza.setSimbolo(null);
    }
    
    public boolean esDeterministico(){ //determina si es deterministico con una busqueda simple
        NodoA x, y;
        x = primerElemento();
        y = x.getLigaDer();
        
        while(x != cabeza){
            while(y != cabeza){
                if(y.getSimbolo().equals( x.getSimbolo())){
                    
                    return false;
                }
                y = y.getLigaDer();
            }
            
            x = x.getLigaDer();
            y = x.getLigaDer();
        }
        
        return true;
      
    }
    
    
}
