package booking;

import java.util.HashMap;
import java.util.Map;

import flight.Flight;

public class Prototype {
	
	private static Map<String, BookingDecorator> decoratorMap = new HashMap<String, BookingDecorator>();
	
	public static BookingDecorator getCost(String classType) {
		BookingDecorator prototype =  decoratorMap.get(classType);
		return (BookingDecorator) prototype.clone();
	}
	
	public static void getDecorator(Flight flight, BookingPrice price) {
		Price_first first = new Price_first(flight, price);
	    decoratorMap.put("First Class", first);
	    
	    Price_business business = new Price_business(flight, price);
	    decoratorMap.put("Business Class", business);
	    
	    Price_economic economic = new Price_economic(flight, price);
	    decoratorMap.put("Economic Class", economic);
	    
	}

}

