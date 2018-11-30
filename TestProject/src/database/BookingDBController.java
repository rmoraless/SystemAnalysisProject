package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import booking.Booking;

public class BookingDBController {
	
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;

	public void insertBooking(Booking booking) throws SQLException, Exception {

		DatabaseManager db;
		db = DatabaseManager.getInstance();
		db.connectDB();
		this.connect = db.returnConnection();

		preparedStatement = connect
				.prepareStatement("insert into abcs.flight_bookings values (?, ?, ?, ?, ?, ?)");

		preparedStatement.setInt(1, booking.getBookingID());
		preparedStatement.setInt(2, booking.getCustomer().getUserID());
		preparedStatement.setInt(3, booking.getFlight().getFlightID());
		preparedStatement.setString(4, booking.getClassType());
		preparedStatement.setInt(5, booking.getBaggage());
		preparedStatement.setFloat(6, booking.getPrice());
		preparedStatement.executeUpdate();

		db.close();
	}

}
