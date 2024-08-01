package repository;

import dao.DBconnect;
import java.sql.*;
import java.util.ArrayList;
import model.SanPhamCT_Ten;

public class ViRepository {

    DBconnect dBconnect;

    public ArrayList<SanPhamCT_Ten> getAll() {
        String sql = " SELECT Ma_SanPham,\n"
                + "		TenSanPham,\n"
                + "		KieuDang,\n"
                + "		ThuongHieu.TenThuongHieu,\n"
                + "		MauSac.TenMauSac,\n"
                + " FROM Vi \n"
                + " JOIN (ChiTietSanPham JOIN MauSac ON ChiTietSanPham.ID_MauSac = MauSac.IDMauSac) ON SanPham.IDSanPham = ChiTietSanPham.ID_SanPham \n"
                + " JOIN ThuongHieu ON SanPham.ID_ThuongHieu = ThuongHieu.IDThuongHieu ";
        ArrayList<SanPhamCT_Ten> list = new ArrayList<>();
        try (Connection con = dBconnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SanPhamCT_Ten sp = new SanPhamCT_Ten(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
