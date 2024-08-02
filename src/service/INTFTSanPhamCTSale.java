/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.SanPhamCTSale;

/**
 *
 * @author Admin
 */
public interface INTFTSanPhamCTSale {

    List<SanPhamCTSale> getData(String key);

    void suaSLSPCT(int idSPCT, int soLuong);

    void themSoLuongSP(int idSPCT, int soLuong);
}
