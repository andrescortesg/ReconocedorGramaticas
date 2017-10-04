/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocedorgramaticas;

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
        final char igual = '=';
        for(int i = 0; i< linea.length(); i++){
            if(linea.charAt(i) == igual){
                System.out.println("-----asdasdasd------------------");
            }
            switch(linea.charAt(i)){
                case '<': //no terminal
                    System.out.println("entro <");
                    
                    int x = i+1;
                    while(linea.charAt(x) != '>'){
                        System.out.println("entro loop " + linea.charAt(x));
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
                case igual: // separador de lados
                    System.out.println("entro =");
                    if(produccion.cabezaVacia()){
                        return 2; // error 2: no tiene lado izquierdo
                    }else{
                        ladoDerecho = true;
                    }
                    break;
                case ' ': //ignora espacios
                    i = i+1;
                    break;
                default:
                    System.out.println("entro def");
                    aux.append(linea.charAt(i));
                    produccion.crearElemento(aux.toString(), 1); //crea terminal
                    
                    break;
            }
            aux = new StringBuilder();
        }
        produccion.imprimirEnConsola();
        insertarProduccion(produccion);
        return 0; // terminación normal
    }
    
    
    
    
    
    
}
