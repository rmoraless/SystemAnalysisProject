package booking;

import flight.Flight;

public class Price_first extends BookingDecorator {
	
	Flight flight;

	public Price_first(Flight flight, BookingPrice p) {
		super(p);
		this.flight = flight;
	}

	public float cost() {
		return super.cost() + flight.getFlightPrice().getFirstPrice();
	}

}
