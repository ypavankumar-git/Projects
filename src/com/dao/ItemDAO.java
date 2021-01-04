package com.dao;

import java.util.List;
import com.model.Item;


public interface ItemDAO {
  
  public void saveItem(Item item);
  public void deleteItem(int id);
  public Item findItemById(int id);
  public List<Item> listAllItems();
  public void updateItem(Item item);
}
