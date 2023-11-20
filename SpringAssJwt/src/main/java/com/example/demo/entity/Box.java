package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NonNull;

@Entity
public class Box {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bId;
	@NonNull
	private String bName;
	@NonNull
	private String bType;
	@NonNull
	private Double bWeight;
	
	public Box() {
		super();
	}

	public Box(int bId, @NonNull String bName, @NonNull String bType, @NonNull Double bWeight) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bType = bType;
		this.bWeight = bWeight;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public Double getbWeight() {
		return bWeight;
	}

	public void setbWeight(Double bWeight) {
		this.bWeight = bWeight;
	}

	@Override
	public String toString() {
		return "Box [bId=" + bId + ", bName=" + bName + ", bType=" + bType + ", bWeight=" + bWeight + "]";
	}
	

}
