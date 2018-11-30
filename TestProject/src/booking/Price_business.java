package booking;

import flight.Flight;

public class Price_business extends BookingDecorator {

	Flight flight;

	public Price_business(Flight flight, BookingPrice p) {
		super(p);
		this.flight = flight;
	}

	public float cost() {
		return super.cost() + flight.getFlightPrice().getBusinessPrice();
	}

}
