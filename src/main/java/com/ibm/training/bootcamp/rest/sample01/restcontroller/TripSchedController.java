package com.ibm.training.bootcamp.rest.sample01.restcontroller;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import com.ibm.training.bootcamp.rest.sample01.domain.TripSched;
import com.ibm.training.bootcamp.rest.sample01.service.TripSchedService;
import com.ibm.training.bootcamp.rest.sample01.service.TripSchedServiceImpl;

@Path("/tripscheds")
public class TripSchedController {
	
	private TripSchedService tripSchedService;

	public TripSchedController() {
		this.tripSchedService = new TripSchedServiceImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TripSched> getTripScheds(
			@QueryParam("truckId") Long truckId, 
			@QueryParam("driverName") String driverName,
			@QueryParam("dtStart") Date dtStart,
			@QueryParam("dtStarttime") Time dtStarttime,
			@QueryParam("dtEnd") Date dtEnd,
			@QueryParam("dtEndtime") Time dtEndtime,
			@QueryParam("status") String status) {

		try {
			List<TripSched> tripscheds;
			
			if (StringUtils.isAllBlank(driverName, status)) {
				tripscheds = tripSchedService.findAll();
			} else {
				tripscheds = tripSchedService.findByName(truckId, driverName, status);
			}
						
			return tripscheds;
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TripSched getTripSched(@PathParam("id") String tripId) {

		try {
			Long longTripId = Long.parseLong(tripId);
			TripSched tripsched = tripSchedService.find(longTripId);
			return tripsched;
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTruck(TripSched tripsched) {

		try {
			tripSchedService.add(tripsched);
			String result = "Trip Schedule saved : " + tripsched.getTruckId() + " " + tripsched.getDriverName() + " " 
			+ tripsched.getLoadWeight() + " " + tripsched.getDtStart() + " " + tripsched.getDtStarttime() + " "  
			+ tripsched.getDtEnd() + " " + tripsched.getDtEndtime() + " "  + tripsched.getStatus();
			return Response.status(201).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTruck(TripSched tripsched) {

		try {
			tripSchedService.update(tripsched);
			String result = "Trip Schedule updated : " + tripsched.getTruckId() + " " + tripsched.getDriverName() + " " 
					+ tripsched.getLoadWeight() + " " + tripsched.getDtStart() + " " + tripsched.getDtStarttime() + " "  
					+ tripsched.getDtEnd() + " " + tripsched.getDtEndtime() + " "  + tripsched.getStatus();
			return Response.status(200).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}

	}

	@DELETE
	@Path("{id}")
	public Response deleteTruck(@PathParam("id") String tripId) {

		try {
			Long longTripId = Long.parseLong(tripId);
			tripSchedService.delete1(longTripId);
			String result = "Trip Schedule deleted";
			return Response.status(200).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
}
