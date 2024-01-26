package org.erp_case_1.model;

import java.math.BigDecimal;

public class OrderItem {
    private String id;
    private Product product;
    private Order order;
    private BigDecimal amount;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    // Constructors

    /**
     * NoArgsConstructor
     */
    public OrderItem() {
    }

    /**
     * AllArgsConstructor
     */
    public OrderItem(
            final String id,
            final Product product,
            final Order order,
            final BigDecimal amount,
            final BigDecimal unitPrice,
            final BigDecimal totalPrice
    ) {
        this.id = id;
        this.product = product;
        this.order = order;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }


    private OrderItem(
            final OrderItemBuilder orderItemBuilder
    ) {
        this.id = orderItemBuilder.id;
        this.product = orderItemBuilder.product;
        this.order = orderItemBuilder.order;
        this.amount = orderItemBuilder.amount;
        this.unitPrice = orderItemBuilder.unitPrice;
        this.totalPrice = orderItemBuilder.totalPrice;
    }

    // Getters & Setters

    /**
     * Getter method of ID field.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method of ID field.
     */
    public void setId(
            final String id
    ) {
        this.id = id;
    }

    /**
     * Getter method of product field.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Setter method of product field.
     */
    public void setProduct(
            final Product product
    ) {
        this.product = product;
    }

    /**
     * Getter method of order field.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Setter method of order field.
     */
    public void setOrder(
            final Order order
    ) {
        this.order = order;
    }

    /**
     * Getter method of amount field.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter method of amount field.
     */
    public void setAmount(
            final BigDecimal amount
    ) {
        this.amount = amount;
    }

    /**
     * Getter method of unitPrice field.
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Setter method of unitPrice field.
     */
    public void setUnitPrice(
            final BigDecimal unitPrice
    ) {
        this.unitPrice = unitPrice;
    }

    /**
     * Getter method of totalPrice field.
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Setter method of totalPrice field.
     */
    public void setTotalPrice(
            final BigDecimal totalPrice
    ) {
        this.totalPrice = totalPrice;
    }

    public static OrderItemBuilder builder(){
        return new OrderItemBuilder();
    }

    public static class OrderItemBuilder {
        private String id;
        private Product product;
        private Order order;
        private BigDecimal amount;
        private BigDecimal unitPrice;
        private BigDecimal totalPrice;

        public OrderItemBuilder id(
                final String id
        ) {
            this.id = id;
            return this;
        }

        public OrderItemBuilder product(
                final Product product
        ) {
            this.product = product;
            return this;
        }

        public OrderItemBuilder order(
                final Order order
        ) {
            this.order = order;
            return this;
        }

        public OrderItemBuilder amount(
                final BigDecimal amount
        ) {
            this.amount = amount;
            return this;
        }

        public OrderItemBuilder unitPrice(
                final BigDecimal unitPrice
        ) {
            this.unitPrice = unitPrice;
            return this;
        }

        public OrderItemBuilder totalPrice(
                final BigDecimal totalPrice
        ) {
            this.totalPrice = totalPrice;
            return this;
        }

        public OrderItem build()
        {
            return new OrderItem(this);
        }
    }
}
