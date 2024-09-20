package com.mycompany.teatro;

import javax.swing.JOptionPane;

public class Teatro {
    
    Nodoscirculares inicio;
    Nodossimple registroInicio;
    
    Teatro(){
    inicio=null;    
    }

   
    
    public void solicitarTurno( String nombre, String documento, String genero ){        
        Nodoscirculares nuevo = new Nodoscirculares();
        nuevo.setDocumento(documento);
        nuevo.setNombre(nombre);
        nuevo.setGenero(genero);
        
        if (inicio==null) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");   
            nuevo.setSiguiente(nuevo);
            inicio=nuevo;        
        } else {
            Nodoscirculares nodoFinal;
            
            // El nodo final debe apuntar al nuevo nodo, sin el
            // La lista no funcionaría
            Nodoscirculares temporal = inicio;
            while (temporal.getSiguiente() != inicio) {
                temporal = temporal.getSiguiente();
            }
            
            nodoFinal = temporal;
            nuevo.setSiguiente(inicio);          
            nodoFinal.setSiguiente(nuevo);
        }
        
    }
    
    public void imprimir(){        
        
        Nodoscirculares temporal=inicio;
        
        if(inicio==null){    
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
        else{
            do{       
                JOptionPane.showMessageDialog(null, "Documento "+
                temporal.getDocumento()+" Nombre " + temporal.getNombre() +" Genero "+ temporal.getGenero()
                );
                temporal=temporal.getSiguiente();       
            } while (temporal!=inicio);
        } 
    }   
    
    
    public void atender(int nboletas){
        
           
        
        
        
     
    
    
    }
    
    
        
    
    
    
}
