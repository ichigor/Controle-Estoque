package gui;

import controlador.OperacaoController;
import controlador.ProdutoController;
import java.util.List;
import modelo.Produto;
import tableModel.OperacaoTableModel;
import tableModel.ProdutoTableModel;

/**
 *
 * @author aluno
 */
public class JFrmLstOperacao extends javax.swing.JFrame {

    private OperacaoTableModel operacaoModel;
    private final OperacaoController oc = new OperacaoController();
    public JFrmLstOperacao() {
        initComponents();
        setResizable(false);
        
        setLocationRelativeTo(null);
        operacaoModel = new OperacaoTableModel(oc.listaOperacoes());
        jTblOperacao.setModel(operacaoModel);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnIncluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCmbCampos = new javax.swing.JComboBox();
        jTxtProcura = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblOperacao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Produtos");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
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

        jCmbCampos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nenhum", "ID Operacao" }));
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

        jTblOperacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTblOperacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCmbCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtProcura)))
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

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
       JFrmOperacao frm = new JFrmOperacao();
       frm.setVisible(true);
       
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jCmbCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbCamposActionPerformed
        if(jCmbCampos.getSelectedIndex()==0){
            operacaoModel = new OperacaoTableModel(oc.listaOperacoes());
            jTblOperacao.setModel(operacaoModel);
        }
        jTxtProcura.requestFocus();
    }//GEN-LAST:event_jCmbCamposActionPerformed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
     
    }//GEN-LAST:event_formMouseExited

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JFrmPrincipal frmPrincipal = new JFrmPrincipal();
        frmPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowClosed

    private void jTxtProcuraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtProcuraKeyTyped
       String chave = jTxtProcura.getText();
       if(chave.equals("")){
           chave = String.valueOf(evt.getKeyChar());
       }else if (evt.getKeyChar() !='\b'){
           chave = chave + evt.getKeyChar();
       }
       
       switch (jCmbCampos.getSelectedIndex()){
           
           case 1: operacaoModel = new OperacaoTableModel (oc.getOperacaoIdLista(chave));
               break;
           
       }
       //atribui o modelo a tabela
       jTblOperacao.setModel(operacaoModel);
       
    }//GEN-LAST:event_jTxtProcuraKeyTyped

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
            java.util.logging.Logger.getLogger(JFrmLstOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmLstOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmLstOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmLstOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmLstOperacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JComboBox jCmbCampos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblOperacao;
    private javax.swing.JTextField jTxtProcura;
    // End of variables declaration//GEN-END:variables
}
