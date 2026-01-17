package me.lokaur.algorithms.abstractfactory.factory;

import me.lokaur.algorithms.abstractfactory.dto.PassengerCar;
import me.lokaur.algorithms.abstractfactory.dto.Truck;
import me.lokaur.algorithms.abstractfactory.dto.car.FordFocus;
import me.lokaur.algorithms.abstractfactory.dto.car.FordF350;

public class FordFactory implements CarsFactory {

    @Override
    public PassengerCar createCar() {
        return new FordFocus();
    }

    @Override
    public Truck createTruck() {
        return new FordF350();
    }
}
