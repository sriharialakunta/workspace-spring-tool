package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;
	String pname;
	String pdesc;
	
	public product() {
		super();
	}

	public product(int pid, String pname, String pdesc) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdesc = pdesc;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + "]";
	}
	

}
