import com.parkinglot.model.Car;
import com.parkinglot.service.ParkingLotGridService;

import java.util.Scanner;

public class ParkingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLotGridService parkingLot = new ParkingLotGridService(4, 4); // 4x4 parking grid

        while (true) {
            System.out.println("\n-------- Parking Lot System --------");
            System.out.println("1. Park a Car");
            System.out.println("2. Remove a Car");
            System.out.println("3. Display Parking Lot");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter License Plate: ");
                    String license = scanner.nextLine().trim();

                    if (license.isEmpty()) {
                        System.out.println("License plate cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Car Model: ");
                    String model = scanner.nextLine().trim();

                    Car car = new Car(license, model);
                    parkingLot.addCar(car);
                    parkingLot.displayGrid();
                    break;

                case 2:
                    System.out.print("Enter License Plate to Remove: ");
                    String plate = scanner.nextLine().trim();
                    parkingLot.removeCar(plate);
                    parkingLot.displayGrid();
                    break;

                case 3:
                    parkingLot.displayGrid();
                    break;

                case 4:
                    System.out.println("Exiting Parking Lot System. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}