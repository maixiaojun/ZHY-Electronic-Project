package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	
	static final String url="jdbc:mysql://localhost:3306?useSSL=false&serverTimezone=UTC";
	static final String driver="com.mysql.cj.jdbc.Driver";
	static final String user="root";
	static final String password="WWP.nwcd@123";
	
	public static Connection getCon() throws SQLException, ClassNotFoundException{
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);
		System.out.println("321");
		return con;
	}
	
	
	public static void close(Connection con,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
