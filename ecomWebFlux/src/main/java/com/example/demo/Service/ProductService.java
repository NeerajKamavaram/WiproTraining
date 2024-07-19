package com.example.demo.Service;

import com.example.demo.Entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService 
{
	Mono<Product> saveProduct(Product product);
	
	Mono<Product> findProductById(int productId);
	
	Flux<Product> findAllProducts();
	
//	Mono<Product> updateProduct(Product product);
//	
//	void deleteProduct(int productId);

	
}
