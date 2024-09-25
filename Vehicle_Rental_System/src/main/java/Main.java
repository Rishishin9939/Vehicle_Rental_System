//import Controller.CarController;
//
//import Controller.CustomerController;
//import Controller.RentalController;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        CarController carController = new CarController();
//                CustomerController customerController = new CustomerController();
//                RentalController rentalController = new RentalController();
//                Scanner scanner = new Scanner(System.in);
//
//                boolean running = true;
//                while (running) {
//                    System.out.println("\n===== Car Rental System =====");
//                    System.out.println("1. Manage Cars");
//                    System.out.println("2. Manage Customers");
//                    System.out.println("3. Manage Rentals");
//                    System.out.println("4. Exit");
//                    System.out.print("Choose an option: ");
//
//                    int option = scanner.nextInt();
//                    switch (option) {
//                        case 1:
//                            manageCars(carController);
//                            break;
//                        case 2:
//                            manageCustomers(customerController);
//                            break;
//                        case 3:
//                            manageRentals(rentalController, carController, customerController);
//                            break;
//                        case 4:
//                            running = false;
//                            System.out.println("Exiting the system. Goodbye!");
//                            break;
//                        default:
//                            System.out.println("Invalid option! Please try again.");
//                    }
//                }
//                scanner.close();
//            }
//
//            private static void manageCars(CarController carController) {
//                Scanner scanner = new Scanner(System.in);
//                boolean running = true;
//
//                while (running) {
//                    System.out.println("\n===== Manage Cars =====");
//                    System.out.println("1. Add a new car");
//                    System.out.println("2. List all cars");
//                    System.out.println("3. Find a car by ID");
//                    System.out.println("4. Update car availability");
//                    System.out.println("5. Delete a car");
//                    System.out.println("6. Back to main menu");
//                    System.out.print("Choose an option: ");
//
//                    int option = scanner.nextInt();
//                    switch (option) {
//                        case 1:
//                            carController.addNewCar();
//                            break;
//                        case 2:
//                            carController.listAllCars();
//                            break;
//                        case 3:
//                            carController.findCarById();
//                            break;
//                        case 4:
//                            carController.updateCarAvailability();
//                            break;
//                        case 5:
//                            carController.deleteCar();
//                            break;
//                        case 6:
//                            running = false;
//                            break;
//                        default:
//                            System.out.println("Invalid option! Please try again.");
//                    }
//                }
//            }
//
//            private static void manageCustomers(CustomerController customerController) {
//                Scanner scanner = new Scanner(System.in);
//                boolean running = true;
//
//                while (running) {
//                    System.out.println("\n===== Manage Customers =====");
//                    System.out.println("1. Add a new customer");
//                    System.out.println("2. List all customers");
//                    System.out.println("3. Find a customer by ID");
//                    System.out.println("4. Back to main menu");
//                    System.out.print("Choose an option: ");
//
//                    int option = scanner.nextInt();
//                    switch (option) {
//                        case 1:
//                            customerController.addNewCustomer();
//                            break;
//                        case 2:
//                            customerController.listAllCustomers();
//                            break;
//                        case 3:
//                            customerController.findCustomerById();
//                            break;
//                        case 4:
//                            running = false;
//                            break;
//                        default:
//                            System.out.println("Invalid option! Please try again.");
//                    }
//                }
//            }
//
//            private static void manageRentals(RentalController rentalController, CarController carController, CustomerController customerController) {
//                Scanner scanner = new Scanner(System.in);
//                boolean running = true;
//
//                while (running) {
//                    System.out.println("\n===== Manage Rentals =====");
//                    System.out.println("1. Rent a car");
//                    System.out.println("2. List all rentals");
//                    System.out.println("3. Find a rental by ID");
//                    System.out.println("4. Return a car");
//                    System.out.println("5. Back to main menu");
//                    System.out.print("Choose an option: ");
//
//                    int option = scanner.nextInt();
//                    switch (option) {
//                        case 1:
//                            rentalController.rentCar(carController, customerController);
//                            break;
//                        case 2:
//                            rentalController.listAllRentals();
//                            break;
//                        case 3:
//                            rentalController.findRentalById();
//                            break;
//                        case 4:
//                            rentalController.returnCar();
//                            break;
//                        case 5:
//                            running = false;
//                            break;
//                        default:
//                            System.out.println("Invalid option! Please try again.");
//                    }
//                }
//            }
//        }
////        carController.addNewCar();
////        carController.listAllCars();





import Controller.CarController;
import Controller.CustomerController;
import Controller.RentalController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Car Rental System");
            System.out.println("1. Manage Cars");
            System.out.println("2. Manage Customers");
            System.out.println("3. Manage Rentals");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    CarController carController = new CarController();
                    carController.run();
                    break;
                case 2:
                    CustomerController customerController = new CustomerController();
                    customerController.run();
                    break;
                case 3:
                    RentalController rentalController = new RentalController();
                    rentalController.run();
                    break;
                case 4:
                    System.out.println("Exiting the application. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

