package org.erp_case_1.service.order_item.impl;

import org.erp_case_1.model.Order;
import org.erp_case_1.model.OrderItem;
import org.erp_case_1.model.Product;
import org.erp_case_1.model.dto.order_item.OrderItemCreateRequest;
import org.erp_case_1.repository.OrderItemRepository;
import org.erp_case_1.repository.ProductRepository;
import org.erp_case_1.service.order_item.OrderItemCreateService;
import org.erp_case_1.service.product.ProductService;
import org.erp_case_1.service.product.impl.ProductServiceImpl;
import org.erp_case_1.util.PriceCalculator;

public class OrderItemCreateServiceImpl implements OrderItemCreateService {

    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public OrderItemCreateServiceImpl()
    {
        this.orderItemRepository = OrderItemRepository.getInstance();
        this.productRepository = ProductRepository.getInstance();
    }

    @Override
    public OrderItem createOrderItem(
            final Order order,
            final OrderItemCreateRequest orderItemCreateRequest
    ) {
        final Product product = productRepository
                .findByNumber(orderItemCreateRequest.getProductNumber())
                .orElseThrow(() -> new RuntimeException(
                        "Product couldn't be found with given number: "
                        + orderItemCreateRequest.getProductNumber()
                ));

        final OrderItem orderItemToBeCreate = OrderItem.builder()
                .product(product)
                .order(order)
                .amount(orderItemCreateRequest.getAmount())
                .unitPrice(orderItemCreateRequest.getUnitPrice())
                .totalPrice(PriceCalculator.calculateTotalPrice(
                        orderItemCreateRequest.getAmount(),
                        orderItemCreateRequest.getUnitPrice()
                ))
                .build();

        product.getOrderItems().add(orderItemToBeCreate);

        productRepository.save(product);

        return orderItemRepository.save(orderItemToBeCreate);
    }

}
