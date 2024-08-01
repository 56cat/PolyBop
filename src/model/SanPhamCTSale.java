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
public class SanPhamCTSale {
    
    private String maSPCT ; 
    private String tenSanPham ; 
    private String tenMauSac ; 
    private String tenThuongHieu; 
    private String tenChatLieu ; 
    private int soLuong ; 
    private BigDecimal giaBan ; 

    public SanPhamCTSale() {
    }

    public SanPhamCTSale(String maSPCT, String tenSanPham, String tenMauSac, String tenThuongHieu, String tenChatLieu, int soLuong, BigDecimal giaBan) {
        this.maSPCT = maSPCT;
        this.tenSanPham = tenSanPham;
        this.tenMauSac = tenMauSac;
        this.tenThuongHieu = tenThuongHieu;
        this.tenChatLieu = tenChatLieu;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
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

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    

    @Override
    public String toString() {
        return "SanPhamCTSale{" + "maSPCT=" + maSPCT + ", tenSanPham=" + tenSanPham + ", tenMauSac=" + tenMauSac + ", tenThuongHieu=" + tenThuongHieu + ", tenChatLieu=" + tenChatLieu + "soLuong=" + soLuong + ", giaBan=" + giaBan + '}';
    }
  
    
}
