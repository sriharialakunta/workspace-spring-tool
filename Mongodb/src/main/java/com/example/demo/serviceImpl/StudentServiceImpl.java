package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	private StudentRepository srpo;
	
	@Override
	public List<Student> getAll() {
		return srpo.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		return srpo.insert(student);
	}

}
