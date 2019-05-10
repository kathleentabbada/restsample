package com.ibm.training.bootcamp.rest.sample01.service;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.ibm.training.bootcamp.rest.sample01.dao.TripSchedDao;
import com.ibm.training.bootcamp.rest.sample01.dao.TripSchedJdbcDaoImpl;
import com.ibm.training.bootcamp.rest.sample01.domain.TripSched;

public class TripSchedServiceImpl implements TripSchedService {
	TripSchedDao tripSchedDao;

	public TripSchedServiceImpl() {
		this.tripSchedDao = TripSchedJdbcDaoImpl.getInstance();
	}
	
	public List<TripSched> findAll() {
		return tripSchedDao.findAll();
	}

	public TripSched find(Long tripId) {
		return tripSchedDao.find(tripId);
	}
	
	public List<TripSched> findByName(Long truckId, String driverName, String status) {
		return tripSchedDao.findByName(truckId, driverName, status);
	}
		
	public void add(TripSched tripsched) {
		if (validate(tripsched)) {
			tripSchedDao.add(tripsched);
		} else {
			throw new IllegalArgumentException("Fields cannot be blank.");
		}
	}

	public void update(TripSched tripsched) {
		if (validate(tripsched)) {
			if(tripsched.getTripId() != null && tripsched.getTripId() >= 0) {
				tripSchedDao.update(tripsched);
			} else {
				tripSchedDao.add(tripsched);
			}
		} else {
			throw new IllegalArgumentException("Fields cannot be blank.");
		}
	}

	public void delete1(Long tripId) {
		tripSchedDao.delete(tripId);
	}
	
	private boolean validate(TripSched tripsched) {
		return !StringUtils.isAnyBlank(tripsched.getDriverName(), tripsched.getStatus());
	}
}