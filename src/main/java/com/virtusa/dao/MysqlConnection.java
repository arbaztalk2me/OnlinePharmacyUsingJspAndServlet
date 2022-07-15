package com.virtusa.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
	

	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			conn=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/arbazdb","root","arbaz"); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
