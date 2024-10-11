package com.mycompany.doblecircular;

public class NodoDoble {
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public NodoDoble getAnterior() {
        return anterior;
    }
    
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public NodoDoble getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
    
    private NodoDoble anterior;
    private String nombre;
    private int edad;
    private NodoDoble siguiente;
    
     
}
