package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	private String name;
	private String sec;
	
	@OneToMany(mappedBy="student", cascade= CascadeType.ALL)
	private List<Training> training;
	
	public Student() {
		super();
	}
	public Student(int id, String name, String sec, List<Training> training) {
		super();
		this.id = id;
		this.name = name;
		this.sec = sec;
		this.training = training;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSec() {
		return sec;
	}
	public void setSec(String sec) {
		this.sec = sec;
	}
	public List<Training> getTraining() {
		return training;
	}
	public void setTraining(List<Training> training) {
		this.training = training;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sec=" + sec + ", training=" + training + "]";
	}

	
	
}
