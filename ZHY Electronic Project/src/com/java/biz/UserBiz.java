package com.java.biz;

import java.util.List;

import com.java.dao.UserDao;
import com.java.dao.impl.UserDaoImpl;
import com.java.model.User;

public class UserBiz {
	private UserDao userdao = new UserDaoImpl();
	
	public void addUser(User uid) {
		userdao.addUser(uid);
	}
	
	public boolean updateUser(User uid) {
		return userdao.updateUser(uid);
	}
	
	public void deleteUser(int id) {
		userdao.deleteUser(id);
	}

}
