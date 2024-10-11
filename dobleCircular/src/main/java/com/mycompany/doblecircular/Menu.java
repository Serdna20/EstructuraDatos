/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.doblecircular;

import com.mycompany.doblecircular.Doble;
import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-22
 */
public class Menu extends javax.swing.JFrame {

    Doble listaDoble = new Doble();
    
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        printValues = new javax.swing.JButton();
        insertStart = new javax.swing.JButton();
        insertFinal = new javax.swing.JButton();
        beforeAfterButton = new javax.swing.JButton();
        insertBeforeIndex = new javax.swing.JButton();
        removeMinors = new javax.swing.JButton();
        printAdults = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        printValues.setText("Imprimir");
        printValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printValuesActionPerformed(evt);
            }
        });

        insertStart.setText("Insertar al inicio");
        insertStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertStartActionPerformed(evt);
            }
        });

        insertFinal.setText("Insertar al final");
        insertFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertFinalActionPerformed(evt);
            }
        });

        beforeAfterButton.setText("Atrás/Adelante");
        beforeAfterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beforeAfterButtonActionPerformed(evt);
            }
        });

        insertBeforeIndex.setText("Insertar en indice");
        insertBeforeIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBeforeIndexActionPerformed(evt);
            }
        });

        removeMinors.setText("Remover menores");
        removeMinors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMinorsActionPerformed(evt);
            }
        });

        printAdults.setText("Imprimir mayores");
        printAdults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printAdultsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(insertBeforeIndex))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(beforeAfterButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(insertStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(insertFinal)))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printValues)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(printAdults)
                    .addComponent(removeMinors))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertStart)
                    .addComponent(insertFinal))
                .addGap(26, 26, 26)
                .addComponent(insertBeforeIndex)
                .addGap(18, 18, 18)
                .addComponent(beforeAfterButton)
                .addGap(18, 18, 18)
                .addComponent(removeMinors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(printAdults)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printValues)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertStartActionPerformed
        listaDoble.insertarInicio(
                JOptionPane.showInputDialog(rootPane, "Ingrese el nombre de la persona: "),
                Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Ingrese la edad de la persona: ")));
    }//GEN-LAST:event_insertStartActionPerformed

    private void printValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printValuesActionPerformed
        listaDoble.imprimir();
    }//GEN-LAST:event_printValuesActionPerformed

    private void insertFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertFinalActionPerformed
        listaDoble.insertarFinal(
                JOptionPane.showInputDialog(rootPane, "Ingrese el nombre de la persona: "),
                Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Ingrese la edad de la persona: ")));
    }//GEN-LAST:event_insertFinalActionPerformed

    private void beforeAfterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beforeAfterButtonActionPerformed
        listaDoble.delanteAtrás(Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Ingrese el indice: ")));
    }//GEN-LAST:event_beforeAfterButtonActionPerformed

    private void insertBeforeIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBeforeIndexActionPerformed
        listaDoble.insertarPorIndice(
                JOptionPane.showInputDialog(rootPane, "Ingrese el nombre de la persona: "), 
                Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Ingrese la edad de la persona: ")), 
                Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Ingrese el indice: ")));
    }//GEN-LAST:event_insertBeforeIndexActionPerformed

    private void removeMinorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMinorsActionPerformed
        listaDoble.removerMenores();
    }//GEN-LAST:event_removeMinorsActionPerformed

    private void printAdultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printAdultsActionPerformed
        listaDoble.imprimirMayores();
    }//GEN-LAST:event_printAdultsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beforeAfterButton;
    private javax.swing.JButton insertBeforeIndex;
    private javax.swing.JButton insertFinal;
    private javax.swing.JButton insertStart;
    private javax.swing.JButton printAdults;
    private javax.swing.JButton printValues;
    private javax.swing.JButton removeMinors;
    // End of variables declaration//GEN-END:variables
}