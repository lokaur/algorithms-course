package me.lokaur.algorithms.product.dto;

import me.lokaur.algorithms.product.visitor.Visitor;

public class VideoGame implements Product {

    private final double price;

    public VideoGame(double price) {
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitVideoGame(this);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
