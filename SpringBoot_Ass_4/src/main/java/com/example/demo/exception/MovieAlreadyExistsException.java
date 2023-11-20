package com.example.demo.exception;

@SuppressWarnings("serial")
public class MovieAlreadyExistsException extends RuntimeException {

    public MovieAlreadyExistsException(String message) {
        super(message);
    }
}