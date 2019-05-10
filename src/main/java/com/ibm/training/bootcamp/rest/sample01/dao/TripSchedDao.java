package com.ibm.training.bootcamp.rest.sample01.dao;
import com.ibm.training.bootcamp.rest.sample01.domain.TripSched;
//import java.sql.Date;
import java.util.List;

public interface TripSchedDao {
	public List<TripSched> findAll();
	
	public TripSched find(Long tripId);
	
	public List<TripSched> findByName(Long truckId, String driverName, String status);
	
	public void add(TripSched tripsched);
	
	public void update(TripSched tripsched);
	
	public void delete(Long tripId);
}
