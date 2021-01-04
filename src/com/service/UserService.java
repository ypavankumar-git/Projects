package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	   public void saveUser(User user);
	   public void deleteUser(int uid);
	   public User findUserById(int uid);
	   public List<User> listAllUsers();
	   public void changeFlagById(int id);
	   public void updateUserById(int id);
	   public String getPower(User user);
	   public User findUserByName(String name);
	   public int getFlag(User user);
	   public void changeFlag(User user);
}
