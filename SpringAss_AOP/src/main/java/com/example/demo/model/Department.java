package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Department {
	
	private int depId;
	private String depName;
	@Autowired
	private Employee employee;
	
	public Department() {
		super();
	}

	public Department(int depId, String depName, Employee employee) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.employee = employee;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String toString() {
		return "Department [empId=" + depId + ", empName=" + depName + ", employee=" + employee + "]";
	}
	
}
