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
    
    public void consultar() {
    
        // Ubicarme al nodo inicial para recorrer la lista
        Nodo temporal = inicio;
        
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
        }
        else {        
            do {
            JOptionPane.showMessageDialog(null, " Nombre: "+temporal.getName()+" Edad: "+temporal.getAge()+" Promedio: "+temporal.getAverageGrade());
            } while (temporal.getEnlace()!=null);
        }
    
    }
}
