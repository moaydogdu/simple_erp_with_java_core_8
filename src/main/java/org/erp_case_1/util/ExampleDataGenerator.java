package org.erp_case_1.util;

import org.erp_case_1.model.Order;
import org.erp_case_1.model.Product;
import org.erp_case_1.model.dto.order_item.OrderItemCreateRequest;
import org.erp_case_1.model.dto.product.ProductCreateRequest;
import org.erp_case_1.service.order.OrderCreateService;
import org.erp_case_1.service.order.impl.OrderCreateServiceImpl;
import org.erp_case_1.service.product.ProductCreateService;
import org.erp_case_1.service.product.impl.ProductCreateServiceImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Util class for generating example data from Case.
 */
public class ExampleDataGenerator {

    public static void generatedAllDataSet(){
        System.out.println("---------- EXAMPLE DATA GENERATION IS STARTED ----------");
        createProductDataSet();
        createOrderDataSet1();
        createOrderDataSet2();
        createOrderDataSet3();
        System.out.println("---------- EXAMPLE DATA GENERATION IS DONE ----------");
    }
    public static List<Product> createProductDataSet() {
        System.out.println("Initiating the Product creation process.");

        final ProductCreateService productCreateService = new ProductCreateServiceImpl();

        final List<ProductCreateRequest> productCreateRequests = Arrays.asList(
                ProductCreateRequest.builder().number(2000L).name("Example Product 1").build(),
                ProductCreateRequest.builder().number(2001L).name("Example Product 2").build(),
                ProductCreateRequest.builder().number(2002L).name("Example Product 3").build(),
                ProductCreateRequest.builder().number(2003L).name("Example Product 4").build(),
                ProductCreateRequest.builder().number(2004L).name("Example Product 5").build(),
                ProductCreateRequest.builder().number(2005L).name("Example Product 6").build(),
                ProductCreateRequest.builder().number(2006L).name("Example Product 7").build()
        );

        final List<Product> createdProducts = productCreateRequests.stream()
                .map(productCreateService::createProduct)
                .collect(Collectors.toList());

        System.out.println("Product creation process is successful!");

        return createdProducts;
    }

    public static Order createOrderDataSet1() {
        System.out.println("Initiating the Order creation process.");

        final OrderCreateService orderCreateService = new OrderCreateServiceImpl();

        List<OrderItemCreateRequest> orderItemCreateRequests;
        {
            orderItemCreateRequests = Arrays.asList(
                    OrderItemCreateRequest.builder()
                            .productNumber(2000L)
                            .amount(BigDecimal.valueOf(12))
                            .unitPrice(BigDecimal.valueOf(100.51))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2001L)
                            .amount(BigDecimal.valueOf(31))
                            .unitPrice(BigDecimal.valueOf(200))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2002L)
                            .amount(BigDecimal.valueOf(22))
                            .unitPrice(BigDecimal.valueOf(150.86))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2003L)
                            .amount(BigDecimal.valueOf(41))
                            .unitPrice(BigDecimal.valueOf(250))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2004L)
                            .amount(BigDecimal.valueOf(55))
                            .unitPrice(BigDecimal.valueOf(244))
                            .build()
            );
        }

        System.out.println("Order creation process is successful!");

        return orderCreateService
                .createOrder(1000L,orderItemCreateRequests);
    }

    public static Order createOrderDataSet2() {
        System.out.println("Initiating the Order creation process.");

        final OrderCreateService orderCreateService = new OrderCreateServiceImpl();

        List<OrderItemCreateRequest> orderItemCreateRequests;
        {
            orderItemCreateRequests = Arrays.asList(
                    OrderItemCreateRequest.builder()
                            .productNumber(2001L)
                            .amount(BigDecimal.valueOf(88))
                            .unitPrice(BigDecimal.valueOf(44.531))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2002L)
                            .amount(BigDecimal.valueOf(121))
                            .unitPrice(BigDecimal.valueOf(88.11))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2004L)
                            .amount(BigDecimal.valueOf(74))
                            .unitPrice(BigDecimal.valueOf(211))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2002L)
                            .amount(BigDecimal.valueOf(14))
                            .unitPrice(BigDecimal.valueOf(88.11))
                            .build()
            );
        }

        System.out.println("Order creation process is successful!");

        return orderCreateService
                .createOrder(1001L,orderItemCreateRequests);
    }

    public static Order createOrderDataSet3() {
        System.out.println("Initiating the Order creation process.");

        final OrderCreateService orderCreateService = new OrderCreateServiceImpl();

        List<OrderItemCreateRequest> orderItemCreateRequests;
        {
            orderItemCreateRequests = Arrays.asList(
                    OrderItemCreateRequest.builder()
                            .productNumber(2003L)
                            .amount(BigDecimal.valueOf(2))
                            .unitPrice(BigDecimal.valueOf(12.1))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2004L)
                            .amount(BigDecimal.valueOf(3))
                            .unitPrice(BigDecimal.valueOf(22.3))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2003L)
                            .amount(BigDecimal.valueOf(8))
                            .unitPrice(BigDecimal.valueOf(12.1))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2002L)
                            .amount(BigDecimal.valueOf(16))
                            .unitPrice(BigDecimal.valueOf(94))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2005L)
                            .amount(BigDecimal.valueOf(9))
                            .unitPrice(BigDecimal.valueOf(44.1))
                            .build(),
                    OrderItemCreateRequest.builder()
                            .productNumber(2006L)
                            .amount(BigDecimal.valueOf(19))
                            .unitPrice(BigDecimal.valueOf(90))
                            .build()
            );
        }

        System.out.println("Order creation process is successful!");

        return orderCreateService
                .createOrder(1002L,orderItemCreateRequests);
    }
}
