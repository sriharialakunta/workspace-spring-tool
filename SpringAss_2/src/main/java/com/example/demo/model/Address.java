package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Address {

	private String state;
	private String City;
	private String village;
	private String Street;
	private int pincode;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", City=" + City + ", village=" + village + ", Street=" + Street
				+ ", pincode=" + pincode + "]";
	}

}
