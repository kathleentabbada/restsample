package com.ibm.training.bootcamp.rest.sample01.restcontroller;

import java.sql.Date;
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

import com.ibm.training.bootcamp.rest.sample01.domain.Truck;
import com.ibm.training.bootcamp.rest.sample01.service.TruckService;
import com.ibm.training.bootcamp.rest.sample01.service.TruckServiceImpl;

@Path("/trucks")
public class TrucksController {

	private TruckService truckService;

	public TrucksController() {
		this.truckService = new TruckServiceImpl();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Truck> getTrucks(
			@QueryParam("model") String model, 
			@QueryParam("licenseno") String licenseno,
			@QueryParam("weight") int weight,
			@QueryParam("capacity") int capacity,
			@QueryParam("dateacq") Date dateacq) {

		try {
			List<Truck> trucks;
			
			if (StringUtils.isAllBlank(model, licenseno)) {
				trucks = truckService.findAll();
			} else {
				trucks = truckService.findByName(model, licenseno, weight, capacity);
			}
						
			return trucks;
			
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Truck getTruck(@PathParam("id") String id) {

		try {
			Long longId = Long.parseLong(id);
			Truck truck = truckService.find(longId);
			return truck;
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTruck(Truck truck) {

		try {
			truckService.add(truck);
			String result = "Truck saved : " + truck.getModel() + " " + truck.getLicenseno() 
				+ " " + truck.getWeight() + " " + truck.getCapacity() + " " + truck.getDateacq();
			return Response.status(201).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTruck(Truck truck) {

		try {
			truckService.update(truck);
			String result = "Truck updated : " + truck.getModel() + " " + truck.getLicenseno()
				+ " " + truck.getWeight() + " " + truck.getCapacity() + " " + truck.getDateacq();
			return Response.status(200).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}

	}

	@DELETE
	@Path("{id}")
	public Response deleteTruck(@PathParam("id") String id) {

		try {
			Long longId = Long.parseLong(id);
			truckService.delete(longId);
			String result = "Truck deleted";
			return Response.status(200).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
}
