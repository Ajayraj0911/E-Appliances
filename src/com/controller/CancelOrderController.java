package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderDao;

public class CancelOrderController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int orderid = Integer.parseInt(request.getParameter("orderId"));
		
		OrderDao orderdao = new OrderDao();
		RequestDispatcher rd = null;
		if (orderdao.CancelOrder(orderid)) {
			request.setAttribute("message", "Order Canceled successfully");
			rd = request.getRequestDispatcher("MyOrdersController");
		}else{
			request.setAttribute("message", "some error in DAo");
		}
		rd.forward(request, response);
	}

}
