package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.serviceimpl.MovieServiceImpl;

@SpringBootTest
class MovieServiceTest {

	@Mock
	MovieRepository mr;
	
	@InjectMocks
	MovieServiceImpl ms;
	
	public List<Movie> movie;
	
	@Test
	 void test_getAll() {
		List<Movie> movie= new ArrayList<Movie>();
		movie.add(new Movie(1,"lovetoday","zee5","telugu","love",new Date(2021-10-24)));
		when(mr.findAll()).thenReturn(movie);
		assertEquals(movie,ms.findAllMovies());
	}
	
	@Test
	 void test_saveCustomer() {
		Movie movie1=new Movie(1,"lovetoday","zee5","telugu","love",new Date(2021-10-24));
		when(mr.save(movie1)).thenReturn(movie1);
		assertEquals(movie1,ms.saveMovie(movie1));
	}

}
