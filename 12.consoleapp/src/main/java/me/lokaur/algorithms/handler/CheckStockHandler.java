package me.lokaur.algorithms.handler;

import me.lokaur.algorithms.dto.Order;

public class CheckStockHandler extends Handler {

    @Override
    protected boolean check(Order order) {
        System.out.println("Проверка наличия товара");
        return order.isInStock();
    }
}
