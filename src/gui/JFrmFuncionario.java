/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controlador.FuncionarioController;
import controlador.ServidorController;
import java.awt.Component;
import java.awt.Container;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.Bolsista;
import modelo.Funcionario;
import modelo.Servidor;
import sun.misc.BASE64Encoder;
import util.ValidaCampos;

/**
 *
 * @author aluno
 */
public class JFrmFuncionario extends javax.swing.JFrame {

    private boolean alt = false;
    private int idFuncionario = 0;
    private String cpf  = null;
    private char tipo;

    public JFrmFuncionario(Funcionario funcionario) {
        initComponents();
        setResizable(false);
        
        setLocationRelativeTo(null);
        if (funcionario != null) {
            preencheCampos(funcionario);
        } else {
            jTxtNome.requestFocus();
        }
    }

    private void limpacampos(Container container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            } else if (component instanceof JFormattedTextField) {
                ((JFormattedTextField) component).setText(null);
            } else if (component instanceof JPasswordField) {
                ((JPasswordField) component).setText(null);
            }
        }
        jTxtNome.requestFocus();
    }
    
    public String criptografa(String senha){  
        try{  
         MessageDigest digest = MessageDigest.getInstance("MD5");  
                       digest.update(senha.getBytes());  
         BASE64Encoder encoder = new BASE64Encoder();  
                return encoder.encode(digest.digest());  
        }catch(NoSuchAlgorithmException ns){  
            ns.printStackTrace();  
        }  
        return senha;  
    }

    private void preencheCampos(Funcionario funcionario) {
        idFuncionario = funcionario.getIdFuncionario();
        jTxtNome.setText(funcionario.getNomeCompleto());
        jTxtCpf.setText(funcionario.getCpf());
        jTxtEmail.setText(funcionario.getEmail());
        jTxtSenha.setText(funcionario.getSenha());
        if (funcionario.getTipo() == 'A'){
            jRdBtnAlmoxarife.setSelected(true);
        }
        else{
            jRdBtnTerceirizado.setSelected(true);
        }
        cpf = funcionario.getCpf();
        jBtnIncluir.setEnabled(false);
        jBtnSalvar.setEnabled(false);
        jBtnExcluir.setEnabled(true);
        jBtnCancelar.setEnabled(true);
        jBtnSair.setEnabled(true);
        alt = true;
    }

    private boolean validaCampos() {
        String mensagem = "";
        boolean c1, c2, c3;
        c1 = c2 = c3 = false;
        boolean retorno = false;
        if (!ValidaCampos.validaAlfabetico(jTxtNome.getText())) {
            mensagem += "Nome Invalido !\n";
            retorno = true;
            c1 = true;
        }
        if (!ValidaCampos.validaCpf(jTxtCpf.getText())) {
            mensagem += "Cpf Invalido !\n";
            retorno = true;
            c2 = true;
        }
        if (!ValidaCampos.validaEmail(jTxtEmail.getText())) {
            mensagem += "E-mail Invalido !\n";
            retorno = true;
            c3 = true;
        }
        if (retorno) {
            JOptionPane.showMessageDialog(this, mensagem, "Controle de Estoque", JOptionPane.INFORMATION_MESSAGE);
            if (c1) {
                jTxtNome.requestFocus();
            } else if (c2) {
                jTxtCpf.requestFocus();
            } else if (c3) {
                jTxtEmail.requestFocus();
            }
        }
        return retorno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPnlBotoes = new javax.swing.JPanel();
        jBtnIncluir = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();
        jPnlCampos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtSenha = new javax.swing.JPasswordField();
        jTxtCpf = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jRdBtnAlmoxarife = new javax.swing.JRadioButton();
        jRdBtnTerceirizado = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Funcionarios");
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
                .addContainerGap(18, Short.MAX_VALUE))
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

        jLabel1.setText("Nome Completo:");

        jTxtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNomeKeyTyped(evt);
            }
        });

        jLabel2.setText("Cpf:");

        jLabel5.setText("E-mail:");

        jTxtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNomeKeyTyped(evt);
            }
        });

        jLabel6.setText("Senha:");

        jTxtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNomeKeyTyped(evt);
            }
        });

        try {
            jTxtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTxtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNomeKeyTyped(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        buttonGroup1.add(jRdBtnAlmoxarife);
        jRdBtnAlmoxarife.setText("Almoxarife");

        buttonGroup1.add(jRdBtnTerceirizado);
        jRdBtnTerceirizado.setText("Terceirizado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRdBtnTerceirizado)
                    .addComponent(jRdBtnAlmoxarife))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRdBtnTerceirizado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRdBtnAlmoxarife)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPnlCamposLayout = new javax.swing.GroupLayout(jPnlCampos);
        jPnlCampos.setLayout(jPnlCamposLayout);
        jPnlCamposLayout.setHorizontalGroup(
            jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlCamposLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtNome)
                        .addContainerGap())
                    .addGroup(jPnlCamposLayout.createSequentialGroup()
                        .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPnlCamposLayout.createSequentialGroup()
                                .addComponent(jTxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtSenha))
                            .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        jPnlCamposLayout.setVerticalGroup(
            jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlCamposLayout.createSequentialGroup()
                        .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        if (!validaCampos()) {
            FuncionarioController sc = new FuncionarioController();
            Bolsista b = new Bolsista();
            
            String senha = new String(jTxtSenha.getPassword()).trim();
            String novaSenha = criptografa(senha);
            if (jRdBtnAlmoxarife.isSelected()){
                tipo = 'A';
            }
            else{
                tipo = 'T';
            }
            int erro = sc.incluir(jTxtNome.getText(), jTxtCpf.getText(), novaSenha, jTxtEmail.getText(), tipo);
            if (erro > -1) {
                if (erro == 1062) {
                    Funcionario funcionario = null;
                    List<Funcionario>listaFuncionarios = sc.getUsuarioCpf(jTxtCpf.getText());
                    if(listaFuncionarios.size()>0)
                        funcionario = listaFuncionarios.get(0);
                    if(funcionario !=null){
                        JOptionPane.showMessageDialog(this, "CPF ja cadastrado", "Controle Estoque - Cadastro de Funcionario", JOptionPane.ERROR_MESSAGE);
                        jTxtCpf.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Erro numero " + erro, "Controle Estoque- Cadastro de Funcionario", JOptionPane.ERROR_MESSAGE);
                    jTxtCpf.requestFocus();
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
      // JFrmLstFuncionarios frmLstFuncionarios = new JFrmLstFuncionarios();
       //frmLstFuncionarios.setVisible(true);
       dispose();
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
      if (!validaCampos()) {
            Bolsista b = new Bolsista();
            
            String senha = new String(jTxtSenha.getPassword()).trim();
            String novaSenha = criptografa(senha);
            FuncionarioController sc = new FuncionarioController();
            if (jRdBtnAlmoxarife.isSelected()){
                tipo = 'A';
            }
            else{
                tipo = 'T';
            }
            int erro = sc.alterar(idFuncionario,jTxtNome.getText(), jTxtCpf.getText(), novaSenha, jTxtEmail.getText(), tipo);
            if (erro > -1) {
                if (erro == 1062) {
                    if(!jTxtCpf.getText().equals(cpf)){
                        JOptionPane.showMessageDialog(this, "CPF ja cadastrado", "Controle Estoque - Cadastro de Funcionario", JOptionPane.ERROR_MESSAGE);
                        jTxtCpf.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Erro numero " + erro, "Controle Estoque- Cadastro de Funcionario", JOptionPane.ERROR_MESSAGE);
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
            case 0: FuncionarioController sc = new FuncionarioController();
                int erro = sc.excluir(idFuncionario);
                if(erro >-1)
                    JOptionPane.showMessageDialog(this, "Erro Numero "+erro,"Controle de Estoque - Cadastro Funcionario",JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(JFrmFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmFuncionario(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPnlBotoes;
    private javax.swing.JPanel jPnlCampos;
    private javax.swing.JRadioButton jRdBtnAlmoxarife;
    private javax.swing.JRadioButton jRdBtnTerceirizado;
    private javax.swing.JFormattedTextField jTxtCpf;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JPasswordField jTxtSenha;
    // End of variables declaration//GEN-END:variables
}
