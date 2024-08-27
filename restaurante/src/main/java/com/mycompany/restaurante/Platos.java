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
    private String nombre;

    public Platos(String nombre, int precio) {
        this.precio = precio;
        this.nombre = nombre;
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
    
}
