package repository;

import model.SanPham;

public class SanPhamService {
    
    SanPhamRepository dao = new SanPhamRepository();
    
    public void insert(SanPham sp){
        dao.insert(sp);
    }
    
    public void update(SanPham sp){
        dao.update(sp);
    }
   
}
