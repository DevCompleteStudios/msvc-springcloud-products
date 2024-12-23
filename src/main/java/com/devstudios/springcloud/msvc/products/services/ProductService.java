package com.devstudios.springcloud.msvc.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devstudios.springcloud.msvc.products.entities.Product;
import com.devstudios.springcloud.msvc.products.repositories.ProductRepository;





@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository repository;


    @Override
    @Transactional(readOnly=true)
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

}
