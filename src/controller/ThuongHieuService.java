package controller;

import repository.INTFThuongHieu;
import dao.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ThuongHieu;

public class ThuongHieuService implements INTFThuongHieu {

    String selectAll = "select *from ThuongHieu";
    String update = "update ThuongHieu set TenThuongHieu =? , TrangThai = ? where Ma_ThuongHieu =?";
    String selectById = "select * from ThuongHieu where IDThuongHieu = ?";
    String selectById1 = "select * from ThuongHieu where Ma_ThuongHieu = ?";
    String insert = "insert into ThuongHieu (Ma_ThuongHieu , TenThuongHieu, TrangThai) values (?,?,?)";

    @Override
    public void insert(ThuongHieu sp) {
        JDBCHelper.update(insert, sp.getMa_ThuongHieu(), sp.getTen_ThuongHieu(), sp.isTrangThai());
    }

    @Override
    public void update(ThuongHieu sp) {

        JDBCHelper.update(update, sp.getTen_ThuongHieu(), sp.isTrangThai(), sp.getMa_ThuongHieu());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ThuongHieu> selectAll() {
        return selectBySQL(selectAll);
    }

    @Override
    public ThuongHieu selectID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ThuongHieu> selectBySQL(String sql, Object... args) {
        List<ThuongHieu> list_th = new ArrayList<>();

        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                ThuongHieu th = new ThuongHieu();
                th.setIdThuongHieu(rs.getInt("IDThuongHieu"));
                th.setMa_ThuongHieu(rs.getString("Ma_ThuongHieu"));
                th.setTen_ThuongHieu(rs.getString("TenThuongHieu"));
                th.setTrangThai(rs.getBoolean("trangThai"));
                list_th.add(th);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_th;
    }

    public String selectNameByID(int id) {
//        return selectBySQL(selectById, id).get(0).getTenThuongHieu();
        List<ThuongHieu> list = selectBySQL(selectById, id);
        if (list.isEmpty()) {
            throw new RuntimeException("Không tìm thấy thương hiệu với ID: " + id);
        }
        return list.get(0).getTen_ThuongHieu();

    }

    public int selectIdByName(String name) {
        String sql = "SELECT * FROM ThuongHieu WHERE TenThuongHieu = ?";
        List<ThuongHieu> list = selectBySQL(sql, name);
        if (list.isEmpty()) {
            // Xử lý khi không tìm thấy thương hiệu với tên tương ứng
            System.out.println("Không tìm thấy thương hiệu với tên: " + name);
            return -1; // Hoặc giá trị mặc định khác, nhưng cần xử lý cẩn thận
        }
        return list.get(0).getIdThuongHieu();

    }

    public ThuongHieu selectID1(String id) {
        List<ThuongHieu> list = selectBySQL(selectById1, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public int selectMaLOAISP() {
        try {
            String sql = "select max(cast(substring(Ma_ThuongHieu,4,LEN(IDThuongHieu))as int)) from  ThuongHieu ";
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
