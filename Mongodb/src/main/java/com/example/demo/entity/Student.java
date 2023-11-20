package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Student")
public class Student {

	@Id
	private int id;
	private String name;
	private String sec;
	private int marks;
	
	public Student() {
		super();
	}

	public Student(int id, String name, String sec, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.sec = sec;
		this.marks = marks;
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

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	
	
}
