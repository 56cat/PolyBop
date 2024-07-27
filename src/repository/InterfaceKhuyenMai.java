/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import model.KhuyenMai;
import java.util.List;

/**
 *
 * @author dangc
 */
public interface InterfaceKhuyenMai {
    List<KhuyenMai> getKhuyenMai();
    int getGiaTriKM(String maKH);
}
