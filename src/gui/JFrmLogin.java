

package gui;

import dao.BuscaDao;
import factory.ConnectionFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.misc.BASE64Encoder;


public class JFrmLogin extends javax.swing.JFrame {

    private Connection con;
    public static String tipoUsuario;
    /**
     * Creates new form JFrmLogin
     */
    public JFrmLogin() {
        initComponents();
        
        setResizable(false);
        
        setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLBImagem = new javax.swing.JLabel();
        jPnlLogin = new javax.swing.JPanel();
        jLblCPF = new javax.swing.JLabel();
        jLblSenha = new javax.swing.JLabel();
        jPassSenha = new javax.swing.JPasswordField();
        jBtnEntrar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login Sistema Almoxarifado ");

        jLBImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/politenico.png"))); // NOI18N

        jPnlLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPnlLogin.setForeground(new java.awt.Color(51, 51, 255));

        jLblCPF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLblCPF.setText("CPF:");

        jLblSenha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLblSenha.setText("Senha:");

        jPassSenha.setToolTipText("Digite sua Senha");

        jBtnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/2683_32x32.png"))); // NOI18N
        jBtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEntrarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/2702_32x32.png"))); // NOI18N

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setToolTipText("Digite seu CPF  XXX.XXX.XXX-XX");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlLoginLayout = new javax.swing.GroupLayout(jPnlLogin);
        jPnlLogin.setLayout(jPnlLoginLayout);
        jPnlLoginLayout.setHorizontalGroup(
            jPnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLoginLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblCPF)
                    .addComponent(jLblSenha))
                .addGap(18, 18, 18)
                .addGroup(jPnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlLoginLayout.createSequentialGroup()
                        .addGap(0, 55, Short.MAX_VALUE)
                        .addComponent(jBtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPassSenha)
                    .addComponent(jFormattedTextField1))
                .addContainerGap())
        );
        jPnlLoginLayout.setVerticalGroup(
            jPnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLoginLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblCPF)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblSenha)
                    .addComponent(jPassSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jBtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLBImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLBImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    
    private void jBtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEntrarActionPerformed
        
        BuscaDao dao = new BuscaDao();
        String senha = jPassSenha.getText();
        String novaSenha = criptografa(senha);
        System.out.println("senha "+senha+"  Senha "+novaSenha);
        //login:888.888.888-88   senha: 1       
        int idUser = dao.getLogin(jFormattedTextField1.getText(), novaSenha);
        tipoUsuario = dao.BuscaTipo(idUser);
        
        if(idUser != 0){
            
            System.out.println("Tipo = "+ tipoUsuario);
            JFrmPrincipal frmPrincipal = new JFrmPrincipal();
            frmPrincipal .setVisible(true);
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(null,"Usuario ou Senha Invalidos");
        }
        
        
        
    }//GEN-LAST:event_jBtnEntrarActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnEntrar;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLBImagem;
    private javax.swing.JLabel jLblCPF;
    private javax.swing.JLabel jLblSenha;
    private javax.swing.JPasswordField jPassSenha;
    private javax.swing.JPanel jPnlLogin;
    // End of variables declaration//GEN-END:variables
}
