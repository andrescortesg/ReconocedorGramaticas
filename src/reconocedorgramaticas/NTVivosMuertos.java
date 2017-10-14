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
 * 
 * Clase para No terminales vivos y muertos
 */
public class NTVivosMuertos {
    private List NTVivos, NTMuertos;
    
    public NTVivosMuertos(){
        NTVivos = new ArrayList();
        NTMuertos = new ArrayList();
    }

    public List getNTVivos() {
        return NTVivos;
    }

    public void setNTVivos(List NTVivos) {
        this.NTVivos = NTVivos;
    }

    public List getNTMuertos() {
        return NTMuertos;
    }

    public void setNTMuertos(List NTMuertos) {
        this.NTMuertos = NTMuertos;
    }
    
    
}
