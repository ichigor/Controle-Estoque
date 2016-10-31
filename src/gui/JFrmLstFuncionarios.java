/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controlador.FuncionarioController;
import modelo.Funcionario;
import tableModel.FuncionarioTableModel;

/**
 *
 * @author aluno
 */
public class JFrmLstFuncionarios extends javax.swing.JFrame {

    private FuncionarioTableModel funcionarioModel;
    private final FuncionarioController sc = new FuncionarioController();
    public JFrmLstFuncionarios() {
        initComponents();
        setResizable(false);
        
        setLocationRelativeTo(null);
        funcionarioModel = new FuncionarioTableModel(sc.listaFuncionario());
        jTblFuncionarios.setModel(funcionarioModel);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnIncluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCmbCampos = new javax.swing.JComboBox();
        jTxtProcura = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Funcionarios");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add_32.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jLabel1.setText("Campo para Busca:");

        jCmbCampos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nenhum", "Nome", "CPF", "Siape" }));
        jCmbCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbCamposActionPerformed(evt);
            }
        });

        jTxtProcura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtProcuraKeyTyped(evt);
            }
        });

        jTblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCmbCampos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtProcura, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jBtnIncluir)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCmbCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtProcura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblFuncionariosMouseClicked
       FuncionarioTableModel modelo = (FuncionarioTableModel) jTblFuncionarios.getModel();
       Funcionario funcionario = modelo.getFuncionario(jTblFuncionarios.getSelectedRow());
       JFrmFuncionario frmFuncionario = new JFrmFuncionario(funcionario);
       frmFuncionario.setVisible(true);
       //dispose();
    }//GEN-LAST:event_jTblFuncionariosMouseClicked

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
       JFrmFuncionario frmFuncionario = new JFrmFuncionario(null);
       frmFuncionario.setVisible(true);
       //dispose();
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jTxtProcuraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtProcuraKeyTyped
       String chave = jTxtProcura.getText();
       if(chave.equals("")){
           chave = String.valueOf(evt.getKeyChar());
       }else if (evt.getKeyChar() !='\b'){
           chave = chave + evt.getKeyChar();
       }
       switch (jCmbCampos.getSelectedIndex()){
           case 1: funcionarioModel = new FuncionarioTableModel (sc.getUsuarioNome(chave));
               break;
           case 2: funcionarioModel = new FuncionarioTableModel (sc.getUsuarioCpf(chave));
               break;
       }
       //atribui o modelo a tabela
       jTblFuncionarios.setModel(funcionarioModel);
    }//GEN-LAST:event_jTxtProcuraKeyTyped

    private void jCmbCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbCamposActionPerformed
        if(jCmbCampos.getSelectedIndex()==0){
            funcionarioModel = new FuncionarioTableModel(sc.listaFuncionario());
            jTblFuncionarios.setModel(funcionarioModel);
        }
        jTxtProcura.requestFocus();
    }//GEN-LAST:event_jCmbCamposActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JFrmPrincipal frmPrincipal = new JFrmPrincipal();
        frmPrincipal.setVisible(true);
        //dispose();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(JFrmLstFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmLstFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmLstFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmLstFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmLstFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JComboBox jCmbCampos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblFuncionarios;
    private javax.swing.JTextField jTxtProcura;
    // End of variables declaration//GEN-END:variables
}
