package com.Wipro.ProductService.Exceptions;

public class ProductNotFoundException extends RuntimeException
{
	public ProductNotFoundException(String msg)
	{
		super(msg);
	}
}
