package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectController {

	@Pointcut("execution(* com.example.demo.model.Department.Department(..))")
	   private  void departmentData(){}
	
	@Before("departmentData()")
	public void beforeinsert() {
		System.out.println("Before Inserting Department data");
	}
	
	@After("departmentData()")
	public void afterinsert() {
		
		System.out.println("Department Data inserted Successfully");
	}
	
	@AfterReturning("departmentData()")
	public void afterReturning() {
		System.out.println("Department Data inserted Successfully without errors");
	}
	
	
	@Around("departmentData()")
	public void around(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("Department Data Insertion is in progress");
		joinpoint.proceed();
	}
	
	@AfterThrowing("execution(* com.example.demo.model.Department.toString())")
	public void afterThrowing() {
		System.out.println("Exception occurs at Department Entity");
	}
	
	//For Course Component
	
	@Pointcut("execution(* com.example.demo.model.Employee.Employee(..))")
	   private void employeeData(){}
	
	@Before(value = "employeeData()")
	public void beforeinsertEmployee() {
		System.out.println("Before Inserting Employee data");
	}
	
	@After("employeeData()")
	public void afterinsertEmployee() {
		System.out.println("Employee Data inserted Successfully");
	}
	
	@AfterReturning("employeeData()")
	public void afterReturningEmployee() {
		System.out.println("Employee Data inserted Successfully without errors");
	}
	
	@Around("execution(* com.example.demo.model.Employee.toString())")
	public void aroundEmployee(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("Employee Data Insertion is in progress");
		joinpoint.proceed();
	}
	
	@AfterThrowing("execution(* com.example.demo.model.Employee.toString())")
	public void afterThrowingEmployee() {
		System.out.println("Exception occurs at Employee Entity");
	}
	
}
