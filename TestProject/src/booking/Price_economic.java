package booking;

import flight.Flight;

public class Price_economic extends BookingDecorator {

	Flight flight;

	public Price_economic(Flight flight, BookingPrice p) {
		super(p);
		this.flight = flight;
	}

	public float cost() {
		return super.cost() + flight.getFlightPrice().getEconomicPrice();
	}

}
