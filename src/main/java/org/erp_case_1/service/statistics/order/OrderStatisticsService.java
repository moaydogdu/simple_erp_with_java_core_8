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

    public void calculateTotalPriceOfSpecifiedOrders(
            final Long... orderNumbers
    ) {
        BigDecimal totalPriceOfSpecifiedOrders = BigDecimal.ZERO;

        for (Long orderNumber : orderNumbers) {
            Order order = orderService.getOrderByNumber(orderNumber);
            totalPriceOfSpecifiedOrders = totalPriceOfSpecifiedOrders.add(order.getTotalPrice());
        }

        System.out.println("Total price of specified orders : " + totalPriceOfSpecifiedOrders);
    }

    public void calculateAverageUnitPriceOfSpecifiedOrders(
            final Long... orderNumbers
    ) {

        BigDecimal averageOrderItemPriceOfOrders = BigDecimal.ZERO;

        for (Long orderNumber : orderNumbers) {
            Order order = orderService.getOrderByNumber(orderNumber);

            averageOrderItemPriceOfOrders = order.getTotalPrice()
                    .divide(order.getTotalProductAmount(), 8, RoundingMode.HALF_UP);
        }

        System.out.println("Average unit price of specified orders is: " + averageOrderItemPriceOfOrders);
    }


    public List<ProductAverageStatisticsResponse> calculateAverageUnitPriceOfEveryProductForSpecifiedOrders(
            final Long... orderNumbers
    ) {
        Map<Long, ProductAverageStatisticsResponse> productAverageStatisticsResponseMap =
                new HashMap<>();

        for (Long orderNumber : orderNumbers) {
            Order order = orderService.getOrderByNumber(orderNumber);
            for (OrderItem orderItem : order.getOrderItems()) {
                final Product product = orderItem.getProduct();
                final Long productNumber = product.getNumber();

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
