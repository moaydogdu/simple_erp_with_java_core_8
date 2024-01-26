package org.erp_case_1.model.dto.product;

import java.math.BigDecimal;

public class ProductCreateRequest {
    private Long number;
    private String name;
    private BigDecimal unitPrice;

    // Constructors

    /**
     * NoArgsConstructor
     */
    public ProductCreateRequest() {
    }

    /**
     * AllArgsConstructor
     */
    public ProductCreateRequest(
            final Long number,
            final String name,
            final BigDecimal unitPrice
    ) {
        this.number = number;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    /**
     * Private constructor with ProductBuilder
     */
    private ProductCreateRequest(
            final ProductCreateRequestBuilder productCreateRequestBuilder
    ) {
        this.number = productCreateRequestBuilder.number;
        this.name = productCreateRequestBuilder.name;
        this.unitPrice = productCreateRequestBuilder.unitPrice;
    }

    // Getters & Setters


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

    /**
     * Getter method of ProductCreateRequestBuilder
     */
    public static ProductCreateRequestBuilder builder() {
        return new ProductCreateRequestBuilder();
    }


    /**
     * Builder pattern of ProductCreateRequest class.
     */
    public static class ProductCreateRequestBuilder {
        private Long number;
        private String name;
        private BigDecimal unitPrice;


        public ProductCreateRequestBuilder number(
                final Long number
        ) {
            this.number = number;
            return this;
        }

        public ProductCreateRequestBuilder name(
                final String name
        ) {
            this.name = name;
            return this;
        }

        public ProductCreateRequestBuilder unitPrice(
                final BigDecimal unitPrice
        ) {
            this.unitPrice = unitPrice;
            return this;
        }

        public ProductCreateRequest build() {
            return new ProductCreateRequest(this);
        }
    }

}
