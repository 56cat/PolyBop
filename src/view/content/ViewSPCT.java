package view.content;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.LoaiSanPham;
import model.MauSac;
import model.SanPhamCT_ID;
import controller.ChatLieuRepository;
import repository.LoaiSanPhamRepository;
import controller.MauSacRepository;
import controller.MsgBox;
import controller.SanPhamCTRepository;
import controller.ThuocTinhSanPhamRepository;
import controller.Xdate;

public class ViewSPCT extends javax.swing.JFrame {

    DefaultTableModel mol = new DefaultTableModel();
    SanPhamCTRepository service = new SanPhamCTRepository();
    MauSacRepository daoms = new MauSacRepository();
    ChatLieuRepository daocl = new ChatLieuRepository();
    LoaiSanPhamRepository daolv = new LoaiSanPhamRepository();
    ThuocTinhSanPhamRepository serviceTT = new ThuocTinhSanPhamRepository();

    List<MauSac> listMauSac;
    List<ChatLieu> listChatLieu;
    List<LoaiSanPham> listLoaiVi;
    List<SanPhamCT_ID> listSPCT;
    String maVi;

    public ViewSPCT(String maVi, String tenVi) {
        initComponents();
        init();
        this.maVi = maVi;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        txt_tenSP.setText(tenVi);
        this.fillTable(service.getDaTaSPCT(maVi));

        // Kiểm tra sản phẩm đã có thông tin chi tiết chưa 
        if (service.getSoLuongSPCT(maVi) <= 0) {
            //System.out.println("Sản phẩm chưa có thông tin chi tiết");
        }
    }

    private ViewSPCT() {
        initComponents();
        init();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void init() {
        fillcomboboxMauSac();
        fillcomboboxChatLieu();
//        fillcomboboxLoaiSanPham();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        txt_KhoaVi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_SoLuong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_giaBan = new javax.swing.JTextField();
        cbo_chatLieu = new javax.swing.JComboBox<>();
        cbo_mauSac = new javax.swing.JComboBox<>();
        txt_MaCTVi = new javax.swing.JTextField();
        txt_tenSP = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        txt_NgayNhap = new com.toedter.calendar.JDateChooser();
        txt_giaNhap = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SanPhamCT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Khóa Sản Phẩm");

        txt_KhoaVi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_KhoaVi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_KhoaVi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Số Lượng");

        txt_SoLuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_SoLuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_SoLuong.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Ngày Nhập");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Giá Nhập");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Tên Sản phẩm ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Mã Chi Tiết Sản Phẩm ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Màu Sắc");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Chất Liệu");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Giá Bán");

        txt_giaBan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_giaBan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_giaBan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        cbo_chatLieu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        cbo_mauSac.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txt_MaCTVi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_MaCTVi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_MaCTVi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txt_tenSP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_tenSP.setForeground(new java.awt.Color(255, 51, 51));
        txt_tenSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_tenSP.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_tenSP.setEnabled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-reset-24.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnSua1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        btnSua1.setText("Thêm");
        btnSua1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSua1MouseClicked(evt);
            }
        });
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        txt_giaNhap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_giaNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_giaNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        tbl_SanPhamCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SPCT", "Màu Sắc", "Chất Liệu", "Khóa Sản phẩm", "Số Lượng", "Giá Nhập", "Giá Bán", "Ngày Nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_SanPhamCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SanPhamCTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_SanPhamCT);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Chi Tiết Sản Phẩm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(72, 72, 72)
                                        .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(cbo_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbo_chatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txt_MaCTVi, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(15, 15, 15)
                                        .addComponent(txt_KhoaVi, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel13))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_NgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSua1)
                                    .addComponent(btnSua)
                                    .addComponent(btnLamMoi)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSua1))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txt_MaCTVi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSua))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnLamMoi))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbo_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbo_chatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel12))
                            .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel8))
                            .addComponent(txt_KhoaVi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel10))
                            .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel11))
                            .addComponent(txt_NgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel13))
                            .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Quản lý màu sắc sản phẩm
//        new MauSacJDiaLog(null, true).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Quản lý chất liệu
//        new ChatLieuJDiaLog(null, true).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        lammoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        // TODO add your handling code here
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnSua1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSua1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSua1MouseClicked

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        // Thêm chi tiết sản phẩm
        this.insert();
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void tbl_SanPhamCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SanPhamCTMouseClicked
        // Click hiện thông tin chi tiết sản phẩm lên form
        // Sản phẩm đã có thông tin chi tiết
        int index = tbl_SanPhamCT.getSelectedRow();
        SanPhamCT_ID sanPhamCT = service.getDaTaSPCT(maVi).get(index);
        txt_MaCTVi.setText(sanPhamCT.getMaCTSP());
        txt_KhoaVi.setText(sanPhamCT.getKhoaSanPham());
        txt_SoLuong.setText(String.valueOf(sanPhamCT.getSoLuongSP()));
        txt_NgayNhap.setDate(Xdate.toDate(sanPhamCT.getNgayNhap(), "yyyy-MM-dd"));
        txt_giaBan.setText(String.valueOf(sanPhamCT.getGiaBanSP()));
        txt_giaNhap.setText(String.valueOf(sanPhamCT.getGiaNhapSP()));
//        cbo_loaiVi.setSelectedItem(sanPhamCT.getTenLoaiSanPham());
        cbo_mauSac.setSelectedItem(sanPhamCT.getTen_MauSac());
        cbo_chatLieu.setSelectedItem(sanPhamCT.getTen_ChatLieu());

        //        txt_MaCTVi.setEnabled(false);
    }//GEN-LAST:event_tbl_SanPhamCTMouseClicked

    private void lammoi() {
        txt_MaCTVi.setText("");
        txt_KhoaVi.setText("");
        txt_NgayNhap.setDateFormatString("");
        txt_SoLuong.setText("");
        txt_giaBan.setText("");
        txt_giaNhap.setText("");
        txt_MaCTVi.setEnabled(true);
    }

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
            java.util.logging.Logger.getLogger(ViewSPCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSPCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSPCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSPCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSPCT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua1;
    private javax.swing.JComboBox<String> cbo_chatLieu;
    private javax.swing.JComboBox<String> cbo_mauSac;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_SanPhamCT;
    private javax.swing.JTextField txt_KhoaVi;
    private javax.swing.JTextField txt_MaCTVi;
    private com.toedter.calendar.JDateChooser txt_NgayNhap;
    private javax.swing.JTextField txt_SoLuong;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_tenSP;
    // End of variables declaration//GEN-END:variables

    private void fillTable(List<SanPhamCT_ID> list) {
        mol = (DefaultTableModel) tbl_SanPhamCT.getModel();
        mol.setRowCount(0);
        for (SanPhamCT_ID x : list) {
            mol.addRow(new Object[]{
                x.getMaCTSP(),
                x.getTen_MauSac(),
                x.getTen_ChatLieu(),
                x.getKhoaSanPham(),
                x.getSoLuongSP(),
                x.getGiaNhapSP(),
                x.getGiaBanSP(),
                x.getNgayNhap()
            });
        }
    }

    private void fillcomboboxMauSac() {
        DefaultComboBoxModel modelMausac = (DefaultComboBoxModel) cbo_mauSac.getModel();
        modelMausac.removeAllElements();
        listMauSac = daoms.selectAll();
        for (MauSac x : listMauSac) {
            modelMausac.addElement(x.getTen_MauSac());
        }
    }

    private void fillcomboboxChatLieu() {
        DefaultComboBoxModel modelChat = (DefaultComboBoxModel) cbo_chatLieu.getModel();
        modelChat.removeAllElements();
        listChatLieu = daocl.selectAll();
        for (ChatLieu x : listChatLieu) {
            modelChat.addElement(x.getTen_ChatLieu());
        }
    }

//    private void fillcomboboxLoaiSanPham() {
//        DefaultComboBoxModel modelChat = (DefaultComboBoxModel) cbo_loaiVi.getModel();
//        modelChat.removeAllElements();
//        listLoaiVi = daolv.selectAll();
//        for (LoaiSanPham lv : listLoaiVi) {
//            modelChat.addElement(lv.getTenLoaiSanPham());
//        }
//    }

    private boolean vadidateNull() {
        List<SanPhamCT_ID> list = service.getDaTaSPCT(maVi);
        String id = txt_MaCTVi.getText();
        String tensp = txt_tenSP.getText();
        Integer soLuong = Integer.parseInt(txt_SoLuong.getText());
        Double giaNhap = Double.parseDouble(txt_giaNhap.getText());
        Double giaBan = Double.parseDouble(txt_giaBan.getText());
        if (txt_MaCTVi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm!");
            txt_MaCTVi.requestFocus();

            return false;
        } else if (txt_KhoaVi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập khóa sản phẩm!");
            return false;
        } else if (txt_SoLuong.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng sản phẩm!");
            return false;
        } else if (txt_giaNhap.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập sản phẩm!");
            return false;
        } else if (txt_giaBan.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá bán sản phẩm!");
            return false;
        } else if (txt_NgayNhap.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày nhập sản phẩm!");
            return false;
        } else if (txt_MaCTVi.getText().length() < 5) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm phải trên 4 kí tự");
            return false;
        } else if (txt_tenSP.getText().length() < 5) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm phải trên 5 kí tự");
            return false;
        } else if (soLuong < 1) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải trên 1 sản phẩm");
            return false;
        } else if (giaNhap < 1) {
            JOptionPane.showMessageDialog(this, "Giá nhập sản phẩm phải trên 0");
            return false;
        } else if (giaBan < 0) {
            JOptionPane.showMessageDialog(this, "Giá bán sản phẩm phải trên 0");
            return false;
        } else if (txt_tenSP.getText().length() < 5) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm phải trên 5 kí tự");
            return false;
        }
        return true;
//return true;
    }

    // Check trùng sản phẩm 
    private boolean VadidateTrungCTSP() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String maCTSP = txt_MaCTVi.getText();
            String khoaVi = txt_KhoaVi.getText();
            String MauSac = (String) cbo_mauSac.getSelectedItem();
            String ChatLieu = (String) cbo_chatLieu.getSelectedItem();
//            String LoaiVi = (String) cbo_loaiVi.getSelectedItem();
            int soLuong = Integer.parseInt(txt_SoLuong.getText());
            String ngayNhap = dateFormat.format(txt_NgayNhap.getDate());
            Double giaNhap = Double.valueOf(txt_giaNhap.getText());
            Double giaBan = Double.valueOf(txt_giaBan.getText());
            for (SanPhamCT_ID x : service.getDaTaSPCT(maVi)) {
                if (maCTSP.equalsIgnoreCase(x.getMaCTSP())
                        & khoaVi.equalsIgnoreCase(x.getKhoaSanPham())
                        & soLuong == x.getSoLuongSP()
                        & ngayNhap.equalsIgnoreCase(x.getNgayNhap())
                        & giaNhap == x.getGiaNhapSP()
                        & giaBan == x.getGiaBanSP()
                        & MauSac.equalsIgnoreCase(x.getTen_MauSac())
                        & ChatLieu.equalsIgnoreCase(x.getTen_ChatLieu()))
//                        & LoaiVi.equalsIgnoreCase(x.getTenLoaiSanPham())) {
                        {
                    JOptionPane.showMessageDialog(this, "Chi tiết sản phẩm đã tồn tại");
                    return false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập đủ thông tin !");
        }
        return true;
    }

    private void insert() {
        if (VadidateTrungCTSP() & vadidateNull()) {
            try {
                int idSP, idMauSac, idChatLieu, idXuatXu, idLoaiVi, soLuong;
                String maCTSP, khoaVi, soNganDungThe, ngayNhap;
                double giaBan, giaNhap;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                idSP = serviceTT.getIDSPbyName(txt_tenSP.getText());
                idMauSac = serviceTT.getIDMauSacbyName((String) cbo_mauSac.getSelectedItem());
                idChatLieu = serviceTT.getIDChatLieubyName((String) cbo_chatLieu.getSelectedItem());
//                idLoaiVi = serviceTT.getIDLoaiSanPhambyName((String) cbo_loaiVi.getSelectedItem());
                maCTSP = txt_MaCTVi.getText();
                khoaVi = txt_KhoaVi.getText();
                ngayNhap = dateFormat.format(txt_NgayNhap.getDate());
                soLuong = Integer.valueOf(txt_SoLuong.getText());
                giaNhap = Double.valueOf(txt_giaNhap.getText());
                giaBan = Double.valueOf(txt_giaBan.getText());
                service.addCTSP(idSP, idMauSac, idChatLieu, maCTSP, ngayNhap, soLuong, giaNhap, giaBan, ngayNhap);
                JOptionPane.showMessageDialog(this, "Thêm chi tiết sản phẩm thành công");
                this.fillTable(service.getDaTaSPCT(maVi));
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin ");
            }

        }

    }

    private void update() {
        int idSP, idMauSac, idChatLieu, idXuatXu, idLoaiVi, soLuong;
        String maCTSP, khoaVi, soNganDungThe, ngayNhap;
        double giaBan, giaNhap;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        idSP = serviceTT.getIDSPbyName(txt_tenSP.getText());
        idMauSac = serviceTT.getIDMauSacbyName((String) cbo_mauSac.getSelectedItem());
        idChatLieu = serviceTT.getIDChatLieubyName((String) cbo_chatLieu.getSelectedItem());
//        idLoaiVi = serviceTT.getIDLoaiSanPhambyName((String) cbo_loaiVi.getSelectedItem());
        maCTSP = txt_MaCTVi.getText();
        khoaVi = txt_KhoaVi.getText();
        ngayNhap = dateFormat.format(txt_NgayNhap.getDate());
        soLuong = Integer.valueOf(txt_SoLuong.getText());
        giaNhap = Double.valueOf(txt_giaNhap.getText());
        giaBan = Double.valueOf(txt_giaBan.getText());
        try {
            if (MsgBox.confirm(this, "Bạn có muốn sửa sản phẩm ?")) {
                service.updateCTSP(idSP, idMauSac, idChatLieu, maCTSP, ngayNhap, soLuong, giaNhap, giaBan, ngayNhap);
                this.fillTable(service.getDaTaSPCT(maVi));
                JOptionPane.showMessageDialog(this, "Đã sửa");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ops! Sửa thất bại");
            e.printStackTrace();
        }
    }

    private SanPhamCT_ID getInformation() {
        SanPhamCT_ID sp = new SanPhamCT_ID();
        sp.setMaCTSP(txt_MaCTVi.getText());
        sp.setGiaBanSP(Double.parseDouble(txt_giaBan.getText()));
        sp.setGiaNhapSP(Double.parseDouble(txt_giaNhap.getText()));
        sp.setSoLuongSP(Integer.parseInt(txt_SoLuong.getText()));
        sp.setKhoaSanPham(txt_KhoaVi.getText());
        sp.setNgayNhap(txt_NgayNhap.getDateFormatString());
        return sp;
    }
}
