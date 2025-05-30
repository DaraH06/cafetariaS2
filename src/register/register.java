package register;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import base.LoginMenu;
import static database.db_connect.con;


public class register extends javax.swing.JFrame {
    public boolean saveToDatabase(String username, String email, String password, String rfid) {
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom wajib diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String url = "jdbc:mysql://localhost:3306/cafetaria";
        String user = "root";
        String pass = "";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "INSERT INTO user (username, email, password, id_rfid) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username.trim());
            pst.setString(2, email.trim());
            pst.setString(3, hashPassword(password)); // Gunakan hashPassword dari class ini

            if (rfid == null || rfid.trim().isEmpty()) {
                pst.setNull(4, java.sql.Types.VARCHAR);
            } else {
                pst.setString(4, rfid.trim());
            }

            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Registrasi berhasil!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Registrasi gagal!");
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat registrasi: " + ex.getMessage());
            return false;
        }
    }

    // ✅ Sekarang hashPassword berada di luar saveToDatabase
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Creates new form register
     */
    public register() {
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
        jLabel3 = new javax.swing.JLabel();
        id_rfid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 255, 255));
        jLabel3.setForeground(new java.awt.Color(51, 255, 255));
        jLabel3.setText("Log In");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 570, -1, -1));

        id_rfid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_rfidActionPerformed(evt);
            }
        });
        jPanel1.add(id_rfid, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 150, -1));

        jLabel1.setText("Sudah punya akun?");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, -1, -1));

        register.setBackground(new java.awt.Color(57, 62, 70));
        register.setForeground(new java.awt.Color(255, 211, 105));
        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel1.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 560, 80, 30));

        password.setBorder(null);
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, 320, 30));

        username.setBorder(null);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 320, 30));

        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 320, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrasi/design/m_register.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
  String user = username.getText();
    String mail = email.getText();
    String pass = password.getText();
    String rfid = id_rfid.getText(); // ambil nilai RFID dari field

    if (user.isEmpty() || mail.isEmpty() || pass.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    register dbHelper = new register();
    boolean success = dbHelper.saveToDatabase(user, mail, pass, rfid);

    if (success) {
    username.setText("");
    email.setText("");
    password.setText("");
    id_rfid.setText("");
    }
    }//GEN-LAST:event_registerActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void id_rfidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_rfidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_rfidActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new base.LoginMenu().setVisible(true); // buka form login
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JTextField id_rfid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton register;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
