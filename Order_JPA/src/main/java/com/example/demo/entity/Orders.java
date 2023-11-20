package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	@Column(columnDefinition = "varchar(10)")
	private String order_id;
	
	@ManyToOne
	@JoinColumn(name = "coustomer_id",columnDefinition = "varchar(10)")
	private Customers coustomer;
	
	@ManyToOne
	@JoinColumn(name ="hotel_id",columnDefinition = "varchar(10)")	
	private Hotel_details hotel_details;
	
	@ManyToOne
	@JoinColumn(name ="partner_id",columnDefinition = "varchar(10)")	
	private Delivery_partners delivery_partners;
	
	private Date order_date;
	
	private int order_amount;
	
	public Orders() {
		super();
	}

	public Orders(String order_id, Customers coustomer, Hotel_details hotel_details,
			Delivery_partners delivery_partners, Date order_date, int order_amount) {
		super();
		this.order_id = order_id;
		this.coustomer = coustomer;
		this.hotel_details = hotel_details;
		this.delivery_partners = delivery_partners;
		this.order_date = order_date;
		this.order_amount = order_amount;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Customers getCoustomer() {
		return coustomer;
	}

	public void setCoustomer(Customers coustomer) {
		this.coustomer = coustomer;
	}

	public Hotel_details getHotel_details() {
		return hotel_details;
	}

	public void setHotel_details(Hotel_details hotel_details) {
		this.hotel_details = hotel_details;
	}

	public Delivery_partners getDelivery_partners() {
		return delivery_partners;
	}

	public void setDelivery_partners(Delivery_partners delivery_partners) {
		this.delivery_partners = delivery_partners;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", coustomer=" + coustomer + ", hotel_details=" + hotel_details
				+ ", delivery_partners=" + delivery_partners + ", order_date=" + order_date + ", order_amount="
				+ order_amount + "]";
	}


}
