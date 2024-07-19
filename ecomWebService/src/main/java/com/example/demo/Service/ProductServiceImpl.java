package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Product;
import com.example.demo.Exceptions.CustomerNotFoundException;
import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) 
	{
		productRepository.save(product);
		return product;
	}

	@Override
	public Product findProductById(int productId) throws ProductNotFoundException 
	{
	
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) 
		{
			throw new ProductNotFoundException("Product not existing with id: "+productId);
		}		
		Product product = optionalProduct.get();
		return product;
	}

	@Override
	public List<Product> findAllProducts() 
	{
	
		return productRepository.findAll();
	}
	
	@Override
	public Product updateProduct(Product product) throws ProductNotFoundException
	{		
		Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
		if(optionalProduct.isEmpty()) 
		{
			
		}		
		productRepository.save(product);		
		return product;
	}


	@Override
	public void deleteProduct(int productId) throws ProductNotFoundException
	{
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty())
		{
			throw new ProductNotFoundException("product not existing with id: "+productId); 
			
		}
		
		Product product = optionalProduct.get();
		productRepository.delete(product);
	}
}
