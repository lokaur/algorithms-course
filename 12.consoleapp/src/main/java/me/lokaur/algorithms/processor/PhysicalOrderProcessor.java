package me.lokaur.algorithms.processor;

import me.lokaur.algorithms.dto.Order;

public class PhysicalOrderProcessor extends OrderProcessor {

    @Override
    protected void validate(Order order) {
        if (order.getDeliveryAddress() == null || order.getDeliveryAddress().isBlank()) {
            throw new RuntimeException("Не указан адрес доставки");
        }
    }

    @Override
    protected void calculatePrice(Order order) {
        System.out.println("Цена товара + цена доставки");
    }

    @Override
    protected void pay(Order order) {
        System.out.println("Оплата при получении");
    }
}
