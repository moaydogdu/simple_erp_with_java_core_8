package org.erp_case_1.service.product;

import org.erp_case_1.model.Product;
import org.erp_case_1.model.dto.product.ProductCreateRequest;

public interface ProductCreateService {
    Product createProduct(
            final ProductCreateRequest productCreateRequest
    );
}
