/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Vehicle;
import domain.VehicleEuropol;
import dto.VehicleEuropolDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.VehicleEuropolService;
import service.VehicleService;
import util.DomainToDto;
import util.DtoToDomain;

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

    @Inject
    VehicleService vehicleService;

    @GET
    public Response getStolenVehicles() throws PersistenceException {
        List<VehicleEuropolDTO> dtos = DomainToDto.VEHICLES_EUROPOL_TODTOS(VehicleEuropolService.getStolenVehicles());
        return Response.ok(dtos).build();
    }

    @GET
    @Path("{licensePlate}")
    public Response findStolenVehicle(@PathParam("licensePlate") String licensePlate) throws PersistenceException {
        VehicleEuropolDTO dto = DomainToDto.VEHICLE_EUROPOL_TODTO(VehicleEuropolService.findStolenVehicle(licensePlate));
        return Response.ok(dto).build();
    }

    @POST
    public Response insertStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        VehicleEuropol vehicleToInsert = DtoToDomain.VEHICLE_EUROPOL_DTO_TO_DOMAIN(vehicleEuropol);
        VehicleEuropolDTO dto = DomainToDto.VEHICLE_EUROPOL_TODTO(VehicleEuropolService.insertStolenVehicle(vehicleToInsert));
        return Response.ok(dto).build();
    }

    @POST
    @Path("eurpol")
    public Response insertStolenVehicleEuropol(VehicleEuropol vehicleEuropol) throws PersistenceException {
        VehicleEuropol vehicleToInsert = DtoToDomain.VEHICLE_EUROPOL_DTO_TO_DOMAIN(vehicleEuropol);
        VehicleEuropolDTO dto = DomainToDto.VEHICLE_EUROPOL_TODTO(VehicleEuropolService.insertStolenEuropolVehicle(vehicleToInsert));
        return Response.ok(dto).build();
    }

    @PUT
    public Response updateStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        VehicleEuropol vehicleToUpdate = DtoToDomain.VEHICLE_EUROPOL_DTO_TO_DOMAIN(vehicleEuropol);
        VehicleEuropolDTO dto = DomainToDto.VEHICLE_EUROPOL_TODTO(VehicleEuropolService.updateStolenVehicle(vehicleToUpdate));
        return Response.ok(dto).build();
    }

    @POST
    @Path("remove")
    public Response removeStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        VehicleEuropolService.removeStolenVehicle(vehicleEuropol);
        return Response.ok().build();
    }
}
