package com.rest.controller;

import java.net.URISyntaxException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.rest.ejb.model.Passenger;
import com.rest.ejb.repository.PassengerRepository;

@Path("passenger")
@Singleton
@LocalBean
public class PassengerResource {

    @EJB(beanName = "passengerRepository")
    private PassengerRepository repository;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/new")
    public Response save(Passenger passenger, @Context UriInfo uri) {
	if (passenger == null)
	    return Response.notAcceptable(null).build();
	repository.save(passenger);
	return Response.status(Response.Status.ACCEPTED).entity(passenger).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listNewPassengers")
    public Response listNewPassengers() throws URISyntaxException {
	return Response.status(Response.Status.ACCEPTED).entity(repository.findIfTaxiRideExists(false)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listPassengersFromHistory")
    public Response listPassengersFromHistory() throws URISyntaxException {
	return Response.status(Response.Status.ACCEPTED).entity(repository.findIfTaxiRideExists(true)).build();
    }
}
