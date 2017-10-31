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
    private boolean aceptacion;
    
    
    public Estado(){
        noDeterministico = aceptacion = false;
        ligaDer = ligaIzq = null;
        cabeza = new NodoA();
        cabeza.setLigaDer(cabeza);
        cabeza.setLigaIzq(cabeza);
        cabeza.setSimbolo(null);
        cabeza.setEstado(null);
    }
    public boolean esVacio(){
        return cabeza == cabeza.getLigaIzq();
    }
    
    public void setAceptacion(boolean a){
        aceptacion = a;
    }
    
    public boolean getAceptacion(){
        return aceptacion;
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
    
    public String getEstado(){ //estado actual
        return cabeza.getEstado();
    }
    
    public void setEstado(String estado){ // define el estado actual de la trasicion
        cabeza.setEstado(estado);
        
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
    
    public NodoA desconectar(NodoA t){ 
        //si el nodo a desconectar no es cabeza = false
        //caso contrario = true
        if(t != cabeza){
            t.getLigaDer().setLigaIzq(t.getLigaIzq());
            t.getLigaIzq().setLigaDer(t.getLigaDer());
            return t;
        }
        return null;
    }
    
    public void insertarTransicion(NodoA t){ // inserción al final
        if(!esVacia()){ // si No es vacia
            t.setLigaDer(cabeza.getLigaIzq());
            t.setLigaDer(cabeza.getLigaIzq().getLigaDer());
            cabeza.getLigaIzq().setLigaDer(t);
            cabeza.setLigaIzq(t);
        }else{ // caso contrario
            cabeza.setLigaDer(t);
            cabeza.setLigaIzq(t);
            t.setLigaDer(cabeza);
            t.setLigaIzq(cabeza);
        }
        
    }
    
    public boolean crearTransicion(String estado, String simbolo){ // crea una transicion
        NodoA x = new NodoA();
        x.setEstado(estado);
        x.setSimbolo(simbolo);
        insertarTransicion(x);
        return !esVacia();
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
    
    public void imprimirEstado(){
        NodoA x = primerElemento();
        
        while(x != cabeza){
            System.out.println("Estado:"+x.getEstado()+" Simbolo:"+x.getSimbolo());
            x = x.getLigaDer();
        }
    }
    
    
    //en desarrollo
    public Estado unirEstados(ArrayList<Estado> estados){
        if(estados.isEmpty()){
            return null;
        }
        Estado e = new Estado();
        //creación del nuevo estado
        while(!estados.isEmpty()){
            
        }
        
        
        return null;
    }
    
    public void moverAlInicio(){
        
    }
    
    public int ordenarTransiciones(ArrayList<String> listaSimbolos){
        
        
        
        return 0;
    }
}
