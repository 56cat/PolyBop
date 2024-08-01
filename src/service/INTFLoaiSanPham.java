package service;

import java.util.List;
import model.LoaiSanPham;

public interface INTFLoaiSanPham {

    abstract public void insert(LoaiSanPham sp);

    abstract public void update(LoaiSanPham sp);

    abstract public void delete(Integer id);

    abstract public LoaiSanPham selectID(Integer id);

    abstract public List<LoaiSanPham> selectAll();

    abstract public List<LoaiSanPham> selectBySQL(String sql, Object... args);
}
