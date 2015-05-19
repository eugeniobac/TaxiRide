package com.rest.controller;

import java.util.List;

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
import com.rest.ejb.vo.ReportVO;

@Path("report")
@Singleton
@LocalBean
public class ReportResource {

    @EJB(beanName = "taxiRideRepository")
    private TaxiRideRepository repository;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/generate")
    public Response generate(ReportVO report, @Context UriInfo uri) {

	List<TaxiRide> rides = repository.findByDates(report.getStartDate(), report.getEndDate());

	return Response.status(Response.Status.ACCEPTED).entity(rides).build();
    }
}
