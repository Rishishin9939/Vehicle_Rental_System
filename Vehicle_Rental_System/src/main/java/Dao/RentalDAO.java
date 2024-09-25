package Dao;

import Beans.Rental;
import Utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RentalDAO {

    public void save(Rental rental) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(rental);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Rental> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Rental", Rental.class).list();
        }
    }

    public Rental findById(int id) {
        Rental rental = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            rental = session.get(Rental.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rental;
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Rental rental = session.get(Rental.class, id);
            if (rental != null) {
                session.delete(rental);
                System.out.println("Rental with ID " + id + " deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}