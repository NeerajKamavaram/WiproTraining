package com.example.demo.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.Model.ApiError;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<Mono<ApiError>> handleResourseNotFoundException(Exception ex)
	{
		ApiError apiError=new ApiError();
		apiError.setError((HttpStatus.NOT_FOUND.toString()));
		apiError.setMessege(ex.getMessage());
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(Mono.just(apiError),HttpStatus.NOT_FOUND);
	}
}
