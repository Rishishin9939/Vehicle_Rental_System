package Service;

import Beans.Rental;
import Dao.RentalDAO;

import java.util.List;

public class RentalService {
    private RentalDAO rentalDAO = new RentalDAO();

    public void saveRental(Rental rental) {
        rentalDAO.save(rental);
    }

    public List<Rental> getAllRentals() {
        return rentalDAO.findAll();
    }

    public Rental findRentalById(int id) {
        return rentalDAO.findById(id);
    }

    public void deleteRental(int id) {
        rentalDAO.delete(id);
    }
}