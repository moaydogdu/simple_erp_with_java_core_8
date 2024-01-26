package org.erp_case_1.service.order.impl;

import org.erp_case_1.model.Order;
import org.erp_case_1.model.OrderItem;
import org.erp_case_1.model.dto.order_item.OrderItemCreateRequest;
import org.erp_case_1.repository.OrderRepository;
import org.erp_case_1.service.order.OrderCreateService;
import org.erp_case_1.service.order_item.OrderItemCreateService;
import org.erp_case_1.service.order_item.impl.OrderItemCreateServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OrderCreateServiceImpl implements OrderCreateService {
    private final OrderRepository orderRepository;
    private final OrderItemCreateService orderItemCreateService;

    public OrderCreateServiceImpl() {
        orderRepository = OrderRepository.getInstance();
        orderItemCreateService = new OrderItemCreateServiceImpl();
    }

    @Override
    public Order createOrder(
            final Long orderNumber,
            final List<OrderItemCreateRequest> orderItemCreateRequests
    ) {
        final Order orderToBeCreate = Order.builder()
                .number(orderNumber)
                .build();

        orderRepository.save(orderToBeCreate);

        final List<OrderItem> orderItems = orderItemCreateRequests.stream()
                .map(request -> orderItemCreateService
                        .createOrderItem(orderToBeCreate, request))
                .collect(Collectors.toList());

        orderToBeCreate.setOrderItems(orderItems);

        calculateTotalPriceOfOrder(orderToBeCreate, orderItems);

        calculateTotalProductAmountOfOrder(orderToBeCreate, orderItems);

        return orderRepository.save(orderToBeCreate);
    }

    private void calculateTotalPriceOfOrder(
            final Order orderToBeCreate,
            final List<OrderItem> orderItems
    ) {
        orderToBeCreate.setTotalPrice(
                orderItems
                        .stream()
                        .map(OrderItem::getTotalPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }

    private void calculateTotalProductAmountOfOrder(
            final Order orderToBeCreate,
            final List<OrderItem> orderItems
    ) {
        orderToBeCreate.setTotalProductAmount(
                orderItems
                        .stream()
                        .map(OrderItem::getAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }
}
