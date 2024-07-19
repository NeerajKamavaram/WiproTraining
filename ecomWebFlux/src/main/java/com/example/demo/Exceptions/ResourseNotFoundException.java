package com.example.demo.Exceptions;

public class ResourseNotFoundException extends RuntimeException
{
	public ResourseNotFoundException(String msg)
	{
		super(msg);
	}

}
