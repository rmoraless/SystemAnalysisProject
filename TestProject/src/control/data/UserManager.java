package control.data;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import database.MembershipDBController;
import database.UserDBController;
import flight.Flight;
import interfaces.I_Flight;
import interfaces.I_User;
import membership.Membership;
import ui.UserMenu;
import users.Customer;
import users.User;

public class UserManager implements I_User {

	@Override
	public void createUser(String username, String password) throws SQLException, Exception {

		UserDBController u = new UserDBController();
		MembershipDBController m = new MembershipDBController();
		int roleID = u.getRole(username, password);

		if (roleID == 1) {
			Customer c1 = new Customer();
			u.createUser(c1, username, password);
			Membership membership = m.getMembership(c1);
			c1.createMembership(membership);
			
			UserMenu userMenu = new UserMenu(c1);
            userMenu.setVisible(true);
		}
	}

	@Override
	public void viewFlights() throws Exception {

		I_Flight flightManager = new FlightManager();
		String results = "";
		ArrayList<Flight> flightList = flightManager.getFlightList();

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
		
		// Results added together to see the scrollpane
		JTextArea textArea = new JTextArea(results);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setPreferredSize(new Dimension(400, 400));
		JOptionPane.showMessageDialog(null, scrollPane, "Flights", JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public String getUserDetails(User user) {
		return user.toString();
	}

}
