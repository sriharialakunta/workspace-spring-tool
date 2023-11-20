package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student getStudentById(int id);

	Student addStudent(Student student);

	String deleteStudentById(int id);

	String deleteAllStudents();

}
