package com.example.demo.entity;

public class Student {
	
	private int id;
	private String name;
	private String section;
	private String address;
	
	public Student() {
		super();
	}

	public Student(int id, String name, String section, String address) {
		super();
		this.id = id;
		this.name = name;
		this.section = section;
		this.address = address;
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

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", section=" + section + ", address=" + address + "]";
//	}

	


}
