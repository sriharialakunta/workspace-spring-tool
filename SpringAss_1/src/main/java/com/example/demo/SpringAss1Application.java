package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringAss1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAss1Application.class, args);
		@SuppressWarnings("resource")
		ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
		Employee employee=app.getBean("employee",Employee.class);
		System.out.println(employee);

	}

}
