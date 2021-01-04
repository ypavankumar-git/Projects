package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ItemDAO;
import com.model.Item;


@Service("itemserviceimpl")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemdao;
	
	@Override
	public void saveItem(Item item) {
	  itemdao.saveItem(item);	
		
	}

	@Override
	public void deleteItem(int id) {
		itemdao.deleteItem(id);
		
	}

	@Override
	public Item findItemById(int id) {
		Item item=itemdao.findItemById(id);
		return item;
	}

	@Override
	public List<Item> listAllItems() {
		List<Item> items=itemdao.listAllItems();
		return items;
	}

	@Override
	public void updateItemById(int id) {
		Item item=itemdao.findItemById(id);
		item.setItem_no(1);
		item.setItem_name("");
		item.setUnit("");
		item.setPrize(1);
		item.setCategory("");
		itemdao.updateItem(item);
		
	}

	@Override
	public int getPrizeById(int id) {
		Item item=itemdao.findItemById(id);
		return item.getPrize();
	}
   
}
