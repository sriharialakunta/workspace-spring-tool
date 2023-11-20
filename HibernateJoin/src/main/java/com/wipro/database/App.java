package com.wipro.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    public static void main( String[] args )
    {
    	Department department = new Department();
    	department.setDeptName("Sales");
    	
    	Employee employee = new Employee();
    	employee.setName("Srihari");
    	employee.setRole("Employee");
    	employee.setSalary(21000);
    	employee.setDetId(department);
    	
        Transaction tnx = null;
        String path ="hibernate.cfg.xml";
        Configuration cfg = new Configuration().configure(path);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
        		cfg.getProperties()).build();        
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        
        Session session = sessionFactory.openSession();
        try {
        	tnx = session.beginTransaction();
        	session.save(employee);
        	session.getTransaction();
        	  tnx.commit();
        }catch (HibernateException e) {
        	e.printStackTrace();
		}finally {
			
			session.close();
		}
       
    }
}
