package com.parkinglot.service;

import com.parkinglot.model.Car;
import com.parkinglot.interfaces.ParkingLotInterface;

import java.util.*;

public class ParkingLotService implements ParkingLotInterface {
    private int capacity;
    private Stack<Car> parkingStack;
    private Map<String, Car> carMap;

    public ParkingLotService(int capacity) {
        this.capacity = capacity;
        this.parkingStack = new Stack<>();
        this.carMap = new HashMap<>();
    }

    public boolean parkCar(Car car) {
        if (parkingStack.size() >= capacity) return false;
        parkingStack.push(car);
        carMap.put(car.getLicensePlate(), car);
        return true;
    }

    public boolean removeCar(String licensePlate) {
        Stack<Car> tempStack = new Stack<>();
        boolean found = false;

        while (!parkingStack.isEmpty()) {
            Car car = parkingStack.pop();
            if (car.getLicensePlate().equals(licensePlate)) {
                carMap.remove(licensePlate);
                found = true;
                break;
            }
            tempStack.push(car);
        }

        while (!tempStack.isEmpty()) {
            parkingStack.push(tempStack.pop());
        }

        return found;
    }

    public void displayParkingStatus() {
        System.out.println("\n--- Current Parking Lot Status ---");
        for (Car car : parkingStack) {
            System.out.println(car.getLicensePlate() + " | " + car.getCarModel() + " | " + car.getOwnerName());
        }
    }

    public Car getCarInfo(String licensePlate) {
        return carMap.get(licensePlate);
    }
}
