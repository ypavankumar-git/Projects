package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Inv_Master;
import com.model.Inv_Trans;

@Repository("inv_transdaoimpl")
public class Inv_TransDAOImpl implements Inv_TransDAO {

	@Autowired 
	private SessionFactory sessionFactory;
	 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession(){
	    return getSessionFactory().getCurrentSession();
	}
	@Override
	public void saveInv_Trans(Inv_Trans inv_trans) {
		getSession().save(inv_trans);
		
	}

	@Override
	public void deleteinv_Trans() {
//		Query query=getSession().createSQLQuery("delete from Inv_Trans where inv_id =: id");
//		query.setInteger("id",id);
//		query.executeUpdate();
		
	}

	@Override
	public List<Inv_Trans> listAllInv_Trans() {
		Criteria criteria = getSession().createCriteria(Inv_Trans.class);
		return  (List<Inv_Trans>)criteria.list(); 
	}

	@Override
	public List<Inv_Trans> listInv_TransById(int id) {
		Query query=getSession().createQuery("from Inv_Trans inv_trans where inv_trans.inv_no =: id");
		query.setInteger("id",id);
		List<Inv_Trans> list=query.list();
		return list;
	}

}
