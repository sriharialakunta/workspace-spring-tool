package com.wipro.topgear.HibernateDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	@Column
	private String Name;
	@Column
	private String Designation;
	@Column
	private int Salary;
	
	public Employee() {
		super();
	}

	public Employee(int empId, String name, String designation, int salary) {
		super();
		this.empId = empId;
		Name = name;
		Designation = designation;
		Salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", Name=" + Name + ", Designation=" + Designation + ", Salary=" + Salary
				+ "]";
	}
	
	
	
}
