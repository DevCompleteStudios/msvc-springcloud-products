package com.devstudios.springcloud.msvc.products.controllers;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devstudios.springcloud.msvc.products.entities.Product;
import com.devstudios.springcloud.msvc.products.services.IProductService;



@RestController
public class ProductController {

    @Autowired
    IProductService service;


    @GetMapping
    public ResponseEntity<List<Product>> list(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> details( @PathVariable Long id ) throws InterruptedException {
        if( id.equals(10L) ){
            throw new IllegalStateException("Producto no encontrado");
        } else if( id.equals(7L) ){
            TimeUnit.SECONDS.sleep(3);
        }

        Optional<Product> productOpt = service.findById(id);
        if( productOpt.isPresent() ) return ResponseEntity.ok(productOpt.get());

        return ResponseEntity.notFound().build();
    }

}
