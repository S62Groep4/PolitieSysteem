package dao;

import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
public class VehicleDAOImpl implements VehicleDAO{

    
    @PersistenceContext(name = "politieSysteemPU")
    EntityManager em;
    
    @Override
    public List<Vehicle> getVehicle(String hashedLicenceplate) throws PersistenceException {
        return em.createNamedQuery("Vehicle.findByLicenseplate").setParameter("license", hashedLicenceplate).getResultList();
    }

    @Override
    public List<Vehicle> getAllVehicles() throws PersistenceException {
        return em.createNamedQuery("Vehicle.findAll").getResultList();
    }

    //NOTE returning a bool here is not needed
    @Override
    public boolean updateVehicle(Vehicle vehicle) throws PersistenceException {
        em.merge(vehicle);
        return true;
    }

    @Override
    public boolean removeVehicle(Vehicle vehicle) throws PersistenceException {
        Vehicle managedVehicle = em.find(Vehicle.class, vehicle.getHashedLicensePlate());
        em.remove(managedVehicle);
        return true;
    }

    @Override
    public boolean insertVehicle(Vehicle vehicle) throws PersistenceException {
        em.persist(vehicle);
        return true;
    }

}
