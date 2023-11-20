package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository repository;

	@Override
	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Student addStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public String deleteStudentById(int id) {
		repository.deleteById(id);
		return "deleted Department with : "+id;
	}

	@Override
	public String deleteAllStudents() {
		repository.deleteAll();
		return "deleted All Departments";
	}

}
