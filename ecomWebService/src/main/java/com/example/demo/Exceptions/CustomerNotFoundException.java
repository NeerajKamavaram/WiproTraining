package com.example.demo.Exceptions;

public class CustomerNotFoundException extends RuntimeException
{
	public CustomerNotFoundException(String msg)
	{
		super(msg);
	}
}
