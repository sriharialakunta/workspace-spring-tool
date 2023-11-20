package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student getStudentById(int id) throws Exception;

	Student registerStudent(Student student);

	Student updateStudent(Student student) throws Exception;

	String removeStudent(int id) throws Exception;

}
