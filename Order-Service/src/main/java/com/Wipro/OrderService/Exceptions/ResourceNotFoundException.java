package com.Wipro.OrderService.Exceptions;

public class ResourceNotFoundException extends RuntimeException
{
	public ResourceNotFoundException(String msg) 
	{
		super(msg);
	}

}
