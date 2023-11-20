package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaTestApplication {
//implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JpaTestApplication.class, args);
		
		
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter your consumed units ");
//		System.out.println(
//		ElecSlab.billAmount(sc.nextInt()));
//		sc.close();
//		
//	}

}
 