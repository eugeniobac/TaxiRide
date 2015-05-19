package com.rest.controller;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.rest.ejb.model.TaxiRide;
import com.rest.ejb.repository.TaxiRideRepository;

@Path("taxiRide")
@Singleton
@LocalBean
public class TaxiRideResource {

    @EJB(beanName = "taxiRideRepository")
    private TaxiRideRepository repository;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/new")
    public Response save(TaxiRide taxiRide, @Context UriInfo uri) {
	if (taxiRide == null)
	    return Response.notAcceptable(null).build();
	// taxiRide.getPassenger().setTaxiRide(taxiRide);
	repository.save(taxiRide);
	return Response.status(Response.Status.ACCEPTED).entity(taxiRide).build();
    }

}
