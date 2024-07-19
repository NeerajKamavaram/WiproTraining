package com.Wipro.Course.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception ex)
	{
		ErrorResponse er=new ErrorResponse();
		er.setStatus(HttpStatus.NOT_FOUND);
		er.setError(HttpStatus.NOT_FOUND.toString());
		er.setMessege(ex.getMessage());
		er.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
}
