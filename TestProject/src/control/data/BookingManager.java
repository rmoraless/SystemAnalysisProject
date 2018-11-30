package control.data;

import java.sql.SQLException;

import booking.*;
import database.BookingDBController;
import flight.Flight;
import interfaces.I_Booking;
import users.Customer;

public class BookingManager implements I_Booking {
	
	@Override
	public Booking makeBooking(Customer customer, Flight flight, int baggage, String type) {
		
		int bookingID = (int)(Math.random()*100);

		Booking booking = new Booking(bookingID, customer, flight, baggage, type, calculatePrice(flight, type, baggage));
		
		System.out.println(booking.toString());
		return booking;
	}
	
	@Override
	public float calculatePrice(Flight flight, String type, int baggage) {
		
		BookingPrice price = new Booking();
		
		Prototype.getDecorator(flight, price);
	    BookingDecorator clonedDecorator = (BookingDecorator) Prototype.getCost(type);

	    price = clonedDecorator;
	    
		if(baggage > 0)
			price = new Price_baggage(flight, price, baggage);
	    
		return price.cost();
	
	}
	
	@Override
	public void insertBooking(Booking booking) throws SQLException, Exception {
		BookingDBController db = new BookingDBController();
		db.insertBooking(booking);
	}

	@Override
	public void changePrice(Booking booking, float price) {
		booking.setPrice(price);
	}

}
