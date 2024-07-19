package com.Wipro.ProductService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Wipro.ProductService.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>
{

}
