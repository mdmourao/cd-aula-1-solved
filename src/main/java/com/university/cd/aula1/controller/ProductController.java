package com.university.cd.aula1.controller;


import com.university.cd.aula1.model.Product;
import com.university.cd.aula1.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody @Valid Product p) {
        return service.create(p);
    }

}