package me.lokaur.algorithms.processor;

import me.lokaur.algorithms.dto.Order;

public abstract class OrderProcessor {

    public final void processOrder(Order order) {
        validate(order);
        calculatePrice(order);
        pay(order);
    }

    protected abstract void validate(Order order);

    protected abstract void calculatePrice(Order order);

    protected abstract void pay(Order order);

    protected void notification(Order order) {
        System.out.println("Заказ создан");
    }
}
