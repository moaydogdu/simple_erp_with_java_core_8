package org.erp_case_1.service.product.impl;

import org.erp_case_1.model.Product;
import org.erp_case_1.model.dto.product.ProductCreateRequest;
import org.erp_case_1.repository.ProductRepository;
import org.erp_case_1.service.product.ProductCreateService;

public class ProductCreateServiceImpl implements ProductCreateService {

    private final ProductRepository productRepository;

    public ProductCreateServiceImpl() {
        this.productRepository = ProductRepository.getInstance();
    }

    @Override
    public Product createProduct(
            final ProductCreateRequest productCreateRequest
    ) {
        Product productToBeSave = Product.builder()
                .number(productCreateRequest.getNumber())
                .name(productCreateRequest.getName())
                .unitPrice(productCreateRequest.getUnitPrice())
                .build();

        return productRepository.save(productToBeSave);
    }
}
