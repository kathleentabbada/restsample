package com.ibm.training.bootcamp.rest.sample01.domain;
import java.sql.Date;

public class Truck {
	Long id;
	private String model;
	private String licenseno;
	private int weight;
	private int capacity;
	private Date dateacq;
	
	public Truck() {
		
	}
	
	public Truck(String model, String licenseno, int weight, int capacity, Date dateacq) {
		this(null, model, licenseno, weight, capacity, dateacq);
	}

	public Truck(Long id, String model, String licenseno, int weight, int capacity, Date dateacq) {
		this.id = id;
		this.model = model;
		this.licenseno = licenseno;
		this.weight = weight;
		this.capacity = capacity;
		this.dateacq = dateacq;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicenseno() {
		return licenseno;
	}

	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Date getDateacq() {
		return dateacq;
	}

	public void setDateacq(Date dateacq) {
		this.dateacq = dateacq;
	}

}