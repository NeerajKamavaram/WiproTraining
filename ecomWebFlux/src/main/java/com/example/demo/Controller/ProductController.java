package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Mono<Product>> addProduct(@RequestBody Product product)
	{
		Mono<Product> monoProduct=productService.saveProduct(product);
		return new ResponseEntity<>(monoProduct,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Mono<Product>> fetchProductById(@PathVariable("id") int productId)
	{
		Mono<Product> monoProduct=productService.findProductById(productId);
		return new ResponseEntity<>(monoProduct,HttpStatus.OK);
	}
	
	@GetMapping("all")
	public Flux<Product> fetchAllProducts()
	{
		return productService.findAllProducts();
	}

}
