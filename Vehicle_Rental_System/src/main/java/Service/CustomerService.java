package Service;

import Dao.CustomerDAO;
import Beans.Customer;

import java.util.List;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();
    // Save a new customer
    public void saveCustomer(Customer customer) {
            customerDAO.save(customer);
    }

    // Find all customers
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    public void deleteCustomer(int id) {
        customerDAO.delete(id);
    }

    public Customer findCustomerById(int id) {
        return customerDAO.findById(id);
    }
}