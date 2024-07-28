/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.KhuyenMai;
import dao.DBconnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import repository.InterfaceKhuyenMai;

/**
 *
 * @author dangc
 */
public class KhuyenMaiService implements InterfaceKhuyenMai {

    @Override
    public List<KhuyenMai> getKhuyenMai() {
        String sql = "SELECT [IDKhuyenMai]\n"
                + "       ,[Ma_KhuyenMai]\n"
                + "       ,[GiaTri]\n"
                + "       ,[NgayBatDau]\n"
                + "       ,[NgayKetThuc]\n"
                + "       ,[TrangThai]\n"
                + "  FROM [dbo].[KhuyenMai]where TrangThai = 1";
        List<KhuyenMai> listKM = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getBoolean(6));
                listKM.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKM;
    }

    @Override
    public int getGiaTriKM(String maKH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

public List<KhuyenMai> getAll(){
    String sql = "SELECT IDKhuyenMai, Ma_KhuyenMai, GiaTri, NgayBatDau, NgayKetThuc, TrangThai FROM KhuyenMai WHERE TrangThai = 1";
    List<KhuyenMai> listKM = new ArrayList<>();
    try (Connection con = DBconnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
         
        while(rs.next()){
            KhuyenMai km = new KhuyenMai(
                                rs.getInt("IDKhuyenMai"),
                                rs.getString("Ma_KhuyenMai"),
                                rs.getInt("GiaTri"),
                                rs.getDate("NgayBatDau"),
                                rs.getDate("NgayKetThuc"),
                                rs.getBoolean("TrangThai")); // Assuming TrangThai is bit
            listKM.add(km);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listKM;
}

    public int deleteKM(String ma) {
        String sql = "Update KhuyenMai set TrangThai = 0 where Ma_KhuyenMai like ?";
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int addKhuyenMai(KhuyenMai km) {
        String sql = "INSERT INTO KhuyenMai(Ma_KhuyenMai, GiaTri, NgayBatDau, NgayKetThuc, TrangThai) VALUES( ?, ?, ?, ?, ?)";
        int kq = 0;
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, km.getMa());
            ps.setInt(2, km.getGiaTri());
            java.util.Date startDate = km.getNgayBatDau();
            java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
            java.util.Date endDate = km.getNgayKetThuc();
            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

            ps.setDate(3, sqlStartDate);
            ps.setDate(4, sqlEndDate);
            ps.setBoolean(5, km.isTrangThai());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public int updateKM(String ma, KhuyenMai km) {
        String sql = "UPDATE KhuyenMai set GiaTri= ?, NgayBatDau = ?, NgayKetThuc = ?, TrangThai = ? WHERE Ma_KhuyenMai = ?";
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, km.getGiaTri());
            ps.setDate(2, new java.sql.Date(km.getNgayBatDau().getTime()));
            ps.setDate(3, new java.sql.Date(km.getNgayKetThuc().getTime()));
            ps.setBoolean(4, km.isTrangThai());
            ps.setString(5, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<KhuyenMai> locTT(String trangThai) {
        List<KhuyenMai> ListNV = new ArrayList<>();
        Connection con = DBconnect.getConnection();
        String sql = "SELECT IDKhuyenMai, Ma_KhuyenMai, GiaTri, NgayBatDau, NgayKetThuc, TrangThai  FROM KhuyenMai WHERE TrangThai LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getBoolean(6)
                );
                ListNV.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ListNV;
    }

    public List<KhuyenMai> searchKM(String ma) {
        String sql = "SELECT IDKhuyenMai, Ma_KhuyenMai, GiaTri, NgayBatDau, NgayKetThuc, TrangThai  FROM KhuyenMai WHERE Ma_KhuyenMai LIKE ?";
        List<KhuyenMai> listKM = new ArrayList<>();
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getBoolean(6)
                );
                listKM.add(km);
            }
            return listKM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
