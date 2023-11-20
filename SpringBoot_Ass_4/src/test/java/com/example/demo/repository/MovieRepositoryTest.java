package com.example.demo.repository;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Movie;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MovieRepositoryTest {

	@Autowired
	private MovieRepository movieRepository;
	
	private Movie movie=new Movie(1,"Liger","zee5","telugu","love", new Date(2022-8-25));
	private Movie movie1=new Movie(2,"Rana Naidu","Netflix","Hindi","Action",new Date(2022-3-12));
	
	@Test
   void addmovie() {
		movieRepository.save(movie);
		movieRepository.save(movie1);
		assertThat(movieRepository).isNotNull();
		assertThat(movieRepository.count()).isPositive();
	}

}
