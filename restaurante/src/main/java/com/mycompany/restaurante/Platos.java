/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante;

/**
 *
 * @author SCIS2-22
 */
public class Platos {

    private int precio;
    private int costo;
    private String nombre;
    private int ganancia;

    public Platos(String nombre, int precio, int costo) {
        this.nombre = nombre;
        
        if (costo > precio) {
            this.precio = costo;
            this.costo = precio;
        }
        else {
            this.precio = precio;
            this.costo = costo;
        }        
        this.ganancia = this.precio-this.costo;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGanancia() {
        return ganancia;
    }
}
