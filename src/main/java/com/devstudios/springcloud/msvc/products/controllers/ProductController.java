package com.devstudios.springcloud.msvc.products.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devstudios.springcloud.msvc.products.entities.Product;
import com.devstudios.springcloud.msvc.products.services.IProductService;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    IProductService service;


    @GetMapping
    public ResponseEntity<List<Product>> list(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> details( @PathVariable Long id ){
        Optional<Product> productOpt = service.findById(id);
        if( productOpt.isPresent() ) return ResponseEntity.ok(productOpt.get());

        return ResponseEntity.notFound().build();
    }

}
