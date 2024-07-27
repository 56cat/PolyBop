package model;

public class ThuongHieu {

    private int idThuongHieu;
    private String Ma_ThuongHieu;
    private String ten_ThuongHieu;
    private boolean trangThai;

    public ThuongHieu() {
    }

    public ThuongHieu(int idThuongHieu, String Ma_ThuongHieu, String ten_ThuongHieu, boolean trangThai) {
        this.idThuongHieu = idThuongHieu;
        this.Ma_ThuongHieu = Ma_ThuongHieu;
        this.ten_ThuongHieu = ten_ThuongHieu;
        this.trangThai = trangThai;
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public String getMa_ThuongHieu() {
        return Ma_ThuongHieu;
    }

    public void setMa_ThuongHieu(String Ma_ThuongHieu) {
        this.Ma_ThuongHieu = Ma_ThuongHieu;
    }

    public String getTen_ThuongHieu() {
        return ten_ThuongHieu;
    }

    public void setTen_ThuongHieu(String ten_ThuongHieu) {
        this.ten_ThuongHieu = ten_ThuongHieu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
