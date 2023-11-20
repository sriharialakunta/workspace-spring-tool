package com.example.bank;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class EmployeeDaoTest {

	@Test
	public void selectAll() throws SQLException {
	    int a,e =5;
	    EmployeeDao eDAO = new EmployeeDao();
	    a=eDAO.selectAll();
		assertEquals(e, a);
	}

}
