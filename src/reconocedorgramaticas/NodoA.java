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
public class NodoA {
    private String estado;
    private String simbolo;
    private List transiciones;
    
    
    public NodoA(){
        transiciones = new ArrayList();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public List getTransiciones() {
        return transiciones;
    }

    public void setTransicion(String x) {
        
        transiciones.add(x);
    }
    
    
}
