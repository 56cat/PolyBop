package repository;

import controller.SanPhamCTRepository;
import controller.ViRepository;
import java.util.List;
import model.SanPhamCT_Ten;
import controller.SanPhamCTRepository;
import controller.ViRepository;


public class SanPhamCTDAO {
    ViRepository viRepository;
    SanPhamCTRepository sanPhamDAO = new SanPhamCTRepository();
    public List<SanPhamCT_Ten> getAll(){
        return viRepository.getAll();
    }
}
