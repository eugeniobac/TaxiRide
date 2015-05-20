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

import com.rest.ejb.model.Driver;
import com.rest.ejb.repository.DriverRepository;

@Path("driver")
@Singleton
@LocalBean
public class DriverResource {

    @EJB(beanName = "driverRepository")
    private DriverRepository repository;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/new")
    public Response save(Driver driver, @Context UriInfo uri) {
	repository.save(driver);
	return Response.status(Response.Status.ACCEPTED).entity(driver).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response update(Driver driver, @Context UriInfo uri) {
	if (driver == null)
	    return Response.notAcceptable(null).build();
	repository.update(driver);
	return Response.status(Response.Status.ACCEPTED).entity(driver).build();
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
