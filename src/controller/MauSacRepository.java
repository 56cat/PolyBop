package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.INTFMauSac;
import dao.JDBCHelper;
import model.MauSac;

public class MauSacRepository implements INTFMauSac {

    String selectAll = "select * from MauSac";
    String selectID = "select * from MauSac where Ma_MauSac= ?";
    String selectById = "select * from MauSac where IDMauSac =?";
    String update = "update MauSac set  TenMauSac =?, TrangThai=? where Ma_MauSac=?";
    String insert = "INSERT INTO MauSac (Ma_MauSac, TenMauSac, TrangThai) VALUES (?, ?, ?)";
    @Override
    public void insert(MauSac sp) {
        JDBCHelper.update(insert, sp.getMa_MauSac(),sp.getTen_MauSac(),sp.isTrangThai());
    }

    @Override
    public void update(MauSac sp) {
        JDBCHelper.update(update, sp.getTen_MauSac(),sp.isTrangThai(),sp.getMa_MauSac());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MauSac selectID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MauSac> selectAll() {
        return selectBySQL(selectAll);
    }

    @Override
    public List<MauSac> selectBySQL(String sql, Object... args) {
        List<MauSac> lisst = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setIdMauSac(rs.getInt("IDMauSac"));
                ms.setMa_MauSac(rs.getString("Ma_MauSac"));
                ms.setTen_MauSac(rs.getString("TenMauSac"));
                ms.setTrangThai(rs.getBoolean("trangThai"));
                lisst.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lisst;
    }

    public String selecNameById(int id) {
        return selectBySQL(selectById, id).get(0).getTen_MauSac();
    }
        public int selectIdByName(String name){
        String sql = "select * from MauSac where TenMauSac =?";
        return selectBySQL(sql, name).get(0).getIdMauSac();
    }
    public MauSac selectID1(String id) {
        List<MauSac> list = selectBySQL(selectID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(Ma_MauSac,4,LEN(IDMauSac))as int)) from MauSac ";
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
