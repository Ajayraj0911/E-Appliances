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


@WebServlet("/UpdateProductController")
public class UpdateProductController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		ProductBean product = new ProductBean();
		product.setProductname(request.getParameter("productname"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		product.setDesc(request.getParameter("desc"));
		product.setImgUrl(request.getParameter("imgurl"));
		product.setProductId(Integer.parseInt(request.getParameter("productId")));
		
		ProductDao productDao = new ProductDao();
		if(productDao.updateProduct(product)) {
			request.setAttribute("message", "updates successfuly");
		}else {
			request.setAttribute("message", "some error in DAO");
		}
		
		request.getRequestDispatcher("ListProductController").forward(request, response);
		
		
	}
	
}
