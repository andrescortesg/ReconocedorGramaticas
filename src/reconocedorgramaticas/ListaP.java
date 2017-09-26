/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocedorgramaticas;

/**
 *
 * @author andres.cortesg
 */
public class ListaP {
    private NodoP cabeza;
    
    public ListaP(){
        cabeza.setModo(3);
        cabeza.setLigaDer(cabeza);
        cabeza.setLigaIzq(cabeza);
    }
    
}
