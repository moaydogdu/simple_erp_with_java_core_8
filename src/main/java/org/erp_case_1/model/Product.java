package org.erp_case_1.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String id;
    private Long number;
    private String name;
    private BigDecimal unitPrice;
    private List<OrderItem> orderItems;

    // Constructors

    /**
     * NoArgsConstructor
     */
    public Product() {
    }

    /**
     * AllArgsConstructor
     */
    public Product(
            final String id,
            final Long number,
            final String name,
            final BigDecimal unitPrice,
            final List<OrderItem> orderItems
    ) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.unitPrice = unitPrice;
        if (orderItems == null)
        {
            this.orderItems = new ArrayList<>();
        }
        else {
            this.orderItems = orderItems;

        }
    }

    /**
     * Private constructor with ProductBuilder
     */
    private Product(
            final ProductBuilder productBuilder
    ) {
        this.id = productBuilder.id;
        this.number = productBuilder.number;
        this.name = productBuilder.name;
        this.unitPrice = productBuilder.unitPrice;
        if (productBuilder.orderItems == null)
        {
            this.orderItems = new ArrayList<>();
        }
        else {
            this.orderItems = productBuilder.orderItems;

        }
    }

    // Getters & Setters

    /**
     * Getter method of ID field.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter method of ID field
     */
    public void setId(
            final String id
    ) {
        this.id = id;
    }

    /**
     * Getter method of number field.
     */
    public Long getNumber() {
        return this.number;
    }

    /**
     * Setter method of number field.
     */
    public void setNumber(
            final Long number
    ) {
        this.number = number;
    }

    /**
     * Getter method of name field.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter method of name field.
     */
    public void setName(
            final String name
    ) {
        this.name = name;
    }

    /**
     * Getter method of unitPrice field.
     */
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * Setter method of unitPrice field.
     */
    public void setUnitPrice(
            final BigDecimal unitPrice
    ) {
        this.unitPrice = unitPrice;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(
            final List<OrderItem> orderItems
    ) {
        this.orderItems = orderItems;
    }

    /**
     * Getter method of Product.builder()
     */
    public static ProductBuilder builder() {
        return new ProductBuilder();
    }


    /**
     * Builder pattern of Product class.
     */
    public static class ProductBuilder {
        private String id;
        private Long number;
        private String name;
        private BigDecimal unitPrice;
        private List<OrderItem> orderItems;

        public ProductBuilder id(
                final String id
        ) {
            this.id = id;
            return this;
        }

        public ProductBuilder number(
                final Long number
        ) {
            this.number = number;
            return this;
        }

        public ProductBuilder name(
                final String name
        ) {
            this.name = name;
            return this;
        }

        public ProductBuilder unitPrice(
                final BigDecimal unitPrice
        ) {
            this.unitPrice = unitPrice;
            return this;
        }

        public ProductBuilder orderItems(
                final List<OrderItem> orderItems
        ) {
            this.orderItems = orderItems;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

}
