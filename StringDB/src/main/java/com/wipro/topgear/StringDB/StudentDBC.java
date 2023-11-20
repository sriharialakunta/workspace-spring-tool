package com.wipro.topgear.StringDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDBC {
	
	public static Connection conect()throws SQLException {
	    String DB_URL = "jdbc:hsqldb:mem:testdb";
	    String USER = "SA";
	    String PASS = "";
	   
      Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
     
	return connection; 
   }
}
