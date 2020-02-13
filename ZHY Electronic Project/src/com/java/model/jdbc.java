package com.java.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	
	public static void main(String[] args) throws SQLException{
		//1.注册jdbc驱动
		  String driverName="com.mysql.cj.jdbc.Driver";
		//2.获取连接对象
		  String dbURL="jdbc:mysql://localhost:3306?useSSL=false&serverTimezone=UTC";
		  String userName="root";		
		  String userPwd="WWP.nwcd@123";//数据库密码（自己设置的）
	try{
		Class.forName(driverName);
		System.out.println("加载驱动成功！");
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("加载驱动失败！");
	}
	try{
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		System.out.println("连接数据库成功！");
	}catch(Exception e){
		e.printStackTrace();
		System.out.print("MySQL80连接失败！");
	}	
		Connection Conn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement stat=Conn.createStatement();
	}

}

