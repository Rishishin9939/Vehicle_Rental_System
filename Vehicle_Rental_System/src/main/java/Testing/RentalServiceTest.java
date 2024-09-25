package Testing;

import Beans.Car;
import Beans.Customer;
import Beans.Rental;
import Service.CarService;
import Service.CustomerService;
import Service.RentalService;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

public class RentalServiceTest {

    private RentalService rentalService;
    private CarService carService;
    private CustomerService customerService;

    @Before
    public void setUp() {
        rentalService = new RentalService();
        carService = new CarService();
        customerService = new CustomerService();
    }

    @Test
    public void testAddRental() {
        Car car = carService.findCarById(1);
        Customer customer = customerService.findCustomerById(1);
        Rental rental = new Rental();
        rental.setCar(car);
        rental.setCustomer(customer);
        rental.setRentalDate(new Date());

        rentalService.saveRental(rental);
        List<Rental> rentals = rentalService.getAllRentals();
        assertFalse(rentals.isEmpty());
    }

    @Test
    public void testFindRentalById() {
        Rental rental = rentalService.findRentalById(1);
        assertNotNull(rental);
        assertEquals(1, rental.getId());
    }

//    @Test
//    public void testDeleteRental() {
//        rentalService.deleteRental(1);
//        Rental rental = rentalService.deleteRental(1);
//        assertNull(rental);
//    }
}