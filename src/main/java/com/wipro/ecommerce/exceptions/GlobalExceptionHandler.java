package com.wipro.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneral(Exception ex) {
		return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<String> handleInvalid(InvalidInputException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}