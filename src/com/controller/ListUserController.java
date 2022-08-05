package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/ListUserController")
public class ListUserController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		UserDao userDao = new UserDao();
		
		ArrayList<UserBean> users = userDao.getAllUsers();
		
		request.setAttribute("users", users);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListUsers.jsp");
		rd.forward(request, response);
		
	}
}
