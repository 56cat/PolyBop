package repository;

import dao.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import service.INTFChatLieu;

public class ChatLieuDao implements INTFChatLieu {

    String selectAll = "select *from ChatLieu";
    String update = "update ChatLieu set TenChatLieu =? , TrangThai = ? where Ma_ChatLieu =?";
    String selectById = "select * from ChatLieu where IDChatLieu = ?";
    String selectById1 = "select * from ChatLieu where Ma_ChatLieu=?";
    String insert = "insert into ChatLieu(Ma_ChatLieu, TenChatLieu, TrangThai) values (?,?,?)";

    @Override
    public void insert(ChatLieu sp) {
        JDBCHelper.update(insert, sp.getMa_ChatLieu(), sp.getTen_ChatLieu(), sp.isTrangThai());
    }

    @Override
    public void update(ChatLieu sp) {
        JDBCHelper.update(update, sp.getTen_ChatLieu(), sp.isTrangThai(), sp.getMa_ChatLieu());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChatLieu selectID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChatLieu> selectAll() {
        return selectBySQL(selectAll);
    }

    @Override
    public List<ChatLieu> selectBySQL(String sql, Object... args) {
        List<ChatLieu> lisst = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                ChatLieu ms = new ChatLieu();
                ms.setIdChatLieu(rs.getInt("IDChatLieu"));
                ms.setMa_ChatLieu(rs.getString("Ma_ChatLieu"));
                ms.setTen_ChatLieu(rs.getString("TenChatLieu"));
                ms.setTrangThai(rs.getBoolean("TrangThai"));
                lisst.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lisst;
    }

    public ChatLieu selectID1(String id) {
        List<ChatLieu> list = selectBySQL(selectById1, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public int selectMaLOAISP() {
        try {
            String sql = "select max(cast(substring(Ma_ChatLieu,4,LEN(IDChatLieu))as int)) from  ChatLieu ";
            ResultSet rs = JDBCHelper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String selectNameById(int id) {
        return selectBySQL(selectById, id).get(0).getTen_ChatLieu();
    }

    public int selectIdByName(String name) {
        String sql = "select * from ChatLieu where TenChatLieu =?";
        return selectBySQL(sql, name).get(0).getIdChatLieu();
    }
}
