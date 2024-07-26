package view.content;

import controller.LoaiSanPhamRepository;
import controller.MsgBox;
import controller.SanPhamRepository;
import controller.ThuongHieuRepository;
import controller.Ximages;
import java.io.File;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.LoaiSanPham;
import model.SanPham;
import model.ThuongHieu;
import repository.SanPhamDAO;

public class SanPhamView extends javax.swing.JInternalFrame {

    Locale vn = new Locale("vi", "VN");
    SanPhamRepository dao_vi = new SanPhamRepository();
    ThuongHieuRepository dao_th = new ThuongHieuRepository();
    LoaiSanPhamRepository dao_lsp = new LoaiSanPhamRepository();
    int row = -1;
    DefaultTableModel modelCH = new DefaultTableModel();
    DefaultTableModel modelHH = new DefaultTableModel();
    List<ThuongHieu> list_TH;
    List<LoaiSanPham> list_LSP;

    public SanPhamView() {
        initComponents();
        init();
        modelCH = (DefaultTableModel) tblConhang.getModel();
        filltotablech();
        modelHH = (DefaultTableModel) tblHetHang.getModel();
        filltotablehh();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
    }

    private void init() {
        fillcomboboxThuonghieu();
        fillComboboxLoaiSanPham();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        txtKieuDang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxThuongHieu = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdo = new javax.swing.JRadioButton();
        rdo1 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblConhang = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHetHang = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        txtTenVi = new javax.swing.JTextField();
        txtMaVi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnThem1 = new javax.swing.JButton();
        cbxLoaiSanPham = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        lblHinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );

        txtKieuDang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtKieuDang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKieuDangActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tên Sản Phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Kiểu Dáng");

        cbxThuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxThuongHieuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Thương Hiệu");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Trạng Thái");

        buttonGroup1.add(rdo);
        rdo.setText("Hết Hàng");
        rdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo1);
        rdo1.setSelected(true);
        rdo1.setText("Còn Hàng");
        rdo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo1ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Tìm kiếm(Tên hoặc Mã)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLammoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLammoi.setText("Làm mới");
        btnLammoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLammoiMouseClicked(evt);
            }
        });
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblConhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Thương Hiệu", "Loại Sản Phẩm", "Kiểu Dáng", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblConhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConhangtblSanPham1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblConhang);

        jPanel11.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 920, 240));

        jTabbedPane1.addTab("Sản Phẩm Còn Hàng", jPanel11);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red));
        jPanel8.setPreferredSize(new java.awt.Dimension(1013, 200));

        tblHetHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Thương Hiệu", "Loại Sản Phẩm", "Kiểu Dáng", "Trạng Thái"
            }
        ));
        tblHetHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHetHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHetHang);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm Hết Hàng", jPanel8);

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtTenVi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTenVi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTenVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenViActionPerformed(evt);
            }
        });

        txtMaVi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMaVi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMaVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaViActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Mã Sản Phẩm");

        btnThem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem1.setText("Chi Tiết Sản Phẩm");
        btnThem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThem1MouseClicked(evt);
            }
        });
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        cbxLoaiSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLoaiSanPhamActionPerformed(evt);
            }
        });

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Loại Sản Phẩm");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("|<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("<<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText(">>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText(">|");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaVi, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(rdo1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdo))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenVi, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(cbxLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(cbxThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnLammoi)
                                    .addComponent(jButton1))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(btnThem1))))))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 101, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaVi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdo1)
                                            .addComponent(rdo)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtTenVi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(22, 22, 22)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
//        chooseImages();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseClicked

    private void txtKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKieuDangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKieuDangActionPerformed

    private void cbxThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxThuongHieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxThuongHieuActionPerformed

    private void rdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoActionPerformed

    private void rdo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo1ActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        this.update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLammoiMouseClicked
        // TODO add your handling code here:
        this.clearForm();
    }//GEN-LAST:event_btnLammoiMouseClicked

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        this.insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblConhangtblSanPham1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConhangtblSanPham1MouseClicked
        try {
            row = tblConhang.getSelectedRow();
            edit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblConhangtblSanPham1MouseClicked

    private void tblHetHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHetHangMouseClicked
        // TODO add your handling code here:
        try {
            row = tblHetHang.getSelectedRow();
            edithh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblHetHangMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtTenViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenViActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenViActionPerformed

    private void txtMaViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaViActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaViActionPerformed

    private void btnThem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThem1MouseClicked

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        //  chi tiết ví
        // Hiện thông tin chi tiết của sản phẩm
        try {
            if (row >= 0) {
                ViewSPCT spct = new ViewSPCT(txtMaVi.getText(), txtTenVi.getText());
                spct.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn xem !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void cbxLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLoaiSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLoaiSanPhamActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        row = 0;
        if (jTabbedPane1.getSelectedIndex() == 0) {
            tblConhang.setRowSelectionInterval(row, row);
            edit();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (jTabbedPane1.getSelectedIndex() == 0) {
            if (row > 0) {
                row--;
                tblConhang.setRowSelectionInterval(row, row);
                edit();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (jTabbedPane1.getSelectedIndex() == 0) {
            if (row < tblConhang.getRowCount() - 1) {
                row++;
                tblConhang.setRowSelectionInterval(row, row);
                edit();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTabbedPane1.getSelectedIndex() == 0) {
            row = tblConhang.getRowCount() - 1;

            tblConhang.setRowSelectionInterval(row, row);
            edit();
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxLoaiSanPham;
    private javax.swing.JComboBox<String> cbxThuongHieu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JRadioButton rdo;
    private javax.swing.JRadioButton rdo1;
    private javax.swing.JTable tblConhang;
    private javax.swing.JTable tblHetHang;
    private javax.swing.JTextField txtKieuDang;
    private javax.swing.JTextField txtMaVi;
    private javax.swing.JTextField txtTenVi;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
 private void filltotablech() {
        modelCH.setRowCount(0);
        try {
            List<SanPham> list = dao_vi.findAllData();
            for (SanPham x : list) {
                modelCH.addRow(new Object[]{
                    //                    x.getIDVi(),
                    x.getMaSanPham(),
                    x.getTenSanPham(),
                    dao_th.selectNameByID(x.getIdThuongHieu()),
                    dao_lsp.selecNameById(x.getIdLoaiSanPham()),
                    x.getKieuDang(),
                    x.isTrangThai() ? "Còn Hàng" : "Hết Hàng"
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void filltotablehh() {
        modelHH.setRowCount(0);
        try {
            List<SanPham> list = dao_vi.select_TrangThai();
            for (SanPham x : list) {
                modelHH.addRow(new Object[]{
                    //                    x.getIDVi(),
                    x.getMaSanPham(),
                    x.getTenSanPham(),
                    dao_th.selectNameByID(x.getIdThuongHieu()),
                    dao_lsp.selecNameById(x.getIdLoaiSanPham()),
                    x.getKieuDang(),
                    x.isTrangThai() ? "Còn Hàng" : "Hết Hàng"
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Combox Thương Hiệu
    private void fillcomboboxThuonghieu() {
        DefaultComboBoxModel modelcbo = (DefaultComboBoxModel) cbxThuongHieu.getModel();
        modelcbo.removeAllElements();
        list_TH = dao_th.selectAll();
        for (ThuongHieu th : list_TH) {
            modelcbo.addElement(th.getTen_ThuongHieu());
        }
    }

//    Combox Loại sản phẩm
    private void fillComboboxLoaiSanPham() {
        DefaultComboBoxModel<String> modelcbo = (DefaultComboBoxModel<String>) cbxLoaiSanPham.getModel();
        modelcbo.removeAllElements();
        list_LSP = dao_lsp.selectAll();  // Lấy danh sách loại sản phẩm từ cơ sở dữ liệu
        for (LoaiSanPham lsp : list_LSP) {
            modelcbo.addElement(lsp.getTenLoaiSanPham());  // Thêm tên loại sản phẩm vào model của combobox
        }
    }

    private void chooseImages() {
        JFileChooser file = new JFileChooser("C:\\Users\\trang\\Desktop\\PoLyBop_01\\logos");
        if (file.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File filechoser = file.getSelectedFile();
            Ximages.save(filechoser);
            ImageIcon icon = Ximages.read(filechoser.getName());
            lblHinh.setIcon(icon);
            lblHinh.setToolTipText(filechoser.getName());
        }
    }

    private SanPham getInformation() {
//        SanPham sp = new SanPham();
//        sp.setMaSanPham(txtMaVi.getText());
//        sp.setTenSanPham(txtTenVi.getText());
//        sp.setKieuDang(txtKieuDang.getText());
//        sp.setIdThuongHieu(dao_th.selectIdByName(cbxThuongHieu.getSelectedItem() + ""));
//        sp.setIdLoaiSanPham(dao_th.selectIdByName(cbxLoaiSanPham.getSelectedItem() + ""));
//        sp.setTrangThai(rdo1.isSelected());
//        sp.setUrl_Anh(lblHinh.getToolTipText());
//        System.out.println(sp.getTenSanPham());
//        System.out.println(sp.getUrl_Anh());
//        return sp;
        SanPham sp = new SanPham();
        sp.setMaSanPham(txtMaVi.getText());
        sp.setTenSanPham(txtTenVi.getText());
        sp.setKieuDang(txtKieuDang.getText());

        // Lấy ID thương hiệu và loại sản phẩm từ combobox
        String selectedThuongHieu = (String) cbxThuongHieu.getSelectedItem();
        String selectedLoaiSanPham = (String) cbxLoaiSanPham.getSelectedItem();

        // Xác định ID từ tên được chọn
        sp.setIdThuongHieu(dao_th.selectIdByName(selectedThuongHieu));
        sp.setIdLoaiSanPham(dao_lsp.selectIdByName(selectedLoaiSanPham));

        sp.setTrangThai(rdo1.isSelected());
        sp.setUrl_Anh(lblHinh.getToolTipText());

        return sp;
    }

    private void setForm(SanPham sp) {
//        String thuonghieu = tblConhang.getValueAt(row, 2).toString();
//        for (int i = 0; i < list_TH.size(); i++) {
//            if (thuonghieu.equals(list_TH.get(i).getTenThuongHieu())) {
//                cbxThuongHieu.setSelectedIndex(i);
//            }
//        }
//        String loaisanpham = tblConhang.getValueAt(row, 3).toString();
//        for (int i = 0; i < list_LSP.size(); i++) {
//            if (loaisanpham.equals(list_LSP.get(i).getTenLoaiSanPham())) {
//                cbxLoaiSanPham.setSelectedIndex(i);
//            }
//        }

        Object thuonghieuObj = tblConhang.getValueAt(row, 2);
        String thuonghieu = (thuonghieuObj != null) ? thuonghieuObj.toString() : "";

        Object loaisanphamObj = tblConhang.getValueAt(row, 3);
        String loaisanpham = (loaisanphamObj != null) ? loaisanphamObj.toString() : "";

        txtMaVi.setText(sp.getMaSanPham());
        txtTenVi.setText(sp.getTenSanPham());
        txtKieuDang.setText(sp.getKieuDang());
        rdo1.setSelected(sp.isTrangThai());
        rdo.setSelected(!sp.isTrangThai());
        System.out.println(sp.getUrl_Anh());
        try {
            lblHinh.setToolTipText(sp.getUrl_Anh());
            lblHinh.setIcon((Ximages.read(sp.getUrl_Anh())));
        } catch (Exception e) {
        }
    }

    private void setForm1(SanPham sp) {
//        String thuonghieu = tblHetHang.getValueAt(row, 2).toString();
//        for (int i = 0; i < list_TH.size(); i++) {
//            if (thuonghieu.equals(list_TH.get(i).getTenThuongHieu())) {
//                cbxThuongHieu.setSelectedIndex(i);
//            }
//        }
//        String loaisanpham = tblConhang.getValueAt(row, 3).toString();
//        for (int i = 0; i < list_LSP.size(); i++) {
//            if (loaisanpham.equals(list_LSP.get(i).getTenLoaiSanPham())) {
//                cbxLoaiSanPham.setSelectedIndex(i);
//            }
//        }

        Object thuonghieuObj = tblHetHang.getValueAt(row, 2);
        String thuonghieu = (thuonghieuObj != null) ? thuonghieuObj.toString() : "";

        Object loaisanphamObj = tblHetHang.getValueAt(row, 3);
        String loaisanpham = (loaisanphamObj != null) ? loaisanphamObj.toString() : "";

        txtMaVi.setText(sp.getMaSanPham());
        txtTenVi.setText(sp.getTenSanPham());
        txtKieuDang.setText(sp.getKieuDang());
        rdo1.setSelected(sp.isTrangThai());
        rdo.setSelected(!sp.isTrangThai());
        System.out.println(sp.getUrl_Anh());
        try {
            lblHinh.setToolTipText(sp.getUrl_Anh());
            lblHinh.setIcon((Ximages.read(sp.getUrl_Anh())));
        } catch (Exception e) {
        }
    }

//    Chuyển trang
    private void updateStatus() {
        boolean edit = (row >= 0);
        boolean fist = (row == 0);
        boolean last = (row == tblConhang.getRowCount() - 1);
        ////
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        ////
        jButton1.setEnabled(edit && !fist);
        jButton2.setEnabled(edit && !fist);
        jButton3.setEnabled(!last && edit);
        jButton4.setEnabled(!last && edit);
    }

    private void updateStatus2() {
        boolean edit = (row >= 0);
        boolean fist = (row == 0);
        boolean last = (row == tblHetHang.getRowCount() - 1);
        ////
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        ////
        jButton1.setEnabled(edit && !fist);
        jButton2.setEnabled(edit && !fist);
        jButton3.setEnabled(!last && edit);
        jButton4.setEnabled(!last && edit);
    }

    private void edit() {
        String masp = tblConhang.getValueAt(row, 0).toString();
        SanPham sp = dao_vi.selectID1(masp);
        setForm(sp);
        updateStatus();
    }

    private void edithh() {
        String mahh = tblHetHang.getValueAt(row, 0).toString();
        SanPham sp = dao_vi.selectID1(mahh);

        setForm1(sp);
        updateStatus2();
    }

    SanPhamDAO service = new SanPhamDAO();

    private void clearForm() {
//        txtMaVi.setText("");
        txtMaVi.setText(" ");
        txtTenVi.setText(" ");
        txtKieuDang.setText(" ");
        lblHinh.setIcon(null);
        row = -1;
//        identityMasp2();
        if (jTabbedPane1.getSelectedIndex() == 0) {
            updateStatus();
        }
    }

//    private void identityMasp2() {
//        if (dao_vi.selectAll().isEmpty()) {
//            txtMaVi.setText("V001");
//        } else {
//            txtMaVi.setText("V0" + (dao_vi.selectMaxID() + 1));
//        }
////    }
    private void insert() {
        if (Checknull()) {
            return;
        } else if (CheckSPInuput()) {
            return;
        } else {
            try {
                if (MsgBox.confirm(this, "Bạn có muốn thêm sản phẩm này ?")) {
                    //SanPham sp = getInformation();
                    service.insert(getInformation());
                    if (jTabbedPane1.getSelectedIndex() == 0) {
                        filltotablech();
                        jTabbedPane1.setSelectedIndex(0);
                    } else {
                        filltotablehh();
                        jTabbedPane1.setSelectedIndex(1);
                    }
                    filltotablech();
                    filltotablehh();
                    clearForm();
                    JOptionPane.showMessageDialog(this, "Đã thêm");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Ops! Lỗi truy vấn dữ liệu rồi!");
            }
        }

    }

    private void delete() {
        try {
            int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa ?");
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Dữ liệu chưa được hiển thị để xóa!");
                return;
            }
            if (chon == JOptionPane.YES_OPTION) {
                Integer manv = Integer.valueOf(txtTenVi.getText());
                dao_vi.delete(manv);
                filltotablehh();
                filltotablech();
                jTabbedPane1.setSelectedIndex(1);
                clearForm();
                JOptionPane.showMessageDialog(this, "Yeah! Đã xóa");
            }

        } catch (Exception e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "xóa không thành công");
        }
    }

    private void update() {
        try {
            if (MsgBox.confirm(this, "Bạn có muốn sửa sản phẩm ?")) {
                SanPham sp = getInformation();
                dao_vi.update(sp);
                filltotablech();
                filltotablehh();
                clearForm();
                jTabbedPane1.setSelectedIndex(0);
                JOptionPane.showMessageDialog(this, "Đã sửa");
            } else ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ops! Sửa thất bại");
            e.printStackTrace();
        }

    }

//    Check trống 
    private boolean Checknull() {
        if (txtMaVi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm!");
            txtMaVi.requestFocus();

            return true;
        }
        if (txtTenVi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm!");
            txtTenVi.requestFocus();

            return true;
        }
        if (txtKieuDang.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập kiểu dáng sản phẩm!");
            txtKieuDang.requestFocus();

            return true;
        }
        List<SanPham> list = dao_vi.selectAll();
        String id = txtMaVi.getText();
        String tensp = txtTenVi.getText();
        for (int i = 0; i < list.size(); i++) {
            if (id.equalsIgnoreCase(list.get(i).getMaSanPham())) {
                JOptionPane.showMessageDialog(this, "Trùng khóa chính");
                txtMaVi.requestFocus();
                return true;
            } else if (tensp.equalsIgnoreCase(list.get(i).getTenSanPham())) {
                JOptionPane.showMessageDialog(this, "Tên sản phẩm đã tồn tại");
                txtTenVi.requestFocus();
                return true;
            }
        }
        if (lblHinh.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hình sản phẩm!");
            return true;
        } else if (txtMaVi.getText().length() < 3) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm phải trên 2 kí tự");
            return true;
        } else if (txtTenVi.getText().length() < 5) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm phải trên 5 kí tự");
            return true;
        }
        return false;

    }

    private boolean CheckSPInuput() {

        modelCH.setRowCount(0);
        try {
            List<SanPham> list = dao_vi.selectByName(txtTenVi.getText());
            for (int i = 0; i < list.size(); i++) {
                modelCH.addRow(new Object[]{list.get(i).getMaSanPham(), list.get(i).getTenSanPham(),
                    dao_th.selectNameByID(list.get(i).getIdThuongHieu()),
                    list.get(i).isTrangThai() ? "Còn Hàng" : "Không còn hàng"});
            }
        } catch (Exception e) {
        }
        return false;
    }

    private void search() {
        if (jTabbedPane1.getSelectedIndex() == 0) {
            String timkiem = txtTimKiem.getText();
            TableRowSorter<DefaultTableModel> sanpham = new TableRowSorter<>(modelCH);
            tblConhang.setRowSorter(sanpham);
            sanpham.setRowFilter(javax.swing.RowFilter.regexFilter(timkiem));
            jTabbedPane1.setSelectedIndex(0);
        }
    }

}
