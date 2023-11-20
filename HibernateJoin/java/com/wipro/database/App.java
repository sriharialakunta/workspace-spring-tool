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
        Employee employee = new Employee();
        
        employee.setName("Srihari");
        employee.setRole("Employee");
        Employee employee2 = new Employee();
        
        employee2.setName("Sudheer");
        employee2.setRole("Employee");
        
        Transaction tnx = null;
        String path ="hibernate.cfg.xml";
        Configuration cfg = new Configuration().configure(path);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
        		cfg.getProperties()).build();        
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        
        Session session = sessionFactory.openSession();
        try {
        	tnx = session.beginTransaction();
        	session.save(employee2);
        	System.out.println("added Successfully...");
        	
        	session.get(Employee.class,1);
        	 System.out.println("Id : "+employee2.getId());
             System.out.println("Name : "+employee2.getName());
             System.out.println("Class : "+employee2.getRole());
             Employee s= (Employee) session.get(Employee.class, 1);
             s.setName("name");
             session.save(s);
             session.get(Employee.class,1);
        	 System.out.println("Id : "+employee2.getId());
             System.out.println("Name : "+employee2.getName());
             System.out.println("Class : "+employee2.getRole());
           
             session.delete(employee);
        	System.out.println("Deleted Successfully...");
        	  tnx.commit();
        }catch (HibernateException e) {
        	e.printStackTrace();
		}finally {
			
			session.close();
		}
       
    }
}
