package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcUtil {
	
	//Step-1 Load the Driver
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	 public static	Connection getMySQLConnection() {
		 String url="jdbc:mysql://localhost:3306/mydb";
		 Connection con=null;
		 try {
		con=DriverManager.getConnection(url, "root", "myhandsomepapa@0930") ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return con;
	 }
	public static void cleanUp(Connection con,Statement st) {
		
			try {
				if(con !=null)
				con.close();
				if(st !=null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}	
		
}

