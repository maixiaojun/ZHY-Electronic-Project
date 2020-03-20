package com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.UserDao;
import com.java.model.User;
import com.java.util.BaseDao;

public class UserDaoImpl implements UserDao {
	 private Connection con=null;
	 private PreparedStatement psmt=null;
	 private ResultSet rs=null;
	 
	//用户登录
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

    //获取所有用户信息
	@Override
	public List<User> getAllUser() {
		List<User> list =new ArrayList<User>();
        try {
            con=BaseDao.getCon();
            String sql="select * from paperless.user";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            
            while(rs.next())
            {
            	Integer id=rs.getInt("id");
                String name=rs.getString("name");
                //String password=rs.getString("password");
                String email=rs.getString("email");
                String phone=rs.getString("phone");
                String site=rs.getString("site");
                User us=new User(id, name, email, phone, site);
                list.add(us);
            }
              rs.close();
              psmt.close();
               
            } catch (Exception e) {
                e.printStackTrace();
            }
        return list;
	}

	//添加用户
	@Override
	public void addUser(User uid) {
		String sql = "insert into paperless.user values(null,?,?,?,?,?)";
		try{
			con = BaseDao.getCon();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, uid.getName());
			psmt.setString(2, uid.getPassword());
			psmt.setString(3, uid.getEmail());
			psmt.setString(4, uid.getPhone());
			psmt.setString(5, uid.getSite());
			psmt.executeUpdate();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}

	//修改用户信息
	@Override
	public boolean updateUser(User uid) {
		String sql = "update paperless.user set name=?, email=?, phone=?, site=? where id= ? ";
		try {
			con = BaseDao.getCon();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, uid.getName());
			//psmt.setString(3,uid.getPassword());
			psmt.setString(2, uid.getEmail());
			psmt.setString(3, uid.getPhone());
			psmt.setString(4, uid.getSite());
			psmt.setInt(5, uid.getId());
			int count = psmt.executeUpdate();
			return count > 0;
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		return false;	
	}

	//删除用户信息
	@Override
	public void deleteUser(int id) {
		String sql = "delete from paperless.user where id= ? ";
		try {
			con = BaseDao.getCon();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}		
	}   
}
