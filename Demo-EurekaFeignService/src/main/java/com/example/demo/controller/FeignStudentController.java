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

import com.example.demo.service.StusentService;

@RestController
@RequestMapping("/feignstud")
public class FeignStudentController {

	@Autowired
	private StusentService service;
	
	@GetMapping
	public List<Object> getAllStudents(){
		return service.getAllStudents();
	}

	@GetMapping("/{studentId}")
	public Object getDepartment(@PathVariable("studentId") int id) {
		return service.getDepartment(id);
	}

	@PostMapping
	public Object addDepartment(@RequestBody Object student) {
		return service.addDepartment(student);
	}

	@PutMapping("/{studentId}")
	public Object updateDepartment(@PathVariable("studentId") int id,@RequestBody Object student) {
		return service.updateDepartment(id, student);
	}

	@DeleteMapping("/{studentId}")
	public String deleteDepartment(@PathVariable("studentId") int id) {
		return service.deleteDepartment(id);
	}

	@DeleteMapping
	public String deleteAllDepartments() {
		return service.deleteAllDepartments();
	}
}
