/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class HoaDonCT {

    private int idHoaDonChiTiet;
    private int idHoaDon;
    private int idChiTietSanPham;
    private String maHoaDonChiTiet;
    private int soLuong;
    private BigDecimal donGia;
    private boolean trangThai;
    private String tenSanPham;
    private String tenMauSac;
    private String tenChatLieu;
    private BigDecimal giaBan;

    // Constructors
    public HoaDonCT() {
    }

    public HoaDonCT(int idHoaDonChiTiet, int idHoaDon, int idChiTietSanPham, String maHoaDonChiTiet, int soLuong, BigDecimal donGia, boolean trangThai, String tenSanPham, String tenMauSac, String tenChatLieu, BigDecimal giaBan) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
        this.idHoaDon = idHoaDon;
        this.idChiTietSanPham = idChiTietSanPham;
        this.maHoaDonChiTiet = maHoaDonChiTiet;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.tenSanPham = tenSanPham;
        this.tenMauSac = tenMauSac;
        this.tenChatLieu = tenChatLieu;
        this.giaBan = giaBan;
    }

    // Getters and Setters
    public int getIdHoaDonChiTiet() {
        return idHoaDonChiTiet;
    }

    public void setIdHoaDonChiTiet(int idHoaDonChiTiet) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdChiTietSanPham() {
        return idChiTietSanPham;
    }

    public void setIdChiTietSanPham(int idChiTietSanPham) {
        this.idChiTietSanPham = idChiTietSanPham;
    }

    public String getMaHoaDonChiTiet() {
        return maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String maHoaDonChiTiet) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

}
