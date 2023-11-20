package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="DemoEurekaFeignDepartmentService",url="${departmentService}")
public interface DepartmentService {
	
	@GetMapping
	public List<Object> getAllDepartments();

	@GetMapping("/{departmentId}")
	public Object getDepartment(@PathVariable("departmentId") int id);

	@PostMapping
	public Object addDepartment(@RequestBody Object department);

	@PutMapping("/{departmentId}")
	public Object updateDepartment(@PathVariable("departmentId") int id,@RequestBody Object department);

	@DeleteMapping("/{departmentId}")
	public String deleteDepartment(@PathVariable("departmentId") int id);

	@DeleteMapping
	public String deleteAllDepartments();

}
