package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String productname = request.getParameter("productname");
		String eprice = request.getParameter("price");
		String equantity = request.getParameter("quantity");
		String desc = request.getParameter("desc");
		String imgurl = request.getParameter("imgurl");
		int price =0;
		int quantity = 0;
		ProductBean productBean = new ProductBean();

		Boolean isError = false;
		if(productname == null || productname.trim().length() == 0) {
			isError=true;
			request.setAttribute("productNameError", "<font color='red'>Please enter product name</font>");
		}else {
			request.setAttribute("productNameValue", productname);
		}
		if(imgurl == null || imgurl.trim().length() == 0) {
			isError=true;
			request.setAttribute("imgurlError", "<font color='red'>Please enter imgUrl</font>");
		}else {
			request.setAttribute("imgurlValue", imgurl);
		}
		if(desc == null || desc.trim().length() == 0) {
			isError=true;
			request.setAttribute("descError", "<font color='red'>Please enter description</font>");
		}else {
			request.setAttribute("descValue", desc);
		}
		if(eprice==null || eprice.trim().length() == 0) {
			isError=true;
			request.setAttribute("priceError", "<font color='red'>Please enter price</font>");

		}else {
			price = Integer.parseInt(eprice);
			request.setAttribute("priceValue", price);
		}
		if(equantity==null || equantity.trim().length() == 0) {
			isError=true;
			request.setAttribute("quantityError", "<font color='red'>Please enter quantity</font>");
		}else {
			quantity = Integer.parseInt(equantity);
			request.setAttribute("quantityValue", quantity);
		}
		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("Product.jsp");
		} else {
			ProductDao productDao = new ProductDao();
			
		productBean.setProductname(productname);
		productBean.setPrice(price);
		productBean.setQuantity(quantity);
		productBean.setImgUrl(imgurl);
		productBean.setDesc(desc);		
		
		productDao.insertProduct(productBean);
		
		request.setAttribute("msg", "Product inserted...");
		rd = request.getRequestDispatcher("ListProductController");
		
		}
		rd.forward(request, response);
	}
}
