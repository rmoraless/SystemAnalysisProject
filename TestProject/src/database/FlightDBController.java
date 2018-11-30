package database;

import java.awt.Dimension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import flight.*;

public class FlightDBController {

	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private int update;
	
	public FlightDBController() {
		
	}

	public void viewFlights() throws Exception {

		String results = "";
		ArrayList<Flight> flightList = getFlightList();

		for(int i = 0; i < flightList.size(); i++) {
			results += "\nFlight Number: ";
			results += flightList.get(i).getFlightID();
			results += "\n";
			results += "\nArrival Time: ";
			results += flightList.get(i).getArrivalTime();
			results += "\n";
			results += "\nArrival Date: ";
			results += flightList.get(i).getArrivalDate();
			results += "\n";
			results += "\nArrival Airport: ";
			results += flightList.get(i).getArrivalAirport();
			results += "\n";
			results += "\nDeparture Time: ";
			results += flightList.get(i).getDepartureTime();
			results += "\n";
			results += "\nDeparture Date: ";
			results += flightList.get(i).getDepartureDate();
			results += "\n";
			results += "\nDeparture Airport: ";
			results += flightList.get(i).getDepartureAirport();
			results += "\n";
			results += "\nAirplane ID: ";
			results += flightList.get(i).getAirplane().getAirplaneID();
			results += "\n\n--------------------------";
			results += "\n\n\n";
		};
		
		JTextArea textArea = new JTextArea(results);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setPreferredSize(new Dimension(400, 400));
		JOptionPane.showMessageDialog(null, scrollPane, "Flights", JOptionPane.INFORMATION_MESSAGE);
	}

	public ArrayList<Flight> getFlightList() throws Exception {

		DatabaseManager db;
		db = DatabaseManager.getInstance();
		db.connectDB();
		this.connect = db.returnConnection();

		int flightNumber = 0;
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		ArrayList<Integer> flightNum = new ArrayList<Integer>();

		preparedStatement = connect.prepareStatement("SELECT flight_number FROM abcs.flight;");
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			flightNumber = resultSet.getInt("flight_number");
			flightNum.add(flightNumber);
		}
		
		db.close();
		
		/*
		 * LAMBDA EXPRESSIONS
		 */
		flightNum.forEach(n -> {
			try {
				flightList.add(createFlight(n));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		return flightList;
	}

	public Flight createFlight(int flightNumber) throws Exception {

		DatabaseManager db;
		db = DatabaseManager.getInstance();
		db.connectDB();
		this.connect = db.returnConnection();
		
		int flightID = 0;
		int arrivalTime = 0;
		Date arrivalDate = null;
		String arrivalAirport = "";
		int departureTime = 0;
		Date departureDate = null;
		String departureAirport = "";
		int airplaneID = 0;

		preparedStatement = connect.prepareStatement("SELECT * FROM abcs.flight WHERE flight_number = ?;");
		preparedStatement.setInt(1, flightNumber);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			flightID = resultSet.getInt("flight_number");
			arrivalTime = resultSet.getInt("arrival_time");
			arrivalDate = resultSet.getDate("arrival_date");
			arrivalAirport = resultSet.getString("arrival_airport");
			departureTime = resultSet.getInt("departure_time");
			departureDate = resultSet.getDate("departure_date");
			departureAirport = resultSet.getString("departure_airport");
			airplaneID = resultSet.getInt("airplane_id");
		}

		db.close();
		
		Airplane airplane = createAirplane(airplaneID);
		Flight_Price flightPrice = createPrice(flightID);

		Flight f = new Flight(flightID, departureTime, departureDate, departureAirport, arrivalTime, 
				arrivalDate, arrivalAirport, airplane, flightPrice);
		
		System.out.println(f.toString());
		
		return f;

	}
	
	public Airplane createAirplane(int airplaneNumber) throws Exception {
		
		DatabaseManager db;
		db = DatabaseManager.getInstance();
		db.connectDB();
		this.connect = db.returnConnection();
		
		int firstCapacity = 0;
		int businessCapacity = 0;
		int economicCapacity = 0;
		int baggage = 0;
		int currentFirst = 0;
		int currentBusiness = 0;
		int currentEconomic = 0;

		preparedStatement = connect.prepareStatement("SELECT * FROM abcs.airplane WHERE airplane_id = ?;");
		preparedStatement.setInt(1, airplaneNumber);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			firstCapacity = resultSet.getInt("first_capacity");
			businessCapacity = resultSet.getInt("business_capacity");
			economicCapacity = resultSet.getInt("economy_capacity");
			baggage = resultSet.getInt("baggage");
			currentFirst = resultSet.getInt("current_first");
			currentBusiness = resultSet.getInt("current_business");
			currentEconomic = resultSet.getInt("current_economic");
		}
		
		db.close();
		
		Airplane a = new Airplane(airplaneNumber, firstCapacity, businessCapacity, economicCapacity, baggage);
		a.setCurrentFirstCapacity(currentFirst);
		a.setCurrentBusinessCapacity(currentBusiness);
		a.setCurrentEconomicCapacity(currentEconomic);
		
		return a;
	}
	
	public Flight_Price createPrice(int flightNumber) throws Exception {
		
		DatabaseManager db;
		db = DatabaseManager.getInstance();
		db.connectDB();
		this.connect = db.returnConnection();
		
		float firstPrice = 0;
		float businessPrice = 0;
		float economicPrice = 0;
		float baggagePrice = 0;

		preparedStatement = connect.prepareStatement("SELECT * FROM abcs.flight_price WHERE flight_number = ?;");
		preparedStatement.setInt(1, flightNumber);
		resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			firstPrice = resultSet.getFloat("first_price");
			businessPrice = resultSet.getFloat("business_price");
			economicPrice = resultSet.getFloat("economy_price");
			baggagePrice = resultSet.getFloat("baggage_price");
		}
		
		db.close();
		
		Flight_Price p = new Flight_Price(flightNumber, firstPrice, businessPrice, economicPrice, baggagePrice);
		
		return p;
	}
	
	public void decreaseSeats(Flight flight, String classType) throws Exception {
		
		DatabaseManager db;
		db = DatabaseManager.getInstance();
		db.connectDB();
		this.connect = db.returnConnection();

		if(classType.equals("First Class")) {
			preparedStatement = connect
					.prepareStatement("UPDATE abcs.airplane SET current_first = ? WHERE airplane_id = ?;");
			preparedStatement.setInt(1, flight.getAirplane().getCurrentFirstCapacity());
			preparedStatement.setInt(2, flight.getAirplane().getAirplaneID());
			update = preparedStatement.executeUpdate();
		}
		
		else if(classType.equals("Business Class")) {
			preparedStatement = connect
					.prepareStatement("UPDATE abcs.airplane SET current_business = ? WHERE airplane_id = ?;");
			preparedStatement.setInt(1, flight.getAirplane().getCurrentBusinessCapacity());
			preparedStatement.setInt(2, flight.getAirplane().getAirplaneID());
			update = preparedStatement.executeUpdate();
		}
		
		else if(classType.equals("Economic Class")) {
			preparedStatement = connect
					.prepareStatement("UPDATE abcs.airplane SET current_economic = ? WHERE airplane_id = ?;");
			preparedStatement.setInt(1, flight.getAirplane().getCurrentEconomicCapacity());
			preparedStatement.setInt(2, flight.getAirplane().getAirplaneID());
			update = preparedStatement.executeUpdate();
		}

		db.close();
	}

}
