/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.VehicleEuropol;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
public interface VehicleEuropolDAO {

    List<VehicleEuropol> getStolenVehicles() throws PersistenceException;

    VehicleEuropol findStolenVehicle(String licensePlate) throws PersistenceException;

    Boolean insertStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException;

    Boolean updateStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException;

    Boolean removeStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException;
}
