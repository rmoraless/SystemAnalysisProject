package flight;

/**
 *
 * @author Cailean
 */
public class Flight_Price {

	private int flightID;
	private float firstPrice;
	private float businessPrice;
	private float economicPrice;
	private float baggagePrice;

	public Flight_Price(int flightID, float firstPrice, float businessPrice, float economicPrice, float baggagePrice) {
		
		this.flightID = flightID;
		this.firstPrice = firstPrice;
		this.businessPrice = businessPrice;
		this.economicPrice = economicPrice;
		this.baggagePrice = baggagePrice;
		
	}

	public int getFlight() {
		return flightID;
	}

	public void setFlight(int flight) {
		this.flightID = flight;
	}

	public float getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(float firstPrice) {
		this.firstPrice = firstPrice;
	}

	public float getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(float businessPrice) {
		this.businessPrice = businessPrice;
	}

	public float getEconomicPrice() {
		return economicPrice;
	}

	public void setEconomicPrice(float economicPrice) {
		this.economicPrice = economicPrice;
	}

	public float getBaggagePrice() {
		return baggagePrice;
	}

	public void setBaggagePrice(float baggagePrice) {
		this.baggagePrice = baggagePrice;
	}

	@Override
	public String toString() {
		return "FlightPrice [flightID=" + flightID + ", firstPrice=" + firstPrice + ", businessPrice=" + businessPrice
				+ ", economicPrice=" + economicPrice + ", baggagePrice=" + baggagePrice + "]";
	}
	
}
