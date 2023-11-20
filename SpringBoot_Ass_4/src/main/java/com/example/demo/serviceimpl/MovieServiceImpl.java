package com.example.demo.serviceimpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;

	private HttpHeaders headers = new HttpHeaders();

	public List<Movie> findByTitle(String title) {
		return repository.findByTitle(title);
	}

	public List<Movie> findByLanguage(String language) {
		return repository.findByLanguage(language);
	}

	public List<Movie> findByCategory(String category) {
		return repository.findByCategory(category);

	}

	public List<Movie> findByYearOfRelease() {
		return repository.findByYearOfRelease();
	}

	@Override
	public List<Movie> findAllMovies() {
		return repository.findAll();
	}

	@Override
	public Movie findById(int id) {
		return repository.findMovieById(id);
	}
	@Override
	public Movie saveMovie(Movie movie) {
		return repository.save(movie);
	}

	@Override
	public BodyBuilder deleteMovieById(int id) {


		if (repository.findById(id).isEmpty()) {
			log.info("Unable to delete. Movie with id " + id + " not found");
			headers.add("Conflict", "Unable to delete The Movie");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers);
		}

		repository.deleteById(id);
		log.info("Fetching & Deleting Movie with id " + id);
		headers.add("Responded", "Fetching & Deleting Movie with id");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers);
	}


	@Override
	public void deleteAllMovies() {
		repository.deleteAll();
	}

	@Override
	public List<Movie> searchMovies(String title, String language, String category, Boolean latestRelease) {
		if (title != null)
			return findByTitle(title);
		else if (language != null)
			return findByLanguage(language);
		else if (category != null)
			return findByCategory(category);
		else if (Boolean.TRUE.equals(latestRelease))
			return findByYearOfRelease();
		else
			return Collections.emptyList();

	}



}
