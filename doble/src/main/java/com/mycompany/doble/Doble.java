/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.doble;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-22
 */
public class Doble {
    
    // IMPRIMIR MAYORES DE EDAD

    NodoDoble inicio = new NodoDoble();
    Doble() {
        inicio = null;
    }
    
    public void insertarInicio(String dato, int edad) {
        
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setNombre(dato);
        nuevo.setEdad(edad);
        
        if (inicio != null) {
            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);            
        }
        inicio = nuevo;
    }
    
    public void insertarFinal(String dato, int edad) {
        
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setNombre(dato);
        nuevo.setEdad(edad);
        
        if (inicio == null) {
            inicio = nuevo;           
        } else {
            NodoDoble ultimo = inicio;
            while (ultimo.getSiguiente() != null) {
                ultimo = ultimo.getSiguiente();
            }
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
        }        
    }
    
    // Insertar por indice adelante y atras, eliminar por dato, buscar, actualizar nodo
    
    public void insertarPorIndice(String dato, int edad, int index) {
        
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setNombre(dato);
        
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
            return;
        }
        
        if (index < 0 || index > getLongitud()) {
            JOptionPane.showMessageDialog(null, "Fuera de los bordes");
            return;
        }
        
        // Validamos que la index sea posible
        
        if (index == 1) {
            insertarInicio(dato, edad);
            return;
        }
        
        if (index == getLongitud()) {
            insertarFinal(dato, edad);
            return;
        }
        
        NodoDoble anterior;
        NodoDoble siguiente;
        
        int posicion = 1;
        NodoDoble temporal = inicio;
        while (temporal != null && posicion != index) {
                temporal = temporal.getSiguiente();
                posicion++;
        }
        JOptionPane.showMessageDialog(null, "Datos: "+temporal.getNombre());
        anterior = temporal.getAnterior();
        siguiente = temporal;
        
        if (anterior != null) {
            anterior.setSiguiente(nuevo);
        }
        
        if (siguiente != null) {
            siguiente.setAnterior(nuevo);
        }
        
        nuevo.setSiguiente(siguiente);
        nuevo.setAnterior(anterior);
           
    }
    
    public void imprimir() {
        NodoDoble temporal = inicio;
        if (inicio == null ) {
            JOptionPane.showMessageDialog(null, "La lista está vacia");
        } else {
            while (temporal != null) {                
                JOptionPane.showMessageDialog(null, "Datos: Nombre: "+temporal.getNombre()
                +" Edad: "+temporal.getEdad());
                temporal = temporal.getSiguiente();
            }
        }        
    }
    
    public int getLongitud() {
        int longitud = 0;
        NodoDoble temporal = inicio;
        while (temporal != null) {
                temporal = temporal.getSiguiente();
                longitud++;
        }
        return longitud;
    }
    
    public int getMenoresCantidad() {
        int longitud = 0;
        NodoDoble temporal = inicio;
        while (temporal != null) {
            if (temporal.getEdad() >= 18) {
                longitud++;
            }
            temporal = temporal.getSiguiente();                
        }
        return longitud;
    }
    
    public void delanteAtrás(int index) {
        
        int posicion = 1;
        NodoDoble temporal = inicio;
        while (temporal != null && posicion != index) {
                temporal = temporal.getSiguiente();
                posicion++;
        }
        
        String nombreAnterior = "nulo / nadie";
        String nombreAdelante = "nulo / nadie";
        
        if (temporal != null) {
            if (temporal.getAnterior() == null) {
                nombreAnterior = "nulo / nadie";
            } else {
                nombreAnterior = temporal.getAnterior().getNombre();
            }

            if (temporal.getSiguiente() == null) {
                nombreAdelante = "nulo / nadie";
            } else {
                nombreAdelante = temporal.getSiguiente().getNombre();
            }
        }
        
        JOptionPane.showMessageDialog(null, "Por detrás: "+nombreAnterior);
        JOptionPane.showMessageDialog(null, "Por delante: "+nombreAdelante);
        // JOptionPane.showMessageDialog(null, getLongitud());
    }
    
    public void removerMenores() {        
        if (inicio == null ) {
            JOptionPane.showMessageDialog(null, "La lista está vacia");
        } else {
            
            // Nueva variable inicio
            
            NodoDoble[] arrayDoble = new NodoDoble[getMenoresCantidad()];
            int index = 0;
            NodoDoble temporal = inicio;
            while (temporal != null) {
                boolean esMayor = temporal.getEdad() >= 18;                
                if (esMayor) {
                    arrayDoble[index] = temporal;
                    index++;
                }                
                temporal = temporal.getSiguiente();
            }
            
            arrayDoble[0].setAnterior(null);
            inicio = arrayDoble[0];
            
            for (int i = 0; i < arrayDoble.length-1; i++) {
                arrayDoble[i].setSiguiente(arrayDoble[i+1]);
                arrayDoble[i+1].setAnterior(arrayDoble[i]);
                arrayDoble[i+1].setSiguiente(null);
            }
            
            
            
        }     
    }
}
