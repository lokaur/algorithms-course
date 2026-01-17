package me.lokaur.algorithms.product.dto;

import me.lokaur.algorithms.product.visitor.Visitor;

public class Book implements Product {

    private final double price;

    public Book(double price) {
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBook(this);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
