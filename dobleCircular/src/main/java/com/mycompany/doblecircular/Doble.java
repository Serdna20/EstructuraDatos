/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.doblecircular;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-22
 */
public class Doble {

    NodoDoble inicio = new NodoDoble();
    Doble() {
        inicio = null;
    }
    
    public void insertarInicio(String dato, int edad) {
        
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(nuevo);
        nuevo.setSiguiente(nuevo);
        nuevo.setNombre(dato);
        nuevo.setEdad(edad);
        
        if (inicio == null) {
            inicio = nuevo;
        }
        else {
            NodoDoble last = inicio.getAnterior();
            inicio.setAnterior(nuevo);
            nuevo.setSiguiente(inicio);
            last.setSiguiente(nuevo);
            nuevo.setAnterior(last);            
            inicio=nuevo;
        }
        
    }
    
    public void insertarFinal(String dato, int edad) {
        
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(nuevo);
        nuevo.setSiguiente(nuevo);
        nuevo.setNombre(dato);
        nuevo.setEdad(edad);
        
        if (inicio == null) {
            inicio = nuevo;
            inicio.setAnterior(nuevo);
            inicio.setSiguiente(nuevo);          
        } else {
            NodoDoble last = inicio.getAnterior();
            last.setSiguiente(nuevo);
            nuevo.setAnterior(last);
            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);
        }        
    }
    
    public void insertarPorIndice(String dato, int edad, int index) {
        
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setNombre(dato);
        nuevo.setEdad(edad);
        
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
    
    public void insertarDespuesIndice(String dato, int edad, int index) {        
        insertarPorIndice(dato, edad, index+1);
    }
    
    public void eliminarIndice(int index) {
    
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
            return;
        }
        
        if (index < 0 || index > getLongitud()) {
            JOptionPane.showMessageDialog(null, "Fuera de los bordes");
            return;
        }
        
        NodoDoble anterior, siguiente;
        
        if (index == 1) {
            anterior = inicio.getAnterior();
            siguiente = inicio.getSiguiente();
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
            return;
        }
        
        if (index == getLongitud()) {
            anterior = inicio.getAnterior().getAnterior();
            siguiente = inicio;
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
            return;
        }
        
        int posicion = 1;
        NodoDoble temporal = inicio;      
        do {
            temporal = temporal.getSiguiente();
            posicion++;
        }
        while (posicion != index);
        
        anterior = temporal.getAnterior();
        siguiente = temporal.getSiguiente();        
        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);
    }
    
    public void buscarNodo(String dato) {
        boolean encontrado = false;
        
        int posicion = 1;
        NodoDoble temporal = inicio;      
        do {
            if (temporal.getNombre().equals(dato)) {
                encontrado = true;
                break;
            }
            temporal = temporal.getSiguiente();            
            posicion++;
        }
        while (temporal != inicio);
        
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Nodo encontrado en la posición "+posicion);
        }
        else {
            JOptionPane.showMessageDialog(null, "Nodo no encontrado");
        }
    }
    
    public void actualizarNodo(String dato, int edad, int index) {
        
        int posicion = 1;
        NodoDoble temporal = inicio;      
        do {
            temporal = temporal.getSiguiente();
            posicion++;
        }
        while (posicion != index);
        
        temporal.setEdad(edad);
        temporal.setNombre(dato);
        
        // insertarPorIndice(dato, edad, index);
        // eliminarIndice(index+1);
    }
    
    public void imprimir() {
        NodoDoble temporal = inicio;
        if (inicio == null ) {
            JOptionPane.showMessageDialog(null, "La lista está vacia");
        } else {
            do {
                JOptionPane.showMessageDialog(null, "Datos: Nombre: "+temporal.getNombre()
                +" Edad: "+temporal.getEdad());
                temporal = temporal.getSiguiente();
            }
            while (temporal != inicio);
        }        
    }
    
    public int getLongitud() {
        int longitud = 0;
        NodoDoble temporal = inicio;        
        do {
            temporal = temporal.getSiguiente();
            longitud++;
        }
        while (temporal != inicio);
        return longitud;
    }
    
    public int getMenoresCantidad() {
        int longitud = 0;
        NodoDoble temporal = inicio;
        do {
            if (temporal.getEdad() >= 18) {
                longitud++;
            }
            temporal = temporal.getSiguiente();  
        }
        while (temporal != inicio);
        return longitud;
    }
    
    public void delanteAtrás(int index) {
        
        if (index < 0 || index > getLongitud()) {
            JOptionPane.showMessageDialog(null, "Index fuera de los límites");
            return;
        }
        
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
            
            do {
                boolean esMayor = temporal.getEdad() >= 18;                
                if (esMayor) {
                    arrayDoble[index] = temporal;
                    index++;
                }                
                temporal = temporal.getSiguiente();
            }
            while (temporal != inicio);
            
            inicio = arrayDoble[0];
            
            for (int i = 0; i < arrayDoble.length-1; i++) {
                arrayDoble[i].setSiguiente(arrayDoble[i+1]);
                arrayDoble[i+1].setAnterior(arrayDoble[i]);                
            }
            arrayDoble[arrayDoble.length-1].setSiguiente(inicio);
            inicio.setAnterior(arrayDoble[arrayDoble.length-1]);
        }     
    }
    
    public void imprimirMayores() {
        NodoDoble temporal = inicio;
        int index = 1;
        if (inicio == null ) {
            JOptionPane.showMessageDialog(null, "La lista está vacia");
        } else {
            do {
                boolean esMayor = temporal.getEdad() >= 18;                
                if (esMayor) {
                    JOptionPane.showMessageDialog(null, "Posicion: "+index+" - Datos: Nombre: "+temporal.getNombre()
                    +" Edad: "+temporal.getEdad());                    
                }
                index++;
                temporal = temporal.getSiguiente();
            } while (temporal != inicio);
        }        
    }
}
