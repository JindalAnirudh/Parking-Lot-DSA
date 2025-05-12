package com.parkinglot.service;

import com.parkinglot.model.Car;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotGridService {
    private Car[][] parkingGrid;
    private int rows;
    private int cols;
    private Map<String, Car> carMap;

    public ParkingLotGridService(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.parkingGrid = new Car[rows][cols];
        this.carMap = new HashMap<>();
    }

    public void addCar(Car car) {
        if (carMap.containsKey(car.getLicensePlate())) {
            System.out.println("Car with this license plate is already parked.");
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (parkingGrid[i][j] == null) {
                    parkingGrid[i][j] = car;
                    car.setRow(i);
                    car.setCol(j);
                    carMap.put(car.getLicensePlate(), car);
                    System.out.println("Car parked at spot (" + i + ", " + j + ").");
                    return;
                }
            }
        }
        System.out.println("Parking Lot Full.");
    }

    public void removeCar(String licensePlate) {
        Car car = carMap.get(licensePlate);
        if (car == null) {
            System.out.println("Car not found in the parking lot.");
            return;
        }
    
        int row = car.getRow();
        int col = car.getCol();
        parkingGrid[row][col] = null;
        carMap.remove(licensePlate);
    
        LocalDateTime entryTime = car.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        Duration duration = Duration.between(entryTime, exitTime);
        long hours = Math.max(duration.toHours(), 1); // Minimum billing 1 hour
        long bill = hours * 1; // ₹20 per hour
    
        System.out.println("-------------------------------------------------");
        System.out.println("Car with License Plate: " + licensePlate + " removed.");
        System.out.println("Slot Freed: (" + row + ", " + col + ")");
        System.out.println("Entry Time : " + entryTime);
        System.out.println("Exit Time  : " + exitTime);
        System.out.println("Total Duration: " + hours + " hour(s)");
        System.out.println("Amount to be Paid: $" + bill);
        System.out.println("-------------------------------------------------");
    }
    

    public void displayGrid() {
        System.out.println("Current Parking Lot Layout:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (parkingGrid[i][j] == null) {
                    System.out.print("[  ] ");
                } else {
                    System.out.print("[X] ");
                }
            }
            System.out.println();
        }
    }
}