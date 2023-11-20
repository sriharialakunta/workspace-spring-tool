package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.entity.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student student = context.getBean("student",Student.class); 
		System.out.println("student Data "+student.toString());
		Student student2 = context.getBean("s2",Student.class); 
		System.out.println("student Data "+student2.toString());
		Student student3 = context.getBean("s3",Student.class); 
		System.out.println("student Data "+student3.toString());
		Student student4 = context.getBean("s4",Student.class); 
		System.out.println("student Data "+student4.toString());
		Student student5 = context.getBean("s5",Student.class); 
		System.out.println("student Data "+student5.toString());
	}

}
