package com.mycompany.teatro;

import javax.swing.JOptionPane;

public class Teatro {
    
    Nodoscirculares inicio;
    Nodossimple registroInicio;
    
    Teatro(){
    inicio=null;
    registroInicio=null;
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
    
    public void removerTurno() {
        
        if (inicio.getSiguiente() == inicio) {
            inicio = null;
            return;
        }
        
        Nodoscirculares nodoFinal;
        Nodoscirculares despuesInicio;
        Nodoscirculares temporal = inicio;
        while (temporal.getSiguiente() != inicio) {
            temporal = temporal.getSiguiente();
        }            
        nodoFinal = temporal;     
        despuesInicio = inicio.getSiguiente();
        nodoFinal.setSiguiente(despuesInicio);
        inicio = despuesInicio;
    }
    
    public void imprimir(){
        Nodoscirculares temporal=inicio;
        
        if (inicio==null){    
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
        else {
            do{       
                JOptionPane.showMessageDialog(null, "Documento "+
                temporal.getDocumento()+" Nombre " + temporal.getNombre() +" Genero "+ temporal.getGenero()
                );
                temporal=temporal.getSiguiente();       
            } while (temporal!=inicio);
        } 
    }   
    
    
    public String atender(int nboletas){
        
        String fallo = "";
        // Si hay boletas vendemos
        if (nboletas>0) {            
            // Atendemos a cada cliente en orden de llegada
            Nodoscirculares temporal=inicio;   
            do {
                int cantidad = 0;                
                // Validamos la cantidad de boletas
                do {
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog(
                    temporal.getNombre()+ ", Diga el numero de boletas a comprar (debe ser menor a 3 y "+nboletas+")")
                    );
                } while (cantidad > 3 || cantidad > nboletas); 
                
                // Vendimos boletas y removemos de la lista                
                nboletas = nboletas - cantidad;                
                Nodossimple nuevo = new Nodossimple();
                nuevo.setDocumento(temporal.getDocumento());
                nuevo.setNombre(temporal.getNombre());
                nuevo.setGenero(temporal.getGenero());
                nuevo.setNboletas(cantidad);
                nuevo.setSiguiente(null);
                     
                temporal=temporal.getSiguiente();
                removerTurno();
                
                
                if (registroInicio == null) {                                      
                    registroInicio = nuevo;
                }
                else {
                    Nodossimple ultimo = registroInicio;
                    while(ultimo.getSiguiente()!=null) {
                        ultimo = ultimo.getSiguiente();
                    }
                    ultimo.setSiguiente(nuevo);
                }
                
                // Si ya no hay boletas o no hay clientes rompemos el ciclo
                
                if (nboletas == 0 || inicio == null) {
                    fallo = "Atendidos todos";
                    break;
                }
                else if (nboletas == 0) {
                    fallo = "Se acabaron las boletas";
                    break;
                }
                
                
            } while (true);
        }
        return fallo;
    }
    
    public void consultarVendidas(){
        Nodossimple temporal=registroInicio;
        
        int cantidadHombre = 0;
        int cantidadMujer = 0;
        
        if (registroInicio==null){    
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
        else {
            do{       
                JOptionPane.showMessageDialog(null,
                "Documento: "+temporal.getDocumento()+"\n"+
                "Nombre: " + temporal.getNombre()+"\n"+
                "Genero: "+ temporal.getGenero()+"\n"+
                "Boletas compradas: "+temporal.getNboletas());
                
                if (temporal.getGenero().equals("hombre")) {
                    cantidadHombre = cantidadHombre + temporal.getNboletas();
                } else {
                    cantidadMujer = cantidadMujer + temporal.getNboletas();
                }
                
                temporal=temporal.getSiguiente();       
            } while (temporal!=null);
            
            int cantidadTotal = cantidadHombre + cantidadMujer;   
            
            JOptionPane.showMessageDialog(null,
                    "Se vendieron "+cantidadTotal+" boletas en total."+"\n"+
                    "Los hombres compraron "+cantidadHombre+" boletas. ("+returnPercentage(cantidadTotal, cantidadHombre)+")"+"\n"+
                    "Las mujeres compraron "+cantidadMujer+" boletas. ("+returnPercentage(cantidadTotal, cantidadMujer)+")");
            
        } 
    }
    
    public void consultarDocumento(String documento) {
        
        Nodossimple temporal=registroInicio;
        boolean encontrado = false;
        do{       
            if (temporal.getDocumento().equals(documento)) {
                encontrado = true;
                JOptionPane.showMessageDialog(null,
                "El documento "+documento+" ha comprado "+temporal.getNboletas()+" boletas.");
                break;
            }
            temporal=temporal.getSiguiente();
        } while (temporal!=null);
        if (!encontrado) {
            JOptionPane.showMessageDialog(null,
            "El documento "+documento+" no ha comprado boletas.");
        }
    }
    
    public String returnPercentage(int total, int porcion) {
        return String.format("%.1f", (double) porcion*100/total)+"%";
    } 
    
}
