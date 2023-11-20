package com.wipro.topgear.StringDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.StringUtils;

public class StudentDao {

	public void selectAll() throws SQLException {
		
		String QUERY = "SELECT * FROM student";
	      PreparedStatement stmt = StudentDBC.conect().prepareStatement(QUERY);
  	  ResultSet rs = stmt.executeQuery(); 
	         while (rs.next()) {
	            System.out.print("ID: " + rs.getInt("sid"));
	            System.out.print(", Firstname: " + rs.getString("firstname"));
	            System.out.print(", Lastname: " + rs.getString("lastname"));
	            System.out.println(", Join_Date: " + rs.getDate("join_Date"));
	           
	         }
		
	}

	public void addStudent() throws SQLException {
		try(Statement stmt = StudentDBC.conect().createStatement()){
		  stmt.execute("CREATE TABLE student(sid int NOT NULL, firstname varchar(25) NOT NULL,"
		  		+ " lastname varchar(25) NOT NULL, join_Date date,PRIMARY KEY(sid))");
		  stmt.execute("INSERT INTO student values(1,'Venu','Bokka','2020-02-01')");
		}
		
	}

	public void stringOP() throws SQLException {

		String QUERY = "SELECT * FROM student";
	      PreparedStatement stmt = StudentDBC.conect().prepareStatement(QUERY);
	  ResultSet rs = stmt.executeQuery(); 
	  while (rs.next()) {
          System.out.print("ID: " + rs.getInt("sid"));
          System.out.print("Name reversel "+StringUtils.reverse(rs.getString("firstname")));
          
       }
	}

}
