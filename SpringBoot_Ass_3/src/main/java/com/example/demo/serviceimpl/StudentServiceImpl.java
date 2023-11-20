package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student getStudentById(int id) throws Exception {
		Optional<Student> isExist = studentRepository.findById(id);
		if(isExist.isEmpty())
			throw new Exception("No one with this id = "+id);
		return isExist.get();
	}
	
	public Student registerStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Student student) throws Exception {
		Student existingStudent = getStudentById(student.getId());
		existingStudent.setSec(student.getSec());
		return studentRepository.save(existingStudent);
	}
	
	public String removeStudent(int id) throws Exception {
		Student existingStudent = getStudentById(id);
		studentRepository.delete(existingStudent);
		return "student deleted with id = "+id;
	}
}
