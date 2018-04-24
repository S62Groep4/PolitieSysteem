package dao;

import domain.SubInvoice;
import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
public class VehicleDAOImpl implements VehicleDAO{

    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<Vehicle> getVehicle(String hashedLicenceplate) throws PersistenceException {
        return em.createNamedQuery("Vehicle.findByLicenceplate")
                .setParameter("hashedLicencePlate", "%" + hashedLicenceplate + "%").getResultList();
    }

    @Override
    public List<Vehicle> getAllVehicles() throws PersistenceException {
        return em.createNamedQuery("Vehicle.findAll").getResultList();
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) throws PersistenceException {
        em.merge(vehicle);
        return true;
    }

    @Override
    public boolean removeVehicle(String hashedLicenceplate) throws PersistenceException {
        Vehicle temp = em.find(Vehicle.class, hashedLicenceplate);

        for (Integer j : temp.getJourneys()) {
            em.remove(j);
        }

        for (SubInvoice si : temp.getSubInvoices()) {
            em.remove(si);
        }

        em.remove(temp);
        return true;
    }

    @Override
    public boolean insertVehicle(Vehicle vehicle) throws PersistenceException {
        em.persist(vehicle);
        return true;
    }

}
