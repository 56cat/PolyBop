package repository;

import service.INTFSanPhamCT;
import dao.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.SanPhamCT_ID;
import model.SanPhamCT_Ten;

public class SanPhamCTRepository implements INTFSanPhamCT {

    String update = "Update ChiTietSanPham set ID_MauSac=?, ID_ChatLieu=?, KhoaSanPham=?, SoLuong = ?,GiaNhap = ?, GiaBan = ?, NgayNhap = ? where Ma_ChiTietSanPham = ?";

    @Override
    public List<SanPhamCT_Ten> getAll() {
        String sql = " SELECT Ma_SanPham,\n"
                + "		TenSanPham,\n"
                + "		KieuDang,\n"
                + "		ThuongHieu.TenThuongHieu,\n"
                + "		MauSac.TenMauSac,\n"
                + "		ChiTietSanPham.SoLuong,\n"
                + "		ChiTietSanPham.Giaban\n"
                + " FROM SanPham \n"
                + " JOIN (ChiTietSanPham JOIN MauSac ON ChiTietSanPham.ID_MauSac = MauSac.IDMauSac) ON SanPham.IDSanPham = ChiTietSanPham.ID_SanPham \n"
                + " JOIN ThuongHieu ON SanPham.ID_ThuongHieu = ThuongHieu.IDThuongHieu ";
        List<SanPhamCT_Ten> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamCT_Ten sp = new SanPhamCT_Ten(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDouble(7));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SanPhamCT_Ten> seachSP(String key) {
        String sql = " SELECT Ma_SanPham,\n"
                + "		TenSanPham,\n"
                + "		KieuDang,\n"
                + "		ThuongHieu.TenThuongHieu,\n"
                + "		MauSac.TenMauSac,\n"
                + "		ChiTietSanPham.SoLuong,\n"
                + "		ChiTietSanPham.GiaBan\n"
                + " FROM SanPham \n"
                + " JOIN (ChiTietSanPham JOIN MauSac ON ChiTietSanPham.ID_MauSac = MauSac.IDMauSac) ON SanPham.IDSanPham = ChiTietSanPham.ID_SanPha \n"
                + " JOIN ThuongHieu ON SanPham.ID_ThuongHieu = ThuongHieu.IDThuongHieu Where Ma_SanPham like '%" + key + "%' or TenSanPham like N'%" + key + "%' ";
        List<SanPhamCT_Ten> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamCT_Ten sp = new SanPhamCT_Ten(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDouble(7));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getIDCTSP(String maSP) {
        int id = 0;
        String sql = "SELECT IDChiTietSanPham \n"
                + "FROM ChiTietSanPham join SanPham on ChiTietSanPham.ID_SanPham = SanPham.IDSanPham where Ma_SanPham = '" + maSP + "'";
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

    @Override
    public void reduceSLSP(int idCTSP, int soLuong) {
        String sql = "update ChiTietSanPham set SoLuong = SoLuong - " + soLuong + " where IDChiTietSanPham = " + idCTSP + " ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy ra tổng số lượng sản phẩm 
    @Override
    public int sumSLSP(int IDCTSP, String maHDCT) {
        int sunSL = 0;
        String sql = "	Select ChiTietSanPham.SoLuong + HoaDonChiTiet.SoLuong\n"
                + "	from ChiTietSanPham join HoaDonChiTiet on ChiTietSanPham.IDChiTietSanPham = HoaDonChiTiet.ID_ChiTietSanPham \n"
                + "	where ID_ChiTietSanPham =" + IDCTSP + "  and Ma_HoaDonChiTiet = '" + maHDCT + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sunSL = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sunSL;
    }

    @Override
    public void updateSLSP(int IDCTSP, int soLuong) {
        String sql = "update ChiTietSanPham set SoLuong = " + soLuong + " \n"
                + "where IDChiTietSanPham = " + IDCTSP + " ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addSLSP(int idCTSP, int soLuong) {
        String sql = "update ChiTietSanPham set SoLuong = SoLuong + " + soLuong + " where IDChiTietSanPham = " + idCTSP + " ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // lấy ra thông tin chi tiết của sản phẩm thông qua mã sản phẩm 
    @Override
    public List<SanPhamCT_ID> getDaTaSPCT(String maSP) {
        String sql = "SELECT Ma_ChiTietSanPham, TenMauSac, TenChatLieu, "
                + "KhoaSanPham, SoLuong, GiaNhap, ChiTietSanPham.GiaBan, NgayNhap "
                + "FROM ChiTietSanPham "
                + "JOIN SanPham ON ChiTietSanPham.ID_SanPham = SanPham.IDSanPham "
                + "JOIN MauSac ON ChiTietSanPham.ID_MauSac = MauSac.IDMauSac "
                + "JOIN ChatLieu ON ChiTietSanPham.ID_ChatLieu = ChatLieu.IDChatLieu "
                + "WHERE SanPham.Ma_SanPham LIKE ?";
        List<SanPhamCT_ID> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ngayNhapStr = null;
                Date ngayNhapDate = rs.getDate(8);
                if (ngayNhapDate != null) {
                    ngayNhapStr = new SimpleDateFormat("yyyy-MM-dd").format(ngayNhapDate);
                }

                SanPhamCT_ID spct = new SanPhamCT_ID(
                        rs.getString(1), // Ma_ChiTietSanPham
                        rs.getString(2), // TenMauSac
                        rs.getString(3), // TenChatLieu
                        rs.getString(4), // KhoaSanPham
                        rs.getInt(5), // SoLuong
                        rs.getDouble(6), // GiaNhap
                        rs.getDouble(7), // GiaBan
                        ngayNhapStr // NgayNhap
                );
                list.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getSoLuongSPCT(String maSanPham) {
        int SL = 0;
        String sql = "Select COUNT(Ma_ChiTietSanPham) from ChiTietSanPham where ID_SanPham = (Select IDSanPham from SanPham where Ma_SanPham = '" + maSanPham + "' )";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SL = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SL;
    }

    @Override
    public void addCTSP(int idSP, int idMauSac, int idChatLieu, String maCTSP, String khoaSanPham, int soLuong, double giaNhap, double giaBan, String ngayNhap) {
        String sql = "INSERT INTO [dbo].[ChiTietSanPham]\n"
                + "           ([ID_SanPham]\n"
                + "           ,[ID_MauSac]\n"
                + "           ,[ID_ChatLieu]\n"
                + "           ,[Ma_ChiTietSanPham]\n"
                + "           ,[KhoaSanPham]\n"
                + "           ,[SoLuong]\n"
                + "           ,[GiaNhap]\n"
                + "           ,[GiaBan]\n"
                + "           ,[NgayNhap]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (" + idSP + "\n"
                + "           ," + idMauSac + "\n"
                + "           ," + idChatLieu + "\n"
                //                + "           ," + idLoaiSanPham + "\n"
                + "           ,'" + maCTSP + "'\n"
                + "           ,'" + khoaSanPham + "'\n"
                + "           ," + soLuong + "\n"
                + "           ," + giaNhap + "\n"
                + "           ," + giaBan + "\n"
                + "           ,'" + ngayNhap + "'\n"
                + "           ,1\n"
                + "		   )";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCTSP(int idSP, int idMauSac, int idChatLieu, String maCTSP, String khoaSanPham, int soLuong, double giaNhap, double giaBan, String ngayNhap) {
        String sql = "UPDATE [dbo].[ChiTietSanPham]\n"
                + "   SET [ID_MauSac] = " + idMauSac + " \n"
                + "      ,[ID_ChatLieu] = " + idChatLieu + " \n"
                //                + "      ,[ID_LoaiSanPham] = " + idLoaiSanPham + " \n"
                + "      ,[KhoaSanPham] = '" + khoaSanPham + "'\n"
                + "      ,[SoLuong] = " + soLuong + " \n"
                + "      ,[GiaNhap] = " + giaNhap + " \n"
                + "      ,[GiaBan] = " + giaBan + " \n"
                + "      ,[NgayNhap] = '" + ngayNhap + "'\n"
                + "      ,[TrangThai] = 1 \n"
                + " WHERE ID_SanPham = " + idSP + " and Ma_ChiTietSanPham = '" + maCTSP + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
