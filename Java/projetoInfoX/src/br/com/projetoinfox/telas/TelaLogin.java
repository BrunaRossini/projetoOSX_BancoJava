/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoinfox.telas;

import java.sql.*;
import br.com.projetoinfox.dal.ModuloConexao;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruna Rossini
 */
public class TelaLogin extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;// para usar as querys 
    ResultSet rs = null; //executar a query

    public void logar() {
        String sql = "select * from tbusuarios where login=? and senha=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tfUsuarioLogin.getText());
            pst.setString(2, tfSenhaLogin.getText());// campo especial
            rs = pst.executeQuery();
            //validação de usuário na base de dados por perfil 
            if (rs.next()) {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                TelaPrincipal.lbUsuario.setText(rs.getString(2));// campo usuario no banco de dados
                telaPrincipal.setVisible(true);
                TelaPrincipal.lbUsuario.setForeground(new Color(70, 130, 180));
                String perfil = rs.getString(6); // campo perfil no banco de dados
                this.dispose(); //fechar a tela de login após usuário validado
                conexao.close();
                if (perfil.equals("adm")) {
                    TelaPrincipal.mnRelatorio.setEnabled(true);
                    TelaPrincipal.miUsuario.setEnabled(true);
                    TelaPrincipal.lbUsuario.setForeground(Color.darkGray);
                    this.dispose(); //fechar a tela de login após usuário validado
                    conexao.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "usuário e/ou senha inválido(s)!");
                tfUsuarioLogin.setText("");
                tfSenhaLogin.setText("");
                tfUsuarioLogin.grabFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        conexao = ModuloConexao.conector();
        //System.out.println(conexao);
        if (conexao != null) {
            lbStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projetoinfox/icones/dbOk.png")));
        } else {
            lbStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projetoinfox/icones/dbOff.png")));
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

        jLabel1 = new javax.swing.JLabel();
        lbLoginUsuario = new javax.swing.JLabel();
        lbSenhaUsuario = new javax.swing.JLabel();
        tfUsuarioLogin = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        tfSenhaLogin = new javax.swing.JPasswordField();
        lbStatus = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TEC System - Login");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        lbLoginUsuario.setText("Usuário");

        lbSenhaUsuario.setText("Senha");

        tfUsuarioLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioLoginActionPerformed(evt);
            }
        });

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        btLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btLoginKeyPressed(evt);
            }
        });

        tfSenhaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSenhaLoginActionPerformed(evt);
            }
        });
        tfSenhaLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSenhaLoginKeyPressed(evt);
            }
        });

        lbStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projetoinfox/icones/dbOff.png"))); // NOI18N
        lbStatus.setText("Conexão ao Banco");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 173, Short.MAX_VALUE)
                .addComponent(btLogin)
                .addGap(138, 138, 138))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfSenhaLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(tfUsuarioLogin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lbStatus)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLoginUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfUsuarioLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSenhaUsuario))
                .addGap(18, 18, 18)
                .addComponent(btLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbStatus)
                .addGap(8, 8, 8))
        );

        setSize(new java.awt.Dimension(384, 239));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        getRootPane().setDefaultButton(btLogin);
        logar();
    }//GEN-LAST:event_btLoginActionPerformed

    private void tfSenhaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSenhaLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSenhaLoginActionPerformed

    private void tfUsuarioLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsuarioLoginActionPerformed

    private void tfSenhaLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSenhaLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            logar();
        }
    }//GEN-LAST:event_tfSenhaLoginKeyPressed

    private void btLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            logar();
        }
    }//GEN-LAST:event_btLoginKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            logar();
        }
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbLoginUsuario;
    private javax.swing.JLabel lbSenhaUsuario;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPasswordField tfSenhaLogin;
    private javax.swing.JTextField tfUsuarioLogin;
    // End of variables declaration//GEN-END:variables
}
