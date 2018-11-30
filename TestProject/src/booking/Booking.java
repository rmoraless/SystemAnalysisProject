package booking;

import flight.Flight;
import users.Customer;

public class Booking extends BookingPrice {
	
	private int bookingID;
	private Customer customer;
	private Flight flight;
	private int baggage;
	private String classType;
	private float price;

	public Booking() {
		
	}
	
	public Booking(int bookingID, Customer customer, Flight flight, int baggage, String classType, float price) {
		
		this.bookingID = bookingID;
		this.customer = customer;
		this.flight = flight;
		this.baggage = baggage;
		this.classType = classType;
		this.price = price;
		
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getBaggage() {
		return baggage;
	}

	public void setBaggage(int baggage) {
		this.baggage = baggage;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", customer=" + customer.getUserID() + ", flight=" + flight.getFlightID() 
				+ ", baggage=" + baggage + ", classType=" + classType + ", price=" + price + "]";
	}

	/*
	 * Auxiliary method to initialize the decorator 
	 */
	@Override
	public float cost() {
		return 0;
	}

}
