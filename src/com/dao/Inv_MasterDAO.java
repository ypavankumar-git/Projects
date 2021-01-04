package com.dao;

import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;

import com.model.Inv_Master;

public interface Inv_MasterDAO {
   public void saveInv_Master(Inv_Master inv_master);
   public void deleteInv_Master(int id);
   public List<Inv_Master> listAllInv_Masters();
   public List<Inv_Master> listByUserId(int id);
   public List<Inv_Master> listByUserIdBetweenDates(String id,Date d1,Date d2);
   public List<Inv_Master> listByUserIdAfterDate(Date d1);
   }
