package service;

import java.util.List;
import model.TaiKhoan;

public interface INTFTaiKhoan {
    List<TaiKhoan> getTaiKhoanNV(); 
    List<TaiKhoan> getChucVu(String email); 
    String updateTaiKhoan(String email,String mk); 
    String getNameNV(String email) ; 
}
