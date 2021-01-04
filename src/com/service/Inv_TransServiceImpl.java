package com.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Inv_TransDAO;
import com.model.Inv_Master;
import com.model.Inv_Trans;
import com.model.Item;
@Service("inv_transserviceimpl")
@Transactional
public class Inv_TransServiceImpl implements Inv_TransService {

	@Autowired
	private Inv_TransDAO inv_transdao;
	@Override
	public void saveInv_Trans(Inv_Trans inv_trans) {
		inv_transdao.saveInv_Trans(inv_trans);
		
	}

	@Override
	public void deleteinv_Trans() {
//		inv_transdao.saveInv_Trans(inv_trans);
		
	}

	@Override
	public List<Inv_Trans> listAllInv_Trans() {
		List<Inv_Trans> list=inv_transdao.listAllInv_Trans();
		return list;
	}

	@Override
	public List<Inv_Trans> listInv_TransById(int id) {
		List<Inv_Trans> list=inv_transdao.listInv_TransById(id);
		return list;
	}

	@Override
	public void saveList(List<Item> list,Inv_Master inv_master) {
		Iterator<Item> itr=list.iterator();
		while(itr.hasNext()) {
			Inv_Trans inv_trans=new Inv_Trans();
			inv_trans.setInv_master(inv_master);
			inv_trans.setItem(itr.next());
			inv_transdao.saveInv_Trans(inv_trans);
		}
		
	}

	

}
