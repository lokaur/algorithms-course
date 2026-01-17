package me.lokaur.algorithms.product.dto;

import me.lokaur.algorithms.product.visitor.Visitor;

public interface Product {
    void accept(Visitor visitor);
    double getPrice();
}
