package booking;

import flight.Flight;

public class Price_baggage extends BookingDecorator {

	Flight flight;
	int quantity;

	public Price_baggage(Flight flight, BookingPrice p, int quantity) {
		super(p);
		this.flight = flight;
		this.quantity = quantity;
	}

	public float cost() {
		return super.cost() + (quantity*(flight.getFlightPrice().getBaggagePrice()));
	}

}

