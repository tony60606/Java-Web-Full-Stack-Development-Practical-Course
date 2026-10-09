package com.sample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	private static final String URL = "jdbc:mysql://localhost:3306/drinkshop?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8" ;
	private static final String USER = "root" ;
	private static final String password = "zoobee00" ;
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;			
		} catch (Exception ex) {
			throw new RuntimeException(ex) ;
		}
		
	}
	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(URL, USER, password) ;
	}
	
}
