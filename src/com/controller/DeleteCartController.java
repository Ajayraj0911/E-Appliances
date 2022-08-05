package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CartProductBean;
import com.dao.CartDao;
import com.dao.ProductDao;

public class DeleteCartController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cartid = Integer.parseInt(request.getParameter("cartId"));

		CartDao cartDao = new CartDao();

		if (cartDao.deleteProduct(cartid)) {
			request.setAttribute("message", "Delete product successfully");
		} else {
			request.setAttribute("message", "some error in DAo");
		}
		request.getRequestDispatcher("ViewCartController").forward(request, response);
	}

	
}
