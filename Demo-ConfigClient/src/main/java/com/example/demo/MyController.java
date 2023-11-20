package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RefreshScope
public class MyController {

	@Value("${message}")
	String message;
	@Value("${company}")
String company;
	
	@GetMapping("/message")
	public String  getMessageFromConfigServer()
	{
		return "You are in company "+company+"   "+message;
	}
	

	
}

