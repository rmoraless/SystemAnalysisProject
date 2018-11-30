package booking;

public abstract class BookingDecorator extends BookingPrice implements Cloneable {
	
	private BookingPrice b;

	public BookingDecorator(BookingPrice b) { this.b = b; }

	public float cost() { return b.cost(); }
	
	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

}
