package model;

public class SanPhamCT_ID {

    private String maCTSP;
    private String ten_MauSac;
    private String ten_ChatLieu;
    private String khoaSanPham;
    private int soLuongSP;
    private double giaNhapSP;
    private double giaBanSP;
    private String ngayNhap;

    public SanPhamCT_ID(String maCTSP, String ten_MauSac, String ten_ChatLieu, String khoaSanPham, int soLuongSP, double giaNhapSP, double giaBanSP, String ngayNhap) {
        this.maCTSP = maCTSP;
        this.ten_MauSac = ten_MauSac;
        this.ten_ChatLieu = ten_ChatLieu;
        this.khoaSanPham = khoaSanPham;
        this.soLuongSP = soLuongSP;
        this.giaNhapSP = giaNhapSP;
        this.giaBanSP = giaBanSP;
        this.ngayNhap = ngayNhap;
    }

    public SanPhamCT_ID() {
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public String getTen_MauSac() {
        return ten_MauSac;
    }

    public void setTen_MauSac(String ten_MauSac) {
        this.ten_MauSac = ten_MauSac;
    }

    public String getTen_ChatLieu() {
        return ten_ChatLieu;
    }

    public void setTen_ChatLieu(String ten_ChatLieu) {
        this.ten_ChatLieu = ten_ChatLieu;
    }

    public String getKhoaSanPham() {
        return khoaSanPham;
    }

    public void setKhoaSanPham(String khoaSanPham) {
        this.khoaSanPham = khoaSanPham;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public double getGiaNhapSP() {
        return giaNhapSP;
    }

    public void setGiaNhapSP(double giaNhapSP) {
        this.giaNhapSP = giaNhapSP;
    }

    public double getGiaBanSP() {
        return giaBanSP;
    }

    public void setGiaBanSP(double giaBanSP) {
        this.giaBanSP = giaBanSP;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

}
