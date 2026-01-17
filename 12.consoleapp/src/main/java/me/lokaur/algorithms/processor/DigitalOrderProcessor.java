package me.lokaur.algorithms.processor;

import me.lokaur.algorithms.dto.Order;

public class DigitalOrderProcessor extends OrderProcessor {

    @Override
    protected void validate(Order order) {
        if (order.getEmail() == null || order.getEmail().isBlank()) {
            throw new RuntimeException("Не указан email");
        }
    }

    @Override
    protected void calculatePrice(Order order) {
        System.out.println("Цена: товар");
    }

    @Override
    protected void pay(Order order) {
        System.out.println("Онлайн оплата");
    }
}
