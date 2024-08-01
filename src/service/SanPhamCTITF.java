/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.SanPhamCTSale;
import model.SanPhamCT_ID;

/**
 *
 * @author Admin
 */
public interface SanPhamCTITF {
    List<SanPhamCTSale> getData(String key);
}
