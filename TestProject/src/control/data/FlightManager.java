package control.data;

import java.util.ArrayList;

import flight.*;
import interfaces.I_Flight;
import database.FlightDBController;

public class FlightManager implements I_Flight {
	
	private ArrayList<Flight> flightList;
	
	@Override
	public ArrayList<Flight> getFlightList() throws Exception {
		
		FlightDBController db = new FlightDBController();
		flightList = db.getFlightList();
		
		return flightList;
	}
	
	@Override
	public Flight createFlight(int flightNumber) throws Exception {
		
		FlightDBController db = new FlightDBController();
		Flight flight = db.createFlight(flightNumber);
		
		return flight;
	}

	@Override
	public boolean checkAvaliability(Flight flight, String typeClass) {
		if(typeClass.equals("First Class"))
			return (flight.getAirplane().getCurrentFirstCapacity() == 0);
		
		else if(typeClass.equals("Business Class"))
			return (flight.getAirplane().getCurrentBusinessCapacity() == 0);	
		
		else if(typeClass.equals("Economic Class"))
			return (flight.getAirplane().getCurrentEconomicCapacity() == 0);
		
		return false;
	}

	@Override
	public void decreaseSeats(Flight flight, String typeClass) throws Exception {
		
		FlightDBController flightManager = new FlightDBController();
		
		if(typeClass.equals("First Class")) {
			flight.getAirplane().setCurrentFirstCapacity(flight.getAirplane().getCurrentFirstCapacity() - 1);
			try {
				flightManager.decreaseSeats(flight, typeClass);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(typeClass.equals("Business Class")){
			flight.getAirplane().setCurrentBusinessCapacity(flight.getAirplane().getCurrentBusinessCapacity() - 1);
			try {
				flightManager.decreaseSeats(flight, typeClass);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(typeClass.equals("Economic Class")) {
			flight.getAirplane().setCurrentEconomicCapacity(flight.getAirplane().getCurrentEconomicCapacity() - 1);
			try {
				flightManager.decreaseSeats(flight, typeClass);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
