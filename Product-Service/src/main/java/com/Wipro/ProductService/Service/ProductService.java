package com.Wipro.ProductService.Service;

import java.util.List;

import com.Wipro.ProductService.Exceptions.ProductNotFoundException;
import com.Wipro.ProductService.Model.Product;

public interface ProductService 
{
	Product saveProduct(Product product);
	
	Product findProductById(int productId) throws ProductNotFoundException;
	
	List<Product> findAllProducts();
	
	Product updateProduct(Product product);
	
	void deleteProduct(int productId);
}
