package com.university.cd.aula1.repository;

import com.university.cd.aula1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import com.university.cd.aula1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/*
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByNameIgnoreCase(String name);
}
*/

// fake repo:
@Repository
public class ProductRepository {

    private final Map<Long, Product> store = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idGenerator.getAndIncrement());
        }
        store.put(product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    public Product getById(Long id) {
        return store.get(id);
    }

    public boolean existsByNameIgnoreCase(String name) {
        return store.values().stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(name));
    }

}