package com.wipro.topgear.Hiber_Assign_4.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.topgear.Hiber_Assign_4.dao.HqlConnector;
import com.wipro.topgear.Hiber_Assign_4.entity.Car;

public class HqlOperations {

	private Session session;
	private Transaction tnx = null;
	
	public void save(Car car) {
		session = HqlConnector.sessionConnect();
		tnx = session.beginTransaction();
	try {
		
		session.save(car);
		tnx.commit();
	} catch (HibernateException e) {
		e.printStackTrace();
	} finally {

		session.close();

	}

}
public void getManufacturer() {
	session = HqlConnector.sessionConnect();
	tnx = session.beginTransaction();
	try {
		List<?> cars = session.createQuery("FROM Car WHERE manufacturer LIKE 'V%'").list();
		Iterator<?> it = cars.iterator();
		while(it.hasNext()) {
			Car c1 = (Car)it.next();
			System.out.println(c1);
		}
		
	}catch(HibernateException e) {
		e.printStackTrace();
	}finally {
		session.close();
	}
}

public void getByRegNo(String string) {
	session = HqlConnector.sessionConnect();
	tnx = session.beginTransaction();
	try {
		String query = "FROM Car WHERE RegNo = " + string;
		List<?> cars = session.createQuery(query).list();
		Iterator<?> it = cars.iterator();
		while(it.hasNext()) {
			Car c1 = (Car)it.next();
			System.out.println(c1);
		}
		
	}catch(HibernateException e) {
		e.printStackTrace();
	}finally {
		session.close();
	}
}


public void getByPrice() {
	session = HqlConnector.sessionConnect();
	tnx = session.beginTransaction();
	try {
		List<?> cars = session.createQuery("FROM Car WHERE price < 600000").list();
		Iterator<?> it = cars.iterator();
		while(it.hasNext()) {
			Car c1 = (Car)it.next();
			System.out.println(c1);
		}
		
	}catch(HibernateException e) {
		e.printStackTrace();
	}finally {
		session.close();
	}
	
}

public void retriveAll() {
	session = HqlConnector.sessionConnect();
	tnx = session.beginTransaction();
	try {
		List<?> cars = session.createQuery("FROM Car").list();
		Iterator<?> it = cars.iterator();
		while(it.hasNext()) {
			Car c1 = (Car)it.next();
			System.out.println(c1);
		}
		
	}catch(HibernateException e) {
		e.printStackTrace();
	}finally {
		session.close();
	}
	
}
}
