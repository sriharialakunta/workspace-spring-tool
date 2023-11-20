package com.example.demo;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.construct.Simple;
import com.example.demo.construct.SimpleConfig;
import com.example.demo.utill.Dao;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringJdbcApplication.class, args);
		//Getting Data from the XML file.....
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		BasicDataSource basicDataSource = context.getBean("myDataSource",BasicDataSource.class);
		System.out.println(basicDataSource.getUrl());
		
		//Getting Data from the bean(XML file) through the DAO Class.....
		ApplicationContext contextUtil = new ClassPathXmlApplicationContext("configUtil.xml");
		Dao dao = contextUtil.getBean("dao",Dao.class);
		System.out.println(dao.getDbutil());
		
		//Getting Data from the @Bean Annotation.....
 		ApplicationContext context2 = new AnnotationConfigApplicationContext(SimpleConfig.class);
		Simple simple = context2.getBean("simpleBean",Simple.class);
		System.out.println(simple.toString());
		Simple simple1 = context2.getBean("simpleBean1",Simple.class);
		System.out.println(simple1.toString());
		
	}

}
