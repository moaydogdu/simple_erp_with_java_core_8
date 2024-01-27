package org.erp_case_1;

import org.erp_case_1.model.dto.statistics.ProductAverageStatisticsResponse;
import org.erp_case_1.service.statistics.order.OrderStatisticsService;
import org.erp_case_1.service.statistics.product.ProductStatisticsService;
import org.erp_case_1.util.ExampleDataGenerator;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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

      httpGetExample();
      httpPostExample();

    }

    public static void calculateAndPrintA(
            final Long... orderNumbers
    ) {
        final OrderStatisticsService orderStatisticsService =
                new OrderStatisticsService();

        orderStatisticsService
                .calculateTotalPriceOfSpecifiedOrders(orderNumbers);
    }

    public static void calculateAndPrintB(
            final Long... orderNumbers
    ) {
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
    }

    public static void calculateAndPrintD(
            final Long... productNumbers
    ) {
        final ProductStatisticsService productStatisticsService
                = new ProductStatisticsService();

        productStatisticsService
                .findProductTotalSaleAmountsBasedOnOrders(productNumbers);
    }

    public static void httpGetExample() {
        try {
            final URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                final StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                System.out.println("Response: " + response.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void httpPostExample() {
        try {
            final URL url = new URL("https://jsonplaceholder.typicode.com/users");

            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            final String jsonInputString =
                    "{\"name\": \"Muhammet Oğuzhan AYDOĞDU\"," +
                            " \"username\": \"moaydogdu\"," +
                            " \"email\": \"m.o.aydogdu@outlook.com\"}";

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                wr.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    final StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    System.out.println("Response: " + response.toString());
                }
            } else {
                System.out.println("POST request failed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
