package com.rest.controller;

import java.net.URISyntaxException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response update(Passenger passenger, @Context UriInfo uri) {
	if (passenger == null)
	    return Response.notAcceptable(null).build();
	repository.update(passenger);
	return Response.status(Response.Status.ACCEPTED).entity(passenger).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
	repository.delete(repository.findById(id));
	return Response.status(Response.Status.ACCEPTED).entity(repository.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response list() throws URISyntaxException {
	return Response.status(Response.Status.ACCEPTED).entity(repository.findAll()).build();
    }
}
