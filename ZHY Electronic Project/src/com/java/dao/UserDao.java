package com.java.dao;

import java.util.List;

import com.java.model.User;

public interface UserDao {
	
	public User login(User user);
	
	public List<User> getAllUser();

	public void addUser(User uid);
	
	public boolean updateUser(User uid);
	
	public void deleteUser(int id);

}
