package rest;

import domain.Vehicle;
import dto.JourneyDTO;
import dto.SubInvoiceDTO;
import dto.VehicleDTO;
import dto.VehicleVisibleLicencePlateDTO;
import service.VehicleEuropolService;
import service.VehicleService;
import util.DomainToDto;
import util.DtoToDomain;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Stateless
@Path("stolen")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StolenResource {

    @Inject
    VehicleEuropolService VehicleEuropolService;


    @GET
    public Response getAllSerialNumbers() {
        List<String> returnList = new ArrayList<>();
        VehicleEuropolService.getStolenVehicles().forEach(vehicle -> { returnList.add(vehicle.getSerialNumber());});
        return Response.ok(returnList).build();
    }
}
