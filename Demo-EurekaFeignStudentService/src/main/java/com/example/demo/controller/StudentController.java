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

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
 
	@Autowired
	private StudentService service;

	@GetMapping
	public List<Student> getAllStudents() {
		return service.getAllStudents();

	}

	@GetMapping("{studentId}")
	public Student getStudent(@PathVariable("studentId") int id) {
		return service.getStudentById(id);

	}

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);

	}
	@PutMapping("{studentId}")
	public Student updateStudent(@PathVariable("studentId") int id,@RequestBody Student student) {
		student.setStudentId(id);
		return service.addStudent(student);

	}
	@DeleteMapping("{studentId}")
	public String deleteStudent(@PathVariable("studentId") int id) {
		return service.deleteStudentById(id);

	}

	@DeleteMapping
	public String deleteAllStudents() {
		return service.deleteAllStudents();

	}
}
