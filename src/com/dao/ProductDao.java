package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.ProductBean;
import com.util.DBConnection;

public class ProductDao {

	public void insertProduct(ProductBean productBean) {
		
		try {
			Connection con = DBConnection.getConnection();
						
			PreparedStatement pstmt = con.prepareStatement("insert into products(productname,price,quantity,imgurl,description) values(?,?,?,?,?)");
		
			pstmt.setString(1, productBean.getProductname());
			pstmt.setInt(2, productBean.getPrice());
			pstmt.setInt(3, productBean.getQuantity());
			pstmt.setString(4, productBean.getImgUrl());
			pstmt.setString(5, productBean.getDesc());
			
			int records = pstmt.executeUpdate();
			if(records>0) {
				System.out.println(records + "inserted...");
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("SMW in insertProduct()");
			e.printStackTrace();
		}
		
	}

	public ArrayList<ProductBean> getAllProducts() {
		
		ArrayList<ProductBean> products = new ArrayList<ProductBean>();
		
		try {
			
			Connection con = DBConnection.getConnection();
						
			PreparedStatement pstmt = con.prepareStatement("select * from products");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ProductBean product = new ProductBean();
				product.setProductname(rs.getString("productname"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setProductId(rs.getInt("productid"));
				product.setImgUrl(rs.getString("imgurl"));
				product.setDesc(rs.getString("description"));				
				
				products.add(product);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
		
		
		
	}

	public boolean deleteProduct(int  productId) {
		
		boolean flag = true;
		try (
			Connection con = DBConnection.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("delete from products where productid=?");
			)	{
			pstmt.setInt(1, productId);
			
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
	
	public ProductBean getProductByProductID(int productID) {
		
		ProductBean product = null;
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from products where productid=?");
				){
			pstmt.setInt(1, productID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				product = new ProductBean();
				product.setProductname(rs.getString("productname"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setImgUrl(rs.getString("imgurl"));
				product.setDesc(rs.getString("description"));				
				product.setProductId(productID);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return product;
		
	}
	
	public boolean updateProduct(ProductBean product) {
		boolean flag = false;	
		try (Connection con=DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update products set productname=?,price=?,quantity=?,imgurl=?,description=? where productid=?")
				){
			
			pstmt.setString(1, product.getProductname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setInt(3, product.getQuantity());
			pstmt.setString(4, product.getImgUrl());
			pstmt.setString(5, product.getDesc());			
			pstmt.setInt(6, product.getProductId());
			
			int records = pstmt.executeUpdate();
			if(records == 1) {
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return flag;
		
		
	}
	
}
