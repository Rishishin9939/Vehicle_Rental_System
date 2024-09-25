package Testing;

import Beans.Customer;
import Service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class CustomerServiceTest {

    private CustomerService customerService;

    @Before
    public void setUp() {
        customerService = new CustomerService();
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Sina");
        customer.setEmail("john.doe@example.com");
        customer.setAddress("Tokyo");

        customerService.saveCustomer(customer);
        List<Customer> customers = customerService.getAllCustomers();
        assertFalse(customers.isEmpty());
    }

    @Test
    public void testFindCustomerById() {
        Customer customer = customerService.findCustomerById(1);
        assertNotNull(customer);
        assertEquals(1, customer.getId());
    }

//    @Test
//    public void testDeleteCustomer() {
//        customerService.deleteCustomer(1);
//        Customer customer = customerService.deleteCustomer(1);
//        assertNull(customer);
//    }
}