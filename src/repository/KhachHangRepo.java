package repository;

import dao.DBconnect;
import model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class KhachHangRepo {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Connection conn;

    public KhachHangRepo() {
        this.conn = DBconnect.getConnection();
    }

    public ArrayList<KhachHang> findAll() {
        ArrayList<KhachHang> ds = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("IDKhachHang");
                String ten = rs.getString("TenKhachHang");
                String sdt = rs.getString("SDT");
                Date ngaySinh = rs.getDate("NgaySinh");
                String email = rs.getString("Email");
                String diaChi = rs.getString("DiaChi");
                int trangThai = rs.getInt("TrangThai");

                KhachHang kh = new KhachHang(id, ten, sdt, ngaySinh, email, diaChi, trangThai);
                ds.add(kh);
            }
        } catch (Exception e) {
            System.out.println("Loii");
            e.printStackTrace();
        }
        return ds;
    }

    public void delete(int IDKhachHang) {
        String sql = "DELETE FROM KhachHang WHERE IDKhachHang = ? ";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, IDKhachHang);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(KhachHang kh) {
        String sql = "INSERT INTO KhachHang(TenKhachHang, SDT, NgaySinh, Email, DiaChi, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, kh.getTenKhachHang());
            ps.setString(2, kh.getSDT());
            ps.setDate(3, new java.sql.Date(kh.getNgaySinh().getTime())); // Chuyển đổi java.util.Date thành java.sql.Date
            ps.setString(4, kh.getEmail());
            ps.setString(5, kh.getDiaChi());
            ps.setInt(6, kh.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            System.out.println("Lỗi");
            e.printStackTrace();
        }
    }

    public ArrayList<KhachHang> search(String keyword, int trangThai) {
    ArrayList<KhachHang> ds = new ArrayList<>();
    String sql = "SELECT * FROM KhachHang WHERE TrangThai = ?";
    
    if (keyword != null && !keyword.trim().isEmpty()) {
        sql += " AND (TenKhachHang LIKE ? OR SDT LIKE ?)";
    }
    
    try {
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, trangThai);
        
        if (keyword != null && !keyword.trim().isEmpty()) {
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
        }
        
        ResultSet rs = ps.executeQuery();  // Thay `execute()` bằng `executeQuery()` để nhận dữ liệu
        
        while (rs.next()) {
            int id = rs.getInt("IDKhachHang");
            String ten = rs.getString("TenKhachHang");
            String sdt = rs.getString("SDT");
            Date ngaySinh = rs.getDate("NgaySinh");
            String email = rs.getString("Email");
            String diaChi = rs.getString("DiaChi");
            int trangThai1 = rs.getInt("TrangThai");

            KhachHang kh = new KhachHang(id, ten, sdt, ngaySinh, email, diaChi, trangThai1);
            ds.add(kh);
        }
    } catch (SQLException e) {
        System.out.println("Lỗi khi tìm kiếm");
        e.printStackTrace();
    }
    
    return ds;
}

    public boolean isPhoneNumberDuplicate(String phoneNumber) {
        String sql = "SELECT COUNT(*) FROM KhachHang WHERE SDT = ?";
        
        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setString(1, phoneNumber);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Trả về true nếu số điện thoại đã tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; // Trả về false nếu số điện thoại không tồn tại
    }
    
    public boolean isEmailDuplicate(String email) {
        String sql = "SELECT COUNT(*) FROM KhachHang WHERE Email = ?";
        
        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Trả về true nếu số điện thoại đã tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; // Trả về false nếu số điện thoại không tồn tại
    }

    public void update(KhachHang kh) {
    String sql = "UPDATE KhachHang SET TenKhachHang = ?, SDT = ?, NgaySinh = ?, Email = ?, DiaChi = ?, TrangThai = ? WHERE IDKhachHang = ?";
    try {
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, kh.getTenKhachHang());
        ps.setString(2, kh.getSDT());
        ps.setDate(3, new java.sql.Date(kh.getNgaySinh().getTime()));
        ps.setString(4, kh.getEmail());
        ps.setString(5, kh.getDiaChi());
        ps.setInt(6, kh.getTrangThai());
        ps.setInt(7, kh.getIDKhachHang()); // Đừng quên thiết lập giá trị cho IDKhachHang trong câu truy vấn WHERE

        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
