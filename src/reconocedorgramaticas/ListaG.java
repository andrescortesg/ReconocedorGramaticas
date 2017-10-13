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

    public ListaP getCabeza() {
        return cabeza;
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
    
    
    public <String> List<String> detectarNTVivos(){
        int NTvivos = 0;
        List listaNTvivos = new ArrayList();
        ListaP x= cabeza.getLigaDer();
        
        System.out.println(x);
        
        while(x != cabeza ){// NT vivos por definición
            System.out.println("NT  "+ x.getCantidadNT()+ "TTT  "+x.getCantidadT()+ "aqui");
            if(x.getCantidadNT() == 0 && x.getCantidadT() > 0){  // Condicion para las producciones
               if (!listaNTvivos.contains(x.getCabeza())){
                NodoP z = x.cabeza();
                while(z != x.cabeza() ){
                
                z= z.getLigaDer();
                        
                }
                    listaNTvivos.add(x.getCabeza());
                 
                }
            }
            x = x.getLigaDer();
        }
        
        detectarNT(listaNTvivos);
        
        return listaNTvivos;
    }
    public NodoP detectarPrimerNTVivos(){
        int NTvivos = 0;
        ListaP x= cabeza.getLigaDer();
        NodoP vivo = new NodoP();
               
        while(x != cabeza ){// NT vivos por definición
           
            if(x.getCantidadNT() == 0 && x.getCantidadT() > 0){  // Condicion para las producciones
                
                          System.out.println("N "+ x.getCantidadNT()+ "  TTT  "+x.getCantidadT()+ "aqui");  
                          vivo =x.cabeza();
                }
                    
                 x = x.getLigaDer();
                }
    
            
                 System.out.println(vivo+"  soy yo");
        return vivo;
    }
    
    
    public <String> List<String> detectarNT(List lista){
        ListaP x = cabeza.getLigaDer();
        
        while(x != cabeza){
            if( lista.contains(x.getCabeza()) ){
                x = x.getLigaDer();
            }
            NodoP a = x.primerElemento();
            while( a != x.cabeza() ){
                if( !(lista.contains(a.getDato())) ){
                    break;
                }
                a = a.getLigaDer();
            }
            if(a == x.cabeza()){
                lista.add(a.getDato());
                
                lista =detectarNT(lista); 
            }
            x = x.getLigaDer();
        }
        
        return lista;
    }
    
    public boolean esRegular(){
        ListaP x = this.primerProduccion();
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
        ListaP x = this.primerProduccion();
        while(x != cabeza){
            if( x.getCantidadNT() >1 && x.getCantidadT() > 1 ){
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
