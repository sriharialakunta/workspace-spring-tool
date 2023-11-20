package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.model.Employee;

@SpringBootApplication
public class SpringAss2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAss2Application.class, args);
		@SuppressWarnings("resource")
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("bean.xml");
		Employee emp = ctxt.getBean(Employee.class);
		System.out.println(emp);
	}

}
