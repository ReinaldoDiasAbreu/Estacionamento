/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.estacionamento.gui;

import br.edu.ifnmg.poo.estacionamento.entity.Cliente;

/**
 *
 * @author Mirrális
 */
public class EstacionamentoGui extends javax.swing.JFrame {
    
    /**
     * Creates new form Estacionamento
     */
    public EstacionamentoGui() {
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

        jPanel1 = new javax.swing.JPanel();
        btnRent = new javax.swing.JButton();
        btnAddClient = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        btnListClients = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estacionamento");

        btnRent.setText("Alugar vaga");
        btnRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentActionPerformed(evt);
            }
        });

        btnAddClient.setText("Cadastrar Cliente");
        btnAddClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClientActionPerformed(evt);
            }
        });

        btnPayment.setText("Pagamento");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        btnListClients.setText("Exibir Clientes");
        btnListClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListClientsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnListClients)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnRent)
                .addGap(55, 55, 55)
                .addComponent(btnAddClient)
                .addGap(57, 57, 57)
                .addComponent(btnPayment)
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListClients)
                    .addComponent(btnRent)
                    .addComponent(btnAddClient)
                    .addComponent(btnPayment))
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentActionPerformed
        AlugarVaga alugar = new AlugarVaga();
        alugar.setLocationRelativeTo(this);
        alugar.setVisible(true);
    }//GEN-LAST:event_btnRentActionPerformed

    private void btnAddClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClientActionPerformed
        // Also use EditarCliente for adding new clients, but passing an empty client
        EditarCliente cliente = new EditarCliente(new Cliente(), new ClientesCadastrados(), true);
        cliente.setLocationRelativeTo(this);
        cliente.setVisible(true);
    }//GEN-LAST:event_btnAddClientActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        Pagamento payment = new Pagamento();
        payment.setLocationRelativeTo(this);
        payment.setVisible(true);
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnListClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListClientsActionPerformed
        ClientesCadastrados cadastrados = new ClientesCadastrados();
        cadastrados.setLocationRelativeTo(this);
        cadastrados.setVisible(true);
    }//GEN-LAST:event_btnListClientsActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(EstacionamentoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EstacionamentoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EstacionamentoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EstacionamentoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EstacionamentoGui().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddClient;
    private javax.swing.JButton btnListClients;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnRent;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
