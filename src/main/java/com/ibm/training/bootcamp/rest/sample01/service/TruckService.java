package com.ibm.training.bootcamp.rest.sample01.service;

import java.util.List;
//import java.util.Date;
import com.ibm.training.bootcamp.rest.sample01.domain.Truck;

public interface TruckService {
	public List<Truck> findAll();
	
	public Truck find(Long id);
	
	public List<Truck> findByName(String model, String licenseno, int weight, int capacity);
	
	public void add(Truck truck);
	
	public void update(Truck truck);
	
	public void delete(Long id);
}
