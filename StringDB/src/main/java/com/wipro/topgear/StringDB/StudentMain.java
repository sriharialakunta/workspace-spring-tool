package com.wipro.topgear.StringDB;

import java.sql.SQLException;

public class StudentMain 
{
    public static void main( String[] args ) throws SQLException
    {
    	StudentDao sDAO = new StudentDao();
    	sDAO.addStudent();
    	sDAO.selectAll();
      	sDAO.stringOP();
    }
}
