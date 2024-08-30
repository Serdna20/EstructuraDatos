package com.mycompany.restaurante;

import javax.swing.JOptionPane;

public class Menu {
    Platos platos[];
    int datos[][];
    
    public void crearMenu(int cantidad) {
        platos = new Platos[cantidad];
        
        for (int i = 0; i < platos.length; i++) {
            platos[i] = new Platos(JOptionPane.showInputDialog("Ingrese el nombre del plato #"+(i+1)),
                    validateIntInput(JOptionPane.showInputDialog("Ingrese el precio de venta del plato:")),
                     validateIntInput(JOptionPane.showInputDialog("Ingrese el costo de producción del plato:")));
        }
    }
    
    public String obtenerMenu() {
        String menuString = "Menú: \n";
        for (Platos plato : platos) {
            menuString += "· " + plato.getNombre() + " - $"+plato.getPrecio()+"\n";            
        }
        menuString += "Este menú cuenta con "+platos.length+" plato(s)";
        return menuString;
    }
    
    public void ingresarInfo() {
        datos = new int[6][platos.length];
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado"};
        for (int dia = 0; dia < 6; dia++) {
            for (int plato = 0; plato < platos.length; plato++) {
                datos[dia][plato] = validateIntInput(JOptionPane.showInputDialog("Ingrese las ventas de "+platos[plato].getNombre()+" en el día "+dias[dia]));                
            }
        }
    }
    
    public String analizarInfo() {
        // Ventas dia posee las ventas de cada día en total
        int gananciaTotal = 0;
        String returnString = "";
        int[] ventasDia = new int[6];
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado"};
        for (int plato = 0; plato < platos.length; plato++) {
            for (int dia = 0; dia < 6; dia++) {
                // System.out.println(datos[dia][plato]);
                ventasDia[dia] += datos[dia][plato];
                gananciaTotal += datos[dia][plato]*platos[plato].getGanancia();
            }
        }
        
        // Ventas totales de cada plato
        int[] gananciasPlato = new int[platos.length];
        int[] ventasPlato = new int[platos.length];
        for (int plato = 0; plato < platos.length; plato++) {
            for (int dia = 0; dia < 6; dia++) {
                gananciasPlato[plato] += (int) datos[dia][plato] * platos[plato].getGanancia();
                ventasPlato[plato] += datos[dia][plato];                
            }
            // System.out.println("El plato "+platos[plato]+" tuvo "+ventasPlato[plato]+" ventas esta semana");
        }
        
        // GENERALES
        // Platos vendidos en la semana
        int platosVendidos = sumValues(ventasDia);
        returnString += "-- Información General --\n";
        returnString += "· Platos vendidos en la semana: "+platosVendidos+"\n";        
        returnString += "· Ganancia total: $"+gananciaTotal+"\n";
        returnString += "· Plato con más ganancia: "+platos[findMaxIndex(gananciasPlato)].getNombre()+" con ganancia de $"+gananciasPlato[findMaxIndex(gananciasPlato)]+"\n";
        
        // Promedio de platos vendidos cada día
        String promedioPlatos = String.format("%.1f", (double) platosVendidos/dias.length);
        returnString += "· Promedio de platos vendidos cada día: "+promedioPlatos+"\n";
        
        // Día más vendido
        returnString += "· Día más vendido: "+dias[findMaxIndex(ventasDia)]+" con "+ventasDia[findMaxIndex(ventasDia)]+" ventas\n";
        String porcentajeDia = String.format("%.1f", (double) ventasDia[findMaxIndex(ventasDia)]*100/platosVendidos);
        returnString += "· El día más vendido representa un "+porcentajeDia+"% de las ventas"+"\n";
        // Día menos vendido
        returnString += "· Día menos vendido: "+dias[findMinIndex(ventasDia)]+" con "+ventasDia[findMinIndex(ventasDia)]+" ventas\n";
        
        // Plato más vendido
        returnString += "· El plato más vendido fue: "+platos[findMaxIndex(ventasPlato)].getNombre()+" con "+ventasPlato[findMaxIndex(ventasPlato)]+" ventas esta semana"+"\n";
        
        // Plato menos vendido
        returnString += "· El plato menos vendido fue: "+platos[findMinIndex(ventasPlato)].getNombre()+" con "+ventasPlato[findMinIndex(ventasPlato)]+" ventas esta semana"+"\n\n";
        
        // PARTICULARES
        // Cada plato vendido en la semana
        
        returnString += "-- Información particular --\n\n";
        
        for (int i = 0; i < platos.length; i++) {
            returnString += "· El plato "+platos[i].getNombre()+" tuvo "+ventasPlato[i]+" ventas esta semana\n";
            int[] ventasDiarias = new int[dias.length];
            for (int dia = 0; dia < dias.length; dia++) {
                ventasDiarias[dia] = datos[dia][i];                
            }
            returnString += "· El día que más se vendió el plato "+platos[i].getNombre()+" fue el "+dias[ findMaxIndex(ventasDiarias)]+"\n";
            returnString += "· El día que menos se vendió el plato "+platos[i].getNombre()+" fue el "+dias[ findMinIndex(ventasDiarias)]+"\n";
            String porcentaje = String.format("%.1f", (double) ventasPlato[i]*100/platosVendidos);
            String porcentajeGanancias = String.format("%.1f", (double) gananciasPlato[i]*100/gananciaTotal);
            returnString += "· Las ganancias obtenidas por el plato "+platos[i].getNombre()+" fueron de $"+gananciasPlato[i]+"\n";
            returnString += "· El porcentaje de ganancias que representa el plato "+platos[i].getNombre()+" fue del "+porcentajeGanancias+"%\n";
            returnString += "· El porcentaje de ventas que representa el plato "+platos[i].getNombre()+" es del "+porcentaje+"%"+"\n\n";
        }
        
        return returnString;
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
