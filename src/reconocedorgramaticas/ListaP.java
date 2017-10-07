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
    private ListaP ligaDer, ligaIzq;
    private int cantidadT, cantidadNT;
    private boolean esNulo;
    

    
    
    public ListaP(){
        cabeza = new NodoP();
        cabeza.setModo(0); // modo No terminal
        cabeza.setLigaDer(cabeza); //lista circular con nodo cabeza
        cabeza.setLigaIzq(cabeza);
        cantidadT = cantidadNT = 0;
        esNulo = false;
        
    }

    public boolean isEsNulo() {
        return esNulo;
    }

    public int getCantidadT() {
        return cantidadT;
    }

    public int getCantidadNT() {
        return cantidadNT;
    }
    
    public ListaP getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(ListaP ligaDer) {
        this.ligaDer = ligaDer;
    }

    public ListaP getLigaIzq() {
        return ligaIzq;
    }

    public void setLigaIzq(ListaP ligaIzq) {
        this.ligaIzq = ligaIzq;
    }
    
    public void crearCabeza(String dato){
        cabeza.setDato(dato);
    }
    
    public String getCabeza(){
        return cabeza.getDato();
    }
    
    public NodoP cabeza(){
        return cabeza;
    }
    
    public boolean cabezaVacia(){
        return cabeza.getDato().isEmpty();
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
    
    //en espera
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
    
    
    //PROBADO
    // Inserción al final de la lista
    public void insertarElemento(NodoP elemento){ 
        if(esVacia()){
            elemento.setLigaDer(cabeza);
            elemento.setLigaIzq(cabeza);
            cabeza.setLigaDer(elemento);
            cabeza.setLigaIzq(elemento);
            return;
        }
        
        
        elemento.setLigaIzq(cabeza.getLigaIzq());
        elemento.setLigaDer(cabeza);
        cabeza.getLigaIzq().setLigaDer(elemento);
        cabeza.setLigaIzq(elemento);
    }
    
    
   
    
    // PROBADO
    //Crea un elemento y lo inserta al final de la lista en el lado derecho de la producción
    public void crearElemento(String nombre, int modo){ 
        NodoP nodo = new NodoP();
        if(modo == 0){
            cantidadNT++;
            
        }
        if(modo == 1){
            cantidadT++;
            
        }
        if(modo == 2){
            esNulo= true;
        }
        nodo.setDato(nombre);
        nodo.setModo(modo);
        insertarElemento(nodo);
    }
    
    
    
    
    //En espera pero funciona
    public NodoP buscarElemento( int instancia,String nombre){
        NodoP x;
        x = cabeza.getLigaDer();
        int f = 0;
        
        while(x != cabeza ){
            if(x.getDato().equals(nombre)){
                f = f+1;
                if(f == instancia){
                    
                    return x;
                }
  
            }
            
            x = x.getLigaDer();
            
        } 
        
        return null;
    }
    
    public void modificarDato(NodoP nodo,String dato){
        nodo.setDato(dato);
       
    }
    
    public void modificarModo(NodoP nodo, int modo){
        nodo.setModo(modo);
    }
    
    //Probado funciona
    public void imprimirEnConsola(){
        NodoP x;
        x = cabeza;
        do{
            System.out.println("Nombre: "+x.getDato()+" -Modo: "+x.getModo() + " Nodo: "+ x);
            x = x.getLigaDer();
        }while(x != cabeza);
        System.out.println("cantidad NT: "+cantidadNT );
        System.out.println("cantidad T: "+cantidadT);
    }
    
    //NO PROBADO
    //Desconecta el elemento
    public void desconectar( NodoP nodo){
        if(nodo != cabeza){
            nodo.getLigaIzq().setLigaDer(nodo.getLigaDer());
            nodo.getLigaDer().setLigaIzq(nodo.getLigaIzq());
            return;
        }
        System.out.println("No se puede borrar el nodo cabeza");
    }
}
