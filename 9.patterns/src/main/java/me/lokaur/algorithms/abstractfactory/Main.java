package me.lokaur.algorithms.abstractfactory;

import me.lokaur.algorithms.abstractfactory.dto.PassengerCar;
import me.lokaur.algorithms.abstractfactory.dto.Truck;
import me.lokaur.algorithms.abstractfactory.factory.CarsFactory;
import me.lokaur.algorithms.abstractfactory.factory.FordFactory;
import me.lokaur.algorithms.abstractfactory.factory.ToyotaFactory;

public class Main {

    static void main(String[] args) {
        CarsFactory factory = new FordFactory();
        Truck truck = factory.createTruck();
        PassengerCar car = factory.createCar();
        truck.beep();
        car.beep();

        factory = new ToyotaFactory();
        truck = factory.createTruck();
        car = factory.createCar();
        truck.beep();
        car.beep();
    }
}
