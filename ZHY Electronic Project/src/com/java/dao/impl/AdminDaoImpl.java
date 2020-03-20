package com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.dao.AdminDao;
import com.java.model.Admin;
import com.java.util.BaseDao;


public class AdminDaoImpl implements AdminDao{
	
	@Override
	public Admin login(Admin admin) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=BaseDao.getCon();
			String sql="select * from electronic.admin where adminname=? and password=? ";
			ps=con.prepareStatement(sql);
			ps.setString(1, admin.getAdminname());
			ps.setString(2, admin.getPassword());
			rs=ps.executeQuery();
			Admin admins=null;
			if(rs.next()){
				admins=new Admin();
				
				admins.setAdmin_id(rs.getInt("admin_id"));
				admins.setAdminname(rs.getString("adminname"));
				admins.setPassword(rs.getString("password"));
				
				return admin;
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
