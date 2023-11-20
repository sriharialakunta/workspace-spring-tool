package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.entity.Movie;
import com.example.demo.exception.MovieAlreadyExistsException;
import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/movies/")
@Slf4j
public class MovieController {
	@Autowired
	public MovieService movieService;
	
	private String conflict ="Conflict";
	private String responded ="Responded";

	private HttpHeaders headers = new HttpHeaders();

	@GetMapping("all/")
	public ResponseEntity<List<Movie>> listAllMovies() {

		List<Movie> movies = movieService.findAllMovies();
		if (movies.isEmpty()) {
			log.info("EMPTY Movies List");
			headers.add(conflict, "NO Movies Present");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).body(null);
		}

		log.info("List Of Movies");
		headers.add(responded, "List Of Movies Present");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movies);
	}

	@GetMapping("search/")
	public ResponseEntity<List<Movie>> searchMovies(@RequestParam(required = false) String title,
			@RequestParam(required = false) String language, @RequestParam(required = false) String category,
			@RequestParam(required = false) Boolean latestRelease) throws MovieNotFoundException {
		List<Movie> movies = movieService.searchMovies(title, language, category, latestRelease);

		if (movies != null)
			return new ResponseEntity<>(movies, HttpStatus.OK);

		return new ResponseEntity<>(movies, HttpStatus.NOT_FOUND);
	}

	@GetMapping("movie/{id}/")
	public ResponseEntity<Movie> fetchMovieById(@PathVariable("id") int id) throws MovieNotFoundException{
		Movie movie = movieService.findById(id);
		if (movie == null) {
			log.info("Movie with id " + id + " not found");
			headers.add(conflict, "Invallid Movie ID");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(null);
		}
		log.info("Fetching Movie with id " + id);
		headers.add(responded, "Fetching The Movie By ID");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movie);
	}

	@PostMapping("addmovie/")
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie, UriComponentsBuilder ucBuilder) throws MovieAlreadyExistsException{
		log.info("Creating Movie " + movie.getTitle());
		if (movieService.findByTitle(movie.getTitle()).isEmpty()) {

			movieService.saveMovie(movie);
			headers.add(responded, "Movie Created");
			headers.setLocation(ucBuilder.path("/movie/{id}").buildAndExpand(movie.getId()).toUri());
			return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(movie);
		}

		log.info("A Movie with this name " + movie.getTitle() + " is already exist");
		headers.add(conflict, "A Movie with this name is already exist");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(movie);
	}

	@DeleteMapping("movie/{id}/")
	public BodyBuilder deleteUser(@PathVariable("id") int id) {
		if (movieService.findById(id) == null) {
			log.info("Unable to delete. Movie with id " + id + " not found");
			headers.add(conflict, "Unable to delete The Movie");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers);
		}

		movieService.deleteMovieById(id);
		log.info("Fetching & Deleting Movie with id " + id);
		headers.add(responded, "Fetching & Deleting Movie with id");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers);
	}

	@DeleteMapping("deleteallmovies/")
	public ResponseEntity<Movie> deleteAllMovie() {
		log.info("Deleting All Movies");
		movieService.deleteAllMovies();
		headers.add(responded, "Deleted All Movies");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).body(null);
	}
}
