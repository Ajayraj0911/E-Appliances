package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/UpdateUserController")
public class UpdateUserController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		UserBean user = new UserBean();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		user.setUserId(Integer.parseInt(request.getParameter("userId")));
		
		UserDao userDao = new UserDao();
		if(userDao.updateUser(user)) {
			request.setAttribute("message", "updates successfuly");
		}else {
			request.setAttribute("message", "some error in DAO");
		}
		
		request.getRequestDispatcher("ListUserController").forward(request, response);
		
	}
	
}
