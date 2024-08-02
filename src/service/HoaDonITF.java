/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.math.BigDecimal;
import java.util.List;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public interface HoaDonITF {

    List<HoaDon> getAll();

    void taoHoaDon(int idNhanVien);

    void capNhatTongHoaDon(int idHoaDon, BigDecimal thanhTien);

    void capNhatTrangThai(int idHoaDon, String trangThai);
}
