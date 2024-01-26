package org.erp_case_1.service.product.impl;

import org.erp_case_1.model.Product;
import org.erp_case_1.repository.ProductRepository;
import org.erp_case_1.service.product.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(){
        this.productRepository = ProductRepository.getInstance();
    }

    @Override
    public List<Product> getProducts() {
        final List<Product> productsFromDB = productRepository
                .findAll();

        if (productsFromDB.isEmpty())
        {
            throw new RuntimeException("Couldn't find any product.");
        }

        return productsFromDB;
    }

    public Product getProductById(
            final String productId
    ) {
        return productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException(
                        "There is no product in database with given id: " + productId)
                );
    }

    @Override
    public Product getProductByNumber(
            final Long productNumber
    ) {
        return productRepository
                .findByNumber(productNumber)
                .orElseThrow(() -> new RuntimeException(
                        "There is no product in database with given number: " + productNumber)
                );
    }
}
