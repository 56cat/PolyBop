
package repository;

import dao.DBconnect;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import model.HoaDonShow;

public class HoaDonShowRepo {
    private Connection conn;

    public HoaDonShowRepo() {
        this.conn = DBconnect.getConnection();
    }
    
    public ArrayList<HoaDonShow> findAll() {
        ArrayList<HoaDonShow> ds = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int idHoaDon = rs.getInt("IDHoaDon");
                int idKhachHang = rs.getInt("ID_KhachHang");
                int idNhanVien = rs.getInt("ID_NhanVien");
                int idKHuyenMai = rs.getInt("ID_KhuyenMai");
                String maHoaDon = rs.getString("Ma_HoaDon");
                BigDecimal tienSauGiam = rs.getBigDecimal("TienSauGiamGia");
                BigDecimal thanhTien = rs.getBigDecimal("ThanhTien");
                int phuongThuc = rs.getInt("PhuongThucThanhToan");
                Date ngayThanhToan = rs.getDate("NgayThanhToan");
                int trangThai = rs.getInt("TrangThai");

                HoaDonShow hd = new HoaDonShow(idHoaDon, idKhachHang, idNhanVien, idKHuyenMai, maHoaDon, tienSauGiam, thanhTien, phuongThuc, ngayThanhToan, trangThai);
                ds.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Loii");
            e.printStackTrace();
        }
        return ds;
    }
    
}
