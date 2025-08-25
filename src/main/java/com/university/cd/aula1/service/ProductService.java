package com.university.cd.aula1.service;


import com.university.cd.aula1.model.Product;
import com.university.cd.aula1.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product create(Product p) {
        if (repo.existsByNameIgnoreCase(p.getName())) {
            throw new RuntimeException("Product already exists!");
        }
        return repo.save(p);
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product getById(Long id){
        Product product = repo.getById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        return product;
    }
}