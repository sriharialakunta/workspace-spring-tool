package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity.BodyBuilder;

import com.example.demo.entity.Movie;

import lombok.NonNull;

public interface MovieService {

	List<Movie> findAllMovies();

	Movie findById(int id);

	Movie saveMovie(Movie movie);

	BodyBuilder deleteMovieById(int id);

	void deleteAllMovies();

	List<Movie> searchMovies(String title, String language, String category, Boolean latestRelease);

	List<Movie> findByTitle(@NonNull String title);

}
