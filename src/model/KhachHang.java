package model;

import java.util.Date;

public class KhachHang {
    private int IDKhachHang;
    private String TenKhachHang;
    private String SDT;
    private Date NgaySinh;
    private String Email;
    private String DiaChi;
    private int TrangThai;

    public KhachHang() {
    }

    public KhachHang(int IDKhachHang, String TenKhachHang, String SDT, Date NgaySinh, String Email, String DiaChi, int TrangThai) {
        this.IDKhachHang = IDKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.TrangThai = TrangThai;
    }

    public int getIDKhachHang() {
        return IDKhachHang;
    }

    public void setIDKhachHang(int IDKhachHang) {
        this.IDKhachHang = IDKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    
    
    
    
}
