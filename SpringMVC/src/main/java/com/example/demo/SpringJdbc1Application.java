package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.ProductController;

@SpringBootApplication
public class SpringJdbc1Application implements CommandLineRunner{
   @Autowired
   ProductController productController;
//   @Autowired
//   CustomerController customerController;
   
	public static void main(String[] args)  {
		SpringApplication.run(SpringJdbc1Application.class, args);
		

	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println(productController.count());	
		System.out.println(productController.name());
//		System.out.println(customerController.count());
	}

}
