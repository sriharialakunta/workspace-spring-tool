package com.example.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Delivery_partners {
	
	@Id
	@Column(columnDefinition = "varchar(10)")
	private String partner_id;
	@Column(columnDefinition = "varchar(20)")
	private String partner_name;
	@Column(columnDefinition = "BIGINT")
	private BigDecimal phone_no;
	private int rating;
	
	public Delivery_partners() {
		super();
	}

	public Delivery_partners(String partner_id, String partner_name, BigDecimal phone_no, int rating) {
		super();
		this.partner_id = partner_id;
		this.partner_name = partner_name;
		this.phone_no = phone_no;
		this.rating = rating;
	}

	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	public String getPartner_name() {
		return partner_name;
	}

	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}

	public BigDecimal getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(BigDecimal phone_no) {
		this.phone_no = phone_no;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Delivery_partners [partner_id=" + partner_id + ", partner_name=" + partner_name + ", phone_no="
				+ phone_no + ", rating=" + rating + "]";
	}
	
}
