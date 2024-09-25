package Controller;

import Beans.Rental;
import Beans.Car;
import Beans.Customer;
import Service.RentalService;
import Service.CarService;
import Service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class RentalController {
    private RentalService rentalService = new RentalService();
    private CarService carService = new CarService();
    private CustomerService customerService = new CustomerService();
    private Scanner scanner = new Scanner(System.in);

    public void rentCar() {
        System.out.print("Enter car ID to rent: ");
        int carId = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        Rental rental = new Rental();
        rental.setCar(carService.findCarById(carId));
        rental.setCustomer(customerService.findCustomerById(customerId));
        rental.setRentalDate(new java.util.Date()); // Set current date

        rentalService.saveRental(rental);
        System.out.println("Car rented successfully!");
    }

    public void listAllRentals() {
        List<Rental> rentals = rentalService.getAllRentals();
        if (rentals.isEmpty()) {
            System.out.println("No rentals available.");
        } else {
            System.out.println("List of Rentals:");
            for (Rental rental : rentals) {
                System.out.println("Rental ID: " + rental.getId() + ", Car: " + rental.getCar().getModel() +
                        ", Customer: " + rental.getCustomer().getFirstName() + ", Rental Date: " + rental.getRentalDate());
            }
        }
    }

    public void findRentalById() {
        System.out.print("Enter rental ID to find: ");
        int rentalId = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        Rental rental = rentalService.findRentalById(rentalId);
        if (rental != null) {
            System.out.println("Rental Found: Rental ID: " + rental.getId() + ", Car: " + rental.getCar().getModel() +
                    ", Customer: " + rental.getCustomer().getFirstName() + ", Rental Date: " + rental.getRentalDate());
        } else {
            System.out.println("Rental not found.");
        }
    }

    public void returnCar() {
        System.out.print("Enter rental ID to return: ");
        int rentalId = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        Rental rental = rentalService.findRentalById(rentalId);
        if (rental != null) {
            rentalService.deleteRental(rentalId); // Delete rental record (or mark as returned)
            System.out.println("Car returned successfully!");
        } else {
            System.out.println("Rental not found.");
        }
    }

    public void run() {
        while (true) {
            System.out.println("\nRental Management System");
            System.out.println("1. Rent Car");
            System.out.println("2. List All Rentals");
            System.out.println("3. Find Rental by ID");
            System.out.println("4. Return Car");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    rentCar();
                    break;
                case 2:
                    listAllRentals();
                    break;
                case 3:
                    findRentalById();
                    break;
                case 4:
                    returnCar();
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
