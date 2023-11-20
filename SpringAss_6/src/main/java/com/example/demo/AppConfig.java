package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("com.example.demo")
@PropertySource(value="application.properties")
public class AppConfig {

	@Bean("orders")
	public Orders orders() {
		return new Orders();
	}
	
	
}
