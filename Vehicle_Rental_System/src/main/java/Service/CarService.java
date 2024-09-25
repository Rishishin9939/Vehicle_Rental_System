package Service;

import Dao.CarDAO;
import Beans.Car;

import java.util.List;

public class CarService {

    private CarDAO carDAO = new CarDAO();

    public void addCar(Car car) {
        carDAO.save(car);
    }

    public List<Car> getAllCars() {
        return carDAO.findAll();
    }

    public Car findCarById(int id) {
        return carDAO.findById(id);
    }

    public void deleteCar(int carId){
        carDAO.delete(carId);
    }
}