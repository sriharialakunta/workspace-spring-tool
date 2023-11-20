package com.example.demo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Component
public class StudentUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
           Optional<Student> student = repo.findByName(username);
		
		return student.map(StudentUserDetails::new)
			.orElseThrow(()->new UsernameNotFoundException("student not found " + username));
		
	}

	
}
