package me.lokaur.algorithms.fabricmethod;

public class Main {

    static void main(String[] args) {
        CoffeeShop coffeeShop = new RussianCoffeeShop();
        coffeeShop.createCoffee();

        coffeeShop = new AmericanCoffeeShop();
        coffeeShop.createCoffee();

        coffeeShop = new ItalianCoffeeShop();
        coffeeShop.createCoffee();
    }
}
