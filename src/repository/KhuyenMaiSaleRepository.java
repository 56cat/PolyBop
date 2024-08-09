/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dao.DBconnect;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhuyenMaiSaleRepository {
    public List<String> getAllKhuyenMai(){
        List<String> khuyenMai = new ArrayList<>();
        String query = "SELECT Ma_KhuyenMai FROM KhuyenMai";
         try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                khuyenMai.add(rs.getString("Ma_KhuyenMai"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
      return  khuyenMai;
    }
    
     public BigDecimal getGiaTriKM(String maKM){
         BigDecimal giaTri = BigDecimal.ZERO;
        String query = "SELECT GiaTri FROM KhuyenMai WHERE Ma_KhuyenMai =  ? ";
         try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
             ps.setString(1, maKM);
             try (ResultSet rs = ps.executeQuery();) {
                 if (rs.next()) {
                     giaTri = rs.getBigDecimal("GiaTri");
                 }
             }            
        } catch (Exception e) {
            e.printStackTrace();
        }
         return giaTri;
    }
}
