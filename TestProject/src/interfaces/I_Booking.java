package interfaces;

import java.sql.SQLException;

import booking.*;
import flight.Flight;
import users.Customer;

public interface I_Booking {
	
	/**
	 * Create a new booking
	 * @param customer
	 * @param flight
	 * @param baggage
	 * @param type
	 * @return Booking
	 */
	public Booking makeBooking(Customer customer, Flight flight, int baggage, String type);
	
	/**
	 * Calculate the booking price
	 * @param flight
	 * @param type
	 * @param baggage
	 * @return price
	 */
	public float calculatePrice(Flight flight, String type, int baggage);
	
	/**
	 * Inserts a booking into the database
	 * @param booking
	 * @throws SQLException
	 * @throws Exception
	 */
	public void insertBooking(Booking booking) throws SQLException, Exception;
	
	/**
	 * If the user decide to have a discount this method update the price of the booking
	 * @param booking
	 * @param price
	 */
	public void changePrice(Booking booking, float price);

}
