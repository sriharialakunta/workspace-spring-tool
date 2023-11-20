package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo"} )
public class SpringAss5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAss5Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(SecondBean.class);
		FirstBean firstBean = context.getBean(FirstBean.class);
		firstBean.sayHello();
	}

}
