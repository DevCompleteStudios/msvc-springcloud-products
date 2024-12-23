package com.devstudios.springcloud.msvc.products.services;

import java.util.List;
import java.util.Optional;

import com.devstudios.springcloud.msvc.products.entities.Product;





public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
