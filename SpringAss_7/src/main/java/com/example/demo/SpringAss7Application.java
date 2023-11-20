package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringAss7Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAss7Application.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		Player p = context.getBean(Player.class);
		Player p1 = context.getBean(Player.class);
		Player p2 = context.getBean(Player.class);
		Player p3 = context.getBean(Player.class);
		Player p4 = context.getBean(Player.class);
		p=new Player("P001","Sachin Tendulkar");
		p1=new Player("P002","MS Dhoni");
		p2=new Player("P003","Virat Kohli");
		p3=new Player("P001","Michael Hussey");
		p4=new Player("P002","David Warner");
		List<Player> indPlayers = new ArrayList<Player>();
		indPlayers.add(p);
		indPlayers.add(p1);
		indPlayers.add(p2);
		List<Player> ausPlayers = new ArrayList<Player>();
		ausPlayers.add(p3);
		ausPlayers.add(p4);
		Country country = context.getBean(Country.class);
		country= new Country("C001","India",indPlayers);
		Country country2 = context.getBean(Country.class);
		country2= new Country("C002","Australia",ausPlayers);
		List<Country> countries = new ArrayList<Country>();
		countries.add(country);
		countries.add(country2);
		System.out.println();
		for(Country c:countries)
		System.out.println(c);
		
	}

}
