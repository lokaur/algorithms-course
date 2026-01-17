package me.lokaur.algorithms.handler;

import me.lokaur.algorithms.dto.Order;

public class CheckBalanceHandler extends Handler {

    @Override
    protected boolean check(Order order) {
        System.out.println("Проверка наличия средств");
        return order.isEnoughMoney();
    }
}
