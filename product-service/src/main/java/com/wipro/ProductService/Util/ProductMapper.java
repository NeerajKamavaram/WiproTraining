package com.Wipro.ProductService.Util;

import java.util.ArrayList;
import java.util.List;

import com.Wipro.ProductService.Entity.ProductEntity;
import com.Wipro.ProductService.Model.Product;

public class ProductMapper 
{
	public static ProductEntity mapToEntity(Product product)
	{
		ProductEntity productEntity=new ProductEntity();
		productEntity.setProductId(product.getProductId());
		productEntity.setProductName(product.getProductName());
		productEntity.setProductPrice(product.getProductPrice());
		productEntity.setCategory(product.getCategory());
		productEntity.setMfd(product.getMfd());
		
		return productEntity;
		
	}
	
	public static Product mapToModel(ProductEntity productEntity)
	{
		Product product=new Product();
		product.setProductId(productEntity.getProductId());
		product.setProductName(productEntity.getProductName());
		product.setProductPrice(productEntity.getProductPrice());
		product.setCategory(productEntity.getCategory());
		product.setMfd(productEntity.getMfd());
		
		return product;
	}
	
	public static List<Product> mapToModelList(List<ProductEntity> productEntityList)
	{
		List<Product> productList=new ArrayList<>();
		
		for(ProductEntity entity:productEntityList)
		{
			Product product=mapToModel(entity);
			productList.add(product);
		}
		return productList;
	}
	
	public static List<ProductEntity> mapToEntityList(List<Product> productList)
	{
		List<ProductEntity> productEntityList=new ArrayList<>();
		
		for(Product product:productList)
		{
			ProductEntity productEntity=mapToEntity(product);
			productEntityList.add(productEntity);
		}
		return productEntityList;
	}
	 

}
