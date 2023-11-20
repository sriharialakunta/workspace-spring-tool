package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Address;
import com.example.demo.model.Employee;

@Configuration
public class Config {
	@Bean 
	public Employee employee() {
		return new Employee();
		
	}
	@Bean
	public Address address() {
		
		return new Address();
	}
	
}


