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
    public List<HoaDon> getAll(){ 
        String sql = "SELECT  [IDHoaDon]\n"
                +"  ,[ID_KhachHang]\n"
                +"  ,[ID_NhanVien]\n"
                +"  ,[ID_KhuyenMai]\n"
                +"  ,[Ma_HoaDon]\n"
                +"  ,[TienSauGiamGia]\n"
                +"  ,[ThanhTien]\n"
                +"  ,[PhuongThucThanhToan]\n"
                +"  ,[NgayThanhToan]\n"
                +"  ,[HoaDon].TrangThai\n"
                +"  ,[HoTen]\n"
                +"  ,[TenKhachHang]\n"
                +"  FROM HoaDon\n"
                +"  JOIN KhachHang on HoaDon.ID_KhachHang = KhachHang.IDKhachHang\n"
                +"  JOIN NhanVien on HoaDon.ID_NhanVien = NhanVien.IDNhanVien\n"
                +"  WHERE HoaDon.TrangThai = 0";
         List<HoaDon> listHoaDon = new ArrayList<>();
                
         try (Connection con =DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {                 
                 int idHoaDon = rs.getInt(1);
                 int idKhachHang = rs.getInt(2);
                 int idNhanVien = rs.getInt(3);
                 int idKhuyenMai = rs.getInt(4);
                 String maHoaDon = rs.getString(5);
                 BigDecimal tienSauGiamGia = rs.getBigDecimal(6);
                 BigDecimal thanhTien = rs.getBigDecimal(7);
                 boolean phuongThucThanhToan = rs.getBoolean(8);
                 Date ngayThanhToan = rs.getDate(9);
                 boolean trangThai = rs.getBoolean(10);
                 String tenKH = rs.getString(11);
                 String tenNV = rs.getString(12);
                 HoaDon hd = new HoaDon(idHoaDon, idKhachHang, idNhanVien, idKhuyenMai, maHoaDon, tienSauGiamGia, thanhTien, phuongThucThanhToan, ngayThanhToan, trangThai, tenKH, tenNV);
                 listHoaDon.add(hd);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return listHoaDon;
    }
}
