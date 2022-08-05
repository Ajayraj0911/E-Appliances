package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/juneinternship";
	private static String userName = "postgres";
	private static String password = "root";
	
	public static Connection getConnection(){  
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url,userName,password);
			
			if (con != null) {
				System.out.println("db connected.....");
			}else {
				System.out.println("SMW in else");
			}
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("SMW in catch 1");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("SMW in catch 2");
			e.printStackTrace();
		}
		return null;
		
	}

}
