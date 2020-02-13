package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.AdminDao;
import com.java.dao.impl.AdminDaoImpl;
import com.java.model.Admin;


/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Admin admin = new Admin();
		String adminname = request.getParameter("adminname");
		String password = request.getParameter("password");
		System.out.println(adminname+" "+password);
		
		admin.setAdminname(adminname);
		admin.setPassword(password);
		
		AdminDao admindao=new AdminDaoImpl();
		Admin ad=admindao.login(admin);
		
		System.out.println(ad);
		if(ad!=null){
			request.setAttribute("info", "Yes-0");
			request.getRequestDispatcher("/index/AdminMain.jsp").forward(request, response);
		}else{
			request.setAttribute("info", "No-1");
			request.getRequestDispatcher("/index/AdminLogin.jsp").forward(request, response);
		}
	
	}

}
