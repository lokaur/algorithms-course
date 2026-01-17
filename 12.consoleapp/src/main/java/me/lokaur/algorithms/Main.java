package me.lokaur.algorithms;

import me.lokaur.algorithms.dto.Order;
import me.lokaur.algorithms.handler.CheckBalanceHandler;
import me.lokaur.algorithms.handler.CheckFraudHandler;
import me.lokaur.algorithms.handler.CheckStockHandler;
import me.lokaur.algorithms.handler.Handler;
import me.lokaur.algorithms.processor.DigitalOrderProcessor;
import me.lokaur.algorithms.processor.OrderProcessor;
import me.lokaur.algorithms.product.dto.Book;
import me.lokaur.algorithms.product.dto.Laptop;
import me.lokaur.algorithms.product.dto.Product;
import me.lokaur.algorithms.product.dto.VideoGame;
import me.lokaur.algorithms.product.visitor.PriceVisitor;
import me.lokaur.algorithms.product.visitor.ReportVisitor;

import java.util.List;

public class Main {

    private static List<Order> orders = List.of(
            new Order(
                    List.of(
                            new Book(100),
                            new VideoGame(7000),
                            new Laptop(50000)
                    ),
                    "testemail@test.ru",
                    "ул. Пушкина, д. Колотушкина",
                    true,
                    true,
                    false
            ),
            new Order(
                    List.of(
                            new Book(100),
                            new VideoGame(7000),
                            new Laptop(50000)
                    ),
                    "testemail1@test.ru",
                    "ул. Ленина, д. 2",
                    false,
                    true,
                    false
            ),
            new Order(
                    List.of(
                            new Book(100),
                            new VideoGame(7000),
                            new Laptop(50000)
                    ),
                    "testemail2@test.ru",
                    "ул. Свободы, д. 2",
                    true,
                    false,
                    false
            ),
            new Order(
                    List.of(
                            new Book(100),
                            new VideoGame(7000),
                            new Laptop(50000)
                    ),
                    "testemail2@test.ru",
                    "ул. Октября, д. 2",
                    true,
                    true,
                    true
            )
    );

    static void main(String[] args) {
        Handler chain = new CheckStockHandler();
        chain.setNext(new CheckBalanceHandler())
                .setNext(new CheckFraudHandler());

        for (Order order : orders) {
            try {
                System.out.println("===== Проверка заказа =====");
                chain.handle(order);

                System.out.println("===== Отчет по товарам =====");
                ReportVisitor reportVisitor = new ReportVisitor();
                PriceVisitor priceVisitor = new PriceVisitor();

                for (Product product : order.getProducts()) {
                    product.accept(reportVisitor);
                    product.accept(priceVisitor);
                }

                System.out.printf("Общая стоимость: %f\n", priceVisitor.getTotalPrice());

                System.out.println("===== Оформление заказа =====");
                OrderProcessor processor = new DigitalOrderProcessor();
                processor.processOrder(order);
                System.out.println();
            } catch (RuntimeException e) {
                System.out.println("При обработке заказа произошла ошибка\n");
            }
        }
    }
}
