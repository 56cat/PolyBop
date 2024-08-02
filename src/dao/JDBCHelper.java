/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.DBconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class JDBCHelper {
    
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=PoLyBop";
    static String user = "sa";
    static String password = "123456";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

//    public static PreparedStatement getStmt(String sql, Object... args) throws Exception {
//        Connection con = DriverManager.getConnection(url, user, password);//kết nối
//        PreparedStatement stmt;
//        if (sql.trim().startsWith("{")) {
//            stmt = con.prepareCall(sql);//câu lệnh SQl là thủ tục
//        } else {
//            stmt = con.prepareStatement(sql);//câu lệnh sql select
//        }
//
//        for (int i = 0; i < args.length; i++) {//i = 0 suy ra câu truy vấn không có ?
//            stmt.setObject(i + 1, args[i]);//đẩy dữ liệu vào dấu ?
//        }
//        return stmt;
//    }
    public static PreparedStatement getStmt(String sql, Object... args) throws Exception {
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt;
        if (sql.trim().startsWith("{")) {
            stmt = con.prepareCall(sql);
        } else {
            stmt = con.prepareStatement(sql);
        }

        // Debugging: In ra câu lệnh SQL và các tham số
        System.out.println("SQL: " + sql);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Parameter " + (i + 1) + ": " + args[i]);
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }

    public static ResultSet query(String sql, Object... args) throws Exception {
        PreparedStatement stmt = JDBCHelper.getStmt(sql, args);
        return stmt.executeQuery();//trả về rs "preparestatement có thể chạy executeQuery"
    }

    public static ResultSet Query(String sql, Object... args) {
        Connection con = null;
        PreparedStatement psvm = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            psvm = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                psvm.setObject(i + 1, args[i]);
            }
            return rs = psvm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            close(psvm, con, rs);
            return null;
        }
    }

    public static Object value(String sql, Object... args) {//trả về Mã mỗi bảng
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }//nếu có dữ liệu sẽ không đóng rs nếu đóng không trả đc rs
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public static int update(String sql, Object... args) {
//        try {
//            PreparedStatement stmt = JDBCHelper.getStmt(sql, args);
//            try {
//                return stmt.executeUpdate();
//            } finally {
//                stmt.getConnection().close();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
    public static void update(String sql, Object... params) {
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);
        }
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}


    public static void close(PreparedStatement psvm, Connection con, ResultSet rs) {
        try {
            rs.close();
            con.close();
            psvm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
