package repository;

import repository.SanPhamCTRepository;
import repository.ViRepository;
import java.util.List;
import model.SanPhamCT_Ten;
import repository.SanPhamCTRepository;
import repository.ViRepository;


public class SanPhamCTDAO {
    ViRepository viRepository;
    SanPhamCTRepository sanPhamDAO = new SanPhamCTRepository();
    public List<SanPhamCT_Ten> getAll(){
        return viRepository.getAll();
    }
}
