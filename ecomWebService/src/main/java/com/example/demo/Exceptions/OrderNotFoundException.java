package com.example.demo.Exceptions;

public class OrderNotFoundException  extends RuntimeException
{
	public OrderNotFoundException(String msg)
	{
		super(msg);
	}
}
