package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;
import com.dao.UserDao;

@WebServlet("/ListProductController")
public class ListProductController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductDao productDao = new ProductDao();
		
		ArrayList<ProductBean> products = productDao.getAllProducts();
		
		request.setAttribute("products",products);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListProducts.jsp");
		rd.forward(request, response);
		 
	}
}
