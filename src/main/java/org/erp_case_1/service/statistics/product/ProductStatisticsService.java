package org.erp_case_1.service.statistics.product;

import org.erp_case_1.model.OrderItem;
import org.erp_case_1.model.dto.order.OrderSaleResponse;
import org.erp_case_1.model.dto.statistics.ProductTotalSaleStatisticsResponse;
import org.erp_case_1.repository.OrderItemRepository;
import org.erp_case_1.service.product.ProductService;
import org.erp_case_1.service.product.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductStatisticsService {

    private final ProductService productService;
    private final OrderItemRepository orderItemRepository;

    public ProductStatisticsService() {
        this.productService = new ProductServiceImpl();
        this.orderItemRepository = OrderItemRepository.getInstance();
    }

    public void findProductTotalSaleAmountsBasedOnOrders(
            final Long... productNumbers
    ) {
        final List<ProductTotalSaleStatisticsResponse> listOfProductTotalSaleStatistics
                = new ArrayList<>();

        for (Long productNumber : productNumbers)
        {
            final List<OrderItem> orderItemsByProduct = orderItemRepository
                    .findOrderItemsByProductNumber(productNumber);

            if (orderItemsByProduct.isEmpty())
            {
                throw new RuntimeException("There is no sale with given Product");
            }

            final ProductTotalSaleStatisticsResponse productTotalSaleStatisticsResponse =
                    ProductTotalSaleStatisticsResponse.builder()
                            .productNumber(productNumber)
                            .build();

            Map<Long, OrderSaleResponse> orderSaleResponseHashMap
                    = new HashMap<>();

            for (OrderItem orderItem : orderItemsByProduct)
            {
                final Long orderNumber = orderItem.getOrder().getNumber();

                if (Boolean.FALSE.equals(
                        orderSaleResponseHashMap.containsKey(orderNumber)
                ))
                {
                    orderSaleResponseHashMap.put(
                            orderItem.getOrder().getNumber(),
                            OrderSaleResponse.builder()
                                    .orderNumber(orderNumber)
                                    .totalSaleCount(orderItem.getAmount())
                                    .build()
                    );
                    continue;
                }

                OrderSaleResponse response = orderSaleResponseHashMap.get(
                        orderItem.getOrder().getNumber());

               response.setTotalSaleCount(response.getTotalSaleCount().add(orderItem.getAmount()));
            }

            productTotalSaleStatisticsResponse.setOrderSaleResponses(
                    new ArrayList<>(orderSaleResponseHashMap.values())
            );

            listOfProductTotalSaleStatistics.add(productTotalSaleStatisticsResponse);
        }

        listOfProductTotalSaleStatistics.forEach(System.out::println);
    }

}
