package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hotel_details {
	
	@Id
	@Column(columnDefinition = "varchar(10)")
	private String hotel_id;
	@Column(columnDefinition = "varchar(20)")
	private String hotel_name;
	@Column(columnDefinition = "varchar(20)")
	private String hotel_type;
	
	private int rating;

	public Hotel_details() {
		super();
	}

	public Hotel_details(String hotel_id, String hotel_name, String hotel_type, int rating) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_type = hotel_type;
		this.rating = rating;
	}

	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_type() {
		return hotel_type;
	}

	public void setHotel_type(String hotel_type) {
		this.hotel_type = hotel_type;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "hotel_details [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_type=" + hotel_type
				+ ", rating=" + rating + "]";
	}
	
	

}
