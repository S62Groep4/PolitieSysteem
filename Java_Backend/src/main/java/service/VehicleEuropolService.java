/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.VehicleEuropolDAO;
import domain.VehicleEuropol;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class VehicleEuropolService {

    @Inject
    VehicleEuropolDAO vehicleEuropolDAO;

    public List<VehicleEuropol> getStolenVehicles() throws PersistenceException {
        return vehicleEuropolDAO.getStolenVehicles();
    }

    public VehicleEuropol findStolenVehicle(Integer id) throws PersistenceException {
        return vehicleEuropolDAO.findStolenVehicle(id);
    }

    public Boolean insertStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        return vehicleEuropolDAO.insertStolenVehicle(vehicleEuropol);
    }

    public Boolean updateStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        return vehicleEuropolDAO.updateStolenVehicle(vehicleEuropol);
    }

    public Boolean removeStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        return vehicleEuropolDAO.removeStolenVehicle(vehicleEuropol);
    }
}
