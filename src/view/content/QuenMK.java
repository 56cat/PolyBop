package view.content;

//import controller.SendMail;
import controller.TaiKhoanDao;
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.TaiKhoan;

public class QuenMK extends javax.swing.JFrame {

    TaiKhoanDao service = new TaiKhoanDao();
//    SendMail sendMail = new SendMail();
    String code;

    public QuenMK() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_OTP = new javax.swing.JLabel();
        txt_OTP = new javax.swing.JTextField();
        txt_TK = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lbl_TK = new javax.swing.JLabel();
        txt_TK1 = new javax.swing.JTextField();
        btn_getMa = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 450));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setAlignmentY(1.0F);
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 168, 280, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setAlignmentY(1.0F);
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 180, -1));

        lbl_OTP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_OTP.setForeground(new java.awt.Color(255, 255, 255));
        lbl_OTP.setText("OTP");
        jPanel1.add(lbl_OTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, 30));

        txt_OTP.setBackground(new java.awt.Color(13, 36, 51));
        txt_OTP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_OTP.setForeground(new java.awt.Color(255, 255, 255));
        txt_OTP.setBorder(null);
        txt_OTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_OTPMouseClicked(evt);
            }
        });
        jPanel1.add(txt_OTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 180, 30));

        txt_TK.setBackground(new java.awt.Color(13, 36, 51));
        txt_TK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_TK.setForeground(new java.awt.Color(255, 255, 255));
        txt_TK.setBorder(null);
        jPanel1.add(txt_TK, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 280, 30));

        jButton1.setBackground(new java.awt.Color(240, 151, 57));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Đổi mật khẩu");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 280, 40));

        lbl_TK.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_TK.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TK.setText("Email");
        jPanel1.add(lbl_TK, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 102, -1, 30));

        txt_TK1.setBackground(new java.awt.Color(13, 36, 51));
        txt_TK1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_TK1.setForeground(new java.awt.Color(255, 255, 255));
        txt_TK1.setBorder(null);
        txt_TK1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_TK1MouseClicked(evt);
            }
        });
        jPanel1.add(txt_TK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 280, 30));

        btn_getMa.setBackground(new java.awt.Color(255, 102, 102));
        btn_getMa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_getMa.setForeground(new java.awt.Color(255, 255, 255));
        btn_getMa.setText("Lấy mã");
        jPanel1.add(btn_getMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 90, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Exit");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 70, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_OTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_OTPMouseClicked
        // TODO add your handling code here:
//        this.ResetError();
    }//GEN-LAST:event_txt_OTPMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.checkAccount();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
//        this.ResetError();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void txt_TK1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TK1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TK1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(QuenMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_getMa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_OTP;
    private javax.swing.JLabel lbl_TK;
    private javax.swing.JTextField txt_OTP;
    private javax.swing.JTextField txt_TK;
    private javax.swing.JTextField txt_TK1;
    // End of variables declaration//GEN-END:variables
 
    private void clickHover() {
        // Nhập email 
        if (txt_TK.getText().isBlank()) {
            txt_TK.setBackground(Color.red);
            lbl_TK.setText("Vui lòng nhập email");
            lbl_TK.setForeground(Color.red);
        } else {
            this.checkAccount();
        }
    }

//    private void labelGuiOTP() {
//        btn_getMa.setBackground(Color.red);
//        btn_getMa.setEnabled(false);
//        txt_OTP.setEnabled(true);
//        txt_OTP.setText("");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 30; i >= 0; i--) {
//                    try {
//                        Thread.sleep(1000);
//                        lbl_ThongBaoTimeOTP.setText("Nhận mã mới sau " + String.valueOf(i));
//                        if (i == 30) {
//                            btn_getMa.setEnabled(true);
//                            lbl_ThongBaoTimeOTP.setText("");
//                            btn_getMa.setBackground(Color.ORANGE);
//                            code = randum();
//                            sendMail.send(txt_TK.getText(), code);
//                        }
//                    } catch (InterruptedException ex) {
////                        Logger.getLogger(QuenMK_View.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        }).start();
//    }

    // Xóa thông báo lỗi 
    private void resetError() {
        txt_TK.setBackground(Color.WHITE);
        lbl_TK.setText("Email");
        lbl_TK.setForeground(Color.BLACK);
    }

    // check vadidate trống thông tin 
    boolean checkTrongTT() {
        if (txt_TK.getText().isBlank() || txt_OTP.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin ");
            return false;
        } else {
            return true;
        }
    }

    // Vadidate trống thông tin email 
    boolean checkTrongTTemail() {
        if (txt_TK.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập email ");
            return false;
        } else {
            return true;
        }
    }

    // Check email có tồn tại trên hệ thông hoặc đã khóa 
    private void checkAccount() {
        if (checkTrongTTemail() == true) {
            String email = txt_TK.getText().trim();
            int check = 0;
            for (TaiKhoan x : service.getTaiKhoanNV()) {
                // Đăng nhập thành công 
                if (email.equalsIgnoreCase(x.getEmail())) {
                    // Check trạng thái tài khoản 
                    for (TaiKhoan tt : service.getChucVu(email)) {
                        // Tài khoản không hoạt động 
                        if (tt.getTrangThaiNV() == 0) {
                            JOptionPane.showMessageDialog(this, "Tài khoản không còn hoạt dộng");
                        } // Tài khoản còn hoạt động
                        else {
                            // Gửi thông báo TOP 
//                            this.labelGuiOTP();
                        }
                    }
                    check = 1;
                }
            }
            // đăng nhập thất bại 
            if (check == 0) {
                JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại trên hệ thống !");
            }
        }
    }

    // Tạo số ngẫu nhiên 
    public String randum() {
        Random rd = new Random();
        int numberCode = rd.nextInt(1000) + 1000;
        return String.valueOf(numberCode);
    }

    // Check OTP 
    boolean checkOTP() {
        if (txt_OTP.getText().trim().equalsIgnoreCase(code)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "ERROR : Mã OTP Không chính xác \n Vui Lòng Kiểm Tra Và Nhập Lại Mã OTP ");
            return false;
        }
    }

    // Nhập đúng thông tin 
    void doiMatKhau() {
        if (checkTrongTT() == true) {
            if (checkOTP() == true) {
//                DoiMK_View dmk = new DoiMK_View(txt_Email.getText());
//                dmk.setVisible(true);
                this.dispose();
            }
        }
    }
}
