/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocedorgramaticas;


import java.util.*;
/** 
 *Lista para una gramatica
 * @author andres.cortesg
 */
public class ListaG {
    private ListaP cabeza;
    private int nroProducciones;
    
    public ListaG(){
       nroProducciones = 0;
       cabeza = new ListaP();
       cabeza.setLigaDer(cabeza);
       cabeza.setLigaIzq(cabeza);
    }
    
    public ListaP primerProduccion(){
        return cabeza.getLigaDer();
    }
    
    public ListaP ultimaProduccion(){
        return cabeza.getLigaIzq();
    }
    
    public boolean esPrimero(ListaP x){
        return x == primerProduccion();
    }
    
    public boolean esUltimo(ListaP x){
        return x == ultimaProduccion();
    }
    
    public boolean esVacia(){
        return primerProduccion() == cabeza;
    }
    
    public ListaP getProduccionInicial(){
        return cabeza.getLigaDer();
        
    }
    
    public void imprimirGramatica(){
        ListaP x;
        x = cabeza.getLigaDer();
        while(x != cabeza){
            x.imprimirEnConsola();
            System.out.println("---------------------------------------------------------------------------");
            x = x.getLigaDer();
        }
    }
    
    public void insertarProduccion(ListaP produccion){
        if(esVacia()){
            produccion.setLigaDer(cabeza);
            produccion.setLigaIzq(cabeza);
            cabeza.setLigaDer(produccion);
            cabeza.setLigaIzq(produccion);
            nroProducciones = nroProducciones+1;
            return;
        }
        
        produccion.setLigaIzq(cabeza.getLigaIzq());
        produccion.setLigaDer(cabeza);
        cabeza.getLigaIzq().setLigaDer(produccion);
        cabeza.setLigaIzq(produccion);
        nroProducciones = nroProducciones+1;
    }
    
    public int crearProduccion(String linea){
        ListaP produccion = new ListaP(); //nueva produccion
        StringBuilder aux = new StringBuilder(); // buffer para el string a insertar
        boolean ladoDerecho = false; // verificador de lado derecho
        
        for(int i = 0; i< linea.length(); i++){
            if(linea.charAt(i) == '='){
                
            }
           
            switch(linea.charAt(i)){
                case 60: //no terminal '<'
                    
                    
                    int x = i+1;
                    while(linea.charAt(x) != '>'){
                        
                        aux.append(linea.charAt(x));
                        x = x+1;
                    }
                    System.out.println(aux);
                    i = x;
                    if(ladoDerecho == false){
                        
                        produccion.crearCabeza(aux.toString()); // crea no terminal lado izquierdo
                    }else{
                        produccion.crearElemento(aux.toString() ,0); //crea no terminal lado derecho
                    }
                    
                    break;
                case 61: // separador de lados '='
                    
                    if(produccion.cabezaVacia()){
                        return 2; // error 2: no tiene lado izquierdo
                    }else{
                        ladoDerecho = true;
                    }
                    break;
                case 32: //ignora espacios 'space'
                    
                    break;
                default:
                    
                    aux.append(linea.charAt(i));
                    produccion.crearElemento(aux.toString(), 1); //crea terminal
                    
                    break;
            }
            aux = new StringBuilder();
        }
        
        insertarProduccion(produccion);
        return 0; // terminación normal
    }
    
    
    public <String> List<String> detectarNTVivos(){
        int NTvivos = 0;
        List listaNTvivos = new ArrayList();
        ListaP x;
        x = cabeza.getLigaDer();
        System.out.println(x);
        boolean hayNTvivos = true;
        while(hayNTvivos == true){ //si se encuentra un NT vivo
            System.out.println("bucle 1--------1---1---1--" + x);
            
            while(x != cabeza){ //recorre la lista
                System.out.println(x);
                
                System.out.println("bucle 2----2----2--------");
                if(x.getCantidadNT() == 0 && x.getCantidadT() > 0){
                    listaNTvivos.add(x.getCabeza());
                    hayNTvivos = true;
                    break;
                }else{
                
                    NodoP a = x.primerElemento();
                    do{
                    
                        if(listaNTvivos.contains(x.getCabeza())){ // si ya es NT vivo
                            break;
                        }
                        if(listaNTvivos.isEmpty()){ // si no hay NT vivos por defecto
                            break;
                        }
                        if(a.getModo() == 0){ //es NT
                            if(!(listaNTvivos.contains(a.getDato()))){ // 
                                break;
                            }
                        }
                        a = a.getLigaDer();
                    
                    }while(a != x.ultimoElemento()); // recorre la produccion
                
                    if(a == x.ultimoElemento()){
                        listaNTvivos.add(a.getLigaDer().getDato()); // agreaga nombre del nodo cabeza
                        hayNTvivos = true;
                    }else{
                        hayNTvivos = false;
                    }
                    x = x.getLigaDer();
                }
            }
            x = cabeza.getLigaDer(); 
        }
        if(hayNTvivos == false && listaNTvivos.isEmpty()){
            return null;
        }
        return listaNTvivos;
    }
    
    
}
