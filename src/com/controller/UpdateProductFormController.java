package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;
import com.dao.UserDao;

@WebServlet("/UpdateProductFormController")
public class UpdateProductFormController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int productID = Integer.parseInt(request.getParameter("productid"));
		ProductDao productDao = new ProductDao();
		
		ProductBean product = productDao.getProductByProductID(productID);
		request.setAttribute("product", product);
		request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
		
	}
	
}
