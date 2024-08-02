 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dao.DBconnect;
import service.HoaDonCTITF;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonCT;

/**
 *
 * @author Admin
 */
public class HoaDonCTRepository implements HoaDonCTITF {

    @Override
    public List<HoaDonCT> getHDCT(int IDHoaDon) {
        String sql = "SELECT [IDHoaDonChiTiet]\n"
                + "      ,[ID_HoaDon]\n"
                + "      ,[ID_ChiTietSanPham]\n"
                + "      ,[Ma_HoaDonChiTiet]\n"
                + "      ,HoaDonChiTiet.SoLuong\n"
                + "      ,[DonGia]\n"
                + "      ,HoaDonChiTiet.TrangThai\n"
                + "	  ,TenSanPham\n"
                + "	  ,TenMauSac\n"
                + "	  ,TenChatLieu\n"
                + "	  ,ChiTietSanPham.GiaBan\n"
                + "  FROM [HoaDonChiTiet]\n"
                + "  JOIN ChiTietSanPham on ChiTietSanPham.IDChiTietSanPham = HoaDonChiTiet.ID_ChiTietSanPham\n"
                + "  JOIN SanPham on ChiTietSanPham.ID_SanPham = SanPham.IDSanPham\n"
                + "  JOIN MauSac on MauSac.IDMauSac = ChiTietSanPham.ID_MauSac\n"
                + "  JOIN ChatLieu on ChatLieu.IDChatLieu = ChiTietSanPham.ID_ChatLieu\n"
                + "  where ID_HoaDon = " + IDHoaDon + " ";
        List<HoaDonCT> listHDCT = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getBigDecimal(6),
                        rs.getBoolean(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getBigDecimal(11)
                );
                listHDCT.add(hdct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    @Override
    public void themHDCT(int idHoaDon, int idCTSP, int soLuongSPCT, BigDecimal donGia) {
        String sql = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([ID_HoaDon]\n"
                + "           ,[ID_ChiTietSanPham]\n"
                + "           ,[Ma_HoaDonChiTiet]\n"
                + "           ,[SoLuong]\n"
                + "           ,[DonGia]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (" + idHoaDon + "\n"
                + "           ," + idCTSP + "\n"
                + "           ,null\n"
                + "           ," + soLuongSPCT + "\n"
                + "           ," + donGia + "\n"
                + "           ,1)";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSoLuongSP(int idSPCT, int idHoaDon) {
        int soLuongSanPham = 0;
        String sql = "SELECT SoLuong\n"
                + "FROM HoaDonChiTiet WHERE ID_ChiTietSanPham = " + idSPCT + "and ID_HoaDon =" + idHoaDon + "";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soLuongSanPham = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuongSanPham;
    }

    public BigDecimal getTongTienHDCT(int IDHoaDon) {
        BigDecimal sum = BigDecimal.valueOf(0);
        String sql = "SELECT SUM(DonGia) as N'Tổng hóa đơn' \n"
                + "FROM HoaDonChiTiet WHERE ID_HoaDon = " + IDHoaDon + "";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sum = rs.getBigDecimal(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public static void main(String[] args) {
        HoaDonCTRepository hdct = new HoaDonCTRepository();
        System.out.println(hdct.getTongTienHDCT(1));
    }

    @Override
    public void suaHDCT(int idSPCT, int idHoaDon, int soLuong, BigDecimal thanhTien) {
        String sql = "UPDATE HoaDonChiTiet\n"
                + " SET SoLuong = " + soLuong + ", DonGia = " + thanhTien + "\n"
                + " WHERE ID_ChiTietSanPham = " + idSPCT + " and ID_HoaDon = " + idHoaDon + "";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   @Override
    public void xoaHDCT(int idHDCT) {
        String sql = "DELETE HoaDonChiTiet WHERE IDHoaDonChiTiet = " + idHDCT + "";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
