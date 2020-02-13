package com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.dao.UserDao;
import com.java.model.User;
import com.java.util.BaseDao;



public class UserDaoImpl implements UserDao {
	
	@Override
	public User login(User user) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=BaseDao.getCon();
			String sql="select * from electronic.user where username=? and password=? ";
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs=ps.executeQuery();
			User users=null;
			if(rs.next()){
				users=new User();
				
				users.setUser_id(rs.getInt("user_id"));
				users.setUsername(rs.getString("username"));
				users.setPassword(rs.getString("password"));
				
				return user;
			}else{
				
				return null;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
