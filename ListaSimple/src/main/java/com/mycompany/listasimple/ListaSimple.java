/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listasimple;

import java.util.Arrays;
import java.util.Random;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-22
 */
public class ListaSimple {
    
    Nodo inicio;
    int longitud;
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
    
    public void insertarAntesDeIndice(String nombre, int age, float averageGrade, int indice) {
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
        else if (indice == 1) {
            insertarInicio(nombre, age, averageGrade);
        }
        else {
            while(anterior!=null) {
                if (posicion+1==indice) {
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
    
    public void eliminarIndice(int indice) {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacia");
            return;
        } 
        
        int posicion = 1;
        boolean indiceEncontrado = false;
        
        Nodo anterior = inicio;        
        Nodo siguiente = null;
        
        if (indice == 1) {
            inicio = inicio.getEnlace();
            return;
        }
        
        while(anterior!=null) {
            if (posicion+1==indice) {
                siguiente = anterior.getEnlace().getEnlace();
                indiceEncontrado = true;
                break;
            }
            anterior = anterior.getEnlace();
            posicion++;
        }
        if (indiceEncontrado) {
            anterior.setEnlace(siguiente);
        }
        else {
            JOptionPane.showMessageDialog(null, "No se encontró el indice ingresado.");
        }        
    }
    
    public void eliminarPorNombre(String referencia) {
        int posicion = 1;
        Nodo anterior = inicio;
        Nodo siguiente = null;
        
        while (anterior!=null) {
            
            if (siguiente == null && posicion == 1 && anterior.getName().equals(referencia)) {
                Nodo enlaceTemporal = anterior.getEnlace();
                while(enlaceTemporal.getName().equals(referencia)) {
                    enlaceTemporal = enlaceTemporal.getEnlace();
                }
                inicio = enlaceTemporal;
            }
            
            if (siguiente != null && siguiente.getName().equals(referencia)) {
                Nodo enlaceTemporal = anterior.getEnlace();
                while(enlaceTemporal!=null && enlaceTemporal.getName().equals(referencia)) {
                    enlaceTemporal = enlaceTemporal.getEnlace();
                }
                anterior.setEnlace(enlaceTemporal);
            }
            
        
            anterior = anterior.getEnlace();
            if (anterior==null) {
                // Llegué al final de la lista
                break;
            }
            siguiente = anterior.getEnlace();
            posicion++;
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
        while(anterior!=null) {
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
        while(anterior!=null) {
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
        while(anterior!=null) {
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
    
    public void ordenarEnOrden() {
        long startTime = new Date().getTime();
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista està vacia");
            return;
        }
        
        // Recorrer los nodos        
        Nodo inicial = inicio;
        int cantidadNodos = getLongitud();
        int posicion = 0;
        String[] arrayNombres = new String[cantidadNodos];
        while(inicial!=null) {
            arrayNombres[posicion] = inicial.getName();
            inicial = inicial.getEnlace();
            posicion++;
        }
        
        // Tengo los nodos ordenados
        Arrays.sort(arrayNombres);
        //JOptionPane.showMessageDialog(null, Arrays.toString(arrayNombres));
        
        // Algoritmo de busqueda
        // if inicio = arrayNombres[0]
        
        
        //Encontrar el primer nodo según el nombre
        String nombreInicio = arrayNombres[0];
        Nodo nuevoInicio = null;
        inicial = inicio;
        posicion = 1;
        while(inicial!=null) {
            if (inicial.getName().equals(nombreInicio)) {
                nuevoInicio = inicial;
                eliminarIndice(posicion);
                break;
            }
            inicial = inicial.getEnlace();
            posicion++;
        }        
        
        // Cicla cantidad de nodos veces - 1
        for (int i = 1; i < cantidadNodos; i++) {
            inicial = inicio;
            // Cicla hasta encontrar el nodo
            posicion = 1;
            while(inicial!=null) {
                if (inicial.getName().equals(arrayNombres[i])) {
                    Nodo temporal = nuevoInicio;
                    // Llega a la posición necesaria para establecer el enlace
                    for (int j = 1; j < i; j++) {
                        temporal = temporal.getEnlace();                        
                    }
                    temporal.setEnlace(inicial);
                    // Elimina al nodo de la lista original para
                    // no confundir nombres repetidos
                    eliminarIndice(posicion);
                    break;
                }
                posicion++;
                inicial = inicial.getEnlace();
            }
        }        
        inicio = nuevoInicio;
        long finishTime = new Date().getTime();
        JOptionPane.showMessageDialog(null, "Esta acción tardó "+ (finishTime-startTime) +" milisegundos en realizarse");
    }
    
    public void ordenarEnOrden2() {
    }
    
    //SACADO DE INTERNET
    
    public int stringCompare(String str1, String str2) { 
        for (int i = 0; i < str1.length() && i < str2.length(); i++) { 
            if ((int)str1.charAt(i) == (int)str2.charAt(i)) { 
                continue; 
            } 
            else { 
                return (int)str1.charAt(i) - (int)str2.charAt(i); 
            } 
        }
        
        if (str1.length() < str2.length()) { 
            return (str1.length()-str2.length()); 
        } 
        else if (str1.length() > str2.length()) { 
            return (str1.length()-str2.length()); 
        } 
        
        else { 
            return 0; 
        } 
    }
    
    public boolean returnAction(int indicador) {
        if (indicador<=0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public void swapNodes(Nodo nodo1, Nodo nodo2) {
        Nodo nodoTemp1 = nodo1;
        Nodo nodoTemp2 = nodo2;
    }
    
    //LOL
    
    public int getLongitud() {
        Nodo temporal = inicio;
        int cantidad = 0;
        if (inicio != null) {        
            do {
            cantidad++;
            temporal = temporal.getEnlace();
            } while (temporal!=null);
        }
        return cantidad;
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
        
        JOptionPane.showMessageDialog(null, "Hay "+getLongitud()+" nodo(s) en la lista.");
    
    }
    
    public void llenarAlAzar(int cantidad) {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < cantidad; i++) {
            String nombre = "";
            int longitud = random.nextInt(4)+2;
            for (int j = 0; j < longitud; j++) {
                nombre += alphabet.charAt(random.nextInt(alphabet.length()));
            }
            int age = random.nextInt(20)+1;
            float averageGrade = random.nextFloat(4)+1;
            insertarInicio(nombre, age, averageGrade);
        }
    }
}
