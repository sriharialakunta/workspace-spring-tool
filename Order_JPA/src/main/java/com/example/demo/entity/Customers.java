package com.example.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customers {

	@Id
	@Column(columnDefinition = "varchar(10)")
	private String coustomer_id;
	@Column(columnDefinition = "varchar(20)")
	private String coustomer_name;
	@Column(columnDefinition = "varchar(20)")
	private String address;
	@Column(columnDefinition = "BIGINT")
	private BigDecimal phone_no;
	@Column(columnDefinition = "varchar(20)")
	private String email_id;

	public Customers() {
		super();
	}

	public Customers(String coustomer_id, String coustomer_name, String address, BigDecimal phone_no, String email_id) {
		super();
		this.coustomer_id = coustomer_id;
		this.coustomer_name = coustomer_name;
		this.address = address;
		this.phone_no = phone_no;
		this.email_id = email_id;
	}

	public String getCoustomer_id() {
		return coustomer_id;
	}

	public void setCoustomer_id(String coustomer_id) {
		this.coustomer_id = coustomer_id;
	}

	public String getCoustomer_name() {
		return coustomer_name;
	}

	public void setCoustomer_name(String coustomer_name) {
		this.coustomer_name = coustomer_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(BigDecimal phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	@Override
	public String toString() {
		return "Customers [coustomer_id=" + coustomer_id + ", coustomer_name=" + coustomer_name + ", address=" + address
				+ ", phone_no=" + phone_no + ", email_id=" + email_id + "]";
	}
	
	
}
