/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {
    
    private int idHoaDon;
    private int idKhachHang;
    private int idNhanVien;
    private int idKhuyenMai;
    private String maHoaDon;
    private BigDecimal tienSauGiamGia;
    private BigDecimal thanhTien;
    private boolean phuongThucThanhToan;
    private Date ngayThanhToan;
    private boolean trangThai;
    private String tenKH;
    private String tenNV;

    public HoaDon() {
    }

    public HoaDon(int idHoaDon, int idKhachHang, int idNhanVien, int idKhuyenMai, String maHoaDon, BigDecimal tienSauGiamGia, BigDecimal thanhTien, boolean phuongThucThanhToan, Date ngayThanhToan, boolean trangThai, String tenKH, String tenNV) {
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
        this.tenKH = tenKH;
        this.tenNV = tenNV;
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

    public boolean isPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(boolean phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    
}
