package me.lokaur.algorithms.abstractfactory.factory;

import me.lokaur.algorithms.abstractfactory.dto.PassengerCar;
import me.lokaur.algorithms.abstractfactory.dto.Truck;
import me.lokaur.algorithms.abstractfactory.dto.car.ToyotaCamry;
import me.lokaur.algorithms.abstractfactory.dto.car.ToyotaTacoma;

public class ToyotaFactory implements CarsFactory {

    @Override
    public PassengerCar createCar() {
        return new ToyotaCamry();
    }

    @Override
    public Truck createTruck() {
        return new ToyotaTacoma();
    }
}
