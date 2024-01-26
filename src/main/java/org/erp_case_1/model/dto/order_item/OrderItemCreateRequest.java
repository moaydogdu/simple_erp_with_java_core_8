package org.erp_case_1.model.dto.order_item;

import java.math.BigDecimal;

public class OrderItemCreateRequest {
    private Long productNumber;
    private BigDecimal amount;
    private BigDecimal unitPrice;

    // Constructors

    /**
     * NoArgsConstructor
     */
    public OrderItemCreateRequest(){}

    /**
     * AllArgsConstructor
     */
    public OrderItemCreateRequest(
            final Long productNumber,
            final BigDecimal amount,
            final BigDecimal unitPrice
    ) {
        this.productNumber = productNumber;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    /**
     * Constructor for Builder pattern.
     */
    private OrderItemCreateRequest(
            final OrderItemCreateRequestBuilder orderItemCreateRequestBuilder
    ) {
        this.productNumber = orderItemCreateRequestBuilder.productNumber;
        this.amount = orderItemCreateRequestBuilder.amount;
        this.unitPrice = orderItemCreateRequestBuilder.unitPrice;
    }

    // Getters & Setters

    /**
     * Getter method of productId field.
     */
    public Long getProductNumber() {
        return productNumber;
    }

    /**
     * Setter method of productId field.
     */
    public void setProductNumber(
            final Long productNumber
    ) {
        this.productNumber = productNumber;
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
     * Getter method for Builder of OrderItemCreateRequest.
     */
    public static OrderItemCreateRequestBuilder builder(){
        return new OrderItemCreateRequestBuilder();
    }

    public static class OrderItemCreateRequestBuilder {
        private Long productNumber;
        private BigDecimal amount;
        private BigDecimal unitPrice;

        public OrderItemCreateRequestBuilder productNumber(
                final Long productNumber
        ) {
            this.productNumber = productNumber;
            return this;
        }

        public OrderItemCreateRequestBuilder amount(
                final BigDecimal amount
        ) {
            this.amount = amount;
            return this;
        }

        public OrderItemCreateRequestBuilder unitPrice(
                final BigDecimal unitPrice
        ) {
            this.unitPrice = unitPrice;
            return this;
        }

        public OrderItemCreateRequest build(){
            return new OrderItemCreateRequest(this);
        }

    }

}
