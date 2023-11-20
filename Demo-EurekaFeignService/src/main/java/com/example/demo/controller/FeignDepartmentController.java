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

import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/feigndept")
public class FeignDepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	@GetMapping
	public List<Object> getAllDepartments(){
		return deptService.getAllDepartments();
	}

	@GetMapping("/{departmentId}")
	public Object getDepartment(@PathVariable("departmentId") int id) {
		return deptService.getDepartment(id);
	}

	@PostMapping
	public Object addDepartment(@RequestBody Object department) {
		return deptService.addDepartment(department);
	}

	@PutMapping("/{departmentId}")
	public Object updateDepartment(@PathVariable("departmentId") int id,@RequestBody Object department) {
		return deptService.updateDepartment(id, department);
	}

	@DeleteMapping("/{departmentId}")
	public String deleteDepartment(@PathVariable("departmentId") int id) {
		return deptService.deleteDepartment(id);
	}

	@DeleteMapping
	public String deleteAllDepartments() {
		return deptService.deleteAllDepartments();
	}
}
