package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository repository;

	@Override
	public List<Department> getAllDepartments() {
		return repository.findAll();
	}

	@Override
	public Department getDepartmentById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Department addDepartment(Department department) {
		return repository.save(department);
	}

	@Override
	public String deleteDepartmentById(int id) {
		repository.deleteById(id);
		return "deleted Department with : "+id;
	}

	@Override
	public String deleteDepartments() {
		repository.deleteAll();
		return "deleted All Departments";
	}

}
