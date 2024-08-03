/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.content;

import repository.KhuyenMaiDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.KhuyenMai;
import dao.DBconnect;
import javax.swing.ButtonGroup;

/**
 *
 * @author Admin
 */
public class KhuyenMaiView extends javax.swing.JInternalFrame {

    /**
     * Creates new form KhuyenMaiView
     */
    private DefaultTableModel tableModel = new DefaultTableModel();
    private KhuyenMaiDao kms = new KhuyenMaiDao();
    private int index = -1;

    /**
     * Creates new form Main
     */
    public KhuyenMaiView() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        this.fillTable(kms.getAll());
    }

    void fillTable(List<KhuyenMai> list) {
        tableModel = (DefaultTableModel) tblKhuyenMai.getModel();
        tableModel.setRowCount(0);
        for (KhuyenMai x : list) {
            tableModel.addRow(x.toDataRow());
        }
    }

    public void showData(int index) {
        index = tblKhuyenMai.getSelectedRow();
        txtMa.setText(tblKhuyenMai.getValueAt(index, 1).toString());
        txtGiaTri.setText(tblKhuyenMai.getValueAt(index, 2).toString());
        txtBatDau.setDate((Date) tblKhuyenMai.getValueAt(index, 3));
        txtKetThuc.setDate((Date) tblKhuyenMai.getValueAt(index, 4));
        if (tblKhuyenMai.getValueAt(index, 5).toString().equalsIgnoreCase("Còn hoạt động")) {
            rdoHoatDong.setSelected(true);
        } else {
            rdoKhongHoatDong.setSelected(true);
        }
    }

    KhuyenMai readForm() {
        String ma;
        Date ngayDB, ngayKT;
        int GiaTri;
        boolean TrangThai;

        ma = txtMa.getText().trim();
        ngayDB = txtBatDau.getDate();
        java.util.Date startDate = ngayDB;
        java.sql.Date sqlDate = new java.sql.Date(startDate.getTime());
        ngayKT = txtKetThuc.getDate();
        java.util.Date endDate = ngayKT;
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
        GiaTri = Integer.parseInt(txtGiaTri.getText().trim());
        if (rdoHoatDong.isSelected()) {
            TrangThai = true;
        } else {
            TrangThai = false;
        }
        return new KhuyenMai(ma, GiaTri, ngayKT, ngayKT, TrangThai);
    }

    private boolean isMaStringDuplicate(String maKhuyenMai) {
        String sql = "SELECT COUNT(*) FROM KhuyenMai WHERE Ma_KhuyenMai = ?";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, maKhuyenMai);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean check() {
        if (txtMa.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khuyến mại!");
            return false;
        }
        if (isMaStringDuplicate(txtMa.getText())) {
            JOptionPane.showMessageDialog(this, "Mã khuyến mại đã tồn tại!");
            return false;
        }
        if (txtBatDau.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu!");
            return false;
        }
        if (txtKetThuc.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày kết thúc!");
            return false;
        }
        java.util.Date ngayDB = txtBatDau.getDate();
        java.util.Date ngayKT = txtKetThuc.getDate();
        if (ngayDB != null && ngayKT != null) {
            java.sql.Date sqlStartDate = new java.sql.Date(ngayDB.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(ngayKT.getTime());
            if (sqlStartDate.after(sqlEndDate)) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải trước ngày kết thúc!");
                return false;
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false);
                try {
                    sdf.parse(ngayDB.toString());
                    sdf.parse(ngayKT.toString());
                    JOptionPane.showMessageDialog(this, "Ngày bắt đầu và ngày kết thúc hợp lệ!");
                } catch (ParseException e) {

                }
            }
        }
        if (txtGiaTri.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị của khuyến mại!");
            return false;
        }
        try {
            int giaTri = Integer.valueOf(txtGiaTri.getText());
            if (giaTri < 0) {
                JOptionPane.showConfirmDialog(this, "Giá tị phải lớn hơn 0!");
                return false;
            }
            if (giaTri > 100) {
                JOptionPane.showMessageDialog(this, "Giá trị phải <= 100 !");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá phải là số!");
            return false;
        }
        if (!rdoHoatDong.isSelected() && !rdoKhongHoatDong.isSelected()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn trạng thái khuyến mại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean checkUpdate() {
        if (txtMa.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khuyến mại!");
            return false;
        }
        if (txtBatDau.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu!");
            return false;
        }
        if (txtKetThuc.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày kết thúc!");
            return false;
        }
        java.util.Date ngayBD = txtBatDau.getDate();
        java.util.Date ngayKT = txtKetThuc.getDate();
        if (ngayBD != null && ngayKT != null) {
            java.sql.Date sqlStartDate = new java.sql.Date(ngayBD.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(ngayKT.getTime());
            if (sqlStartDate.after(sqlEndDate)) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải trước ngày kết thúc!");
                return false;
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false);
                try {
                    sdf.parse(ngayBD.toString());
                    sdf.parse(ngayKT.toString());
                    JOptionPane.showMessageDialog(this, "Ngày bắt đầu và ngày kết thúc không hợp lệ!");
                } catch (ParseException e) {

                }
            }
        }
        if (txtGiaTri.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị của khuyến mại!");
            return false;
        }
        try {
            int giaTri = Integer.valueOf(txtGiaTri.getText());
            if (giaTri < 0) {
                JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 0!");
                return false;
            } else if (giaTri > 100) {
                JOptionPane.showMessageDialog(this, "Giá phải <= 100!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showConfirmDialog(this, "Giá phải là số!");
            return false;
        }
        if (!rdoHoatDong.isSelected() && !rdoKhongHoatDong.isSelected()) {
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn trạng thái khuyến mại.", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        btnTimKhuyenMai = new javax.swing.JButton();
        txtSreach = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbbLocKhuyenMai = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtBatDau = new com.toedter.calendar.JDateChooser();
        txtKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        rdoKhongHoatDong = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdoHoatDong = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        btnTaoKhuyenMai = new javax.swing.JButton();
        btnSuaKhuyenMai = new javax.swing.JButton();
        btnXoaKhuyenMai = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã khuyến mại", "Giá trị", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ));
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);

        btnTimKhuyenMai.setText("Tìm khuyến mại");
        btnTimKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKhuyenMaiActionPerformed(evt);
            }
        });

        jLabel6.setText("Lọc khuyến mại");

        cbbLocKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hoạt động", "Không hoạt động" }));
        cbbLocKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocKhuyenMaiActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Quản lý khuyến mại");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Ngày kết thúc");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Mã khuyến mại");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Ngày bắt đầu");

        rdoKhongHoatDong.setText("Không hoạt động");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Trạng thái");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Giá trị");

        rdoHoatDong.setText("Còn hoạt động");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        btnTaoKhuyenMai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTaoKhuyenMai.setForeground(new java.awt.Color(255, 51, 0));
        btnTaoKhuyenMai.setText("Thêm");
        btnTaoKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoKhuyenMaiActionPerformed(evt);
            }
        });

        btnSuaKhuyenMai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSuaKhuyenMai.setForeground(new java.awt.Color(204, 0, 0));
        btnSuaKhuyenMai.setText("Sửa");
        btnSuaKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKhuyenMaiActionPerformed(evt);
            }
        });

        btnXoaKhuyenMai.setForeground(new java.awt.Color(255, 51, 0));
        btnXoaKhuyenMai.setText("Xoa");
        btnXoaKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhuyenMaiActionPerformed(evt);
            }
        });

        btnLamMoi.setForeground(new java.awt.Color(204, 0, 0));
        btnLamMoi.setText("Clear");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTaoKhuyenMai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnTaoKhuyenMai)
                .addGap(18, 18, 18)
                .addComponent(btnSuaKhuyenMai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaKhuyenMai)
                .addGap(26, 26, 26)
                .addComponent(btnLamMoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtKetThuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBatDau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(rdoHoatDong)
                                    .addGap(39, 39, 39)
                                    .addComponent(rdoKhongHoatDong))
                                .addComponent(txtGiaTri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(btnTimKhuyenMai)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSreach, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(cbbLocKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(280, 280, 280))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addGap(14, 14, 14)
                            .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoHoatDong)
                                .addComponent(rdoKhongHoatDong)))))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKhuyenMai)
                    .addComponent(txtSreach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbbLocKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        index = tblKhuyenMai.getSelectedRow();
        if (index > -1) {
            this.showData(index);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void btnTimKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKhuyenMaiActionPerformed
        // TODO add your handling code here:
        String ma = txtSreach.getText();
        List<KhuyenMai> listl;
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã cần tìm !");
            listl = kms.getAll();
        } else {
            tableModel.setRowCount(0);
            listl = kms.searchKM(ma);
        }
        for (KhuyenMai sv : listl) {
            tableModel.addRow(sv.toDataRow());
        }
    }//GEN-LAST:event_btnTimKhuyenMaiActionPerformed

    private void cbbLocKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocKhuyenMaiActionPerformed
        // TODO add your handling code here:
        String select = ((String) cbbLocKhuyenMai.getSelectedItem());
        String hd;
        if (select.equals("Còn hoạt động")) {
            hd = "1";
        } else {
            hd = "0";
        }
        List<KhuyenMai> list = kms.locTT(hd);
        this.fillTable(list);
    }//GEN-LAST:event_cbbLocKhuyenMaiActionPerformed

    private void btnTaoKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoKhuyenMaiActionPerformed
        int chon;
        chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm không ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (chon != JOptionPane.YES_OPTION) {
            return;
        } else {
            if (check()) {
                if (check()) {
                    if (kms.addKhuyenMai(this.readForm()) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công!");
                        this.fillTable(kms.getAll());
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnTaoKhuyenMaiActionPerformed

    private void btnSuaKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKhuyenMaiActionPerformed
        // TODO add your handling code here:
        index = tblKhuyenMai.getSelectedRow();
        String ma;
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để sửa!");
        } else {
            int chon;
            chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (chon != JOptionPane.YES_OPTION) {
                return;
            } else {
                if (checkUpdate()) {
                    ma = tblKhuyenMai.getValueAt(index, 1).toString();
                    String maHienTai = txtMa.getText();
                    if (!ma.equals(maHienTai)) {
                        JOptionPane.showMessageDialog(this, "Không thể thảy đổi mã!");
                        return;
                    }
                    if (kms.updateKM(ma, this.readForm()) > 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công!");
                        this.fillTable(kms.getAll());
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại !");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSuaKhuyenMaiActionPerformed

    private void btnXoaKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhuyenMaiActionPerformed
        index = tblKhuyenMai.getSelectedRow();
        String ma;
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chọn dòng để xóa!");
            return;
        }
        int chon;
        chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không ?", "Xác nhận!", JOptionPane.YES_NO_OPTION);
        if (chon != JOptionPane.YES_OPTION) {
            return;
        } else {
            ma = tblKhuyenMai.getValueAt(index, 1).toString();
            if (kms.deleteKM(ma) > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                this.fillTable(kms.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        }
    }//GEN-LAST:event_btnXoaKhuyenMaiActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtMa.setText(null);
        txtBatDau.setDate(null);
        txtKetThuc.setDate(null);
        txtGiaTri.setText(null);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdoHoatDong);
        buttonGroup.add(rdoKhongHoatDong);
        buttonGroup.clearSelection();
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaKhuyenMai;
    private javax.swing.JButton btnTaoKhuyenMai;
    private javax.swing.JButton btnTimKhuyenMai;
    private javax.swing.JButton btnXoaKhuyenMai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbLocKhuyenMai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JRadioButton rdoKhongHoatDong;
    private javax.swing.JTable tblKhuyenMai;
    private com.toedter.calendar.JDateChooser txtBatDau;
    private javax.swing.JTextField txtGiaTri;
    private com.toedter.calendar.JDateChooser txtKetThuc;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSreach;
    // End of variables declaration//GEN-END:variables
}
