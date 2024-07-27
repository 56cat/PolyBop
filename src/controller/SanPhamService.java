package controller;

import model.SanPham;
import repository.SanPhamRepository;

public class SanPhamService {
    
    SanPhamRepository dao = new SanPhamRepository();
    
    public void insert(SanPham sp){
        dao.insert(sp);
    }
    
    public void update(SanPham sp){
        dao.update(sp);
    }
   
}
