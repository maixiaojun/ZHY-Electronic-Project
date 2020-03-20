package com.java.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.biz.UserBiz;
import com.java.dao.UserDao;
import com.java.dao.impl.UserDaoImpl;
import com.java.model.User;


@WebServlet("/User")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserBiz ud = new UserBiz();

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doPost(request, response);
	}
	
	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String type = request.getParameter("type");
		
		System.out.println("123hhhhh");
		if("add".equals(type)){
			add(request, response);
		}else if("update".equals(type)){
			update(request, response);
		}else if("delete".equals(type)){
			delete(request, response);
		}		
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String site = request.getParameter("site");
		
		User uid = new User();
		uid.setName(name);
		uid.setPassword(password);
		uid.setEmail(email);
		uid.setPhone(phone);
		uid.setSite(site);
		ud.addUser(uid);
		response.sendRedirect("index/UserList.jsp");
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//int page = Integer.parseInt(request.getParameter("page"));
		ud.deleteUser(id);
		
		response.sendRedirect("index/UserList.jsp");
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		//String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String site = request.getParameter("site");
		
		User uid = new User(name, email,phone, site);
		uid.setId(Integer.parseInt(id));
		ud.updateUser(uid);
		System.out.println("345");
		response.sendRedirect("index/UserList.jsp");
	}

}
