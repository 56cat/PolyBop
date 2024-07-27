package controller;

import model.SanPham;
import controller.SanPhamService;

public class SanPhamDAO {
    
    SanPhamService dao = new SanPhamService();
    
    public void insert(SanPham sp){
        dao.insert(sp);
    }
    
    public void update(SanPham sp){
        dao.update(sp);
    }
   
}
