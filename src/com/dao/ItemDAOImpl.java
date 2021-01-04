package com.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Item;

@Repository("itemdaoimpl")
public class ItemDAOImpl implements ItemDAO{

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
	public void saveItem(Item item) {
		getSession().persist(item);
	}

	@Override
	public void deleteItem(int id) {
		 Query query=getSession().createSQLQuery("delete from Item where item_no =: id");
		 query.setInteger("id", id);
		 query.executeUpdate();
		
	}

	@Override
	public Item findItemById(int id) {
		 return (Item)getSession().get(Item.class,id);
	}

	@Override
	public List<Item> listAllItems() {
		Criteria criteria = getSession().createCriteria(Item.class);
		return  (List<Item>)criteria.list();
		
	}
	@Override
	public void updateItem(Item item) {
		getSession().update(item);
		
	}

}
