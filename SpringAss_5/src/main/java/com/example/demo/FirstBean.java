package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class FirstBean {

	public void sayHello() {
		System.out.println("Executing In FirstBean");
	}
}