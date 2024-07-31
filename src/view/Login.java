package view;

import controller.TaiKhoanDao;
import java.awt.Color;
import javax.swing.JOptionPane;
import model.TaiKhoan;

public class Login extends javax.swing.JFrame {

    TaiKhoanDao service = new TaiKhoanDao();

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_MK = new javax.swing.JLabel();
        txt_TK = new javax.swing.JTextField();
        txt_MK = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        lbl_TK = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(13, 36, 51));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(240, 151, 57));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 98, 83));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user (1).png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 420));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quên mật khẩu?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 280, 20));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setAlignmentY(1.0F);
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 168, 280, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setAlignmentY(1.0F);
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 280, -1));

        lbl_MK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_MK.setForeground(new java.awt.Color(255, 255, 255));
        lbl_MK.setText("Mật khẩu");
        jPanel1.add(lbl_MK, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, 30));

        txt_TK.setBackground(new java.awt.Color(13, 36, 51));
        txt_TK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_TK.setForeground(new java.awt.Color(255, 255, 255));
        txt_TK.setBorder(null);
        txt_TK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_TKMouseClicked(evt);
            }
        });
        txt_TK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TKActionPerformed(evt);
            }
        });
        jPanel1.add(txt_TK, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 280, 30));

        txt_MK.setBackground(new java.awt.Color(13, 36, 51));
        txt_MK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_MK.setForeground(new java.awt.Color(255, 255, 255));
        txt_MK.setBorder(null);
        jPanel1.add(txt_MK, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 280, 30));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Exit");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, 70, 30));

        lbl_TK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_TK.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TK.setText("Tài khoản");
        jPanel1.add(lbl_TK, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 102, -1, 30));

        jButton2.setBackground(new java.awt.Color(240, 151, 57));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Đăng nhập");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 280, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_TKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TKMouseClicked
        // TODO add your handling code here:
        this.ResetError();
    }//GEN-LAST:event_txt_TKMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        this.ResetError();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.checkAccount();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_TKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TKActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_MK;
    private javax.swing.JLabel lbl_TK;
    private javax.swing.JPasswordField txt_MK;
    private javax.swing.JTextField txt_TK;
    // End of variables declaration//GEN-END:variables

//  Chức năng
    public boolean checkData() {
        if (txt_TK.getText().isBlank() || txt_MK.getText().isBlank()) {
            if (txt_TK.getText().isBlank()) {
                txt_TK.setBackground(Color.red);
                lbl_TK.setText("Vui lòng nhập email");
                lbl_TK.setForeground(Color.red);
            }
            if (txt_MK.getText().isBlank()) {
                txt_MK.setBackground(Color.red);
                lbl_MK.setText("Vui lòng nhập mật khẩu");
                lbl_MK.setForeground(Color.red);
            }
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin !");
            return false;
        } else {
            return true;
        }
    }

//    reset báo lỗi form 
    public void ResetError() {
        txt_TK.setBackground(Color.WHITE);
        lbl_TK.setText("Email");
        lbl_TK.setForeground(Color.BLACK);
        txt_TK.setBackground(Color.WHITE);
        lbl_MK.setText("Password");
        lbl_MK.setForeground(Color.BLACK);
    }

//    Check đăng nhập
    private void checkAccount() {
        if (checkData() == true) {
            String email = txt_TK.getText().trim();
            String matKhau = txt_MK.getText().trim();
            int check = 0;

            for (TaiKhoan x : service.getTaiKhoanNV()) {
                if (email.equalsIgnoreCase(x.getEmail()) && matKhau.equalsIgnoreCase(x.getMatKhau())) {
                    for (TaiKhoan tt : service.getChucVu(email)) {
                        if (tt.getTrangThaiNV() == 0) {
                            JOptionPane.showMessageDialog(this, "Tài khoản không còn hoạt động");
                            return;  // thoát khỏi hàm nếu tài khoản không hoạt động
                        } else {
                            if (tt.getChucVuNV() == 1) {
                                JOptionPane.showMessageDialog(this, "Đăng nhập thành công dưới quyền quản lý");
                            } else {
                                JOptionPane.showMessageDialog(this, "Đăng nhập thành công dưới quyền nhân viên");
                            }
                            this.dispose();
                            Menu mn = new Menu();
                            mn.setVisible(true);
                            return;  // thoát khỏi hàm sau khi mở Menu
                        }
                    }
                    check = 1;
                }
            }

            if (check == 0) {
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu chưa chính xác!");
            }
        }
    }

}
