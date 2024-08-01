package service;

import java.util.List;
import model.ChatLieu;

public interface INTFChatLieu {
          abstract public void insert(ChatLieu sp);
    
    abstract public void update(ChatLieu sp);
    
    abstract public void delete(Integer id);
    
    
    abstract public ChatLieu selectID(String id);
    
    abstract public List<ChatLieu> selectAll();
    
    abstract public List<ChatLieu> selectBySQL(String sql, Object...args);
}
