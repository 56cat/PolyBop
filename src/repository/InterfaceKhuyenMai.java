/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.KhuyenMai;

/**
 *
 * @author dangc
 */
public interface InterfaceKhuyenMai {
    List<KhuyenMai> getKhuyenMai();
    int getGiaTriKM(String maKH);
}
