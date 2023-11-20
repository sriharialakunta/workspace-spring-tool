package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String location;
	
	@Email(message = "Enter valid email")
	private String email;
	
	@Pattern(regexp = "\\d{10}", message = "Invalid mobile number")
	private String mobile;

	public Employee(String name, String location, @Email(message = "Enter valid email") String email,
			@Pattern(regexp = "\\d{10}", message = "Invalid mobile number") String mobile) {
		super();
		this.name = name;
		this.location = location;
		this.email = email;
		this.mobile = mobile;
	}
	
	

}
