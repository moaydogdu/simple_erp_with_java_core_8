package org.erp_case_1.repository;

import org.erp_case_1.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class OrderRepository implements CustomRepository<Order, String> {

    private static volatile OrderRepository instance;

    private static volatile List<Order> orders;

    private OrderRepository(
            final List<Order> orders
    ) {
        OrderRepository.orders = orders;
    }

    public static OrderRepository getInstance() {
        OrderRepository localInstance = instance;
        if (localInstance == null) {
            synchronized (OrderRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new OrderRepository(new ArrayList<>());
                }
            }
        }
        return localInstance;
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public Order save(
            final Order orderToBeSave
    ) {
        if (Objects.isNull(orderToBeSave.getId())) {
            orderToBeSave.setId(UUID.randomUUID().toString());
            orders.add(orderToBeSave);
            return orderToBeSave;
        }

        return this.update(orderToBeSave);
    }

    private Order update(
            final Order orderToBeUpdate
    ) {
        for (Order order : orders) {
            if (order.getId().equals(orderToBeUpdate.getId())) {
                order = orderToBeUpdate;
                return order;
            }
        }

        throw new RuntimeException("Something went wrong when updating order");
    }

    public Optional<Order> findOrderByNumber(
            final Long orderNumber
    ) {
        for (Order order: orders)
        {
            if (order.getNumber().equals(orderNumber))
            {
                return Optional.of(order);
            }
        }

        return Optional.empty();
    }
}
