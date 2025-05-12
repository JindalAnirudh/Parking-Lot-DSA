package com.parkinglot.model;

import java.time.LocalDateTime;

public class Car {
    private String licensePlate;
    private String carModel;
    private LocalDateTime entryTime;
    private int row;
    private int col;

    public Car(String licensePlate, String carModel) {
        this.licensePlate = licensePlate;
        // this.carModel = carModel;
        this.entryTime = LocalDateTime.now();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCarModel() {
        return carModel;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}