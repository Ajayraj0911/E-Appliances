package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

@WebServlet("/DeleteUserController")
public class DeleteUserController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int userid = Integer.parseInt(request.getParameter("userid"));

		UserDao userDao = new UserDao();

		if (userDao.deleteUser(userid)) {
			request.setAttribute("message", "Delete user successfully");
		} else {
			request.setAttribute("message", "some error in DAo");
		}
		request.getRequestDispatcher("ListUserController").forward(request, response);

	}

}
