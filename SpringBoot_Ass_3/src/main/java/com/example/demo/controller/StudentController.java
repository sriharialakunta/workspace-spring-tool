package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentDetailsById(@PathVariable int id) throws Exception {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.FOUND);
	}

	@PostMapping("/registerStudents")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.registerStudent(student), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws Exception {
		return new ResponseEntity<Student>(studentService.updateStudent(student), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeStudent(@PathVariable int id) throws Exception{
		return new ResponseEntity<String>(studentService.removeStudent(id),HttpStatus.OK);
	}
}