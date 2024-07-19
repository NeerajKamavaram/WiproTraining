package com.Wipro.CustomerService.Exceptions;

public class CustomerNotFoundException extends RuntimeException
{
	public CustomerNotFoundException(String msg)
	{
		super(msg);
	}
}
