package com.parkinglot.interfaces;

import com.parkinglot.model.Car;

public interface ParkingLotInterface {
    boolean parkCar(Car car);
    boolean removeCar(String licensePlate);
    void displayParkingStatus();
    Car getCarInfo(String licensePlate);
}
