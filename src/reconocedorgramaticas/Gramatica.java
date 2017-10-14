/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocedorgramaticas;


import java.util.*;
/** 
 *Lista para una gramatica
 * @author andres.cortesg elkin.garces
 */
public class Gramatica {
    private Produccion cabeza;
    private int nroProducciones;
    
    /** 
    *Constructor 
    *
    */
    
    public Gramatica(){
       nroProducciones = 0;
       cabeza = new Produccion();
       cabeza.setLigaDer(cabeza);
       cabeza.setLigaIzq(cabeza);
    }

    /** 
    *Encuentra el nodo cabeza de una lista que contiene las producciones
    *
    *@return nodo cabeza de una gramática
    */
    public Produccion getCabeza() {
        return cabeza;
    }
    /** 
    *Retorna la primera producción que se encuentra en la lista 
    *@return nodo cabeza de la primera producción de una gramática
    */
    
    public Produccion primerProduccion(){
        return cabeza.getLigaDer();
    }
    /** 
    *Retorna la ultima producción que se encuentra en la lista 
    *@return nodo cabeza de la ultima producción de la gramática
    */
    
    public Produccion ultimaProduccion(){
        return cabeza.getLigaIzq();
    }
    /** 
    *Verifica si el nodo que se pasa por parámetro es el primero de la gramática 
    *@param x envia como parametro un nodo
    *@return nodo cabeza de la ultima producción
    */
    public boolean esPrimero(Produccion x){
        return x == primerProduccion();
    }
    
    /** 
    *Verifica si el nodo que se pasa por parámetro es el ultimo de la gramática 
    *@param x envia como parametro un nodo
    *@return nodo cabeza de la ultima producción
    */
    public boolean esUltimo(Produccion x){
        return x == ultimaProduccion();
    }
    /** 
    *Verifica si la lista que representa una produccion esta vacia 
    *@return true cuando esta vacia,  false cuando la lista contiene elementos
    *
    */
    
    public boolean esVacia(){
        return primerProduccion() == cabeza;
    }
    /** 
    *Retorna la primera produción de una gramática
    *@return nodo que apunta hacia la lista donde esta almacenada una producción
    */
    public Produccion getProduccionInicial(){
        return cabeza.getLigaDer();
        
    }
    /** 
    *Metodo que recorre la lista que representa la Gramática y las sublistas que representan las producciones
    */
    
    public void imprimirGramatica(){
        Produccion x;
        x = cabeza.getLigaDer();
        while(x != cabeza){
            x.imprimirEnConsola();
            System.out.println("---------------------------------------------------------------------------");
            x = x.getLigaDer();
        }
    }
    /** 
    *Metodo para insertar una produccion
    *@param produccion es una lista ligada 
    */
    
    public void insertarProduccion(Produccion produccion){
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
    /** 
    *Método para crear una producción a partir de un string
    *Se verifica cada caracter del string y se valida que sea correcta la escritura de la producción
    *@param linea es un String 
    *@return lista 
    * 
    */
    
    
    public int crearProduccion(String linea){
        Produccion produccion = new Produccion(); //nueva produccion
        StringBuilder aux = new StringBuilder(); // buffer para el string a insertar
        boolean ladoDerecho = false; // verificador de lado derecho
        boolean inBounds; // dentro de los limites
        for(int i = 0; i< linea.length(); i++){
            if(linea.charAt(i) == '='){
                
            }
            
            inBounds = (i >= 0) && (i+1 < linea.length());
            switch(linea.charAt(i)){
                case 60: //no terminal '<'
                    
                    if(!inBounds || linea.charAt(i+1) == '>'){
                        return 1; // error 1: secuencia mal escrita
                    }
                    int x = i+1;
                    boolean inX = (x >= 0) && (x+1 < linea.length());
                    while(linea.charAt(x) != '>' ){
                        if(!inX){
                            return 1; // error 1
                        }
                        aux.append(linea.charAt(x));
                        x = x+1;
                    }
                    
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
                    if(i == (linea.length()-1) ){
                        return 4; // error 4: no hay nada después del =
                    }
                    break;
                    
                case 'λ'://secuencia nula
                case '&'://secuencia nula, carácter reservado &
                    
                    if(produccion.getCantidadNT() == 0 && produccion.getCantidadT() == 0 && !inBounds){
                        aux.append(linea.charAt(i));
                        produccion.crearElemento(aux.toString(), 2); //crea terminal
                        insertarProduccion(produccion);
                        return 0;
                    }else{
                        return 3; // error 3: secuencia nula cuando tiene elementos en el lado derecho
                    }
                   
                    
                default:
                    if(inBounds){ // verifica que no tenga simbolos '>' antes de la secuencia nula
                        if(linea.charAt(i+1) == '>'){
                        return 1;
                        }
                    }
                    
                    aux.append(linea.charAt(i));
                    produccion.crearElemento(aux.toString(), 1); //crea terminal
                    
                    break;
            }
            aux = new StringBuilder();
        }
        if(produccion.esVacia()){
            return 4; //error 4: nada después del '='
        }
        insertarProduccion(produccion);
        return 0; // terminación normal
    }
    
    
    
    public <String> List<String> detectarVivosPorDefinicion(){
        int NTvivos = 0;
        Produccion x= cabeza.getLigaDer();
        NodoP vivo = new NodoP();
        List lista = new ArrayList();   
        
        while(x != cabeza ){// NT vivos por definición
            
            if( (x.getCantidadNT() == 0 && x.getCantidadT() > 0) || x.isEsNulo()){  // Condicion para las producciones
                    
                       lista.add(x.getCabeza());
                    
                    //System.out.println("N "+ x.getCantidadNT()+ "  TTT  "+x.getCantidadT()+ "aqui");  
                    
                    
                }
                   
            x = x.getLigaDer();
        }
    
            
      
        return lista;
    }
    
    public boolean esNTVivo(List listaVivos, Produccion x){ //detectar NT vivo
        NodoP a = x.primerElemento();
        while(a != x.cabeza()){
            if((!listaVivos.contains(a.getDato()) && a.getModo() == 0) ){
                return false;
            }
            
            a = a.getLigaDer();
        }
        
        return true;
    }
    
    
    public NTVivosMuertos detectarNT(){
        
        NTVivosMuertos NTS = new NTVivosMuertos();
        List NTVivos = this.detectarVivosPorDefinicion();
        NTS.setNTVivos(NTVivos);
        boolean hayNTVivos = true; // hay NT vivos
        
        Produccion x = this.getProduccionInicial();
        
        while(hayNTVivos){
            
            if(this.esNTVivo(NTVivos, x) && !NTVivos.contains(x.getCabeza())){
                
                NTVivos.add(x.getCabeza());
                x = this.getProduccionInicial();
            }
            if(x == cabeza){
                hayNTVivos = false;
            }
            
            x = x.getLigaDer();
        }
        NTVivos.remove(NTVivos.size()-1);
        NTS.setNTVivos(NTVivos);
        
        x = this.getProduccionInicial();
        List NTMuertos = new ArrayList();
        
        while(x != cabeza){
            if(!NTVivos.contains(x.getCabeza())){
                NTMuertos.add(x.getCabeza());
            }
            x = x.getLigaDer();
        }
        NTS.setNTMuertos(NTMuertos);
        
        return NTS;
    }
    
    public boolean esRegular(){
        Produccion x = this.primerProduccion();
        while(x != cabeza){
            if( x.getCantidadNT() >1 ){
                return false;
            }
            NodoP a = x.primerElemento();
            boolean NT = false;
            while(a != x.cabeza()){
                if(a.getModo() == 0){ //hay más de un no terminal
                    NT = true;
                }
                if(NT && a.getModo() == 1){ //producción de la forma <A>a
                    return false;
                }
                
                a = a.getLigaDer();
            }
            x = x.getLigaDer();
        }
        
        return true;
    }
    
    public boolean esFormaEspecial(){
        if(!esRegular()){
            return false;
        }
        Produccion x = this.primerProduccion();
        while(x != cabeza){
            if( (x.getCantidadNT() >1) || (x.getCantidadT() > 1) ){
                return false;
            }
            if(!x.isEsNulo() && x.getCantidadT() > 0 && x.getCantidadNT() == 0){
                return false;
            }
            x = x.getLigaDer();
        }
        
        return true;
    }
    
    
    //desconecta producciones
    public void desconectar( Produccion nodo){
        
        if(nodo != cabeza){
            nroProducciones = nroProducciones -1;
            nodo.getLigaIzq().setLigaDer(nodo.getLigaDer());
            nodo.getLigaDer().setLigaIzq(nodo.getLigaIzq());
            return;
        }
        System.out.println("No se puede borrar el nodo cabeza");
    }
    
    public void eliminarProduccion(String nombre){
        Produccion x = this.getProduccionInicial();
        while(x != cabeza){
            if(x.getCabeza().equals(nombre)){
                desconectar(x);
            }
            x = x.getLigaDer();
        }
    }
    
    
    //falta NT inalcanzables
    public void simplificarGramatica(){
        
        NTVivosMuertos NTVM = this.detectarNT();
        
        //bucle para eliminar producciones muertas
        Produccion x = this.getProduccionInicial();
        for(int i = 0; i < NTVM.getNTMuertos().size(); i++){
            eliminarProduccion((String) NTVM.getNTMuertos().get(i));
        }
    }
    
}
