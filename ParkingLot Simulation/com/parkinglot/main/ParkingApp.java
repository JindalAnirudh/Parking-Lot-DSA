package com.parkinglot.main;

import com.parkinglot.model.Car;
import com.parkinglot.service.ParkingLotService;
import com.parkinglot.service.BillingService;

import java.util.Scanner;

public class ParkingApp {
    public static void main(String[] args) throws InterruptedException {
        ParkingLotService parkingLot = new ParkingLotService(5);
        BillingService billingService = new BillingService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of cars to park:");
        int numCars = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCars; i++) {
            System.out.println("\nEnter details for car " + (i + 1) + ":");

            System.out.print("License Plate: ");
            String licensePlate = scanner.nextLine();

            System.out.print("Car Model: ");
            String carModel = scanner.nextLine();

            System.out.print("Car Owner Name: ");
            String ownerName = scanner.nextLine();

            Car car = new Car(licensePlate, carModel, ownerName);

            if (parkingLot.parkCar(car)) {
                System.out.println("Car " + car.getLicensePlate() + " parked successfully!");
            } else {
                System.out.println("Parking lot is full. Could not park " + car.getLicensePlate());
            }
        }

        Thread.sleep(2000);

        parkingLot.displayParkingStatus();

        System.out.println("\n--- Parking Fees ---");
        for (int i = 0; i < numCars; i++) {
            System.out.print("Enter license plate for billing: ");
            String plate = scanner.nextLine();
            Car car = parkingLot.getCarInfo(plate);
            if (car != null) {
                System.out.println("Parking fee for " + car.getLicensePlate() + ": $" + billingService.calculateBill(car));
            }
        }

        System.out.print("\nEnter the license plate of the car to remove: ");
        String licensePlateToRemove = scanner.nextLine();
        parkingLot.removeCar(licensePlateToRemove);

        parkingLot.displayParkingStatus();
    }
}
