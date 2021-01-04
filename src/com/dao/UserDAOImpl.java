package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.model.User;



@Repository("userdaoimpl")
public class UserDAOImpl implements UserDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	 
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
	public void saveUser(User user) {
		getSession().save(user);
	}

	@Override
	public void deleteUser(int uid) {
		Query query=getSession().createSQLQuery("delete from User where uid = :uid");
		query.setInteger("uid",uid);
		query.executeUpdate();
	}

	@Override
	public User findUserById(int uid) {
		return (User)getSession().get(User.class, uid);
	}
	
	

	@Override
	public List<User> listAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
	}
	
	@Override
	public void updateUser(User user) {
		getSession().update(user); 
	}
	@Override
	public User findUserByName(String name) {
		Criteria crit=getSession().createCriteria(User.class);
    	crit.add(Property.forName("uname").eq(name));
    	User user=(User)crit.uniqueResult();
    	System.out.println(user.getUname()+"inside DAO layer...");
    	return user;
	}
	
     
}
