package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.CartProductBean;
import com.bean.OrderBean;
import com.bean.OrderDetailBean;
import com.util.DBConnection;

public class OrderDao {

	public void placeOrder(int userId) {
		
		CartDao cartDao = new CartDao();
		ArrayList<CartProductBean> carts =  cartDao.getCartItems(userId);
		
		int total = 0;
		for (CartProductBean cartProductBean : carts) {
			total = total + cartProductBean.getPrice();
		}
		
		try {
			Connection con = DBConnection.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("insert into orders(userid,amount,orderstatus,paymentmode,paymentstatus) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, userId);
			pstmt.setInt(2, total);
			pstmt.setString(3, "placed");
			pstmt.setString(4, "COD");
			pstmt.setString(5, "pending");
			
			pstmt.executeUpdate();
			
			//orderid
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			int orderid = rs.getInt("orderid");
			System.out.println("orderid ==> " + orderid);
			
			//orderdetail -> 7 10 [11 22 33 44 55]
		OrderDetailDao orderDetailDao = new OrderDetailDao();
//			ArrayList<OrderDetailBean> orderDetails = new ArrayList<OrderDetailBean>();
			for (CartProductBean cartProductBean : carts) {
				OrderDetailBean orderDetail = new OrderDetailBean();
				orderDetail.setProductId(cartProductBean.getProductId());
				orderDetail.setPrice(cartProductBean.getPrice());
				orderDetail.setOrderId(orderid);
				orderDetailDao.addOrderDetail(orderDetail);
//				orderDetails.add(orderDetail);
			}
			
			//remove all items from cards
			cartDao.emptyCart(carts.get(0).getUserId());
			
		} catch (Exception e) {
			System.out.println("SMW in OrderDao::placeOrder()");
		}
		
	}
	
	public ArrayList<OrderBean> getMyOrder(int userId){
		ArrayList<OrderBean> orders = new  ArrayList<OrderBean>();
		try {
			
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from orders where userid = ?");
			
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderBean bean = new OrderBean();
				bean.setAmount(rs.getInt("amount"));
				bean.setOrderId(rs.getInt("orderid"));
				bean.setOrderstatus(rs.getString("orderstatus"));
				bean.setPaymentmode(rs.getString("paymentmode"));
				bean.setPaymentstatus(rs.getString("paymentstatus"));
				bean.setUserId(rs.getInt("userid"));
				orders.add(bean);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SMW ::OrderDAo::getMyOrder()");
			e.printStackTrace();
			
		}
		return orders;
		
	}
	
//	public boolean CancelOrder(int  orderId) {
//			
//			boolean flag = true;
//			try (
//				Connection con = DBConnection.getConnection();
//				
//				PreparedStatement pstmt = con.prepareStatement("delete from orders where orderid=?");
//				)	{
//				pstmt.setInt(1, orderId);
//				
//				int records = pstmt.executeUpdate();
//				if (records == 1) {
//					flag = true;
//					System.out.println(records + "canceled...");	
//				}		
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.println("SMW in CancelOrder()");
//				e.printStackTrace();
//			}
//			return flag;
//			
//		}
	
	public boolean CancelOrder(int orderId) {
		
		boolean flag = true;
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from orders where orderid=?");)
		{
			pstmt.setInt(1, orderId);
			int records = pstmt.executeUpdate();
			if (records==1) {
				flag = true;
				System.out.println(records+"order canceled");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SMW in CancelOrder()");
			e.printStackTrace();
		}
		return flag;
		
	}
	
	
}
