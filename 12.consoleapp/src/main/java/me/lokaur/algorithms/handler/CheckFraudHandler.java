package me.lokaur.algorithms.handler;

import me.lokaur.algorithms.dto.Order;

public class CheckFraudHandler extends Handler {

    @Override
    protected boolean check(Order order) {
        System.out.println("Проверка подозрительности");
        return !order.isFraud();
    }
}
