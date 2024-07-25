package model;

public class MauSac {

    private int idMauSac;
    private String Ma_MauSac;
    private String ten_MauSac;
    private boolean trangThai;

    public MauSac() {
    }

    public MauSac(int idMauSac, String Ma_MauSac, String ten_MauSac, boolean trangThai) {
        this.idMauSac = idMauSac;
        this.Ma_MauSac = Ma_MauSac;
        this.ten_MauSac = ten_MauSac;
        this.trangThai = trangThai;
    }

    public int getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(int idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getMa_MauSac() {
        return Ma_MauSac;
    }

    public void setMa_MauSac(String Ma_MauSac) {
        this.Ma_MauSac = Ma_MauSac;
    }

    public String getTen_MauSac() {
        return ten_MauSac;
    }

    public void setTen_MauSac(String ten_MauSac) {
        this.ten_MauSac = ten_MauSac;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

   

}
