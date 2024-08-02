/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import  dao.DBconnect;
import service.HoaDonITF;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDonRepository implements HoaDonITF{
    @Override
    public List<HoaDon> getAll() {
        String sql = "SELECT  [IDHoaDon]\n"
                + "  ,[ID_KhachHang]\n"
                + "  ,[ID_NhanVien]\n"
                + "  ,[ID_KhuyenMai]\n"
                + "  ,[Ma_HoaDon]\n"
                + "  ,[TienSauGiamGia]\n"
                + "  ,[ThanhTien]\n"
                + "  ,[PhuongThucThanhToan]\n"
                + "  ,[NgayThanhToan]\n"
                + "  ,[HoaDon].TrangThai\n"
                + "  ,[HoTen]\n"
                + "  ,[TenKhachHang]\n"
                + "  FROM HoaDon\n"
                + "  JOIN KhachHang on HoaDon.ID_KhachHang = KhachHang.IDKhachHang\n"
                + "  JOIN NhanVien on HoaDon.ID_NhanVien = NhanVien.IDNhanVien\n"
                + "  WHERE HoaDon.TrangThai = 0";
        List<HoaDon> listHoaDon = new ArrayList<>();

        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idHoaDon = rs.getInt(1);
                int idNhanVien = rs.getInt(2);
                int idKhachHang = rs.getInt(3);
                int idKhuyenMai = rs.getInt(4);
                String maHoaDon = rs.getString(5);
                BigDecimal tienSauGiamGia = rs.getBigDecimal(6);
                BigDecimal thanhTien = rs.getBigDecimal(7);
                boolean phuongThucThanhToan = rs.getBoolean(8);
                Date ngayThanhToan = rs.getDate(9);
                boolean trangThai = rs.getBoolean(10);
                String tenNV = rs.getString(11);
                String tenKH = rs.getString(12);
                HoaDon hd = new HoaDon(idHoaDon, idKhachHang, idNhanVien, idKhuyenMai, maHoaDon, tienSauGiamGia, thanhTien, phuongThucThanhToan, ngayThanhToan, trangThai, tenKH, tenNV);
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    @Override
    public void taoHoaDon(int idNhanVien) {
        String newBillCode = taoHoaDonMoi();
        String sql = "INSERT INTO [HoaDon]\n"
                + "           ([ID_KhachHang]\n"
                + "           ,[ID_NhanVien]\n"
                + "           ,[ID_KhuyenMai]\n"
                + "           ,[Ma_HoaDon]\n"
                + "           ,[TienSauGiamGia]\n"
                + "           ,[ThanhTien]\n"
                + "           ,[PhuongThucThanhToan]\n"
                + "           ,[NgayThanhToan]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (1\n" // This should be parameterized as well, if needed
                + "           ,1\n"
                + "           ,NULL\n"
                + "           ,?\n"
                + "           ,0\n"
                + "           ,0\n"
                + "           ,NULL\n"
                + "           ,GETDATE()\n"
                + "           ,0)";

        try (Connection con = DBconnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newBillCode);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HoaDon getHoaDonById(int idHoaDon) {
        HoaDon hoaDon = null;
        String sql = "SELECT * FROM HoaDon WHERE IDHoaDon = ?";

        try (Connection con = DBconnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idHoaDon);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                hoaDon = new HoaDon();
                hoaDon.setIdHoaDon(rs.getInt("IDHoaDon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDon;
    }

    public String getHoaDonCu() {
        String sql = "SELECT TOP 1 Ma_HoaDon FROM HoaDon ORDER BY IDHoaDon DESC";
        try (Connection con = DBconnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String taoHoaDonMoi() {
        String lastBillCode = getHoaDonCu();
        if (lastBillCode == null || lastBillCode.isEmpty()) {
            return "HD001";
        }

        String numericalPart = lastBillCode.substring(2);
        int billNumber = Integer.parseInt(numericalPart);
        billNumber++;

        return String.format("HD%03d", billNumber);
    }

    @Override
    public void capNhatTongHoaDon(int idHoaDon, BigDecimal thanhTien) {
        String sql = "UPDATE HoaDon\n"
                + " SET ThanhTien = " + thanhTien + "\n"
                + " WHERE IDHoaDon = " + idHoaDon + "";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void capNhatTrangThai(int idHoaDon, String trangThai) {
        String sql = "UPDATE HoaDon SET TrangThai = ? WHERE IDHoaDon = ?";

        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, trangThai);
            ps.setInt(2, idHoaDon);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean capNhatKHonHoaDon(int idHoaDon, int idKhachHang) {
        String sql = "UPDATE HoaDon SET ID_KhachHang = ? WHERE IDHoaDon = ?";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idKhachHang);
            ps.setInt(2, idHoaDon);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void capNhatPTTT(int idHoaDon, int phuongThucThanhToan) {
        String sql = "UPDATE HoaDon SET PhuongThucThanhToan = ?  WHERE IDHoaDon =  ?";

        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, phuongThucThanhToan);
            ps.setInt(2, idHoaDon);
            int rowsAffected = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
