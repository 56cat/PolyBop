package repository;

import model.SanPham;
import repository.SanPhamRepository;
import repository.SanPhamRepository;

public class SanPhamDAO {
    
    SanPhamRepository dao = new SanPhamRepository();
    
    public void insert(SanPham sp){
        dao.insert(sp);
    }
    
    public void update(SanPham sp){
        dao.update(sp);
    }
   
}
