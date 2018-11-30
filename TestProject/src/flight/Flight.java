package flight;

import java.util.Date;

/**
 *
 * @author Cailean
 */
public class Flight {

	protected int flightID;
    protected int departureTime;
    protected Date departureDate;
    protected String departureAirport;
    protected int arrivalTime;
    protected Date arrivalDate;
    protected String arrivalAirport;
    protected Airplane airplane;
    protected Flight_Price flightPrice;
   
    public Flight(int flightID, int departureTime, Date departureDate, String departureAirport, int arrivalTime, Date arrivalDate, 
		  		String arrivalAirport, Airplane airplane, Flight_Price flightPrice) {
    
    	this.flightID = flightID;
    	this.departureTime = departureTime;
    	this.departureDate = departureDate;
    	this.departureAirport = departureAirport;
    	this.arrivalTime = arrivalTime;
    	this.arrivalDate = arrivalDate;
    	this.arrivalAirport = arrivalAirport;
    	this.airplane = airplane;
    	this.flightPrice = flightPrice;
    	
    }

	public int getFlightID() {
		return flightID;
	}
	
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	
	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Flight_Price getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(Flight_Price flightPrice) {
		this.flightPrice = flightPrice;
	}
	
	@Override
	public String toString() {
		return "Flight [flightID=" + flightID + ", departureTime=" + departureTime + ", departureDate=" + departureDate
				+ ", departureAirport=" + departureAirport + ", arrivalTime=" + arrivalTime + ", arrivalDate="
				+ arrivalDate + ", arrivalAirport=" + arrivalAirport + ", \nairplane=" + airplane + ", \nflightPrice="
				+ flightPrice + "]";
	}
    
}
