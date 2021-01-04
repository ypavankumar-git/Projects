package com.dao;

import java.util.List;

import com.model.User;

public interface UserDAO {
   public void saveUser(User user);
   public void deleteUser(int uid);
   public User findUserById(int uid);
   public List<User> listAllUsers();
   public void updateUser(User user);
   public User findUserByName(String uname); 
}
