package com.example.demo.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.demo.Entity.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer>
{

}
