package com.mycompany.teatro;

public class Nodossimple {
    
    public String getDocumento() {
        return documento;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public int getNboletas() {
        return nboletas;
    }
    
    public void setNboletas(int nboletas) {
        this.nboletas = nboletas;
    }
    
    public Nodossimple getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Nodossimple siguiente) {
        this.siguiente = siguiente;
    }    
    
    private String documento;    
    private String nombre;    
    private String genero;    
    private int nboletas;
    
    private Nodossimple siguiente;
    
    
}
