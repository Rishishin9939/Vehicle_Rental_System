package Testing;

import Beans.Car;
import Service.CarService;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class CarServiceTest {

    private CarService carService;

    @Before
    public void setUp() {
        carService = new CarService();
    }

    @Test
    public void testAddCar() {
        Car car = new Car();
        car.setBrand("Toyota");
        car.setModel("Corolla");
        car.setRegistrationNo("AB123CD");
        car.setAvailable(true);

        carService.addCar(car);
        List<Car> cars = carService.getAllCars();
        assertFalse(cars.isEmpty());
    }

    @Test
    public void testFindCarById() {
        Car car = carService.findCarById(1);
        assertNotNull(car);
        assertEquals(1, car.getId());
    }

//    @Test
//    public void testDeleteCar() {
//        carService.deleteCar(1);
//        Car car = carService.deleteCar();
//        assertNull(car);
//    }
}