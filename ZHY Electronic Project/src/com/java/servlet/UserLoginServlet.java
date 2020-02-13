package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.UserDao;
import com.java.dao.impl.UserDaoImpl;
import com.java.model.User;


/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+" "+password);
		
		user.setUsername(username);
		user.setPassword(password);
		
		UserDao userdao=new UserDaoImpl();
		User us=userdao.login(user);
		
		System.out.println(us);
		if(us!=null){
			request.setAttribute("info", "Yes-0");
			request.getRequestDispatcher("/index/UserMain.jsp").forward(request, response);
		}else{
			request.setAttribute("info", "No-1");
			request.getRequestDispatcher("/index/UserLogin.jsp").forward(request, response);
		}
	}

}
