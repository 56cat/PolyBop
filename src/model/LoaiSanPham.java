package model;

public class LoaiSanPham {

    private int idLoaiSanPham;
    private String maLoaiSanPham;
    private String tenLoaiSanPham;
    private boolean trangThai;

    public LoaiSanPham() {
    }

    public LoaiSanPham(int idLoaiSanPham, String maLoaiSanPham, String tenLoaiSanPham, boolean trangThai) {
        this.idLoaiSanPham = idLoaiSanPham;
        this.maLoaiSanPham = maLoaiSanPham;
        this.tenLoaiSanPham = tenLoaiSanPham;
        this.trangThai = trangThai;
    }

    public int getIdLoaiSanPham() {
        return idLoaiSanPham;
    }

    public void setIdLoaiSanPham(int idLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
    }

    public String getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(String maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
