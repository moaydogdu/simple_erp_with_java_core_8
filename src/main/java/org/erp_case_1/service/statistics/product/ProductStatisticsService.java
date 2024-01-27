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

    /**
     * Question 4 : Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğunun çıktısını veren
     * java kodu.
     * <br> <br>
     *
     * This method calculates number of product sale amount with orders individually with given products
     * via product numbers.
     */
    public void findProductTotalSaleAmountsBasedOnOrders(
            final Long... productNumbers
    ) {
        System.out.println("----------- QUESTION 4 : CALCULATING TOTAL SALE AMOUNT OF PRODUCTS IN ORDERS WITH GIVEN PRODUCT NUMBERS ----------\n");

        final List<ProductTotalSaleStatisticsResponse> listOfProductTotalSaleStatistics
                = new ArrayList<>();

        final StringBuilder productNumberStringBuilder = new StringBuilder(" ");

        for (Long productNumber : productNumbers)
        {
            productNumberStringBuilder.append(productNumber).append(" ");

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

            final Map<Long, OrderSaleResponse> orderSaleResponseHashMap
                    = new HashMap<>();

            for (OrderItem orderItem : orderItemsByProduct)
            {
                final Long orderNumber = orderItem.getOrder().getNumber();

                if (Boolean.FALSE.equals(
                        orderSaleResponseHashMap.containsKey(orderNumber)
                ))
                {
                    orderSaleResponseHashMap.put(
                            orderNumber,
                            OrderSaleResponse.builder()
                                    .orderNumber(orderNumber)
                                    .totalSaleCount(orderItem.getAmount())
                                    .build()
                    );
                    continue;
                }

                final OrderSaleResponse oldOrderSaleResponse = orderSaleResponseHashMap.get(
                        orderItem.getOrder().getNumber());

               oldOrderSaleResponse.setTotalSaleCount(oldOrderSaleResponse.getTotalSaleCount().add(orderItem.getAmount()));
            }

            productTotalSaleStatisticsResponse.setOrderSaleResponses(
                    new ArrayList<>(orderSaleResponseHashMap.values())
            );

            listOfProductTotalSaleStatistics.add(productTotalSaleStatisticsResponse);
        }

        System.out.println("Specified Products are ["+productNumberStringBuilder.toString()+"] and result is below; \n");

        listOfProductTotalSaleStatistics.forEach(System.out::println);

        System.out.println("----------- QUESTION 4 : CALCULATING TOTAL SALE AMOUNT OF PRODUCTS IN ORDERS WITH GIVEN PRODUCT NUMBERS ----------");
    }

}
