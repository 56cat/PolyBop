package service;

import java.util.List;
import model.MauSac;

public interface INTFMauSac {

    abstract public void insert(MauSac sp);

    abstract public void update(MauSac sp);

    abstract public void delete(Integer id);

    abstract public MauSac selectID(Integer id);

    abstract public List<MauSac> selectAll();

    abstract public List<MauSac> selectBySQL(String sql, Object... args);
}
