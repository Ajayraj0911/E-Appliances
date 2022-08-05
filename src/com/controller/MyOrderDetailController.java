package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.OrderDetailProductBean;
import com.dao.OrderDetailDao;

public class MyOrderDetailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		
		OrderDetailDao dao = new OrderDetailDao();
		ArrayList<OrderDetailProductBean> details = dao.getOrderDetail(orderId);
		request.setAttribute("details", details);
		request.getRequestDispatcher("MyOrderDetails.jsp").forward(request, response);;
	}

}
