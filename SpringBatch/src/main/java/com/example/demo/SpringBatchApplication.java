package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(
				SpringApplication.run(SpringBatchApplication.class, args)));
	}

}
