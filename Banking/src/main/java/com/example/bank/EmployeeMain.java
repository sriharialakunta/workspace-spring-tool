package com.example.bank;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class EmployeeMain
{
    public static void main( String[] args ) throws SQLException {
    	
    	EmployeeDao eDAO = new EmployeeDao();
    	eDAO.selectAll();
//    	eDAO.addEmployee();
    	eDAO.deleteEmp();
    	eDAO.selectAll();
    	
    	
    }
}
