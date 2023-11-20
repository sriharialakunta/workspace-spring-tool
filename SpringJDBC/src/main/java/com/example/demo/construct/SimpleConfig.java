package com.example.demo.construct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfig {
	
	@Bean
	public Simple simpleBean() {
		Simple simple = new Simple();
		simple.setSname("hello");
		return simple;
		
	}
	@Bean
	public Simple simpleBean1() {
	 return new Simple("Second Hello");
	}
	

}
