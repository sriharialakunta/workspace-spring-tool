package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentService {

	List<Department> getAllDepartments();

	Department getDepartmentById(int id);

	Department addDepartment(Department department);

	String deleteDepartmentById(int id);

	String deleteDepartments();

}
