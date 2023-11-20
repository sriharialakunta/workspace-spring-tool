package com.wipro.topgear.HibernateDemo;

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
	        employee.setDesignation("Employee");
	        employee.setSalary(20000);
	        Employee employee2 = new Employee();
	        employee2.setName("Sudheer");
	        employee2.setDesignation("Employee");
	        employee2.setSalary(25000);
	        Employee employee3 = new Employee();
	        employee3.setName("Srinu");
	        employee3.setDesignation("Manager");
	        employee3.setSalary(32000);
	        Employee employee4 = new Employee();
	        employee4.setName("Venu");
	        employee4.setDesignation("Employee");
	        employee4.setSalary(35000);
	        Employee employee5 = new Employee();
	        employee5.setName("Thrinadh");
	        employee5.setDesignation("Manager");
	        employee5.setSalary(25000);
	        
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
	        	session.save(employee2);
	        	session.save(employee3);
	        	session.save(employee4);
	        	session.save(employee5);
	        	System.out.println("added Successfully...");
	        	
	        	  tnx.commit();
	        }catch (HibernateException e) {
	        	e.printStackTrace();
			}finally {
				
				session.close();
			}
	       
	    }
	}


