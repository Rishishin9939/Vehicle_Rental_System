package Controller;

import Beans.Car;
import Service.CarService;

import java.util.List;
import java.util.Scanner;

public class CarController {

    private CarService carService = new CarService();
    private Scanner scanner = new Scanner(System.in);
    public void addNewCar() {

        System.out.println("Enter car model: ");
        String model = scanner.nextLine();

        System.out.println("Enter car brand: ");
        String brand = scanner.nextLine();

        System.out.println("Enter registration number: ");
        String registrationNo = scanner.nextLine();

        Car car = new Car();
        car.setModel(model);
        car.setBrand(brand);
        car.setRegistrationNo(registrationNo);
        car.setAvailable(true);
        carService.addCar(car);
//        carService.addCar(car);
        System.out.println("Car added successfully.");
    }

    public void listAllCars() {
        List<Car> cars = carService.getAllCars();
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            System.out.println("List of Cars:");
            for (Car car : cars) {
                System.out.println("ID: " + car.getId() + ", Model: " + car.getModel() +
                        ", Brand: " + car.getBrand() + ", Registration No: " + car.getRegistrationNo() +
                        ", Available: " + car.isAvailable());
            }
        }
    }

    // Method to find a car by its ID
    public void findCarById() {
        System.out.print("Enter car ID to find: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        Car car = carService.findCarById(id);
        if (car != null) {
            System.out.println("Car Found: ID: " + car.getId() + ", Model: " + car.getModel() +
                    ", Brand: " + car.getBrand() + ", Registration No: " + car.getRegistrationNo() +
                    ", Available: " + car.isAvailable());
        } else {
            System.out.println("Car not found.");
        }
    }

    public void deleteCar() {
        System.out.print("Enter car ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        carService.deleteCar(id);
        System.out.println("Car deleted successfully (if it existed).");
    }

    public void run() {
        while (true) {
            System.out.println("\nCar Rental System");
            System.out.println("1. Add Car");
            System.out.println("2. List All Cars");
            System.out.println("3. Find Car by ID");
            System.out.println("4. Delete Car");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    addNewCar();
                    break;
                case 2:
                    listAllCars();
                    break;
                case 3:
                    findCarById();
                    break;
                case 4:
                    deleteCar();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
