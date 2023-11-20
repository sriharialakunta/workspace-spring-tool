package com.wipro.topgear.Hiber_Assign_2.service;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.topgear.Hiber_Assign_2.dao.HqlConnect;
import com.wipro.topgear.Hiber_Assign_2.entity.Employee;
import com.wipro.topgear.Hiber_Assign_2.entity.EmployeeLogTab;

public class HqlService {

	HqlConnect hqlConnect;
	private Session session;
	private Transaction tnx = null;

	public void addEmp(Employee employee) {

		session = HqlConnect.sessionConnect();
		tnx = session.beginTransaction();

		if (employee.getEmpName().equals(employee.getEmpName().toUpperCase())) {
			session.save(employee);
			System.out.println("added Successfully...");
		} else {
			System.out.println("The empName is not in uppercase.");
		}

		tnx.commit();
		session.close();

	}

	public void deleteEmp(int i) {

		session = HqlConnect.sessionConnect();
		tnx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, i);
		empLogTab(employee);
		
	}

	public void empLogTab(Employee employee) {

		EmployeeLogTab employeeLogTab = new EmployeeLogTab(employee.getEmpcode(), employee.getEmpName(),
				employee.getEmpDesignation(), new Date(), employee.getEmpBasic_Pay());
		session.save(employeeLogTab);
		System.out.println("added Successfully to EmpLogTab...");
		session.delete(employee);
		System.out.println("deleted Successfully from Employee...");
		tnx.commit();
		session.close();

	}

}
