/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocedorgramaticas;

/**
 *Lista circular con nodo cabeza para una producción
 * @author andres.cortesg
 */
public class ListaP {
    private NodoP cabeza;
    
    
    public ListaP(){
        cabeza = new NodoP();
        cabeza.setModo(3); // modo nodo cabeza
        cabeza.setLigaDer(cabeza); //lista circular con nodo cabeza
        cabeza.setLigaIzq(cabeza);
        
    }
    
    public NodoP primerElemento(){
        return cabeza.getLigaDer();
    }
    
    public NodoP ultimoElemento(){
        return cabeza.getLigaIzq();
    }
    
    
    
    public boolean esPrimero(NodoP x){
        return x == primerElemento();
    }
    
    public boolean esUltimo(NodoP x){
        return x == ultimoElemento();
    }
    
    public boolean esVacia(){
        return primerElemento() == cabeza;
    }
    /*
    public NodoP buscarDondeInsertar(int lado){
        if(lado == 0){ // buscar en lado derecho
            if(esVacia()){
                return null;
            }
            NodoP x = cabeza;
            do{
                
            }while(x != ladoDerecho);
        }
        
        return null;
    }*/
    //NO PROBADO
    // Inserción al final de la lista
    public void insertarElemento(NodoP elemento){ 
        if(esVacia()){
            elemento.setLigaDer(cabeza);
            elemento.setLigaIzq(cabeza);
            cabeza.setLigaDer(elemento);
            cabeza.setLigaIzq(elemento);
        }else{
            elemento.setLigaIzq(cabeza);
            elemento.setLigaDer(cabeza.getLigaIzq());
            cabeza.setLigaIzq(elemento);
        }
    }
    
    
    
    
    //NO PROBADO
    //Crea un elemento y lo inserta al final de la lista en el lado derecho de la producción
    public void crearElemento(String nombre, int modo){ 
        NodoP nodo = new NodoP();
        nodo.setDato(nombre);
        nodo.setModo(modo);
        insertarElemento(nodo);
    }
    
    public NodoP buscar(String nombre, int instancia){
        
        
        return null;
    }
    
    //NO PROBADO
    //Desconecta el elemento
    public void desconectar(){
    
    }
}
