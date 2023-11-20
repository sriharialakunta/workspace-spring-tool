package com.wipro.topgear.Hiber_Assign_2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Check;
//import org.hibernate.annotations.ColumnTransformer;


@Entity
@Check(constraints = "EmpDesignation IN ('SE','SSE','SS','SSS')")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Empcode;
	@Column(nullable = false,length=20)
//	@ColumnTransformer(read="UPPER(Empname)")
	private String EmpName;
	@Column(nullable = false,columnDefinition="varchar(4)")
	private String EmpDesignation;
	@Column(nullable = false,columnDefinition="Date")
	private Date EmpDOB;
	@Column(nullable = false,columnDefinition="Date")
	private Date EmpJOD;
	@Column(nullable = false,columnDefinition="NUMERIC(2) CHECK (EmpAge BETWEEN 18 AND 60)")
	private int EmpAge;
	@Column(nullable = false,columnDefinition="DECIMAL(8,2) CHECK(EmpBasic_Pay>6000)")
	private double EmpBasic_Pay;
	
	public Employee() {
		super();
	}
	

	public Employee(String empName, String empDesignation, Date empDOB, Date empJOD, int empAge, double empBasic_Pay) {
		super();
		this.EmpName = empName;
		this.EmpDesignation = empDesignation;
		this.EmpDOB = empDOB;
		this.EmpJOD = empJOD;
		this.EmpAge = empAge;
		this.EmpBasic_Pay = empBasic_Pay;
	}
	


	public Employee(int empcode, String empName, String empDesignation, Date empDOB, Date empJOD, int empAge,
			double empBasic_Pay) {
		super();
		this.Empcode = empcode;
		this.EmpName = empName;
		this.EmpDesignation = empDesignation;
		this.EmpDOB = empDOB;
		this.EmpJOD = empJOD;
		this.EmpAge = empAge;
		this.EmpBasic_Pay = empBasic_Pay;
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

	public Date getEmpDOB() {
		return EmpDOB;
	}

	public void setEmpDOB(Date empDOB) {
		this.EmpDOB = empDOB;
	}

	public Date getEmpJOD() {
		return EmpJOD;
	}

	public void setEmpJOD(Date empJOD) {
		this.EmpJOD = empJOD;
	}

	public int getEmpAge() {
		return EmpAge;
	}

	public void setEmpAge(int empAge) {
		this.EmpAge = empAge;
	}

	public double getEmpBasic_Pay() {
		return EmpBasic_Pay;
	}

	public void setEmpBasic_Pay(double empBasic_Pay) {
		this.EmpBasic_Pay = empBasic_Pay;
	}


	@Override
	public String toString() {
		return "Employee [Empcode=" + Empcode + ", EmpName=" + EmpName + ", EmpDesignation=" + EmpDesignation
				+ ", EmpDOB=" + EmpDOB + ", EmpJOD=" + EmpJOD + ", EmpAge=" + EmpAge + ", EmpBasic_Pay=" + EmpBasic_Pay
				+ "]";
	}

	
}
