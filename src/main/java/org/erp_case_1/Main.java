package org.erp_case_1;

import org.erp_case_1.model.dto.statistics.ProductAverageStatisticsResponse;
import org.erp_case_1.service.statistics.order.OrderStatisticsService;
import org.erp_case_1.service.statistics.product.ProductStatisticsService;
import org.erp_case_1.util.ExampleDataGenerator;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ExampleDataGenerator.generatedAllDataSet();
        System.out.println();

        calculateAndPrintA(
                1000L,
                1001L,
                1002L
        );
        System.out.println();

        calculateAndPrintB(
                1000L,
                1001L,
                1002L
        );
        System.out.println();


        calculateAndPrintC(
                1000L,
                1001L,
                1002L
        );
        System.out.println();

        calculateAndPrintD(
                2000L,
                2001L,
                2002L,
                2003L,
                2004L,
                2005L,
                2006L
        );

    }

    public static void calculateAndPrintA(
            final Long... orderNumbers
    ){
        final OrderStatisticsService orderStatisticsService =
                new OrderStatisticsService();

        orderStatisticsService
                .calculateTotalPriceOfSpecifiedOrders(orderNumbers);
    }

    public static void calculateAndPrintB(
            final Long... orderNumbers
    ){
        final OrderStatisticsService orderStatisticsService =
                new OrderStatisticsService();

        orderStatisticsService
                .calculateAverageUnitPriceOfSpecifiedOrders(orderNumbers);
    }

    public static void calculateAndPrintC(
            final Long... orderNumbers //Variable arguments
    ) {
        final OrderStatisticsService orderStatisticsService =
                new OrderStatisticsService();

        final List<ProductAverageStatisticsResponse> response = orderStatisticsService
                .calculateAverageUnitPriceOfEveryProductForSpecifiedOrders(orderNumbers);

        response.forEach(System.out::println);
    }

    public static void calculateAndPrintD(
            final Long... productNumbers
    ) {
        final ProductStatisticsService productStatisticsService
                = new ProductStatisticsService();

        productStatisticsService.findProductTotalSaleAmountsBasedOnOrders(productNumbers);
    }


}