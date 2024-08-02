package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.LoaiSanPham;
import dao.JDBCHelper;
import service.INTFLoaiSanPham;

public class LoaiSanPhamDao implements INTFLoaiSanPham {

    String selectAll = "select * from LoaiSanPham";
    String selectID = "select * from LoaiSanPham where  Ma_LoaiSanPham = ?";
    String selectById = "select * from LoaiSanPham where IDLoaiSanPham =?";
    String update = "update LoaiSanPham set  TenLoaiSanPham =?, TrangThai=? where Ma_LoaiSanPham=?";
    String insert = "INSERT INTO LoaiSanPham (Ma_LoaiSanPham, TenLoaiSanPham, TrangThai) VALUES (?, ?, ?)";
    @Override
    public void insert(LoaiSanPham sp) {
        JDBCHelper.update(insert, sp.getMaLoaiSanPham(),sp.getTenLoaiSanPham(),sp.isTrangThai());
    }

    @Override
    public void update(LoaiSanPham sp) {
        JDBCHelper.update(update, sp.getTenLoaiSanPham(),sp.isTrangThai(),sp.getMaLoaiSanPham());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LoaiSanPham selectID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LoaiSanPham> selectAll() {
        return selectBySQL(selectAll);
    }

    @Override
    public List<LoaiSanPham> selectBySQL(String sql, Object... args) {
        List<LoaiSanPham> lisst = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                LoaiSanPham ms = new LoaiSanPham();
                ms.setIdLoaiSanPham(rs.getInt("IDLoaiSanPham"));
                ms.setMaLoaiSanPham(rs.getString("Ma_LoaiSanPham"));
                ms.setTenLoaiSanPham(rs.getString("TenLoaiSanPham"));
                ms.setTrangThai(rs.getBoolean("TrangThai"));
                lisst.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lisst;
    }

    public String selecNameById(int id) {
        return selectBySQL(selectById, id).get(0).getTenLoaiSanPham();
    }
        public int selectIdByName(String name){
        String sql = "select * from LoaiSanPham where TenLoaiSanPham =?";
        return selectBySQL(sql, name).get(0).getIdLoaiSanPham();
    }
    public LoaiSanPham selectID1(String id) {
        List<LoaiSanPham> list = selectBySQL(selectID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(Ma_LoaiSanPham,4,LEN(IDLoaiSanPham))as int)) from LoaiSanPham ";
            ResultSet rs = JDBCHelper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
