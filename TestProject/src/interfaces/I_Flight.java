package interfaces;

import java.util.ArrayList;

import flight.Flight;

public interface I_Flight {
	
	/**
	 * Returns the list of available flights
	 * @return ArrayList of Flights
	 * @throws Exception
	 */
	public ArrayList<Flight> getFlightList() throws Exception;
	
	/**
	 * Creates a flight getting the information from the database
	 * @param flightNumber
	 * @return Flight
	 * @throws Exception
	 */
	public Flight createFlight(int flightNumber) throws Exception;

	/**
	 * Checks the availability of seats of a selected class flight
	 * @param flight
	 * @param typeClass
	 * @return True if there is no seats available
	 */
	public boolean checkAvaliability(Flight flight, String typeClass);
	
	/**
	 * Decreases the current seats number of a selected class flight
	 * @param flight
	 * @param typeClass
	 */
	public void decreaseSeats(Flight flight, String typeClass) throws Exception;

}
