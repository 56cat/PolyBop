
package model;

import java.math.BigDecimal;
import java.util.Date;

public class HoaDonShow {
    
    private int idHoaDon;
    private int idKhachHang;
    private int idNhanVien;
    private int idKhuyenMai;
    private String maHoaDon;
    private BigDecimal tienSauGiamGia;
    private BigDecimal thanhTien;
    private int phuongThucThanhToan;
    private Date ngayThanhToan;
    private int trangThai;

    public HoaDonShow() {
    }

    public HoaDonShow(int idHoaDon, int idKhachHang, int idNhanVien, int idKhuyenMai, String maHoaDon, BigDecimal tienSauGiamGia, BigDecimal thanhTien, int phuongThucThanhToan, Date ngayThanhToan, int trangThai) {
        this.idHoaDon = idHoaDon;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idKhuyenMai = idKhuyenMai;
        this.maHoaDon = maHoaDon;
        this.tienSauGiamGia = tienSauGiamGia;
        this.thanhTien = thanhTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(int idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public BigDecimal getTienSauGiamGia() {
        return tienSauGiamGia;
    }

    public void setTienSauGiamGia(BigDecimal tienSauGiamGia) {
        this.tienSauGiamGia = tienSauGiamGia;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(int phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
