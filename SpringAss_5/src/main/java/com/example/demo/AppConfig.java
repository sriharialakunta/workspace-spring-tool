package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {

	@Bean
	@Lazy(true)
	public SecondBean secondBean() {
		SecondBean secondBean = new SecondBean();
		secondBean.print();
		return secondBean;
	}
	@Bean
	public FirstBean mybean() {
		return new FirstBean();
	}
}