package repository;

import model.SanPham;
import controller.SanPhamRepository;
import controller.SanPhamRepository;

public class SanPhamDAO {
    
    SanPhamRepository dao = new SanPhamRepository();
    
    public void insert(SanPham sp){
        dao.insert(sp);
    }
    
    public void update(SanPham sp){
        dao.update(sp);
    }
   
}
