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
public class NTVivosMuertos {
    private List NTVivos, NTMuertos;
    
    public NTVivosMuertos(List vivos){
        NTVivos = vivos;
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
