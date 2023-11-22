package com.manytomany.exceptionHandler;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> idNotFoundException(NoSuchElementException ex){
		return new ResponseEntity<>("Id not found" , HttpStatus.BAD_REQUEST);
	}

}
