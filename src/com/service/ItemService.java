package com.service;

import java.util.List;

import com.model.Item;

public interface ItemService {
	  public void saveItem(Item item);
	  public void deleteItem(int id);
	  public Item findItemById(int id);
	  public List<Item> listAllItems();
      public void updateItemById(int id);
      public int getPrizeById(int id);
}
