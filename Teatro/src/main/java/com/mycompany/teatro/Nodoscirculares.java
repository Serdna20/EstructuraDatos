
package com.mycompany.teatro;

public class Nodoscirculares {
    
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
    
    public Nodoscirculares getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Nodoscirculares siguiente) {
        this.siguiente = siguiente;
    }
    
    private String documento;    
    private String nombre;    
    private String genero;
    private Nodoscirculares siguiente;    
    
}
