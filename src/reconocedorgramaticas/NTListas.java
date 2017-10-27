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
public class NTListas {
    private List NT1, NT0, NT2, NT3;

   
    
    public NTListas(){
        NT3 = new ArrayList(); //inalcanzables
        NT2 = new ArrayList();// alcanzables
        NT1 = new ArrayList(); //vivos
        NT0 = new ArrayList(); //muertos
        
    }

    public List getNT2() {
        return NT2;
    }

    public void setNT2(List NT2) {
        this.NT2 = NT2;
    }

    public List getNT3() {
        return NT3;
    }

    public void setNT3(List NT3) {
        this.NT3 = NT3;
    }
    

    public List getNT1() {
        return NT1;
    }

    public void setNT1(List NTVivos) {
        this.NT1 = NTVivos;
    }

    public List getNT0() {
        return NT0;
    }

    public void setNT0(List NTMuertos) {
        this.NT0 = NTMuertos;
    }
    
    
}
