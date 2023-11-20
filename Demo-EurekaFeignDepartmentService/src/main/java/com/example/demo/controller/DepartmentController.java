package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
 
	@Autowired
	private DepartmentService service;

	@GetMapping
	public List<Department> getAllDepartments() {
		return service.getAllDepartments();

	}

	@GetMapping("{departmentId}")
	public Department getDepartment(@PathVariable("departmentId") int id) {
		return service.getDepartmentById(id);

	}

	@PostMapping
	public Department addDepartment(@RequestBody Department department) {
		return service.addDepartment(department);

	}
	@PutMapping("{departmentId}")
	public Department updateDepartment(@PathVariable("departmentId") int id,@RequestBody Department department) {
		department.setDepartmentId(id);
		return service.addDepartment(department);

	}
	@DeleteMapping("{departmentId}")
	public String deleteDepartment(@PathVariable("departmentId") int id) {
		return service.deleteDepartmentById(id);

	}

	@DeleteMapping
	public String deleteAllDepartments() {
		return service.deleteDepartments();

	}
}
