package com.ibm.training.bootcamp.rest.sample01.domain;
import java.sql.Date;
import java.sql.Time;


public class TripSched {
	Long tripId;
	Long truckId;
	private String driverName;
	private int loadWeight;
	private Date dtStart;
	private Time dtStarttime;
	private Date dtEnd;
	private Time dtEndtime;
	private String status;
	
	public TripSched() {
		
	}
	
	public TripSched(Long truckId, String driverName, int loadWeight, Date dtStart, Time dtStarttime, Date dtEnd, Time dtEndtime, String status) {
		this(null, truckId, driverName, loadWeight, dtStart, dtStarttime, dtEnd, dtEndtime, status);
	}

	public TripSched(Long tripId, Long truckId, String driverName, int loadWeight, Date dtStart, Time dtStarttime, Date dtEnd, Time dtEndtime, String status) {
		this.tripId = tripId;
		this.truckId = truckId;
		this.driverName = driverName;
		this.loadWeight = loadWeight;
		this.dtStart = dtStart;
		this.dtStarttime = dtStarttime;
		this.dtEnd = dtEnd;
		this.dtEndtime = dtEndtime;
		this.status = status;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public Long getTruckId() {
		return truckId;
	}

	public void setTruckId(Long truckId) {
		this.truckId = truckId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public int getLoadWeight() {
		return loadWeight;
	}

	public void setLoadWeight(int loadWeight) {
		this.loadWeight = loadWeight;
	}

	public Date getDtStart() {
		return dtStart;
	}

	public void setDtStart(Date dtStart) {
		this.dtStart = dtStart;
	}

	public Time getDtStarttime() {
		return dtStarttime;
	}

	public void setDtStarttime(Time dtStarttime) {
		this.dtStarttime = dtStarttime;
	}

	public Date getDtEnd() {
		return dtEnd;
	}

	public void setDtEnd(Date dtEnd) {
		this.dtEnd = dtEnd;
	}

	public Time getDtEndtime() {
		return dtEndtime;
	}

	public void setDtEndtime(Time dtEndtime) {
		this.dtEndtime = dtEndtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
