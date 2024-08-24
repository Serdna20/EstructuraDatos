package com.mycompany.restaurante;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Menu {
    String platos[];
    int datos[][];
    
    public void crearMenu(int cantidad) {
        platos = new String[cantidad];
        
        for (int i = 0; i < platos.length; i++) {
            platos[i] = JOptionPane.showInputDialog("Ingrese el nombre del plato #"+(i+1));            
        }
    }
    
    public String obtenerMenu() {
        String menuString = "Menú: \n";
        for (String plato : platos) {
            menuString += "· " + plato + "\n";            
        }
        menuString += "Este menú cuenta con "+platos.length+" plato(s)";
        return menuString;
    }
    
    public void ingresarInfo() {
        datos = new int[6][platos.length];
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado"};
        for (int dia = 0; dia < 6; dia++) {
            for (int plato = 0; plato < platos.length; plato++) {
                datos[dia][plato] = validateIntInput(JOptionPane.showInputDialog("Ingrese las ventas de "+platos[plato]+" en el día "+dias[dia]));                
            }
        }
    }
    
    public String analizarInfo() {
        // Ventas dia posee las ventas de cada día en total
        int[] ventasDia = new int[6];
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado"};
        for (int plato = 0; plato < platos.length; plato++) {
            for (int dia = 0; dia < 6; dia++) {
                System.out.println(datos[dia][plato]);
                ventasDia[dia] += datos[dia][plato];                
            }
        }
        
        // Ventas totales de cada plato
        int[] ventasPlato = new int[platos.length];
        for (int plato = 0; plato < platos.length; plato++) {
            for (int dia = 0; dia < 6; dia++) {
                ventasPlato[plato] += datos[dia][plato];                
            }
            // System.out.println("El plato "+platos[plato]+" tuvo "+ventasPlato[plato]+" ventas esta semana");
        }
        
        // GENERALES
        // Platos vendidos en la semana
        int platosVendidos = sumValues(ventasDia);
        System.out.println("Platos vendidos en la semana: "+platosVendidos);
        
        // Promedio de platos vendidos cada día
        String promedioPlatos = String.format("%.1f", (double) platosVendidos/dias.length);
        System.out.println("Promedio de platos vendidos cada día: "+promedioPlatos);
        
        // Día más vendido
        System.out.println("Día más vendido: "+dias[findMaxIndex(ventasDia)]);
        
        // Día menos vendido
        System.out.println("Día menos vendido: "+dias[findMinIndex(ventasDia)]);
        
        // Plato más vendido
        System.out.println("El plato más vendido fue: "+platos[findMaxIndex(ventasPlato)]+" con "+ventasPlato[findMaxIndex(ventasPlato)]+" ventas esta semana.");
        
        // Plato menos vendido
        System.out.println("El plato menos vendido fue: "+platos[findMinIndex(ventasPlato)]+" con "+ventasPlato[findMinIndex(ventasPlato)]+" ventas esta semana.");
        
        // PARTICULARES
        // Cada plato vendido en la semana
        
        for (int i = 0; i < platos.length; i++) {
            int j = ventasPlato[i];
            
        }
        
        
        
        
        
        return Arrays.toString(ventasDia);
    }
    
    private int findMaxIndex(int[] array) {
        int maxIndex = 0;
        int maxNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxNumber == 0){
                maxNumber = array[i];
                maxIndex = i;
            }
            if (maxNumber < array[i]) {
                maxNumber = array[i];
                maxIndex = i;
            }                
        }
        return maxIndex;
    }
    
    private int findMinIndex(int[] array) {
        int minIndex = 0;
        int minNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (minNumber == 0){
                minNumber = array[i];
                minIndex = i;
            }
            if (minNumber > array[i]) {
                minNumber = array[i];
                minIndex = i;
            }                
        }
        return minIndex;
    }
    
    private int sumValues(int[] array) {
        int total = 0;
        for (int value : array) {
            total += value;
        }
        return total;
    }
    
    private int validateIntInput(String str) {
        while (isNumber(str)==false) {
            str = JOptionPane.showInputDialog("Ingrese un número ENTERO válido (sin espacios):");
        }
        return Integer.parseInt(str);
    }
    
    private static boolean isNumber(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
