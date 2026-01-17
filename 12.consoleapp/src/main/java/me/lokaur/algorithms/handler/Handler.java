package me.lokaur.algorithms.handler;

import me.lokaur.algorithms.dto.Order;

public abstract class Handler {

    protected Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public void handle(Order order) {
        if (check(order)) {
            if (next != null) {
                next.handle(order);
            }
        } else {
            throw new RuntimeException("Проверка не пройдена");
        }
    }

    protected abstract boolean check(Order order);
}
