package org.erp_case_1.repository;

import org.erp_case_1.model.OrderItem;
import org.erp_case_1.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ProductRepository implements CustomRepository<Product, String> {
    private static volatile ProductRepository instance;

    private static volatile List<Product> products;

    private ProductRepository(
            final List<Product> products
    ) {
        ProductRepository.products = products;
    }

    public static ProductRepository getInstance() {
        ProductRepository localInstance = instance;
        if (localInstance == null) {
            synchronized (ProductRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ProductRepository(new ArrayList<>());
                }
            }
        }
        return localInstance;
    }

    public List<Product> findAll() {
        return products;
    }

    public Product save(
            final Product entity
    ) {
        if (Objects.isNull(entity.getId())) {
            entity.setId(UUID.randomUUID().toString());
                products.add(entity);
            return entity;
        }

        return this.update(entity);

    }

    private Product update(
            final Product product
    ) {
        for (Product productFromRepository : products) {
            if (productFromRepository.getId().equals(product.getId())) {
                productFromRepository = product;
                return product;
            }
        }

        throw new RuntimeException("Something went wrong when updating product");
    }

    public Optional<Product> findById(
            final String id
    ) {
        for (Product productFromDB : products) {
            if (productFromDB.getId().equals(id)) {
                return Optional.of(productFromDB);
            }
        }

        return Optional.empty();
    }

    public Optional<Product> findByNumber(
            final Long productNumber
    ) {
        for (Product productFromDB : products) {
            if (productFromDB.getNumber().equals(productNumber)) {
                return Optional.of(productFromDB);
            }
        }

        return Optional.empty();
    }

}
