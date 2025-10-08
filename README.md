# Parking Lot Management System

A simple Java-based parking lot management system that simulates the operations of a parking facility using console interface.

## 📋 Overview

This project implements a parking lot management system that allows users to:
- Park cars in available spots
- Remove cars from the parking lot with automatic fee calculation
- Search for specific cars by license plate
- View available parking spots
- List all currently parked cars

The system uses a **Stack (LIFO - Last In, First Out)** data structure to simulate a single-lane parking lot where cars need to be moved to access cars parked earlier.

## 🏗️ Project Structure

```
Parking-Lot/
├── Main.java          # Main application entry point with user interface
├── Car.java           # Car class representing individual vehicles
├── ParkingLot.java    # Core parking lot management logic
├── Car.class          # Compiled Car class
├── ParkingLot.class   # Compiled ParkingLot class
├── Main.class         # Compiled Main class
└── README.md          # This file
```

## 🎯 Features

### Core Functionality
- **Park Car**: Add a new car to the parking lot
- **Remove Car**: Remove a car and calculate parking fees
- **Search Car**: Find and display information about a parked car
- **Available Spots**: Check remaining parking capacity
- **List Parked Cars**: Display all currently parked vehicles

### Additional Features
- **Duplicate Prevention**: Prevents parking the same car twice
- **Time Tracking**: Records entry time for each vehicle
- **Fee Calculation**: Automatic fee calculation based on parking duration
- **Capacity Management**: Configurable parking lot capacity

## 💰 Pricing Structure

- **Rate**: $5 per hour
- **Billing**: Rounded up to the nearest hour
- **Minimum**: 1 hour charge regardless of actual time

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line interface (Terminal/Command Prompt)

### Compilation
```bash
javac *.java
```

### Running the Application
```bash
java Main
```

## 🎮 How to Use

1. **Start the Application**: Run `java Main`
2. **Choose an Option**: Select from the menu (1-6)
3. **Follow Prompts**: Enter license plate numbers as requested

### Menu Options:
```
1. Park Car       - Add a new car to the parking lot
2. Remove Car     - Remove a car and pay parking fee
3. Search Car     - Find a specific car by license plate
4. Available Spots - Check remaining parking capacity
5. List Parked Cars - View all currently parked cars
6. Exit           - Close the application
```

## 💡 Example Usage

```
Choose option: 1
Enter license plate: ABC123
Car ABC123 parked successfully.

Choose option: 3
Enter license plate to search: ABC123
Car ABC123 is parked.
Parked since: 08-10-2025 14:30:15
Time elapsed: 45 minutes

Choose option: 2
Enter license plate to remove: ABC123
Car ABC123 removed.
Parked time: 45 minutes | Fee: $5
```

## 🔧 Technical Details

### Data Structures Used
- **Stack**: For LIFO parking management
- **HashMap**: For O(1) license plate lookup
- **Scanner**: For user input handling

### Classes Overview

#### `Car.java`
- Represents individual vehicles
- Stores license plate and entry time
- Provides getter methods for accessing car data

#### `ParkingLot.java`
- Core business logic for parking operations
- Manages parking capacity and car storage
- Handles fee calculation and time tracking

#### `Main.java`
- User interface and menu system
- Input validation and error handling
- Application flow control

## ⚙️ Configuration

The parking lot capacity can be modified in `Main.java`:
```java
ParkingLot lot = new ParkingLot(5); // Change 5 to desired capacity
```

The hourly rate can be modified in `ParkingLot.java`:
```java
int ratePerHour = 5; // Change to desired rate
```

## 🚨 Known Limitations

1. **Single Lane Design**: Cars parked earlier may need other cars to be moved first
2. **Memory Storage**: Data is not persisted between application runs
3. **Console Interface**: No graphical user interface
4. **Single Threading**: No concurrent access support

## 🔮 Future Enhancements

- [ ] Database integration for data persistence
- [ ] Multi-level parking support
- [ ] GUI interface using JavaFX or Swing
- [ ] Real-time parking spot visualization
- [ ] Different vehicle types (car, motorcycle, truck)
- [ ] Reserved parking spots
- [ ] Payment processing integration
- [ ] Parking history and analytics

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👥 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📞 Support

If you encounter any issues or have questions about this project, please create an issue in the repository.

---
**Created with ❤️ using Java**
