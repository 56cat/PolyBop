/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.content;

import dao.DBconnect;
import java.awt.Component;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import repository.HoaDonRepository;
import repository.SanPhamCTSaleRepository;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonCT;
import model.KhachHang;
import model.SanPhamCTSale;
import repository.HoaDonCTRepository;
import repository.Information;
import repository.KhachHangRepo;
import repository.KhuyenMaiSaleRepository;

/**
 *
 * @author Admin
 */
public class BanHangView extends javax.swing.JInternalFrame {

    private KhachHangRepo KHservice = new KhachHangRepo();
    private HoaDonRepository HDservice = new HoaDonRepository();
    private SanPhamCTSaleRepository SPCTservice = new SanPhamCTSaleRepository();
    private HoaDonCTRepository HDCTservice = new HoaDonCTRepository();
    private KhuyenMaiSaleRepository KMservice = new KhuyenMaiSaleRepository();
    Information infor = new Information();
    private DefaultTableModel model = new DefaultTableModel();
    String name, email;
    int indexHD = -1;
    private Component frame;

    public BanHangView() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        this.email = email;
        this.name = name;
        this.fillHD(HDservice.getAll());
        this.fillSPCT(SPCTservice.getData(txtTimKiem.getText().trim()));
        this.fillKhuyenMaicbb();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDonChiTiet = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbMaHoaDon = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        btnHuyHoaDon = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtSDT = new javax.swing.JTextField();
        txtKhachHang = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lbTienSauKhuyenMai = new javax.swing.JLabel();
        cbbPhuongThucThanhToan = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtTienDua = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cbbKhuyenMai = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPhamChiTiet = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        tbHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Tên", "Màu sắc", "Chất liệu", "Số lượng", "Giá bán", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tbHoaDonChiTiet);

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hóa đơn", "Khách hàng", "Nhân viên", "Trạng thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Giỏ hàng");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Sửa số lượng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(249, 249, 249));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Khách hàng:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("SĐT:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Mã hóa đơn:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tổng tiền:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Phương thức thanh toán:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Khuyến mãi:");

        lbMaHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMaHoaDon.setForeground(new java.awt.Color(255, 0, 0));
        lbMaHoaDon.setText("Null");

        lbTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTongTien.setForeground(new java.awt.Color(255, 0, 0));
        lbTongTien.setText("Null");

        btnHuyHoaDon.setText("Hủy hóa đơn");
        btnHuyHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyHoaDonMouseClicked(evt);
            }
        });
        btnHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonActionPerformed(evt);
            }
        });

        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jButton6.setText("Thanh toán");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });

        txtKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhachHangActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Tiền sau khuyến mại:");

        lbTienSauKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTienSauKhuyenMai.setForeground(new java.awt.Color(255, 0, 0));
        lbTienSauKhuyenMai.setText("Null");

        cbbPhuongThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn hình thức", "Chuyển khoản", "Tiền mặt" }));
        cbbPhuongThucThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPhuongThucThanhToanActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Tiền đưa:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Tiền thừa:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Thông tin");

        jButton2.setText("Cập nhật");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbbKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhuyenMaiActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon("G:\\FINAL\\PolyBop\\img\\checked.png")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(lbTienSauKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTienDua, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(txtTienThua)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbbPhuongThucThanhToan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbMaHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbTienSauKhuyenMai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbPhuongThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(cbbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTienDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblSanPhamChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Sản phẩm", "Màu sắc", "Thương hiệu", "Chất liệu", "Số lượng", "Giá bán"
            }
        ));
        tblSanPhamChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamChiTietMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPhamChiTiet);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Danh sách sản phẩm");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel14.setText("Tìm kiếm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Thẻ thanh toán");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jButton1)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11))))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        indexHD = tblHoaDon.getSelectedRow();
        if (indexHD < -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }
        cbbPhuongThucThanhToan.setSelectedIndex(0);
        int idHoaDon = (Integer) this.tblHoaDon.getValueAt(indexHD, 0);
        this.fillHDCT(HDCTservice.getHDCT(idHoaDon));
        this.showInfor();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.updateSoLuong();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.removeSPCTinHDCT();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnHuyHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyHoaDonMouseClicked
        this.deleteHoaDon();
    }//GEN-LAST:event_btnHuyHoaDonMouseClicked

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        this.createBill();
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.thanhToan();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased

    }//GEN-LAST:event_txtSDTKeyReleased

    private void txtKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhachHangActionPerformed

    private void cbbPhuongThucThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPhuongThucThanhToanActionPerformed
        this.choicePayMents();
    }//GEN-LAST:event_cbbPhuongThucThanhToanActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.showKHbySDT();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblSanPhamChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamChiTietMouseClicked
        this.SPCTinHDCT();
    }//GEN-LAST:event_tblSanPhamChiTietMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        String key = txtTimKiem.getText().trim();
        this.fillSPCT(SPCTservice.getData(key));
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cbbKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiActionPerformed

    }//GEN-LAST:event_cbbKhuyenMaiActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       this.apDungKhuyenMai();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JComboBox<String> cbbKhuyenMai;
    private javax.swing.JComboBox<String> cbbPhuongThucThanhToan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbMaHoaDon;
    private javax.swing.JLabel lbTienSauKhuyenMai;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tbHoaDonChiTiet;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPhamChiTiet;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTienDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void createBill() {
        int count = tblHoaDon.getRowCount();
        if (count <= 10) {
            HDservice.taoHoaDon(infor.getIDNVByEmail(email));
            this.fillHD(HDservice.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Số lượng hóa đơn không được quá 10 ! ");
        }
    }

    private void deleteHoaDon() {
        int selectedRow = tblHoaDon.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn để xóa.");
            return;
        }
        int idHoaDon = (int) tblHoaDon.getValueAt(selectedRow, 0);

        boolean isDeleted = deleteBillFromDatabase(idHoaDon);

        if (isDeleted) {
            ((DefaultTableModel) tblHoaDon.getModel()).removeRow(selectedRow);

            this.fillHDCT(HDCTservice.getHDCT(idHoaDon));
            this.fillSPCT(SPCTservice.getData(txtTimKiem.getText()));
            lbMaHoaDon.setText("HD");
            cbbKhuyenMai.setSelectedItem("Chọn khuyến mãi");
            lbTienSauKhuyenMai.setText("0");

            BigDecimal tongTien = HDCTservice.getTongTienHDCT(idHoaDon);
            if (tongTien != null) {
                lbTongTien.setText(tongTien.toString());
            } else {
                lbTongTien.setText(BigDecimal.ZERO.toString());
            }
            JOptionPane.showMessageDialog(this, "Đã xóa hóa đơn thành công.");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa hóa đơn.");
        }
    }

    private boolean deleteBillFromDatabase(int idHoaDon) {
        String deleteDetailsSql = "DELETE FROM HoaDonChiTiet WHERE ID_HoaDon = ?";
        String deleteBillSql = "DELETE FROM HoaDon WHERE IDHoaDon = ?";

        try (Connection con = DBconnect.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement(deleteDetailsSql)) {
                ps.setInt(1, idHoaDon);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = con.prepareStatement(deleteBillSql)) {
                ps.setInt(1, idHoaDon);
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void fillHD(List<HoaDon> lists) {
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        for (HoaDon item : lists) {
            model.addRow(new Object[]{
                item.getIdHoaDon(),
                item.getTenNV(),
                item.getTenKH(),
                item.isTrangThai() ? "Ðã thanh toán" : "Chờ thanh toán",
                item.getThanhTien()
            });
        }
    }

    private void fillSPCT(List<SanPhamCTSale> lists) {
        model = (DefaultTableModel) tblSanPhamChiTiet.getModel();
        model.setRowCount(0);
        for (SanPhamCTSale item : lists) {
            model.addRow(new Object[]{
                item.getMaSPCT(),
                item.getTenSanPham(),
                item.getTenMauSac(),
                item.getTenThuongHieu(),
                item.getTenChatLieu(),
                item.getSoLuong(),
                item.getGiaBan()
            });
        }
    }

    private void fillHDCT(List<HoaDonCT> lists) {
        model = (DefaultTableModel) tbHoaDonChiTiet.getModel();
        model.setRowCount(0);
        for (HoaDonCT item : lists) {
            model.addRow(new Object[]{
                item.getIdHoaDonChiTiet(),
                item.getTenSanPham(),
                item.getTenMauSac(),
                item.getTenChatLieu(),
                item.getSoLuong(),
                item.getGiaBan(),
                item.getDonGia()
            });
        }
    }

    private void choicePayMents() {
        int indexHD = tblHoaDon.getSelectedRow();
        if (indexHD == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn để thực hiện hành động.");
            return;
        }

        String selected = (String) cbbPhuongThucThanhToan.getSelectedItem();
        int phuongThucThanhToan = -1;

        switch (selected) {
            case "Chuyển khoản":
                phuongThucThanhToan = 1;
                break;
            case "Tiền mặt":
                phuongThucThanhToan = 0;
                break;
        }

        int idHoaDon = (Integer) tblHoaDon.getValueAt(indexHD, 0);
        HDservice.capNhatPTTT(idHoaDon, phuongThucThanhToan);

        if (phuongThucThanhToan == 1) {
            txtTienDua.setEnabled(false);
            txtTienThua.setEnabled(false);
            txtTienDua.setText("");
            txtTienThua.setText("");
        } else if (phuongThucThanhToan == 0) {
            txtTienDua.setEnabled(true);
            txtTienThua.setEnabled(true);
        }
    }

    private void showKHbySDT() {
        String phone = txtSDT.getText();
        boolean found = false;
        KhachHang foundKhachHang = null;

        for (KhachHang item : KHservice.findAll()) {
            if (phone.equalsIgnoreCase(item.getSDT())) {
                txtKhachHang.setText(item.getTenKhachHang());
                foundKhachHang = item;
                found = true;
                break;
            }
        }

        if (found && foundKhachHang != null) {
            int idHoaDon = getSelectedHoaDonId();
            if (idHoaDon != -1) {
                boolean updateSuccess = HDservice.capNhatKHonHoaDon(idHoaDon, foundKhachHang.getIDKhachHang());
                if (updateSuccess) {
                    JOptionPane.showMessageDialog(this, "Cập nhật khách hàng vào hóa đơn thành công!");
                    this.fillHD(HDservice.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật khách hàng vào hóa đơn thất bại!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không có hóa đơn nào được chọn.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng với số điện thoại đã nhập.");
        }
    }

    private int getSelectedHoaDonId() {
        int selectedRow = tblHoaDon.getSelectedRow();
        if (selectedRow != -1) {
            return (Integer) tblHoaDon.getValueAt(selectedRow, 0);
        }
        return -1;
    }

    private void showInfor() {
        int index = tblHoaDon.getSelectedRow();
        HoaDon hd = HDservice.getAll().get(index);
        txtKhachHang.setText(hd.getTenKH());
        lbMaHoaDon.setText(String.valueOf(hd.getMaHoaDon()));
        if (index >= 0) {
            int idHoaDon = (Integer) tblHoaDon.getValueAt(index, 0);

            HoaDon hoaDon = HDservice.getHoaDonById(idHoaDon);

            if (hoaDon != null) {
                BigDecimal thanhTien = hd.getThanhTien();

                if (thanhTien != null) {
                    lbTongTien.setText(thanhTien.toString());
                } else {
                    lbTongTien.setText("0");
                }
            } else {
                lbTongTien.setText("Không tìm thấy hóa đơn");
            }
        }
        lbTienSauKhuyenMai.setText(hd.getTienSauGiamGia().toString());
    }

    private void updateTable() {
        List<HoaDon> dsHoaDon = HDservice.getAll();
        fillHD(dsHoaDon);
    }

    private void SPCTinHDCT() {
        int indexSPCT = tblSanPhamChiTiet.getSelectedRow();
        SanPhamCTSale spct = SPCTservice.getData(txtTimKiem.getText()).get(indexSPCT);
        String maSPCT = spct.getMaSPCT();

        if (indexHD < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn kìa!");
        } else {
            String inputSoLuong = JOptionPane.showInputDialog("Nhập số lượng");
            if (String.valueOf(inputSoLuong).trim().isEmpty()) {
                return;
            }
            try {
                int idSPCT = infor.getIDSPCTByMa(maSPCT);
                int idHD = (Integer) tblHoaDon.getValueAt(indexHD, 0);
                int soLuongSanPhamTonKho = (Integer) tblSanPhamChiTiet.getValueAt(indexSPCT, 5);
                int soLuongSanPham = Integer.valueOf(inputSoLuong);
                BigDecimal donGia = (BigDecimal) tblSanPhamChiTiet.getValueAt(indexSPCT, 6);
                BigDecimal thanhTien = donGia.multiply(BigDecimal.valueOf(soLuongSanPham));
                if (soLuongSanPham < 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                } else if (soLuongSanPham > soLuongSanPhamTonKho) {
                    JOptionPane.showMessageDialog(this, "Số lượng vượt quá số lượng tồn kho");
                } else {
                    int checkSPCT = 0;
                    for (HoaDonCT item : HDCTservice.getHDCT(idHD)) {
                        if (idSPCT == item.getIdChiTietSanPham()) {
                            int soLuongSP = HDCTservice.getSoLuongSP(idSPCT, idHD) + soLuongSanPham;
                            BigDecimal sum = donGia.multiply(BigDecimal.valueOf(Double.valueOf(soLuongSP)));
                            HDCTservice.suaHDCT(idSPCT, idHD, soLuongSP, sum);
                            HDservice.capNhatTongHoaDon(idHD, HDCTservice.getTongTienHDCT(idHD));
                            updateTable();
                            this.fillHDCT(HDCTservice.getHDCT(idHD));
                            this.fillSPCT(SPCTservice.getData(txtTimKiem.getText()));
                            lbTongTien.setText(HDCTservice.getTongTienHDCT(idHD).toString());
                            checkSPCT = 1;
                        }
                    }
                    if (checkSPCT == 0) {
                        this.HDCTservice.themHDCT(idHD, idSPCT, soLuongSanPham, thanhTien);
                        this.HDservice.capNhatTongHoaDon(idHD, HDCTservice.getTongTienHDCT(idHD));
                        updateTable();
                        this.fillHDCT(HDCTservice.getHDCT(idHD));
                        this.fillSPCT(SPCTservice.getData(txtTimKiem.getText()));
                        lbTongTien.setText(HDCTservice.getTongTienHDCT(idHD).toString());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateSoLuong() {
        int indexHDCT = -1;
        indexHDCT = tbHoaDonChiTiet.getSelectedRow();
        if (indexHDCT < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần sửa");
        } else {
            try {
                int indexHD = tblHoaDon.getSelectedRow();
                int idHD = (Integer) tblHoaDon.getValueAt(indexHD, 0);
                HoaDonCT hdct = HDCTservice.getHDCT(idHD).get(indexHDCT);
                int idSPCT = hdct.getIdChiTietSanPham();
                int soLuongSPCTHD = hdct.getSoLuong();
                int soLuongTonKho = infor.getSoLuongTonKho(idSPCT) + soLuongSPCTHD;
                BigDecimal donGiaSP = hdct.getGiaBan();

                String inputSoLuong = JOptionPane.showInputDialog("Nhập số lượng muốn thêm:");
                if (String.valueOf(inputSoLuong).trim().isEmpty()) {
                    return;
                }

                int soLuongCapNhat = Integer.valueOf(inputSoLuong);

                if (soLuongCapNhat < 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng phỉa lớn hơn 0");
                } else if (soLuongCapNhat > soLuongTonKho) {
                    JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không đủ");
                } else {
                    BigDecimal sum = donGiaSP.multiply(BigDecimal.valueOf(Double.valueOf(soLuongCapNhat)));
                    this.HDCTservice.suaHDCT(idSPCT, idHD, soLuongCapNhat, sum);
                    this.HDservice.capNhatTongHoaDon(idHD, HDCTservice.getTongTienHDCT(idHD));
                    this.fillHDCT(HDCTservice.getHDCT(idHD));
                    this.fillSPCT(SPCTservice.getData(txtTimKiem.getText()));
                    lbTongTien.setText(HDCTservice.getTongTienHDCT(idHD).toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
            }
        }
    }

    private void removeSPCTinHDCT() {
        int indexHDCT = -1;
        indexHDCT = tbHoaDonChiTiet.getSelectedRow();
        int indexHoaDon = tblHoaDon.getSelectedRow();

        if (indexHDCT < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa");
        } else {
            int confirmDelete = JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn xóa chứ ?", "Có", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmDelete == JOptionPane.YES_OPTION) {
                int idHDCT = (Integer) tbHoaDonChiTiet.getValueAt(indexHDCT, 0);
                int idHD = (Integer) tblHoaDon.getValueAt(indexHoaDon, 0);
                this.HDCTservice.xoaHDCT(idHDCT);
                this.HDservice.capNhatTongHoaDon(idHD, HDCTservice.getTongTienHDCT(idHD));
                this.fillHDCT(HDCTservice.getHDCT(idHD));
                this.fillSPCT(SPCTservice.getData(txtTimKiem.getText()));
                BigDecimal tongTienHDCT = HDCTservice.getTongTienHDCT(idHD);

                if (tongTienHDCT != null) {
                    this.HDservice.capNhatTongHoaDon(idHD, tongTienHDCT);
                    lbTongTien.setText(tongTienHDCT.toString());
                } else {
                    lbTongTien.setText("0");
                }
            }
        }
    }

    private void thanhToan() {
        String phuongThucThanhToan = (String) cbbPhuongThucThanhToan.getSelectedItem();
         BigDecimal tienSauGiamGia = new BigDecimal(lbTienSauKhuyenMai.getText());
        if ("Chọn hình thức".equals(phuongThucThanhToan)) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phương thức thanh toán.");
            return;
        }
        try {
            int indexHD = tblHoaDon.getSelectedRow();
            if (indexHD < 0) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn!");
                return;
            }

            int idHD = (Integer) tblHoaDon.getValueAt(indexHD, 0);

            for (HoaDonCT item : HDCTservice.getHDCT(idHD)) {
                int idSPCT = item.getIdChiTietSanPham();
                int soLuongBan = item.getSoLuong();
                int soLuongTonKhoHienTai = infor.getSoLuongTonKho(idSPCT);
                int soLuongMoi = soLuongTonKhoHienTai - soLuongBan;

                SPCTservice.suaSLSPCT(idSPCT, soLuongMoi);
            }

            HDservice.capNhatTrangThai(idHD, "1");
            HDservice.capNhatTongHoaDon(idHD, tienSauGiamGia);
            reset();
            JOptionPane.showMessageDialog(this, "Giao dịch hoàn tất thành công!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra trong quá trình hoàn tất giao dịch.");
        }
    }

    private void reset() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        tblHoaDon.clearSelection();
        tblSanPhamChiTiet.clearSelection();
        lbTongTien.setText("0");
        lbMaHoaDon.setText("HD");
        txtKhachHang.setText("");
        lbTienSauKhuyenMai.setText("0");
        cbbKhuyenMai.setSelectedItem("Chọn khuyến mãi");
        cbbPhuongThucThanhToan.setSelectedItem("Chọn hình thức");
        fillHDCT(new ArrayList<>());
        fillSPCT(SPCTservice.getData(txtTimKiem.getText()));
    }

    private void fillKhuyenMaicbb() {
        cbbKhuyenMai.removeAllItems();
        
        cbbKhuyenMai.addItem("Chọn khuyến mãi");

        List<String> khuyenMai = KMservice.getAllKhuyenMai();
        for (String km : khuyenMai) {
            cbbKhuyenMai.addItem(km);
        }
    }
    
    private void apDungKhuyenMai(){
        String selectedKM = (String) cbbKhuyenMai.getSelectedItem();
        
        
        if (indexHD < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn kìa!");
            return;
        } else if ("Chọn khuyến mãi".equals(selectedKM)) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khuyến mãi");
            return;
        }
       
        BigDecimal giaTriKM = KMservice.getGiaTriKM(selectedKM);
        
        BigDecimal tongTien = new BigDecimal(lbTongTien.getText());
        
        BigDecimal tienSauKhuyenMai = tongTien.subtract(giaTriKM);
        
        lbTienSauKhuyenMai.setText(tienSauKhuyenMai.toString());
    }
}
