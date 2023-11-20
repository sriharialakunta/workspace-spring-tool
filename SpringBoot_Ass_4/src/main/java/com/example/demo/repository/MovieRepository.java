package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Movie;

import lombok.NonNull;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	List<Movie> findByTitle(@NonNull String title);

	List<Movie> findByLanguage(String language);

	List<Movie> findByCategory(String category);

	@Query(nativeQuery = true,value = "SELECT * FROM movie ORDER BY yearOfRelease DESC")
	List<Movie> findByYearOfRelease();

	Movie findMovieById(int id);

}
