package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CartProductBean;
import com.dao.CartDao;

public class ViewCartController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		CartDao cartDao = new CartDao();
		ArrayList<CartProductBean> carts =  cartDao.getCartItems(userId);
		request.setAttribute("carts", carts);
		
		
		request.getRequestDispatcher("ViewCarts.jsp").forward(request, response);
		
	}
}
 