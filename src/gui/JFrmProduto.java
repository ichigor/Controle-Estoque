
package gui;


import controlador.ProdutoController;
import controlador.UnidadeController;
import java.awt.Component;
import java.awt.Container;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Produto;
import modelo.Unidade;
import util.ValidaCampos;

/**
 *
 * @author aluno
 */
public class JFrmProduto extends javax.swing.JFrame {

    private boolean alt = false;
    private int idProduto = 0;
    private List<Unidade> listaUnidades;

    public JFrmProduto(Produto produto) {
        UnidadeController sc = new UnidadeController();
        listaUnidades = sc.listaUnidades();
        initComponents();
        setResizable(false);
        
        setLocationRelativeTo(null);
        setUnidadesCombo();
        if (produto != null) {
            preencheCampos(produto);
        } else {
            jTxtNome.requestFocus();
        }
    }
    
    private void setUnidadesCombo (){
        DefaultComboBoxModel lstUnidades = new DefaultComboBoxModel();
        for(int i=0; i< listaUnidades.size(); i++)
            lstUnidades.addElement(listaUnidades.get(i).getDescricao());
        jCmbUnidade.setModel(lstUnidades);
    }
    
    
    private void limpacampos(Container container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            } 
        }
        jTxtNome.requestFocus();
    }
    
    private void selecionaNomeUnidade (Unidade unidadeAux){
        for (int i=0; i < jCmbUnidade.getItemCount(); i++){
            if(jCmbUnidade.getItemAt(i).equals(unidadeAux.getDescricao())){
                jCmbUnidade.setSelectedIndex(i);
                break;
            }
        }
    }
    
    
    private void preencheCampos(Produto produto) {
        idProduto = produto.getIdProduto();
        jTxtNome.setText(produto.getNomeProduto());
        jTxtAtual.setText(String.valueOf(produto.getQtdAtual()));
        jTxtMin.setText(String.valueOf(produto.getQtdMin()));
        jTxtLocalizacao.setText(produto.getLocalizacao());
        selecionaNomeUnidade(produto.getUnidade());
            
        jBtnIncluir.setEnabled(false);
        jBtnSalvar.setEnabled(false);
        jBtnExcluir.setEnabled(true);
        jBtnCancelar.setEnabled(true);
        jBtnSair.setEnabled(true);
        alt = true;
    }

    private boolean validaCampos() {
        String mensagem = "";
        boolean c1, c2, c3, c4;
        c1 = c2 = c3 = c4 = false;
        boolean retorno = false;
        if (!ValidaCampos.validaAlfaNumerico(jTxtNome.getText())) {
            mensagem += "Produto invalido !\n";
            retorno = true;
            c1 = true;
        }
        if (!ValidaCampos.validaQtd(jTxtAtual.getText())) {
            mensagem += "Quantidade atual invalida !\n";
            retorno = true;
            c2 = true;
        }
        if (!ValidaCampos.validaQtd(jTxtMin.getText())) {
            mensagem += "Quantidade minima invalida !\n";
            retorno = true;
            c3 = true;
        }
        if (!ValidaCampos.validaAlfaNumerico(jTxtLocalizacao.getText())) {
            mensagem += "Localizacao invalida !\n";
            retorno = true;
            c4 = true;
        }
        if (retorno) {
            JOptionPane.showMessageDialog(this, mensagem, "Controle de Estoque", JOptionPane.INFORMATION_MESSAGE);
            if (c1) {
                jTxtNome.requestFocus();
            } else if (c2) {
                jTxtAtual.requestFocus();
            } else if (c3) {
                jTxtMin.requestFocus();
            } else if (c4) {
                jTxtLocalizacao.requestFocus();
            }
        }
        return retorno;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlBotoes = new javax.swing.JPanel();
        jBtnIncluir = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();
        jPnlCampos = new javax.swing.JPanel();
        jLbProduto = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLbQtdMin = new javax.swing.JLabel();
        jLbQtdAtual = new javax.swing.JLabel();
        jTxtAtual = new javax.swing.JTextField();
        jLbLocalizacao = new javax.swing.JLabel();
        jLbUnidade = new javax.swing.JLabel();
        jCmbUnidade = new javax.swing.JComboBox();
        jTxtMin = new javax.swing.JTextField();
        jTxtLocalizacao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");
        setResizable(false);

        jPnlBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/2683_32x32.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.setPreferredSize(new java.awt.Dimension(120, 40));
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/6228_32x32.png"))); // NOI18N
        jBtnSalvar.setText("Salvar");
        jBtnSalvar.setEnabled(false);
        jBtnSalvar.setPreferredSize(new java.awt.Dimension(120, 40));
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/283_32x32.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.setEnabled(false);
        jBtnExcluir.setPreferredSize(new java.awt.Dimension(120, 40));
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/2702_32x32.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.setEnabled(false);
        jBtnCancelar.setPreferredSize(new java.awt.Dimension(120, 40));
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/11292_32x32.png"))); // NOI18N
        jBtnSair.setText("Sair");
        jBtnSair.setPreferredSize(new java.awt.Dimension(120, 40));
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlBotoesLayout = new javax.swing.GroupLayout(jPnlBotoes);
        jPnlBotoes.setLayout(jPnlBotoesLayout);
        jPnlBotoesLayout.setHorizontalGroup(
            jPnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPnlBotoesLayout.setVerticalGroup(
            jPnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPnlCampos.setBorder(new javax.swing.border.MatteBorder(null));

        jLbProduto.setText("Produto:");

        jTxtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNomeKeyTyped(evt);
            }
        });

        jLbQtdMin.setText("Qtd. Min");

        jLbQtdAtual.setText("Qtd. Atual");

        jTxtAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNomeKeyTyped(evt);
            }
        });

        jLbLocalizacao.setText("Localização:");

        jLbUnidade.setText("Unidade:");

        javax.swing.GroupLayout jPnlCamposLayout = new javax.swing.GroupLayout(jPnlCampos);
        jPnlCampos.setLayout(jPnlCamposLayout);
        jPnlCamposLayout.setHorizontalGroup(
            jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlCamposLayout.createSequentialGroup()
                        .addComponent(jLbProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtNome))
                    .addGroup(jPnlCamposLayout.createSequentialGroup()
                        .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPnlCamposLayout.createSequentialGroup()
                                .addComponent(jLbQtdMin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(jLbQtdAtual))
                            .addGroup(jPnlCamposLayout.createSequentialGroup()
                                .addComponent(jLbUnidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCmbUnidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLbLocalizacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtLocalizacao)))
                .addContainerGap())
        );
        jPnlCamposLayout.setVerticalGroup(
            jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbProduto)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLbQtdMin)
                        .addComponent(jLbQtdAtual)
                        .addComponent(jTxtAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLbLocalizacao)
                        .addComponent(jTxtLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbUnidade)
                    .addComponent(jCmbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPnlBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPnlCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPnlCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        if (!validaCampos()) {
            ProdutoController bc = new ProdutoController();
            Unidade unidade = listaUnidades.get(jCmbUnidade.getSelectedIndex());
            int erro = bc.incluir(jTxtNome.getText(), jTxtLocalizacao.getText(), Float.valueOf(jTxtMin.getText()), Float.valueOf(jTxtAtual.getText()) , unidade);
            if (erro > -1) {
                if (erro == 1062) {
                    Produto produto = null;
                    List<Produto>listaProdutos = bc.getProdutoNome(jTxtNome.getText());
                    if(listaProdutos.size()>0)
                        produto = listaProdutos.get(0);
                    if(produto !=null){
                        JOptionPane.showMessageDialog(this, "Nome do produto ja cadastrado", "Controle Estoque - Cadastro de Produto", JOptionPane.ERROR_MESSAGE);
                        jTxtNome.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Erro numero " + erro, "Controle Estoque - Cadastro de Produto", JOptionPane.ERROR_MESSAGE);
                    jTxtNome.requestFocus();
                }
            } else {
                jBtnCancelar.setEnabled(false);
                limpacampos(jPnlCampos);
            }
        }
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        jBtnIncluir.setEnabled(true);
        jBtnSalvar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnCancelar.setEnabled(false);
        jBtnSair.setEnabled(true);
        alt=false;
        limpacampos(jPnlCampos);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jTxtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtNomeKeyTyped
       if(alt){
           jBtnExcluir.setEnabled(false);
           jBtnSalvar.setEnabled(true);
       }
       jBtnCancelar.setEnabled(true);
    }//GEN-LAST:event_jTxtNomeKeyTyped

    private void jBtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairActionPerformed
       //JFrmLstProduto frmLstProdutos = new JFrmLstProduto();
      // frmLstProdutos.setVisible(true);
       dispose();
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
       if (!validaCampos()) {
            
            ProdutoController bc = new ProdutoController();
             Unidade unidade = listaUnidades.get(jCmbUnidade.getSelectedIndex());
            int erro = bc.alterar(idProduto,jTxtNome.getText(), jTxtLocalizacao.getText(), Float.valueOf(jTxtMin.getText()), Float.valueOf(jTxtAtual.getText()) , unidade);
            if (erro > -1) {
                if (erro == 1062) {
                    Produto produto = null;
                    List<Produto>listaProdutos = bc.getProdutoNome(jTxtNome.getText());
                    if(listaProdutos.size()>0)
                        produto = listaProdutos.get(0);
                    if(produto !=null){
                        JOptionPane.showMessageDialog(this, "Nome do produto ja cadastrado", "Controle Estoque - Cadastro de Produto", JOptionPane.ERROR_MESSAGE);
                        jTxtNome.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Erro numero " + erro, "Controle Estoque - Cadastro de Produto", JOptionPane.ERROR_MESSAGE);
                    jTxtNome.requestFocus();
                }  
            } else {
                jBtnSalvar.setEnabled(false);
                jBtnCancelar.setEnabled(false);
                jBtnIncluir.setEnabled(true);
                alt=false;
                limpacampos(jPnlCampos);
            }
        }
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        switch(JOptionPane.showConfirmDialog(this, "Confirma Exclusão?","Controle de Estoque",JOptionPane.YES_NO_OPTION)){
            case 0: ProdutoController bc = new ProdutoController();
                int erro = bc.excluir(idProduto);
                if(erro >-1)
                    JOptionPane.showMessageDialog(this, "Erro Numero "+erro,"Controle de Estoque - Cadastro Produto",JOptionPane.ERROR_MESSAGE);
                else{
                    jBtnSalvar.setEnabled(false);
                    jBtnCancelar.setEnabled(false);
                    jBtnExcluir.setEnabled(false);
                    jBtnIncluir.setEnabled(true);
                    limpacampos(jPnlCampos);
                }break;
            case 1: break;
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JFrmProduto(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JComboBox jCmbUnidade;
    private javax.swing.JLabel jLbLocalizacao;
    private javax.swing.JLabel jLbProduto;
    private javax.swing.JLabel jLbQtdAtual;
    private javax.swing.JLabel jLbQtdMin;
    private javax.swing.JLabel jLbUnidade;
    private javax.swing.JPanel jPnlBotoes;
    private javax.swing.JPanel jPnlCampos;
    private javax.swing.JTextField jTxtAtual;
    private javax.swing.JTextField jTxtLocalizacao;
    private javax.swing.JTextField jTxtMin;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables
}
