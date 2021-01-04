package com.service;

import java.util.List;

import com.model.Inv_Master;
import com.model.Inv_Trans;
import com.model.Item;

public interface Inv_TransService {
	public void saveInv_Trans(Inv_Trans inv_trans);
    public void deleteinv_Trans();
    public List<Inv_Trans> listAllInv_Trans();
    public List<Inv_Trans> listInv_TransById(int id);
    public void saveList(List<Item> list,Inv_Master inv_master);
    
}
