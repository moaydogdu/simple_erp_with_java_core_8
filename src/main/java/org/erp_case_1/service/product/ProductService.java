package org.erp_case_1.service.product;

import org.erp_case_1.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProductById(
            final String productId
    );

    Product getProductByNumber(
            final Long productNumber
    );
}
