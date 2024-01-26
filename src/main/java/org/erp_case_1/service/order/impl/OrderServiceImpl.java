package org.erp_case_1.service.order.impl;

import org.erp_case_1.model.Order;
import org.erp_case_1.repository.OrderRepository;
import org.erp_case_1.service.order.OrderService;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl()
    {
        this.orderRepository = OrderRepository.getInstance();
    }

    @Override
    public Order getOrderByNumber(
            final Long orderNumber
    ) {
        return orderRepository
                .findOrderByNumber(orderNumber)
                .orElseThrow(() -> new RuntimeException(
                        "Order not found with given order number: " + orderNumber
                ));
    }
}
