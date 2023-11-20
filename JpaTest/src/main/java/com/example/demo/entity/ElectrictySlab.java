package com.example.demo.entity;

import jakarta.persistence.GenerationType;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ElectrictySlab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String meterId;
	private int units;
	private Date dueDate;
	@Value("${pricePerUnit}")
	private int pricePerUnit;
	
	public ElectrictySlab() {
		super();
	}

	public ElectrictySlab(int id, String meterId, int units, Date dueDate, int pricePerUnit) {
		super();
		this.id = id;
		this.meterId = meterId;
		this.units = units;
		this.dueDate = dueDate;
		this.pricePerUnit = pricePerUnit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public int getUnits() {
		return units;
	}
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public void setUnits(int units) {
		this.units = units;
	}

	public int getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(int pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public String toString() {
		return "ElectrictySlab [id=" + id + ", meterId=" + meterId + ", units=" + units + ", dueDate=" + dueDate
				+ ", pricePerUnit=" + pricePerUnit + "]";
	}

	
	
	

}
