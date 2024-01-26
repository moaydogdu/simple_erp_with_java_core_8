package org.erp_case_1.model.dto.statistics;

import org.erp_case_1.model.dto.order.OrderSaleResponse;

import java.util.List;

public class ProductTotalSaleStatisticsResponse {
    private Long productNumber;
    private List<OrderSaleResponse> orderSaleResponses;

    // Constructors

    /**
     * NoArgsConstructor
     */
    public ProductTotalSaleStatisticsResponse(){}

    /**
     * AllArgsConstructor
     */
    public ProductTotalSaleStatisticsResponse(
            final Long productNumber,
            final List<OrderSaleResponse> orderSaleResponses
    ) {
        this.productNumber = productNumber;
        this.orderSaleResponses = orderSaleResponses;
    }

    /**
     * Constructor for Builder
     */
    public ProductTotalSaleStatisticsResponse(
            final ProductTotalSaleStatisticsResponseBuilder productTotalSaleStatisticsResponseBuilder
    ) {
        this.productNumber = productTotalSaleStatisticsResponseBuilder.productNumber;
        this.orderSaleResponses = productTotalSaleStatisticsResponseBuilder.orderSaleResponses;
    }

    // Getters & Setters


    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(
            final Long productNumber
    ) {
        this.productNumber = productNumber;
    }

    public List<OrderSaleResponse> getOrderSaleResponses() {
        return orderSaleResponses;
    }

    public void setOrderSaleResponses(
            final List<OrderSaleResponse> orderSaleResponses
    ) {
        this.orderSaleResponses = orderSaleResponses;
    }

    public static ProductTotalSaleStatisticsResponseBuilder builder()
    {
        return new ProductTotalSaleStatisticsResponseBuilder();
    }

    @Override
    public String toString() {
        return "ProductTotalSaleStatisticsResponse{" +
                "productNumber=" + productNumber +
                ", orderSaleResponses{\n" + orderSaleResponses +
                "\n}";
    }

    public static class ProductTotalSaleStatisticsResponseBuilder {
        private Long productNumber;
        private List<OrderSaleResponse> orderSaleResponses;

        public ProductTotalSaleStatisticsResponseBuilder productNumber(
                final Long productNumber
        ) {
            this.productNumber = productNumber;
            return this;
        }

        public ProductTotalSaleStatisticsResponseBuilder orderSaleResponses(
                final List<OrderSaleResponse> orderSaleResponses
        ) {
            this.orderSaleResponses = orderSaleResponses;
            return this;
        }

        public ProductTotalSaleStatisticsResponse build()
        {
            return new ProductTotalSaleStatisticsResponse(this);
        }
    }
}
