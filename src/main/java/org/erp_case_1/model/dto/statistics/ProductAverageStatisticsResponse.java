package org.erp_case_1.model.dto.statistics;

import java.math.BigDecimal;

public class ProductAverageStatisticsResponse {
    private Long productNumber;
    private BigDecimal totalCount;
    private BigDecimal averagePrice;

    // Constructors

    /**
     * NoArgsConstructor
     */
    public ProductAverageStatisticsResponse() {}

    /**
     * AllArgsConstructor
     */
    public ProductAverageStatisticsResponse(
            final Long productNumber,
            final BigDecimal averagePrice,
            final BigDecimal totalCount
    ) {
        this.productNumber = productNumber;
        this.averagePrice = averagePrice;
        this.totalCount = totalCount;
    }

    /**
     * Constructor for Builder.
     */
    public ProductAverageStatisticsResponse(
            final ProductAverageStatisticsResponseBuilder productAverageStatisticsResponseBuilder
    ) {
        this.productNumber = productAverageStatisticsResponseBuilder.productNumber;
        this.averagePrice = productAverageStatisticsResponseBuilder.averagePrice;
        this.totalCount = productAverageStatisticsResponseBuilder.totalCount;
    }

    // Getters & Setters

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(
            final BigDecimal totalCount
    ) {
        this.totalCount = totalCount;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    /**
     * Builder of {@link ProductAverageStatisticsResponse}
     */
    public static ProductAverageStatisticsResponseBuilder builder()
    {
        return new ProductAverageStatisticsResponseBuilder();
    }

    @Override
    public String toString() {
        return "ProductAverageStatisticsResponse{" +
                "productNumber=" + productNumber +
                ", totalCount= " + totalCount +
                ", averagePrice=" + averagePrice +
                '}';
    }

    public static class ProductAverageStatisticsResponseBuilder {
        private Long productNumber;
        private BigDecimal totalCount;
        private BigDecimal averagePrice;


        public ProductAverageStatisticsResponseBuilder productNumber(
                final Long productNumber
        ) {
            this.productNumber = productNumber;
            return this;
        }

        public ProductAverageStatisticsResponseBuilder totalCount(
                final BigDecimal totalCount
        ) {
            this.totalCount = totalCount;
            return this;
        }

        public ProductAverageStatisticsResponseBuilder averagePrice(
                final BigDecimal averagePrice
        ) {
            this.averagePrice = averagePrice;
            return this;
        }

        public ProductAverageStatisticsResponse build()
        {
            return new ProductAverageStatisticsResponse(this);
        }

    }

}
