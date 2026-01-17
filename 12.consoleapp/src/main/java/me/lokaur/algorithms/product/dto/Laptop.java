package me.lokaur.algorithms.product.dto;

import me.lokaur.algorithms.product.visitor.Visitor;

public class Laptop implements Product {

    private final double price;

    public Laptop(double price) {
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLaptop(this);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
