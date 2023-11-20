package com.wipro.topgear.Hiber_Assign_2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Check;

@Entity
@Check(constraints = "EmpDesignation IN ('SE','SSE','SS','SSS')")
public class EmployeeLogTab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sNo;
	@Column(nullable = false)
	private int Empcode;
	@Column(nullable = false,length=20)
	private String EmpName;
	@Column(nullable = false,columnDefinition="varchar(4)")
	private String EmpDesignation;
	@Column(nullable = false,columnDefinition="Date")
	private Date LeavingDate;
	@Column(nullable = false,columnDefinition="DECIMAL(8,2)")
	private double LastDrawnSalary;
	
	public EmployeeLogTab() {
		super();
	}

	public EmployeeLogTab(int empcode, String empName, String empDesignation, Date date,
			double lastDrawnSalary) {
		super();
		this.Empcode = empcode;
		this.EmpName = empName;
		this.EmpDesignation = empDesignation;
		this.LeavingDate = date;
		this.LastDrawnSalary = lastDrawnSalary;
	}

	public EmployeeLogTab(int sNo, int empcode, String empName, String empDesignation, Date leavingDate,
			double lastDrawnSalary) {
		super();
		this.sNo = sNo;
		this.Empcode = empcode;
		this.EmpName = empName;
		this.EmpDesignation = empDesignation;
		this.LeavingDate = leavingDate;
		this.LastDrawnSalary = lastDrawnSalary;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public int getEmpcode() {
		return Empcode;
	}

	public void setEmpcode(int empcode) {
		this.Empcode = empcode;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		this.EmpName = empName;
	}

	public String getEmpDesignation() {
		return EmpDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.EmpDesignation = empDesignation;
	}

	public Date getLeavingDate() {
		return LeavingDate;
	}

	public void setLeavingDate(Date leavingDate) {
		this.LeavingDate = leavingDate;
	}

	public double getLastDrawnSalary() {
		return LastDrawnSalary;
	}

	public void setLastDrawnSalary(double lastDrawnSalary) {
		this.LastDrawnSalary = lastDrawnSalary;
	}

	@Override
	public String toString() {
		return "EmployeeLogTab [sNo=" + sNo + ", Empcode=" + Empcode + ", EmpName=" + EmpName + ", EmpDesignation="
				+ EmpDesignation + ", LeavingDate=" + LeavingDate + ", LastDrawnSalary=" + LastDrawnSalary + "]";
	}
	
	
	
}
