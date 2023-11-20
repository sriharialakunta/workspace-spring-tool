package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mobiles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String model;
	@Column
	private String brand;
	
	public Mobiles() {
		super();
	}
	
	public Mobiles(int id, String brand, String model) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
	}

	public Mobiles(String brand, String model) {
		this.model = model;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Mobiles [id=" + id + ", model=" + model + ", brand=" + brand + "]";
	}
	
	
	

}
