package model;

import java.util.Date;

public class NhanVien {

    private int id;
    private String maNV;
    private String hoTen;
    private String email;
    private String sdt;
    private int gioiTinh; 
    private Date ngaySinh;
    private int chucVu; 
    private String diaChi;
    private String matkhau;
    private int trangThai; 

    // Constructor
    public NhanVien(int id, String maNV, String hoTen, String email, String sdt, int gioiTinh, Date ngaySinh, int chucVu, String diaChi, String matkhau, int trangThai) {
        this.id = id;
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.chucVu = chucVu;
        this.diaChi = diaChi;
        this.matkhau = matkhau;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getChucVu() {
        return chucVu;
    }

    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    // Methods to convert int to boolean and vice versa
    public boolean isGioiTinh() {
        return gioiTinh == 1;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh ? 1 : 0;
    }

    public boolean isChucVu() {
        return chucVu == 1;
    }

    public void setChucVu(boolean chucVu) {
        this.chucVu = chucVu ? 1 : 0;
    }

    public boolean isTrangThai() {
        return trangThai == 1;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai ? 1 : 0;
    }
}
