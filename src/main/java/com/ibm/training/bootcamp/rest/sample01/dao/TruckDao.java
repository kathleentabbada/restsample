package com.ibm.training.bootcamp.rest.sample01.dao;
import com.ibm.training.bootcamp.rest.sample01.domain.Truck;
import java.util.List;

public interface TruckDao {
	public List<Truck> findAll();
	
	public Truck find(Long id);
	
	public List<Truck> findByName(String model, String licenseno, int weight, int capacity);
	
	public void add(Truck truck);
	
	public void update(Truck truck);
	
	public void delete(Long id);
}
