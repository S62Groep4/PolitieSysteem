/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.TransLocation;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Sjoerd
 */
@Stateless
@Path("test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {


    @Inject
    private Event<TransLocation> eventOnes;


    @GET
    public String vehicles(){
        TransLocation eventOne = new TransLocation();
        eventOne.setCountryCode("POPO");
        eventOnes.fire(eventOne);

        return "test";
    }



    

}
