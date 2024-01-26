package org.erp_case_1.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Util Class for calculating prices.
 */
public class PriceCalculator {

    public static BigDecimal calculateTotalPrice(
            final BigDecimal amount,
            final BigDecimal unitPrice
    ) {
        return amount.multiply(unitPrice);
    }

    public static BigDecimal calculateAveragePrice(
            final BigDecimal totalPrice,
            final BigDecimal amount
    ) {
        return totalPrice.divide(amount, 8, RoundingMode.HALF_UP);
    }
}
