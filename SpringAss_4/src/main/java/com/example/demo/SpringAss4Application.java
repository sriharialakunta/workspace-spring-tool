package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringAss4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAss4Application.class, args);
		ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext("bean.xml");
		System.out.println("\nByName");
		System.out.println(ctxt.getBean("employeeByName"));
		System.out.println("\nByType");
		System.out.println(ctxt.getBean("employeeByTpye"));
	}

}
