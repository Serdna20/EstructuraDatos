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
        int[] ventasDia = new int[6];
        datos = new int[6][platos.length];
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado"};
        for (int plato = 0; plato < platos.length; plato++) {
            for (int dia = 0; dia < 6; dia++) {
                ventasDia[dia] += datos[dia][plato];                
            }
        }
        System.out.println("Día más vendido: " );
        return Arrays.toString(ventasDia);
    }
    
    private int findMaxIndex(int[] array) {
        int maxIndex = 0
        for (int i = 0; i < platos.length; i++) {
            String plato = platos[i];
            
        }
        return maxIndex;
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
