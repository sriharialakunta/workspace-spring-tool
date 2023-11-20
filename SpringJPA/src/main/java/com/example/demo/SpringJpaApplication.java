package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.MobilesController;
import com.example.demo.entity.Mobiles;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {
	@Autowired
	MobilesController mobilesController;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Mobiles mobiles = new Mobiles("9 Pro+","Realme");
//      mobilesController.addMobile(mobiles);
		System.out.println(mobilesController.getAllMobiles());
	}

}
