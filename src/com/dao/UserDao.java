package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.ProductBean;
import com.bean.UserBean;
import com.util.DBConnection;

public class UserDao {

	public void insertUser(UserBean userBean) {

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("insert into users(firstname,lastname,email,password,gender,usertype,contact) values(?,?,?,?,?,?,?)");

			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getLastName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
			pstmt.setString(6, userBean.getUserType());
			pstmt.setLong(7,userBean.getContact());
			

			int records = pstmt.executeUpdate();

			System.out.println(records + "inserted......");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SMW in insertUser()");
			e.printStackTrace();
		}

	}

	public ArrayList<UserBean> getAllUsers() {
		
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				int userId = rs.getInt("userid");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				long contact = rs.getLong("contact");
				
				UserBean user = new UserBean();
				user.setUserId(userId);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPassword(password);
				user.setGender(gender);
				user.setContact(contact);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public UserBean login(String email,String password) {
		
		UserBean user = null;
		
		try {
			Connection con = DBConnection.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("select * from users where email=? and password=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				user = new UserBean();
				user.setUserId(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstName"));
				user.setUserType(rs.getString("userType"));
			}
			con.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}


	public boolean deleteUser(int  userId) {
			
			boolean flag = true;
			try (
				Connection con = DBConnection.getConnection();
				
				PreparedStatement pstmt = con.prepareStatement("delete from users where userid=?");
				)	{
				pstmt.setInt(1, userId);
				
				int records = pstmt.executeUpdate();
				if (records == 1) {
					flag = true;
					System.out.println(records + "deleted...");	
				}		
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("SMW in deleteUser()");
				e.printStackTrace();
			}
			return flag;
			
		}

	public UserBean getUserByUserID(int userID) {
		
		UserBean user = null;
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from users where userid=?");
				){
			pstmt.setInt(1, userID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new UserBean();
				user.setEmail(rs.getString("email"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setUserId(userID);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
		
	}
	
	
	public boolean updateUser(UserBean user) {
		boolean flag = false;
		
		try (Connection con=DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update users set firstname=?,lastname=?,password=?,gender=? where userid=?")
				){
			
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getGender());
			pstmt.setInt(5, user.getUserId());
			
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

	

