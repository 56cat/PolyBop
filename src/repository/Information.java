/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dao.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class Information {

    public int getIDNVByEmail(String email) {
        int id = -1;
        String sql = "SELECT IDNhanVien FROM NhanVien where Email = '" + email + "' ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public int getIDSPCTByMa(String maSPCT) {
        int id = -1;
        String sql = "SELECT IDChiTietSanPham FROM ChiTietSanPham WHERE Ma_ChiTietSanPham = '" + maSPCT + "' ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    
    public int getSoLuongTonKho(int idSPCT) {
        String sql = "SELECT SoLuong FROM ChiTietSanPham WHERE IDChiTietSanPham = ?";
        try (Connection con = DBconnect.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSPCT);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("SoLuong");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Hoặc một giá trị mặc định hoặc xử lý ngoại lệ tùy ý
    }

    public static void main(String[] args) {
        Information x = new Information();
        int id = x.getIDNVByEmail("nguyenvana@example.com");
        System.out.println(id);
    }
}
