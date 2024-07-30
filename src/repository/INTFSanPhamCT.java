package repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import model.SanPhamCT_ID;
import model.SanPhamCT_Ten;

public interface INTFSanPhamCT {

    List<SanPhamCT_Ten> getAll();

    List<SanPhamCT_Ten> seachSP(String key);

    // lấy ra id chi tiết sản phẩm 
    int getIDCTSP(String maSP);

    // trừ số lượng sản phảm trong sản phẩm chi tiết 
    void reduceSLSP(int idCTSP, int soLuong);

    // Cộng số lượng sản phẩm trong sản phẩm chi tiết 
    void addSLSP(int idCTSP, int soLuong);

    // sửa số lượng của sản phẩm 
    void updateSLSP(int IDCTSP, int soLuong);

    // Lấy ra tổng số lượng của sản phẩm 
    int sumSLSP(int IDCTSP, String maHDCT);

    // lấy ra thông tin sản phẩm chi tiết qua quã sản phẩm 
    List<SanPhamCT_ID> getDaTaSPCT(String maSP);

    // 
    int getSoLuongSPCT(String maVi);

    // Thêm chi tiết sản phẩm 
    void addCTSP(int idSP, int idMauSac, int idChatLieu, String maCTSP, String khoaSanPham, int soLuong, double giaNhap, double giaBan, String ngayNhap);

    // update chi tiết sản phẩm 
//    void updateCTSP(int idSP, int idMauSac, int idChatLieu, String maCTSP, String khoaSanPham, int soLuong, double giaNhap, double giaBan, String ngayNhap);
        void updateCTSP(int idSP, int idMauSac, int idChatLieu, String maCTSP, String khoaSanPham, int soLuong, BigDecimal giaNhap, BigDecimal giaBan, String ngayNhap);

}
