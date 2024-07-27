/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bravo15
 */
public class DBConnect {
    public static String URL = "jdbc:sqlserver://localhost\\BISNH\\SQLEXPRESS:1433;databaseName=PoLyBop;encrypt=true;trustServerCertificate=true;";
    public static String USERNAME = "sa";
    public static String PASS = "123";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    public static void main(String[] args) {
        Connection cn = getConnection();
        if (cn != null) {
            System.out.println("Done!!");
        } else {
            System.out.println("Error !!");
        }
    }
   
    
}