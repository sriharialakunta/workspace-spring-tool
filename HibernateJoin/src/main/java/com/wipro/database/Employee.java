package com.wipro.database;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author SR20379928
 *
 */
@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String role;
	@Column(nullable = false)
	private int salary;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "Department")
	@JoinColumn(nullable = false)
	private Department detId;
	
	public Employee() {
		
	}

	public Employee(int id, String name, String role, int salary, Department detId) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.salary = salary;
		this.detId = detId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDetId() {
		return detId;
	}

	public void setDetId(Department detId) {
		this.detId = detId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + ", detId=" + detId
				+ "]";
	}


}
