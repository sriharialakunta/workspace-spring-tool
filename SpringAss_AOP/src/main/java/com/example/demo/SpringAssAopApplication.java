package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.aspect.Config;
import com.example.demo.model.Department;

@SpringBootApplication
public class SpringAssAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAssAopApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		System.out.println(context.getBean(Department.class));
	}

}
