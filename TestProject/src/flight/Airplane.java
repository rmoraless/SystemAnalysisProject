package flight;

/**
 *
 * @author Cailean
 */
public class Airplane {

    protected int airplaneID;
	protected int firstCapacity[] = new int[2];
	protected int businessCapacity[] = new int[2];
	protected int economicCapacity[] = new int[2];
	protected int baggage;

	public Airplane(int airplaneID, int firstCapacity, int businessCapacity, int economicCapacity, int baggage) {
		this.airplaneID = airplaneID;
		this.firstCapacity[0] = firstCapacity;
		this.businessCapacity[0] = businessCapacity;
		this.economicCapacity[0] = economicCapacity;
		this.firstCapacity[1] = firstCapacity;
		this.businessCapacity[1] = businessCapacity;
		this.economicCapacity[1] = economicCapacity;
		this.baggage = baggage;
	}

	public int getAirplaneID() {
		return airplaneID;
	}

	public void setAirplaneID(int airplaneID) {
		this.airplaneID = airplaneID;
	}

	public int getFirstCapacity() {
		return firstCapacity[0];
	}

	public void setFirstCapacity(int firstCapacity) {
		this.firstCapacity[0] = firstCapacity;
	}
	
	public int getCurrentFirstCapacity() {
		return firstCapacity[1];
	}

	public void setCurrentFirstCapacity(int firstCapacity) {
		this.firstCapacity[1] = firstCapacity;
	}

	public int getBusinessCapacity() {
		return businessCapacity[0];
	}

	public void setBusinessCapacity(int businessCapacity) {
		this.businessCapacity[0] = businessCapacity;
	}
	
	public int getCurrentBusinessCapacity() {
		return businessCapacity[1];
	}

	public void setCurrentBusinessCapacity(int businessCapacity) {
		this.businessCapacity[1] = businessCapacity;
	}

	public int getEconomicCapacity() {
		return economicCapacity[0];
	}

	public void setEconomicCapacity(int economicCapacity) {
		this.economicCapacity[0] = economicCapacity;
	}
	
	public int getCurrentEconomicCapacity() {
		return economicCapacity[1];
	}

	public void setCurrentEconomicCapacity(int economicCapacity) {
		this.economicCapacity[1] = economicCapacity;
	}
	
	public int getBaggage() {
		return baggage;
	}

	public void setBaggage(int baggage) {
		this.baggage = baggage;
	}

	@Override
	public String toString() {
		return "Airplane [airplaneID=" + airplaneID + ", firstCapacity=" + firstCapacity[0] + "currentFirstCapacity=" + firstCapacity[1] + 
				", businessCapacity=" + businessCapacity[0] +  ", currentBusinessCapacity=" + businessCapacity[1] +
				", economicCapacity=" + economicCapacity[0] + ", currentEconomicCapacity=" + economicCapacity[1] + ", baggage=" + baggage + "]";
	}

}
