package com.parkinglot.model;

import java.time.LocalDateTime;

public class Car {
    private String licensePlate;
    private String carModel;
    private String ownerName;
    private LocalDateTime entryTime;

    public Car(String licensePlate, String carModel, String ownerName) {
        this.licensePlate = licensePlate;
        this.carModel = carModel;
        this.ownerName = ownerName;
        this.entryTime = LocalDateTime.now();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
