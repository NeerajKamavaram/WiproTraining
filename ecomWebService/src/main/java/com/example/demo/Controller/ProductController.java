package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> addNewProduct(@RequestBody Product product) 
	{		
		productService.saveProduct(product);		
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<Product> fetchProductDetails(@PathVariable("productId") int productId) 
	{		
		Product product = productService.findProductById(productId);		
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Product> fetchAllProducts() 
	{		
		List<Product> products = productService.findAllProducts();	
		return products;
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product>  modifyProduct(@RequestBody Product product)
	{
		
		productService.updateProduct(product);
		
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,HttpStatus.OK);		
		return responseEntity;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> removeProduct( @PathVariable("id") int productId) 
	{
		
		productService.deleteProduct(productId);
		ResponseEntity<Void> re = new ResponseEntity<>(HttpStatus.OK);	
		return re;
	}
	
}
