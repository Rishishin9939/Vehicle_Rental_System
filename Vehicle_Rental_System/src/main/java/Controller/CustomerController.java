package Controller;

import Beans.Customer;
import Service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private CustomerService customerService = new CustomerService();
    private Scanner scanner = new Scanner(System.in);

    public void addCustomer() {
        System.out.print("Enter customer First name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter customer Last name: ");
        String lname = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        System.out.print("Enter customer's Address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer();
        customer.setFirstName(fname);
        customer.setLastName(lname);
        customer.setEmail(email);
        customer.setAddress(address);
        customerService.saveCustomer(customer);

        System.out.println("Customer added successfully!");
    }

    public void listAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            System.out.println("List of Customers:");
            for (Customer customer : customers) {
                System.out.println("ID: " + customer.getId() + ", First Name: " + customer.getFirstName() +", Last Name: " + customer.getLastName() +
                        ", Email: " + customer.getEmail() + ", Address: " + customer.getAddress());
            }
        }
    }

    public void findCustomerById() {
        System.out.print("Enter customer ID to find: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        Customer customer = customerService.findCustomerById(id);
        if (customer != null) {
            System.out.println("Customer Found: ID: " + customer.getId() + ", First Name: " + customer.getFirstName() +", Last Name: " + customer.getLastName()+
                    ", Email: " + customer.getEmail() + ", Address: " + customer.getAddress());
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void deleteCustomer() {
        System.out.print("Enter customer ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        customerService.deleteCustomer(id);
        System.out.println("Customer deleted successfully (if it existed).");
    }

    public void run() {
        while (true) {
            System.out.println("\nCustomer Management System");
            System.out.println("1. Add Customer");
            System.out.println("2. List All Customers");
            System.out.println("3. Find Customer by ID");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    listAllCustomers();
                    break;
                case 3:
                    findCustomerById();
                    break;
                case 4:
                    deleteCustomer();
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
