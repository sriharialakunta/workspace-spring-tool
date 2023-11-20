package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.UrlController;

@SpringBootApplication
public class SpringBootAss1Application implements CommandLineRunner{
	
	@Autowired
	private UrlController controller;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAss1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(controller.simpleStringData()+" this from commandLineRunner.");
	}

}
