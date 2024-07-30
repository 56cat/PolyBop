package model;

import java.math.BigDecimal;

public class SanPhamCT_Ten {

    private String maSanPham;
    private String tenSanPham;
    private String kieuDang;
    private String thuongHieu;
    private String mauSac;
    private int soLuong;
//    private double giaBan;
    private BigDecimal giaBan;
    public SanPhamCT_Ten() {
    }

//    public SanPhamCT_Ten(String maSanPham, String tenSanPham, String kieuDang, String thuongHieu, String mauSac, int soLuong, double giaBan) {
//        this.maSanPham = maSanPham;
//        this.tenSanPham = tenSanPham;
//        this.kieuDang = kieuDang;
//        this.thuongHieu = thuongHieu;
//        this.mauSac = mauSac;
//        this.soLuong = soLuong;
//        this.giaBan = giaBan;
//    }

    public SanPhamCT_Ten(String maSanPham, String tenSanPham, String kieuDang, String thuongHieu, String mauSac, int soLuong, BigDecimal giaBan) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.kieuDang = kieuDang;
        this.thuongHieu = thuongHieu;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }
    

    public SanPhamCT_Ten(String maSanPham, String tenSanPham, String kieuDang, String thuongHieu, String mauSac) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.kieuDang = kieuDang;
        this.thuongHieu = thuongHieu;
        this.mauSac = mauSac;
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

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

//    public double getGiaBan() {
//        return giaBan;
//    }
//
//    public void setGiaBan(double giaBan) {
//        this.giaBan = giaBan;
//    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }
    

}
