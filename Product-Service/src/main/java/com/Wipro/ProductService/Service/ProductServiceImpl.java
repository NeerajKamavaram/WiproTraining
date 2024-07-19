package com.Wipro.ProductService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Wipro.ProductService.Entity.ProductEntity;
import com.Wipro.ProductService.Exceptions.ProductNotFoundException;
import com.Wipro.ProductService.Model.Product;
import com.Wipro.ProductService.Repository.ProductRepository;
import com.Wipro.ProductService.Util.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) 
	{
		//convert model object to entity object
		ProductEntity productEntity=ProductMapper.mapToEntity(product);
		productRepository.save(productEntity);
		product.setProductId(productEntity.getProductId());
		return product;
	}

	@Override
	public Product findProductById(int productId) throws ProductNotFoundException 
	{
	
		Optional<ProductEntity> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) 
		{
			throw new ProductNotFoundException("Product not existing with id: "+productId);
		}		
		ProductEntity productEntity = optionalProduct.get();
		
		//convert entity to model
		Product product=ProductMapper.mapToModel(productEntity);
		return product;
	}

	@Override
	public List<Product> findAllProducts() 
	{
	
		List<ProductEntity> productEntityList=productRepository.findAll();
		
		//convert Entity list to model list
		List<Product> productList=ProductMapper.mapToModelList(productEntityList);
		return productList;
	}
	
	@Override
	public Product updateProduct(Product product) throws ProductNotFoundException
	{		
		Optional<ProductEntity> optionalProduct = productRepository.findById(product.getProductId());
		if(optionalProduct.isEmpty()) 
		{
			
		}
		ProductEntity productEntity=optionalProduct.get();
		
		//convert entity to model
		productRepository.save(productEntity);		
		Product product1=ProductMapper.mapToModel(productEntity);
		return product1;
	}


	@Override
	public void deleteProduct(int productId) throws ProductNotFoundException
	{
		Optional<ProductEntity> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty())
		{
			throw new ProductNotFoundException("product not existing with id: "+productId); 
			
		}
		
		ProductEntity productEntity = optionalProduct.get();
		productRepository.delete(productEntity);
	}
}
