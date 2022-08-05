package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		
		UserBean user = userDao.login(email, password);
		
		RequestDispatcher rd = null;
		
		Boolean isError = false;
		if(email==null || email.trim().length() == 0) {
			isError=true;
			request.setAttribute("emailError", "Please enter email");
		}else {
			request.setAttribute("emailValue", email);
		}
		if(password==null || password.trim().length() == 0) {
			isError=true;
			request.setAttribute("passwordError", "Please enter password");
		}else {
			request.setAttribute("passwordValue", password);
		}

		if (user == null || isError==true) {
			request.setAttribute("errormsg", "Invalid Credential");
			rd = request.getRequestDispatcher("Login.jsp");
		}else {
			
			HttpSession session  = request.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("firstName", user.getFirstName());
		 
			
			if(user.getUserType().equals("customer")) {
				request.setAttribute("firstName", user.getFirstName());
				rd = request.getRequestDispatcher("CustomerHome.jsp");
			}else if (user.getUserType().equals("admin")) {
				rd = request.getRequestDispatcher("Dashboard.jsp");
			}else {
				rd = request.getRequestDispatcher("404.jsp");
			}
		}
		rd.forward(request, response);
	}
}
