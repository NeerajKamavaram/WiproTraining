package com.Wipro.Course.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse 
{
	private LocalDateTime timeStamp;
	private HttpStatus status;
	private String error;
	private String messege;

}
