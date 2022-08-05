package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.CartBean;
import com.bean.CartProductBean;
import com.util.DBConnection;

public class CartDao {

	public void addToCart(CartBean cart) {
		
		try {
			Connection con = DBConnection.getConnection();
			
			PreparedStatement pstm = con.prepareStatement("insert into carts (userid,productid) values (?,?)");
			
			pstm.setInt(1, cart.getUserId());
			pstm.setInt(2, cart.getProductId());

			pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("SMW CartDao::addToCart()");
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<CartProductBean> getCartItems(int userId) {
		
		ArrayList<CartProductBean> carts = new ArrayList<CartProductBean>();
		
		try {
			
			Connection con = DBConnection.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select p.productname,p.price,c.cartid,p.productid,c.userid from products p,carts c where c.userid=? and c.productid = p.productid;");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CartProductBean cart = new CartProductBean();
				cart.setCartId(rs.getInt("cartid"));
				cart.setProductId(rs.getInt("productid"));
				cart.setUserId(rs.getInt("userid"));
				cart.setProductname(rs.getString("productname"));
				cart.setPrice(rs.getInt("price"));
				
				carts.add(cart);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SMW CardBean ::getCartItems()");
		}
		
		return carts;
	}

	public boolean deleteProduct(int  cartId) {
		boolean flag = true;
		try (
			Connection con = DBConnection.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("delete from carts where cartid=?;");
			)	{
			pstmt.setInt(1, cartId);
			
			int records = pstmt.executeUpdate();
			if (records == 1) {
				flag = true;
				System.out.println(records + "deleted...");	
			}		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SMW in deleteProduct()");
			e.printStackTrace();
		}
		return flag;
	}
	
	public void emptyCart(int userId) {
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from carts where userid = ?");
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SMW CartDao::emptyCart()");
		}
	}
	
}
