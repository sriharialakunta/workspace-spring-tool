package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/message")
	public String getMessageFromConfigServer() {
		return "You are in company wipro";
	}

}
