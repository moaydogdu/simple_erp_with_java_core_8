package org.erp_case_1.model.dto.order;

import java.math.BigDecimal;

public class OrderSaleResponse {
    private Long orderNumber;
    private BigDecimal totalSaleCount;

    // Constructors

    /**
     * NoArgsConstructor
     */
    public OrderSaleResponse() {}

    /**
     * AllArgsConstructor
     */
    public OrderSaleResponse(
            final Long orderNumber,
            final BigDecimal totalSaleCount
    ) {
        this.orderNumber = orderNumber;
        this.totalSaleCount = totalSaleCount;
    }

    /**
     * Constructor for Builder
     */
    public OrderSaleResponse(
            final OrderSaleResponseBuilder orderSaleResponseBuilder
    ) {
        this.orderNumber = orderSaleResponseBuilder.orderNumber;
        this.totalSaleCount = orderSaleResponseBuilder.totalSaleCount;
    }

    // Getters & Setters

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(
            final Long orderNumber
    ) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getTotalSaleCount() {
        return totalSaleCount;
    }

    public void setTotalSaleCount(
            final BigDecimal totalSaleCount
    ) {
        this.totalSaleCount = totalSaleCount;
    }

    public static OrderSaleResponseBuilder builder()
    {
        return new OrderSaleResponseBuilder();
    }

    @Override
    public String toString() {
        return "OrderSaleResponse{" +
                "orderNumber=" + orderNumber +
                ", totalSaleCount=" + totalSaleCount +
                "}";
    }

    public static class OrderSaleResponseBuilder {
        private Long orderNumber;
        private BigDecimal totalSaleCount;

        public OrderSaleResponseBuilder orderNumber(
                final Long orderNumber
        ) {
            this.orderNumber = orderNumber;
            return this;
        }

        public OrderSaleResponseBuilder totalSaleCount(
                final BigDecimal totalSaleCount
        ) {
            this.totalSaleCount = totalSaleCount;
            return this;
        }

        public OrderSaleResponse build(){
            return new OrderSaleResponse(this);
        }

    }

}
