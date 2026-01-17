package me.lokaur.algorithms.product.visitor;

import me.lokaur.algorithms.product.dto.Book;
import me.lokaur.algorithms.product.dto.Laptop;
import me.lokaur.algorithms.product.dto.VideoGame;

public class ReportVisitor implements Visitor {

    @Override
    public void visitBook(Book book) {
        System.out.printf("Книга. Цена: %f\n", book.getPrice());
    }

    @Override
    public void visitVideoGame(VideoGame game) {
        System.out.printf("Игра. Цена: %f\n", game.getPrice());
    }

    @Override
    public void visitLaptop(Laptop laptop) {
        System.out.printf("Ноутбук. Цена: %f\n", laptop.getPrice());
    }
}
