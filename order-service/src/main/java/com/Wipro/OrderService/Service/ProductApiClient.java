package com.Wipro.OrderService.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Wipro.OrderService.Model.Product;

@FeignClient(value="PRODUCT-SERVICE")
public interface ProductApiClient
{
	@GetMapping("/product/get/{id}")
	public Product getProductDetails(@PathVariable("id") int productId);

}
