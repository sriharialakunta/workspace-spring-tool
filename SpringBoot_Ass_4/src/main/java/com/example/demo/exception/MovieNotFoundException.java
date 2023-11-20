package com.example.demo.exception;

public class MovieNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public MovieNotFoundException() {
        super("Movie not Found");
    }


}
