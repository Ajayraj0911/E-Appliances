package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.dao.UserDao;

@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int productid = Integer.parseInt(request.getParameter("productid"));
		
		ProductDao productDao = new ProductDao();
		
		if(productDao.deleteProduct(productid)) {
			request.setAttribute("message", "Delete product successfully");
		}else{
			request.setAttribute("message", "some error in DAo");
		}
		request.getRequestDispatcher("ListProductController").forward(request, response);
	}
	
}
