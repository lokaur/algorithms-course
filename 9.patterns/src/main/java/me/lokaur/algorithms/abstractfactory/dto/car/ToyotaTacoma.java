package me.lokaur.algorithms.abstractfactory.dto.car;

import me.lokaur.algorithms.abstractfactory.dto.Truck;

public class ToyotaTacoma implements Truck {

    @Override
    public void beep() {
        System.out.println("ToyotaTacoma");
    }
}
