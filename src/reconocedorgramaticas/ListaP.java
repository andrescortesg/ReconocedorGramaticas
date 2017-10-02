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
    
    public boolean esVacio(){
        return primerElemento() == cabeza;
    }
    
    public void insertarElemento(NodoP elemento){ // Inserción al final de la lista
        if(esVacio()){
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
    
    
}
