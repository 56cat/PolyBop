/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import repository.NhanVienService;

/**
 *
 * @author admin
 */
public class NhanVienServiceImpl implements NhanVienService {

    private Connection conn;

    public NhanVienServiceImpl() {
        try {
            conn = DBConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<NhanVien> getAll() {
    List<NhanVien> list = new ArrayList<>();
    String q = "SELECT IDNhanVien, Ma_NhanVien, HoTen, Email, SDT, GioiTinh, NgaySinh, "
            + "ChucVu, DiaChi, MatKhau, TrangThai FROM NhanVien";
    
    try (PreparedStatement ps = conn.prepareStatement(q);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            int id = rs.getInt("IDNhanVien");
            String email = rs.getString("Email");
            String sdt = rs.getString("SDT");
            String hoTen = rs.getString("HoTen");
            String maNV = rs.getString("Ma_NhanVien");
            String diaChi = rs.getString("DiaChi");
            int gioiTinh = rs.getInt("GioiTinh"); // Đọc giá trị kiểu int
            Date ngaySinh = rs.getDate("NgaySinh");
            String matkhau = rs.getString("MatKhau");
            int chucVu = rs.getInt("ChucVu"); // Đọc giá trị kiểu int
            int trangThai = rs.getInt("TrangThai"); // Đọc giá trị kiểu int

            // Tạo đối tượng NhanVien với constructor phù hợp
            NhanVien nv = new NhanVien(id, maNV, hoTen, email, sdt, gioiTinh, ngaySinh, chucVu, diaChi, matkhau, trangThai);
            list.add(nv);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

    @Override
    public void them(NhanVien nv) throws Exception {
    if (nv == null) {
        throw new IllegalArgumentException("NhanVien cannot be null");
    }

    String sql = "INSERT INTO NhanVien(Ma_NhanVien, HoTen, Email, SDT, GioiTinh, NgaySinh, ChucVu, DiaChi, MatKhau, TrangThai) VALUES (?,?,?,?,?,?,?,?,?,?);";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, nv.getMaNV());       // Ma_NhanVien
        ps.setString(2, nv.getHoTen());      // HoTen
        ps.setString(3, nv.getEmail());      // Email
        ps.setString(4, nv.getSdt());        // SDT
        
        // Giới tính (GioiTinh) - sử dụng int thay vì boolean
        ps.setInt(5, nv.getGioiTinh());       // GioiTinh (int)
        
        // Ngày sinh (NgaySinh) - sử dụng java.sql.Date
        ps.setDate(6, new java.sql.Date(nv.getNgaySinh().getTime()));  // NgaySinh (java.sql.Date)
        
        // Chức vụ (ChucVu) - sử dụng int thay vì boolean
        ps.setInt(7, nv.isChucVu() ? 1 : 0);       // ChucVu (int)
        
        ps.setString(8, nv.getDiaChi());     // DiaChi
        ps.setString(9, nv.getMatkhau());    // MatKhau
        
        // Trạng thái (TrangThai) - sử dụng int thay vì boolean
        ps.setInt(10, nv.getTrangThai());    // TrangThai (int)

        ps.executeUpdate(); // Execute the SQL statement
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    @Override
   public void sua(NhanVien nv, int id) throws Exception {
    String sql = "UPDATE NhanVien SET Email=?, SDT=?, Ma_NhanVien=?, HoTen=?, ChucVu=?, DiaChi=?, GioiTinh=?, NgaySinh=?, MatKhau=?, TrangThai=? WHERE IDNhanVien=?;";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, nv.getEmail());
        ps.setString(2, nv.getSdt());
        ps.setString(3, nv.getMaNV());
        ps.setString(4, nv.getHoTen());
        ps.setString(6, nv.getDiaChi());
        ps.setString(9, nv.getMatkhau());
        // Chuyển đổi giới tính từ int sang String nếu cần
        ps.setInt(7, nv.getGioiTinh());
        ps.setDate(8, new java.sql.Date(nv.getNgaySinh().getTime()));
        ps.setInt(5, nv.isChucVu() ? 1 : 0);  
        ps.setInt(10, nv.getTrangThai());
        ps.setInt(11, id);

        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
        throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi về lỗi
    }
}


    @Override
    public void xoa(int id) throws Exception {
        String sql = "DELETE FROM NhanVien WHERE IDNhanVien = ? ";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<NhanVien> tim(String MaNV) {
        List<NhanVien> listNV = new ArrayList<>();
        try {
            String q = "select IDNhanVien ,Ma_NhanVien, HoTen,Email, SDT, GioiTinh, NgaySinh,"
                    + " ChucVu, DiaChi,MatKhau, TrangThai from NhanVien where Ma_NhanVien like ?";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, "%" + MaNV + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDNhanVien");
                String email = rs.getString("Email");
                String sdt = rs.getString("SDT");
                String hoTen = rs.getString("HoTen");
                String maNV = rs.getString("Ma_NhanVien");
                String diaChi = rs.getString("DiaChi");
                // Chuyển đổi giới tính từ int sang String
                boolean gioiTinh = rs.getBoolean("GioiTinh"); // Giữ GioiTinh dưới dạng int
                Date ngaySinh = rs.getDate("NgaySinh");
                boolean chucvu = rs.getBoolean("ChucVu");
                String ngayTao = rs.getString("MatKhau");
                boolean trangThai = rs.getBoolean("TrangThai");
                NhanVien nv = new NhanVien(id, maNV, hoTen, email, sdt, id, ngaySinh, id, diaChi, maNV, id);
                listNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }
   

}
