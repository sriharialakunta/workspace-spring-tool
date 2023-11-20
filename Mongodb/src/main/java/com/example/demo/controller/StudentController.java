package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;


@RequestMapping("/")
@RestController
public class StudentController {
	private static Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentService service;
	
	@GetMapping("findall/")
	public List<Student> allStudents() {
		logger.info("EMPTY Users List");
		return service.getAll();
	}
	
	@PostMapping("newStu/")
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
}
