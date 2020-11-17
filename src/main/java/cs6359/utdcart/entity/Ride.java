package cs6359.utdcart.entity;

import java.util.List;

public class Ride {

	private int id;
	private Driver driver;
	private String pickupLocation;
	private String destination;
	private float cost;
	private List <Customer> customers;
	private String type;

	public Ride() {
		// TODO Auto-generated constructor stub
	}

}
