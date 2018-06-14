/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.VehicleEuropol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class VehicleEuropolDAOImpl implements VehicleEuropolDAO{

    @PersistenceContext(name = "ptt_test")
    EntityManager em;
    
    @Override
    public List<VehicleEuropol> getStolenVehicles() throws PersistenceException {
        return em.createNamedQuery("VehicleEuropol.getStolenVehicles").getResultList();
    }

    @Override
    public VehicleEuropol findStolenVehicle(Integer id) throws PersistenceException {
        return (VehicleEuropol) em.createNamedQuery("VehicleEuropol.findStolenVehicle").setParameter("id", id).getSingleResult();
    }

    @Override
    public Boolean insertStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        em.persist(vehicleEuropol);
        return true;
    }

    @Override
    public Boolean updateStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        em.merge(vehicleEuropol);
        return true;
    }

    @Override
    public Boolean removeStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        em.remove(vehicleEuropol);
        return true;
    }
    
}
