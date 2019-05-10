package com.ibm.training.bootcamp.rest.sample01.service;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.ibm.training.bootcamp.rest.sample01.dao.TruckDao;
import com.ibm.training.bootcamp.rest.sample01.dao.TruckJdbcDaoImpl;
import com.ibm.training.bootcamp.rest.sample01.domain.Truck;

public class TruckServiceImpl implements TruckService{
	TruckDao truckDao;

	public TruckServiceImpl() {
		this.truckDao = TruckJdbcDaoImpl.getInstance();
	}
	
	@Override
	public List<Truck> findAll() {
		return truckDao.findAll();
	}

	@Override
	public Truck find(Long id) {
		return truckDao.find(id);
	}

	@Override
	public List<Truck> findByName(String model, String licenseno, int weight, int capacity) {
		return truckDao.findByName(model, licenseno, weight, capacity);
	}
		
	@Override
	public void add(Truck truck) {
		if (validate(truck)) {
			truckDao.add(truck);
		} else {
			throw new IllegalArgumentException("Fields cannot be blank.");
		}
	}

	@Override
	public void update(Truck truck) {
		if (validate(truck)) {
			if(truck.getId() != null && truck.getId() >= 0) {
				truckDao.update(truck);
			} else {
				truckDao.add(truck);
			}
		} else {
			throw new IllegalArgumentException("Fields cannot be blank.");
		}
	}

	@Override
	public void delete(Long id) {
		truckDao.delete(id);
	}
	
	private boolean validate(Truck truck) {
		return !StringUtils.isAnyBlank(truck.getModel(), truck.getLicenseno());
	}

}
