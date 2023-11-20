package com.wipro.topgear.Hiber_Assign_4.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HqlConnector {

	

	public static Session sessionConnect() {
		
		String path = "hibernate.cfg.xml";
		Configuration cfg = new Configuration().configure(path);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();
	}


}