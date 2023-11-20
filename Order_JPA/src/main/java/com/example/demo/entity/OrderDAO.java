package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;

public class OrderDAO {
	
	@Column(columnDefinition = "varchar(10)")
	private String order_id;
	@Column(columnDefinition = "varchar(20)")
	private String coustomer_name;
	@Column(columnDefinition = "varchar(20)")
	private String hotel_name;
	private int order_amount;
	
	public OrderDAO() {
		super();
	}
	public OrderDAO(List<Orders> orders) {
		super();
		this.order_id = ((Orders) orders).getOrder_id();
		this.coustomer_name = ((Orders) orders).getCoustomer().getCoustomer_name();
		this.hotel_name = ((Orders) orders).getHotel_details().getHotel_name();
		this.order_amount = ((Orders) orders).getOrder_amount();
	}
	public OrderDAO(String order_id, String coustomer_name, String hotel_name, int order_amount) {
		super();
		this.order_id = order_id;
		this.coustomer_name = coustomer_name;
		this.hotel_name = hotel_name;
		this.order_amount = order_amount;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getCoustomer_name() {
		return coustomer_name;
	}

	public void setCoustomer_name(String coustomer_name) {
		this.coustomer_name = coustomer_name;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public int getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}

	@Override
	public String toString() {
		return "OrderDAO [order_id=" + order_id + ", coustomer_name=" + coustomer_name + ", hotel_name=" + hotel_name
				+ ", order_amount=" + order_amount + "]";
	}

}
