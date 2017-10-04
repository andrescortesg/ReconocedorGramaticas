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
    private int numeroDeProduccciones;
    
    public ListaG(){
       numeroDeProduccciones = 0;
       cabeza.setLigaDer(cabeza);
       cabeza.setLigaIzq(cabeza);
    }
    
    public ListaP primerElemento(){
        return cabeza.getLigaDer();
    }
    
    public ListaP ultimoElemento(){
        return cabeza.getLigaIzq();
    }
    
    
    public boolean esPrimero(ListaP x){
        return x == primerElemento();
    }
    
    public boolean esUltimo(ListaP x){
        return x == ultimoElemento();
    }
    
    public boolean esVacia(){
        return primerElemento() == cabeza;
    }
    
    
}
