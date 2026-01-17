package me.lokaur.algorithms.abstractfactory.dto.car;

import me.lokaur.algorithms.abstractfactory.dto.PassengerCar;

public class FordFocus implements PassengerCar {

    @Override
    public void beep() {
        System.out.println("FordFocus");
    }
}
