package com.devstudios.springcloud.msvc.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devstudios.springcloud.msvc.products.entities.Product;



public interface ProductRepository extends JpaRepository<Product, Long> {

}
