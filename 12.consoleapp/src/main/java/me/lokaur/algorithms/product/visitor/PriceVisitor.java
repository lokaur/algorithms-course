package me.lokaur.algorithms.product.visitor;

import me.lokaur.algorithms.product.dto.Book;
import me.lokaur.algorithms.product.dto.Laptop;
import me.lokaur.algorithms.product.dto.VideoGame;

public class PriceVisitor implements Visitor {

    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void visitBook(Book book) {
        totalPrice += book.getPrice();
    }

    @Override
    public void visitVideoGame(VideoGame game) {
        totalPrice += game.getPrice();
    }

    @Override
    public void visitLaptop(Laptop laptop) {
        totalPrice += laptop.getPrice();
    }
}
