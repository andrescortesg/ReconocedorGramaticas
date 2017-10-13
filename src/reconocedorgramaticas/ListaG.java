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
    private Produccion cabeza;
    private int nroProducciones;
    
    public ListaG(){
       nroProducciones = 0;
       cabeza = new Produccion();
       cabeza.setLigaDer(cabeza);
       cabeza.setLigaIzq(cabeza);
    }

    public Produccion getCabeza() {
        return cabeza;
    }
    
    
    public Produccion primerProduccion(){
        return cabeza.getLigaDer();
    }
    
    public Produccion ultimaProduccion(){
        return cabeza.getLigaIzq();
    }
    
    public boolean esPrimero(Produccion x){
        return x == primerProduccion();
    }
    
    public boolean esUltimo(Produccion x){
        return x == ultimaProduccion();
    }
    
    public boolean esVacia(){
        return primerProduccion() == cabeza;
    }
    
    public Produccion getProduccionInicial(){
        return cabeza.getLigaDer();
        
    }
    
    public void imprimirGramatica(){
        Produccion x;
        x = cabeza.getLigaDer();
        while(x != cabeza){
            x.imprimirEnConsola();
            System.out.println("---------------------------------------------------------------------------");
            x = x.getLigaDer();
        }
    }
    
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
                
                    System.out.println("N "+ x.getCantidadNT()+ "  TTT  "+x.getCantidadT()+ "aqui");  
                    lista.add(x.getCabeza());
                          
                }
                    
            x = x.getLigaDer();
        }
    
            
      
        return lista;
    }
    
    public boolean esNTVivo(List listaVivos, Produccion x){ //detectar NT vivo
        NodoP a = x.primerElemento();
        while(a != x.cabeza()){
            if(!listaVivos.contains(a.getDato()) && a.getModo() == 0){
                return false;
            }
            
            a = a.getLigaDer();
        }
        
        return true;
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
    
    
    
}
