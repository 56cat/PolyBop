package model;

public class ChatLieu {

    private int idChatLieu;
    private String Ma_ChatLieu;
    private String ten_ChatLieu;
    private boolean trangThai;

    public ChatLieu() {
    }

    public ChatLieu(int idChatLieu, String Ma_ChatLieu, String ten_ChatLieu, boolean trangThai) {
        this.idChatLieu = idChatLieu;
        this.Ma_ChatLieu = Ma_ChatLieu;
        this.ten_ChatLieu = ten_ChatLieu;
        this.trangThai = trangThai;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getMa_ChatLieu() {
        return Ma_ChatLieu;
    }

    public void setMa_ChatLieu(String Ma_ChatLieu) {
        this.Ma_ChatLieu = Ma_ChatLieu;
    }

    public String getTen_ChatLieu() {
        return ten_ChatLieu;
    }

    public void setTen_ChatLieu(String ten_ChatLieu) {
        this.ten_ChatLieu = ten_ChatLieu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

   

}
