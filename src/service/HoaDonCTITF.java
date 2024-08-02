/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.math.BigDecimal;
import java.util.List;
import model.HoaDonCT;

/**
 *
 * @author Admin
 */
public interface HoaDonCTITF {

    List<HoaDonCT> getHDCT(int IDHoaDon);

    void themHDCT(int idHoaDon, int idCTSP, int soLuongSPCT, BigDecimal donGia);

    int getSoLuongSP(int idSPCT, int idHoaDon);

    void suaHDCT(int idSPCT, int idHoaDon, int soLuong, BigDecimal thanhTien);

    void xoaHDCT(int idHDCT);
}
