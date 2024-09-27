package com.mycompany.doble;

public class NodoDoble {
    
    public NodoDoble getAnterior() {
        return anterior;
    }
    
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
    
    public String getDato() {
        return dato;
    }
    
    public void setDato(String dato) {
        this.dato = dato;
    }
    
    public NodoDoble getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
    
    private NodoDoble anterior;
    private String dato;
    private NodoDoble siguiente;
    
     
}
