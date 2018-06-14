/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.VehicleEuropol;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.VehicleEuropolService;

/**
 *
 * @author M
 */
@Stateless
@Path("stolenvehicles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehicleEuropolRest {

    @Inject
    VehicleEuropolService VehicleEuropolService;

    @GET
    public List<VehicleEuropol> getStolenVehicles() throws PersistenceException {
        return VehicleEuropolService.getStolenVehicles();
    }

    @GET
    @Path("{id}")
    public VehicleEuropol findStolenVehicle(@PathParam("id") Integer id) throws PersistenceException {
        return VehicleEuropolService.findStolenVehicle(id);
    }

    @POST
    public Boolean insertStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        return VehicleEuropolService.insertStolenVehicle(vehicleEuropol);
    }

    @PUT
    public Boolean updateStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        return VehicleEuropolService.updateStolenVehicle(vehicleEuropol);
    }

    @DELETE
    public Boolean removeStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        return VehicleEuropolService.removeStolenVehicle(vehicleEuropol);
    }
}
