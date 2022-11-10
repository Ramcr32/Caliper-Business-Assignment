package com.assignment.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetail> ExceptionHandler(NotFoundException e, WebRequest wr) {
		MyErrorDetail err = new MyErrorDetail();
		err.setDescription(wr.getDescription(false));
		err.setMessage(e.getMessage());
		err.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> ExceptionHandler(Exception e, WebRequest wr) {
		MyErrorDetail err = new MyErrorDetail();
		err.setDescription(wr.getDescription(false));
		err.setMessage(e.getMessage());
		err.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetail> ExceptionHandler(NoHandlerFoundException e, WebRequest wr) {
		MyErrorDetail err = new MyErrorDetail();
		err.setDescription(wr.getDescription(false));
		err.setMessage(e.getMessage());
		err.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> ExceptionHandler(MethodArgumentNotValidException e, WebRequest wr) {
		MyErrorDetail err = new MyErrorDetail();
		err.setDescription(wr.getDescription(false));
		err.setMessage(e.getMessage());
		err.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
	}

}
