package controller;

import repository.SanPhamINTF;
import dao.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.SanPham;

public class SanPhamService implements SanPhamINTF {

    String findAllData = "SELECT * FROM SanPham";
    String select_trangThai = "SELECT * FROM SanPham Where TrangThai = 0";
    String selectID1 = "SELECT * FROM SanPham where IDSanPham = ?";
    String selectID = "SELECT * FROM SanPham where Ma_SanPham = ?";
    String insert = "INSERT INTO [SanPham] ( [IDLoaiSanPham], [ID_ThuongHieu], [Ma_SanPham], [KieuDang], [TenSanPham], [Url_Anh], [TrangThai])"
            + " VALUES (?,?,?,?,?,?,?)";
    String update = "UPDATE SanPham SET TenSanPham = ?, KieuDang = ?, ID_ThuongHieu = ?, Url_Anh = ?, TrangThai = ? WHERE Ma_SanPham = ?";
    String delete = "DELETE FROM SanPham where IDSanpham = ?";
    String selectById = "select * from SanPham where IDSanPham =?";
    String select_Trangthai1 = "SELECT * FROM SanPham WHERE Trangthai = 1";

    @Override
    public void insert(SanPham sp) {
        String sql = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([IDLoaiSanPham]\n"
                + "           ,[ID_ThuongHieu]\n"
                + "           ,[Ma_SanPham]\n"
                + "           ,[TenSanPham]\n"
                + "           ,[KieuDang]\n"
                + "           ,[Url_Anh]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (" + sp.getIdLoaiSanPham() + "\n"
                + "           ," + sp.getIdThuongHieu() + "\n"
                + "           ,'" + sp.getMaSanPham() + "'\n"
                + "           ,'" + sp.getTenSanPham() + "'\n"
                + "           ,'" + sp.getKieuDang() + "'\n"
                + "           ,'" + sp.getUrl_Anh() + "'\n"
                + "           ," + (sp.isTrangThai() ? 1 : 0) + "\n"
                + "		   )";
        try (Connection con = JDBCHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(SanPham sp) {
        JDBCHelper.update(update, sp.getTenSanPham(), sp.getKieuDang(), sp.getIdThuongHieu(), sp.getUrl_Anh(), sp.isTrangThai(), sp.getMaSanPham());
    }

    @Override
    public List<SanPham> findAllData() {
        return selectBySQL(select_Trangthai1);
    }

    @Override
    public SanPham selectID(Integer id) {
        List<SanPham> list = selectBySQL(selectID1, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<SanPham> selectByKey(String key) {
        String sql = "SELECT * FROM SanPham Where TenSanPham like ? and IDSanPham like ? and TrangThai = 1";
        return selectBySQL(sql, "%" + key + "%");
    }

    @Override
    public List<SanPham> selectBySQL(String sql, Object... args) {
        List<SanPham> listSP = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getInt("IDSanPham"));
                sp.setIdLoaiSanPham(rs.getInt("IDLoaiSanPham"));
                sp.setIdThuongHieu(rs.getInt("ID_ThuongHieu"));
                sp.setMaSanPham(rs.getString("Ma_SanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setKieuDang(rs.getString("kieuDang"));
                sp.setTrangThai(rs.getBoolean("trangThai"));
                sp.setUrl_Anh(rs.getString("Url_anh"));
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<SanPham> selectAll() {
        return selectBySQL(findAllData);
    }

    public List<SanPham> select_TrangThai() {
        return selectBySQL(select_trangThai);
    }

    @Override
    public int getTotal() {
        String sql = "SELECT COUNT(*) FROM SanPham Where TrangThai = 1";
        ResultSet rs = JDBCHelper.Query(sql);
        try {
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public SanPham selectID1(String id) {
        List<SanPham> list = selectBySQL(selectID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<SanPham> selectByName(String name) {
        String selectByName = "SELECT * FROM SanPham where TenSanPham like ?";
        return selectBySQL(selectByName, "%" + name + "%");
    }

    public int selectMaxID() {
        try {
            String sql = "SELECT MAX(CAST(substring(Ma_SanPham, 3, LEN(IDSanPham))AS int )) From SanPham";
            ResultSet rs = JDBCHelper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String selectNameById(int id) {
        return selectBySQL(selectID, id).get(0).getTenSanPham();
    }

    public int selectIdByName(String name) {
        String sql = "SELECT * FROM SanPham where TenSanPham = ?";
        return selectBySQL(sql, name).get(0).getIdSanPham();
    }

    @Override
    public List<SanPham> getViByPage(int page, int recordInPage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
