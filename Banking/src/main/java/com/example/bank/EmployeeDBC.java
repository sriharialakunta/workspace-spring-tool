package com.example.bank;

import java.sql.*;

public class EmployeeDBC {
   

   public static Connection conect()throws SQLException {
	    String DB_URL = "jdbc:mysql://localhost:3306/new_schema";
	    String USER = "root";
	    String PASS = "Mysqlwork@6";
	   
      Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
     
	return connection; 
   }
   
	      
	       
	      
}
   
   
   
   