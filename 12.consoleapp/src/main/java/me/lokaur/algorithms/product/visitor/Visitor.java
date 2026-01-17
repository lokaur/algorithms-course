package me.lokaur.algorithms.product.visitor;

import me.lokaur.algorithms.product.dto.Book;
import me.lokaur.algorithms.product.dto.Laptop;
import me.lokaur.algorithms.product.dto.VideoGame;

public interface Visitor {

    void visitBook(Book book);
    void visitVideoGame(VideoGame game);
    void visitLaptop(Laptop laptop);
}
