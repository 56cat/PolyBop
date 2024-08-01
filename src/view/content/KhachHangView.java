package view.content;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import repository.KhachHangRepo;

public class KhachHangView extends javax.swing.JInternalFrame {

    private KhachHangRepo khRepo;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public KhachHangView() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        this.khRepo = new KhachHangRepo();
        this.loadTable();
    }

    private void loadTable() {
        ArrayList<KhachHang> ds = this.khRepo.findAll();
        DefaultTableModel dtm = (DefaultTableModel) this.tblKhachHang.getModel();

        dtm.setRowCount(0);
        for (KhachHang kh : ds) {
            // Định dạng ngày sinh
            java.util.Date ngaySinh = kh.getNgaySinh(); // Sử dụng java.util.Date
            String ngaySinhStr = ngaySinh != null ? dateFormat.format(ngaySinh) : "N/A";

            // Tạo mảng chứa dữ liệu của từng hàng
            Object[] row = {
                kh.getIDKhachHang(),
                kh.getTenKhachHang(),
                kh.getSDT(),
                ngaySinhStr, // Sử dụng chuỗi định dạng ngày sinh
                kh.getEmail(),
                kh.getDiaChi(),
                kh.getTrangThai() == 1 ? "Hoạt động" : "Không hoạt động"
            };

            // Thêm hàng vào model của bảng
            dtm.addRow(row);
        }
    }

    private void loadTable2() {
        String keyword = this.txtTimkiem.getText().trim();
        int trangThai = this.rdoTimKiem.isSelected() ? 1 : 0;
        ArrayList<KhachHang> ketQua = khRepo.search(keyword, trangThai);

        if (ketQua.isEmpty()) {
            // Hiển thị hộp thoại thông báo khi không tìm thấy kết quả
            JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng nào với tiêu chí tìm kiếm.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ArrayList<KhachHang> ds = this.khRepo.search(keyword, trangThai);
            DefaultTableModel dtm = (DefaultTableModel) this.tblKhachHang.getModel();
            dtm.setRowCount(0);
            for (KhachHang kh : ds) {
                Object[] row = {
                    kh.getIDKhachHang(),
                    kh.getTenKhachHang(),
                    kh.getSDT(),
                    kh.getNgaySinh(),
                    kh.getEmail(),
                    kh.getDiaChi(),
                    kh.getTrangThai() == 1 ? "Hoạt động" : "Không hoạt động",};
                dtm.addRow(row);
            }
        }

    }

    private void loadData() {
        this.txtHoTen.setText("");
        this.txtsdt.setText("");
        this.txtDiaChi.setText("");
        this.txtNgaySinh.setText("");
        this.txtEmail.setText("");
        this.txtTimkiem.setText("");
        this.rdoActive.setSelected(true);
    }

    private KhachHang getFormData() {
        // Lấy ID khách hàng từ bảng, giả sử ID nằm ở cột đầu tiên của hàng đã chọn
        int row = this.tblKhachHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng để sửa");
            return null;
        }

        String idStr = this.tblKhachHang.getValueAt(row, 0).toString(); // Lấy giá trị từ cột đầu tiên của hàng đã chọn
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID không hợp lệ");
            return null;
        }

        // Lấy dữ liệu từ các trường văn bản
        String ten = this.txtHoTen.getText().trim();
        String sdt = this.txtsdt.getText().trim();
        String ngaySinhStr = this.txtNgaySinh.getText().trim(); // Chuỗi ngày sinh
        String email = this.txtEmail.getText().trim();
        String diaChi = this.txtDiaChi.getText().trim();

        // Kiểm tra các trường dữ liệu không được để trống
        if (ten.isEmpty() || sdt.isEmpty() || email.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }

        Date ngaySinh = null;
        if (!ngaySinhStr.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            try {
                ngaySinh = dateFormat.parse(ngaySinhStr);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ, vui lòng nhập theo định dạng dd/MM/yyyy");
                return null;
            }
        }

        int trangThai = this.rdoActive.isSelected() ? 1 : 0;
        KhachHang kh = new KhachHang(id, ten, sdt, ngaySinh, email, diaChi, trangThai);

        return kh;
    }

    private boolean validateDate(Date ngaySinh) {
        LocalDate birthDate = ngaySinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        dateFormat.setLenient(false);
        // Kiểm tra ngày sinh không nằm trong tương lai
        if (birthDate.isAfter(currentDate)) {
            return false;
        }

        // Kiểm tra độ tuổi hợp lệ (0-120 tuổi)
        int age = Period.between(birthDate, currentDate).getYears();
        if (age < 0 || age > 120) {
            return false;
        }
        return true;

    }

    private boolean validateEmail(String email) {
        String lowerCaseEmail = email.toLowerCase();
        // Kiểm tra xem email đã chuyển đổi có khác với email gốc không
        if (!email.equals(lowerCaseEmail)) {
            JOptionPane.showMessageDialog(this, "Email không được viết hoa");
            // Nếu email gốc khác với email đã chuyển đổi, có nghĩa là có chữ cái viết hoa
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        boolean containsNonAscii = lowerCaseEmail.chars().anyMatch(c -> c > 127);
        if (containsNonAscii) {
            JOptionPane.showMessageDialog(this, "Email không có đúng định dạng");
        }
        return matcher.matches() && !containsNonAscii;

    }

    private boolean validatePhoneNumber(String phoneNumber) {
        String phoneRegex = "^(0[0-9]{9,10})$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rdoActive = new javax.swing.JRadioButton();
        rdoInactive = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTimkiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        rdoTimKiem = new javax.swing.JRadioButton();
        rdoTimKiem2 = new javax.swing.JRadioButton();
        btnClear2 = new javax.swing.JButton();

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Khach Hang", "Họ và tên", "Số điện thoại", "Ngày sinh", "Email", "Địa chỉ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ và tên :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số điện thoại: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ngày sinh :");

        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Email :");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Địa chỉ :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Trạng thái :");

        buttonGroup1.add(rdoActive);
        rdoActive.setSelected(true);
        rdoActive.setText("Hoạt động");
        rdoActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoActiveActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoInactive);
        rdoInactive.setText("Không hoạt động ");

        jLabel9.setFont(new java.awt.Font("Roboto Condensed", 2, 12)); // NOI18N
        jLabel9.setText("Ngày sinh định dạng : dd/MM/yyyy");

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Trash.png"))); // NOI18N
        btnLoad.setText("CLEAR");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnAdd)
                .addGap(24, 24, 24)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnLoad)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtsdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoActive, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(rdoInactive)))
                        .addGap(89, 89, 89))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)))
                                .addGap(22, 22, 22)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(3, 3, 3)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoActive)
                                .addComponent(rdoInactive))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý khách hàng");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setText("Tìm Kiếm Khách Hàng :");

        txtTimkiem.setBackground(new java.awt.Color(51, 255, 204));
        txtTimkiem.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnTimKiem.setText("SEARCH");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoTimKiem);
        rdoTimKiem.setSelected(true);
        rdoTimKiem.setText("Hoạt động");

        buttonGroup2.add(rdoTimKiem2);
        rdoTimKiem2.setText("Không hoạt động");

        btnClear2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Trash.png"))); // NOI18N
        btnClear2.setText("CLEAR");
        btnClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdoTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(rdoTimKiem2)))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rdoTimKiem2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClear2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rdoTimKiem)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        System.out.println("Clicked?");
        int viTri = this.tblKhachHang.getSelectedRow();
        if (viTri == -1) {
            return;
        }
        //        String idS = this.tblKhachHang.getValueAt(viTri, 0).toString();
        String TenKhachHang = this.tblKhachHang.getValueAt(viTri, 1).toString();
        String sdt = this.tblKhachHang.getValueAt(viTri, 2).toString();
        String ngaySinh = this.tblKhachHang.getValueAt(viTri, 3).toString();
        String email = this.tblKhachHang.getValueAt(viTri, 4).toString();
        String diachi = this.tblKhachHang.getValueAt(viTri, 5).toString();
        String trangThaiSTR = this.tblKhachHang.getValueAt(viTri, 6).toString();

        this.txtHoTen.setText(TenKhachHang);
        this.txtsdt.setText(sdt);
        this.txtNgaySinh.setText(ngaySinh);
        this.txtEmail.setText(email);
        this.txtDiaChi.setText(diachi);

        if (trangThaiSTR.equals("Hoạt động")) {
            this.rdoActive.setSelected(true);
        } else {
            this.rdoInactive.setSelected(true);
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed

    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void rdoActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoActiveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String ten = this.txtHoTen.getText().trim();
        String sdt = this.txtsdt.getText().trim();
        String ngaySinh = this.txtNgaySinh.getText().trim();
        String email = this.txtEmail.getText().trim();
        String diaChi = this.txtDiaChi.getText().trim();

        if (ten.isEmpty() || sdt.isEmpty() || ngaySinh.isEmpty() || email.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return;
        }

        Date parsedDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            parsedDate = dateFormat.parse(ngaySinh);
            if (!validateDate(parsedDate)) {
                JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ");
                return;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng (dd/MM/yyyy)");
            return;
        }

        if (!validateEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ");
            return;
        }
        if (!validatePhoneNumber(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            return;
        }
        if (!sdt.matches("^0[1-9]\\d+$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải bắt đầu bằng 0 và chữ số tiếp theo phải khác 0!");
            return;
        }

        if (this.khRepo.isPhoneNumberDuplicate(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
            return;
        }
         if (this.khRepo.isEmailDuplicate(email)) {
            JOptionPane.showMessageDialog(this, "Email đã tồn tại");
            return;
        }
        int trangThai = this.rdoActive.isSelected() ? 1 : 0;

        try {
            KhachHang kh = new KhachHang(-1, ten, sdt, parsedDate, email, diaChi, trangThai);
            this.khRepo.create(kh);
            this.loadData();
            this.loadTable();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại");
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String ten = this.txtHoTen.getText().trim();
        String sdt = this.txtsdt.getText().trim();
        String ngaySinh = this.txtNgaySinh.getText().trim(); // Chuỗi ngày sinh
        String email = this.txtEmail.getText().trim();
        String diaChi = this.txtDiaChi.getText().trim();

        Date parsedDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        int row = this.tblKhachHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng để sửa");
            return;
        }

        try {
            parsedDate = dateFormat.parse(ngaySinh);
            if (!validateDate(parsedDate)) {
                JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ");
                return;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng (dd/MM/yyyy)");
            return;
        }
        KhachHang kh = this.getFormData();
        if (kh == null) {
            return;
        }
        if (!validateEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ");
            return;
        }
        if (!validatePhoneNumber(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            return;
        }
         

        try {
            this.khRepo.update(kh);
            this.loadData();
            this.loadTable();
            JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thất bại");
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int viTri = this.tblKhachHang.getSelectedRow();
        if (viTri == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng để xóa");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        String idStr = this.tblKhachHang.getValueAt(viTri, 0).toString();
        int id = Integer.parseInt(idStr);
        this.khRepo.delete(id);
        JOptionPane.showMessageDialog(this, "Xóa thành công");
        this.loadData();
        this.loadTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        this.loadData();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        this.loadTable2();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear2ActionPerformed
        this.txtTimkiem.setText("");
        this.rdoTimKiem.setSelected(true);
        this.loadData();
        this.loadTable();
    }//GEN-LAST:event_btnClear2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoActive;
    private javax.swing.JRadioButton rdoInactive;
    private javax.swing.JRadioButton rdoTimKiem;
    private javax.swing.JRadioButton rdoTimKiem2;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}
