package me.lokaur.algorithms.abstractfactory.factory;

import me.lokaur.algorithms.abstractfactory.dto.PassengerCar;
import me.lokaur.algorithms.abstractfactory.dto.Truck;

public interface CarsFactory {

    PassengerCar createCar();

    Truck createTruck();
}
