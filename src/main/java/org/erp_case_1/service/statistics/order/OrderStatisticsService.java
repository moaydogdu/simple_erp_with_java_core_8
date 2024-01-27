package org.erp_case_1.service.statistics.order;

import org.erp_case_1.model.Order;
import org.erp_case_1.model.OrderItem;
import org.erp_case_1.model.Product;
import org.erp_case_1.model.dto.statistics.ProductAverageStatisticsResponse;
import org.erp_case_1.service.order.OrderService;
import org.erp_case_1.service.order.impl.OrderServiceImpl;
import org.erp_case_1.util.PriceCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderStatisticsService {

    private final OrderService orderService;

    public OrderStatisticsService() {
        this.orderService = new OrderServiceImpl();
    }

    /**
     * Question 1 :  Üç siparişteki malların toplam tutarının çıktısını veren java kodu.
     * <br> <br>
     * This method calculates total product price with given orders via order numbers.
     */
    public void calculateTotalPriceOfSpecifiedOrders(
            final Long... orderNumbers
    ) {
        System.out.println("----------- QUESTION 1 : CALCULATING TOTAL PRICE WITH GIVEN ORDERS ----------");
        BigDecimal totalPriceOfSpecifiedOrders = BigDecimal.ZERO;

        final StringBuilder orderNumberStringBuiler = new StringBuilder(" ");

        for (Long orderNumber : orderNumbers) {

            orderNumberStringBuiler.append(orderNumber).append(" ");

            Order order = orderService.getOrderByNumber(orderNumber);

            totalPriceOfSpecifiedOrders = totalPriceOfSpecifiedOrders.add(order.getTotalPrice());

        }

        System.out.println("Total price of specified orders["+orderNumberStringBuiler.toString()+"] : " + totalPriceOfSpecifiedOrders);

        System.out.println("----------- QUESTION 1 : CALCULATING TOTAL PRICE WITH GIVEN ORDERS ----------");
    }

    /**
     * Question 2 : Üç siparişteki bütün malların ortalama fiyatını bulan java kodu.
     * <br> <br>
     *
     * This method calculates average unit prices of given orders via order numbers
     */
    public void calculateAverageUnitPriceOfSpecifiedOrders(
            final Long... orderNumbers
    ) {
        System.out.println("----------- QUESTION 2 : CALCULATING AVERAGE UNIT PRICE WITH GIVEN ORDERS ----------");

        BigDecimal averageOrderItemPriceOfOrders = BigDecimal.ZERO;

        final StringBuilder orderNumberStringBuiler = new StringBuilder(" ");

        for (Long orderNumber : orderNumbers) {

            orderNumberStringBuiler.append(orderNumber).append(" ");

            Order order = orderService.getOrderByNumber(orderNumber);

            averageOrderItemPriceOfOrders = order.getTotalPrice()
                    .divide(order.getTotalProductAmount(), 8, RoundingMode.HALF_UP);

        }

        System.out.println("Average unit price of specified orders [" + orderNumberStringBuiler.toString() + "] is: " + averageOrderItemPriceOfOrders);

        System.out.println("----------- QUESTION 2 : CALCULATING AVERAGE UNIT PRICE WITH GIVEN ORDERS ----------");
    }

    /**
     * Question 3 : Üç siparişteki bütün malların tek tek mal bazlı ortalama fiyatını bulan java kodu.
     * <br> <br>
     *
     * This method calculates every average unit prices of given orders via order numbers.
     */
    public List<ProductAverageStatisticsResponse> calculateAverageUnitPriceOfEveryProductForSpecifiedOrders(
            final Long... orderNumbers
    ) {
        System.out.println("----------- QUESTION 3 : CALCULATING EVERY AVERAGE UNIT PRICE WITH GIVEN ORDERS ----------");

        final Map<Long, ProductAverageStatisticsResponse> productAverageStatisticsResponseMap =
                new HashMap<>();

        final StringBuilder orderNumberStringBuiler = new StringBuilder(" ");

        for (Long orderNumber : orderNumbers) {

            orderNumberStringBuiler.append(orderNumber).append(" ");

            Order order = orderService.getOrderByNumber(orderNumber);

            for (OrderItem orderItem : order.getOrderItems()) {


                final Long productNumber = orderItem.getProduct().getNumber();

                if (!productAverageStatisticsResponseMap.containsKey(productNumber)) {

                    createProductAverageStatistics(
                            orderItem,
                            productAverageStatisticsResponseMap,
                            productNumber
                    );
                    continue;
                }

                updateProductAverageStatistics(
                        orderItem,
                        productAverageStatisticsResponseMap,
                        productNumber
                );
            }
        }

        System.out.println("\nAverage unit price of products in specified orders [" + orderNumberStringBuiler.toString() + "] are;\n");

        productAverageStatisticsResponseMap.values().forEach(System.out::println);

        System.out.println();

        System.out.println("----------- QUESTION 3 : CALCULATING EVERY AVERAGE UNIT PRICE WITH GIVEN ORDERS ----------");

        return new ArrayList<>(productAverageStatisticsResponseMap.values());
    }

    private void createProductAverageStatistics(
            final OrderItem orderItem,
            final Map<Long, ProductAverageStatisticsResponse> productAverageStatisticsResponseMap,
            final Long productNumber
    ) {
        productAverageStatisticsResponseMap.put(
                productNumber,
                ProductAverageStatisticsResponse.builder()
                        .productNumber(productNumber)
                        .totalCount(orderItem.getAmount())
                        .averagePrice(PriceCalculator.calculateAveragePrice(
                                orderItem.getTotalPrice(),
                                orderItem.getAmount()
                        ))
                        .build()
        );
    }

    private void updateProductAverageStatistics(
            final OrderItem orderItem,
            final Map<Long, ProductAverageStatisticsResponse> productAverageStatisticsResponseMap,
            final Long productNumber
    ) {
        final BigDecimal lastTotalCount = productAverageStatisticsResponseMap.get(productNumber).getTotalCount();
        final BigDecimal lastAveragePrice = productAverageStatisticsResponseMap.get(productNumber).getAveragePrice();
        final BigDecimal lastTotalPrice = lastAveragePrice.multiply(lastTotalCount);
        final BigDecimal totalCountOfThem = lastTotalCount.add(orderItem.getAmount());
        final BigDecimal totalPriceOfThem = lastTotalPrice.add(orderItem.getTotalPrice());


        productAverageStatisticsResponseMap.replace(
                productNumber,
                ProductAverageStatisticsResponse.builder()
                        .productNumber(productNumber)
                        .totalCount(totalCountOfThem)
                        .averagePrice(PriceCalculator.calculateAveragePrice(
                                totalPriceOfThem,
                                totalCountOfThem
                        ))
                        .build()
        );
    }


}
