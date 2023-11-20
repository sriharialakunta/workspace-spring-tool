package com.example.bank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao{
	
	   int selectAll() throws SQLException{
		   
		    String QUERY = "SELECT * FROM employee";
		      PreparedStatement stmt = EmployeeDBC.conect().prepareStatement(QUERY);
	    	  ResultSet rs = stmt.executeQuery(); 
	    	  int i=0;
		         while (rs.next()) {
		            System.out.print("ID: " + rs.getInt("empid"));
		            System.out.print(", EmpName: " + rs.getString("ename"));
		            System.out.print(", EmpSal: " + rs.getInt("empsal"));
		            System.out.println(", EmpRol: " + rs.getString("emprole"));
		            i++;
		           
		         }
		         System.out.println("\n\n");
				return i;
		    
	   }
	   void addEmployee()throws SQLException{
//		   String QUERY = "INSERT INTO employee values(2,'Sudheer', 21000,'employee')";
		   String QUERY1="INSERT INTO employee values(3,'Venu',22000,'Manager')";
//		   EmployeeDBC.conect().prepareStatement(QUERY);
		  PreparedStatement stmt = EmployeeDBC.conect().prepareStatement(QUERY1);
		  stmt.executeUpdate();
	   }
	   void deleteEmp()throws SQLException{
		   String QUERY="DELETE FROM employee WHERE empid=2";
		   PreparedStatement stmt = EmployeeDBC.conect().prepareStatement(QUERY);
		   stmt.execute();
	   }
}
