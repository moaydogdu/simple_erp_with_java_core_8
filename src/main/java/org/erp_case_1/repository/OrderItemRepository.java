package org.erp_case_1.repository;

import org.erp_case_1.model.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderItemRepository implements CustomRepository<OrderItem, String> {
    private static volatile OrderItemRepository instance;

    private static volatile List<OrderItem> orderItems;

    private OrderItemRepository(
            final List<OrderItem> orderItems
    ) {
        OrderItemRepository.orderItems = orderItems;
    }

    public static OrderItemRepository getInstance() {
        OrderItemRepository localInstance = instance;
        if (localInstance == null) {
            synchronized (OrderItemRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new OrderItemRepository(new ArrayList<>());
                }
            }
        }
        return localInstance;
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItems;
    }

    @Override
    public OrderItem save(
            final OrderItem orderItem
    ) {
        if (Objects.isNull(orderItem.getId())) {
            orderItem.setId(UUID.randomUUID().toString());
                orderItems.add(orderItem);
                return orderItem;
        }

        return this.update(orderItem);
    }

    private OrderItem update(
            final OrderItem orderItemToBeUpdate
    ) {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getId().equals(orderItemToBeUpdate.getId())) {
                orderItem = orderItemToBeUpdate;
                return orderItem;
            }
        }

        throw new RuntimeException("Something went wrong when updating orderItem");
    }

    public List<OrderItem> findOrderItemsByProductNumber(
            final Long productNumber
    ) {
        return orderItems.stream()
                .filter(orderItem -> orderItem.getProduct().getNumber().equals(productNumber))
                .collect(Collectors.toList());

    }
}
