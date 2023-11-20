package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringAss3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAss3Application.class, args);
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext app =new AnnotationConfigApplicationContext(Employee.class);
		Employee employee=app.getBean("employee",Employee.class);
		employee.setId(1);
		employee.setName("Sudheer");
		employee.setBand("B1");
		System.out.println("\n"+employee.toPrintString());
		System.out.println("\n"+app.getBean(Employee.class).toPrintString()+"\n"+app.getBean(Employee.class)+"\n");
		System.out.println(app.getBean(Employee.class).toPrintString()+"\n"+app.getBean(Employee.class));

	}

}
