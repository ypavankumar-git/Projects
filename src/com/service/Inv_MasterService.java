package com.service;

import java.util.Date;
import java.util.List;

import com.model.Inv_Master;

public interface Inv_MasterService {
	public void saveInv_Master(Inv_Master inv_master);
	   public void deleteInv_Master(int id);
	   public List<Inv_Master> listAllInv_Masters();
	   public List<Inv_Master> listByUserId(int id);
	   public List<Inv_Master> listByUserIdBetweenDates(String id,Date d1,Date d2);
	   public List<Inv_Master> listByUserIdAfterDate(Date d1);
	   public int findLastInvoice();
}
