package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Product;
import com.example.demo.Exceptions.ProductNotFoundException;

public interface ProductService 
{
	Product saveProduct(Product product);
	
	Product findProductById(int productId) throws ProductNotFoundException;
	
	List<Product> findAllProducts();
	
	Product updateProduct(Product product);
	
	void deleteProduct(int productId);
}
