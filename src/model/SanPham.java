package model;

public class SanPham {
    private int idSanPham;
    private int idLoaiSanPham;
    private int idThuongHieu;
    private String maSanPham;
    private String tenSanPham;
    private String kieuDang;
    private String url_Anh;
    private boolean trangThai;

    public SanPham() {
    }

    public SanPham(int idSanPham, int idLoaiSanPham, int idThuongHieu, String maSanPham, String tenSanPham, String kieuDang, String url_Anh, boolean trangThai) {
        this.idSanPham = idSanPham;
        this.idLoaiSanPham = idLoaiSanPham;
        this.idThuongHieu = idThuongHieu;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.kieuDang = kieuDang;
        this.url_Anh = url_Anh;
        this.trangThai = trangThai;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdLoaiSanPham() {
        return idLoaiSanPham;
    }

    public void setIdLoaiSanPham(int idLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    public String getUrl_Anh() {
        return url_Anh;
    }

    public void setUrl_Anh(String url_Anh) {
        this.url_Anh = url_Anh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    
   
    
}
