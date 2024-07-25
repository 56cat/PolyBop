package controller;

import dao.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import repository.INTFThuocTinh;

public class ThuocTinhSanPhamRepository implements INTFThuocTinh{

    @Override
    public int getIDSPbyName(String name) {
        int ID = 0;
        String sql = "Select IDSanPham from SanPham where TenSanPham like N'" + name + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID;
    }

    @Override
    public int getIDMauSacbyName(String name) {
        int ID = 0;
        String sql = "Select IDMauSac from MauSac where TenMauSac like N'" + name + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID;
    }

    @Override
    public int getIDChatLieubyName(String name) {
        int ID = 0;
        String sql = "Select IDChatLieu from ChatLieu where TenChatLieu like N'" + name + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID;
    }

    @Override
    public int getIDLoaiSanPhambyName(String name) {
        int ID = 0;
        String sql = "Select IDLoaiSanPham from LoaiSanPham where TenLoaiSanPham like N'" + name + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID;
    }

    public static void main(String[] args) {
        ThuocTinhSanPhamRepository th = new ThuocTinhSanPhamRepository();
        System.out.println(th.getIDMauSacbyName("do"));
    }

}
