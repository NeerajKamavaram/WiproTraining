package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Exceptions.ResourseNotFoundException;
import com.example.demo.Repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Mono<Product> saveProduct(Product product) 
	{
		return productRepository.save(product);
	}

	@Override
	public Mono<Product> findProductById(int productId) 
	{
		return productRepository.findById(productId)
				.switchIfEmpty(Mono.error(new ResourseNotFoundException("product not found with id: "+productId)));
	}

	@Override
	public Flux<Product> findAllProducts()
	{
		return productRepository.findAll();
	}

//	@Override
//	public Mono<Product> updateProduct(Product product) 
//	{
//		Mono<Product> monoProduct=productRepository.findById(product.getProductId());
//		return productRepository.save(product);
//	}
//
//	@Override
//	public Mono<Void> deleteProduct(int productId) 
//	{
//		Mono<Product> monoProduct=productRepository.findById(productId);
//		return productRepository.delete(monoProduct).swit
//		
//	}
	

}
