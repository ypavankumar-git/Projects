package com.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Inv_Master;
import com.model.Item;
import com.service.UserService;
import com.service.UserServiceImpl;

@Repository("inv_masterdaoimpl")
public class Inv_MasterDAOImpl implements Inv_MasterDAO {

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Autowired
	private UserDAO userdao;
	 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession(){
		   try { return sessionFactory.getCurrentSession();}
		   catch (Exception e) {
			return sessionFactory.openSession();
		}
		}
	@Override
	public void saveInv_Master(Inv_Master inv_master) {
		getSession().save(inv_master);
		
	}

	@Override
	public void deleteInv_Master(int id) {
		Query query=getSession().createSQLQuery("delete from Inv_Master where inv_no =: id");
		query.setInteger("id",id);
		query.executeUpdate();
	}

	@Override
	public List<Inv_Master> listAllInv_Masters() {
		Criteria criteria = getSession().createCriteria(Inv_Master.class);
		return  (List<Inv_Master>)criteria.list(); 
	}

	@Override
	public List<Inv_Master> listByUserId(int id) {
		Query query=getSession().createQuery("from Inv_Master inv_master where inv_master.user.uid =:id");
		query.setInteger("id",id);
		List<Inv_Master> list=query.list();
		return list;
	}
    @Override
	public  List<Inv_Master> listByUserIdBetweenDates(String id,Date d1, Date d2) {
		
		Criteria criteria = getSession().createCriteria(Inv_Master.class)
				.add(Restrictions.between("inv_date",d1,d2))
				.add(Property.forName("user.uid").eq(userdao.findUserByName(id).getUid()));
		List<Inv_Master> list=criteria.list();
		Iterator<Inv_Master> itr=list.iterator();
		while(itr.hasNext()) {
			System.out.println("inside masterdaoimpl............."+itr.next().getInv_no()+"......................");
		}
		return list;
	}
	@Override
	public List<Inv_Master> listByUserIdAfterDate(Date d1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
