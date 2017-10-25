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
    private List NTVivos, NTMuertos, NTAlcanzables, NTInalcanzables;

   
    
    public NTVivosMuertos(){
        NTVivos = new ArrayList();
        NTMuertos = new ArrayList();
        NTAlcanzables = new ArrayList();
        NTInalcanzables = new ArrayList();
    }
    
    public List getNTAlcanzables() {
        return NTAlcanzables;
    }

    public void setNTAlcanzables(List NTAlcanzables) {
        this.NTAlcanzables = NTAlcanzables;
    }

    public List getNTInalcanzables() {
        return NTInalcanzables;
    }

    public void setNTInalcanzables(List NTInalcanzabels) {
        this.NTInalcanzables = NTInalcanzabels;
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
