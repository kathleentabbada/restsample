package com.ibm.training.bootcamp.rest.sample01.service;
import com.ibm.training.bootcamp.rest.sample01.domain.TripSched;
//import java.sql.Date;
import java.util.List;

public interface TripSchedService {
	public List<TripSched> findAll();
	
	public TripSched find(Long tripId);
	
	public List<TripSched> findByName(Long truckId, String driverName, String status);
	
	public void add(TripSched tripsched);
	
	public void update(TripSched tripsched);
	
	public void delete1(Long tripId);
}
