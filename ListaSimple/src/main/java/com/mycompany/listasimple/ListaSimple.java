/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listasimple;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-22
 */
public class ListaSimple {
    
    Nodo inicio;
    ListaSimple() {
        inicio = null;
    }
    
    public void insertarInicio(String nombre, int age, float averageGrade) {
        Nodo nuevo = new Nodo();
        nuevo.setName(nombre);
        nuevo.setAge(age);
        nuevo.setAverageGrade(averageGrade);
        nuevo.setEnlace(null);
        
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
            inicio = nuevo;
        }
        else {
            nuevo.setEnlace(inicio);
            inicio = nuevo;
        }
    }
    
    public void insertarFinal(String nombre, int age, float averageGrade) {
        Nodo nuevo = new Nodo();
        nuevo.setName(nombre);
        nuevo.setAge(age);
        nuevo.setAverageGrade(averageGrade);
        nuevo.setEnlace(null);
        
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
            inicio = nuevo;
        }
        else {
            
            Nodo temporal = inicio;
            while(temporal.getEnlace()!=null) {
                temporal = temporal.getEnlace();
            }
            temporal.setEnlace(nuevo);
        }
    }
    
    public void insertarEnIndice(String nombre, int age, float averageGrade, int indice) {
        Nodo nuevo = new Nodo();
        nuevo.setName(nombre);
        nuevo.setAge(age);
        nuevo.setAverageGrade(averageGrade);
        nuevo.setEnlace(null);
        boolean indiceEncontrado = false;
        int posicion = 1;        
        Nodo anterior = inicio;
        Nodo siguiente = null;
        // Cambia de posición iniciando en la 1
        if (indice <= 0) {
            JOptionPane.showMessageDialog(null, "El indice debe ser un númeo mayor a cero.");
        }
        else {
            while(anterior!=null) {
                if (posicion==indice) {
                    siguiente = anterior.getEnlace();
                    indiceEncontrado = true;
                    break;
                }
                anterior = anterior.getEnlace();
                posicion++;
            }
            if (indiceEncontrado) {
                anterior.setEnlace(nuevo);
                nuevo.setEnlace(siguiente);
            }
            else {
                JOptionPane.showMessageDialog(null, "No se encontró el indice ingresado.");
            }
        }
                
        
    }
    
    public void insertarEnNombre(String nombre, int age, float averageGrade, String referencia) {
        Nodo nuevo = new Nodo();
        nuevo.setName(nombre);
        nuevo.setAge(age);
        nuevo.setAverageGrade(averageGrade);
        nuevo.setEnlace(null);
        boolean nombreEncontrado = false;
        Nodo anterior = inicio;
        Nodo siguiente = null;
        // Recorre el nodo
        while(anterior.getEnlace()!=null) {
            if (anterior.getName().equals(referencia)) {
                siguiente = anterior.getEnlace();
                nombreEncontrado = true;
                break;
            }
            anterior = anterior.getEnlace();
        }
        
        if (nombreEncontrado) {
            anterior.setEnlace(nuevo);
            nuevo.setEnlace(siguiente);
        }
        else {
            JOptionPane.showMessageDialog(null, "No se encontró el nombre ingresado.");
        }
        
    }
    
    public void insertarEnEdad(String nombre, int age, float averageGrade, int referencia) {
        Nodo nuevo = new Nodo();
        nuevo.setName(nombre);
        nuevo.setAge(age);
        nuevo.setAverageGrade(averageGrade);
        nuevo.setEnlace(null);
        boolean edadEncontrada = false;
        Nodo anterior = inicio;
        Nodo siguiente = null;
        // Recorre el nodo
        while(anterior.getEnlace()!=null) {
            if (anterior.getAge() == referencia) {
                siguiente = anterior.getEnlace();
                edadEncontrada = true;
                break;
            }
            anterior = anterior.getEnlace();
        }
        
        if (edadEncontrada) {
            anterior.setEnlace(nuevo);
            nuevo.setEnlace(siguiente);
        }
        else {
            JOptionPane.showMessageDialog(null, "No se encontró la edad ingresada.");
        }
        
    }
    
    public void insertarEnPromedio(String nombre, int age, float averageGrade, float referencia) {
        Nodo nuevo = new Nodo();
        nuevo.setName(nombre);
        nuevo.setAge(age);
        nuevo.setAverageGrade(averageGrade);
        nuevo.setEnlace(null);
        boolean promedioEncontrado = false;
        Nodo anterior = inicio;
        Nodo siguiente = null;
        // Recorre el nodo
        while(anterior.getEnlace()!=null) {
            if (anterior.getAge() == referencia) {
                siguiente = anterior.getEnlace();
                promedioEncontrado = true;
                break;
            }
            anterior = anterior.getEnlace();
        }
        
        if (promedioEncontrado) {
            anterior.setEnlace(nuevo);
            nuevo.setEnlace(siguiente);
        }
        else {
            JOptionPane.showMessageDialog(null, "No se encontró el promedio ingresado.");
        }
        
    }
    
    public void consultar() {
    
        // Ubicarme al nodo inicial para recorrer la lista
        Nodo temporal = inicio;
        
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
        }
        else {        
            do {
            JOptionPane.showMessageDialog(null, " Nombre: "+temporal.getName()+" Edad: "+temporal.getAge()+" Promedio: "+temporal.getAverageGrade());
            temporal = temporal.getEnlace();
            } while (temporal!=null);
        }
    
    }
}
