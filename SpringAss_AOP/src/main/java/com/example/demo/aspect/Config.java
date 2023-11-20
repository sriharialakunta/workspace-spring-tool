package com.example.demo.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;

@Configuration
@EnableAspectJAutoProxy
public class Config {
	
	@Bean
	public AspectController aspect() {
		return new AspectController();
	}
	
	@Bean
	public Employee newemployee() {
		
		return new Employee(1, "Srihari");
	} 
	
	@Bean
	public Department department() {
		
		return new Department(1, "Devloper",newemployee());
	}
	
}
