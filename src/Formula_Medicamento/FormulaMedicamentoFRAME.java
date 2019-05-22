/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formula_Medicamento;

import Paciente.Paciente;
import View.Menu;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jpgas
 */
public class FormulaMedicamentoFRAME extends javax.swing.JFrame {

    /**
     * Creates new form FormulaMedicamentoFRAME
     */
    private DefaultTableModel modeloTabla;
     
    public FormulaMedicamentoFRAME() {
        String nombres[] = {"ID", "ID FORMULA", "CANTIDAD", "ID MEDICAMETO"};
        modeloTabla = new DefaultTableModel(null, nombres);
        cargarTabla();
        initComponents();
    }
    
    private void cargarTabla(){
        FormulaMedicamento objFormulaMedicamento = new FormulaMedicamento();
        ResultSet resultado = objFormulaMedicamento.cargarTablaFormulaMedicamento();
        modeloTabla.setRowCount(0);
        try{
            Object dato[] = new Object[4];
            while(resultado.next()){
                
            for(int i = 0; i < 4;i++){
                dato[i] = resultado.getObject(i+1);
            }
            modeloTabla.addRow(dato);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdMedicamento = new javax.swing.JTextField();
        btnMenu = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFormulaMedicamento = new javax.swing.JTable();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        lblFormulaMedica = new javax.swing.JLabel();
        txtFormulaMedica = new javax.swing.JTextField();
        txtCantidadMedicamento = new javax.swing.JTextField();
        lblCantidadMedicamento = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        lblIdMedicamento = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnMenu.setText("MENÚ");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jtFormulaMedicamento.setModel(modeloTabla);
        jtFormulaMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFormulaMedicamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFormulaMedicamento);

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jLabel2.setText("FORMULA DEL MEDICAMENTO");

        lblid.setText("ID");

        lblFormulaMedica.setText("ID DE LA FORMULA MEDICA ");

        lblCantidadMedicamento.setText("CANTIDAD DE MEDICAMENTO");

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblIdMedicamento.setText("ID DEL MEDICAMENTO");

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFormulaMedica)
                            .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantidadMedicamento)
                            .addComponent(lblIdMedicamento))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdMedicamento)
                                    .addComponent(txtCantidadMedicamento)
                                    .addComponent(txtFormulaMedica))
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnMenu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFormulaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFormulaMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidadMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantidadMedicamento))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdMedicamento))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnLimpiar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnMenu)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        this.setVisible(false);
        new Menu().setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        FormulaMedicamento objFormulaMedicamento = new FormulaMedicamento();
        int id = Integer.parseInt(txtid.getText());
        int id_formula = Integer.parseInt(txtFormulaMedica.getText());
        String cantidad = txtCantidadMedicamento.getText();
        int id_medicamento = Integer.parseInt(txtIdMedicamento.getText());
      

        boolean resultado = objFormulaMedicamento.insertarFormula_Medicamento(id, id_formula, cantidad, id_medicamento);
        if(resultado){
            JOptionPane.showMessageDialog(null, "Se inserto correctamente.");
            cargarTabla();
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar.");
        }

        txtid.setText("");
        txtFormulaMedica.setText("");
        txtCantidadMedicamento.setText("");
        txtIdMedicamento.setText("");
      
        txtid.requestFocus();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        FormulaMedicamento objFormulaMedicamento = new FormulaMedicamento();
        int id = Integer.parseInt(txtid.getText());
        boolean resultado = objFormulaMedicamento.eliminarFormula_Medicamento(id);
        if(resultado){
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente.");
            cargarTabla();
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar.");
        }

         txtid.setText("");
        txtFormulaMedica.setText("");
        txtCantidadMedicamento.setText("");
        txtIdMedicamento.setText("");
      
        txtid.requestFocus();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jtFormulaMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFormulaMedicamentoMouseClicked
        int aux = jtFormulaMedicamento.getSelectedRow();
        txtid.setText(modeloTabla.getValueAt(aux, 0).toString());
        txtFormulaMedica.setText(modeloTabla.getValueAt(aux, 1).toString());
        txtCantidadMedicamento.setText(modeloTabla.getValueAt(aux, 2).toString());
        txtIdMedicamento.setText(modeloTabla.getValueAt(aux, 3).toString());
       
      

    }//GEN-LAST:event_jtFormulaMedicamentoMouseClicked

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        FormulaMedicamento objtFormulaMedicamento = new FormulaMedicamento();
        int id = Integer.parseInt(txtid.getText());
       int id_formula = Integer.parseInt(txtFormulaMedica.getText());
        String cantidad = txtCantidadMedicamento.getText();
        int id_medicamento = Integer.parseInt(txtIdMedicamento.getText());
        boolean resultado = objtFormulaMedicamento.actualizarFormula_Medicamento(id, id_formula, cantidad, id_medicamento);
        if(resultado){
            JOptionPane.showMessageDialog(null, "Actualizó correctamente.");
            cargarTabla();
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar.");
        }
        txtid.setText("");
        txtFormulaMedica.setText("");
        txtCantidadMedicamento.setText("");
        txtIdMedicamento.setText("");
      
        txtid.requestFocus();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
         txtid.setText("");
        txtFormulaMedica.setText("");
        txtCantidadMedicamento.setText("");
        txtIdMedicamento.setText("");
      
        txtid.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(FormulaMedicamentoFRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormulaMedicamentoFRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormulaMedicamentoFRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormulaMedicamentoFRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormulaMedicamentoFRAME().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtFormulaMedicamento;
    private javax.swing.JLabel lblCantidadMedicamento;
    private javax.swing.JLabel lblFormulaMedica;
    private javax.swing.JLabel lblIdMedicamento;
    private javax.swing.JLabel lblid;
    private javax.swing.JTextField txtCantidadMedicamento;
    private javax.swing.JTextField txtFormulaMedica;
    private javax.swing.JTextField txtIdMedicamento;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
