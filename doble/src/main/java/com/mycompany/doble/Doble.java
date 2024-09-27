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

    NodoDoble inicio = new NodoDoble();
    Doble() {
        inicio = null;
    }
    
    public void insertarInicio(String dato) {
        
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setDato(dato);
        
        if (inicio != null) {
            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);            
        }
        inicio = nuevo;
    }
    
    public void insertarFinal(String dato) {
        
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setDato(dato);
        
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
    
    public void insertarPorIndice(String dato, int index) {
        
        NodoDoble nuevo = new NodoDoble();
        nuevo.setAnterior(null);
        nuevo.setSiguiente(null);
        nuevo.setDato(dato);
        
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
    
    public void imprimir() {
        NodoDoble temporal = inicio;
        if (inicio == null ) {
            JOptionPane.showMessageDialog(null, "La lista está vacia");
        } else {
            while (temporal != null) {                
                JOptionPane.showMessageDialog(null, "Datos: "+temporal.getDato());
                temporal = temporal.getSiguiente();
            }
        }
        
    }
    
}
