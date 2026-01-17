package me.lokaur.algorithms.dto;

import me.lokaur.algorithms.product.dto.Product;

import java.util.List;

public final class Order {

    private final List<Product> products;
    private final String email;
    private final String deliveryAddress;
    private final boolean isInStock;
    private final boolean isEnoughMoney;
    private final boolean isFraud;

    public Order(
            List<Product> products,
            String email,
            String deliveryAddress,
            boolean isInStock,
            boolean isEnoughMoney,
            boolean isFraud
    ) {
        this.products = products;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
        this.isInStock = isInStock;
        this.isEnoughMoney = isEnoughMoney;
        this.isFraud = isFraud;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getEmail() {
        return email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public boolean isEnoughMoney() {
        return isEnoughMoney;
    }

    public boolean isFraud() {
        return isFraud;
    }
}
