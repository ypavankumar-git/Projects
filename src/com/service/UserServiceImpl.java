package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDAO;
import com.model.User;

@Service("userserviceimpl")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userdao;
	
	@Override
	public void saveUser(User user) {
		userdao.saveUser(user);
		
	}

	@Override
	public void deleteUser(int uid) {
		userdao.deleteUser(uid);
		
	}

	@Override
	public User findUserById(int uid) {
		User user=userdao.findUserById(uid);
		return user;
	}

	@Override
	public List<User> listAllUsers() {
		List<User> users=userdao.listAllUsers();
		return users;
	}

	@Override
	public void changeFlagById(int id) {
		User user=userdao.findUserById(id);
		int flag=user.getFlag();
		flag=(flag==1)?0:1;
		user.setFlag(flag);
		userdao.updateUser(user);
		
	}

	@Override
	public void updateUserById(int id) {
		User user=userdao.findUserById(id);
		user.setUid(1);
		user.setUname("");
		user.setUpass("");
		user.setPower("");
		userdao.updateUser(user);
	}
	
	public String getPower(User user) {
		String name=user.getUname();
		String password=user.getUpass();
		User user1=userdao.findUserByName(name);
		System.out.println(user1.getPower());
		return user1.getPower();
	}

	@Override
	public User findUserByName(String name) {
		User user=userdao.findUserByName(name);
		System.out.println(user.getUname()+"inside userservice layer");
		return user;
	}

	@Override
	public int getFlag(User user) {
		String name=user.getUname();
		User user1=userdao.findUserByName(name);
		System.out.println(user1.getFlag());
		return user1.getFlag();
	}

	@Override
	public void changeFlag(User user) {
//		String name=user.getUname();
//		User user1=userdao.findUserByName(name);
		int flag=user.getFlag();
		int newflag=flag==1?0:1;
		user.setFlag(newflag);
		userdao.updateUser(user);
		
	}
   
}
