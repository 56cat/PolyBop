/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import dao.DBconnect;
import repository.SanPhamCTITF;
import java.math.BigDecimal;
import java.sql.*;
import model.SanPhamCTSale;

/**
 *
 * @author Admin
 */
public class SanPhamCTSaleRepository implements SanPhamCTITF {

    @Override
    public List<SanPhamCTSale> getData(String key) {
        String sql = "SELECT [Ma_ChiTietSanPham],\n"
                + "       SanPham.TenSanPham,\n"
                + "       MauSac.TenMauSac,\n"
                + "       ThuongHieu.TenThuongHieu,\n"
                + "       ChatLieu.TenChatLieu,\n"
                + "       SoLuong,\n"
                + "       GiaBan\n"
                + "  FROM ChiTietSanPham\n"
                + "  JOIN SanPham ON ChiTietSanPham.ID_SanPham = SanPham.IDSanPham\n"
                + "  JOIN MauSac ON ChiTietSanPham.ID_MauSac = MauSac.IDMauSac\n"
                + "  JOIN ChatLieu ON ChiTietSanPham.ID_ChatLieu = ChatLieu.IDChatLieu\n"
                + "  JOIN ThuongHieu ON ThuongHieu.IDThuongHieu = SanPham.ID_ThuongHieu\n"
                + "WHERE Ma_ChiTietSanPham LIKE ? OR TenSanPham LIKE ?";
        List<SanPhamCTSale> listSanPhamCT = new ArrayList<>();

        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maSPCT = rs.getString("Ma_ChiTietSanPham");
                String tenSanPham = rs.getString("TenSanPham");
                String tenMauSac = rs.getString("TenMauSac");
                String tenThuongHieu = rs.getString("TenThuongHieu");
                String tenChatLieu = rs.getString("TenChatLieu");
                int soLuong = rs.getInt("SoLuong");
                BigDecimal giaBan = rs.getBigDecimal("GiaBan");

                SanPhamCTSale sp = new SanPhamCTSale(maSPCT, tenSanPham, tenMauSac, tenThuongHieu, tenChatLieu, soLuong, giaBan);
                listSanPhamCT.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPhamCT;
    }
}
