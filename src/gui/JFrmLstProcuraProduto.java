package gui;

import controlador.ProdutoController;
import java.util.List;
import modelo.Produto;
import tableModel.ProdutoTableModel;
import gui.JFrmOperacao;
import javax.swing.JFrame;

/**
 *
 * @author aluno
 */
public class JFrmLstProcuraProduto extends javax.swing.JFrame {

    private JFrame principal;
    private ProdutoTableModel produtoModel;
    private final ProdutoController bc = new ProdutoController();
    
    public JFrmLstProcuraProduto(JFrame joutro) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        produtoModel = new ProdutoTableModel(bc.listaProduto());
        jTblProduto.setModel(produtoModel);
        principal = joutro;
    }

    private JFrmLstProcuraProduto(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCmbCampos = new javax.swing.JComboBox();
        jTxtProcura = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblProduto = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista Procura Produtos");
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

        jLabel1.setText("Campo para Busca:");

        jCmbCampos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nenhum", "Produto", "Localizacao" }));
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

        jTblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblProduto);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/2683_32x32.png"))); // NOI18N
        jButton1.setText("Adicionar item a lista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(19, 19, 19)
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

    private void jTblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblProdutoMouseClicked
       ProdutoTableModel modelo = (ProdutoTableModel) jTblProduto.getModel();
       Produto produto = modelo.getProduto(jTblProduto.getSelectedRow());
      //JFrmProduto frmProduto = new JFrmProduto(produto);
       //frmProduto.setVisible(true);
       //dispose();
    }//GEN-LAST:event_jTblProdutoMouseClicked

    private void jTxtProcuraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtProcuraKeyTyped
       String chave = jTxtProcura.getText();
       if(chave.equals("")){
           chave = String.valueOf(evt.getKeyChar());
       }else if (evt.getKeyChar() !='\b'){
           chave = chave + evt.getKeyChar();
       }
       switch (jCmbCampos.getSelectedIndex()){
           
           case 1: produtoModel = new ProdutoTableModel (bc.getProdutoNome(chave));
               break;
           case 2: produtoModel = new ProdutoTableModel (bc.getProdutoLocalizacao(chave));
               break;
       }
       //atribui o modelo a tabela
       jTblProduto.setModel(produtoModel);
    }//GEN-LAST:event_jTxtProcuraKeyTyped

    private void jCmbCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbCamposActionPerformed
        if(jCmbCampos.getSelectedIndex()==0){
            produtoModel = new ProdutoTableModel(bc.listaProduto());
            jTblProduto.setModel(produtoModel);
        }
        jTxtProcura.requestFocus();
    }//GEN-LAST:event_jCmbCamposActionPerformed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
     
    }//GEN-LAST:event_formMouseExited

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //JFrmPrincipal frmPrincipal = new JFrmPrincipal();
        //frmPrincipal.setVisible(true);
        principal.setEnabled(true);
        dispose();
       //JFrmOperacao j = new JFrmOperacao();
       //j.TelaLoko();
        
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmLstProcuraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmLstProcuraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmLstProcuraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmLstProcuraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JFrmLstProcuraProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCmbCampos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblProduto;
    private javax.swing.JTextField jTxtProcura;
    // End of variables declaration//GEN-END:variables
}
