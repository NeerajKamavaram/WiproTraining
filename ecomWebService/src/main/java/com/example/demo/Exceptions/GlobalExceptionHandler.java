package com.example.demo.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.Model.ApiError;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApiError> handleCustomerNotFoundException(Exception ex)
	{
		ApiError apiError=new ApiError();
		apiError.setError((HttpStatus.NOT_FOUND.toString()));
		apiError.setMessege(ex.getMessage());
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setStatus(HttpStatus.NOT_FOUND);
		ResponseEntity<ApiError> re=new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
		return re;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ApiError> handleProductNotFoundException(Exception ex)
	{
		ApiError apiError=new ApiError();
		apiError.setError((HttpStatus.NOT_FOUND.toString()));
		apiError.setMessege(ex.getMessage());
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setStatus(HttpStatus.NOT_FOUND);
		ResponseEntity<ApiError> re=new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
		return re;
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ApiError> handleOrderNotFoundException(Exception ex)
	{
		ApiError apiError=new ApiError();
		apiError.setError((HttpStatus.NOT_FOUND.toString()));
		apiError.setMessege(ex.getMessage());
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setStatus(HttpStatus.NOT_FOUND);
		ResponseEntity<ApiError> re=new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
		return re;
	}
	
	
}
