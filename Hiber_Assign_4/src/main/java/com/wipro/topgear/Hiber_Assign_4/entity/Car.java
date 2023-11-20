package com.wipro.topgear.Hiber_Assign_4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sNo;
	@Column(unique = true, nullable = false)
	private String RegNo;
	@Column(nullable = false)
	private String Model;
	@Column(nullable = false)
	private String Color;
	@Column(nullable = false)
	private String Manufacturer;
	@Column(nullable = false)
	private int Price;
	
	public Car() {
		super();
	}

	public Car(int sNo, String regNo, String model, String color, String manufacturer, int price) {
		super();
		this.sNo = sNo;
		this.RegNo = regNo;
		this.Model = model;
		this.Color = color;
		this.Manufacturer = manufacturer;
		this.Price = price;
	}

	public Car(String regNo, String model, String color, String manufacturer, int price) {
		super();
		this.RegNo = regNo;
		this.Model = model;
		this.Color = color;
		this.Manufacturer = manufacturer;
		this.Price = price;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getRegNo() {
		return RegNo;
	}

	public void setRegNo(String regNo) {
		this.RegNo = regNo;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		this.Model = model;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		this.Color = color;
	}

	public String getManufacturer() {
		return Manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.Manufacturer = manufacturer;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		this.Price = price;
	}

	@Override
	public String toString() {
		return "Car [sNo=" + sNo + ", RegNo=" + RegNo + ", Model=" + Model + ", Color=" + Color + ", Manufacturer="
				+ Manufacturer + ", Price=" + Price + "]";
	}

	
}
