package org.erp_case_1.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private String id;
    private Long number;
    private List<OrderItem> orderItems;
    private BigDecimal totalPrice;
    private BigDecimal totalProductAmount;

    // Constructors

    /**
     * NoArgsConstructor
     */
    public Order() {
    }

    /**
     * AllArgsConstructor
     */
    public Order(
            final String id,
            final Long number,
            final List<OrderItem> orderItems,
            final BigDecimal totalPrice,
            final BigDecimal totalProductAmount
    ) {
        this.id = id;
        this.number = number;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
        this.totalProductAmount = totalProductAmount;
    }

    /**
     * Private Constructor for Builder.
     */
    private Order(
            final OrderBuilder orderBuilder
    ) {
        this.id = orderBuilder.id;
        this.number = orderBuilder.number;
        this.orderItems = orderBuilder.orderItems;
        this.totalPrice = orderBuilder.totalPrice;
        this.totalProductAmount = orderBuilder.totalProductAmount;
    }

    // Getters & Setters

    /**
     * Getter method for ID field.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for ID field.
     */
    public void setId(
            final String id
    ) {
        this.id = id;
    }

    /**
     * Getter method for number field.
     */
    public Long getNumber() {
        return number;
    }

    /**
     * Setter method for number field.
     */
    public void setNumber(
            final Long number
    ) {
        this.number = number;
    }

    /**
     * Getter method for List of OrderItems
     */
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    /**
     * Setter method for List of OrderItems
     */
    public void setOrderItems(
            final List<OrderItem> orderItems
    ) {
        this.orderItems = orderItems;
    }

    /**
     * Getter method for totalPrice field.
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Setter method for totalPrice field.
     */
    public void setTotalPrice(
            final BigDecimal totalPrice
    ) {
        this.totalPrice = totalPrice;
    }

    /**
     * Getter method for totalProductAmount field.
     */
    public BigDecimal getTotalProductAmount() {
        return totalProductAmount;
    }

    /**
     * Setter method for totalProductAmount field.
     */
    public void setTotalProductAmount(
            final BigDecimal totalProductAmount
    ) {
        this.totalProductAmount = totalProductAmount;
    }

    /**
     * Static getter method for Builder of Order
     */
    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    /**
     * Builder for Order
     */
    public static class OrderBuilder {
        private String id;
        private Long number;
        private List<OrderItem> orderItems;
        private BigDecimal totalPrice;
        private BigDecimal totalProductAmount;

        public OrderBuilder id(
                final String id
        ) {
            this.id = id;
            return this;
        }

        public OrderBuilder number(
                final Long number
        ) {
            this.number = number;
            return this;
        }

        public OrderBuilder orderItems(
                final List<OrderItem> orderItems
        ) {
            this.orderItems = orderItems;
            return this;
        }

        public OrderBuilder totalPrice(
                final BigDecimal totalPrice
        ) {
            this.totalPrice = totalPrice;
            return this;
        }

        public OrderBuilder totalProductAmount(
                final BigDecimal totalProductAmount
        ) {
            this.totalProductAmount = totalProductAmount;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

}
