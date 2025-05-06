package com.parkinglot.service;

import com.parkinglot.model.Car;
import com.parkinglot.interfaces.BillingInterface;

import java.time.Duration;
import java.time.LocalDateTime;

public class BillingService implements BillingInterface {
    private static final double RATE_PER_HOUR = 10.0;

    public double calculateBill(Car car) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(car.getEntryTime(), now);
        long hours = Math.max(1, duration.toHours());
        return hours * RATE_PER_HOUR;
    }
}
