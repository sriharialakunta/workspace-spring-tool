package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> getEmployees() {
		return repository.findAll();
	}

	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}

	public void deleteEmployee(int id) {
		repository.deleteById(id);
	}

	public Employee getEmployee(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Employee> initalEmployees(List<Employee> employees) {
		return repository.saveAll(employees);
	}

}
