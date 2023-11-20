package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="DemoEurekaFeignStudentService",url="${studentService}")
public interface StusentService {
	
	@GetMapping
	public List<Object> getAllStudents();

	@GetMapping("/{studentId}")
	public Object getDepartment(@PathVariable("studentId") int id);

	@PostMapping
	public Object addDepartment(@RequestBody Object student);

	@PutMapping("/{studentId}")
	public Object updateDepartment(@PathVariable("studentId") int id,@RequestBody Object student);

	@DeleteMapping("/{studentId}")
	public String deleteDepartment(@PathVariable("studentId") int id);

	@DeleteMapping
	public String deleteAllDepartments();

}
